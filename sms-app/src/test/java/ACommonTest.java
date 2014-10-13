import org.apache.commons.io.IOUtils;
import org.mockito.Mock;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by admin on 13.10.14.
 */
public abstract class ACommonTest {
    static {
        System.setProperty("jboss.server.config.dir", "configuration");
    }
    public static final String OK = "ok";

    @Mock
    private Logger logger;

    public static String readResource(String resourceName, String encoding) throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream(resourceName);
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, encoding);
        return writer.toString();
    }
}
