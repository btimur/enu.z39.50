package kz.arta.ext.api.data;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 22.03.14
 * Time: 23:33
 */
public class User {
    private String name;

    private String userid;
    private String lastname;
    private String firstname;
    private String patronymic;
    private String mail;
    private String jid;
    private String code;
    private String access;
    private Object positions;

    @JsonProperty("hr-manager")
    private String hrManager;

    private String admin;
    private String configurator;

    @JsonProperty("pointers-access")
    private String pointersAccess;

    private String modified;

    public String getUserid() {
        return userid;
    }

    public Object  getPositions() {
        return positions;
    }

    public void setPositions(Object positions) {
        this.positions = positions;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getJid() {
        return jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getHrManager() {
        return hrManager;
    }

    public void setHrManager(String hrManager) {
        this.hrManager = hrManager;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getConfigurator() {
        return configurator;
    }

    public void setConfigurator(String configurator) {
        this.configurator = configurator;
    }

    public String getPointersAccess() {
        return pointersAccess;
    }

    public void setPointersAccess(String pointersAccess) {
        this.pointersAccess = pointersAccess;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
