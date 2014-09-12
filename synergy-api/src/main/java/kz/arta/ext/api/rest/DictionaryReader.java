package kz.arta.ext.api.rest;

import kz.arta.ext.api.data.Dictionary;
import kz.arta.ext.api.data.DictionaryResult;
import kz.arta.ext.common.util.CodeConstants;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by timur on 8/27/2014 7:44 PM.
 */
public abstract class DictionaryReader extends RestQuery {

    private Logger log = LoggerFactory.getLogger(DictionaryReader.class);

    public Dictionary readDictionary(RestQueryContext context, String dictionaryCode) {
        Dictionary dictionary = null;
        try {

            String query = "/rest/api/dictionary/get_by_code?locale=ru&dictionaryCode=" +
                    URLEncoder.encode(dictionaryCode, "UTF-8");
            String resultData = doGetQuery(context, query);
            log.debug("resultData = {}", resultData);
            ObjectMapper objectMapper = new ObjectMapper();
            dictionary = objectMapper.readValue(resultData, Dictionary.class);
        } catch (Exception e) {
            log.error("error load Dictionary " +  dictionaryCode, e);
        }
        return dictionary;
    }


    public String insertDictionary(RestQueryContext context, String dictionaryCode, String value) {
        try {

            String query = "/rest/api/dictionary/record/add";
            ObjectMapper objectMapper = new ObjectMapper();
            Dictionary dictionary = createDictionary(dictionaryCode, value);
            objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL));
            String data = objectMapper.writeValueAsString(dictionary);
            String resultData = doPostQuery(context, query, data);
            log.debug("resultData = {}", resultData);
            DictionaryResult result = objectMapper.readValue(resultData, DictionaryResult.class);
            if (result.getErrorCode().equals("0")){
                return getSuccesCode(dictionary);
            }
            return resultData;
        } catch (Exception e) {
            log.error("error insert Dictionary " +  dictionaryCode, e);
            return null;
        }
    }

    protected String doPostQuery(RestQueryContext context, String query, String data) throws IOException {
        log.debug("query = {}", query);
        log.debug("data = {}", data);
        URL url = new URL(context.getAddress() + query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setAllowUserInteraction(false);
        conn.setRequestProperty("Content-type", "application/json; charset=utf-8");
        String encoded = DatatypeConverter.printBase64Binary((context.getLogin() + ":" + context.getPassword()).getBytes());
        conn.setRequestProperty("Authorization", "Basic " + encoded);

        OutputStream out = conn.getOutputStream();
        Writer writer = new OutputStreamWriter(out, CodeConstants.ENCODING_UFT_8);

        writer.write(data);

        writer.close();
        out.close();

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        String output;
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        while ((output = br.readLine()) != null) {
            result.append(output);
        }
        conn.disconnect();

        return result.toString();
    }

    protected abstract String getSuccesCode(Dictionary dictionary);

    protected abstract Dictionary createDictionary(String dictionaryCode, String value);
}
