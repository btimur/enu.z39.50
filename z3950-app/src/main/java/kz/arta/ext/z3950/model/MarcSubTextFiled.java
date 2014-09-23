package kz.arta.ext.z3950.model;

/**
 * Created by timur on 9/22/14.
 */
public class MarcSubTextFiled {
    private String subName;
    private String subValue;

    public MarcSubTextFiled() {
    }

    public MarcSubTextFiled(String subName, String subValue) {
        this.subName = subName;
        this.subValue = subValue;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubValue() {
        return subValue;
    }

    public void setSubValue(String subValue) {
        this.subValue = subValue;
    }
}
