package kz.arta.ext.ocr.recognizer;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.ocr.model.RecognizeTask;
import kz.arta.ext.ocr.service.RecognizeTaskRepository;
import kz.arta.ext.ocr.service.UploadService;
import org.slf4j.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.io.File;
import java.sql.Date;

/**
 * Класс - менеджер распознования PDF-документов
 */
@Singleton
@Startup
public class RecognizeManager {

    public static final String OCR_TEMP_DIR = "ocr.temp.dir";
    public static final String OCR_DIR_INPUT_KEY = "ocr.dir.input";
    public static final String OCR_DIR_WORK_KEY = "ocr.dir.work";
    public static final String OCR_DIR_OUTPUT_KEY = "ocr.dir.output";

    public static final String OCR_NOT_WORK_SLEEP_SEC_KEY = "ocr.not.work.sleep.sec";

    @Inject
    private Logger log;

    @Inject
    private RecognizeTaskRepository repository;

    @Inject
    private UploadService uploadService;

    private String inputDirPath;
    private String workDirPath;
    private String outDirPath;
    private long sleepTime;

    @Resource
    private TimerService timerService;

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct invoked. Setting up timer...");
        timerService.createSingleActionTimer(2000, new TimerConfig("start recognize manager", false));
    }

    private boolean isShutdown = false;

    @PreDestroy
    public void terminate() {
        isShutdown = true;
    }

    @Timeout
    public void execute() {
        try {
            log.info("RecognizeManager bean initialization starting.");
            if (!init()) {
                log.info("RecognizeManager bean initialization failed.");
                return;
            }
            log.info("RecognizeManager bean initialization success.");

            File inputDir = new File(inputDirPath);
            File workDir = new File(workDirPath);
            File outDir = new File(outDirPath);

            while (true) {
                if(isShutdown)
                    break;
                RecognizeTask task = repository.getNotCopmleteTask();
                while (task != null) {
                    try {
                        log.info("start recognizing file '" + task.getFilePath() + "'...");
                        setTaskStarted(task);

                        Recognizer recognizer = new Recognizer(inputDir, workDir, outDir, task);

                        log.info("coping file start");
                        recognizer.copySourceFileToWorkDir();
                        log.info("coping file finished successfull");

                        log.info("converting source to tiff");
                        recognizer.convertToTiff();
                        log.info("converting source to tiff finished");

                        log.info("recognize tiff to pdf");
                        recognizer.execTesseract();
                        log.info("recognize tiff to pdf finished success");

                        log.info("concat pdf");
                        recognizer.execConcatFiles();
                        log.info("concat pdf finished success");

                        log.info("result file is '" + recognizer.getResultFile().getAbsolutePath() + "'");
                        setTaskFinished(task, recognizer.getResultFile().getAbsolutePath());

                    } catch (Exception e) {
                        setTaskError(task, e.getMessage());
                        log.error("Error during recognize file '" + task.getFilePath() + "'", e);
                    } finally {
                        log.info("finished recognizing file '" + task.getFilePath() + "'");
                    }

                    task = repository.getNotCopmleteTask();
                }
                try {
                    Thread.sleep(sleepTime * 1000);
                } catch (InterruptedException e) {
                    log.error("Thread.sleep() error", e);
                }
            }
        } finally {
            log.info("RecognizeManager bean finished");
        }
    }

    private void setTaskStarted(RecognizeTask task) {
        task.setDateStart(new Date(System.currentTimeMillis()));
        task.setStarted(true);
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
        inputDirPath = checkDirectory(OCR_DIR_INPUT_KEY);
        if (inputDirPath == null)
            return false;

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
