package kz.arta.ext.sms.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.SmsOrder;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 06.10.14.
 */
@Stateless
public class SmsPlainSender {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger logger;

    @Inject
    private SmsGateRepository smsGateRepository;

    @Inject
    private JurnalRepository jurnalRepository;

    @Inject
    private SmsSender smsSender;

    @Inject
    private SendService sendService;


    @Inject
    private UserAdditionalFormReader userAdditionalFormReader;

    public boolean sendPlainSms(String message, String userId) {
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
        boolean result = sendService.sendMessage(smsGate, phone, userAdditionalForm, message);
        jurnalRepository.save(smsSender.createJurnal(new SmsOrder(), smsGate, userAdditionalForm, phone));
        return result;
    }
}
