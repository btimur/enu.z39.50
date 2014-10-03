package kz.arta.ext.sms.service;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.sms.model.*;
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
public class SmsOrderRepository extends ARepository<SmsOrder> {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;


    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public SmsOrder findById(long id) {
        return em.createQuery("select l from SmsOrder l where l=?1", SmsOrder.class).setParameter(1, id).getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public SmsOrder findByOrderUid(String id) {
        return em.createQuery("select l from SmsOrder l where l.dataUUID=?1", SmsOrder.class).setParameter(1,id ).getSingleResult();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<String> getDistinctUserId() {

        return em.createQuery("select distinct l.userid from SmsOrder l where l.executed=true and l.sended =false ", String.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SmsOrder> getSmsOrdersByUserId(String userId) {
        return em.createQuery("select l from SmsOrder l where l.executed=true and l.sended =false and l.userid=?1", SmsOrder.class)
                .setParameter(1, userId)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SmsOrder> getSmsOrders() {
        return em.createQuery("select x from SmsOrder x", SmsOrder.class).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SmsOrder> getOrderByFilter(OrderFilterEntity orderFilterEntity) {
        if (StringUtils.isNullOrEmpty(orderFilterEntity.getTerm())) {
            return em.createQuery("select x from SmsOrder x where x.dateofvidacha between ?1 and ?2 order by x.id desc ", SmsOrder.class)
                    .setParameter(1, orderFilterEntity.getBeginDate())
                    .setParameter(2, orderFilterEntity.getEndDate())
                    .setFirstResult(orderFilterEntity.getPage() * orderFilterEntity.getPageSize())
                    .setMaxResults(orderFilterEntity.getPageSize())
                    .getResultList();
        }
        return em.createQuery("select x from SmsOrder x where x.dateofvidacha between ?1 and ?2 and (x.fio like ?3 or x.iin like ?3 or x.nameofbook like ?3 or x.invnum like ?3) order by x.id desc", SmsOrder.class)
                .setParameter(1, orderFilterEntity.getBeginDate())
                .setParameter(2, orderFilterEntity.getEndDate())
                .setParameter(3, "%" + orderFilterEntity.getTerm() + "%")
                .setFirstResult(orderFilterEntity.getPage() * orderFilterEntity.getPageSize())
                .setMaxResults(orderFilterEntity.getPageSize())
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public long getCountRecord(OrderFilterEntity orderFilterEntity) {
        javax.persistence.Query query;
        if (StringUtils.isNullOrEmpty(orderFilterEntity.getTerm())) {
            query = em.createQuery("select count(x) from SmsOrder x where x.dateofvidacha between ?1 and ?2")
                    .setParameter(1, orderFilterEntity.getBeginDate())
                    .setParameter(2, orderFilterEntity.getEndDate());
        } else {
            query = em.createQuery("select count(x) from SmsOrder x where x.dateofvidacha between ?1 and ?2 and (x.fio like ?3 or x.iin like ?3 or x.nameofbook like ?3 or x.invnum like ?3) ")
                    .setParameter(1, orderFilterEntity.getBeginDate())
                    .setParameter(2, orderFilterEntity.getEndDate())
                    .setParameter(3, "%" + orderFilterEntity.getTerm() + "%");
        }
        return (Long) query.getSingleResult();
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return SmsOrder.class;
    }

    public void updateListWtithResult(List<SmsOrder> smsOrders, boolean result) {
        for(SmsOrder smsOrder : smsOrders)
        {
            smsOrder.setSended(result);
            if(result)
            {
                smsOrder.setSendDate(new Timestamp(new Date().getTime()));
            }
            update(smsOrder);
        }
    }
}
