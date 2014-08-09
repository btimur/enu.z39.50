package kz.arta.ext.api.config;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Kavin
 * Date: 26.04.14
 * Time: 10:14
 */
public class ConfigReader {
    private static final Logger logger = Logger.getLogger(ConfigReader.class);

    private static Properties properties = null;
    private static Date lastPropertiesLoad;
    public static long CACHE_LIVETIME_MSEC = 10*60*1000;

    public static String getPropertyValue(String propName)  {
        try {
            if (properties == null || lastPropertiesLoad == null || (new Date().getTime() - lastPropertiesLoad.getTime()) > CACHE_LIVETIME_MSEC) {
                load();
            }
            if (properties.getProperty(propName) != null) {
                return properties.getProperty(propName);
            } else {
                logger.warn("Property "+propName+" does not exists!");
                return null;
            }
        } catch (Exception e) {
            logger.error("Cannot read property "+ propName+ ", because of exception: ", e);
            return null;
        }
    }
    private static void load() throws Exception {
        String path = System.getProperty("jboss.server.config.dir");
        if (path == null) {
            //Костыль для 4 jboss-а
            path = System.getProperty("jboss.server.data.dir")+"/../conf";
        }
        path+="/esot.properties";
        if (new File(path).exists()) {
            properties = new Properties();
            properties.load(new FileInputStream(path));
        } else {
            throw new Exception("No properties file "+path);
        }
        lastPropertiesLoad = new Date();
    }
}
