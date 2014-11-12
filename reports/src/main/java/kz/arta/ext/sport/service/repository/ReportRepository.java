package kz.arta.ext.sport.service.repository;

import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.util.CodeConstants;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 04.11.14.
 */
@Stateless
public class ReportRepository {
    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCountRecord(List<String> rootStringList,String postStr, String code, Department department, int sexIndex) {
        javax.persistence.Query query;

        if (rootStringList.contains(department.getDepartmentID())) {
            query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?3 and x.department.pointersCode like ?1 and x.department.parent.parent.parent.departmentID like ?2")
                    .setParameter(1, "%" + code + "%")
                    .setParameter(2, department.getDepartmentID())
                    .setParameter(3, sexIndex);
        } else {
            if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {
                if (sexIndex == CodeConstants.MALE_INDEX) {
                    return 0;
                }


                query = em.createQuery("select count(x) from UserChooser x where  x.position like ?1 ")
                        .setParameter(1, "%" + postStr + "%");
                return (Long) query.getSingleResult();

            }
            query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?3 and x.department.pointersCode like ?1 and x.department.parent.parent.departmentID like ?2")
                    .setParameter(1, "%" + code + "%")
                    .setParameter(2, department.getDepartmentID())
                    .setParameter(3, sexIndex);
        }

        return (Long) query.getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long fillNskReport(List<String> rootStringList, Department department) {

            javax.persistence.Query query;
            if (rootStringList.contains(department.getDepartmentID())) {
                query = em.createQuery("select count(x) from UserChooser x where x.department.parent.pointersCode like ?1 and  x.department.parent.parent.parent.departmentID like ?2")
                        .setParameter(1, "%" + CodeConstants.NATSIONAL + "%")
                        .setParameter(2, department.getDepartmentID());
            } else {
                if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {

                    query = em.createQuery("select count(x) from UserChooser x where  x.department.pointersCode like ?1 and x.department.parent.pointersCode like ?2 ")
                            .setParameter(1, "%" + CodeConstants.NATSIONAL + "%")
                            .setParameter(2, "%" + CodeConstants.ZHENSKAYA_BORBA + "%");
                }else{
                    query = em.createQuery("select count(x) from UserChooser x where x.department.parent.pointersCode like ?1 and  x.department.parent.parent.departmentID like ?2")
                            .setParameter(1, "%" + CodeConstants.NATSIONAL + "%")
                            .setParameter(2, department.getDepartmentID());
                }
            }

        return (Long) query.getSingleResult();

        }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long fillAllReport(List<String> rootStringList, Department department) {

        javax.persistence.Query query;
        if (rootStringList.contains(department.getDepartmentID())) {
            query = em.createQuery("select count(x) from UserChooser x where  x.department.parent.parent.parent.departmentID like ?1")
                    .setParameter(1, department.getDepartmentID());
        } else {
            if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {

                query = em.createQuery("select count(x) from UserChooser x where   x.department.parent.pointersCode like ?1 ")
                        .setParameter(1, "%" + CodeConstants.ZHENSKAYA_BORBA + "%");
            }else{
                query = em.createQuery("select count(x) from UserChooser x where  x.department.parent.parent.departmentID like ?1")
                        .setParameter(1, department.getDepartmentID());
            }
        }

        return (Long) query.getSingleResult();
    }
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCellValue(List<String> rootStringList, String reg, Department department, boolean isCity) {

        javax.persistence.Query query;
        if (isCity) {
            if (rootStringList.contains(department.getDepartmentID())) {
                query = em.createQuery("select count(x) from UserChooser x where x.city like ?1 and x.department.parent.parent.parent.departmentID like ?2")
                        .setParameter(1, "%" + reg + "%")
                        .setParameter(2, department.getDepartmentID());
            } else {

                if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {

                    query = em.createQuery("select count(x) from UserChooser x where  x.city like ?1 and x.department.parent.pointersCode like ?2 ")
                            .setParameter(1, "%" + reg + "%")
                            .setParameter(2, "%" + CodeConstants.ZHENSKAYA_BORBA + "%");
                    return (Long) query.getSingleResult();

                }else{

                    query = em.createQuery("select count(x) from UserChooser x where x.city like ?1 and x.department.parent.parent.departmentID like ?2")
                            .setParameter(1, "%" + reg + "%")
                            .setParameter(2, department.getDepartmentID());
                }
            }

        } else {
            if (rootStringList.contains(department.getDepartmentID())) {
                query = em.createQuery("select count(x) from UserChooser x where x.region like ?1 and x.department.parent.parent.parent.departmentID like ?2")
                        .setParameter(1, "%" + reg + "%")
                        .setParameter(2, department.getDepartmentID());
            } else {
                if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {

                    query = em.createQuery("select count(x) from UserChooser x where  x.region like ?1 and x.department.parent.pointersCode like ?2 ")
                            .setParameter(1, "%" + reg + "%")
                            .setParameter(2, "%" + CodeConstants.ZHENSKAYA_BORBA + "%");
                    return (Long) query.getSingleResult();

                }else{
                    query = em.createQuery("select count(x) from UserChooser x where x.region like ?1 and x.department.parent.parent.departmentID like ?2")
                            .setParameter(1, "%" + reg + "%")
                            .setParameter(2, department.getDepartmentID());
                }
            }

        }

        return (Long) query.getSingleResult();
    }
}
