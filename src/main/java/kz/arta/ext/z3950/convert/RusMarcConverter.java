package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.Book;
import org.marc4j.marc.DataField;
import org.marc4j.marc.Record;
import org.marc4j.marc.Subfield;

import java.util.List;

/**
 * Created by timur on 09/08/2014 12:34.
 */
public class RusMarcConverter implements IMarcConverter {

    @Override
    public Book convert(Record marcRecord){
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
        return variableField != null && variableField.getSubfield(subfieldTag) !=null ? variableField.getSubfield(subfieldTag).getData() : null;
    }

    private String getSubfieldMultiData(Record marcRecord, String fieldTag, char subfieldTag) {
        DataField variableField = (DataField) marcRecord.getVariableField(fieldTag);
        if (variableField != null) {

            List<Subfield> subfields = variableField.getSubfields(subfieldTag);
            StringBuilder s = new StringBuilder();
            if (subfields != null) {
                for (Subfield subfield :subfields) {
                    s.append(subfield.getData()).append(",");
                }
            }

            return s.toString();
        }
        else return null;
    }
}
