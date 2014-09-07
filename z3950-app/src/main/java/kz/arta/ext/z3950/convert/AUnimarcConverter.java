package kz.arta.ext.z3950.convert;

import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.common.util.StringUtils;
import org.marc4j.marc.*;

/**
 * Created by timur on 09/08/2014 12:34.
 */
public abstract class AUnimarcConverter extends AMarcConverter {

    public Record getMarcRecord(FormFieldsWrapper fieldsWrapper) {

        MarcFactory factory = MarcFactory.newInstance();
        Record record = factory.newRecord();
        ControlField cf = factory.newControlField(CONTROL_ID_TAG, fieldsWrapper.getUuid());
        record.addVariableField(cf);
        for (FormField formField : fieldsWrapper.getFormFieldMap().values()) {
            String id = formField.getId();
            String val = formField.getValue();
            String first = id.substring(0, 1);
            if (!StringUtils.isNumber(first) || CONTROL_ID_TAG.equals(id)       //id.length() > 4 ||
                    || val == null || "".equals(val.trim())) {
                continue;
            }
            if (id.length() == 3) {
                System.out.println(" field " + id);
                //[TODO] Доделять экспорт  полей 4XX
                continue;
            }
            String fieldTag = id.substring(0, 3);
            DataField dataField = (DataField) record.getVariableField(fieldTag);
            if (dataField == null) {
                char ind1 = ' ';
                if (fieldTag.equals("200")){
                    ind1 = '1';
                }
                char ind2 = ' ';
                if (fieldTag.equals("700")){
                    ind2 = '1';
                }

                //todo !!! идентификаторы для полей
                dataField = factory.newDataField(fieldTag, ind1, ind2);
//                dataField.setTag(fieldTag);
                record.addVariableField(dataField);
            }
            char subFieldTag = id.substring(3, 4).charAt(0);
            Subfield subfield = factory.newSubfield(subFieldTag, val);
            dataField.addSubfield(subfield);
        }
        return record;
    }
}
