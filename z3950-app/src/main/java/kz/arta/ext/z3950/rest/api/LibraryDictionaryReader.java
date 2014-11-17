package kz.arta.ext.z3950.rest.api;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.Dictionary;
import kz.arta.ext.api.data.DictionaryColumn;
import kz.arta.ext.api.data.DictionaryItem;
import kz.arta.ext.api.rest.DictionaryReader;
import kz.arta.ext.z3950.util.CacheManager;

import java.util.ArrayList;

/**
 * Created by timur on 8/27/2014 11:32 PM.
 */
public class LibraryDictionaryReader extends DictionaryReader {

    public static final String NAME_COLUMN = "Name";
    public static final String ID_COLUMN = "ID";


    public void loadDictionary(String dictionaryCode) {
        Dictionary dictionary = readDictionary(ConfigUtils.getQueryContext(), dictionaryCode);
        log.debug("load dictionary - {}", dictionaryCode);
        String columnID = null;
        String columnName = null;
        for (DictionaryColumn column : dictionary.getColumns()) {
            if (column.getCode().equals(ID_COLUMN)) columnID = column.getColumnID();
            if (column.getCode().equals(NAME_COLUMN)) columnName = column.getColumnID();
        }
        for (DictionaryItem item : dictionary.getItems()) {
            String key = item.giveValuesMap().get(columnID);
            String val = item.giveValuesMap().get(columnName);
            CacheManager.getInstance().addDictionary(dictionaryCode, key, val);
            log.debug("add value for dictionary - {}, key - {}, val -{}", dictionaryCode, key, val);
            try {
                CacheManager.getInstance().addDictionaryID(dictionaryCode, Integer.parseInt(key));
            } catch (NumberFormatException e) {
                log.error("can't add id for dictionary {" + dictionaryCode + "}, value {" + key + "}", e);
            }
        }
    }

    public String insertDictionary(String dictionaryCode, String value) {
        String key = insertDictionary(ConfigUtils.getQueryContext(), dictionaryCode, value);
        CacheManager.getInstance().addDictionary(dictionaryCode, key, value);
        return key;
    }


    protected Dictionary createDictionary(String dictionaryCode, String value) {
        Dictionary dictionary = new Dictionary();
        dictionary.setDictCode(dictionaryCode);
        ArrayList<DictionaryColumn> columns = new ArrayList<DictionaryColumn>();
        dictionary.setColumns(columns);

        DictionaryColumn e = new DictionaryColumn();
        e.setCode(NAME_COLUMN);
        e.setValue(value);
        columns.add(e);
        DictionaryColumn e2 = new DictionaryColumn();
        e2.setCode(ID_COLUMN);
        e2.setValue(getMaxId(dictionaryCode).toString());
        columns.add(e2);


        return dictionary;
    }

    private Integer getMaxId(String dictionaryCode) {
        return CacheManager.getInstance().getDictionaryID(dictionaryCode) + 1;
    }

    @Override
    protected String getSuccesCode(Dictionary dictionary) {
        return dictionary.giveColumnsMap().get(ID_COLUMN).getValue();
    }
}
