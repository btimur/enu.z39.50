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
@SuppressWarnings({"CdiInjectionPointsInspection", "UnusedDeclaration"})
@MessageDriven(name = "IndexDeleteZebraQueue",
        activationConfig =
                {
                        @ActivationConfigProperty(propertyName = "destinationType",
                                propertyValue = "javax.jms.Queue"),
                        @ActivationConfigProperty(propertyName = "destination",
                                propertyValue = CodeConstants.INDEX_DELETE_ZEBRA_JMS_DESTINATION)
                })
public class DeleteIndexZebraListener implements MessageListener {

    @Inject
    private Logger log;

    @Inject
    private ExporterForIndexer exporter;

    @Override
    public void onMessage(Message message) {
        log.info(" zebra delete index get message {}", message);
        if (!(message instanceof TextMessage)) {
            return;
        }
//            BlockSignalMessage blockSignalMessage = mapper.readValue(((TextMessage) message).getText(), BlockSignalMessage.class);
//            boolean result  = sender.sendSms(blockSignalMessage.getDataUUID());
        try {
            String dataUUID = ((TextMessage) message).getText();
            log.info("--------------DELETE ZEBRA INDEX FOR {}-----------------", dataUUID);
            exporter.deleteIndex(dataUUID);
        } catch (JMSException e) {
            log.error("error do message - {}", message);
        }

    }
}
