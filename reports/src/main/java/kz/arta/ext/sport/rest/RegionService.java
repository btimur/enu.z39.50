package kz.arta.ext.sport.rest;

import kz.arta.ext.sport.model.report.ConfederationReport;
import kz.arta.ext.sport.service.RegionReportManager;
import kz.arta.ext.sport.service.SyncDataManager;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by admin on 22.10.14.
 */
    @Path("/region")
    public class RegionService {
        @Inject
        private Logger log;

        @Inject
        private SyncDataManager syncDataManager;

        @Inject
        private RegionReportManager regionReportRepository;



        @GET
        @Produces(MediaType.APPLICATION_JSON)
//    @Path("getCategories")
        public ConfederationReport getCategories(@QueryParam("id") String id,@QueryParam("region") String region) {

            return regionReportRepository.getConfederationReport(id, region);
        }
    }
