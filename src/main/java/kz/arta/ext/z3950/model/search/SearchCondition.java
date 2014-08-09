package kz.arta.ext.z3950.model.search;

/**
 * Created by timur on 25/07/2014 12:17.
 */
public class SearchCondition {
    private String field;
    private String match;
    private SearchOperator operator;
    private String cql;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public SearchOperator getOperator() {
        return operator;
    }

    public void setOperator(SearchOperator operator) {
        this.operator = operator;
    }

    public String getCql() {
        return cql;
    }

    public void setCql(String cql) {
        this.cql = cql;
    }

    @Override
    public String toString() {
//        return "@" + field + "";
//        return "@attr 1=1003 @attr 5=1 \"Толстой\"";
        return cql;
//        return "@attr 1=7 0253333490";
//        return "\"bob dylan\"";
    }
}
