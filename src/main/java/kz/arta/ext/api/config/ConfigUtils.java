package kz.arta.ext.api.config;

import kz.arta.ext.api.rest.RestQueryContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:37
 */
public class ConfigUtils {
    private static RestQueryContext queryContext = null;

//    public static final String DELETED_VALUE = "true";
//    public static final String NOT_DELETED_VALUE = "false";
//    public static final String STAFF_UNIT_SEARCH_FIELD = "cmp-xukkmt";


    public static String getSynergyAddress() {
        return ConfigReader.getPropertyValue("synergy.address");
    }

    public static String getUserLogin() {
        return ConfigReader.getPropertyValue("user.login");
    }

    public static String getUserPassword() {
        return ConfigReader.getPropertyValue("user.password");
    }

//    public static String getCurrentRegion() {
//        return currentRegion;
//    }

    public static RestQueryContext getQueryContext() {
        if (queryContext==null){
            queryContext = new RestQueryContext(getSynergyAddress(), getUserLogin(), getUserPassword());
        }
        return queryContext;
    }


    public static double parseDouble(String value) {
        if (value!=null && value.length()>0){
            return Double.parseDouble(value.replaceAll(",","."));
        }
        return 0;
    }

    public static int parseInt(String count) {
        int res = 0;
        if (count!=null && count.length()>0){
            res = Integer.parseInt(count);
        }
        return res;
    }
}
