package kz.arta.ext.ocr.recognizer;

import kz.arta.ext.ocr.model.RecognizeTask;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Администратор on 27.09.2014.
 */
public class Recognizer {

    private File workDir;
    private File outDir;

    private RecognizeTask task;

    public Recognizer(File workDir, File outDir, RecognizeTask task) {
        this.workDir = workDir;
        this.outDir = outDir;
        this.task = task;
    }

    private File fSourceClone;
    private File fTiffSource;
    private File fDestination;
    private File fResult;

    public void copySourceFileToWorkDir() throws Exception {
        try {
            File fSource = new File(task.getFilePath());
            fSourceClone = new File(workDir, task.getUuid() + ".pdf");
            FileUtils.copyFile(fSource, fSourceClone);
        } catch (IOException e) {
            throw new Exception("Error during copy source pdf-file to work directory", e);
        }
    }

    public void convertToTiff() throws Exception{
        fTiffSource = new File(workDir, task.getUuid() + ".tiff");
        boolean res = executeCommandLine(
                "gs -q -dNOPAUSE -r600 -sDEVICE=tiffg4 " +
                        "-sOutputFile=" + fTiffSource.getAbsolutePath() +
                        " " + fSourceClone.getAbsolutePath() +
                        " -sCompression=none -c quit");
        if(!fTiffSource.exists())
            throw new Exception("Error converting file to tiff image format");
    }

    public void execTesseract() throws Exception {
        fTiffSource = new File(workDir, task.getUuid() + ".tiff");

        fDestination = new File(workDir, task.getUuid() + "_res");
        boolean res = executeCommandLine("tesseract -l rus " + fTiffSource.getAbsolutePath() +
                " " + fDestination.getAbsolutePath() + " pdf");
        fDestination = new File(workDir, task.getUuid() + "_res.pdf");

        if(fDestination.exists()) {
            fResult = new File(outDir, task.getUuid() + ".pdf");
            FileUtils.moveFile(fDestination, fResult);
        } else
            throw new Exception("Error during recognize document with tesseract");

        fSourceClone.delete();
        fTiffSource.delete();

        if(!fResult.exists())
            throw new Exception("Error during move recognized file to output directory");
    }

    public File getResultFile() {
        return fResult;
    }

    private boolean executeCommandLine(String command) throws Exception {
        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec(command);
        int res = pr.waitFor();
        return res == 0;
    }
}
