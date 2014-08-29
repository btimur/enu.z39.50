package kz.arta.ext.sms.util;

/**
 * Created by timur on 8/28/2014 10:54 AM.
 */
public class CodeConstants {
    public static final String JMS_DESTINATION = "java:jboss/queues/Synergy/SmsBlockQueue";
    public static final String FORMAT_DATE = "format.date";
    public static final String FORMAT_DATETIME = "format.datetime";

    public static boolean isNullOrEmpty(String s) {
        return s == null || "".equals(s.trim());
    }

}
