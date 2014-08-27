package kz.arta.ext.z3950.rest.api;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.z3950.util.CodeConstants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public String getUserInfoByCardUID(RestQueryContext context, String cardUID) {
        try {
            //todo: Connect to SKUD
            Connection con = null;
            Statement stmt = con.createStatement();
            // Получаем из БД СКУД идентификатор актуального сотрудника по UID карте
            ResultSet rs = stmt.executeQuery(
                    "SELECT t1.ID_STAFF " +
                    "FROM STAFF t1 LEFT JOIN STAFF_CARDS t2 ON t1.ID_STAFF = t2.STAFF_ID " +
                    "WHERE t2.IDENTIFIER = " + cardUID + " and t1.DATE_DISMISS IS NULL"
            );
            if (rs.next()) {
                // Если существует актуальный сотрудник, берем его идентификатор
                long staffId = rs.getLong(1);
                if (staffId > 0) {
                    //todo: stmt = con.createStatement();
                    // Получаем ИИН по идентификатору сотрудника
                    rs = stmt.executeQuery(
                            "SELECT INFO_DATA FROM STAFF_INFO_DATA_STR WHERE REF_ID=45619 AND STAFF_ID=" + staffId);
                    if (rs.next()) {
                        String staffIIN = rs.getString(1);

                        // Формируем запрос по получению информации о сотруднике (читателе) из "системы"
                        String query = "/rest/api/filecabinet/get_by_field_value?formUUID=" + formUUID
                                + "&value=" + staffIIN + "&fieldName=" + iinField;

                        // Получаем результат и его же отправляем как результат
                        String resultData = doGetQuery(context, query);
                        return resultData;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
