package kz.arta.ext.sport.service;

import kz.arta.ext.sport.model.report.CategoryReport;
import kz.arta.ext.sport.model.report.ConfederationReport;
import kz.arta.ext.sport.model.report.SexEntity;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.service.repository.ReportRepository;
import kz.arta.ext.sport.util.CodeConstants;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 21.10.14.
 */
@Stateless
public class ReportManager extends AReportManager {


    @Inject
    protected FederationManager federationManager;

    @Inject
    protected ReportRepository reportRepository;
    /**
     * Менеджер JPA
     */
    private List<CategoryReport> fillConfederationCotegories(List<Department> departments) {
        List<CategoryReport> categoryReports = new ArrayList<CategoryReport>();

        for (Department department : departments) {
            CategoryReport categoryReport = new CategoryReport();
            categoryReport.setName(department.getNameRu());
            categoryReport.setAdult(getSexEntity(CodeConstants.ABULT, department));
            categoryReport.setJunior(getSexEntity(CodeConstants.JUNIOR, department));
            categoryReport.setYouth(getSexEntity(CodeConstants.YOUTH, department));
            categoryReports.add(categoryReport);
        }
        return categoryReports;
    }

    private SexEntity getSexEntity(String code, Department department) {
        SexEntity sexEntity = new SexEntity();
        sexEntity.setCountMale(getCountRecord(code, department, CodeConstants.MALE_INDEX));
        sexEntity.setCountFemale(getCountRecord(code, department, CodeConstants.FEMALE_INDEX));
        return sexEntity;
    }

    private long getCountRecord(String code, Department department, int sexIndex) {
        String postStr = getPostBysubFederation(code);
      return  reportRepository.getCountRecord(rootStringList,postStr,code,department,sexIndex);
    }

    public ConfederationReport getConfederationReport(String departmentId) {

        ConfederationReport confederationReport = new ConfederationReport();
        Department department = departmentRepository.find(departmentId);
        if (department == null) {
            return null;
        }
        confederationReport.setName(department.getNameRu());
        List<Department> departments = getAllListDepartments(departmentId);
        if (!departmentId.equals(CodeConstants.ROOT_DEPARTMENT) && !rootStringList.contains(departmentId)) {
            confederationReport.setConfederation(false);
            confederationReport.setCategoryReports(federationManager.fillFederationCotegories(departmentId));
            return confederationReport;
        }
        confederationReport.setConfederation(true);


        confederationReport.setCategoryReports(fillConfederationCotegories(departments));
        fillFdTables(confederationReport, departments);
        return confederationReport;
    }


    private void fillFdTables(ConfederationReport confederationReport, List<Department> departments) {
        List<String> titles = new ArrayList<String>();
        List<String> region = new ArrayList<String>();

        List<String> regionName = getRegionNames();
        for (String city : CodeConstants.CITES) {
            region.add(city);
        }
        java.util.Collections.sort(regionName);

        for (String city : regionName) {
            region.add(city);
        }
        for (Department department : departments) {
            titles.add(department.getNameRu());
        }
        HashMap<String, List<Long>> hashMaps = new HashMap<String, List<Long>>();
        for (String reg : region) {
            List<Long> stringArrayList = new ArrayList<Long>();

            for (Department department : departments) {
                Long val = getCellValue(reg, department);
                stringArrayList.add(val);
            }
            hashMaps.put(reg, stringArrayList);
        }

        fillNskReport(hashMaps, departments, region);
        fillAllReport(hashMaps, departments, region);

        confederationReport.setRecords(hashMaps);
        confederationReport.setFdRegion(region);
        confederationReport.setFdTitle(titles);
    }

    private void fillNskReport(HashMap<String, List<Long>> hashMaps, List<Department> departments, List<String> region) {
        List<Long> stringArrayList = new ArrayList<Long>();
        for (Department department : departments) {
            long ct = reportRepository.fillNskReport(rootStringList, department);
            stringArrayList.add(ct);
        }
        region.add(CodeConstants.NSK);
        hashMaps.put(CodeConstants.NSK, stringArrayList);
    }

    private void fillAllReport(HashMap<String, List<Long>> hashMaps, List<Department> departments, List<String> region) {
        List<Long> stringArrayList = new ArrayList<Long>();
        for (Department department : departments) {
            long ct = reportRepository.fillAllReport(rootStringList, department);
            stringArrayList.add(ct);
        }
        region.add("ВСЕГО");
        hashMaps.put("ВСЕГО", stringArrayList);
    }

    private Long getCellValue(String reg, Department department) {
        boolean isCity = false;
        for (String s : CodeConstants.CITES) {
            if (s.equals(reg)) {
                isCity = true;
                break;
            }
        }
        return reportRepository.getCellValue(rootStringList, reg,department,isCity);
    }

}
