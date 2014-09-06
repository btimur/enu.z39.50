package kz.arta.ext.z3950.convert;

import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.FormatField;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import org.marc4j.marc.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 9/2/2014 5:11 PM.
 */
public class UsmarcConverter extends AMarcConverter {


    protected Map<String, String> fieldConvert;


    @Override
    protected String getFormat() {
        return FormatEnum.USMARC.name();
    }

    protected LibraryBook fillLibraryBook(Record marcRecord) {
        marcRecord = convertMarc21ToUnimarc(marcRecord);
        return super.fillLibraryBook(marcRecord);
    }

    protected void fillMapForConvert(String formatName) {
        if (fieldConvert != null) {
            return;
        }
        List<FormatField> formatList = formatFieldRepository.getFieldsForConvert(formatName);
        fieldConvert = new HashMap<String, String>();
        for (FormatField format : formatList) {
            fieldConvert.put(format.getFieldName(), format.getObjectField());
        }
    }

    private Record convertMarc21ToUnimarc(Record marcRecord) {
        fillMapForConvert(getFormat());
        MarcFactory marcFactory = MarcFactory.newInstance();
        Record newRecord = marcFactory.newRecord();
        newRecord.setLeader(marcRecord.getLeader());
        for (String usField : fieldConvert.keySet()) {
            String tag = usField.substring(0, 3);
            String objectField = fieldConvert.get(usField);
            String newTag = objectField.substring(0, 3);

            VariableField variableField =  marcRecord.getVariableField(tag);

            if (variableField == null) {
                continue;
            }
            VariableField field = addField(marcFactory, newRecord, newTag, variableField);

            if (usField.length() == 3) {
                continue;
            }
            char usSub = usField.substring(3, 4).charAt(0);
            char newSub = objectField.substring(3, 4).charAt(0);
            Subfield subfield = ((DataField) variableField).getSubfield(usSub);
            if (subfield != null) {
                ((DataField) field).addSubfield(marcFactory.newSubfield(newSub, subfield.getData()));
            }
        }
        return newRecord;
    }

    private VariableField addField(MarcFactory marcFactory, Record newRecord, String newTag, VariableField variableField) {
        VariableField field = newRecord.getVariableField(newTag);
        if (field == null  ) {
            if (!(variableField instanceof ControlField )) {
                field = marcFactory.newDataField(newTag, ((DataField)variableField).getIndicator1(),
                        ((DataField)variableField).getIndicator2());
                newRecord.addVariableField(field);
            }else if(variableField.getTag().equals("008")){
                field = marcFactory.newDataField(newTag, ' ',' ');
                ((DataField)field).addSubfield(marcFactory.newSubfield('a', ((ControlField) variableField).getData()));
                newRecord.addVariableField(field);
            }
            else{
                field = marcFactory.newControlField(newTag, ((ControlField) variableField).getData());
                newRecord.getControlFields().add((ControlField) field);
            }
        }
        return field;
    }


}
