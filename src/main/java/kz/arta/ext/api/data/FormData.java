package kz.arta.ext.api.data;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:44
 */
public class FormData {
    private String uuid;
    private String version;
    private String form;
    private String formVersion;
    private String modified;
    private String data;
    private String username;
    private String userID;
    private String nodeUUID;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getFormVersion() {
        return formVersion;
    }

    public void setFormVersion(String formVersion) {
        this.formVersion = formVersion;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNodeUUID() {
        return nodeUUID;
    }

    public void setNodeUUID(String nodeUUID) {
        this.nodeUUID = nodeUUID;
    }

    public FormFieldsWrapper convertToWrapper(){
        FormFieldsWrapper fieldsWrapper = null;
        if (uuid!=null && data!=null){
            String json = "{\"uuid\":\""+uuid+"\", \"form\":\""+form+"\", \"fields\":"+data+"}";
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                fieldsWrapper = objectMapper.readValue(json, FormFieldsWrapper.class);
            } catch (IOException e) {
                System.out.println("json = " + json);
                e.printStackTrace();
            }
            if (fieldsWrapper!=null){
                fieldsWrapper.mapFields();
            }
        }
        return fieldsWrapper;
    }
}
