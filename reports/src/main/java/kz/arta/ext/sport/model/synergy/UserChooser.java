package kz.arta.ext.sport.model.synergy;

import javax.persistence.*;

/**
 * Created by admin on 21.10.14.
 */
@Entity
@Table(name = "spt_user")
public class UserChooser {
    @Id
    @Column(name = "USER_ID")
    private String userID;

    @Column(name = "NAME_RU")
    private String name;

    @Column(name = "POST")
    private String position;

    @Column(name = "SEX_INDEX")
    private int sexIndex;


    @ManyToOne
    @JoinColumn(name="DEPARTMENT_ID")
    private Department department;


    @Column(name = "ST_CITY")
    private String city;

    @Column(name = "ST_REGION")
    private String region;

    @Column(name = "ST_SUB_REGION")
    private String subRegion;

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public int getSexIndex() {
        return sexIndex;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setSexIndex(int sexIndex) {
        this.sexIndex = sexIndex;
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

