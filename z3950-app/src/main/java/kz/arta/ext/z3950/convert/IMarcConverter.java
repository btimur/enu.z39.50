package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.BookAttribute;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import org.marc4j.marc.Record;

import java.util.List;

/**
 * Created by timur on 09/08/2014 15:48.
 */
public interface IMarcConverter {
    Book convert(Record marcRecord);

    LibraryBook reverseConvert(Record marcRecord);

    List<BookAttribute> loadDescr(Record record);
}
