package kz.arta.ext.z3950.service;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.z3950.model.SubIndex;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by timur on 12/07/2014 23:45.
 * Репозиторий для работы с  подиндексами marc  subfields
 */
@Stateless
public class SubIndexRepository extends ARepository {

    @Inject
    protected EntityManager em;

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return SubIndex.class;
    }
    /**
     *
     * @param format
     * @param field
     * @param tag
     * @return лист
     */
    public List<SubIndex> getListByFieldTag(String format, String field, char tag) {
        return em.createQuery("select x from SubIndex x where x.format=?1 and x.field=?2 and x.tag=?3", SubIndex.class)
                .setParameter(1,format)
                .setParameter(2,field)
                .setParameter(3,tag)
                .getResultList();
    }

    /**
     * Поиск объекта "Подидексов" по MARC синтаксису
     * @return - весь список объектов "Подидексове"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<SubIndex> getFormatList(String format) {
        return em.createQuery("select x from SubIndex x where x.format=?1", SubIndex.class)
                .setParameter(1,format)
                .getResultList();
    }


}
