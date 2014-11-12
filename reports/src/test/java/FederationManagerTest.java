import kz.arta.ext.sport.model.report.CategoryReport;
import kz.arta.ext.sport.model.report.SexEntity;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.UserChooser;
import kz.arta.ext.sport.service.repository.DepartmentRepository;
import kz.arta.ext.sport.service.FederationManager;
import kz.arta.ext.sport.service.repository.FederationRepository;
import kz.arta.ext.sport.service.repository.UserChooserRepository;
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
 * Created by admin on 03.11.14.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({Department.class, UserChooser.class})
public class FederationManagerTest {


    static {
        System.setProperty("jboss.server.config.dir", "configuration");
    }

    private String[] regions = {"Акмолинская область","Алматинская область","Повладарская область"};

    private String[] cities = {"Астана","Алматы"};


    @Mock
    private FederationRepository federationRepository;

    @Mock
    private DepartmentRepository departmentRepository;

    @Mock
    private UserChooserRepository userChooserRepository;

    @InjectMocks
    private FederationManager federationManager;


    private static final String departmentId = "1";

    @Before
    public void setUp() throws Exception {
        Department department = getFindDeparment();
        List<String> regions = getRegionNames();
        String code ="1";
        String postStr ="1";
        String city =cities[0];
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
        department.setPointersCode(CodeConstants.ZHENSKAYA_BORBA);
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


    @Test
    public void fillFederationCotegories() {

        List<CategoryReport> compare = new ArrayList<CategoryReport>();
        List<String> stringList = new ArrayList<String>();
        for(String city : cities)
        {
            stringList.add(city);
        }
        for(String region : regions)
        {
            stringList.add(region);
        }
        stringList.add(CodeConstants.NSK);

        for(String s : stringList)
        {
            CategoryReport categoryReport = new CategoryReport();
            categoryReport.setName(s);
            categoryReport.setYouth(new SexEntity());
            categoryReport.setJunior(new SexEntity());
            categoryReport.setAdult(new SexEntity());
            compare.add(categoryReport);
        }
        List<CategoryReport> actual = federationManager.fillFederationCotegories(departmentId);

        Assert.assertTrue("Expected 'actual' and 'compare' to be equal."+
                "\n  'actual'        = "+actual+
                "\n  'compare' = "+compare,
                getHashCodeList(actual).equals(getHashCodeList(compare)));
    }

    private List<Integer> getHashCodeList(List<CategoryReport> categoryReports)
    {
        List<Integer> stringList = new ArrayList<Integer>();
        for(CategoryReport categoryReport : categoryReports)
        {
            stringList.add(categoryReport.hashCode());
        }
        return stringList;
    }

}
