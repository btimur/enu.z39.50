package kz.arta.ext.common.service;

import kz.arta.ext.common.model.IEntity;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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
    public T save(T obj) {
        getEm().persist(obj);
        return obj;
    }

    /**
     * Изменение объекта "Конфигурация подключения к библиотеке"
     * @param obj - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public T update(T obj) {
        getEm().merge(obj);
        return obj;
    }

    /**
     * Удаление объекта "Конфигурация подключения к библиотеке"
     * @param id - идентификатор объекта "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void remove(Long id) {
        T obj = find(id);
        getEm().remove(obj);
    }

}
