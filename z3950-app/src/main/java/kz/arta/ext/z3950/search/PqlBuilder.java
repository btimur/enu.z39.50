package kz.arta.ext.z3950.search;

import kz.arta.ext.z3950.model.SimpleSearch;
import org.yaz4j.PrefixQuery;
import org.yaz4j.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 8/12/2014 2:51 PM.
 */
public class PqlBuilder implements IQueryBuilder {

    public static final int BIB_1_ATTR_AUTHOR = 1005;
    public static final int BIB_1_ATTR_ISSN = 8;
    public static final int BIB_1_ATTR_ISBN = 7;
    public static final int BIB_1_ATTR_PARALLEL_TITLE = 35;
    public static final int BIB_1_ATTR_PUBLISHED_YEAR = 31;
    public static final int BIB_1_ATTR_PUBLISHED_PLACE = 59;
    public static final int BIB_1_ATTR_PUBLISHED_NAME = 1018;
    public static final int BIB_1_ATTR_ANYWHERE = 1035;

    @Override
    public String createQueryString(SimpleSearch seacrh) {
        if(seacrh.getAdvancedSearch() == null || !seacrh.getAdvancedSearch()){
            return String.format("@attr 1=%d @attr 2=3 @attr 3=3 \"%s\"", BIB_1_ATTR_ANYWHERE, seacrh.getTerm());
        }else{
            List<String> conditions  = new ArrayList<String>();
            addCondition(conditions, seacrh.getIsbn(), BIB_1_ATTR_ISBN);
            addCondition(conditions, seacrh.getAddAuthor(), BIB_1_ATTR_AUTHOR);
            addCondition(conditions, seacrh.getIssn(), BIB_1_ATTR_ISSN);
            addCondition(conditions, seacrh.getParallelTitle(), BIB_1_ATTR_PARALLEL_TITLE);
            addCondition(conditions, seacrh.getPublishedYear(), BIB_1_ATTR_PUBLISHED_YEAR);
            addCondition(conditions, seacrh.getPublishedPlace(), BIB_1_ATTR_PUBLISHED_PLACE);
            addCondition(conditions, seacrh.getPublishedName(), BIB_1_ATTR_PUBLISHED_NAME);

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
        return new PrefixQuery(createQueryString(search));
    }
}
