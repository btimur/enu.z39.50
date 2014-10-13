package kz.arta.ext.sms.service;

import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.rest.SmsQuery;
import kz.arta.ext.sms.util.CodeConstants;
import kz.arta.ext.sms.util.Translit;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by admin on 06.10.14.
 */
public class SendService {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger logger;
    @Inject
    private SmsGateRepository smsGateRepository;


    public boolean trySend(String srokVozvrata, SmsGate smsGate, String phone, Integer countOrder, UserAdditionalForm userAdditionalForm) throws IOException {
        String message = getText(smsGate, srokVozvrata, countOrder, userAdditionalForm);
        return sendMessage(smsGate, phone, userAdditionalForm, message);
    }

    private String getText(SmsGate smsGate, String srokVozvrata, Integer countOrder, UserAdditionalForm userAdditionalForm) {

        return smsGate.getMessageContext()
                .replace("%FULL_NAME%", userAdditionalForm.getFullName())
                .replace("%COUNT_BOOK%", countOrder.toString())
                .replace("%DATE_BACK%", srokVozvrata).replaceAll("[\n\r]", "");
    }

    public boolean sendMessage(SmsGate smsGate, String phone, UserAdditionalForm userAdditionalForm,
                               String message) throws IOException {
        RestQueryContext context = new RestQueryContext();
        String query = smsGate.getTemplate()
                .replace("%ENU_LOGIN%", smsGate.getsLogin())
                .replace("%ENU_PWD%", smsGate.getsPwd())
                .replace("%ENU_PHONES%", phone);
        userAdditionalForm.setMessage(message);
        logger.info("smsSend: message text - {}", message);
        if (smsGate.getTranslit()) {
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
        if (!StringUtils.isNullOrEmpty(smsGate.getSmsIdStart())) {
            userAdditionalForm.setSmsId(getSmsId(result, smsGate.getSmsIdStart()));
//
//            Integer end
//            result.indexOf(starIndex, " ");
//            userAdditionalForm.setSmsId();
        }

        logger.info("smsSend:  send sms by order to user {} to phone {} is result {}",
                userAdditionalForm.getIin(),
                phone,
                result
        );
        return ret;
    }

    private String getSmsId(String result, String idIndex) {
        Character[] chars = {' ', ';'};

        Integer beginIndex = result.indexOf(idIndex);
        if (beginIndex < 1) {
            return null;
        }
        String s = result.substring(beginIndex + idIndex.length()).trim();
        Integer endIndex = 0;
        for (Character character : chars) {
            if (s.indexOf(character) > 0) {
                endIndex = s.indexOf(character);
                break;
            }
        }
        if (endIndex == 0) {
            endIndex = s.length();
        }
        return s.substring(0, endIndex);

    }

}
