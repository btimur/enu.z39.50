package kz.arta.ext.sms.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.BlockSignalMessage;
import kz.arta.ext.sms.model.synergy.Order;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.rest.SmsQuery;
import kz.arta.ext.sms.rest.api.OrderReader;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.util.CodeConstants;
import kz.arta.ext.sms.util.Translit;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
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
public class SmsSender {

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

    public boolean sendSms(BlockSignalMessage blockSignalMessage, RestQueryContext context) {

        Order order = reader.readOrder(context, blockSignalMessage.getDataUUID());
      /*  userAdditionalFormReader = new UserAdditionalFormReader();
        Order order = new Order();
        order.setDataUUID("1");
        order.setSrokvozvrata(new Date());
        order.setDateofvidacha(new Date());
        order.setNameofbook("book1");
        order.setUserid("77ad2e16-cdf9-442e-b7c0-50dad52c40c7");*/
        boolean result = false;
            UserAdditionalForm userAdditionalForm = null;
            try {
                userAdditionalForm = userAdditionalFormReader.getForm(context, order.getUserid());
            } catch (IOException e) {
                logger.error("error read userInfo", e);
            }
            if (userAdditionalForm == null) {
                logger.error("smsSend: can't find user info by order - {}", blockSignalMessage.getDataUUID());
                return result;
            }
            List<SmsGate> smsGates = smsGateRepository.getActiveSmsGates();

            for (SmsGate smsGate : smsGates) {
                for (String phone : userAdditionalForm.getPhones()) {
                    try{
                    result = result || sendOneSms(order, phone, userAdditionalForm, smsGate);
                } catch (IOException e) {
                    logger.error("smsSend: error send sms", e);
                }
                }
                if (result) {
                    break;
                }
            }
            if(result){
                try {
                    reader.unblockProcess(context, blockSignalMessage);
                    result = true;
                } catch (IOException e) {
                    logger.error("error unblock process", e);
                }
            }

        return result;
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
        jurnal.setFio(userAdditionalForm.getFullName());
        if (userAdditionalForm.getIin().isEmpty()) {
            jurnal.setIin(CodeConstants.VALUE_IS_EMPTY);
        } else {
            jurnal.setIin(userAdditionalForm.getIin());
        }
        jurnal.setPhone(phone);
        return jurnal;
    }

    public boolean trySend(SmsGate smsGate, String phone, Order order, UserAdditionalForm userAdditionalForm) throws IOException {

        String message = getText(smsGate, order, userAdditionalForm);

        return sendMessage(smsGate, phone, userAdditionalForm, message, order.getDataUUID());
    }

    private boolean sendMessage(SmsGate smsGate, String phone, UserAdditionalForm userAdditionalForm,
                                String message, String orderUUID) throws IOException {
        RestQueryContext context = new RestQueryContext();
        String query = smsGate.getTemplate()
                .replace("%ENU_LOGIN%", smsGate.getsLogin())
                .replace("%ENU_PWD%", smsGate.getsPwd())
                .replace("%ENU_PHONES%", phone);
        userAdditionalForm.setMessage(message);
        logger.info("smsSend: message text - {}", message);
        if(smsGate.getTranslit())
        {
            message = Translit.toTranslit(message);
        }
        message = URLEncoder.encode(message, smsGate.getsCharset());
        logger.debug("smsSend: endcoded message text - {}", message);
        query = query.replace("%ENU_MSG%", message);
        context.setAddress(query);
        context.setLogin(smsGate.getsLogin());
        context.setPassword(smsGate.getsPwd());
        logger.info("smsSend: query - {}", query);
        String result = new SmsQuery().doGetQueryWithoutAuth(context);
        boolean ret = result.contains(smsGate.getSucessResult());
        userAdditionalForm.setResponceMessage(ret ? CodeConstants.SEND_SUCCESS : result);
        logger.info("smsSend:  send sms by order {} to user {} to phone {} is result {}",
                orderUUID,
                userAdditionalForm.getIin(),
                phone,
                result
        );
        return ret;
    }


    private String getText(SmsGate smsGate, Order order, UserAdditionalForm userAdditionalForm) {

        SimpleDateFormat formatDateJava = new SimpleDateFormat("dd/MM/yyyy");

        return smsGate.getMessageContext()
                .replace("%FULL_NAME%", userAdditionalForm.getFullName())
                .replace("%NAME_BOOK%", order.getNameofbook())
                .replace("%DATE_DELIVERY%", formatDateJava.format(order.getDateofvidacha()))
                .replace("%DATE_BACK%", formatDateJava.format(order.getSrokvozvrata())).replaceAll("[\n\r]", "");
    }


    public boolean sendPlainSms(String message, String userId){
        UserAdditionalForm userAdditionalForm = null;
        boolean result = false;
        try {
            userAdditionalForm = userAdditionalFormReader.getForm(ConfigUtils.getQueryContext(),
                    userId);
        } catch (IOException e) {
            logger.error("error read user info", e);
        }
        if (userAdditionalForm == null) {
            logger.error("smsSend: can't find user info by userId - {}", userId);
            return result;
        }
        List<SmsGate> smsGates = smsGateRepository.getActiveSmsGates();

        for (SmsGate smsGate : smsGates) {
            for (String phone : userAdditionalForm.getPhones()) {
                try {
                    result = result || sendOnePlainSms(message, phone, userAdditionalForm, smsGate);
                } catch (IOException e) {
                    logger.error("error send one sms", e);
                }
            }
            if (result) {
                break;
            }
        }
        return result;

    }

    private boolean sendOnePlainSms(String message, String phone, UserAdditionalForm userAdditionalForm, SmsGate smsGate) throws IOException {
        boolean result = sendMessage(smsGate, phone, userAdditionalForm, message, "-");
        saveJurnal(new Order(), smsGate, userAdditionalForm, phone);
        return result;
    }

}
