package kz.arta.ext.ocr.service;

import kz.arta.ext.ocr.model.RecognizeTask;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * Created by timur on 9/25/14.
 */
public class RecognizeService {
    @Inject
   private Logger logger;

    @Inject
    private RecognizeTaskRepository repository;

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
