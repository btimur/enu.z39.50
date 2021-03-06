package kz.arta.ext.sms.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.data.Dictionary;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.SmsOrder;
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
import java.util.*;

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
    private SmsOrderRepository smsOrderRepository;

    @Inject
    private OrderReader reader;

    @Inject
    private UserAdditionalFormReader userAdditionalFormReader;

    @Inject
    private SendService sendService;

    public void runSmsSender() {
        List<String> userIds = smsOrderRepository.getDistinctUserId();
        if (userIds == null || userIds.size() == 0) {
            logger.info("smsSend: smsorder list is empty");
            return;
        }
        for (String userId : userIds) {
            logger.info("smsSend: smsorder userid - {}", userId);
            SendSmsByUserId(userId);
        }
    }

    public boolean sendSms(String userId, String srokVozvrata, List<SmsOrder> smsOrders, RestQueryContext context) {

        boolean result = false;
        UserAdditionalForm userAdditionalForm = null;
        try {
            userAdditionalForm = userAdditionalFormReader.getForm(context, userId);
        } catch (IOException e) {
            logger.error("error read userInfo", e);
        }
        if (userAdditionalForm == null) {
            logger.error("smsSend: can't find user info by user id - {}", userId);
            return result;
        }
        List<SmsGate> smsGates = smsGateRepository.getActiveSmsGates();

        for (SmsGate smsGate : smsGates) {
            for (String phone : userAdditionalForm.getPhones()) {
                try {
                    result = result || sendOneSms(srokVozvrata, smsOrders, phone, userAdditionalForm, smsGate);
                } catch (IOException e) {
                    logger.error("smsSend: error send sms", e);
                }
            }
            if (result) {
                break;
            }
        }
        smsOrderRepository.updateListWtithResult(smsOrders, result);
        return result;
    }


    private boolean sendOneSms(String srokVozvrata, List<SmsOrder> smsOrders, String phone, UserAdditionalForm userAdditionalForm, SmsGate smsGate) throws IOException {

        Integer countOrder = smsOrders.size();
        boolean result = sendService.trySend(srokVozvrata, smsGate, phone, countOrder, userAdditionalForm);
        saveJurnal(smsOrders, smsGate, userAdditionalForm, phone);
        return result;
    }

    private void saveJurnal(List<SmsOrder> smsOrders, SmsGate smsGate, UserAdditionalForm userAdditionalForm, String phone) {

        for (SmsOrder order : smsOrders) {
            Jurnal jurnal =jurnalRepository.save(createJurnal(order, smsGate, userAdditionalForm, phone));
            order.setJurnal(jurnal);

        }
    }
    public Jurnal createJurnal(SmsOrder order, SmsGate smsGate, UserAdditionalForm userAdditionalForm, String phone) {

        Jurnal jurnal = new Jurnal();
        jurnal.setSmsGate(smsGate);
        jurnal.setDateSend(new Timestamp(new Date().getTime()));
        jurnal.setOrderUUID(order.getDataUUID());
        jurnal.setOrderBookName(order.getNameofbook());
        jurnal.setMessage(userAdditionalForm.getMessage());
        jurnal.setResult(userAdditionalForm.getResponceMessage());
        jurnal.setFio(userAdditionalForm.getFullName());
        jurnal.setSmsIdSend(userAdditionalForm.getSmsId());
        if (userAdditionalForm.getIin().isEmpty()) {
            jurnal.setIin(CodeConstants.VALUE_IS_EMPTY);
        } else {
            jurnal.setIin(userAdditionalForm.getIin());
        }
        jurnal.setPhone(phone);


        return jurnal;
    }

    public boolean saveOrUpdateOrder(BlockSignalMessage blockSignalMessage, RestQueryContext context) {

        Order order = reader.readOrder(context, blockSignalMessage.getDataUUID());
        logger.info("smsSend: read order by -{}", order.getDataUUID());

        SmsOrder smsOrder = smsOrderRepository.findByOrderUid(order.getDataUUID());
        boolean result = false;
        if (smsOrder == null) {
            logger.info("smsSend: new  smsOrder order by -{}", order.getDataUUID());
            smsOrder = new SmsOrder();
        } else {
            logger.info("smsSend: exist  smsOrder order by -{}", order.getDataUUID());
        }
        smsOrder.setSrokvozvrata(order.getSrokvozvrata());
        smsOrder.setUserid(order.getUserid());
        smsOrder.setDataUUID(order.getDataUUID());
        smsOrder.setDateofvidacha(order.getDateofvidacha());
        smsOrder.setNameofbook(order.getNameofbook());
        smsOrder.setInvnum(order.getInvnum());
        smsOrder.setCountTry(0);
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
        smsOrder.setFio(userAdditionalForm.getFullName());
        smsOrder.setIin(userAdditionalForm.getIin());
        smsOrder.setRegDate(new Timestamp(new Date().getTime()));
        smsOrder.setExecuted(true);
        smsOrder.setSended(false);

        if (smsOrder.getId() == null || smsOrder.getId() == 0) {
            smsOrderRepository.save(smsOrder);
            logger.info("smsSend: save new smsorder by order - {}", blockSignalMessage.getDataUUID());

        } else {
            smsOrderRepository.update(smsOrder);
            logger.info("smsSend: update new smsorder by order - {}", blockSignalMessage.getDataUUID());
        }
        try {
            reader.unblockProcess(context, blockSignalMessage);
            result = true;
        } catch (IOException e) {
            logger.error("error unblock process", e);
            result = false;
        }
        return result;
    }



    private void SendSmsByUserId(String userId) {
        String DATE_FORMAT_NOW = "dd-MM-yy";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        List<SmsOrder> smsOrders = smsOrderRepository.getSmsOrdersByUserId(userId);
        if (smsOrders != null) {
            logger.info("smsSend: get list smsOrder count - {}", smsOrders.size());
        }
        Map<String, List<SmsOrder>> dictionary = new HashMap<String, List<SmsOrder>>();
        for (SmsOrder smsOrder : smsOrders) {
            String dateStr = sdf.format(smsOrder.getSrokvozvrata());
            List<SmsOrder> orders = null;
            if (dictionary.containsKey(dateStr)) {
                orders = dictionary.get(dateStr);
            } else {
                orders = new ArrayList<SmsOrder>();
            }
            orders.add(smsOrder);
            dictionary.put(dateStr, orders);
        }
        for (String date : dictionary.keySet()) {
            logger.info("smsSend: send sms for by userId - {} date - {} count order - {}", userId, date, dictionary.get(date));
            RestQueryContext context = ConfigUtils.getQueryContext();
            sendSms(userId, date, dictionary.get(date), context);

        }
    }
}
