package test;

import kz.arta.ext.z3950.convert.IMarcConverter;
import kz.arta.ext.z3950.convert.RusMarcConverter;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.SubIndex;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.util.RuMarcStreamReader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.marc4j.MarcReader;
import org.marc4j.marc.Record;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by timur on 8/11/2014 6:43 PM.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({RusMarcConverter.class})
public class TestConverter {

    private IMarcConverter converter;
    private Record record;

    @Before
    public void setUp() throws Exception {
        InputStream input = ClassLoader.getSystemResourceAsStream("4.mrc");
        MarcReader reader = new RuMarcStreamReader(input, "cp1251");
        record = reader.next();
//        converter = new RusMarcConverter();
        RusMarcConverter c = new RusMarcConverter();
        converter = spy(c);
        doNothing().when(converter, "fillSubindexes");

        Map<String, SubIndex> subindexes = new HashMap<String, SubIndex>();
        subindexes.put("100a1", new SubIndex("100", 'a', 1, 0, 7));
        subindexes.put("100a2", new SubIndex("100", 'a', 2, 8, 8));
        subindexes.put("100a3", new SubIndex("100", 'a', 3, 9, 12));
        subindexes.put("100a4", new SubIndex("100", 'a', 4, 13, 16));
        subindexes.put("100a5", new SubIndex("100", 'a', 5, 17, 19));
        subindexes.put("100a6", new SubIndex("100", 'a', 6, 20, 20));
        subindexes.put("100a7", new SubIndex("100", 'a', 7, 21, 21));
        subindexes.put("100a8", new SubIndex("100", 'a', 8, 22, 24));
        subindexes.put("100a9", new SubIndex("100", 'a', 9, 25, 25));
        subindexes.put("100a10", new SubIndex("100", 'a', 10, 26, 29));
        subindexes.put("100a11", new SubIndex("100", 'a', 11, 30, 33));
        subindexes.put("100a12", new SubIndex("100", 'a', 12, 34, 35));
        field(RusMarcConverter.class, "subindexes").set(converter, subindexes);
    }

    @Test
    public void testRusmarc() {

        Book book = converter.convert(record);
        Assert.assertNotNull(book);
        Assert.assertNotNull(book.getId());
        Assert.assertEquals(book.getId(), "239714/Ж2-99/22451");
        Assert.assertNotNull(book.getAuthor());
        Assert.assertEquals(book.getAuthor(), "Эдди С.Э.");
        Assert.assertNotNull(book.getTitle());
        Assert.assertEquals(book.getTitle(), "XML: справочник");
        Assert.assertNotNull(book.getIsbn());
        Assert.assertEquals(book.getIsbn(), "5-8046-0135-0");
        Assert.assertNotNull(book.getPublishedDate());
        Assert.assertEquals(book.getPublishedDate(), "1999");
        Assert.assertNotNull(book.getPublishedPlace());
        Assert.assertEquals(book.getPublishedPlace(), "спб. и др.");
        Assert.assertNotNull(book.getKeywords());

    }

    @Test
    public void testReverse() {
        LibraryBook libraryBook = converter.reverseConvert(record);
        Assert.assertNotNull(libraryBook);
        Assert.assertNotNull(libraryBook.getF010a());
        Assert.assertEquals(libraryBook.getF010a(), "5-8046-0135-0");
        Assert.assertNotNull(libraryBook.getF700a());
        Assert.assertEquals(libraryBook.getF700a(), "Эдди");//"Эдди С.Э."
        Assert.assertNotNull(libraryBook.getF200a());
        Assert.assertEquals(libraryBook.getF200a(), "XML: справочник");
        Assert.assertNotNull(libraryBook.getF210d());
        Assert.assertEquals(libraryBook.getF210d(), "1999");
        Assert.assertNotNull(libraryBook.getF210a());
        Assert.assertEquals(libraryBook.getF210a(), "спб. и др.");

    }

    @Test
    public void testSubIndex() throws Exception {
        LibraryBook libraryBook = converter.reverseConvert(record);
        Assert.assertNotNull(libraryBook);
        Assert.assertNotNull(libraryBook.getF100a());
        Assert.assertEquals(libraryBook.getF100a(), "19991214d1999    |||y1rusy0204    ca");
        Assert.assertNotNull(libraryBook.getF100a_1());
        Assert.assertEquals(libraryBook.getF100a_1(), "19991214");
        Assert.assertNotNull(libraryBook.getF100a_2());
        Assert.assertEquals(libraryBook.getF100a_2(), "d");
        Assert.assertNotNull(libraryBook.getF100a_3());
        Assert.assertEquals(libraryBook.getF100a_3(), "1999");
        Assert.assertNull(libraryBook.getF100a_4());
        Assert.assertNotNull(libraryBook.getF100a_5());
        Assert.assertEquals(libraryBook.getF100a_5(), "|||");
        Assert.assertNotNull(libraryBook.getF100a_6());
        Assert.assertEquals(libraryBook.getF100a_6(), "y");
        Assert.assertNotNull(libraryBook.getF100a_7());
        Assert.assertEquals(libraryBook.getF100a_7(), "1");
        Assert.assertNotNull(libraryBook.getF100a_8());
        Assert.assertEquals(libraryBook.getF100a_8(), "rus");
        Assert.assertNotNull(libraryBook.getF100a_9());
        Assert.assertEquals(libraryBook.getF100a_9(), "y");
        Assert.assertNotNull(libraryBook.getF100a_10());
        Assert.assertEquals(libraryBook.getF100a_10(), "0204");
        Assert.assertNull(libraryBook.getF100a_11());
        Assert.assertNotNull(libraryBook.getF100a_12());
        Assert.assertEquals(libraryBook.getF100a_12(), "ca");
    }
}
