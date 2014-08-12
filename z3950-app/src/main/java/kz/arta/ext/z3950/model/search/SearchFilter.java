package kz.arta.ext.z3950.model.search;

import kz.arta.ext.z3950.model.Library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:05.
 */
public class SearchFilter {
    /**
     * библиотеки поиска
     */
    private List<Library> libraries;
    /**
     * условия поиска
     */
    private List<SearchCondition> conditions;
    /**
     * максимальный результат
     */
    private int maxResult;

    public SearchFilter() {
        conditions = new ArrayList<SearchCondition>();
        libraries = new ArrayList<Library>();
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public List<SearchCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<SearchCondition> conditions) {
        this.conditions = conditions;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public String createPrefixQueryString() {
        StringBuilder pql = new StringBuilder();
        for (SearchCondition condition :conditions) {
            pql.append(condition.toString());
        }

        return  pql.toString();
    }

    public String createCqlQueryString() {

        StringBuilder cql = new StringBuilder();
        for (SearchCondition condition :conditions) {
            cql.append(condition.toString());
        }

        return  cql.toString();
    }
}
