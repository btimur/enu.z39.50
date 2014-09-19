package kz.arta.ext.sms.model;
import java.util.Date;

/**
 * Created by admin on 16.09.14.
 */
public class JurnalFilterEntity {
    private String term;

    private Date beginDate;

    private Date endDate;

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
