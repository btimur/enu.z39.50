package kz.arta.ext.sms.rest;

import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.model.SmsWrapper;
import kz.arta.ext.sms.service.SmsGateRepository;
import kz.arta.ext.sms.service.SmsSender;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by timur on 9/24/14.
 * sende sms to students
 */
@Path("/sms")
public class SmsProducer {

    @Inject
    private SmsSender sender;


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean sendSms(SmsWrapper wrapper){
        return sender.sendPlainSms(wrapper.getMessage(), wrapper.getUserId());
    }
}
