package kz.arta.ext.z3950.model.search;

import java.util.List;

/**
 * Created by timur on 30/07/2014 23:46.
 */
public class SimpleSearch {
    private String term;
    /**
     * коллективный автор 701b
     */
    private String addAuthor;
    /**
     * параллельное заглавие 200d
     */
    private String parallelTitle;
    /**
     * год издания 210d
     */
    private String publishedYear;
    /**
     * издательство 210c
     */
    private String publishedName;
    /**
     * место издания 210a
     */
    private String publishedPlace;
    /**
     * общие примечания 300a
     */
    private String commoonSubject;
    /**
     * ключевое слово 610a
     */
    private String keyword;
    /**
     * Номер ISSN 022a
     */
    private String issn;
    /**
     * Номер ISBN 010a
     */
    private String isbn;

    private Boolean advancedSearch;

    /**
     * максимальный результат
     */
    private int maxResult;

    /**
     * максимальный результат
     */
    private long libraryId;

    private String booktype;

    public Boolean getAdvancedSearch() {
        return advancedSearch;
    }

    public void setAdvancedSearch(Boolean advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getAddAuthor() {
        return addAuthor;
    }

    public void setAddAuthor(String addAuthor) {
        this.addAuthor = addAuthor;
    }

    public String getParallelTitle() {
        return parallelTitle;
    }

    public void setParallelTitle(String parallelTitle) {
        this.parallelTitle = parallelTitle;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(String publishedYear) {
        this.publishedYear = publishedYear;
    }

    public String getPublishedName() {
        return publishedName;
    }

    public void setPublishedName(String publishedName) {
        this.publishedName = publishedName;
    }

    public String getPublishedPlace() {
        return publishedPlace;
    }

    public void setPublishedPlace(String publishedPlace) {
        this.publishedPlace = publishedPlace;
    }

    public String getCommoonSubject() {
        return commoonSubject;
    }

    public void setCommoonSubject(String commoonSubject) {
        this.commoonSubject = commoonSubject;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(long libraryId) {
        this.libraryId = libraryId;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
}
