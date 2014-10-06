package kz.arta.ext.sms.rest;

import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.*;
import kz.arta.ext.sms.service.JurnalRepository;
import kz.arta.ext.sms.service.SmsGateRepository;
import kz.arta.ext.sms.service.SmsOrderRepository;
import kz.arta.ext.sms.service.SmsSender;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:01.
 */

@Path("/order")
public class SmsOrderService {
    @Inject
    private Logger log;

    @Inject
    private SmsOrderRepository repository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getFindLibraries")
    public List<SmsOrder> getFindSmsOrder() {
        return repository.getSmsOrders();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public SmsOrder get(@PathParam("id") Long id) {
        return repository.find(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("searchOrders")
    public OrderFilterEntity searchSmsOrders(OrderFilterEntity orderFilterEntity) {

        orderFilterEntity.setSmsOrders(repository.getOrderByFilter(orderFilterEntity));
        orderFilterEntity.setCountRecord(repository.getCountRecord(orderFilterEntity));
        return orderFilterEntity;
    }

}
