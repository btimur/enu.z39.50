package kz.arta.ext.sport.rest.api;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sport.model.synergy.Department;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by admin on 20.10.14.
 */
public class DepartmentReader extends AFormsReader {

    public Department[] getListDepartment(int startRecord, int recordsCount, RestQueryContext context) throws IOException {
        {
            String query =  "/rest/api/departments/list?partNumber="+startRecord+"&countInPart="+recordsCount;
            String resultData = doGetQuery(context, query);
            ObjectMapper mapper = new ObjectMapper();
            Department[] departments = mapper.readValue(resultData, Department[].class);

            return departments;
        }
    }


    public Department getDepartment(String departmentId, RestQueryContext context) throws IOException {
        String query =  "/rest/api/departments/get?departmentID="+departmentId;
        String resultData = doGetQuery(context, query);
        ObjectMapper mapper = new ObjectMapper();
        Department department = mapper.readValue(resultData, Department.class);
        return department;
    }
}
