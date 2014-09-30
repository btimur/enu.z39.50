package kz.arta.ext.ocr.recognizer;

import kz.arta.ext.ocr.model.RecognizeTask;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Администратор on 27.09.2014.
 */
public class Recognizer {

    private File inputDir;
    private File workDir;
    private File outputDir;

    private RecognizeTask task;

    public Recognizer(File inputDir, File workDir, File outputDir, RecognizeTask task) {
        this.inputDir = inputDir;
        this.workDir = workDir;
        this.outputDir = outputDir;
        this.task = task;
    }

    private File tempWorkDir;

    public void copySourceFileToWorkDir() throws Exception {
        try {
            File fSourceDir = new File(inputDir, task.getDocId());
            tempWorkDir = new File(workDir, task.getDocId());
            FileUtils.copyDirectory(fSourceDir, tempWorkDir);
        } catch (IOException e) {
            throw new Exception("Error during copy to work directory", e);
        }
    }

    public void convertToTiff() throws Exception{
        File[] files = tempWorkDir.listFiles();
        for(File file: files) {
            if(file.getName().toLowerCase().endsWith(".pdf")) {
                String fname = file.getName();
                File fTiffSource = new File(tempWorkDir, fname.substring(0, fname.length() - 4) + ".tiff");
                boolean res = executeCommandLine(
                        "gs -q -dNOPAUSE -r600 -sDEVICE=tiffg4 " +
                                "-sOutputFile=" + fTiffSource.getAbsolutePath() +
                                " " + file.getAbsolutePath() +
                                " -sCompression=none -c quit");
                if(!fTiffSource.exists())
                    throw new Exception("Error converting file to tiff image format");
            }
        }
    }

    private List<File> fileList = new ArrayList<File>();

    public void execTesseract() throws Exception {
        File[] files = tempWorkDir.listFiles();
        for(File file: files) {
            if(file.getName().toLowerCase().endsWith(".tiff")) {
                String fname = file.getName();
                File fDestination = new File(tempWorkDir, fname.substring(0, fname.length() - 5) + ".res");
                boolean res = executeCommandLine("tesseract -l rus " + file.getAbsolutePath() +
                        " " + fDestination.getAbsolutePath() + " pdf");
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
            StringBuffer buff = new StringBuffer(
                    "gs -dNOPAUSE -sDEVICE=pdfwrite -sOUTPUTFILE=" + concatFile.getAbsolutePath() + " -dBATCH");
            for(File file: fileList) {
                buff.append(" " + file.getAbsolutePath());
            }
            System.out.println(buff.toString());
            executeCommandLine(buff.toString());

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

    private boolean executeCommandLine(String command) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(command);
        int res = pr.waitFor();
        return res == 0;
    }
}
