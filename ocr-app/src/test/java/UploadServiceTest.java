import kz.arta.ext.api.rest.FileReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.ocr.model.RecognizeTask;
import kz.arta.ext.ocr.service.UploadService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.powermock.api.mockito.PowerMockito.doReturn;

/**
 * Created by timur on 9/26/14.
 * тесты аплоада файла
 */
@RunWith(PowerMockRunner.class)
//@PrepareForTest({UserAdditionalFormReader.class})
public class UploadServiceTest {

    @Mock
    private Logger logger;
    @Mock
    private FileReader fileReader;

    @InjectMocks
    private UploadService service;

    @Test
    public void testUpload() throws Exception {
        RecognizeTask task = new RecognizeTask();
        boolean result = service.uploadToServer(task);
        Assert.assertFalse(result);

        task.setFileEnd(ClassLoader.getSystemResource("min.doc").getPath());
        task.setDocId("11-1");
        task.setCompleted(true);

        doReturn("tempFile").when(fileReader, "startUploadFile", any(RestQueryContext.class));
        doReturn(true).when(fileReader, "uploadPart", any(RestQueryContext.class), any(String.class), any(String.class));
        doReturn(true).when(fileReader, "createAttachment", any(RestQueryContext.class), any(String.class),
                any(String.class), any(String.class));
        result = service.uploadToServer(task);

        Mockito.verify(fileReader, times(1)).uploadPart(any(RestQueryContext.class), any(String.class), any(String.class));
        Assert.assertTrue(result);
        Assert.assertTrue(task.isUploaded());


        task.setFileEnd(ClassLoader.getSystemResource("big.pdf").getPath());
        result = service.uploadToServer(task);
        Mockito.verify(fileReader, times(15)).uploadPart(any(RestQueryContext.class), any(String.class), any(String.class));
        Assert.assertTrue(result);
    }

}
