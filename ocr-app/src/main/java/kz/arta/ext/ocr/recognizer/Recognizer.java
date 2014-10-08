package kz.arta.ext.ocr.recognizer;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.common.service.ExternalLauncher;
import kz.arta.ext.ocr.model.RecognizeTask;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Администратор on 27.09.2014.
 * работа с tesseract
 */
public class Recognizer {

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
            FileUtils.copyDirectory(fSourceDir, tempWorkDir);
        } catch (IOException e) {
            log.error("error copy source to work for task {} ", task.getDocId());
            throw new Exception("Error during copy to work directory", e);
        }
    }

    public void convertToTiff() throws Exception{
        File[] files = tempWorkDir.listFiles();
        for(File file: files != null ? files : new File[0]) {
            if(file.getName().toLowerCase().endsWith(".pdf")) {
                String fname = file.getName();
                File fTiffSource = new File(tempWorkDir, fname.substring(0, fname.length() - 4) + ".tiff");
                launcher.launchSh(ConfigReader.getPropertyValue(RecognizeManager.OCR_DIR_WORK_KEY),
                        "sh", "convertToTiff.sh",
                        fTiffSource.getPath(), file.getPath());
                if(!fTiffSource.exists())
                    throw new Exception("Error converting file to tiff image format");
            }
        }
    }

    private List<File> fileList = new ArrayList<File>();

    public void execTesseract() throws Exception {
        File[] files = tempWorkDir.listFiles();
        for(File file: files != null ? files : new File[0]) {
            if(file.getName().toLowerCase().endsWith(".tiff")) {
                String fname = file.getName();
                File fDestination = new File(tempWorkDir, fname.substring(0, fname.length() - 5) + ".res");
                launcher.launchSh(ConfigReader.getPropertyValue(RecognizeManager.OCR_DIR_WORK_KEY),
                        "sh", "execTesseract.sh",
                        file.getPath(), fDestination.getPath());
                fDestination = new File(tempWorkDir, fname.substring(0, fname.length() - 5) + ".res.pdf");

                if(fDestination.exists()) {
                    fileList.add(fDestination);
                } else
                    throw new Exception("Error during recognize document with tesseract");
            }
        }
    }

    private File resultFile;

    public void execConcatFiles() throws Exception {
        File concatFile;
        if (fileList.size() > 1) {
            Collections.sort(fileList, new Comparator<File>() {
                @Override
                public int compare(File o1, File o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            concatFile = new File(tempWorkDir, task.getDocId() + ".pdf");
            StringBuilder buff = new StringBuilder();
            for(File file: fileList) {
                buff.append(" ").append(file.getAbsolutePath());
            }
            log.info("result - {}", buff.toString());
            launcher.launchSh(ConfigReader.getPropertyValue(RecognizeManager.OCR_DIR_WORK_KEY),
                    "sh","execConcatFiles.sh", concatFile.getPath(), buff.toString());
            if(!concatFile.exists())
                throw new Exception("Error during concating documents");
        } else {
            concatFile = fileList.get(0);
        }

        resultFile = new File(outputDir, task.getDocId() + ".pdf");
        FileUtils.moveFile(concatFile, resultFile);
    }

    public File getResultFile() {
        return resultFile;
    }

}
