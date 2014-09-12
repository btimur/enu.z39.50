package test.service;

import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.z3950.rest.api.LibraryDictionaryReader;
import kz.arta.ext.z3950.service.DictionaryService;
import kz.arta.ext.z3950.util.CacheManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import test.TestUtils;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doReturn;

@RunWith(PowerMockRunner.class)
@PrepareForTest({LibraryDictionaryReader.class})
public class DictionaryServiceTest {
    public static final String DIC_CODE = "Служебные отметки";
    public static final String DIC_HAS_KEY = "22";
    public static final String DIC_HAS_VALUE = "Н";

    public static final String DIC_NEW_KEY = "46";
    public static final String DIC_NEW_VALUE = "new";

    @Spy
    private LibraryDictionaryReader reader = new LibraryDictionaryReader();

    @InjectMocks
    private DictionaryService service;


    @Before
    public void setUp() throws Exception {
        String json = TestUtils.readResource("dictionary.json", kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
        String response = TestUtils.readResource("dictionaryInsert.json",
                kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
//        PowerMockito.mockStatic(LoggerFactory.class);
//        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(loggerMock);

//        LibraryDictionaryReader reader = spy(new LibraryDictionaryReader());

//        MockitoAnnotations.initMocks(service);

        doReturn(json).when(reader, "doGetQuery", any(RestQueryContext.class), any(String.class));
        doReturn(response).when(reader, "doPostQuery",
                any(RestQueryContext.class), any(RestQueryContext.class), any(String.class));


    }

    @Test
    public void testGetDictionaryKey() throws Exception {
        Assert.assertTrue(CacheManager.getInstance().getDictionaryKey(DIC_HAS_KEY, DIC_HAS_VALUE) == null);
        String key = service.getDictionaryKey(DIC_CODE, DIC_HAS_VALUE);
        Assert.assertEquals(key, DIC_HAS_KEY);
        Assert.assertEquals(CacheManager.getInstance().getDictionaryKey(DIC_CODE, DIC_HAS_VALUE), DIC_HAS_KEY);


        Assert.assertNull(CacheManager.getInstance().getDictionaryKey(DIC_CODE, DIC_NEW_VALUE));
        key = service.getDictionaryKey(DIC_CODE, DIC_NEW_VALUE);
        Assert.assertEquals(key, DIC_NEW_KEY);
        Assert.assertEquals(CacheManager.getInstance().getDictionaryKey(DIC_CODE, DIC_NEW_VALUE), DIC_NEW_KEY);
    }

}