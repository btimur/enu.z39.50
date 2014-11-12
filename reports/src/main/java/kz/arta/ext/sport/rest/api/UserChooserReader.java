package kz.arta.ext.sport.rest.api;

import kz.arta.ext.api.data.FormField;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.data.User;
import kz.arta.ext.api.rest.AFormsReader;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sport.model.synergy.*;
import kz.arta.ext.sport.service.repository.DepartmentRepository;
import kz.arta.ext.sport.util.CodeConstants;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by admin on 21.10.14.
 */
public class UserChooserReader extends AFormsReader {
    public static final String CITY = "cmp-brqd2a";
    public static final String REGION = "cmp-ch36pp";
    public static final String SUB_REGION = "cmp-pjflzd";

    @Inject
    private DepartmentRepository departmentRepository;

    @Inject
    private DepartmentReader departmentReader;

    public UserChooser[] getListUserChooser(String code, int startRecord, int recordsCount, RestQueryContext context) throws IOException {
        {
            String where = URLEncoder.encode(code, "utf-8") + "&startRecord=" + startRecord + "&recordsCount=" + recordsCount;
            String query = "/rest/api/userchooser/search?search=" + where;
            String resultData = doGetQuery(context, query);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(resultData, UserChooser[].class);
        }
    }

    public void fillDepartment(UserChooser userChooser, RestQueryContext context) throws IOException {
        try {
            String query = "/rest/api/filecabinet/user/" + userChooser.getUserID();
            String resultData = doGetQuery(context, query);
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(resultData, User.class);
            List<LinkedHashMap> positions = (List<LinkedHashMap>) user.getPositions();
            List<String> stringList = new ArrayList<String>();
            stringList.add(CodeConstants.MALE_GROUP);
            stringList.add(CodeConstants.FEMALE_GROUP);
            stringList.add(CodeConstants.FEMALE_ABULT);
            stringList.add(CodeConstants.FEMALE_JUNIOR);
            stringList.add(CodeConstants.FEMALE_YOUTH);
            for (LinkedHashMap position : positions) {
                if (position.containsKey("positionName") && (stringList.contains(position.get("positionName")))) {
                    if (position.containsKey("departmentID")) {
                        String departmentId = position.get("departmentID").toString();
                        Department department = departmentRepository.find(departmentId);
                        if(department==null)
                        {
                            department = departmentReader.getDepartment(departmentId,context);
                            if(department!=null)
                            {
                                department.setParent(fillParentDepartment(department,context));
                            }
                            departmentRepository.save(department);
                        }
                        userChooser.setDepartment(department);
                        return;
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private Department fillParentDepartment(Department department, RestQueryContext context) throws IOException {
        String parentDepartmentID = department.getParentDepartmentID();
        if(parentDepartmentID==CodeConstants.ROOT_DEPARTMENT)
        {
            return departmentRepository.find(CodeConstants.ROOT_DEPARTMENT);
        }
        Department parent = departmentRepository.find(parentDepartmentID);
        if(parent==null)
        {
            parent = departmentReader.getDepartment(parentDepartmentID,context);
            if(parent!=null)
            {
                parent.setParent(fillParentDepartment(parent,context));
                departmentRepository.save(parent);
            }
        }
        return parent;
    }

    public void fillUserAdditionalForm(UserChooser userChooser, RestQueryContext context) throws IOException {
        UserAdditionalForm factForm = getFormByName(CodeConstants.FACT_FORM, context, userChooser);
        if (factForm == null) {
            return;
        }
        FormFieldsWrapper wrapper = readFormData(context, factForm.getDataUuid()).convertToWrapper();
        FormField cityField = wrapper.getFormFieldMap().get(CITY);
        FormField regionField = wrapper.getFormFieldMap().get(REGION);
        FormField sybRegionField = wrapper.getFormFieldMap().get(SUB_REGION);
        if (cityField != null) {
            userChooser.setCity(cityField.getValue());
        }
        if (regionField != null) {
            userChooser.setRegion(regionField.getValue());
        }
        if (sybRegionField != null) {
            userChooser.setSubRegion(sybRegionField.getValue());
        }
    }

    private UserAdditionalForm getFormByName(String code, RestQueryContext context, UserChooser userChooser) throws IOException {
        String query = "/rest/api/personalrecord/forms/" + userChooser.getUserID();
        String resultData = doGetQuery(context, query);
//        resultData = resultData.replace("[", "").replace("]", "");

        ObjectMapper mapper = new ObjectMapper();
        UserAdditionalForm[] userAdditionalForms = mapper.readValue(resultData, UserAdditionalForm[].class);
        for (UserAdditionalForm additionalForm : userAdditionalForms) {
            if (additionalForm.getName().contains(code)) {
                return additionalForm;

            }
        }
        return null;
    }

}
