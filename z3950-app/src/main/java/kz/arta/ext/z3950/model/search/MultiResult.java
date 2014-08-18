package kz.arta.ext.z3950.model.search;

/**
 * Created by timur on 8/17/2014 6:41 PM.
 */
public class MultiResult {
    private Long libraryId;
    private Long countResult;

    public MultiResult() {
    }

    public MultiResult(Long libraryId, Long countResult) {
        this.libraryId = libraryId;
        this.countResult = countResult;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Long getCountResult() {
        return countResult;
    }

    public void setCountResult(Long countResult) {
        this.countResult = countResult;
    }
}
