package kz.arta.ext.api.data;

/**
 * Created by timur on 8/27/2014 7:53 PM.
 */
public class DictionaryColumn {
    private String code;
    private String columnID;
    private String value;
    private String valueKZ;
    private String valueRU;
    private String valueEN;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColumnID() {
        return columnID;
    }

    public void setColumnID(String columnID) {
        this.columnID = columnID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueKZ() {
        return valueKZ;
    }

    public void setValueKZ(String valueKZ) {
        this.valueKZ = valueKZ;
    }

    public String getValueRU() {
        return valueRU;
    }

    public void setValueRU(String valueRU) {
        this.valueRU = valueRU;
    }

    public String getValueEN() {
        return valueEN;
    }

    public void setValueEN(String valueEN) {
        this.valueEN = valueEN;
    }
}
