package test;

import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.z3950.convert.IMarcConverter;
import kz.arta.ext.z3950.convert.UnimarcConverter;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.SubIndex;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.util.CodeConstants;
import kz.arta.ext.z3950.util.SomeMarcStreamReader;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.marc4j.MarcReader;
import org.marc4j.MarcStreamWriter;
import org.marc4j.MarcWriter;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by timur on 8/11/2014 6:43 PM.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UnimarcConverter.class})
public class TestConverter {

    private IMarcConverter converter;
    private Record record;

    @Before
    public void setUp() throws Exception {
        InputStream input = ClassLoader.getSystemResourceAsStream("4.mrc");
        MarcReader reader = new SomeMarcStreamReader(input, "cp1251");
        record = reader.next();
//        converter = new RusMarcConverter();
        UnimarcConverter c = new UnimarcConverter();
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
        field(UnimarcConverter.class, "subindexes").set(converter, subindexes);
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

    @Test
    public void testSaveMarc() throws IOException {
        InputStream input = ClassLoader.getSystemResourceAsStream("formdata.json");
        StringWriter writer = new StringWriter();
        IOUtils.copy(input, writer, CodeConstants.ENCODING_UFT8);
        FormData formData = new LibraryBookReader().parseFormData(writer.toString());
        Assert.assertNotNull(formData);
        FormFieldsWrapper fieldsWrapper = formData.convertToWrapper();
        Assert.assertNotNull(fieldsWrapper);
        Assert.assertEquals(fieldsWrapper.getFields().size(), 415);
        Assert.assertEquals(fieldsWrapper.getFormFieldMap().get("200a").getValue(), "Математические методы синтеза слоистых структур");
        Assert.assertEquals(fieldsWrapper.getFormFieldMap().get("100a(2)").getValue(), "d");


        UnimarcConverter unimarcConverter = new UnimarcConverter();
        Record record  = unimarcConverter.getMarcRecord(fieldsWrapper);
        Assert.assertNotNull(record);
        Assert.assertNotNull(record.getControlNumberField().getData(),"7d4efde7-dda2-4e8f-b276-f848639033cf");
        Assert.assertNotNull(((DataField) record.getVariableField("200")).getSubfield('a').getData(),"Математические методы синтеза слоистых структур");
        System.out.println(record.toString());

        OutputStream stream = null;
        try {
            stream = new FileOutputStream(record.getControlNumberField().getData());
            MarcWriter marcWriter = new MarcStreamWriter(stream, "UTF8");
//            MarcWriter marcWriter = new MarcXmlWriter(stream, "UTF8");
            marcWriter.write(record);
            marcWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }
}
