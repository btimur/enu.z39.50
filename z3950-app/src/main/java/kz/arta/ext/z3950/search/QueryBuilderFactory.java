package kz.arta.ext.z3950.search;

import kz.arta.ext.z3950.model.QueryType;

/**
 * Created by timur on 8/12/2014 7:00 PM.
 */
public class QueryBuilderFactory {

    public static IQueryBuilder createBuilder(QueryType queryType){
        if (QueryType.PREFIX_QUERY.equals(queryType)){
            return new PqlBuilder();
        }else {
            return new CqlBuilder();
        }
    }
}
