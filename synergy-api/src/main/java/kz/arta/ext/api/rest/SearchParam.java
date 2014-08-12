package kz.arta.ext.api.rest;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 18.04.14
 * Time: 22:14
 */
public class SearchParam {
    private String field;
    private String condition;

    public SearchParam() {
    }

    public SearchParam(String field, String condition) {
        this.field = field;
        this.condition = condition;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
