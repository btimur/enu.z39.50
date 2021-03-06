import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.SmsOrder;
import kz.arta.ext.sms.model.synergy.BlockSignalMessage;
import kz.arta.ext.sms.rest.SmsQuery;
import kz.arta.ext.sms.rest.api.OrderReader;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.service.*;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by admin on 09.10.14.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SmsSender.class, OrderReader.class, UserAdditionalFormReader.class})
public class OldNotSendManagerTest {

    static {
        System.setProperty("jboss.server.config.dir", "configuration");
    }

    public static final String OK = "ok";

    private Timestamp timestamp;

    @Spy
    private OrderReader reader = new OrderReader();

    @Spy
    private UserAdditionalFormReader userReader = new UserAdditionalFormReader();

    @Spy
    private SmsGateRepository smsGateRepository = new SmsGateRepository();

    @Spy
    private SmsOrderRepository smsOrderRepository = new SmsOrderRepository();

    @Mock
    private Logger loggerMock;

    @Mock
    private JurnalRepository jurnalRepository;


    @InjectMocks
    private SmsSender smsSender;

    @InjectMocks
    private OldNotSendManager oldNotSendManager;


    @InjectMocks
    private SmsPlainSender sendPlainSms;

    public static String readResource(String resourceName, String encoding) throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream(resourceName);
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, encoding);
        return writer.toString();
    }

    @Before
    public void setUp() throws Exception {
        timestamp = new Timestamp(new Date(2014,1,1).getTime());
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
        smsGate.setCheckStatusOk(OK);
        smsGate.setMessageContext("Уважаемый %FULL_NAME%, книга %NAME_BOOK% %DATE_DELIVERY%, срок возврата %DATE_BACK%");
        smsGate.setTemplate("http://sssss.ru/sms/send?api_id=06d24b0b-4b81-7214-7d85-4f33f6711955&to=%ENU_PHONES%&text=%ENU_MSG%");
        smsGate.setCheckStatusUrl("http://sssss.ru/sms/status?api_id=06d24b0b-4b81-7214-7d85-4f33f6711955&id=%SMS_ID%");
        smsGates.add(smsGate);

        Jurnal jurnal = fillGetListNotSendByOrderUid(smsGate);
        fillGetListNotSendFirstTime(jurnal);
        doReturn(null).when(smsOrderRepository, "update", any(SmsOrder.class));
    }

    private Jurnal fillGetListNotSendByOrderUid(SmsGate smsGate) throws Exception {

        List<Jurnal> jurnalList = new ArrayList<Jurnal>();
        Jurnal jurnal = new Jurnal();
        jurnal.setId((long) 1);
        jurnal.setResult("test");
        jurnal.setIin("1234567891910");
        jurnal.setFio("Иванов");
        jurnal.setMessage("hello");
        jurnal.setOrderBookName("book");
        jurnal.setSmsIdSend("1");
        jurnal.setDateSend(timestamp);
        jurnal.setOrderUUID("1");
        jurnal.setPhone("87012123952");
        jurnal.setSmsGate(smsGate);
        jurnalList.add(jurnal);
        doReturn(jurnalList).when(jurnalRepository, "getListNotSendByOrderUid","1");
        return jurnal;
    }

    private void fillGetListNotSendFirstTime(Jurnal jurnal) throws Exception {
        List<SmsOrder> smsOrders = new ArrayList<SmsOrder>();

        for(int i=0;i<2;i++)
        {
        SmsOrder smsOrder = new SmsOrder();
        smsOrder.setCountTry(1);
        smsOrder.setIin("1234567891910");
        smsOrder.setSendDate(timestamp);
        smsOrder.setSended(false);
        smsOrder.setExecuted(true);
        smsOrder.setFio("Иванов");
        smsOrder.setRegDate(timestamp);
        smsOrder.setUserid("1");
        smsOrder.setNameofbook("book " + i);
        smsOrder.setDataUUID("1");
        smsOrder.setDateofvidacha(timestamp);
        smsOrder.setId((long) 1 + i);
        smsOrder.setJurnal(jurnal);
        smsOrder.setSrokvozvrata(timestamp);
            smsOrders.add(smsOrder);
        }
        doReturn(smsOrders).when(smsOrderRepository, "GetListNotSendFirstTime");
    }

    @Test
    public void CheckStatusOldOrder() throws IOException {
        RestQueryContext context = new RestQueryContext();
        context.setAddress("http://test3.arta.kz/Synergy");
        context.setLogin("1");
        context.setPassword("1");
        BlockSignalMessage message = new BlockSignalMessage();
        message.setDocumentID("1");
        message.setDataUUID("1");
        message.setExecutionID("1");
        boolean result = oldNotSendManager.CheckStatusOldOrder();
        Mockito.verify(jurnalRepository, times(1)).update(any(Jurnal.class));
        Assert.assertTrue(result);

    }

}
