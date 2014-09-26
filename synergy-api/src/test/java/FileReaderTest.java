import kz.arta.ext.api.rest.FileReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.CodeConstants;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doReturn;

/**
 * Created by timur on 9/26/14.
 */
@RunWith(PowerMockRunner.class)
//@PrepareForTest({LibraryDictionaryReader.class})
public class FileReaderTest {

    public static final String DO_GET_QUERY = "doGetQuery";
    public static final String DO_POST_QUERY = "doPostQuery";
    public static final String FILE_PATH = "/opt/synergy/jboss/standalone/tmp/Synergy/upload.tmp/e01e6e4b-fb85-4d58-9a37-fe28031bcd01";
    @Spy
    private FileReader fileReader = new FileReader();

    public static String readResource(String resourceName, String encoding) throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream(resourceName);
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, encoding);
        return writer.toString();
    }

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testStartUploadFile() throws Exception {
        String start = readResource("start_file.json", CodeConstants.ENCODING_UFT_8);
        doReturn(start).when(fileReader, DO_GET_QUERY, any(RestQueryContext.class), any(String.class));

        String file = fileReader.startUploadFile(new RestQueryContext());
        Assert.assertEquals(file, FILE_PATH);

        start = readResource("error.json", CodeConstants.ENCODING_UFT_8);
        doReturn(start).when(fileReader, DO_GET_QUERY, any(RestQueryContext.class), any(String.class));

        file = fileReader.startUploadFile(new RestQueryContext());
        Assert.assertNull(file);

    }

    @Test
    public void testUploadPart() throws Exception {
        String upload = readResource("upload.json", CodeConstants.ENCODING_UFT_8);
        doReturn(upload).when(fileReader, DO_POST_QUERY,
                any(RestQueryContext.class), any(String.class), any(String.class), any(String.class));



        boolean result = fileReader.uploadPart(new RestQueryContext(), FILE_PATH, upload);
        Assert.assertTrue(result);

        upload = readResource("error.json", CodeConstants.ENCODING_UFT_8);
        doReturn(upload).when(fileReader, DO_POST_QUERY,
                any(RestQueryContext.class), any(String.class), any(String.class), any(String.class));

        result = fileReader.uploadPart(new RestQueryContext(), FILE_PATH, upload);
        Assert.assertTrue(!result);

    }

    @Test
    public void testCreateAttachment() throws Exception {
        String docId ="1";
        String fileName = "doc.txt";
        String upload = readResource("upload.json", CodeConstants.ENCODING_UFT_8);
        doReturn(upload).when(fileReader, "doPostBodyQuery",
                any(RestQueryContext.class), any(String.class), any(String.class));
        boolean result = fileReader.createAttachment(new RestQueryContext(), docId, fileName, FILE_PATH);
        Assert.assertTrue(result);

    }
}
