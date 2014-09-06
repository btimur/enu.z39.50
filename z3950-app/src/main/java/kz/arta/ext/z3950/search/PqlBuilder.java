package kz.arta.ext.z3950.search;

import kz.arta.ext.z3950.model.search.SimpleSearch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.yaz4j.PrefixQuery;
import org.yaz4j.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 8/12/2014 2:51 PM.
 */
public class PqlBuilder implements IQueryBuilder {

//    public static final int BIB_1_ATTR_AUTHOR = 1005;
    public static final int BIB_1_ATTR_AUTHOR = 1003;
    public static final int BIB_1_ATTR_ISSN = 8;
    public static final int BIB_1_ATTR_ISBN = 7;
    public static final int BIB_1_ATTR_PARALLEL_TITLE = 35;
    public static final int BIB_1_ATTR_PUBLISHED_YEAR = 31;
    public static final int BIB_1_ATTR_PUBLISHED_PLACE = 59;
    public static final int BIB_1_ATTR_PUBLISHED_NAME = 1018;
    public static final int BIB_1_ATTR_ANYWHERE = 1035;
    public static final int BIB_1_ATTR_ANY = 1016;


    private Logger log = LogManager.getLogger(PqlBuilder.class);

    @Override
    public String createQueryString(SimpleSearch search) {
        if(search.getAdvancedSearch() == null || !search.getAdvancedSearch()){
//            return String.format("@attr 1=%d @attr 2=3 @attr 3=3 \"%s\"", BIB_1_ATTR_ANYWHERE, seacrh.getTerm());
            return String.format("@attr 1=%d @attr 5=1 \"%s\"", BIB_1_ATTR_ANY, search.getTerm());
        }else{
            List<String> conditions  = new ArrayList<String>();
            addCondition(conditions, search.getIsbn(), BIB_1_ATTR_ISBN);
            addCondition(conditions, search.getAddAuthor(), BIB_1_ATTR_AUTHOR);
            addCondition(conditions, search.getIssn(), BIB_1_ATTR_ISSN);
            addCondition(conditions, search.getParallelTitle(), BIB_1_ATTR_PARALLEL_TITLE);
            addCondition(conditions, search.getPublishedYear(), BIB_1_ATTR_PUBLISHED_YEAR);
            addCondition(conditions, search.getPublishedPlace(), BIB_1_ATTR_PUBLISHED_PLACE);
            addCondition(conditions, search.getPublishedName(), BIB_1_ATTR_PUBLISHED_NAME);

            StringBuilder ql = new StringBuilder();
            for (int i = 0; i < conditions.size(); i++) {
                if (i < conditions.size() - 1){
                    ql.append("@and ");
                }
                ql.append(conditions.get(i)).append(" ");
            }
            return ql.toString().trim();
        }
    }

    private void addCondition(List<String> conditions, String term, int attribute) {
        if (term != null && term.trim().length() > 0){
            conditions.add(String.format("@attr 1=%d \"%s\"", attribute,  term));
        }
    }

    @Override
    public Query createQuery(SimpleSearch search) {
        String queryString = createQueryString(search);
        log.info("pql find {0}", queryString);
        return new PrefixQuery(queryString);
    }
}
