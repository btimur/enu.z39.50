package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.BookAttribute;
import kz.arta.ext.z3950.model.FormatField;
import kz.arta.ext.z3950.model.SubIndex;
import kz.arta.ext.z3950.model.synergy.KeyObject;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.service.DictionaryService;
import kz.arta.ext.z3950.service.FormatFieldRepository;
import kz.arta.ext.z3950.service.SubIndexRepository;
import kz.arta.ext.z3950.util.ApiFormField;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;

import javax.inject.Inject;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 9/3/2014 9:53 AM.
 */
public abstract class AMarcConverter implements IMarcConverter {

    @Inject
    protected SubIndexRepository repository;

    @Inject
    protected FormatFieldRepository formatFieldRepository;

    @Inject
    protected DictionaryService dictionaryService;

    public static final char CORRECT_RECORD = 'c';
    public static final String TITLE_FIELD_ALIAS = "title";
    public static final String PUBLISHED_PLACE_FIELD_ALIAS = "publishedPlace";
    public static final String PUBLISHED_DATE_FIELD_ALIAS = "publishedDate";
    public static final String KEYWORDS_FIELD_ALIAS = "keywords";
    public static final String ISBN_FIELD_ALIAS = "isbn";
    public static final String AUTHOR_SURENAME_FIELD_ALIAS = "authorSurename";
    public static final String AUTHOR_NAME_FIELD_ALIAS = "authorName";
    public static final String CONTROL_ID_TAG = "001";


    protected Map<String, SubIndex> subindexes;
    protected Map<String, String> attributes;
    protected Map<String, String> dicCodes;
    protected Map<String, String> fieldForBook;

    public AMarcConverter() {
        dicCodes = new HashMap<String, String>();
        dicCodes.put("101a", "Язык основного текста");
        dicCodes.put("200b", "Материал (носитель)");
        dicCodes.put("9015", "Служебные отметки");
        dicCodes.put("908b", "Вид содержания");
        dicCodes.put("908c", "Вид содержания");
        dicCodes.put("901a", "Сигла");
    }


    protected void fillSubindexes(String formatName) {
        if(subindexes != null){
            return;
        }
        List<SubIndex> formatList = repository.getFormatList(formatName);
        subindexes = new HashMap<String, SubIndex>();
        for (SubIndex subIndex : formatList) {
            subindexes.put(subIndex.getField() + subIndex.getTag() + subIndex.getSubindex(), subIndex);
        }
    }

    protected void fillAttributes(String formatName) {
        if(attributes != null){
            return;
        }
        List<FormatField> formatList = formatFieldRepository.getSubFieldsByFormat(formatName);
        attributes = new HashMap<String, String>();
        for (FormatField format : formatList) {
            attributes.put(format.getFieldName(), format.getFieldComment());
        }
    }

    protected void fillMapForBook(String formatName) {
        if(fieldForBook != null){
            return;
        }
        List<FormatField> formatList = formatFieldRepository.getFieldsForBook(formatName);
        fieldForBook = new HashMap<String, String>();
        for (FormatField format : formatList) {
            fieldForBook.put(format.getFieldAlias(), format.getFieldName());
        }
    }


    protected Book fillBook(Record marcRecord) {
        Book book = new Book();
        book.setId(marcRecord.getControlNumberField().getData());

        book.setTitle(getSubfieldData(marcRecord,
                fieldForBook.get(TITLE_FIELD_ALIAS).substring(0,3),
                fieldForBook.get(TITLE_FIELD_ALIAS).substring(3,4).charAt(0)));
        book.setPublishedPlace(getSubfieldData(marcRecord,
                        fieldForBook.get(PUBLISHED_PLACE_FIELD_ALIAS).substring(0,3),
                        fieldForBook.get(PUBLISHED_PLACE_FIELD_ALIAS).substring(3,4).charAt(0)));
        book.setPublishedDate(getSubfieldData(marcRecord,
                fieldForBook.get(PUBLISHED_DATE_FIELD_ALIAS).substring(0,3),
                fieldForBook.get(PUBLISHED_DATE_FIELD_ALIAS).substring(3,4).charAt(0)));
        book.setKeywords(getSubfieldMultiData(marcRecord,
                fieldForBook.get(KEYWORDS_FIELD_ALIAS).substring(0,3),
                fieldForBook.get(KEYWORDS_FIELD_ALIAS).substring(3,4).charAt(0)));
        book.setIsbn(getSubfieldData(marcRecord,
                fieldForBook.get(ISBN_FIELD_ALIAS).substring(0,3),
                fieldForBook.get(ISBN_FIELD_ALIAS).substring(3,4).charAt(0)));
        book.setAuthor(getSubfieldData(marcRecord,
                fieldForBook.get(AUTHOR_SURENAME_FIELD_ALIAS).substring(0,3),
                fieldForBook.get(AUTHOR_SURENAME_FIELD_ALIAS).substring(3,4).charAt(0))
                 + " " +
                getSubfieldData(marcRecord, fieldForBook.get(AUTHOR_SURENAME_FIELD_ALIAS).substring(0, 3),
                        fieldForBook.get(AUTHOR_NAME_FIELD_ALIAS).substring(3, 4).charAt(0)));
        return book;
    }

