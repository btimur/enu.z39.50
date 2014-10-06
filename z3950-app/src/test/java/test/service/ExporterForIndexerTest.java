package test.service;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.CodeConstants;
import kz.arta.ext.z3950.model.ExportIndexWrapper;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.rest.api.LibraryDictionaryReader;
import kz.arta.ext.z3950.service.ExporterForIndexer;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.marc4j.marc.Record;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import test.TestUtils;

import javax.jms.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({LibraryDictionaryReader.class, ConfigReader.class})
public class ExporterForIndexerTest {

    public static final String DATA_UUID = "7d4efde7-dda2-4e8f-b276-f848639033cf";
    public static final String FORM_UUID = "7f2e7c29-6238-40c5-9eeb-50f383ff0119";
    private final String testDir = System.getProperty("user.dir") + "//testdata//";
    @Mock
    private Logger logger;
    @Spy
    private LibraryBookReader reader = new LibraryBookReader();

    @Mock(name = "java:/ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Mock
    private Connection connection;

    @Mock
    private Session session;

    @Mock
    private ObjectMessage objectMessage;

    @Mock
    private MessageProducer producer;

    @Mock(name = kz.arta.ext.z3950.util.CodeConstants.INDEX_ALL_ZEBRA_JMS_DESTINATION)
    private Destination destination;

    @InjectMocks
    private ExporterForIndexer exporter;
//    private String path;
    private String json;

    @Before
    public void setUp() throws Exception {
        mockStatic(ConfigReader.class);
        when(ConfigReader.getPropertyValue(kz.arta.ext.z3950.util.CodeConstants.ZEBRA_DATA_PATH))
                .thenReturn(testDir);
        deleteTestFile();
        File test = new File(testDir);
        if (!test.exists()){
            //noinspection ResultOfMethodCallIgnored
            test.mkdir();
        }
//        path = (String) PowerMockito.method(ExporterForIndexer.class, "getPath")
//                .invoke(exporter, DATA_UUID);


        json = TestUtils.readResource("formdata.json", CodeConstants.ENCODING_UFT_8);
        doReturn(json).when(reader, "doGetQuery", any(RestQueryContext.class), any(String.class));



        when(connectionFactory.createConnection()).thenReturn(connection);
        when(connection.createSession(false, Session.AUTO_ACKNOWLEDGE)).thenReturn(session);
        when(session.createProducer(destination)).thenReturn(producer);

        when(session.createObjectMessage()).thenReturn(objectMessage);
    }

    @After
    public void tearDown() throws Exception {
        deleteTestFile();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void deleteTestFile() throws IOException {
        File file = new File(testDir);
        if (file.exists()) {
            FileUtils.deleteDirectory(file);
        }
    }

    @Test
    public void testExportRegistry() throws Exception {

        String result = exporter.exportRegistry(FORM_UUID);
        Assert.assertEquals("ok", result);
        Mockito.verify(producer, times(52)).send(any(ObjectMessage.class));
//        Assert.assertTrue(new File(path).exists());
    }

    @Test
    public void testExport() throws Exception {
        doReturn(new String[]{DATA_UUID}).when(reader, "getDataUUID", any(String.class),
                any(RestQueryContext.class), any(Integer.class), any(Integer.class));
        boolean result = exporter.export(DATA_UUID, false);
        Assert.assertTrue(result);
        Assert.assertTrue(new File(testDir + DATA_UUID).exists());
    }

    @Test
    public void testGetRecord() throws Exception {

        FormData formData = reader.parseFormData(json);
        Record record = exporter.getRecord(formData);
        Assert.assertNotNull(record);
        Assert.assertEquals(record.getControlNumber(), DATA_UUID);
    }


    @Test
    public void testExportAsyncRegistry() throws Exception {
        ExportIndexWrapper wrapper = new ExportIndexWrapper(FORM_UUID, 0, ExporterForIndexer.BUFFER_READ_BOOKS);

//        replace(method(LibraryBookReader.class, "getDataUUID"))
//                .with(method(ExporterForIndexerTest.class, "getDataUUID"));
         //, String.class, RestQueryContext.class,int.class, int.class)
        String[] uuids = new String[ExporterForIndexer.BUFFER_READ_BOOKS];
        for (int i = 0; i < ExporterForIndexer.BUFFER_READ_BOOKS; i++) {
            uuids[i] = UUID.randomUUID().toString();
        }
        doReturn(uuids).when(reader, "getDataUUID", any(String.class), any(RestQueryContext.class),
                any(Integer.class), any(Integer.class));//.thenReturn(uuids);
        boolean result = exporter.exportAsyncRegistry(wrapper);
        Assert.assertTrue(result);
        File file = new File(testDir);
        Assert.assertEquals(file.list().length, ExporterForIndexer.BUFFER_READ_BOOKS);
    }
}