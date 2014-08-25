package kz.arta.ext.z3950.rest;

import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.service.LibraryRepository;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:01.
 */

@Path("/libraries")
public class LibraryRestService {
    @Inject
    private Logger log;

    @Inject
    private LibraryRepository libraryRepository;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getFindLibraries")
    public List<Library> getFindLibraries() {
        return libraryRepository.getLibraryList();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Library get(@PathParam("id") Long id) {
        return libraryRepository.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Library create(Library library) {
        return libraryRepository.save(library);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Library update(Library library) {
        return libraryRepository.update(library);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        libraryRepository.remove(id);
    }
}
