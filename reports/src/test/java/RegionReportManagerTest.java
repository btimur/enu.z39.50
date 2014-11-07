import kz.arta.ext.sport.model.report.CategoryReport;
import kz.arta.ext.sport.model.report.ConfederationReport;
import kz.arta.ext.sport.model.report.SexEntity;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.RegionLocation;
import kz.arta.ext.sport.model.synergy.UserChooser;
import kz.arta.ext.sport.service.RegionReportManager;
import kz.arta.ext.sport.service.repository.*;
import kz.arta.ext.sport.service.FederationManager;
import kz.arta.ext.sport.util.CodeConstants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by admin on 05.11.14.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Department.class, UserChooser.class})
public class RegionReportManagerTest {
    static {
        System.setProperty("jboss.server.config.dir", "configuration");
    }

    private static final String departmentId = "1";
    private static final String regionName = "Астана";

    private String[] regions = {"Есильский район","Алматинский район"};
    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private RegionLocationRepository regionLocationRepository;

    @Mock
    private UserChooserRepository userChooserRepository;

    @Mock
    private RegionReportRepository regionReportRepository;

    @InjectMocks
    private RegionReportManager regionReportManager;

    @Before
    public void setUp() throws Exception {
        regionReportManager.fillChildFederation();
        List<String> rootStringList = regionReportManager.subFederetionList;
        Department department = getFindDeparment();
        getListDepartaments(rootStringList);
        getListRegionLocations();
        String postStr ="1";
        String code ="1";
        int sexIndex = 1;

        doReturn(1L).when(regionReportRepository, "getCategoryCountRecord", rootStringList, postStr, code, sexIndex, regionName, department);
        doReturn(1L).when(regionReportRepository, "getCityCountRecord", regionName,  postStr, code, sexIndex, regionName, department);

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
        doReturn(departments).when(departmentRepository, "getSubFederation", regionReportManager.subFederetionList);
        return departments;
    }
    private List<RegionLocation> getListRegionLocations() throws Exception {
        List<RegionLocation> regionLocations = new ArrayList<RegionLocation>();
        for(String s : regions)
        {
            RegionLocation regionLocation = new RegionLocation();
            regionLocation.setNameRu(s);
            regionLocations.add(regionLocation);
        }
        doReturn(regionLocations).when(regionLocationRepository, "getChilds", regionName);
        return regionLocations;
    }
    private Department getFindDeparment() throws Exception {
        Department department = new Department();
        department.setDepartmentID(departmentId);
        department.setPointersCode(CodeConstants.ZHENSKAYA_BORBA);
        doReturn(department).when(departmentRepository, "find", departmentId);
        return department;
    }

    @Test
    public void getConfederationReport() {
        ConfederationReport confederationReport = regionReportManager.getConfederationReport(departmentId, regionName);
        Assert.assertNotNull(confederationReport);
        Assert.assertFalse(confederationReport.isConfederation());
        Assert.assertEquals(confederationReport.getName().hashCode(),regionName.hashCode());
        Assert.assertEquals(confederationReport.getCategoryReports().size(), 3);

    }
}
