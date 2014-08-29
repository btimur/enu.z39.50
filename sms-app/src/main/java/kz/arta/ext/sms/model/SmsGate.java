package kz.arta.ext.sms.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by timur on 8/28/2014 10:19 AM.
 */

@Entity
@Table(name = "sms_gate", schema = "", catalog = "z3950")
public class SmsGate {
    private String nameSms;
    private String sUrl;
    private String sLogin;
    private String sPwd;
    private String sCharset;
    private String sFormat;
    private Boolean enabled;
    private Boolean translit;
    private Integer sOrder;
    private Boolean deleted;
    private String template;

    public String getNameSms() {
        return nameSms;
    }

    public void setNameSms(String nameSms) {
        this.nameSms = nameSms;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getsLogin() {
        return sLogin;
    }

    public void setsLogin(String sLogin) {
        this.sLogin = sLogin;
    }

    public String getsPwd() {
        return sPwd;
    }

    public void setsPwd(String sPwd) {
        this.sPwd = sPwd;
    }

    public String getsCharset() {
        return sCharset;
    }

    public void setsCharset(String sCharset) {
        this.sCharset = sCharset;
    }

    public String getsFormat() {
        return sFormat;
    }

    public void setsFormat(String sFormat) {
        this.sFormat = sFormat;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getTranslit() {
        return translit;
    }

    public void setTranslit(Boolean translit) {
        this.translit = translit;
    }

    public Integer getsOrder() {
        return sOrder;
    }

    public void setsOrder(Integer sOrder) {
        this.sOrder = sOrder;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
