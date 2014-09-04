package kz.arta.ext.z3950.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.Dictionary;
import kz.arta.ext.api.data.DictionaryColumn;
import kz.arta.ext.api.data.DictionaryItem;
import kz.arta.ext.api.rest.DictionaryReader;
import kz.arta.ext.z3950.rest.api.LibraryDictionaryReader;
import kz.arta.ext.z3950.util.CacheManager;

import javax.inject.Inject;

/**
 * Created by timur on 8/27/2014 7:49 PM.
 */
public class DictionaryService {
    @Inject
    private LibraryDictionaryReader reader;

    public String getDictionaryKey(String dictionaryCode,String value){
        String result = CacheManager.getInstance().getDictionaryKey(dictionaryCode,value);
        if (result == null){
            result = reader.loadDictionary(dictionaryCode, value);
            if (result == null){
               result = reader.insertDictionary(dictionaryCode, value);
            }
        }
        return result;
    }

}
