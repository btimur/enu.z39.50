package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.model.ExportIndexWrapper;
import kz.arta.ext.z3950.util.CodeConstants;
import org.slf4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Created by timur on 9/22/14.
 * слушатель для полного экспорта
 */
@SuppressWarnings({"CdiInjectionPointsInspection", "UnusedDeclaration"})
@MessageDriven(name = "IndexAllZebraQueue",
        activationConfig =
                {
                        @ActivationConfigProperty(propertyName = "destinationType",
                                propertyValue = "javax.jms.Queue"),
                        @ActivationConfigProperty(propertyName = "destination",
                                propertyValue = CodeConstants.INDEX_ALL_ZEBRA_JMS_DESTINATION)
                })
public class AllExportListener  implements MessageListener {

    @Inject
    private Logger log;

    @Inject
    private ExporterForIndexer exporter;

    @Override
    public void onMessage(Message message) {
        log.info(" zebra all index get message {}", message);
        if (!(message instanceof ObjectMessage)) {
            return;
        }
        try {
            ExportIndexWrapper wrapper = (ExportIndexWrapper) ((ObjectMessage) message).getObject();

            log.info("--------------ALL ZEBRA INDEX FOR REGISTRY {}-----------------", wrapper.getEndPosition());
            exporter.exportAsyncRegistry(wrapper);
        } catch (JMSException e) {
            log.error("error do message - {}", message);
        }

    }
}