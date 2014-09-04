package kz.arta.ext.sms.service;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.sms.model.SmsGate;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by timur on 8/28/2014 10:24 AM.
 */
public class SmsGateRepository  extends ARepository<SmsGate> {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @param id - имя объекта "Конфигурация подключения к библиотеке"
     * @return - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public SmsGate findById(long id) {
        return em.createQuery("select l from SmsGate l where l.id=?1", SmsGate.class).setParameter(1,id).getSingleResult();
    }

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @return - весь список объектов "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SmsGate> getSmsGates() {
        return em.createQuery("select x from SmsGate x where x.enabled=?1 order by x.sOrder", SmsGate.class)
                .setParameter(1, true)
                .getResultList();
    }



    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return SmsGate.class;
    }

}
