import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.BlockSignalMessage;
import kz.arta.ext.sms.rest.SmsQuery;
import kz.arta.ext.sms.rest.api.OrderReader;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.service.JurnalRepository;
import kz.arta.ext.sms.service.SmsGateRepository;
import kz.arta.ext.sms.service.SmsPlainSender;
import kz.arta.ext.sms.service.SmsSender;
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
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by admin on 04.09.14.
 * тесты отправки
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SmsSender.class, OrderReader.class, UserAdditionalFormReader.class})
public class SmsSenderTest {

    static {
        System.setProperty("jboss.server.config.dir", "configuration");
    }

    public static final String OK = "ok";

    @Spy
    private OrderReader reader = new OrderReader();

    @Spy
    private UserAdditionalFormReader userReader = new UserAdditionalFormReader();

    @Spy
    private SmsGateRepository smsGateRepository = new SmsGateRepository();

    @Mock
    private Logger loggerMock;

    @Mock
    private JurnalRepository jurnalRepository;

    @InjectMocks
    private SmsSender smsSender;

    @InjectMocks
    private SmsPlainSender sendPlainSms;

//    @InjectMocks
//    private DictionaryService service;

    public static String readResource(String resourceName, String encoding) throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream(resourceName);
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, encoding);
        return writer.toString();
    }

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
    public void sendSms() throws IOException {

         smsSender.runSmsSender();
//        Mockito.verify(jurnalRepository, times(1)).save(any(Jurnal.class));
//        Assert.assertTrue(result);

    }

    @Test
    public void saveOrUpdateOrder() throws IOException {

        RestQueryContext context = new RestQueryContext();
        context.setAddress("http://test3.arta.kz/Synergy");
        context.setLogin("1");
        context.setPassword("1");
        BlockSignalMessage message = new BlockSignalMessage();
        message.setDocumentID("1");
        message.setDataUUID("1");
        message.setExecutionID("1");
        boolean result = smsSender.saveOrUpdateOrder(message, context);
        Mockito.verify(jurnalRepository, times(1)).save(any(Jurnal.class));
        Assert.assertTrue(result);

    }

    @Test
    public void testSendPlainSms(){
        boolean result = sendPlainSms.sendPlainSms("test", "ba7d7ebe-4cf3-4172-8d07-1b7e6355eaa0");
        Mockito.verify(jurnalRepository, times(1)).save(any(Jurnal.class));
        Assert.assertTrue(result);
    }
}
