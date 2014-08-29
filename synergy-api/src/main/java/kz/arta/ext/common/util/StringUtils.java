package kz.arta.ext.common.util;

/**
 * Created by timur on 8/29/2014 10:28 AM.
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String s) {
        return s == null || "".equals(s.trim());
    }
}
