package kz.arta.ext.z3950.search;

import kz.arta.ext.z3950.model.SimpleSearch;
import org.yaz4j.Query;

/**
 * Created by timur on 8/12/2014 5:38 PM.
 */
public interface IQueryBuilder {
    String createQueryString(SimpleSearch seacrh);

    Query createQuery(SimpleSearch search);
}
