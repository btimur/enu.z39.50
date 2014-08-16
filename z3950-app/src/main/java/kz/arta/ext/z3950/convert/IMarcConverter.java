package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.synergy.ABook;
import org.marc4j.marc.Record;

/**
 * Created by timur on 09/08/2014 15:48.
 */
public interface IMarcConverter {
    Book convert(Record marcRecord);

    ABook reverseConvert(Record marcRecord);
}
