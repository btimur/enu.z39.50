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

    public boolean copySourceFileToWorkDir() {
        try {
            File fSource = new File(task.getFilePath());
            fSourceClone = new File(workDir, task.getUuid() + ".pdf");
            FileUtils.copyFile(fSource, fSourceClone);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean convertToTiff() {
        fTiffSource = new File(workDir, task.getUuid() + ".tiff");
        try {
            boolean res = executeCommandLine(
                    "gs -q -dNOPAUSE -r600 -sDEVICE=tiffg4 " +
                            "-sOutputFile=" + fTiffSource.getAbsolutePath() +
                            " " + fSourceClone.getAbsolutePath() +
                            " -sCompression=none -c quit");
            return res && fTiffSource.exists();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean execTesseract() {
        fTiffSource = new File(workDir, task.getUuid() + ".tiff");
        try {
            fDestination = new File(workDir, task.getUuid() + "_res");
            boolean res = executeCommandLine("tesseract -l rus " + fTiffSource.getAbsolutePath() +
                    " " + fDestination.getAbsolutePath() + " pdf");
            fDestination = new File(workDir, task.getUuid() + "_res.pdf");

            if(res && fDestination.exists()) {
                fResult = new File(outDir, task.getUuid() + ".pdf");
                FileUtils.moveFile(fDestination, fResult);
            } else
                return false;

            fSourceClone.delete();
            fTiffSource.delete();

            compliteSuccess = fResult.exists();
            return compliteSuccess;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean compliteSuccess = false;

    public boolean isCompliteSuccess() {
        return compliteSuccess;
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
