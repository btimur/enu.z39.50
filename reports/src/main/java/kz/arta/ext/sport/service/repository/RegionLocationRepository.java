package kz.arta.ext.sport.service.repository;

import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.RegionLocation;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by admin on 28.10.14.
 */
@Stateless
public class RegionLocationRepository {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<RegionLocation> getChilds(String parentName) {
        return em.createQuery("select x from RegionLocation x where x.parent.nameRu=?1 ", RegionLocation.class)
                .setParameter(1, parentName)
                .getResultList();
    }
}
