package kz.arta.ext.sport.service;

import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.service.repository.DepartmentRepository;
import kz.arta.ext.sport.service.repository.UserChooserRepository;
import kz.arta.ext.sport.util.CodeConstants;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 22.10.14.
 */
public abstract class AReportManager {


    public List<String> subFederetionList = new ArrayList<String>();
    protected List<String> rootStringList = new ArrayList<String>();

    @Inject
    protected EntityManager em;

    @Inject
    protected DepartmentRepository departmentRepository;

    @Inject
    protected UserChooserRepository userChooserRepository;

    public void fillChildFederation() {
        subFederetionList = new ArrayList<String>();
        subFederetionList.add(CodeConstants.WRESTLING);
        subFederetionList.add(CodeConstants.GRECO_WRESTLING);
        subFederetionList.add(CodeConstants.ZHENSKAYA_BORBA);

    }
    protected String getPostBysubFederation(String code) {
        if (code.equals(CodeConstants.ABULT)) {
            return  CodeConstants.ABULT_CATEGORY;
        }
        if (code.equals(CodeConstants.YOUTH)) {
            return CodeConstants.YOUTH_CATEGORY;
        }
        if (code.equals(CodeConstants.JUNIOR)) {
            return CodeConstants.JUNIOR_CATEGORY;
        }
        return null;
    }
    public  List<String> getRegionNames() {
        return userChooserRepository.getRegionNames(CodeConstants.OBLAST_CONTENT);
    }

    protected List<Department> getAllListDepartments(String departmentId) {
        fillChildFederation();
        List<Department> departmentsAll = new ArrayList<Department>();
        List<Department> subfederation = departmentRepository.getSubFederation(subFederetionList);

        for (Department department : subfederation) {
            if (!rootStringList.contains(department.getParent().getDepartmentID())) {
                rootStringList.add(department.getParent().getDepartmentID());
            }
        }
        if (!departmentId.equals(CodeConstants.ROOT_DEPARTMENT)) {
            return subfederation;
        }

        List<Department> departments = departmentRepository.getChilds(CodeConstants.ROOT_DEPARTMENT);

        for (Department department : departments) {
            departmentsAll.add(department);
            if (rootStringList.contains(department.getDepartmentID())) {
                for (Department subdepartment : subfederation) {
                    departmentsAll.add(subdepartment);
                }
            }
        }

        return departmentsAll;
    }
}
