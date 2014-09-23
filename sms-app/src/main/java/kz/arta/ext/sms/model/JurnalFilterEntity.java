package kz.arta.ext.sms.model;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 16.09.14.
 */
public class JurnalFilterEntity {
    private String term;

    private Date beginDate;

    private Date endDate;

    private int page;
    private int pageSize;

    private long countRecord;

    private List<Jurnal> jurnals;

    public long getCountRecord() {
        return countRecord;
    }

    public void setCountRecord(long countRecord) {
        this.countRecord = countRecord;
    }

    public List<Jurnal> getJurnals() {
        return jurnals;
    }

    public void setJurnals(List<Jurnal> jurnals) {
        this.jurnals = jurnals;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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
