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
import org.codehaus.jackson.map.ObjectMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
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

    public boolean sendSms(String dataUUID,  RestQueryContext context) throws IOException {
//        RestQueryContext context = ConfigUtils.getQueryContext();
//        reader = new OrderReader();
//        Order order = reader.readOrder(context, dataUUID);
        Order order = new Order();
        String userId = "77ad2e16-cdf9-442e-b7c0-50dad52c40c7";
        UserAdditionalFormReader userAdditionalFormReader = new UserAdditionalFormReader();
        UserAdditionalForm userAdditionalForm = userAdditionalFormReader.getForm(context, userId);
        if(userAdditionalForm==null)
        {
            return false;
        }
        smsGateRepository = new SmsGateRepository();
        List<SmsGate> smsGates = smsGateRepository.getSmsGates();
        boolean result = false;
        for (SmsGate smsGate : smsGates) {
            result = trySend(smsGate, order, userAdditionalForm);
            if (result) {
                jurnalRepository.saveJurnal(order, smsGate);
                break;
            }
        }
        return result;
    }

    public boolean trySend(SmsGate smsGate, Order order,UserAdditionalForm userAdditionalForm) throws IOException {
        RestQueryContext context = new RestQueryContext();
        String query = smsGate.getsUrl()
                .replace("%ENU_LOGIN%", smsGate.getsLogin())
                .replace("%ENU_PWD%", URLEncoder.encode(smsGate.getsPwd(), smsGate.getsCharset()))
                .replace("%ENU_PHONES%",userAdditionalForm.getPhoneNumber())
                .replace("%ENU_MSG%", URLEncoder.encode(getText(smsGate, order, userAdditionalForm), smsGate.getsCharset()));
        context.setAddress(query);
        context.setLogin(smsGate.getsLogin());
        context.setPassword(smsGate.getsPwd());

//        String result = doGetQuery(context, query);
        return false;
    }

    private String getText(SmsGate smsGate, Order order,  UserAdditionalForm userAdditionalForm) {

        String message = smsGate.getTemplate()
                .replace("%FULL_NAME%", userAdditionalForm.getFullName())
                .replace("%NAME_BOOK%", order.getNameofbook())
                .replace("%DATE_DELIVERY%", order.getDateofvidacha().toString())
                .replace("%DATE_BACK%", order.getDateofsdacha().toString());

        return message;
    }

    private String getPhones(SmsGate smsGate, Order order) {
        return "87012123952";
//        return null;
    }

    @Override
    protected void authentithication(RestQueryContext context, HttpURLConnection conn) {

    }
}
