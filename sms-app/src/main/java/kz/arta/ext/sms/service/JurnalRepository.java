package kz.arta.ext.sms.service;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.JurnalFilterEntity;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.Order;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.util.CodeConstants;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * Created by timur on 8/28/2014 10:24 AM.
 */
public class JurnalRepository extends ARepository<Jurnal> {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     *
     * @param id - имя объекта "Конфигурация подключения к библиотеке"
     * @return - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Jurnal findById(long id) {
        return em.createQuery("select l from Jurnal l where l=?1", Jurnal.class).setParameter(1, id).getSingleResult();
    }

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     *
     * @return - весь список объектов "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Jurnal> getJurnals() {
        return em.createQuery("select x from Jurnal x", Jurnal.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Jurnal> getJurnalsByFinter(JurnalFilterEntity jurnalFilterEntity) {
        if(StringUtils.isNullOrEmpty(jurnalFilterEntity.getTerm()))
        {
            return em.createQuery("select x from Jurnal x where x.dateSend between ?1 and ?2 order by x.id desc ", Jurnal.class)
                    .setParameter(1, jurnalFilterEntity.getBeginDate())
                    .setParameter(2, jurnalFilterEntity.getEndDate())
                    .setFirstResult(jurnalFilterEntity.getPage() * jurnalFilterEntity.getPageSize())
                    .setMaxResults(jurnalFilterEntity.getPageSize())
                    .getResultList();
        }
        return em.createQuery("select x from Jurnal x where x.dateSend between ?1 and ?2 and (x.message like ?3 or x.orderBookName like ?3 or x.result like ?3) order by x.id desc", Jurnal.class)
                .setParameter(1, jurnalFilterEntity.getBeginDate())
                .setParameter(2, jurnalFilterEntity.getEndDate())
                .setParameter(3,"%"+ jurnalFilterEntity.getTerm()+"%")
                .setFirstResult(jurnalFilterEntity.getPage() * jurnalFilterEntity.getPageSize())
                .setMaxResults(jurnalFilterEntity.getPageSize())
                .getResultList();
    }
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCountRecord (JurnalFilterEntity jurnalFilterEntity) {
        javax.persistence.Query query;
        if(StringUtils.isNullOrEmpty(jurnalFilterEntity.getTerm()))
        {
            query = em.createQuery("select count(x) from Jurnal x where x.dateSend between ?1 and ?2")
                    .setParameter(1, jurnalFilterEntity.getBeginDate())
                    .setParameter(2, jurnalFilterEntity.getEndDate());
        }else{
            query =  em.createQuery("select count(x) from Jurnal x where x.dateSend between ?1 and ?2 and (x.message like ?3 or x.orderBookName like ?3 or x.result like ?3) ")
                    .setParameter(1, jurnalFilterEntity.getBeginDate())
                    .setParameter(2, jurnalFilterEntity.getEndDate())
                    .setParameter(3,"%"+ jurnalFilterEntity.getTerm()+"%");
        }
        return  (Long)query.getSingleResult();
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
