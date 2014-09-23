package kz.arta.ext.z3950.rest;

import kz.arta.ext.z3950.service.ExporterForIndexer;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by timur on 8/26/2014 12:34 PM.
 */
@Path("/marc")
public class MarcRestService{
    @Inject
    private Logger log;

    @Inject
    private ExporterForIndexer exporter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{dataUUID}")
    public boolean get(@PathParam("dataUUID") String dataUUID) {

        return exporter.export(dataUUID, true);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("exportAll/{registryFormUUID}")
    public String exportAll(@PathParam("registryFormUUID") String registryFormUUID) {

        return exporter.exportRegistry(registryFormUUID);
    }


}
