package kz.arta.ext.sms.model.synergy;

import org.jboss.resteasy.util.DateUtil;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by timur on 8/28/2014 11:00 AM.
 */
public class Order {
    private String dataUUID;
    private String userid;
    private String nameofbook;
    private String invnum;
    private String iin;
    private Date dateofvidacha;
    private Date dateofsdacha;

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

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public Date getDateofvidacha() {
        return dateofvidacha;
    }

    public void setDateofvidacha(Date dateofvidacha) {
        this.dateofvidacha = dateofvidacha;
    }

    public Date getDateofsdacha() {
        return dateofsdacha;
    }

    public void setDateofsdacha(Date dateofsdacha) {
        this.dateofsdacha = dateofsdacha;
    }
}
