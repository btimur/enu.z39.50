package kz.arta.ext.sms.model.synergy;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by admin on 05.09.14.
 */
public class UserAdditionalForm {
    @JsonProperty("data-uuid")
    private String dataUuid;

    @JsonProperty("form-uuid")
    private String formUuid;
    private String name;
    private String editable;
    private String mandatory;

    private String fullName;
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDataUuid() {
        return dataUuid;
    }

    public void setDataUuid(String dataUuid) {
        this.dataUuid = dataUuid;
    }

    public String getFormUuid() {
        return formUuid;
    }

    public void setFormUuid(String formUuid) {
        this.formUuid = formUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditable() {
        return editable;
    }

    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }
}
