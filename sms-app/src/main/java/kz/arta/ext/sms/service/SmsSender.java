package kz.arta.ext.sms.service;

import kz.arta.ext.api.rest.RestQuery;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.BlockSignalMessage;
import kz.arta.ext.sms.model.synergy.Order;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.rest.api.OrderReader;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.util.CodeConstants;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by timur on 8/28/2014 10:39 AM.
 * сервис отправки sms
 */
@Stateless
public class SmsSender extends RestQuery {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger logger;
    @Inject
    private SmsGateRepository smsGateRepository;

    @Inject
    private JurnalRepository jurnalRepository;

    @Inject
    private OrderReader reader;

    @Inject
    private UserAdditionalFormReader userAdditionalFormReader;

    public void sendSms(BlockSignalMessage blockSignalMessage, RestQueryContext context) {

        Order order = reader.readOrder(context, blockSignalMessage.getDataUUID());
      /*  Order order = new Order();
        order.setDataUUID("1");
        order.setDateofsdacha(new Date());
        order.setDateofvidacha(new Date());
        order.setNameofbook("book1");
        String userId = "77ad2e16-cdf9-442e-b7c0-50dad52c40c7";*/
        try {

            UserAdditionalForm userAdditionalForm = userAdditionalFormReader.getForm(context, order.getUserid());
            if (userAdditionalForm == null) {
                logger.error("can't find user info by order - {}", blockSignalMessage.getDataUUID());
                return;
            }
            List<SmsGate> smsGates = smsGateRepository.getActiveSmsGates();
            boolean result = false;
            for (SmsGate smsGate : smsGates) {
                for (String phone : userAdditionalForm.getPhones()) {
                    result = result || sendOneSms(order, phone, userAdditionalForm, smsGate);
                }
                if (result) {
                    break;
                }
            }
            if(result){
                reader.unblockProcess(context, blockSignalMessage);
            }
        } catch (IOException e) {
            log.error("error send sms", e);
        }
    }

    private void unblockProcess() {

    }

    private boolean sendOneSms(Order order, String phone, UserAdditionalForm userAdditionalForm, SmsGate smsGate) throws IOException {
        boolean result = trySend(smsGate, phone, order, userAdditionalForm);
        saveJurnal(order, smsGate, userAdditionalForm, phone);
        return result;
    }

    private void saveJurnal(Order order, SmsGate smsGate, UserAdditionalForm userAdditionalForm, String phone) {

        jurnalRepository.save(createJurnal(order, smsGate, userAdditionalForm, phone));

    }

    private Jurnal createJurnal(Order order, SmsGate smsGate, UserAdditionalForm userAdditionalForm, String phone) {
        Jurnal jurnal = new Jurnal();
        jurnal.setSmsGate(smsGate);
        jurnal.setDateSend(new Timestamp(new Date().getTime()));
        jurnal.setOrderUUID(order.getDataUUID());
        jurnal.setOrderBookName(order.getNameofbook());
        jurnal.setMessage(userAdditionalForm.getMessage());
        jurnal.setResult(userAdditionalForm.getResponceMessage());
        if (userAdditionalForm.getIin().isEmpty()) {
            jurnal.setIin(CodeConstants.VALUE_IS_EMPTY);
        } else {
            jurnal.setIin(userAdditionalForm.getIin());
        }
        jurnal.setPhone(phone);
        return jurnal;
    }

    public boolean trySend(SmsGate smsGate, String phone, Order order, UserAdditionalForm userAdditionalForm) throws IOException {
        RestQueryContext context = new RestQueryContext();
        String message = getText(smsGate, order, userAdditionalForm);
        String query = smsGate.getTemplate()
                .replace("%ENU_LOGIN%", smsGate.getsLogin())
                .replace("%ENU_PWD%", URLEncoder.encode(smsGate.getsPwd(), smsGate.getsCharset()))
                .replace("%ENU_PHONES%", phone);
        userAdditionalForm.setMessage(message);
        message = URLEncoder.encode(message, smsGate.getsCharset());
        query = query.replace("%ENU_MSG%", message);
        context.setAddress(query);
        context.setLogin(URLEncoder.encode(smsGate.getsLogin(), smsGate.getsCharset()));
        context.setPassword(URLEncoder.encode(smsGate.getsPwd(), smsGate.getsCharset()));

        String result = doGetQuery2(context, query);
        if (result.contains(smsGate.getSucessResult())) {
            userAdditionalForm.setResponceMessage(CodeConstants.SEND_SUCCESS);
            log.info("success send sms by order {} to user {} to phone {}",
                    order.getDataUUID(),
                    userAdditionalForm.getIin(),
                    phone);
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
        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        while ((output = br.readLine()) != null) {
            result.append(output);
        }
        conn.disconnect();
        return result.toString();
    }

    private String getText(SmsGate smsGate, Order order, UserAdditionalForm userAdditionalForm) {

        SimpleDateFormat formatDateJava = new SimpleDateFormat("dd/MM/yyyy");

        return smsGate.getMessageContext()
                .replace("%FULL_NAME%", userAdditionalForm.getFullName())
                .replace("%NAME_BOOK%", order.getNameofbook())
                .replace("%DATE_DELIVERY%", formatDateJava.format(order.getDateofvidacha()))
                .replace("%DATE_BACK%", formatDateJava.format(order.getSrokvozvrata()));
    }

    @Override
    protected void authentication(RestQueryContext context, HttpURLConnection conn) {

    }
}
