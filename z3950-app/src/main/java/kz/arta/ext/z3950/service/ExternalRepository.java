package kz.arta.ext.z3950.service;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.z3950.model.External;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Класс - объект "Репозиторий Логин доступа для внешних пользователей"
 */
@Stateless
public class ExternalRepository extends ARepository<External> {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    /**
     * Поиск объекта "Конфигурация Логин доступа для внешних пользователей" по имени
     *
     * @param name - логин объекта "Конфигурация Логин доступа для внешних пользователей"
     * @return - объект "Конфигурация Логин доступа для внешних пользователей"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public External findByLogin(String name) {
        return em.createQuery("select l from External l where l.login=?1", External.class).setParameter(1, name).getSingleResult();
    }

    /**
     * Поиск объекта "Конфигурация Логин доступа для внешних пользователей" по имени
     *
     * @return - весь список объектов "Конфигурация Логин доступа для внешних пользователей"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<External> getExternalList(boolean all) {
        if (!all) {
            return em.createQuery("select x from External x where x.deleted=?1", External.class)
                    .setParameter(1, false).getResultList();
        }
        return em.createQuery("select x from External x ", External.class).getResultList();
    }


    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return External.class;
    }

}
