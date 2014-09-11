package kz.arta.ext.api.rest;

import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.RegistryRecord;
import kz.arta.ext.api.data.RegistryWrapper;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:42
 */
public abstract class AFormsReader extends RestQuery {
    public static final int maxCountPerList = 20;

    private static String createCondition(SearchParam param, String formUUID, String suffix) throws UnsupportedEncodingException {
        return "&type" + suffix + "=partial" +
                "&formUUID" + suffix + "=" + formUUID +
                "&field" + suffix + "=" + param.getField() +
                "&search" + suffix + "=" +
                URLEncoder.encode(param.getCondition(), "utf-8");
    }

    public RegistryWrapper readRegistry(RestQueryContext queryContext, String formUUID, String searchField, String condition) {
        RegistryWrapper registryWrapper = null;
        try {
            if (condition == null) {
                condition = "";
            }
            String query = "/rest/api/asforms/search?" +
                    "type=partial" +
                    "&formUUID=" + formUUID +
                    "&field=" + searchField +
                    "&search=" +
                    URLEncoder.encode(condition, "utf-8")
                    + "&getDocIds=true&startRecord=0&recordsCount=1000000";

            String result = doGetQuery(queryContext, query);
            log.debug("result = {}", result);

            String registryJson = "{\"registryUUID\":\"" + formUUID + "\", \"records\":" + result + "}";
            log.debug("registryJson = {}", registryJson);

            ObjectMapper objectMapper = new ObjectMapper();
            registryWrapper = objectMapper.readValue(registryJson, RegistryWrapper.class);

            log.debug("registryWrapper = {}", registryWrapper);
            //registryWrapper.printRecords();

        } catch (Exception e) {
            log.error("error read registry " + formUUID, e);
        }
        return registryWrapper;
    }

    public RegistryWrapper readMultipleRegistry(RestQueryContext queryContext, String formUUID, SearchParam[] searchParams, SearchTerm term) {
        RegistryWrapper registryWrapper = null;
        try {
            if (searchParams != null && searchParams.length > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("/rest/api/asforms/search?getDocIds=true");
                sb.append(createCondition(searchParams[0], formUUID, ""));
                for (int i = 1; i < searchParams.length; i++) {
                    sb.append(createCondition(searchParams[i], formUUID, "" + i));
                }
                sb.append("&term=").append(term);
                sb.append("&startRecord=0&recordsCount=1000000");
                String query = sb.toString();

                String result = doGetQuery(queryContext, query);
                log.debug("result = {}", result);

                String registryJson = "{\"registryUUID\":\"" + formUUID + "\", \"records\":" + result + "}";
                log.debug("registryJson = {}", registryJson);

                ObjectMapper objectMapper = new ObjectMapper();
                registryWrapper = objectMapper.readValue(registryJson, RegistryWrapper.class);

                log.debug("registryWrapper = {}", registryWrapper);
            }
        } catch (Exception e) {
            log.error("error read multi registry " + formUUID, e);
        }
        return registryWrapper;
    }

    public FormData readFormData(RestQueryContext context, String dataId) {
        FormData formData = null;
        try {

            String query = "/rest/api/asforms/data/" + dataId;
            String resultData = doGetQuery(context, query);
            log.debug("resultData = {}", resultData);
            //logger.debug("result="+ resultData);

            formData = parseFormData(resultData);

            //logger.debug(formData);
            //log.debug(formData);
        } catch (Exception e) {
            log.error("error read form data " + dataId, e);
        }
        return formData;
    }

    public FormData parseFormData(String resultData) throws IOException {
        String data = "";
        int startData = resultData.indexOf("[");
        if (startData >= 0) {
            int endData = resultData.lastIndexOf("]");
            data = resultData.substring(startData, endData + 1);
            resultData = resultData.substring(0, startData) + "\"\"" + resultData.substring(endData + 1);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        FormData formData = objectMapper.readValue(resultData, FormData.class);
        formData.setData(data);
        return formData;
    }


    public void writeData(RestQueryContext queryContext, FormData formData) {
        log.debug("AFormsReader.writeData");
        try {
            String dataUUID = formData.getUuid();
            String formUUID = formData.getForm();
            String data = formData.getData();
            //Заполняем документ
            String saveFormQuery = "/rest/api/asforms/data/save?formUUID=" + formUUID + "&uuid=" + dataUUID;
            String saveResult = doPostQuery(queryContext, saveFormQuery, "\"data\":" + data);
            log.debug("saveResult = {}", saveResult);

        } catch (Exception e) {
            log.error("error write data " + formData, e);
        }
    }


    public RegistryRecord addNewRegistryRecord(RestQueryContext queryContext, String registryId) {
        RegistryRecord registryRecord = null;
        String query = "/rest/api/registry/create_doc?registryID=" + registryId;
        try {
            String result = doGetQuery(queryContext, query);
            log.debug("addNewRegistryRecord.result = {}", result);
            ObjectMapper objectMapper = new ObjectMapper();
            registryRecord = objectMapper.readValue(result, RegistryRecord.class);

        } catch (IOException e) {
            log.error("error add new record to registry " + registryId, e);
        }
        return registryRecord;
    }
}
