package kz.arta.ext.sport.service.repository;

import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.service.AReportManager;
import kz.arta.ext.sport.util.CodeConstants;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by admin on 04.11.14.
 */
@Stateless
public class RegionReportRepository {
    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCategoryCountRecord(List<String> rootStringList, String postStr, String code, int sexIndex, String regionName, Department department) {
        javax.persistence.Query query;
        if (rootStringList.contains(department.getDepartmentID())) {
            query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?1  and x.region like ?2 and x.department.pointersCode like ?3 and x.department.parent.parent.parent.departmentID like ?4")
                    .setParameter(1, sexIndex)
                    .setParameter(2, "%" + regionName + "%")
                    .setParameter(3, "%" + code + "%")
                    .setParameter(4, department.getDepartmentID());
        } else {
            if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {
                if (sexIndex == CodeConstants.MALE_INDEX) {
                    return 0;
                }
                query = em.createQuery("select count(x) from UserChooser x where  x.position like ?1 and x.region like ?2")
                        .setParameter(1, "%" + postStr + "%")
                        .setParameter(2, "%" + regionName + "%");
                return (Long) query.getSingleResult();
            }
            query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?1  and x.region like ?2 and x.department.pointersCode like ?3 and x.department.parent.parent.departmentID like ?4")
                    .setParameter(1, sexIndex)
                    .setParameter(2, "%" + regionName + "%")
                    .setParameter(3, "%" + code + "%")
                    .setParameter(4, department.getDepartmentID());

        }
        return (Long) query.getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCityCountRecord(String city,  String postStr, String code, int sexIndex, String regionName, Department department) {
        javax.persistence.Query query;
        if (department.getPointersCode().equals(CodeConstants.ZHENSKAYA_BORBA)) {
            if (sexIndex == CodeConstants.MALE_INDEX) {
                return 0;
            }
            query = em.createQuery("select count(x) from UserChooser x where  x.position like ?1 and x.subRegion like ?2 and x.region like ?3 ")
                    .setParameter(1, "%" + postStr + "%")
                    .setParameter(2, "%" + city + "%")
                    .setParameter(3, "%" + regionName + "%");
            return (Long) query.getSingleResult();
        }
        query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?1 and x.subRegion like ?2 and x.region like ?3 and x.department.pointersCode like ?4 and x.department.parent.parent.departmentID like ?5")
                .setParameter(1, sexIndex)
                .setParameter(2, "%" + city + "%")
                .setParameter(3, "%" + regionName + "%")
                .setParameter(4, "%" + code + "%")
                .setParameter(5, department.getDepartmentID());
        return (Long) query.getSingleResult();
    }
}
