package kz.arta.ext.ocr.recognizer;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.ocr.model.RecognizeTask;
import kz.arta.ext.ocr.service.RecognizeTaskRepository;
import kz.arta.ext.ocr.service.UploadService;
import org.slf4j.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.File;
import java.sql.Date;

/**
 * Класс - менеджер распознования PDF-документов
 */
@Singleton
@Startup
public class RecognizeManager {

    public static final String OCR_DIR_WORK_KEY = "ocr.dir.work";
    public static final String OCR_DIR_OUTPUT_KEY = "ocr.dir.output";

    public static final String OCR_NOT_WORK_SLEEP_SEC_KEY = "ocr.not.work.sleep.sec";

    @Inject
    private Logger log;

    @Inject
    private RecognizeTaskRepository repository;

    @Inject
    private UploadService uploadService;


    private String workDirPath;
    private String outDirPath;
    private long sleepTime;

    @Schedule(second = "0", minute = "*", hour = "*")
    public void execute() {
        if (!init())
            return;

        File workDir = new File(workDirPath);
        File outDir = new File(outDirPath);

        while (true) {
            RecognizeTask task = repository.getNotCopmleteTask();
            while (task != null) {
                setTaskStarted(task);
                Recognizer recognizer = new Recognizer(workDir, outDir, task);
                if (recognizer.copySourceFileToWorkDir()) {
                    log.info("converting source to tiff");
                    if (recognizer.convertToTiff()) {
                        log.info("converting source to tiff finished");
                        log.info("recognize tiff to pdf");
                        if (recognizer.execTesseract()) {
                            log.info("recognize tiff to pdf finished with result - " + recognizer.isCompliteSuccess());
                            if (recognizer.isCompliteSuccess()) {
                                setTaskFinished(task, recognizer.getResultFile().getAbsolutePath());
                            }
                        }
                    }
                }

                if (!recognizer.isCompliteSuccess()) {
                    setTaskError(task, "error");
                }

                task = repository.getNotCopmleteTask();
            }
            try {
                Thread.sleep(sleepTime * 1000);
            } catch (InterruptedException e) {
                log.error("Thread.sleep() error", e);
            }
        }

    }

    private void setTaskStarted(RecognizeTask task) {
        task.setDateStart(new Date(System.currentTimeMillis()));
        task.setDateEnd(null);
        task.setError(null);
        repository.update(task);
    }

    private void setTaskError(RecognizeTask task, String errorMessage) {
        task.setDateEnd(new Date(System.currentTimeMillis()));
        task.setError(errorMessage);
        task.setCompleted(true);
        repository.update(task);
    }

    private void setTaskFinished(RecognizeTask task, String resultFilepath) {
        task.setDateEnd(new Date(System.currentTimeMillis()));
        task.setError(null);
        task.setCompleted(true);
        task.setFileEnd(resultFilepath);
        repository.update(task);
        uploadService.uploadToServer(task);
    }

    private boolean init() {
        log.info("Initialization starting.");
        workDirPath = checkDirectory(OCR_DIR_WORK_KEY);
        if (workDirPath == null)
            return false;

        outDirPath = checkDirectory(OCR_DIR_OUTPUT_KEY);
        if (outDirPath == null)
            return false;

        String sleepTimeStr = ConfigReader.getPropertyValue(OCR_NOT_WORK_SLEEP_SEC_KEY);
        if (sleepTimeStr == null) {
            log.error("parameter '" + OCR_NOT_WORK_SLEEP_SEC_KEY + "' not set. Please set it!");
            return false;
        }

        try {
            sleepTime = Long.valueOf(sleepTimeStr);
        } catch (NumberFormatException e) {
            log.error("parameter '" + OCR_NOT_WORK_SLEEP_SEC_KEY + "' must be LONG type. Please correct it!");
            return false;
        }

        log.info("Initialization success.");
        return true;
    }

    private String checkDirectory(String paratemerKey) {
        String dirPath = ConfigReader.getPropertyValue(paratemerKey);
        if (dirPath == null) {
            log.error("parameter '" + OCR_DIR_WORK_KEY + "' not set. Please, set it!");
            return null;
        }

        File dir = new File(dirPath);
        if (!(dir.exists() && dir.isDirectory())) {
            log.warn("ocr working directory '" + dirPath + "' not exist.");
            if (!new File(dirPath).mkdirs()) {
                log.error("Can't create ocr working directory '" + dirPath + "'.");
                return null;
            }
        }

        return dirPath;
    }
}
