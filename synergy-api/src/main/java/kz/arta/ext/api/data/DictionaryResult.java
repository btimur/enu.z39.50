package kz.arta.ext.api.data;

/**
 * Created by timur on 8/27/2014 11:46 PM.
 */
public class DictionaryResult {
    private String errorCode;
    private String errorMessage;
    private String itemID;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }
}
