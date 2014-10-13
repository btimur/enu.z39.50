import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.SmsOrder;
import kz.arta.ext.sms.rest.SmsQuery;
import kz.arta.ext.sms.rest.api.OrderReader;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.service.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.cglib.transform.impl.AccessFieldTransformer;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by admin on 13.10.14.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SmsSender.class, OrderReader.class, UserAdditionalFormReader.class, SmsOrder.class})
public class SmsPlainSenderTest extends ACommonTest {

    @Spy
    private OrderReader reader = new OrderReader();

    @Spy
    private UserAdditionalFormReader userReader = new UserAdditionalFormReader();

    @Spy
    private SmsGateRepository smsGateRepository = new SmsGateRepository();

    @Mock
    private JurnalRepository jurnalRepository;

    @Spy
    @InjectMocks
    private SmsSender smsSender = new SmsSender();

    @Spy
    @InjectMocks
    private SendService sendService = new SendService();

    @InjectMocks
    private SmsPlainSender sendPlainSms;

    @Before
    public void setUp() throws Exception {
        String orderJson = readResource("order.json", kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
        String userJson = readResource("user.json", kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
        String userDataJson = readResource("user_data.json", kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
        String userFioJson = readResource("user_fio.json", kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);

        doReturn(orderJson).when(reader, "doGetQuery", any(RestQueryContext.class), any(String.class));
        doReturn(userJson).when(userReader, "doGetQuery", any(RestQueryContext.class), Matchers.contains("personalrecord"));
        doReturn(userDataJson).when(userReader, "doGetQuery", any(RestQueryContext.class), Matchers.contains("api/asforms/data"));
        doReturn(userFioJson).when(userReader, "doGetQuery", any(RestQueryContext.class), Matchers.contains("filecabinet/user"));

        SmsQuery test = Mockito.mock(SmsQuery.class);
        when(test.doGetQueryWithoutAuth(any(RestQueryContext.class))).thenReturn(OK);
        whenNew(SmsQuery.class).withNoArguments().thenReturn(test);

        List<SmsGate> smsGates = new ArrayList<SmsGate>();
        SmsGate smsGate = new SmsGate();
        smsGate.setNameSms("1");
        smsGate.setsLogin("1");
        smsGate.setsPwd("1");
        smsGate.setTranslit(true);
        smsGate.setsCharset(kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
        smsGate.setsUrl("http://sssss.ru");
        smsGate.setSucessResult(OK);
        smsGate.setMessageContext("Уважаемый %FULL_NAME%, книга %NAME_BOOK% %DATE_DELIVERY%, срок возврата %DATE_BACK%");
        smsGate.setTemplate("http://sssss.ru/sms/send?api_id=06d24b0b-4b81-7214-7d85-4f33f6711955&to=%ENU_PHONES%&text=%ENU_MSG%");
        smsGates.add(smsGate);
        doReturn(smsGates).when(smsGateRepository, "getActiveSmsGates");
    }
    @Test
    public void testSendPlainSms(){
        boolean result = sendPlainSms.sendPlainSms("test", "ba7d7ebe-4cf3-4172-8d07-1b7e6355eaa0");
        Mockito.verify(jurnalRepository, times(1)).save(any(Jurnal.class));
        Assert.assertTrue(result);
    }
}
