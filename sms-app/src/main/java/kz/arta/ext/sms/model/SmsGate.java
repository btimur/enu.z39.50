package kz.arta.ext.sms.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;

/**
 * Created by timur on 8/28/2014 10:19 AM.
 */

@Entity
@Table(name = "sms_gate")
public class SmsGate implements IEntity{
    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    /**
     * наименование sms
     */
    @Column(name = "NAME_SMS")
    private String nameSms;

    /**
     * ссылка
     */
    @Column(name = "SURL")
    private String sUrl;

    /**
     * пользователь
     */
    @Column(name = "LOGIN")
    private String sLogin;

    /**
     * пароль
     */
    @Column(name = "PWD")
    private String sPwd;

    /**
     * Кодировка
     */
    @Column(name = "SCHARSET")
    private String sCharset;

    /**
     * Формат
     */
    @Column(name = "SFORMAT")
    private String sFormat;

    /**
     * Активный
     */
    @Column(name = "ENABLED")
    private Boolean enabled;

    /**
     * Переведен
     */
    @Column(name = "TRANSLIT")
    private Boolean translit;

    /**
     * Номер
     */
    @Column(name = "SORDER")
    private Integer sOrder;

    /**
     * Удален
     */
    @Column(name = "DELETED")
    private Boolean deleted;

    /**
     * Шаблон
     */
    @Column(name = "TEMPLATE")
    private String template;

    /**
     * Ответ при удачной отправки
     */
    @Column(name = "SUCESS_RESULT")
    private String sucessResult;

    /**
     * Шаблон сообщения
     */
    @Column(name = "MESSAGE_CONTEXT")
    private String messageContext;

    /**
     * Запрос на проверку статуса
     */
    @Column(name = "CHECK_STATUS")
    private String checkStatusUrl;

    /**
     * Где указывается ид сообщение
     */
    @Column(name = "SMSID_START")
    private String smsIdStart;

    /**
     * Положительный ответ по проверке статуса
     */
    @Column(name = "CHECK_STATUS_OK")
    private String checkStatusOk;


    public String getCheckStatusUrl() {
        return checkStatusUrl;
    }

    public void setCheckStatusUrl(String checkStatusUrl) {
        this.checkStatusUrl = checkStatusUrl;
    }

    public String getSmsIdStart() {
        return smsIdStart;
    }

    public void setSmsIdStart(String smsIdStart) {
        this.smsIdStart = smsIdStart;
    }

    public String getCheckStatusOk() {
        return checkStatusOk;
    }

    public void setCheckStatusOk(String checkStatusOk) {
        this.checkStatusOk = checkStatusOk;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getSucessResult() {
        return sucessResult;
    }

    public void setSucessResult(String sucessResult) {
        this.sucessResult = sucessResult;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsGate that = (SmsGate) o;

        if (deleted != that.deleted) return false;
        if (enabled != that.enabled) return false;
        if (id != that.id) return false;
        if (sOrder != that.sOrder) return false;
        if (translit != that.translit) return false;
        if (sLogin != null ? !sLogin.equals(that.sLogin) : that.sLogin != null) return false;
        if (nameSms != null ? !nameSms.equals(that.nameSms) : that.nameSms != null) return false;
        if (sPwd != null ? !sPwd.equals(that.sPwd) : that.sPwd != null) return false;
        if (sCharset != null ? !sCharset.equals(that.sCharset) : that.sCharset != null) return false;
        if (sFormat != null ? !sFormat.equals(that.sFormat) : that.sFormat != null) return false;
        if (sUrl != null ? !sUrl.equals(that.sUrl) : that.sUrl != null) return false;
        if (template != null ? !template.equals(that.template) : that.template != null) return false;
        if (sucessResult != null ? !sucessResult.equals(that.sucessResult) : that.sucessResult != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (nameSms != null ? nameSms.hashCode() : 0);
        result = 31 * result + (sUrl != null ? sUrl.hashCode() : 0);
        result = 31 * result + (sLogin != null ? sLogin.hashCode() : 0);
        result = 31 * result + (sPwd != null ? sPwd.hashCode() : 0);
        result = 31 * result + (sCharset != null ? sCharset.hashCode() : 0);
        result = 31 * result + (sFormat != null ? sFormat.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (translit ? 1 : 0);
        result = 31 * result + sOrder;
        result = 31 * result + (deleted ? 1 : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);
        result = 31 * result + (sucessResult != null ? sucessResult.hashCode() : 0);
        return result;
    }

}
