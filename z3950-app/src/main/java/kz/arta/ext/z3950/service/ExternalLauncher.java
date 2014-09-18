package kz.arta.ext.z3950.service;


import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.*;

/**
 * Created by timur on 9/2/2014 12:33 PM.
 * Запускает внешние команды
 */
public class ExternalLauncher {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger log;

    public boolean launchSh(String dir, String... parametrs) {
        ProcessBuilder pb = new ProcessBuilder(parametrs);
        pb.directory(new File(dir));
        pb.redirectErrorStream(true);
        Process process;
        try {
            pb.redirectErrorStream(true);
            process = pb.start();
            process.waitFor();
            OutputStream stdin = process.getOutputStream();
            InputStream stderr = process.getErrorStream();
            InputStream stdout = process.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(stderr));

            String s;
            // read the output from the command
            log.info("Here is the standard output of the command:{}", parametrs);
            while ((s = reader.readLine()) != null) {
                log.info(s);
            }

            // read any errors from the attempted command
            log.info("Here is the standard error of the command :{}", parametrs);
            while ((s = stdError.readLine()) != null) {
                log.info(s);
            }

            int a = process.exitValue();
            log.info(" command{} return - {}", parametrs, a);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }

    }
}
