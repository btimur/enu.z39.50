package kz.arta.ext.sport.service;

import kz.arta.ext.sport.model.report.CategoryReport;
import kz.arta.ext.sport.model.report.SexEntity;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.service.repository.DepartmentRepository;
import kz.arta.ext.sport.service.repository.FederationRepository;
import kz.arta.ext.sport.util.CodeConstants;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 23.10.14.
 */
public class FederationManager extends AReportManager {

    @Inject
    protected FederationRepository federationRepository;

    public List<CategoryReport> fillFederationCotegories(String departmentId) {
        fillChildFederation();
        List<CategoryReport> categoryReports = new ArrayList<CategoryReport>();
        Department department = departmentRepository.find(departmentId);
        if (department == null) {
            return new ArrayList<CategoryReport>();
        }
        List<String> regionName = getRegionNames();

        java.util.Collections.sort(regionName);

        for (String city : CodeConstants.CITES) {
            categoryReports.add(fillCategory(city, department, true));
        }

        for (String city : regionName) {
            categoryReports.add(fillCategory(city, department, false));
        }
        categoryReports.add(fillNskReport(department));
        return categoryReports;
    }

    private CategoryReport fillCategory(String city, Department department, boolean isCity) {
        CategoryReport categoryReport = new CategoryReport();
        categoryReport.setName(city);
        categoryReport.setAdult(getSexEntity(city, CodeConstants.ABULT, department, isCity));
        categoryReport.setJunior(getSexEntity(city, CodeConstants.JUNIOR, department, isCity));
        categoryReport.setYouth(getSexEntity(city, CodeConstants.YOUTH, department, isCity));
        return categoryReport;

    }

    private SexEntity getSexEntity(String city, String abult, Department department, boolean isCity) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setCountMale(getCountRecord(city, abult, department, CodeConstants.MALE_INDEX, isCity));
        sexEntity.setCountFemale(getCountRecord(city, abult, department, CodeConstants.FEMALE_INDEX, isCity));
        return sexEntity;
    }

    private CategoryReport fillNskReport(Department department) {
        CategoryReport categoryReport = new CategoryReport();
        categoryReport.setName(CodeConstants.NSK);

        categoryReport.setAdult(getNskSexEntity(CodeConstants.ABULT, department));
        categoryReport.setJunior(getNskSexEntity(CodeConstants.JUNIOR, department));
        categoryReport.setYouth(getNskSexEntity(CodeConstants.YOUTH, department));
        return categoryReport;
    }

    private SexEntity getNskSexEntity(String abult, Department department) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setCountMale(getCountNskRecord(abult, department, CodeConstants.MALE_INDEX));
        sexEntity.setCountFemale(getCountNskRecord(abult, department, CodeConstants.FEMALE_INDEX));
        return sexEntity;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    private long getCountNskRecord(String code, Department department, int sexIndex) {
        String postStr = getPostBysubFederation(code);
        if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {

            if (sexIndex == CodeConstants.MALE_INDEX) {
                return 0;
            }
            return federationRepository.getCountNskRecord(code,postStr, department,sexIndex,true);
        }
        return federationRepository.getCountNskRecord(code,postStr, department,sexIndex,false);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    private long getCountRecord(String city, String code, Department department, int sexIndex, boolean isCity) {
        {
            if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {
                String postStr = getPostBysubFederation(code);
             return   federationRepository.femaleFight(city, postStr,sexIndex,isCity);
            }
            return federationRepository.getCountRecord(city,code,department, sexIndex,isCity);
        }
    }

}
