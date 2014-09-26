package kz.arta.ext.ocr.service;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.ocr.model.RecognizeTask;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by timur on 9/25/14.
 * Репозиторий для работы с задчами
 */
@Stateless
public class RecognizeTaskRepository extends ARepository<RecognizeTask> {

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
    public RecognizeTask findById(long id) {
        return em.createQuery("select l from RecognizeTask l where l.id=?1", RecognizeTask.class)
                .setParameter(1,id).getSingleResult();
    }

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @return - весь список объектов "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<RecognizeTask> getRecognizeTasks() {
        return em.createQuery("select x from RecognizeTask x order by x.dateAdd desc ", RecognizeTask.class)
                .getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<RecognizeTask> getNotCopmleteTasks() {
        return em.createQuery("select x from RecognizeTask x where x.completed=?1 order by x.dateAdd desc", RecognizeTask.class)
                .setParameter(1, false)
                .getResultList();
    }


    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return RecognizeTask.class;
    }

}
