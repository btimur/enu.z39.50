package kz.arta.ext.sms.service;

import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.common.util.StringUtils;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.SmsOrder;
import kz.arta.ext.sms.rest.SmsQuery;
import kz.arta.ext.sms.util.CodeConstants;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 06.10.14.
 */
@Stateless
public class OldNotSendManager {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger logger;
    @Inject
    private SmsGateRepository smsGateRepository;

    @Inject
    private SmsOrderRepository smsOrderRepository;

    @Inject
    private JurnalRepository jurnalRepository;

    public boolean CheckStatusOldOrder() throws IOException {

        logger.info("smsSend.OldNotSendManager start");
        List<SmsOrder> smsOrders = smsOrderRepository.GetListNotSendFirstTime();
        boolean res = false;
        for (SmsOrder smsOrder : smsOrders) {
            logger.info("smsSend.OldNotSendManager order by - {}", smsOrder.getDataUUID());
            List<Jurnal> jurnalList = jurnalRepository.getListNotSendByOrderUid(smsOrder.getDataUUID());
            for (Jurnal jurnal : jurnalList) {
                if (!jurnal.getResult().contains(CodeConstants.SEND_SUCCESS)) {

                    SmsGate smsGate = jurnal.getSmsGate();
                    if (trySend(jurnal, smsGate)) {
                        res = true;
                    }
                }
            }
            if (res) {
                smsOrder.setSended(true);
                smsOrder.setSendDate(new Timestamp(new Date().getTime()));
                smsOrderRepository.update(smsOrder);
            }

        }
        return res;
    }


    private boolean trySend(Jurnal jurnal, SmsGate smsGate) throws IOException {
        if (smsGate != null && !StringUtils.isNullOrEmpty(smsGate.getCheckStatusUrl())) {
            String query = smsGate.getCheckStatusUrl()
                    .replace("%ENU_LOGIN%", smsGate.getsLogin())
                    .replace("%ENU_PWD%", smsGate.getsPwd())
                    .replace("%SMS_ID%", jurnal.getSmsIdSend())
                    .replace("%ENU_PHONES%", jurnal.getPhone());
            logger.info("smsSend.OldNotSendManager query : {}", query);

            RestQueryContext context = new RestQueryContext();
            context.setAddress(query);
            context.setLogin(smsGate.getsLogin());
            context.setPassword(smsGate.getsPwd());

            String result = new SmsQuery().doGetQueryWithoutAuth(context);
            boolean res = result.contains(smsGate.getCheckStatusOk());
            if (res) {
                jurnal.setResult(CodeConstants.SEND_SUCCESS);
            } else {
                jurnal.setResult(result);
            }
            jurnalRepository.update(jurnal);
            logger.info("smsSend.OldNotSendManager response query {} ;result {}", query, result);

            return res;
        }
        return false;
    }
}
