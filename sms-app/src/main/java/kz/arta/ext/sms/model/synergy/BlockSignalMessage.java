package kz.arta.ext.sms.model.synergy;

/**
 * Created by timur on 8/28/2014 10:47 AM.
 */
public class BlockSignalMessage {
    private String dataUUID;
    private String executionID;
    private String documentID;

    public String getDataUUID() {
        return dataUUID;
    }

    public void setDataUUID(String dataUUID) {
        this.dataUUID = dataUUID;
    }

    public String getExecutionID() {
        return executionID;
    }

    public void setExecutionID(String executionID) {
        this.executionID = executionID;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }
}
