package kz.arta.ext.ocr.recognizer;

import kz.arta.ext.common.service.ExternalLauncher;
import kz.arta.ext.ocr.model.RecognizeTask;
import kz.arta.ext.ocr.util.RandomGUID;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.*;
import java.util.*;

/**
 * Created by Администратор on 27.09.2014.
 * работа с tesseract
 */
public class Recognizer3 {

    private File workDir;
    private File outputDir;

    private File tempWorkDir;

    private RecognizeTask task;

    @Inject
    private ExternalLauncher launcher;

    @Inject
    private Logger log;


    public RecognizeTask getTask() {
        return task;
    }

    public void setTask(RecognizeTask task) {
        this.task = task;
    }

    public File getWorkDir() {
        return workDir;
    }

    public void setWorkDir(File workDir) {
        this.workDir = workDir;
    }

    public File getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(File outputDir) {
        this.outputDir = outputDir;
    }

    public void copySourceFileToWorkDir() throws Exception {
        try {
            File fSourceDir = new File(task.getFilePath());
            tempWorkDir = new File(workDir, task.getDocId());
            FileUtils.deleteDirectory(tempWorkDir);
            FileUtils.copyDirectory(fSourceDir, tempWorkDir);

            File imagesDir = new File(tempWorkDir, "images");
            imagesDir.mkdir();
        } catch (IOException e) {
            log.error("error copy source to work for task {} ", task.getDocId());
            throw new Exception("Error during copy to work directory", e);
        }
    }

    public void convertToTiff() throws Exception{
        int index = 1;
        File[] files = tempWorkDir.listFiles();
        Arrays.sort(files);
        for(File file: files) {
            if(file.getName().toLowerCase().endsWith(".pdf")) {
                launcher.launchSh(tempWorkDir.getPath(),
                        "sh", "../work1_extract.sh",
                                    file.getPath(), String.format("%05d", index++));
            }
        }
    }

    private List<File> fileList = new ArrayList<File>();

    public void execTesseract() throws Exception {
        launcher.launchSh(tempWorkDir.getPath(),
                "sh", "../work2_recognize.sh");
    }

    private File resultFile;

    public void execConcatFiles() throws Exception {
        File concatFile = new File(tempWorkDir, (new RandomGUID()).toString() + "_res.pdf");
        launcher.launchSh(tempWorkDir.getPath(),
                "sh","../execConcatFiles.sh", concatFile.getPath());
        if(!concatFile.exists())
            throw new Exception("Error during concating documents");

        resultFile = new File(outputDir, task.getDocId() + ".pdf");
        if(resultFile.exists())
            resultFile.delete();
        FileUtils.moveFile(concatFile, resultFile);
        try {
            FileUtils.deleteDirectory(tempWorkDir);
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
    }

    public File getResultFile() {
        return resultFile;
    }

}