    protected String getSubfieldData(Record marcRecord, String fieldTag, char subfieldTag) {
        DataField variableField = (DataField) marcRecord.getVariableField(fieldTag);
        return variableField != null && variableField.getSubfield(subfieldTag) != null ? variableField.getSubfield(subfieldTag).getData() : null;
    }

    private String getSubfieldMultiData(Record marcRecord, String fieldTag, char subfieldTag) {
        DataField variableField = (DataField) marcRecord.getVariableField(fieldTag);
        if (variableField != null) {

            List<Subfield> subfields = variableField.getSubfields(subfieldTag);
            StringBuilder s = new StringBuilder();
            if (subfields != null) {
                for (Subfield subfield : subfields) {
                    s.append(subfield.getData()).append(",");
                }
            }

            return s.toString();
        } else return null;
    }


    protected LibraryBook fillLibraryBook(Record marcRecord) {
        LibraryBook libraryBook = new LibraryBook();
        try {
            for (PropertyDescriptor pd : Introspector.getBeanInfo(LibraryBook.class).getPropertyDescriptors()) {
                if (pd.getName().equals("class") || pd.getName().length() < 5) continue;
                ApiFormField annotation = LibraryBook.class.getDeclaredField(pd.getName())
                        .getAnnotation(ApiFormField.class);
                String field = pd.getName().substring(1, 4);
                char subField = pd.getName().substring(4, 5).charAt(0);
                String index = null;
                if (pd.getName().contains("_")) {
                    index = pd.getName().substring(6, pd.getName().length());
                }
                String value = getSubfieldData(marcRecord, field, subField);
                if (value != null && pd.getPropertyType().equals(KeyObject.class)) {
                    fillDictionaryValue(libraryBook, pd, field, subField, value);
                } else if (value != null && index != null) {
                    String key = field + subField + index;
                    SubIndex subIndex = subindexes.get(key);
                    if (subIndex != null) {
                        value = value.substring(subIndex.getStart(), subIndex.getEnd() + 1).trim();
                        if (!value.isEmpty()) {
                            pd.getWriteMethod().invoke(libraryBook, value);
                        }
                    } else {
                        System.out.println("not found key " + key + "for field " + pd.getName());
                    }
                } else if(value != null){
                    if (annotation !=null && annotation.isList()) {
                        List<String> list  = (List<String>) pd.getReadMethod().invoke(libraryBook);
                        if (list == null){
                            list = new ArrayList<String>();
                            pd.getWriteMethod().invoke(libraryBook, list);
                        }
                        list.add(value);
                    }else{
                        pd.getWriteMethod().invoke(libraryBook, value);
                    }
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return libraryBook;
    }

    private void fillDictionaryValue(LibraryBook libraryBook, PropertyDescriptor pd, String field, char subField, String value) throws IllegalAccessException, InvocationTargetException {
        String key = dictionaryService.getDictionaryKey(getDictionaryCode(field + String.valueOf(subField)),value);
        KeyObject keyObject = new KeyObject(key, value);
        pd.getWriteMethod().invoke(libraryBook, keyObject);
    }

    private String getDictionaryCode(String field) {
        return dicCodes.get(field);
    }


    protected List<BookAttribute> fillBookAttributes(Record record) {
        List<BookAttribute> bookAttributes = new ArrayList<BookAttribute>();
        for (String fieldKey : attributes.keySet()) {
            String field = fieldKey.substring(0, 3);
            char subField = fieldKey.substring(3, 4).charAt(0);
            String data = getSubfieldData(record, field, subField);
            if (data != null) {
                BookAttribute bookAttribute = new BookAttribute();
                bookAttribute.setNameRu(attributes.get(fieldKey));
                bookAttribute.setValueStr(data);
                bookAttributes.add(bookAttribute);
            }
        }
        return bookAttributes;
    }

    protected abstract String getFormat();

    @Override
    public Book convert(Record marcRecord) {
        fillMapForBook(getFormat());
        return fillBook(marcRecord);
    }

    @Override
    public LibraryBook reverseConvert(Record marcRecord) {
        fillSubindexes(getFormat());
        return fillLibraryBook(marcRecord);
    }

    @Override
    public List<BookAttribute> loadDescr(Record record) {
        fillAttributes(getFormat());
        return fillBookAttributes(record);
    }
}
