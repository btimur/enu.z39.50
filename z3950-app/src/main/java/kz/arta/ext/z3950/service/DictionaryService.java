package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.rest.api.LibraryDictionaryReader;
import kz.arta.ext.z3950.util.CacheManager;
import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * Created by timur on 8/27/2014 7:49 PM.
 * работа со справочниками
 */
public class DictionaryService {

    @Inject
    private Logger logger;

    @Inject
    private LibraryDictionaryReader reader;

    public String getDictionaryKey(String dictionaryCode, String value)  {
        try {
            String result = CacheManager.getInstance().getDictionaryKey(dictionaryCode, value);
            if (result == null) {
                result = reader.loadDictionary(dictionaryCode, value);
                if (result == null) {
                    result = reader.insertDictionary(dictionaryCode, value);
                }
            }
            return result;
        } catch (Exception e) {
            logger.error("error load dictionary "+ dictionaryCode + ", value - "+ value, e);
            return null;
        }
    }

}
