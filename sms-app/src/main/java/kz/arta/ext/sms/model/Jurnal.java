package kz.arta.ext.sms.model;

import kz.arta.ext.common.model.IEntity;

import javax.persistence.*;
import javax.print.attribute.standard.DateTimeAtCompleted;
import java.sql.Timestamp;

/**
 * Created by timur on 8/28/2014 10:35 AM.
 */

@Entity
@Table(name = "sms_jurnal")
public class Jurnal implements IEntity{
    /**
     * идентификатор
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    /**
     * Дата и время отправки
     */
    @Column(name = "DATE_SEND")
    private Timestamp dateSend;

    /**
     * ИИН
     */
    @Column(name = "IIN")
    private String iin;

//    private String sendDateFormat;
    /**
     * ФИО
     */
    @Column(name = "FIO")
    private String fio;

    /**
     * номер телефона
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * сообщение
     */
    @Column(name = "MESSAGES")
    private String message;

    /**
     * результат
     */
    @Column(name = "RESULTS")
    private String result;

    @ManyToOne
    @JoinColumn(name="SMS_GATE_ID")
    private SmsGate smsGate;

    /**
     * индентификатор заявки
     */
    @Column(name = "ORDER_UID")
    private String orderUUID;

    /**
     * наименование книги
     */
    @Column(name = "ORDER_BOOKNAME")
    private String orderBookName;

   /* public String getSendDateFormat() {
     return String.format("%1$TD %1$TT", dateSend);
    }*/

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Timestamp getDateSend() {
        return dateSend;
    }

    public void setDateSend(Timestamp dateSend) {
        this.dateSend = dateSend;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public SmsGate getSmsGate() {
        return smsGate;
    }

    public void setSmsGate(SmsGate smsGate) {
        this.smsGate = smsGate;
    }

    public String getOrderUUID() {
        return orderUUID;
    }

    public void setOrderUUID(String orderUUID) {
        this.orderUUID = orderUUID;
    }

    public String getOrderBookName() {
        return orderBookName;
    }

    public void setOrderBookName(String orderBookName) {
        this.orderBookName = orderBookName;
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

        Jurnal that = (Jurnal) o;

        if (id != that.id) return false;
        if (dateSend != null ? !dateSend.equals(that.dateSend) : that.dateSend != null) return false;
        if (iin != null ? !iin.equals(that.iin) : that.iin != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (orderBookName != null ? !orderBookName.equals(that.orderBookName) : that.orderBookName != null)
            return false;
        if (orderUUID != null ? !orderUUID.equals(that.orderUUID) : that.orderUUID != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int res = (int) (id ^ (id >>> 32));
        res = 31 * res + (dateSend != null ? dateSend.hashCode() : 0);
        res = 31 * res + (iin != null ? iin.hashCode() : 0);
        res = 31 * res + (phone != null ? phone.hashCode() : 0);
        res = 31 * res + (message != null ? message.hashCode() : 0);
        res = 31 * res + (result != null ? result.hashCode() : 0);
        res = 31 * res + (orderUUID != null ? orderUUID.hashCode() : 0);
        res = 31 * res + (orderBookName != null ? orderBookName.hashCode() : 0);
        return res;
    }
}
