package test;

import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.common.util.CodeConstants;
import kz.arta.ext.z3950.convert.UnimarcConverter;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.FormatField;
import kz.arta.ext.z3950.model.SubIndex;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.service.DictionaryService;
import kz.arta.ext.z3950.service.FormatFieldRepository;
import kz.arta.ext.z3950.service.SubIndexRepository;
import kz.arta.ext.z3950.util.SomeMarcStreamReader;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.marc4j.MarcReader;
import org.marc4j.MarcStreamWriter;
import org.marc4j.MarcWriter;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.powermock.api.mockito.PowerMockito.doReturn;

/**
 * Created by timur on 8/11/2014 6:43 PM.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UnimarcConverter.class, SubIndexRepository.class, FormatFieldRepository.class})
public class ConverterTest {

    @Spy
    protected SubIndexRepository repository = new SubIndexRepository();
    @Mock
    private Logger logger;
    @Mock
    private DictionaryService dictionaryService;
    @Spy
    private FormatFieldRepository formatFieldRepository = new FormatFieldRepository();
    @Spy
    @InjectMocks
    private UnimarcConverter converter = new UnimarcConverter();

    private Record record;

    @Before
    public void setUp() throws Exception {
        String fieldsForBook = TestUtils.readResource("fieldsForBook-unimarc.json", CodeConstants.ENCODING_UFT_8);
        ObjectMapper mapper = new ObjectMapper();
        FormatField[] fields = mapper.readValue(fieldsForBook, FormatField[].class);
        List<FormatField> listForBook = new ArrayList<FormatField>();
        Collections.addAll(listForBook, fields);
        doReturn(listForBook).when(formatFieldRepository, "getFieldsForBook", FormatEnum.UNIMARC.name());


        String subfields = TestUtils.readResource("subfields-unimarc.json", CodeConstants.ENCODING_UFT_8);
        FormatField[] fieldsForAttributes = mapper.readValue(subfields, FormatField[].class);
        List<FormatField> attributes = new ArrayList<FormatField>();
        Collections.addAll(attributes, fieldsForAttributes);
        doReturn(attributes).when(formatFieldRepository, "getSubFieldsByFormat", FormatEnum.UNIMARC.name());


        InputStream input = ClassLoader.getSystemResourceAsStream("4.mrc");
        MarcReader reader = new SomeMarcStreamReader(input, "cp1251");
        record = reader.next();
        List<SubIndex> list = new ArrayList<SubIndex>();
        list.add(new SubIndex("100", 'a', 1, 0, 7));
        list.add(new SubIndex("100", 'a', 2, 8, 8));
        list.add(new SubIndex("100", 'a', 3, 9, 12));
        list.add(new SubIndex("100", 'a', 4, 13, 16));
        list.add(new SubIndex("100", 'a', 5, 17, 19));
        list.add(new SubIndex("100", 'a', 6, 20, 20));
        list.add(new SubIndex("100", 'a', 7, 21, 21));
        list.add(new SubIndex("100", 'a', 8, 22, 24));
        list.add(new SubIndex("100", 'a', 9, 25, 25));
        list.add(new SubIndex("100", 'a', 10, 26, 29));
        list.add(new SubIndex("100", 'a', 11, 30, 33));
        list.add(new SubIndex("100", 'a', 12, 34, 35));
        doReturn(list).when(repository, "getFormatList", FormatEnum.UNIMARC.name());




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
//        Assert.assertNotNull(libraryBook.getF700a());
//        Assert.assertEquals(libraryBook.getF700a().size(), 1);
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
        IOUtils.copy(input, writer, kz.arta.ext.common.util.CodeConstants.ENCODING_UFT8);
        FormData formData = new LibraryBookReader().parseFormData(writer.toString());
        Assert.assertNotNull(formData);
        FormFieldsWrapper fieldsWrapper = formData.convertToWrapper();
        Assert.assertNotNull(fieldsWrapper);
        Assert.assertEquals(fieldsWrapper.getFields().size(), 415);
        Assert.assertEquals(fieldsWrapper.getFormFieldMap().get("200a").getValue(), "Математические методы синтеза слоистых структур");
        Assert.assertEquals(fieldsWrapper.getFormFieldMap().get("100a(2)").getValue(), "d");


        UnimarcConverter unimarcConverter = new UnimarcConverter();
        Record record = unimarcConverter.getMarcRecord(fieldsWrapper);
        Assert.assertNotNull(record);
        Assert.assertNotNull(record.getControlNumberField().getData(), "7d4efde7-dda2-4e8f-b276-f848639033cf");
        Assert.assertNotNull(((DataField) record.getVariableField("200")).getSubfield('a').getData(), "Математические методы синтеза слоистых структур");
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
