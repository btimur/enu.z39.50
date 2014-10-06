package kz.arta.ext.sms.model;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 16.09.14.
 */
public class OrderFilterEntity extends AFilterEntity{

    private List<SmsOrder> smsOrders;

    public List<SmsOrder> getSmsOrders() {
        return smsOrders;
    }

    public void setSmsOrders(List<SmsOrder> smsOrders) {
        this.smsOrders = smsOrders;
    }
}
