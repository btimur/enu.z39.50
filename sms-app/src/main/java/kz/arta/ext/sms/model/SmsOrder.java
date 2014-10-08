package kz.arta.ext.sms.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by timur on 8/28/2014 10:19 AM.
 */

@Entity
@Table(name = "sms_order")
public class SmsOrder implements IEntity{
    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    /**
     * uid заказа
     */
    @Column(name = "DATA_UUID")
    private String dataUUID;

    /**
     * uid пользователя
     */
    @Column(name = "USER_ID")
    private String userid;

    /**
     * фио пользователя
     */
    @Column(name = "FIO")
    private String fio;

    /**
     * иин пользователя
     */
    @Column(name = "IIN")
    private String iin;

    /**
     * наименование книги
     */
    @Column(name = "NAME_BOOK")
    private String nameofbook;

    /**
     * инфентарный номер
     */
    @Column(name = "INVNUM")
    private String invnum;

    /**
     * дата выдачи
     */
    @Column(name = "DATE_VIDACHI")
    private Date dateofvidacha;

    /**
     * срок возврата
     */
    @Column(name = "SROK_VOZVRATA")
    private Date srokvozvrata;

    /**
     * выполнить
     */
    @Column(name = "EXECUTED")
    private Boolean executed;

    /**
     * отправлен
     */
    @Column(name = "SENDED")
    private Boolean sended;

    @ManyToOne
    @JoinColumn(name="SMS_JURNAL_ID")
    private Jurnal jurnal;

    /**
     * дата регистрации
     */
    @Column(name = "REG_DATE")
    private Timestamp regDate;

    /**
     * дата отправки
     */
    @Column(name = "SEND_DATE")
    private Timestamp sendDate;



    /**
     * кол-во попыток
     */
    @Column(name = "COUNT_TRY")
    private Integer countTry;



    public Integer getCountTry() {
        return countTry;
    }

    public void setCountTry(Integer countTry) {
        this.countTry = countTry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataUUID() {
        return dataUUID;
    }

    public void setDataUUID(String dataUUID) {
        this.dataUUID = dataUUID;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getNameofbook() {
        return nameofbook;
    }

    public void setNameofbook(String nameofbook) {
        this.nameofbook = nameofbook;
    }

    public String getInvnum() {
        return invnum;
    }

    public void setInvnum(String invnum) {
        this.invnum = invnum;
    }

    public Date getDateofvidacha() {
        return dateofvidacha;
    }

    public void setDateofvidacha(Date dateofvidacha) {
        this.dateofvidacha = dateofvidacha;
    }

    public Date getSrokvozvrata() {
        return srokvozvrata;
    }

    public void setSrokvozvrata(Date srokvozvrata) {
        this.srokvozvrata = srokvozvrata;
    }

    public Boolean getExecuted() {
        return executed;
    }

    public void setExecuted(Boolean executed) {
        this.executed = executed;
    }

    public Boolean getSended() {
        return sended;
    }

    public void setSended(Boolean sended) {
        this.sended = sended;
    }

    public Jurnal getJurnal() {
        return jurnal;
    }

    public void setJurnal(Jurnal jurnal) {
        this.jurnal = jurnal;
    }

    public Timestamp getRegDate() {
        return regDate;
    }

    public void setRegDate(Timestamp regDate) {
        this.regDate = regDate;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }
}
