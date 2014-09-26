package kz.arta.ext.sms.model.synergy;

/**
 * Created by admin on 25.09.14.
 */
public class UserChooser {
    private String userID;
    private String name;
    private String position;
    private String title;

    public String getTitle() {
        return getName() +"("+getPosition()+")";
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }



}
