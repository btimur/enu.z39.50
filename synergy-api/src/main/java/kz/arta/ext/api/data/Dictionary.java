package kz.arta.ext.api.data;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.naming.directory.Attribute;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 8/27/2014 7:52 PM.
 */
public class Dictionary {
    private String dictionary_code;
    private String dictCode;
    private String dictionaryID;
    private List<DictionaryColumn> columns;
    private List<DictionaryItem> items;

    @JsonIgnore
    private Map<String, DictionaryColumn> columnMap;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictionary_code() {
        return dictionary_code;
    }

    public void setDictionary_code(String dictionary_code) {
        this.dictionary_code = dictionary_code;
    }

    public String getDictionaryID() {
        return dictionaryID;
    }

    public void setDictionaryID(String dictionaryID) {
        this.dictionaryID = dictionaryID;
    }

    public List<DictionaryColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<DictionaryColumn> columns) {
        this.columns = columns;
    }

    public List<DictionaryItem> getItems() {
        return items;
    }

    public void setItems(List<DictionaryItem> items) {
        this.items = items;
    }


    public Map<String, DictionaryColumn> giveColumnsMap() {
        if (columnMap == null){
            columnMap = new HashMap<String, DictionaryColumn>();
            for (DictionaryColumn column :columns) {
                columnMap.put(column.getCode(), column);
            }
        }
        return columnMap;
    }
}
