package kz.arta.ext.sport.model.synergy;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by admin on 21.10.14.
 */
public class UserAdditionalForm {
        @JsonProperty("data-uuid")
        private String dataUuid;

        @JsonProperty("form-uuid")
        private String formUuid;
        private String name;
        private String editable;
        private String mandatory;

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
