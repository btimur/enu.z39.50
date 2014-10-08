package kz.arta.ext.sms.rest;

import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sms.model.*;
import kz.arta.ext.sms.service.*;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
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

    @Inject
    private SmsSender sender;

    @Inject
    private OldNotSendManager oldNotSendManager;

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("startSync")
    public void startSync() throws IOException {
        log.info("smsSend: run manual sender sms");
        oldNotSendManager.CheckStatusOldOrder();
        sender.runSmsSender();
        log.info("smsSend: finish manual sender sms");
    }
}
