package kz.arta.ext.sport.rest;

import kz.arta.ext.sport.model.report.ConfederationReport;
import kz.arta.ext.sport.service.ReportManager;
import kz.arta.ext.sport.service.SyncDataManager;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by admin on 20.10.14.
 */
@Path("/federation")
public class FederationService {
    @Inject
    private Logger log;

    @Inject
    private SyncDataManager syncDataManager;

    @Inject
    private ReportManager reportRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("syncData")
    public boolean syncData() throws IOException {
      return   syncDataManager.Run();
//        return true;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getCategories")
    public ConfederationReport getCategories(@QueryParam("id") String id) {

        return reportRepository.getConfederationReport(id);
    }
}
