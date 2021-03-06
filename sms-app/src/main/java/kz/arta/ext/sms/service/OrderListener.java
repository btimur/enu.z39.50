package kz.arta.ext.sms.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.synergy.BlockSignalMessage;
import kz.arta.ext.sms.util.CodeConstants;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;

/**
 * Created by timur on 8/28/2014 10:46 AM.
 */
@MessageDriven(name = "SmsBlockQueue",
        activationConfig =
                {
                        @ActivationConfigProperty(propertyName = "destinationType",
                                propertyValue = "javax.jms.Queue"),
                        @ActivationConfigProperty(propertyName = "destination",
                                propertyValue = CodeConstants.JMS_DESTINATION)
                })

public class OrderListener implements MessageListener {
    @Inject
    private Logger log;

    @Inject
    private SmsSender sender;


    @Override
    public void onMessage(Message message) {
        if (!(message instanceof TextMessage)){
            return;
        }
        log.info("smsSend: sms message - {}", message);
        ObjectMapper mapper = new ObjectMapper();
        try {
            BlockSignalMessage blockSignalMessage = mapper.readValue(((TextMessage) message).getText(), BlockSignalMessage.class);
            log.info("smsSend: parsed message -{}", blockSignalMessage.toString());
            sender.saveOrUpdateOrder(blockSignalMessage, ConfigUtils.getQueryContext());
//            sender.sendSms(blockSignalMessage, ConfigUtils.getQueryContext());

        } catch (IOException e) {
            log.error("error parse message", e);
        } catch (JMSException e) {
            log.error("error process message", e);
        }

    }
}
