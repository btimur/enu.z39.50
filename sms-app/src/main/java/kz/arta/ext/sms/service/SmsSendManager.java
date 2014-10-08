package kz.arta.ext.sms.service;

import org.slf4j.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by admin on 02.10.14.
 */
@Singleton
@Startup
public class SmsSendManager {
    @Inject
    private Logger log;

    @Inject
    private SmsSender sender;

    @Inject
    private OldNotSendManager oldNotSendManager;


//    @Schedule(second = "0", minute ="*/10", hour = "*")
    public void runTask() throws IOException {
        log.info("smsSend: run task sender sms");
//        oldNotSendManager.CheckStatusOldOrder();
//        sender.runSmsSender();
        log.info("smsSend: finish task sender sms");
    }
}
