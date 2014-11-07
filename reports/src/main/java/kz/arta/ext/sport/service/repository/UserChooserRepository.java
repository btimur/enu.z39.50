package kz.arta.ext.sport.service.repository;

import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.UserChooser;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by admin on 21.10.14.
 */
@Stateless
public class UserChooserRepository {
    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @return - весь список объектов "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<UserChooser> getUserChoosers() {
        return em.createQuery("select x from UserChooser x", UserChooser.class)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public  List<String> getRegionNames(String region_content) {
      return em.createQuery("select distinct (x.region) from UserChooser x where x.region like ?1")
                .setParameter(1, "%" + region_content + "%").getResultList();
    }


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void clear() {
        em.createQuery("delete from UserChooser").executeUpdate();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public UserChooser save(UserChooser obj) {
        getEm().persist(obj);
        return obj;
    }


    protected EntityManager getEm() {
        return em;
    }


}
