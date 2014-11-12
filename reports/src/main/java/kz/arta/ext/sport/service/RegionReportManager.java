package kz.arta.ext.sport.service;

import kz.arta.ext.sport.model.report.CategoryReport;
import kz.arta.ext.sport.model.report.ConfederationReport;
import kz.arta.ext.sport.model.report.SexEntity;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.RegionLocation;
import kz.arta.ext.sport.service.repository.RegionLocationRepository;
import kz.arta.ext.sport.service.repository.RegionReportRepository;
import kz.arta.ext.sport.util.CodeConstants;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.10.14.
 */
@Stateless
public class RegionReportManager extends AReportManager {

    @Inject
    private RegionLocationRepository regionLocationRepository;

    @Inject
    private RegionReportRepository regionReportRepository;

    public ConfederationReport getConfederationReport(String departmentId, String region) {

        fillChildFederation();
        getAllListDepartments(CodeConstants.ROOT_DEPARTMENT);

        ConfederationReport confederationReport = new ConfederationReport();
        confederationReport.setName(region);
        confederationReport.setCategoryReports(getCategoryReports(departmentId, region));

        return confederationReport;
    }

    private List<CategoryReport> getCategoryReports(String departmentId, String regionName) {

        Department department = departmentRepository.find(departmentId);
        List<CategoryReport> categoryReports = new ArrayList<CategoryReport>();
        List<RegionLocation> cityNames =regionLocationRepository.getChilds(regionName);


        for (RegionLocation city : cityNames) {
            CategoryReport categoryReport = new CategoryReport();
            categoryReport.setName(city.getNameRu());
            categoryReport.setAdult(getSexEntity(CodeConstants.ABULT, city.getNameRu(), regionName, department));
            categoryReport.setJunior(getSexEntity(CodeConstants.JUNIOR, city.getNameRu(), regionName, department));
            categoryReport.setYouth(getSexEntity(CodeConstants.YOUTH, city.getNameRu(), regionName, department));
            categoryReports.add(categoryReport);
        }
        CategoryReport categoryReport = new CategoryReport();
        categoryReport.setName(CodeConstants.REGION_EMPTY);
        categoryReport.setAdult(getSexEntity(CodeConstants.ABULT, null, regionName, department));
        categoryReport.setJunior(getSexEntity(CodeConstants.JUNIOR, null, regionName, department));
        categoryReport.setYouth(getSexEntity(CodeConstants.YOUTH, null, regionName, department));
        categoryReports.add(categoryReport);

        return categoryReports;
    }

    private SexEntity getSexEntity(String code, String city, String regionName, Department department) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setCountMale(getCountRecord(code, city, CodeConstants.MALE_INDEX, regionName, department));
        sexEntity.setCountFemale(getCountRecord(code, city, CodeConstants.FEMALE_INDEX, regionName, department));
        return sexEntity;
    }

    private long getCountRecord(String code, String city, int sexIndex, String regionName, Department department) {
        javax.persistence.Query query;

        String postStr = getPostBysubFederation(code);
        if (city == null) {
           return regionReportRepository.getCategoryCountRecord(rootStringList,postStr,code,sexIndex,regionName,department);
        }
        return regionReportRepository.getCityCountRecord(city,postStr,code,sexIndex,regionName,department);
    }
}
