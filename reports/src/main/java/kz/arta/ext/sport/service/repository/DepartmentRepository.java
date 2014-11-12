package kz.arta.ext.sport.service.repository;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.util.CodeConstants;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

/**
 * Created by admin on 20.10.14.
 */

/**
 * Created by timur on 8/28/2014 10:24 AM.
 */
@Stateless
public class DepartmentRepository {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Department> getDepartments() {
        return em.createQuery("select x from Department x", Department.class)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Department> getChilds(String parentId) {
        return em.createQuery("select x from Department x where x.parent.departmentID=?1 ", Department.class)
                .setParameter(1, parentId)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Department> getSubFederation(List<String> subFederetionList) {
        return    em.createQuery("select x from Department x where x.pointersCode IN ?1 ", Department.class)
                .setParameter(1, subFederetionList)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void clear() {
//        Department parent = find(CodeConstants.ROOT_DEPARTMENT);
//        getEm().remove(parent);
        List<String> departmentList = em.createNativeQuery("SELECT DEPARTMENT_ID FROM spt_department where DEPARTMENT_ID not in (select x.DEPARTMENT_ID from spt_department as x " +
                "where x.DEPARTMENT_ID  IN " +
                "(select PARENT_ID from spt_department))").getResultList();
        if(departmentList==null || departmentList.size()==0)
        {
            return;
        }
            em.createQuery("delete from Department x where x.departmentID IN (?1)")
                    .setParameter(1,departmentList)
                    .executeUpdate();
        clear();
//            em.createQuery("delete from Department").executeUpdate();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Department save(Department obj) {
            getEm().persist(obj);
        return obj;

    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Department update(Department obj) {
        getEm().merge(obj);
        return obj;
    }

    protected EntityManager getEm() {
        return em;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Department find(String departmentId) {
        List<Department> departments = em.createQuery("select l from Department l where l.departmentID=?1", Department.class).setParameter(1, departmentId).getResultList();
        if (departments == null || departments.size() == 0) {
            return null;
        }
        return departments.get(0);
    }
}
