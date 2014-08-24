package kz.arta.ext.z3950.rest.api;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.data.RegistryRecord;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.z3950.model.synergy.KeyObject;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.util.ApiFormField;
import kz.arta.ext.z3950.util.CodeConstants;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by timur on 08/08/2014 16:09.
 */
public class LibraryBookReader extends AFormsReader {
    @Inject
    protected Logger log;
    //    private final String formUUID;
    private String registryUUID;

    public LibraryBookReader() {
//        formUUID = ConfigReader.getPropertyValue(CodeConstants.AUTOREFERAT_FORM_UUID);
        registryUUID = ConfigReader.getPropertyValue(CodeConstants.AUTOREFERAT_REGISTRY_UUID);
    }

    public String getRegistryUUID() {
        return registryUUID;
    }

    public void setRegistryUUID(String registryUUID) {
        this.registryUUID = registryUUID;
    }

    public boolean Save(String dataUUID, LibraryBook book, RestQueryContext queryContext) throws Exception {
//        RegistryRecord registryRecord = addNewRegistryRecord(queryContext,
//                registryUUID);

        FormData formData = readFormData(queryContext, dataUUID);

        if (formData != null) {
            FormFieldsWrapper fieldsWrapper = formData.convertToWrapper();
            if (fieldsWrapper != null) {
                fillFields(book, fieldsWrapper);
                String data = fieldsWrapper.convertToData();
                log.debug("data = " + data);
                formData.setData(data);
                writeData(queryContext, formData);
                return true;
            }
        }
        return false;
    }

    private void fillFields(LibraryBook book, FormFieldsWrapper fieldsWrapper) throws IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        Map<String, FormField> fieldMap = fieldsWrapper.getFormFieldMap();
        for (PropertyDescriptor pd : Introspector.getBeanInfo(LibraryBook.class).getPropertyDescriptors()) {
            if (pd.getName().equals("class")) continue;
            if (LibraryBook.class.getDeclaredField(pd.getName()).isAnnotationPresent(ApiFormField.class)) {
                ApiFormField annotation = LibraryBook.class.getDeclaredField(pd.getName())
                        .getAnnotation(ApiFormField.class);
                if (!fieldMap.containsKey(annotation.nameField())) {

                    fieldsWrapper.addField(annotation.nameField(),
                            annotation.typeField());
                }
                FormField formField = fieldMap.get(annotation.nameField());
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
                    formField.setValue(o != null ? o.toString() : null);
                }

            }
        }

    }


}

