package kz.arta.ext.z3950.service;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.z3950.convert.UnimarcConverter;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.util.CodeConstants;
import org.marc4j.MarcStreamWriter;
import org.marc4j.MarcWriter;
import org.marc4j.marc.Record;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by timur on 8/26/2014 12:39 PM.
 * Экспортер записей в MARC  для последующей индексации Zebra
 */
@Stateless
public class ExporterForIndexer {
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger log;

    @Inject
    private LibraryBookReader reader;

    @Inject
    private ExternalLauncher launcher;

    /**
     * Сохраняет все для индексации
     *
     * @param registryFormUUID registryID экспортируемого реестра
     * @return  успех операции
     */
    public boolean exportRegistry(String registryFormUUID) {

        try {
            String[] dataUUIDs = reader.getDataUUID(registryFormUUID, ConfigUtils.getQueryContext());
            for (String dataUUID : dataUUIDs) {
                export(dataUUID, false);
                log.info("export to UNIMARC record {}", dataUUID);
            }
        } catch (Exception e) {
            log.error("error export registry " + registryFormUUID, e);
            return false;
        }
        return true;
    }


    /**
     * Сохраняет запись в  в файл для индексации
     * @param dataUUID   идентификатор записи
     * @param updateIndex запускать обновление индекса Zebra
     * @return  успех операции
     */
    public boolean export(String dataUUID, boolean updateIndex) {
        boolean result = false;
        OutputStream stream = null;
        try {
            log.debug("start export book dataUUID -  {}", dataUUID);
            stream = new FileOutputStream(getPath(dataUUID));
            MarcWriter writer = new MarcStreamWriter(stream, kz.arta.ext.common.util.CodeConstants.ENCODING_UFT_8);
//                writer.setConverter(new Iso5426ToUnicode());
            Record record = getRecord(loadFormData(dataUUID));
            writer.write(record);
            result = !updateIndex || updateIndex(dataUUID);
            log.info("end export book dataUUID -  {}", dataUUID);
        } catch (Exception e) {
            log.error("error export book dataUUID -  " + dataUUID, e);
        } finally {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    log.error("error close stream", e);
                }
            }
        }
        return result;

    }

    private boolean updateIndex(String dataUUID) {
          try {
               return launcher.launchSh(ConfigReader.getPropertyValue(CodeConstants.ZEBRA_PATH),
                       "sh", "updateBook.sh", dataUUID);
          }catch (Exception e){
              log.error("Problem update index", e);
          }
        return false;
    }

    public boolean deleteIndex(String dataUUID) {
        try {
            return launcher.launchSh(ConfigReader.getPropertyValue(CodeConstants.ZEBRA_PATH),
                    "sh", "deleteBook.sh", dataUUID);
        }catch (Exception e){
            log.error("Problem delete index", e);
        }
        return false;
    }

    private FormData loadFormData(String dataUUID) {
        return reader.readFormData(ConfigUtils.getQueryContext(), dataUUID);
    }

    public Record getRecord(FormData formData) {
        UnimarcConverter converter = new UnimarcConverter();
        return converter.getMarcRecord(formData.convertToWrapper());
    }

    /**
     * определяет путь куда экспортируются записи
     * @param dataUUID идентификатор записи
     * @return  путь
     */
    protected String getPath(String dataUUID) {
        return ConfigReader.getPropertyValue(CodeConstants.ZEBRA_DATA_PATH) + "/" + dataUUID;
    }

}
