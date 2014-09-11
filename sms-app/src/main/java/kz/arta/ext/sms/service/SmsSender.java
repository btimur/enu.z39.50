package kz.arta.ext.sms.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.FormData;
import kz.arta.ext.api.data.FormFieldsWrapper;
import kz.arta.ext.api.rest.RestQuery;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.Order;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.rest.api.OrderReader;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.util.CodeConstants;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by timur on 8/28/2014 10:39 AM.
 */
@Stateless
public class SmsSender extends RestQuery {

    @Inject
    private SmsGateRepository smsGateRepository;

    @Inject
    private JurnalRepository jurnalRepository;

    @Inject
    private OrderReader reader;

    public boolean sendSms(String dataUUID,  RestQueryContext context){

        Order order = reader.readOrder(context, dataUUID);
      /*  Order order = new Order();
        order.setDataUUID("1");
        order.setDateofsdacha(new Date());
        order.setDateofvidacha(new Date());
        order.setNameofbook("book1");
        String userId = "77ad2e16-cdf9-442e-b7c0-50dad52c40c7";*/
        try {
        UserAdditionalFormReader userAdditionalFormReader = new UserAdditionalFormReader();
        UserAdditionalForm userAdditionalForm = null;

            userAdditionalForm = userAdditionalFormReader.getForm(context, order.getUserid());

        if(userAdditionalForm==null)
        {
            return false;
        }
        List<SmsGate> smsGates = smsGateRepository.getActiveSmsGates();
        boolean result = false;
        for (SmsGate smsGate : smsGates) {
            result = trySend(smsGate, order, userAdditionalForm);
            jurnalRepository.saveJurnal(order, smsGate, userAdditionalForm);
            if (result) {
                break;
            }
        }
        return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean trySend(SmsGate smsGate, Order order,UserAdditionalForm userAdditionalForm) throws IOException {
        RestQueryContext context = new RestQueryContext();
        String message =  getText(smsGate, order, userAdditionalForm);
        String query = smsGate.getTemplate()
                .replace("%ENU_LOGIN%", smsGate.getsLogin())
                .replace("%ENU_PWD%", URLEncoder.encode(smsGate.getsPwd(), smsGate.getsCharset()))
                .replace("%ENU_PHONES%",userAdditionalForm.getPhoneNumber());
        userAdditionalForm.setMessage(message);
        message = URLEncoder.encode(message, smsGate.getsCharset());
        query = query.replace("%ENU_MSG%",message);
        context.setAddress(query);
        context.setLogin(URLEncoder.encode(smsGate.getsLogin(), smsGate.getsCharset()));
        context.setPassword(URLEncoder.encode(smsGate.getsPwd(), smsGate.getsCharset()));

        String result = doGetQuery2(context, query);
        if(result.contains(smsGate.getSucessResult()))
        {
            userAdditionalForm.setResponceMessage(CodeConstants.SEND_SUCCESS);
            return true;
        }
        userAdditionalForm.setResponceMessage(result);
        return false;
    }

    protected String doGetQuery2(RestQueryContext context, String query) throws IOException {
        URL url = new URL(context.getAddress() + query);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        String output;
        StringBuffer result = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((output = br.readLine()) != null) {
            result.append(output);
        }
        conn.disconnect();
        return result.toString();
    }

    private String getText(SmsGate smsGate, Order order,  UserAdditionalForm userAdditionalForm) {

        SimpleDateFormat formatDateJava = new SimpleDateFormat("dd/MM/yyyy");


        String message = smsGate.getMessageContext()
                .replace("%FULL_NAME%", userAdditionalForm.getFullName())
                .replace("%NAME_BOOK%", order.getNameofbook())
                .replace("%DATE_DELIVERY%", formatDateJava.format(order.getDateofvidacha()))
                .replace("%DATE_BACK%", formatDateJava.format(order.getDateofsdacha()));

        return message;
    }

    private String getPhones(SmsGate smsGate, Order order) {
        return "87012123952";
//        return null;
    }

    @Override
    protected void authentication(RestQueryContext context, HttpURLConnection conn) {

    }
}
