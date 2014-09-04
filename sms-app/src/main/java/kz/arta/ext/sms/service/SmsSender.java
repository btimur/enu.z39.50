package kz.arta.ext.sms.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.rest.RestQuery;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.Order;
import kz.arta.ext.sms.rest.api.OrderReader;

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

    public boolean sendSms(String dataUUID) throws IOException {
        Order order = reader.readOrder(ConfigUtils.getQueryContext(), dataUUID);
        List<SmsGate> smsGates = smsGateRepository.getSmsGates();
        boolean result = false;
        for (SmsGate smsGate : smsGates) {
            result = trySend(smsGate, order);
            if (result) {
                jurnalRepository.saveJurnal(order, smsGate);
                break;
            }
        }
        return result;
    }

    private boolean trySend(SmsGate smsGate, Order order) throws IOException {
        RestQueryContext context = new RestQueryContext();
        context.setAddress("");
        String query = smsGate.getsUrl()
                .replace("%ENU_LOGIN%", smsGate.getsLogin())
                .replace("%ENU_PWD%", URLEncoder.encode(smsGate.getsPwd(), smsGate.getsCharset()))
                .replace("%ENU_PHONES%", URLEncoder.encode(getPhones(smsGate, order), smsGate.getsCharset()))
                .replace("%ENU_MSG%", URLEncoder.encode(getText(smsGate, order), smsGate.getsCharset()));
        String result = doGetQuery(context, query);

        return false;
    }

    private String getText(SmsGate smsGate, Order order) {
//        String text = smsGate.getTemplate().replace();
        return null;
    }

    private String getPhones(SmsGate smsGate, Order order) {
        return null;
    }

    @Override
    protected void authentithication(RestQueryContext context, HttpURLConnection conn) {

    }
}
