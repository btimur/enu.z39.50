package kz.arta.ext.z3950.convert;

import info.freelibrary.marc4j.impl.RecordImpl;
import kz.arta.ext.z3950.model.*;
import kz.arta.ext.z3950.model.synergy.KeyObject;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.service.DictionaryService;
import kz.arta.ext.z3950.service.FormatFieldRepository;
import kz.arta.ext.z3950.service.SubIndexRepository;
import org.marc4j.MarcWriter;
import org.marc4j.MarcXmlWriter;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;
import org.marc4j.samples.Marc8ToUnicodeExample;

import javax.inject.Inject;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 09/08/2014 12:34.
 */
public class RusMarcConverter implements IMarcConverter {

    @Inject
    private SubIndexRepository repository;

    @Inject
    private FormatFieldRepository formatFieldRepository;

    @Inject
    private DictionaryService dictionaryService;


    private Map<String, SubIndex> subindexes;
    private Map<String, String> attributes;
    private Map<String, String> dicCodes;

    public RusMarcConverter() {
        dicCodes = new HashMap<String, String>();
        dicCodes.put("101a", "Язык основного текста");
        dicCodes.put("200b", "Материал (носитель)");
        dicCodes.put("9015", "Служебные отметки");
        dicCodes.put("908b", "Вид содержания");
        dicCodes.put("908c", "Вид содержания");
        dicCodes.put("901a", "Сигла");
    }

    @Override
    public Book convert(Record marcRecord) {
        Book book = new Book();
        book.setId(marcRecord.getControlNumberField().getData());
        book.setTitle(getSubfieldData(marcRecord, "200", 'a'));
        book.setPublishedPlace(getSubfieldData(marcRecord, "210", 'a'));
        book.setPublishedDate(getSubfieldData(marcRecord, "210", 'd'));
        book.setKeywords(getSubfieldMultiData(marcRecord, "610", 'a'));
        book.setIsbn(getSubfieldData(marcRecord, "010", 'a'));
        book.setAuthor(getSubfieldData(marcRecord, "700", 'a') + " " +
                getSubfieldData(marcRecord, "700", 'b'));
        return book;
    }

    private String getSubfieldData(Record marcRecord, String fieldTag, char subfieldTag) {
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


    @Override
    public LibraryBook reverseConvert(Record marcRecord) {
        fillSubindexes();
        LibraryBook autoreferat = new LibraryBook();
        try {
            for (PropertyDescriptor pd : Introspector.getBeanInfo(LibraryBook.class).getPropertyDescriptors()) {
                if (pd.getName().equals("class") || pd.getName().length() < 5) continue;
                String field = pd.getName().substring(1, 4);
                char subField = pd.getName().substring(4, 5).charAt(0);
                String index = null;
                if (pd.getName().contains("_")) {
                    index = pd.getName().substring(6, pd.getName().length());
                }
                String value = getSubfieldData(marcRecord, field, subField);
                if (value != null && pd.getPropertyType().equals(KeyObject.class)) {
                    String key = dictionaryService.getDictionaryKey(getDictionaryCode(field + String.valueOf(subField)),value);
                    KeyObject keyObject = new KeyObject(key, value);
                    pd.getWriteMethod().invoke(autoreferat, keyObject);
                } else if (value != null && index != null) {
                    String key = field + subField + index;
                    SubIndex subIndex = subindexes.get(key);
                    if (subIndex != null) {
                        value = value.substring(subIndex.getStart(), subIndex.getEnd() + 1).trim();
                        if (!value.isEmpty()) {
                            pd.getWriteMethod().invoke(autoreferat, value);
                        }
                    } else {
                        System.out.println("not found key " + key + "for field " + pd.getName());
                    }
                } else if(value != null){
                    pd.getWriteMethod().invoke(autoreferat, value);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return autoreferat;
    }

    private String getDictionaryCode(String field) {
        return dicCodes.get(field);
    }

    @Override
    public List<BookAttribute> loadDescr(Record record) {
        fillAttributes();
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



    private void fillSubindexes() {
        if(subindexes != null){
            return;
        }
        List<SubIndex> formatList = repository.getFormatList(FormatEnum.RUSMARC.name());
        subindexes = new HashMap<String, SubIndex>();
        for (SubIndex subIndex : formatList) {
            subindexes.put(subIndex.getField() + subIndex.getTag() + subIndex.getSubindex(), subIndex);
        }
    }

    private void fillAttributes() {
        if(attributes != null){
            return;
        }
        List<FormatField> formatList = formatFieldRepository.getSubFieldsByFormat(FormatEnum.RUSMARC.name());
        attributes = new HashMap<String, String>();
        for (FormatField format : formatList) {
            attributes.put(format.getFieldName(), format.getFieldComment());
        }
    }
}
