package kz.arta.ext.sms.model;

import kz.arta.ext.common.model.IEntity;

import java.sql.Timestamp;

/**
 * Created by timur on 8/28/2014 10:35 AM.
 */
public class Jurnal implements IEntity{
    private Long id;
    private Timestamp dateSend;
    private String iin;
    private String phone;
    private String message;
    private String result;
    private SmsGate smsGate;
    private String orderUUID;
    private String orderBookName;

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
}
