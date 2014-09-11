package test;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by timur on 9/10/14.
 */
public class TestUtils {
    public static String readResource(String resourceName, String encoding) throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream(resourceName);
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, encoding);
        return writer.toString();
    }
}
