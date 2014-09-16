package kz.arta.ext.z3950.rest.api;

import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.data.RegistryRecord;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.z3950.model.synergy.KeyObject;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.rest.ImportWrapper;
import kz.arta.ext.z3950.util.ApiFormField;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by timur on 08/08/2014 16:09.
 */
public class LibraryBookReader extends AFormsReader {
    @Inject
    protected Logger log;

    public LibraryBookReader() {}

    public ImportWrapper createBook(LibraryBook book, String registryUUID, RestQueryContext queryContext) throws Exception {

        RegistryRecord registryRecord = addNewRegistryRecord(queryContext,
                registryUUID);
        ImportWrapper wrapper = new ImportWrapper(registryRecord.getDataUUID(), registryRecord.getDocumentID());
        if(registryRecord.getErrorCode()!= null && !registryRecord.getErrorCode().equals("0")){
            throw new Exception("error create registry record  - "+ registryUUID);
        }
        FormData formData = readFormData(queryContext, registryRecord.getDataUUID());

        if (formData != null) {
            FormFieldsWrapper fieldsWrapper = formData.convertToWrapper();
            if (fieldsWrapper != null) {
                fillFields(book, fieldsWrapper);
                clearNullValues(fieldsWrapper);
                String data = fieldsWrapper.convertToData();
                log.debug("data = {}", data);
                formData.setData(data);
                writeData(queryContext, formData);
            }
        }
        return wrapper;
    }

    private void clearNullValues(FormFieldsWrapper fieldsWrapper) {
        Iterator<FormField> i = fieldsWrapper.getFields().iterator();
        while (i.hasNext()) {
            FormField formField = i.next();
            if (StringUtils.isNullOrEmpty(formField.getValue()) &&
                    formField.getData() == null){
                i.remove();
            }
        }
    }

    private void fillFields(LibraryBook book, FormFieldsWrapper fieldsWrapper) throws IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        Map<String, Integer> listFields = new HashMap<String, Integer>();
        Map<String, FormField> fieldMap = fieldsWrapper.getFormFieldMap();
        for (PropertyDescriptor pd : Introspector.getBeanInfo(LibraryBook.class).getPropertyDescriptors()) {
            if (pd.getName().equals("class")) continue;
            if (LibraryBook.class.getDeclaredField(pd.getName()).isAnnotationPresent(ApiFormField.class)) {
                    ApiFormField annotation = LibraryBook.class.getDeclaredField(pd.getName())
                            .getAnnotation(ApiFormField.class);
                String nameField = annotation.nameField();
                if (!fieldMap.containsKey(nameField)) {

                    if(!annotation.isList()) {
                        fieldsWrapper.addField(nameField, annotation.typeField());
                    }else{
                        Integer index = listFields.get(nameField);
                        if(index == null){
                            index = 1;
                           listFields.put(nameField, index);
                        }
                        nameField = nameField + "-b" + index;
                        fieldsWrapper.addParentField(annotation.parentTable(), nameField, annotation.typeField());
                    }
                }
                FormField formField = fieldMap.get(nameField);
                Object o = pd.getReadMethod().invoke(book);
                if (pd.getPropertyType().equals(KeyObject.class)) {
                    formField.setValue(o != null ? ((KeyObject) o).getNameRu() : null);
                    formField.setKey(o != null ? ((KeyObject) o).getKey() : null);
                }
//                else if(pd.getPropertyType().equals(Timestamp.class)){
//                    Timestamp t = (Timestamp) o;
//                    if (t != null) {
//                        formField.setValue(sfDate.format(t));
//                        formField.setKey(sfDateTime.format(t));
//                        formField.setTimestamp(String.valueOf(t.getTime()));
//                        formField.setValueDefault(sfDateTime.format(t));
//                    }
//                }
                else {
                    if (!annotation.isList()) {
                        formField.setValue(o != null ? o.toString() : null);
                    }else if (o !=null && annotation.isList()){
                        List<String> list = (List<String>) o;
                        formField.setValue(list.get(listFields.get(nameField.substring(0,4)) - 1));
                    }
                }

            }
        }

    }

    public String[] getDataUUID(String registryFormUUID, RestQueryContext queryContext) throws IOException {
        String query = "/rest/api/asforms/search?formUUID=" + registryFormUUID + "&type=partial";
        String result = doGetQuery(queryContext, query);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result, String[].class);
    }
}

