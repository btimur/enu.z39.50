package kz.arta.ext.api.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 11.05.14
 * Time: 1:36
 */
public class DictionariesUtils {
    private static Map<String, String> categoriesMap = new HashMap<String, String>();
    static {
        categoriesMap.put("1","основная (1)");
        categoriesMap.put("2","вспомогательная (2)");
        categoriesMap.put("3","обслуживающая (3)");
    }


    public static String getCategoryByCode(String code) {
        if (categoriesMap.containsKey(code)){
            return categoriesMap.get(code);
        }
        return "категория "+code;
    }

    public static String getCroupByCode(String code) {
        return code+" группа";
    }
}
