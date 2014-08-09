package kz.arta.ext.api.rest;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


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

    protected String doGetQuery(RestQueryContext context, String query) throws IOException {
        URL url = new URL(context.getAddress() + query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json; charset=utf-8");
//        String encoded = DatatypeConverter.encode((context.getLogin() + ":" + context.getPassword()).getBytes());
        String encoded = DatatypeConverter.printBase64Binary((context.getLogin() + ":" + context.getPassword()).getBytes());
        conn.setRequestProperty("Authorization", "Basic " + encoded);
        String output;
        StringBuffer result = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        while ((output = br.readLine()) != null) {
            result.append(output);
        }
        conn.disconnect();
        return result.toString();
    }

    protected String doPostQuery(RestQueryContext context, String query, String data) throws IOException {
        System.out.println("query = " + query);
        System.out.println("data = " + data);
        URL url = new URL(context.getAddress() + query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setAllowUserInteraction(false);
        conn.setRequestProperty("Accept", "application/json; charset=utf-8");
        String encoded = DatatypeConverter.printBase64Binary((context.getLogin() + ":" + context.getPassword()).getBytes());
        conn.setRequestProperty("Authorization", "Basic " + encoded);

        OutputStream out = conn.getOutputStream();
        Writer writer = new OutputStreamWriter(out, "UTF-8");

        writer.write("data");
        writer.write("=");
        writer.write(URLEncoder.encode(data, "utf-8"));
        writer.write("&");

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

}
