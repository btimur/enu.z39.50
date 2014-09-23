package kz.arta.ext.sms.rest;

import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.Jurnal;
import kz.arta.ext.sms.model.JurnalFilterEntity;
import kz.arta.ext.sms.model.SmsGate;
import kz.arta.ext.sms.service.JurnalRepository;
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

@Path("/jurnal")
public class JurnalService {
    @Inject
    private Logger log;

    @Inject
    private JurnalRepository repository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getFindLibraries")
    public List<Jurnal> getFindSmsGates() {
        return repository.getJurnals();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Jurnal get(@PathParam("id") Long id) {
        return repository.find(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchJurnals")
    public JurnalFilterEntity searchJurnals(JurnalFilterEntity jurnalFilterEntity) {

        jurnalFilterEntity.setJurnals(repository.getJurnalsByFinter(jurnalFilterEntity));
        jurnalFilterEntity.setCountRecord(repository.getCountRecord(jurnalFilterEntity));
        return jurnalFilterEntity;
    }

}
