import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.Order;
import kz.arta.ext.sms.service.SmsSender;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by admin on 04.09.14.
 */
public class SmsSenderTest {

//    @Test
//    public void testSend() throws IOException {
//
//        RestQueryContext context = new RestQueryContext();
//        context.setAddress("http://test3.arta.kz/Synergy");
//        context.setLogin("1");
//        context.setPassword("1");
//        SmsSender smsSender = new SmsSender();
//        smsSender.sendSms("test",context);



     /*   SmsGate smsGate = new SmsGate();
        smsGate.setsCharset("UTF-8");
        smsGate.setsLogin("didar712");
        smsGate.setsPwd("1q2w3e4r");
        smsGate.setsUrl("http://smsc.kz/sys/send.php?login=%ENU_LOGIN%&psw=%ENU_PWD%&phones=%ENU_PHONES%&mes=%ENU_MSG%");
        kz.arta.ext.sms.model.synergy.Order order = new Order();
        order.setUserid("77ad2e16-cdf9-442e-b7c0-50dad52c40c7");

        String userID = "77ad2e16-cdf9-442e-b7c0-50dad52c40c7";*/



//        boolean result =new SmsSender().trySend(smsGate, order);
//        Assert.assertEquals(result, true);
//    }
}
