package kz.arta.ext.z3950.model.search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:38.
 */
public class SearchResult {
    private List<org.marc4j.marc.Record> records;
    private long count;

    public SearchResult() {
        this.records = new ArrayList<org.marc4j.marc.Record>();
    }

    public List<org.marc4j.marc.Record> getRecords() {
        return records;
    }

    public void setRecords(List<org.marc4j.marc.Record> records) {
        this.records = records;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }
}
