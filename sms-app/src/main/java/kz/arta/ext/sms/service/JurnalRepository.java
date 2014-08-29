package kz.arta.ext.sms.service;

import kz.arta.ext.sms.model.Jurnal;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by timur on 8/28/2014 10:24 AM.
 */
public class JurnalRepository extends ARepository<Library> {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @param name - имя объекта "Конфигурация подключения к библиотеке"
     * @return - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Jurnal findByName(String name) {
        return em.createQuery("select l from Library l where l.nameLib=?1", Jurnal.class).setParameter(1,name).getSingleResult();
    }

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @return - весь список объектов "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Jurnal> getJurnals() {
        return em.createQuery("select x from Jurnal x where x.enabled=?1", Jurnal.class)
                .setParameter(1, true)
                .getResultList();
    }


    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return Jurnal.class;
    }

}
