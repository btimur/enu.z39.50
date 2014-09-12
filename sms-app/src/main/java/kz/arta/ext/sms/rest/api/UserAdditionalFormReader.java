package kz.arta.ext.sms.rest.api;

import kz.arta.ext.api.data.User;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by admin on 05.09.14.
 */
public class UserAdditionalFormReader extends AFormsReader {

    public UserAdditionalForm getForm(RestQueryContext context, String userId) throws IOException {
        String query = "/rest/api/personalrecord/forms/" + userId;
        String resultData = doGetQuery(context, query);
        resultData = resultData.replace("[","").replace("]","");

        ObjectMapper mapper = new ObjectMapper();
        UserAdditionalForm userAdditionalForm = mapper.readValue(resultData, UserAdditionalForm.class);

        if (userAdditionalForm == null || userAdditionalForm.getDataUuid() == null) {
            return null;
        }
        FormFieldsWrapper wrapper = readFormData(context, userAdditionalForm.getDataUuid()).convertToWrapper();
        String phoneNumber = wrapper.getFormFieldMap().get("telephone").getValue();
        String iinValue = wrapper.getFormFieldMap().get("cmp-lg67bo").getValue();

        if(phoneNumber==null)
        {
            return null;
        }
        userAdditionalForm.setPhoneNumber(phoneNumber);
        userAdditionalForm.setIin(iinValue);
        User user = GetUserById(context, userId);
        if(user!=null)
        {
            String fullName = user.getLastname()+" "+ user.getFirstname()+" "+user.getPatronymic();
            userAdditionalForm.setFullName(fullName);
        }
        return userAdditionalForm;
    }



    public User GetUserById(RestQueryContext context, String userId) throws IOException {
        User user=null;
        try {
        String query = "/rest/api/filecabinet/user/" + userId;
        String resultData = doGetQuery(context, query);
        ObjectMapper mapper = new ObjectMapper();
            user = mapper.readValue(resultData, User.class);
        return user;
        } catch (Throwable e){
            e.printStackTrace();
        }
        return user;
    }


}
