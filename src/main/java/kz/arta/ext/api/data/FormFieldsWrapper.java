package kz.arta.ext.api.data;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 20:12
 */
public class FormFieldsWrapper {
    private String uuid;
    private String form;
    private List<FormField> fields;
    private Map<String, FormField> formFieldMap = new HashMap<String, FormField>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public List<FormField> getFields() {
        if (fields==null){
            fields = new ArrayList<FormField>();
        }
        return fields;
    }

    public void setFields(List<FormField> fields) {
        this.fields = fields;
    }

    public void printFields(){
        if (fields!=null){
            int i=1;
            for(FormField record:fields){
                System.out.println((i++)+". field = " + record);
            }
        }
    }

    public void mapFields() {
        formFieldMap.clear();
        if (fields!=null){
            for(FormField record:fields){
                formFieldMap.put(record.getId(), record);
            }
        }
    }

    public Map<String, FormField> getFormFieldMap() {
        return formFieldMap;
    }

    public String convertToData() throws Exception{
        String result = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        Writer wr = new StringWriter();
        mapper.writeValue(wr, fields);
        result = wr.toString();
        return result;
    }

    public void addField(String fieldId, String fieldType) {
        FormField field = new FormField();
        field.setId(fieldId);
        field.setType(fieldType);
        getFields().add(field);
        getFormFieldMap().put(fieldId, field);
    }
}
