package kz.arta.ext.z3950.service;

import kz.arta.ext.common.service.ARepository;
import kz.arta.ext.z3950.model.FormatField;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by timur on 12/07/2014 23:45.
 */
@Stateless
public class FormatFieldRepository extends ARepository {

    @Inject
    protected EntityManager em;

    @Override
    protected EntityManager getEm() {
        return em;
    }

    @Override
    public Class getEntityClass() {
        return FormatField.class;
    }
    /**
     *
     * @param format
     * @return
     */
    public List<FormatField> getSubFieldsByFormat(String format) {
        return em.createQuery("select x from FormatField x where x.mformat=?1 and x.isSubField=?2", FormatField.class)
                .setParameter(1,format)
                .setParameter(2,true)
                .getResultList();
    }


}
