package kz.arta.ext.z3950.service;

import info.freelibrary.marc4j.converter.impl.Iso5426ToUnicode;
import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.z3950.convert.UnimarcConverter;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.util.CodeConstants;
import org.apache.logging.log4j.Logger;
import org.marc4j.MarcStreamWriter;
import org.marc4j.MarcWriter;
import org.marc4j.marc.Record;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by timur on 8/26/2014 12:39 PM.
 */
@Stateless
public class ExporterForIndexer {
    @Inject
    private Logger log;

    @Inject
    private LibraryBookReader reader;

    /**
     * Сохраняет все для индексации
     *
     * @param registryFormUUID
     * @return
     */
    public boolean exportRegistry(String registryFormUUID) {

        try {
            String[] dataUUIDs = reader.getDataUUID(registryFormUUID, ConfigUtils.getQueryContext());
            for (String dataUUID : dataUUIDs) {
                export(dataUUID);
                log.info("export to UNIMARC recird {}", dataUUID);
            }
        } catch (Exception e) {
            log.error(e);
            return false;
        }
        return true;
    }


    /**
     * Сохраняет запись в  в файл для индексации
     *
     * @param dataUUID
     * @return
     */
    public boolean export(String dataUUID) {
        try {
            FormData formData = reader.readFormData(ConfigUtils.getQueryContext(), dataUUID);
            OutputStream stream = null;
            try {
                stream = new FileOutputStream(getPath("../indexdata/" + dataUUID));
                MarcWriter writer = new MarcStreamWriter(stream, CodeConstants.ENCODING_UFT_8);
//                writer.setConverter(new Iso5426ToUnicode());
                Record record = getRecord(formData);
                writer.write(record);
            } catch (Exception e) {
                log.error(e);
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }
            return true;
        } catch (java.io.IOException e) {
            log.error(e);
            return false;
        }
    }

    public Record getRecord(FormData formData) {
        UnimarcConverter converter = new UnimarcConverter();
        return converter.getMarcRecord(formData.convertToWrapper());
    }

    protected String getPath(String dataUUID) {
        return dataUUID;
    }

}
