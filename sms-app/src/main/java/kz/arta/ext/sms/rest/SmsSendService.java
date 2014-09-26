package kz.arta.ext.sms.rest;

import kz.arta.ext.api.data.User;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.SmsWrapper;
import kz.arta.ext.sms.model.synergy.UserAdditionalForm;
import kz.arta.ext.sms.model.synergy.UserChooser;
import kz.arta.ext.sms.rest.api.UserAdditionalFormReader;
import kz.arta.ext.sms.service.JurnalRepository;
import kz.arta.ext.sms.service.SmsSender;
import kz.arta.ext.sms.util.CodeConstants;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

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
    private SmsSender smsSender;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getListUser")
    public   UserChooser[] getListUser(@QueryParam("term") String val) throws IOException {
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
    public SmsWrapper sendMessage(@QueryParam("phones") String[] phones, @QueryParam("message") String message) throws IOException {
        return smsSender.sendSmsWithText(phones,message);
    }
}
