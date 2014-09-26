package kz.arta.ext.api.rest;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


import kz.arta.ext.common.util.CodeConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * User: D. Kulakhmetov
 * Date: 03.04.14
 * Time: 19:24
 */
public abstract class RestQuery {

    protected Logger log = LoggerFactory.getLogger(DictionaryReader.class);

    protected String doGetQuery(RestQueryContext context, String query) throws IOException {
        URL url = new URL(context.getAddress() + query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json; charset=utf-8");
//        String encoded = DatatypeConverter.encode((context.getLogin() + ":" + context.getPassword()).getBytes());
        authentication(context, conn);
        return readStringReturn(conn);
    }

    private String readStringReturn(HttpURLConnection conn) throws IOException {
        String output;
        StringBuffer result = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), CodeConstants.ENCODING_UFT_8));

        while ((output = br.readLine()) != null) {
            result.append(output);
        }
        conn.disconnect();
        return result.toString();
    }

    protected void authentication(RestQueryContext context, HttpURLConnection conn) {
        String encoded = DatatypeConverter.printBase64Binary((context.getLogin() + ":" + context.getPassword()).getBytes());
        conn.setRequestProperty("Authorization", "Basic " + encoded);
    }

    protected String doPostQuery(RestQueryContext context, String query, String data) throws IOException {
        return doPostQuery(context, query, data, "data");
    }

    protected String doPostQuery(RestQueryContext context, String query, String data, String dataField) throws IOException {
        log.debug("data = {}", data);
        String body = dataField + "=" + URLEncoder.encode(data, CodeConstants.ENCODING_UFT_8) + "&";
        return doPostBodyQuery(context, query, body);
    }

    protected String doPostBodyQuery(RestQueryContext context, String query, String body) throws IOException {
        log.debug("query = {}", query);
        log.debug("body = {}", body);
        URL url = new URL(context.getAddress() + query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setAllowUserInteraction(false);
        conn.setRequestProperty("Accept", "application/json; charset=utf-8");
        authentication(context, conn);

        OutputStream out = conn.getOutputStream();
        Writer writer = new OutputStreamWriter(out, CodeConstants.ENCODING_UFT_8);
        writer.write(body);
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


    public String doGetQueryWithoutAuth(RestQueryContext context) throws IOException {
        URL url = new URL(context.getAddress());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        return readStringReturn(conn);
    }

}
