package kz.arta.ext.api.data;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:44
 */
public class RegistryRecord {
    private String dataUUID;
    private String documentID;
    private String errorCode;
    private String errorMessage;
    private String asfNodeID;

    public String getDataUUID() {
        return dataUUID;
    }

    public void setDataUUID(String dataUUID) {
        this.dataUUID = dataUUID;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getAsfNodeID() {
        return asfNodeID;
    }

    public void setAsfNodeID(String asfNodeID) {
        this.asfNodeID = asfNodeID;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
