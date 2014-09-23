package kz.arta.ext.z3950.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 9/22/14.
 */
public class MarcTextFiled {
    private String field;
    private String fieldValue;
    private String fieldIndex;
    private List<MarcSubTextFiled> subfields;


    public MarcTextFiled() {
    }

    public MarcTextFiled(String field, String fieldValue, String fieldIndex) {
        this.field = field;
        this.fieldValue = fieldValue;
        this.fieldIndex = fieldIndex;
        subfields = new ArrayList<MarcSubTextFiled>();
    }

    public List<MarcSubTextFiled> getSubfields() {
        return subfields;
    }

    public void setSubfields(List<MarcSubTextFiled> subfields) {
        this.subfields = subfields;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldIndex() {
        return fieldIndex;
    }

    public void setFieldIndex(String fieldIndex) {
        this.fieldIndex = fieldIndex;
    }
}
