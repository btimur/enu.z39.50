package kz.arta.ext.skud.rest;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import org.apache.logging.log4j.Logger;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Администратор on 04.09.2014.
 */
@Path("/rest")
public class SkudService extends AFormsReader {

    public static final String USER_ADDITIONAL_FORM_UUID = "user.additional.form.uuid";
    public static final String USER_ADDITIONAL_IIN_FIELD = "user.additional.iin.field";

//    @Inject
//    private Logger log;

    private final String formUUID;
    private final String iinField;

    public SkudService() {
        formUUID = ConfigReader.getPropertyValue(USER_ADDITIONAL_FORM_UUID);
        iinField = ConfigReader.getPropertyValue(USER_ADDITIONAL_IIN_FIELD);
    }

    @Resource(mappedName = "java:jboss/datasources/SkudDS")
    private DataSource ds;

    @GET
    @Path("/getUserIDByCardUID")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUserInfoByCardUID(RestQueryContext context, @QueryParam("cardUID") String cardUID) {
        try {
//            System.out.println(cardUID);
            Connection con = ds.getConnection();
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
