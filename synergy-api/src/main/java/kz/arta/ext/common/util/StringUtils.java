package kz.arta.ext.common.util;

/**
 * Created by timur on 8/29/2014 10:28 AM.
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

    public static boolean isNumber(String first) {
        try{
            int i = Integer.parseInt(first);
            return i>=0;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
