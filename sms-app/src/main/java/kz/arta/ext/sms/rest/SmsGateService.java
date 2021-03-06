package kz.arta.ext.sms.rest;

import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.service.SmsGateRepository;
import kz.arta.ext.sms.service.SmsSender;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:01.
 */

@Path("/smsgate")
public class SmsGateService {
    @Inject
    private Logger log;

    @Inject
    private SmsGateRepository repository;

    @Inject
    private SmsSender smsSender;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getFindLibraries")
    public List<SmsGate> getFindSmsGates() {
        return repository.getSmsGates();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public SmsGate get(@PathParam("id") Long id) {
        return repository.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SmsGate create(SmsGate smsGate) {
        if(smsGate==null)
        {
            return null;
        }
        smsGate.setDeleted(false);
        return repository.save(smsGate);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SmsGate update(SmsGate smsGate) {
        return repository.update(smsGate);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        repository.remove(id);
    }
}
