package kz.arta.ext.sport.model.report;

import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 22.10.14.
 */
public class ConfederationReport {

    public String name;
    public List<String> fdTitle;
    public List<String> fdRegion;
    public HashMap<String, List<Long>> records;

    public boolean isConfederation;

    public boolean isConfederation() {
        return isConfederation;
    }


    public void setConfederation(boolean isConfederation) {
        this.isConfederation = isConfederation;
    }

    public HashMap<String, List<Long>> getRecords() {
        return records;
    }

    public void setRecords(HashMap<String, List<Long>> records) {
        this.records = records;
    }

    public List<CategoryReport> categoryReports;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryReport> getCategoryReports() {
        return categoryReports;
    }

    public void setCategoryReports(List<CategoryReport> categoryReports) {
        this.categoryReports = categoryReports;
    }

    public List<String> getFdTitle() {
        return fdTitle;
    }

    public void setFdTitle(List<String> fdTitle) {
        this.fdTitle = fdTitle;
    }

    public List<String> getFdRegion() {
        return fdRegion;
    }

    public void setFdRegion(List<String> fdRegion) {
        this.fdRegion = fdRegion;
    }
}
