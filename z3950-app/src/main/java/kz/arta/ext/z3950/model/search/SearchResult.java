package kz.arta.ext.z3950.model.search;

import org.yaz4j.Record;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:38.
 */
public class SearchResult {
    private List records;

    public SearchResult() {
        this.records = new ArrayList();
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
}
