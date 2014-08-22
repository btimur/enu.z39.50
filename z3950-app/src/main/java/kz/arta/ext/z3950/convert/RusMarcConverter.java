package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.*;
import kz.arta.ext.z3950.model.synergy.KeyObject;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.service.FormatFieldRepository;
import kz.arta.ext.z3950.service.SubIndexRepository;
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
 * Created by timur on 09/08/2014 12:34.
 */
public class RusMarcConverter implements IMarcConverter {

    @Inject
    private SubIndexRepository repository;

    @Inject
    private FormatFieldRepository formatFieldRepository;


    private Map<String, SubIndex> subindexes;
    private Map<String, String> attributes;

    public RusMarcConverter() {

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
                if (pd.getPropertyType().equals(KeyObject.class)) {
                    //todo сопоставление справочников
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
                } else {
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
