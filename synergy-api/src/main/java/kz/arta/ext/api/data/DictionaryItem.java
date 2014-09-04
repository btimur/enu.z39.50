package kz.arta.ext.api.data;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 8/27/2014 7:55 PM.
 */
public class DictionaryItem {

    private String itemID;
    private List<DictionaryItemValue> values;
    @JsonIgnore
    private Map<String, String> valuesMap;


    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public List<DictionaryItemValue> getValues() {
        return values;
    }

    public void setValues(List<DictionaryItemValue> values) {
        this.values = values;
    }

    public Map<String, String> giveValuesMap() {
        if (valuesMap == null) {
            valuesMap = new HashMap<String, String>();
            for (DictionaryItemValue itemValue : values) {
                valuesMap.put(itemValue.getColumnID(), itemValue.getValue());
            }
        }
        return valuesMap;
    }
}
