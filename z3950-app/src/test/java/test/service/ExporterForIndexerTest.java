package test.service;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.CodeConstants;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.rest.api.LibraryDictionaryReader;
import kz.arta.ext.z3950.service.ExporterForIndexer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.marc4j.marc.Record;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import test.TestUtils;

import java.io.File;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({LibraryDictionaryReader.class, ConfigReader.class})
public class ExporterForIndexerTest {

    public static final String DATA_UUID = "7d4efde7-dda2-4e8f-b276-f848639033cf";
    public static final String FORM_UUID = "7f2e7c29-6238-40c5-9eeb-50f383ff0119";
    @Mock
    private Logger logger;
    @Spy
    private LibraryBookReader reader = new LibraryBookReader();

    @InjectMocks
    private ExporterForIndexer exporter;
    private String path;
    private String json;

    @Before
    public void setUp() throws Exception {
        mockStatic(ConfigReader.class);
        when(ConfigReader.getPropertyValue(kz.arta.ext.z3950.util.CodeConstants.ZEBRA_DATA_PATH))
                .thenReturn(System.getProperty("user.dir"));
        path = (String) PowerMockito.method(ExporterForIndexer.class, "getPath")
                .invoke(exporter, DATA_UUID);

        deleteTestFile();
        json = TestUtils.readResource("formdata.json", CodeConstants.ENCODING_UFT_8);
        doReturn(json).when(reader, "doGetQuery", any(RestQueryContext.class), any(String.class));
        doReturn(new String[]{ DATA_UUID}).when(reader, "getDataUUID", any(RestQueryContext.class), any(String.class));
    }

    @After
    public void tearDown() throws Exception {
        deleteTestFile();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private void deleteTestFile() {
        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    @Test
    public void testExportRegistry() throws Exception {
        String result = exporter.exportRegistry(FORM_UUID);
        Assert.assertEquals("ok", result);
        Assert.assertTrue(new File(path).exists());
    }

    @Test
    public void testExport() throws Exception {
        boolean result = exporter.export(DATA_UUID, false);
        Assert.assertTrue(result);
        Assert.assertTrue(new File(path).exists());
    }

    @Test
    public void testGetRecord() throws Exception {

        FormData formData = reader.parseFormData(json);
        Record record = exporter.getRecord(formData);
        Assert.assertNotNull(record);
        Assert.assertEquals(record.getControlNumber(), DATA_UUID);
    }
}