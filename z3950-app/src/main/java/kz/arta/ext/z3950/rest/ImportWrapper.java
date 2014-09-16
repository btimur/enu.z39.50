package kz.arta.ext.z3950.rest;

/**
 * Created by timur on 9/14/14.
 * wrapper response import book
 */
public class ImportWrapper {
    private String dataUUID;
    private String documentID;
    private Boolean error;

    public ImportWrapper() {
    }

    public ImportWrapper(String dataUUID, String documentID) {
        this.dataUUID = dataUUID;
        this.documentID = documentID;
        error = false;
    }

    public ImportWrapper(Boolean error) {
        this.error = error;
    }

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

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}
