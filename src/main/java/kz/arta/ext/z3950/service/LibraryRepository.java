package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.Library;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by timur on 12/07/2014 23:45.
 */
@Stateless
public class LibraryRepository {

    @Inject
    protected EntityManager em;


    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void update(Library library) {
        em.merge(library);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object find(Class entityClass, Object id) {
        return em.find(entityClass, id);
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Library find(Long id) {
        return (Library) find(Library.class, id);
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
