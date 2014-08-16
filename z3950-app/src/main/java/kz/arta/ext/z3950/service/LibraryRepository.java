package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.QueryType;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Класс - объект "Репозиторий конфигураций подключения к библиотекам"
 */
@Stateless
public class LibraryRepository extends ARepository<Library> {

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
    public Library findByName(String name) {
        return em.createQuery("select l from Library l where l.nameLib=?1", Library.class).setParameter(1,name).getSingleResult();
    }

    /**
     * Поиск объекта "Конфигурация подключения к библиотеке" по имени
     * @return - весь список объектов "Конфигурация подключения к библиотеке"
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Library> getLibraryList() {
        return em.createQuery("select x from Library x", Library.class).getResultList();
    }

    public Library getDefaultLibrary() {
        Library library = new Library();
        library.setZhost("193.233.14.5");
        library.setZport(9999);
        library.setZdb("katb");
        library.setzFormat(FormatEnum.RUSMARC.name());
        library.setEncoding("cp1251");
        library.setQueryType(QueryType.PREFIX_QUERY.name());
        return library;
    }

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return Library.class;
    }

}
