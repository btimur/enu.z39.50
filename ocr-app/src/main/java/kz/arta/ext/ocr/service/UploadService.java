package kz.arta.ext.ocr.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.rest.FileReader;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.ocr.model.RecognizeTask;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by timur on 9/26/14.
 * сервис загрузки на Synergy
 */
@Stateless
public class UploadService {

    private static final int BATCH_SIZE = 1024*200;
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger logger;
    @Inject
    private FileReader fileReader;

    public boolean uploadToServer(RecognizeTask task) {

        String filePath = task.getFileEnd();
        if (StringUtils.isNullOrEmpty(filePath)) {
            logger.error("error upload because recognise file is null");
            return false;
        }
        String tmpFilePath = fileReader.startUploadFile(ConfigUtils.getQueryContext());
        if (StringUtils.isNullOrEmpty(filePath)) {
            logger.error("error on server create tempFile");
            return false;
        }
        boolean b = upload(filePath, tmpFilePath) &&
                fileReader.createAttachment(ConfigUtils.getQueryContext(),
                        task.getDataUUID(), task.getBookName() + ".txt", tmpFilePath);
        task.setUploaded(b);
        return b;

    }

    private boolean upload(String filePath, String tmFile) {
        boolean result = false;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new java.io.FileReader(filePath));
            String line;
            StringBuilder buffer = new StringBuilder();
            boolean upload = true;
            while ((line = reader.readLine()) != null && upload) {
                buffer.append(line);
                if (buffer.length() > BATCH_SIZE) {
                    upload = upload && fileReader.uploadPart(ConfigUtils.getQueryContext(), tmFile, buffer.toString());
                    buffer.setLength(0);
                }
            }
            if (buffer.length() > 0) {
                upload = upload && fileReader.uploadPart(ConfigUtils.getQueryContext(), tmFile, buffer.toString());
            }
            result = upload;
        } catch (FileNotFoundException e) {
            logger.error("can't find file = {}", filePath);
        } catch (IOException e) {
            logger.error("error read file = {}", filePath);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                logger.error("error close reader", e);
            }
        }
        return result;
    }
}
