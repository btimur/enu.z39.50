package kz.arta.ext.sport.service.repository;

import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.service.AReportManager;
import kz.arta.ext.sport.util.CodeConstants;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by admin on 04.11.14.
 */
@Stateless
public class FederationRepository {
    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCountNskRecord(String code, String postStr,Department department, int sexIndex, boolean isFemaleWresling) {
        javax.persistence.Query query;

        if (isFemaleWresling) {
            query = em.createQuery("select count(x) from UserChooser x where  x.position like ?1 and x.department.parent.pointersCode like ?2")
                    .setParameter(1, "%" + postStr + "%")
                    .setParameter(2, "%" + CodeConstants.NATSIONAL + "%");
            return (Long) query.getSingleResult();
        }

        query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?3 and x.department.pointersCode like ?1 and x.department.parent.parent.departmentID like ?2 and x.department.parent.pointersCode like ?4 ")
                .setParameter(1, "%" + code + "%")
                .setParameter(2, department.getDepartmentID())
                .setParameter(3, sexIndex)
                .setParameter(4, "%" + CodeConstants.NATSIONAL + "%");

        return (Long) query.getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCountRecord(String city,  String code, Department department, int sexIndex, boolean isCity) {
        {
            javax.persistence.Query query;

            if (isCity) {
                query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?3 and x.department.pointersCode like ?1 and x.department.parent.parent.departmentID like ?2 and x.city like ?4")
                        .setParameter(1, "%" + code + "%")
                        .setParameter(2, department.getDepartmentID())
                        .setParameter(3, sexIndex)
                        .setParameter(4, city);
            } else {
                query = em.createQuery("select count(x) from UserChooser x where x.sexIndex=?3 and x.department.pointersCode like ?1 and x.department.parent.parent.departmentID like ?2 and x.region like ?4")
                        .setParameter(1, "%" + code + "%")
                        .setParameter(2, department.getDepartmentID())
                        .setParameter(3, sexIndex)
                        .setParameter(4, city);
            }
            return (Long) query.getSingleResult();
        }
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long femaleFight(String city, String postStr, int sexIndex, boolean isCity) {

        if (sexIndex == CodeConstants.MALE_INDEX) {
            return 0;
        }
        javax.persistence.Query query;
        if (isCity) {

            query = em.createQuery("select count(x) from UserChooser x where  x.position like ?1 and x.city like ?2")
                    .setParameter(1, "%" + postStr + "%")
                    .setParameter(2, city);

        } else {
            query = em.createQuery("select count(x) from UserChooser x where  x.position like ?1 and x.region like ?2")
                    .setParameter(1, "%" + postStr + "%")
                    .setParameter(2, city);
        }
        return (Long) query.getSingleResult();
    }

}
