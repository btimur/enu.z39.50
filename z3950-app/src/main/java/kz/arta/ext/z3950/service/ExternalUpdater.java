package kz.arta.ext.z3950.service;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.common.service.ExternalLauncher;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.z3950.model.External;
import kz.arta.ext.z3950.util.CodeConstants;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by timur on 10/3/14.
 * обновляет конфигурации zebra
 */
@Stateless
public class ExternalUpdater {

    public static final String ZEBRA_CFG = "//zebra.cfg";
    public static final String ZEBRA_PWD = "//zebra.passwd";

    @Inject
    private Logger logger;

    @Inject
    private ExternalRepository repository;

    @Inject
    private ExternalLauncher launcher;

    public static String listLines(File file, String assertRow) throws IOException {
        String fileStr = FileUtils.readFileToString(file);
        String lines[] = fileStr.split("[\\r\\n]+");
        for (String line : lines) {
            if (line.startsWith(assertRow)) {
                return line;
            }
        }
        return null;
    }

    @Schedule(second = "0", minute = "*/5", hour = "*")
    public void updateOld() {
        Date current = new Date(Calendar.getInstance().getTimeInMillis());
        logger.debug("remove old before {}", current);
        List<External> list = repository.getOld(current);
        for (External user : list) {
            try {
                remove(user);
                logger.debug("remove older user {},  id - {}, dateEnd -{}", user.getLogin(),
                        user.getId(), user.getDateEnd());
            } catch (IOException e) {
                logger.error("error remove user " + user.getId());
            }
        }
    }

    public void update(External external) throws IOException {
        checkCfg(external, false);
        checkPwd(external, false);
        restart();
    }

    private void checkPwd(External external, boolean delete) throws IOException {
        File file = new File(getPwdFilePath());
        File filebak = new File(getPwdFilePath() + ".bak");
        FileUtils.copyFile(file, filebak);

        String newRow = external.getLogin() + ":" + external.getPwd();
        if (external.isBlock()){
            newRow = "#" + newRow;
        }
        String line = listLines(file, external.getLogin());
        addNewUserToPwd(file, filebak, newRow, !StringUtils.isNullOrEmpty(line), external.getLogin(), delete);
    }

    private void addNewUserToPwd(File file, File filebak, String newRow, boolean update, String newUser, boolean delete) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filebak));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (update && line.startsWith(newUser)) {
                    if (!delete) {
                        writer.write(newRow);
                    }
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
            if (!update && !delete) {
                writer.write(newRow);
                writer.newLine();
            }
        } finally {
            reader.close();
            writer.close();
        }
    }

    private void checkCfg(External external, boolean delete) throws IOException {
        File file = new File(getCfgFilePath());
        File filebak = new File(getCfgFilePath() + ".bak");
        FileUtils.copyFile(file, filebak);

        String newRow = "perm." + external.getLogin() + ":r";
        String line = listLines(file, "perm." + external.getLogin());
        if (!external.isBlock() && StringUtils.isNullOrEmpty(line)) {
            addNewUserToCfg(file, filebak, newRow, false, null);
        } else if ((external.isBlock() || delete) && !StringUtils.isNullOrEmpty(line)) {
            addNewUserToCfg(file, filebak, newRow, true, "perm." + external.getLogin());
        }
    }

    private void addNewUserToCfg(File file, File filebak, String newRow, boolean remove, String userRow) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filebak));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!remove) {
                    writer.write(line);
                    if (line.startsWith("#passwd info")) {
                        writer.newLine();
                        writer.write(newRow);
                    }
                } else if (!line.contains(userRow)) {
                    writer.write(line);
                }
                writer.newLine();
            }
        } finally {
            reader.close();
            writer.close();
        }
    }

    private String getCfgFilePath() {
        return ConfigReader.getPropertyValue(CodeConstants.ZEBRA_PATH) + ZEBRA_CFG;
    }

    private String getPwdFilePath() {
        return ConfigReader.getPropertyValue(CodeConstants.ZEBRA_PATH) + ZEBRA_PWD;
    }

    public void remove(External external) throws IOException {
        checkCfg(external, true);
        checkPwd(external, true);
        restart();
    }

    private void restart() {
        launcher.launchSh(ConfigReader.getPropertyValue(CodeConstants.ZEBRA_PATH),
                "sh", "restart.sh");
    }
}
