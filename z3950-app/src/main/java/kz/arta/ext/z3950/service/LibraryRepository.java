package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.Library;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Класс - объект "Конфигурация подключения к библиотеке"
 */
@Stateless
public class LibraryRepository {

    /**
     * Менеджер JPA
     */
    @Inject
    protected EntityManager em;

    /**
     * Сохранение объекта "Конфигурация подключения к библиотеке"
     * @param library - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void save(Library library) {
        em.persist(library);
    }

    /**
     * Изменение объекта "Конфигурация подключения к библиотеке"
     * @param library - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void update(Library library) {
        em.merge(library);
    }

    /**
     * Поиск объекта JPA по идентификатору
     * @param entityClass - имя класса
     * @param id - идентификатор объекта
     * @return - объект JPA
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object find(Class entityClass, Object id) {
        return em.find(entityClass, id);
    }

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по идентификатору
     * @param id - идентификатор объекта "Конфигурация подключения к библиотеке"
     * @return - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Library find(Long id) {
        return (Library) find(Library.class, id);
    }

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @param name - имя объекта "Конфигурация подключения к библиотеке"
     * @return - объект "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Library findByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Library> criteria = builder.createQuery( Library.class );
        Root<Library> libRoot = criteria.from( Library.class );
        criteria.select( libRoot );
        criteria.where( builder.equal(libRoot.get(Library.FILDNAME_LIBNAME), name) );
        List<Library> libraryList = em.createQuery( criteria ).setMaxResults(1).getResultList();
        return libraryList.size() > 0 ? libraryList.get(0) : null;
    }

    public Library getDefaultLibrary() {
        Library library = new Library();
        library.setZhost("193.233.14.5");
        library.setZport(9999);
        library.setZdb("katb");
        library.setzFormat(FormatEnum.RUSMARC);
        library.setEncoding("cp1251");
        return library;
    }
}
