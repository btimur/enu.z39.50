package test;

import kz.arta.ext.z3950.convert.RusMarcConverter;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.util.RuMarcStreamReader;
import org.junit.Assert;
import org.junit.Test;
import org.marc4j.MarcReader;
import org.marc4j.marc.Record;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by timur on 8/11/2014 6:43 PM.
 */
public class TestConverter {
    @Test
    public void testRusmarc() throws FileNotFoundException {
        InputStream input = ClassLoader.getSystemResourceAsStream("4.mrc");
        MarcReader reader = new RuMarcStreamReader(input, "cp1251");
        Record record = reader.next();

        RusMarcConverter converter = new RusMarcConverter();
        Book book = converter.convert(record);
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getId());
        Assert.assertEquals(book.getId(),"239714/Ж2-99/22451");
        Assert.assertNotNull(book.getAuthor());
        Assert.assertEquals(book.getAuthor(), "Эдди С.Э.");
        Assert.assertNotNull(book.getTitle());
        Assert.assertEquals(book.getTitle(),"XML: справочник");
        Assert.assertNotNull(book.getIsbn());
        Assert.assertEquals(book.getIsbn(), "5-8046-0135-0");
        Assert.assertNotNull(book.getPublishedDate());
        Assert.assertEquals(book.getPublishedDate(),"1999");
        Assert.assertNotNull(book.getPublishedPlace());
        Assert.assertEquals(book.getPublishedPlace(), "спб. и др.");
        Assert.assertNotNull(book.getKeywords());

    }
}
