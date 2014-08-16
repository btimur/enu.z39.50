package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.model.IEntity;
import kz.arta.ext.z3950.model.Library;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by timur on 8/15/2014 5:23 PM.
 */
public abstract class ARepository<T extends IEntity> {

    /**
     * возращает inject Entity Manager
     * @return Entity Manager
     */
    protected abstract EntityManager getEm();

    /**
     * Тип класс ( не пашет что-то с generic t.class  -> .NET рулит)
     * @return класс Entity
     */
    public abstract Class<T> getEntityClass();
    /**
     * Поиск объекта JPA по идентификатору
     *
     * @param id - идентификатор объекта
     * @return - объект JPA
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public T find(long id) {
        return getEm().find(getEntityClass(), id);
    }



    /**
     * Сохранение объекта "Конфигурация подключения к библиотеке"
     * @param obj - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void save(T obj) {
        getEm().persist(obj);
    }

    /**
     * Изменение объекта "Конфигурация подключения к библиотеке"
     * @param obj - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void update(T obj) {
        getEm().merge(obj);
    }

}
