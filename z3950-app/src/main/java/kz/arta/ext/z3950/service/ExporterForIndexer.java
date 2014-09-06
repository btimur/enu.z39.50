package kz.arta.ext.z3950.service;

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
     * Сохраняет запись в  в файл для индексации
     * @param dataUUID
     * @return
     */
    public boolean export(String dataUUID){
        try {
            FormData formData = reader.readFormData(ConfigUtils.getQueryContext(), dataUUID);
            OutputStream stream = null;
            try {
                stream = new FileOutputStream(getPath(dataUUID));
                MarcWriter writer = new MarcStreamWriter(stream, CodeConstants.ENCODING_UFT8);
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
