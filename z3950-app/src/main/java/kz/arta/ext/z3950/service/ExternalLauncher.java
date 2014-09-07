package kz.arta.ext.z3950.service;

import java.io.File;
import java.io.IOException;

/**
 * Created by timur on 9/2/2014 12:33 PM.
 */
public class ExternalLauncher {

    public int launch(String command, String dir) {
        Process p = null;
        try {
            File f = new File(dir);
            if (!f.exists()){
                throw  new IOException();
            }
            Process process = Runtime.getRuntime().exec("zebraidx",
                    null, f);

            p = Runtime.getRuntime().exec("start.bat", null, new File("C:\\temp\\"));
//            ProcessBuilder builder = new ProcessBuilder(command);
//            builder.directory(new File(dir));
//            builder.redirectErrorStream(true);
//            p = builder.start();
            p = Runtime.getRuntime().exec(command, null, new File(dir));
            p.waitFor();
            return  p.exitValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(p != null){
                p.destroy();
            }
        }
        return -1;
    }
}
