package kz.arta.ext.sms.model;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 16.09.14.
 */
public class JurnalFilterEntity extends AFilterEntity{

    private List<Jurnal> jurnals;

    public List<Jurnal> getJurnals() {
        return jurnals;
    }

    public void setJurnals(List<Jurnal> jurnals) {
        this.jurnals = jurnals;
    }

}
