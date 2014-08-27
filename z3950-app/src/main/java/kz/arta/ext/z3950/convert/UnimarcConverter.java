package kz.arta.ext.z3950.convert;

import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.BookAttribute;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import org.marc4j.marc.*;

import java.util.List;

/**
 * Created by timur on 8/26/2014 1:04 PM.
 */
public class UnimarcConverter implements IMarcConverter {

    public static final char CORRECT_RECORD = 'c';

    @Override
    public Book convert(Record marcRecord) {
        return null;
    }

    @Override
    public LibraryBook reverseConvert(Record marcRecord) {
        return null;
    }

    @Override
    public List<BookAttribute> loadDescr(Record record) {
        return null;
    }

    public Record getMarcRecord(FormFieldsWrapper fieldsWrapper) {

        MarcFactory factory = MarcFactory.newInstance();
        Record record = factory.newRecord();
        ControlField cf = factory.newControlField("001", fieldsWrapper.getUuid());
        record.addVariableField(cf);
        for (FormField formField : fieldsWrapper.getFields()) {
            String id = formField.getId();
            String val = formField.getValue();
            String first = id.substring(0, 1);
            if (!isNumber(first) || id.length() > 4 || "001".equals(id)
                    || val == null || "".equals(val.trim())){
                continue;
            }
            if(id.length() == 3){
                System.out.println(" field " + id);
                //[TODO] Доделять экспорт этих полей
                continue;
            }
            String fieldTag = id.substring(0, 3);
            DataField dataField = (DataField) record.getVariableField(fieldTag);
            if (dataField == null){
                dataField = factory.newDataField();
                dataField.setTag(fieldTag);
                record.addVariableField(dataField);
            }
            char subFieldTag = id.substring(3, 4).charAt(0);
            Subfield subfield = factory.newSubfield(subFieldTag, val);
            dataField.addSubfield(subfield);
        }

//

        return record;
    }

    private boolean isNumber(String first) {
        try{
            int i = Integer.parseInt(first);
            return i>=0;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private Leader createLeader(FormFieldsWrapper fieldsWrapper,MarcFactory factory) {
        Leader leader = factory.newLeader();
        leader.setRecordStatus(CORRECT_RECORD);

        return leader;
    }
}
