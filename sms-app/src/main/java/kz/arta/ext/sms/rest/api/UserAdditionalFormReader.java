package kz.arta.ext.sms.rest.api;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.data.User;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.CodeConstants;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.model.synergy.UserChooser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectReader;
import org.slf4j.ILoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 05.09.14.
 * считывает с Synergy дополнительые сведения пользователя
 */
public class UserAdditionalFormReader extends AFormsReader {

    public static final String TELEPHONE = ConfigReader.getPropertyValue("user.additional.phones.field");
    public static final String CMP_LG67BO = ConfigReader.getPropertyValue("user.additional.iin.field");
    public static final String PHONES_SPLIT = ";";


    public UserAdditionalForm getForm(RestQueryContext context, String userId) throws IOException {
        UserAdditionalForm userAdditionalForm = getUserAdditionalForm(context, userId);

        if (userAdditionalForm == null || userAdditionalForm.getDataUuid() == null) {
            return null;
        }
        if (fillUseradditionalForm(context, userAdditionalForm)) {
            return null;
        }
        fillFio(context, userId, userAdditionalForm);
        return userAdditionalForm;
    }

    private void fillFio(RestQueryContext context, String userId, UserAdditionalForm userAdditionalForm) throws IOException {
        User user = GetUserById(context, userId);
        if (user != null) {
            String fullName = user.getLastname() + " " + user.getFirstname() + " " + user.getPatronymic();
            userAdditionalForm.setFullName(fullName);
        }
    }

    private boolean fillUseradditionalForm(RestQueryContext context, UserAdditionalForm userAdditionalForm) {
        FormFieldsWrapper wrapper = readFormData(context, userAdditionalForm.getDataUuid()).convertToWrapper();
        FormField phoneField = wrapper.getFormFieldMap().get(TELEPHONE);
        String iinValue = wrapper.getFormFieldMap().get(CMP_LG67BO).getValue();

        if (phoneField == null || StringUtils.isNullOrEmpty(phoneField.getValue())) {
            return true;
        }

        String[] phones = getPhones(phoneField.getValue());
        userAdditionalForm.setPhones(phones);
        userAdditionalForm.setIin(iinValue);
        return false;
    }

    private UserAdditionalForm getUserAdditionalForm(RestQueryContext context, String userId) throws IOException {
        String query = "/rest/api/personalrecord/forms/" + userId;
        String resultData = doGetQuery(context, query);
        resultData = resultData.replace("[", "").replace("]", "");

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(resultData, UserAdditionalForm.class);
    }

    private String[] getPhones(String value) {
        value = value.trim();
        return value.contains(PHONES_SPLIT) ? value.split(PHONES_SPLIT) : new String[]{value};
    }

    public UserChooser[] getListUser(String value) throws IOException {
        {
            value = value.trim();
            RestQueryContext context = ConfigUtils.getQueryContext();
            String query = "/rest/api/userchooser/search?search=" + URLEncoder.encode(value, "utf-8");
            String resultData = doGetQuery(context, query);
            ObjectMapper mapper = new ObjectMapper();
            UserChooser[] users = mapper.readValue(resultData, UserChooser[].class);
            return users;
        }
    }

    public User GetUserById(RestQueryContext context, String userId) throws IOException {
        User user;
        try {
            String query = "/rest/api/filecabinet/user/" + userId;
            String resultData = doGetQuery(context, query);
            ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(resultData, User.class);
            return user;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }


    public UserAdditionalForm getUserInfo(String userId) throws IOException {
        {
            RestQueryContext context = ConfigUtils.getQueryContext();
            UserAdditionalForm userAdditionalForm = getUserAdditionalForm(context, userId);
            fillUseradditionalForm(context, userAdditionalForm);
            return userAdditionalForm;
        }
    }
}
