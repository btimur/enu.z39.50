import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.UserChooser;
import kz.arta.ext.sport.rest.api.DepartmentReader;
import kz.arta.ext.sport.rest.api.UserChooserReader;
import kz.arta.ext.sport.service.ReportManager;
import kz.arta.ext.sport.service.SyncDataManager;
import kz.arta.ext.sport.service.repository.DepartmentRepository;
import kz.arta.ext.sport.service.repository.UserChooserRepository;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by admin on 05.11.14.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Department.class, UserChooser.class})
public class SyncDataManagerTest {

    private static final String departmentId = "1";

    static {
        System.setProperty("jboss.server.config.dir", "configuration");
    }

    public static final String OK = "ok";

    @Mock
    private Logger loggerMock;

    @Mock
    private DepartmentReader departmentReader;

    @Mock
    private UserChooserReader userChooserReader;

    @Mock
    private UserChooserRepository userChooserRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private SyncDataManager syncDataManager;

    public static String readResource(String resourceName, String encoding) throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream(resourceName);
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, encoding);
        return writer.toString();
    }

    @Before
    public void setUp() throws Exception {

        Department department = new Department();
        department.setDepartmentID(departmentId);
//        String orderJson = readResource("order.json", kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
//        doReturn("departmentId").when(departmentReader, "doGetQuery", any(RestQueryContext.class), Matchers.contains("api/departments"));
        RestQueryContext context = new RestQueryContext();
        context.setAddress("http://test6.arta.kz/Synergy");
        context.setLogin("1");
        context.setPassword("1");

        UserChooser chooser = new UserChooser();
        UserChooser[] users = {chooser};

        doNothing().when(userChooserRepository, "clear");
        doNothing().when(departmentRepository, "clear");
        doReturn(department).when(departmentReader, "getDepartment", departmentId, context);
        doReturn(users).when(userChooserReader, "getListUserChooser", "1", 1, 10,  context);
        doReturn(null).when(departmentRepository, "save", department);
    }

    @Test
    public void run() throws IOException {
      boolean result = syncDataManager.Run();
        Assert.assertTrue(result);
    }
}
