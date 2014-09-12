package kz.arta.ext.z3950.search;

import kz.arta.ext.z3950.model.search.SimpleSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaz4j.CQLQuery;
import org.yaz4j.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 8/12/2014 5:38 PM.
 */
public class CqlBuilder implements IQueryBuilder {

    private Logger log = LoggerFactory.getLogger(CqlBuilder.class);

    @Override
    public String createQueryString(SimpleSearch search) {
        if (search.getAdvancedSearch() == null || !search.getAdvancedSearch()) {
            return search.getTerm();
        } else {
            List<String> conditions = new ArrayList<String>();

            StringBuilder ql = new StringBuilder();
            for (int i = 0; i < conditions.size(); i++) {
                if (i < conditions.size() - 1) {
                    ql.append("@and ");
                }
                ql.append(conditions.get(i)).append(" ");
            }
            return ql.toString().trim();
        }
    }

    @Override
    public Query createQuery(SimpleSearch search) {
        String queryString = createQueryString(search);
        log.info("pql find {}", queryString);
        return new CQLQuery(queryString);
    }
}
