package kz.arta.ext.z3950.rest.api;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.z3950.util.CodeConstants;

/**
 * Created by timur on 14/07/2014 13:28.
 */
public class UserAdditionalReader extends AFormsReader {
    private final String formUUID;
    private final String iinField;

    public UserAdditionalReader() {
        formUUID = ConfigReader.getPropertyValue(CodeConstants.USER_ADDITIONAL_FORM_UUID);
        iinField = ConfigReader.getPropertyValue(CodeConstants.USER_ADDITIONAL_IIN_FIELD);
    }

    public String  getUserIdByIin(RestQueryContext context, String iin) {
        String userId = null;
        try {
//http://cloudofficeoneweek.v3na.kz/Synergy/rest/api/filecabinet/get_by_field_value?formUUID=cd2ab343-ecad-4f91-919d-e7f9afb4ba6d&value=000290023038&fieldName=cmp-lg67bo
            String query = "/rest/api/filecabinet/get_by_field_value?formUUID=" + formUUID
                    + "&value="+ iin+"&fieldName="+ iinField;

            String resultData = doGetQuery(context, query);
            System.out.println("resultData = " + resultData);
            String data = "";
            int startData = resultData.indexOf("[");
            if (startData>=0){
                int endData = resultData.lastIndexOf("]");
                data = resultData.substring(startData + 1 , endData);
//                resultData = resultData.substring(0, startData)+"\"\""+resultData.substring(endData+1);
                if (data.contains(",")) {
                    String[] ids = data.split(",");
                    userId = ids[0];
                }else{
                    userId = data;
                }
                userId = userId.replace("\"","");
            }
        } catch (Throwable e){
            e.printStackTrace();
        }
        return userId;
    }
}
