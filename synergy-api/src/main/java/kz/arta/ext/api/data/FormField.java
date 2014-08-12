package kz.arta.ext.api.data;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 20:11
 */
public class FormField {
    private String id;
    private String type;
    private String value;
    private String key;
    private String username;
    private String userID;
    private String label;
    private String timestamp;
    private String valueDefault;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getValueDefault() {
        return valueDefault;
    }

    public void setValueDefault(String valueDefault) {
        this.valueDefault = valueDefault;
    }

    @Override
    public String toString() {
        return "id = " + id + ", type=" + type + ", value=" + value + ", key=" + key;
    }
}
