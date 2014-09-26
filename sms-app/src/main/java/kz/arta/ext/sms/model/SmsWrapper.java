package kz.arta.ext.sms.model;

/**
 * Created by timur on 9/24/14.
 * wrapping собщения
 */
public class SmsWrapper {
    private String message;
    private String userId;
    private Boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
