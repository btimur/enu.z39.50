package kz.arta.ext.z3950.model;

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
    private String libraryCode;
    private Object rec;


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

    public String getLibraryCode() {
        return libraryCode;
    }

    public void setLibraryCode(String libraryCode) {
        this.libraryCode = libraryCode;
    }

    public Object getRec() {
        return rec;
    }

    public void setRec(Object rec) {
        this.rec = rec;
    }
}
