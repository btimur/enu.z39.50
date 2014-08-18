package kz.arta.ext.z3950.model;

import kz.arta.ext.z3950.util.ApiFormField;
import org.marc4j.marc.Record;

/**
 * Created by timur on 09/08/2014 12:17.
 */
public class Book {
    private String id;
    private String isbn;
    private String title;
    private String author;
    private String publishedDate;
    private String publishedPlace;
    private String keywords;
    private String booktype;
    private Long libraryId;
    private Record record;

    private String titleBig;
    private String published;
    private String phisical;
    private String recordPlace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPublishedPlace() {
        return publishedPlace;
    }

    public void setPublishedPlace(String publishedPlace) {
        this.publishedPlace = publishedPlace;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Long getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Long libraryId) {
        this.libraryId = libraryId;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public String getTitleBig() {
        return titleBig;
    }

    public void setTitleBig(String titleBig) {
        this.titleBig = titleBig;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getPhisical() {
        return phisical;
    }

    public void setPhisical(String phisical) {
        this.phisical = phisical;
    }

    public String getRecordPlace() {
        return recordPlace;
    }

    public void setRecordPlace(String recordPlace) {
        this.recordPlace = recordPlace;
    }
}
