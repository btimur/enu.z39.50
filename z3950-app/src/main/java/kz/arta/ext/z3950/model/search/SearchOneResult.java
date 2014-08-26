package kz.arta.ext.z3950.model.search;

import kz.arta.ext.z3950.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 8/24/2014 4:28 PM.
 */
public class SearchOneResult {
    private List<Book> books;
    private long count;

    public SearchOneResult() {
        books = new ArrayList<Book>();
        count = 0L;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
