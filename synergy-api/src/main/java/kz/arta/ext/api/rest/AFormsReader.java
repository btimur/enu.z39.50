package kz.arta.ext.api.rest;

import kz.arta.ext.api.data.*;
import kz.arta.ext.api.data.Dictionary;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:42
 */
public abstract class AFormsReader extends RestQuery {
    public static final int maxCountPerList = 20;

    protected static<T> List<Dictionary> convertToDictionaries(List<T> professions, IFieldGetter fieldGetter) {
        List<Dictionary> dictionaries = new ArrayList<Dictionary>();
        if (professions!=null && professions.size()>0){
            int i=1;
            Set<String> itemsSet = new HashSet<String>();
            for(T profession:professions){
                if (profession!=null){
                    String keyField = fieldGetter.getKeyField(profession);
                    if (keyField !=null){
                        String keyFieldTrimmed = keyField.trim();
                        if (keyFieldTrimmed.length()>0){
                            String lowerKeyField = keyFieldTrimmed;//keyFieldTrimmed.toLowerCase();
                            if (!itemsSet.contains(lowerKeyField)){
                                Dictionary dictionary = new Dictionary(fieldGetter.getId(i, profession), keyFieldTrimmed);
                                fieldGetter.prepareDictionary(dictionary, profession);
                                dictionaries.add(dictionary);
                                itemsSet.add(lowerKeyField);
                                i++;
                            }
                        }
                    }
                }
            }
            Collections.sort(dictionaries);
        }
        return dictionaries;
    }

    public RegistryWrapper readRegistry(RestQueryContext queryContext, String formUUID, String searchField, String condition){
        RegistryWrapper registryWrapper = null;
        try{
            if (condition==null){
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
            System.out.println("result = " + result);

            String registryJson = "{\"registryUUID\":\""+formUUID+"\", \"records\":"+result+"}";
            System.out.println("registryJson = " + registryJson);

            ObjectMapper objectMapper = new ObjectMapper();
            registryWrapper = objectMapper.readValue(registryJson, RegistryWrapper.class);

            System.out.println("registryWrapper = " + registryWrapper);
            //registryWrapper.printRecords();

        }catch (Throwable e){
            e.printStackTrace();
        }
        return registryWrapper;
    }


    public RegistryWrapper readMultipleRegistry(RestQueryContext queryContext, String formUUID, SearchParam[] searchParams, SearchTerm term){
        RegistryWrapper registryWrapper = null;
        try{
            if (searchParams!=null && searchParams.length>0){
                StringBuilder sb = new StringBuilder();
                sb.append("/rest/api/asforms/search?getDocIds=true");
                sb.append(createCondition(searchParams[0], formUUID, ""));
                for(int i=1; i<searchParams.length;i++){
                    sb.append(createCondition(searchParams[i], formUUID, ""+i));
                }
                sb.append("&term=").append(term);
                sb.append("&startRecord=0&recordsCount=1000000");
                String query = sb.toString();

                String result = doGetQuery(queryContext, query);
                System.out.println("result = " + result);

                String registryJson = "{\"registryUUID\":\""+formUUID+"\", \"records\":"+result+"}";
                System.out.println("registryJson = " + registryJson);

                ObjectMapper objectMapper = new ObjectMapper();
                registryWrapper = objectMapper.readValue(registryJson, RegistryWrapper.class);

                System.out.println("registryWrapper = " + registryWrapper);
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
        return registryWrapper;
    }

    private static String createCondition(SearchParam param, String formUUID, String suffix) throws UnsupportedEncodingException {
        String cond =
                "&type"+suffix+"=partial" +
                "&formUUID"+suffix+"=" + formUUID +
                "&field"+suffix+"=" + param.getField() +
                "&search"+suffix+"=" +
                URLEncoder.encode(param.getCondition(), "utf-8");
        return cond;
    }


    public FormData readFormData(RestQueryContext context, String formId){
        FormData formData = null;
        try {

            String query = "/rest/api/asforms/data/" + formId;
            String resultData = doGetQuery(context, query);
            System.out.println("resultData = " + resultData);
            //logger.debug("result="+ resultData);

            String data = "";
            int startData = resultData.indexOf("[");
            if (startData>=0){
                int endData = resultData.lastIndexOf("]");
                data = resultData.substring(startData, endData+1);
                resultData = resultData.substring(0, startData)+"\"\""+resultData.substring(endData+1);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            formData = objectMapper.readValue(resultData, FormData.class);
            formData.setData(data);

            //logger.debug(formData);
            //System.out.println(formData);
        } catch (Throwable e){
            e.printStackTrace();
        }
        return formData;
    }


    public void writeData(RestQueryContext queryContext, FormData formData){
        System.out.println("AFormsReader.writeData");
        try{
            String dataUUID = formData.getUuid();
//            dataUUID = "0"+dataUUID.substring(1);
            String formUUID = formData.getForm();
            String data = formData.getData();
            //Заполняем документ
            String saveFormQuery = "/rest/api/asforms/data/save?formUUID=" + formUUID + "&uuid=" + dataUUID;
            String saveResult = doPostQuery(queryContext, saveFormQuery, "\"data\":"+data);
            System.out.println("saveResult = " + saveResult);

        }catch (Throwable e){
            e.printStackTrace();
        }
    }


    public RegistryRecord addNewRegistryRecord(RestQueryContext queryContext, String registryId){
        RegistryRecord registryRecord = null;
//        registryRecord = new RegistryRecord();
//        registryRecord.setDataUUID("2f0cd960-02b2-4aee-89fd-299091bf669b");
        if (true){
            String query = "/rest/api/registry/create_doc?registryID="+registryId;
            try {
                String result = doGetQuery(queryContext, query);
                System.out.println("addNewRegistryRecord.result = " + result);
                //res = {"errorCode": "0",
                // "documentID": "2d7ec7a7-61ce-4451-8a7b-2f67552c923f",
                // "dataUUID": "2f0cd960-02b2-4aee-89fd-299091bf669b",
                // "asfNodeID": "6bbe555d-834e-4e24-8232-25bfc426c68b" }
                ObjectMapper objectMapper = new ObjectMapper();
                registryRecord = objectMapper.readValue(result, RegistryRecord.class);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return registryRecord;
    }
}
