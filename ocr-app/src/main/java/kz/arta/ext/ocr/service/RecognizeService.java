package kz.arta.ext.ocr.service;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.ocr.model.RecognizeTask;
import kz.arta.ext.ocr.recognizer.RecognizeManager;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by timur on 9/25/14.
 */
public class RecognizeService {
    @Inject
   private Logger logger;

    @Inject
    private RecognizeTaskRepository repository;

    public boolean startTask(String documentID, String dataUUID, String filename) {
        RecognizeTask task = new RecognizeTask();
        task.setDataUUID(dataUUID);
        task.setDateAdd(new Timestamp(new Date().getTime()));
        task.setDocId(documentID);
        task.setBookName(filename);
        task.setFilePath(ConfigReader.getPropertyValue(RecognizeManager.OCR_TEMP_DIR) +"//" + documentID);
        return startTask(task);
    }
    public boolean startTask(RecognizeTask task) {
        try {
            repository.save(task);
            saveFileToParseDir(task);
            startExecuteTask(task);
            return true;
        } catch (Exception e) {
            logger.error("error save new Task");
            return false;
        }
    }

    private void startExecuteTask(RecognizeTask task) {

    }

    private void saveFileToParseDir(RecognizeTask task) {

    }
}
