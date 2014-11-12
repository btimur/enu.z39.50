import kz.arta.ext.sport.model.report.ConfederationReport;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.RegionLocation;
import kz.arta.ext.sport.model.synergy.UserChooser;
import kz.arta.ext.sport.service.RegionReportManager;
import kz.arta.ext.sport.service.ReportManager;
import kz.arta.ext.sport.service.repository.DepartmentRepository;
import kz.arta.ext.sport.service.repository.FederationRepository;
import kz.arta.ext.sport.service.repository.UserChooserRepository;
import kz.arta.ext.sport.util.CodeConstants;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.doReturn;

/**
 * Created by admin on 05.11.14.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Department.class, UserChooser.class})
public class ReportManagerTest {
    static {
        System.setProperty("jboss.server.config.dir", "configuration");
    }

    private static final String departmentId = "1";

    private static final String city = "Астана";
    private String[] regions = {"Акмолинская область","Алматинская область","Повладарская область"};
    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private FederationRepository federationRepository;

    @Mock
    private UserChooserRepository userChooserRepository;

    @InjectMocks
    private ReportManager reportManager;

    @Before
    public void setUp() throws Exception {


        reportManager.fillChildFederation();
        List<String> rootStringList = reportManager.subFederetionList;
        Department department = getFindDeparment();
        getListDepartaments(rootStringList);
        getRegionNames();
        String code ="1";
        String postStr ="1";
        int sexIndex = 1;
        boolean isFemaleWresling = true;
        boolean isCity = true;

        doReturn(1L).when(federationRepository, "getCountNskRecord", code, postStr,department, sexIndex, isFemaleWresling);
        doReturn(1L).when(federationRepository, "getCountRecord",city,  code, department, sexIndex, isCity);
        doReturn(1L).when(federationRepository, "femaleFight", city, postStr, sexIndex, isCity);
    }



    private Department getFindDeparment() throws Exception {
        Department department = new Department();
        department.setDepartmentID(departmentId);
        department.setNameRu(city);
        doReturn(department).when(departmentRepository, "find", departmentId);
        return department;
    }

    private List<String> getRegionNames() throws Exception {
        List<String> stringList = new ArrayList<String>();
        for(String region : regions)
        {
            stringList.add(region);
        }
        doReturn(stringList).when(userChooserRepository, "getRegionNames", CodeConstants.OBLAST_CONTENT);
        return stringList;
    }
    private List<Department> getListDepartaments(List<String> strings) throws Exception {
        List<Department> departments = new ArrayList<Department>();
        Department root = new Department();
        root.setDepartmentID(departmentId);
        for(String s : strings)
        {
            Department department = new Department();
            department.setNameRu(s);
            department.setParent(root);
            departments.add(department);
        }
        doReturn(departments).when(departmentRepository, "getSubFederation", reportManager.subFederetionList);
        return departments;
    }
    @Test
    public void getConfederationReport() {
        ConfederationReport confederationReport = reportManager.getConfederationReport(departmentId);
        Assert.assertNotNull(confederationReport);
        Assert.assertEquals(confederationReport.getName(), city);
        Assert.assertTrue(confederationReport.isConfederation());
        Assert.assertEquals(confederationReport.getFdRegion().size(), 7);
        Assert.assertEquals(confederationReport.getRecords().size(), 7);
    }
}
