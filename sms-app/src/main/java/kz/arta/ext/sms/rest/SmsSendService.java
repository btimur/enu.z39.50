package kz.arta.ext.sms.rest;

import kz.arta.ext.sms.model.SmsWrapper;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.model.synergy.UserChooser;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.service.SmsPlainSender;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by admin on 25.09.14.
 */

@Path("/smssend")
public class SmsSendService {
    @Inject
    private Logger log;

    @Inject
    private UserAdditionalFormReader userAdditionalFormReader;

    @Inject
    private SmsPlainSender sendPlainSms;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getListUser")
    public UserChooser[] getListUser(@QueryParam("term") String val) throws IOException {
        return userAdditionalFormReader.getListUser(val);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUserInfo")
    public UserAdditionalForm getUserInfo(@QueryParam("userId") String userId) throws IOException {
        return userAdditionalFormReader.getUserInfo(userId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("sendMessage")
    public SmsWrapper sendMessage(@QueryParam("userId") String userId, @QueryParam("message") String message) throws IOException {
        SmsWrapper smsWrapper = new SmsWrapper();
        smsWrapper.setSuccess(sendPlainSms.sendPlainSms(message,userId));
        return smsWrapper;


    }
}
