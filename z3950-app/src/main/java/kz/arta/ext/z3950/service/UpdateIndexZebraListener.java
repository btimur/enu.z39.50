package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.util.CodeConstants;
import org.slf4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by timur on 9/9/14.
 * Слушатель для событий изменеия книг для переиндексации в Zebra
 */
@MessageDriven(name = "IndexZebraQueue",
        activationConfig =
                {
                        @ActivationConfigProperty(propertyName = "destinationType",
                                propertyValue = "javax.jms.Queue"),
                        @ActivationConfigProperty(propertyName = "destination",
                                propertyValue = CodeConstants.INDEX_ZEBRA_JMS_DESTINATION)
                })
public class UpdateIndexZebraListener implements MessageListener {

    @Inject
    private Logger log;

    @Inject
    private ExporterForIndexer exporter;

    @Override
    public void onMessage(Message message) {
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        log.info(" zebra get message {}", message);
        if (!(message instanceof TextMessage)) {
            return;
        }
//            BlockSignalMessage blockSignalMessage = mapper.readValue(((TextMessage) message).getText(), BlockSignalMessage.class);
//            boolean result  = sender.sendSms(blockSignalMessage.getDataUUID());
        try {
            String dataUUID = ((TextMessage) message).getText();
            log.info("------------------------------------------------------------------");
            log.info("--------------UPDATE ZEBRA INDEX FOR {}-----------------", dataUUID);
            log.info("------------------------------------------------------------------");
            exporter.export(dataUUID, true);
        } catch (JMSException e) {
            log.error("error do message - {}", message);
        }

    }
}
