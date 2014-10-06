package kz.arta.ext.z3950.rest;

import kz.arta.ext.z3950.model.External;
import kz.arta.ext.z3950.service.ExternalRepository;
import kz.arta.ext.z3950.service.ExternalUpdater;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:01.
 * REST сервис для управления Логин доступа для внешних пользователей
 */

@Path("/externals")
public class ExternalRestService {
    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger log;

    @Inject
    private ExternalRepository repository;

    @Inject
    private ExternalUpdater updater;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("list")
    public List<External> getExternal(@QueryParam("all")Boolean all) {
        log.debug("getExternal - {}", all);
        return repository.getExternalList(all);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public External get(@PathParam("id") Long id) {
        return repository.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public External create(External external) throws IOException {
        log.debug("call create login - {}", external.getLogin());
        External save = repository.save(external);
        updater.update(save);
        return save;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public External update(External external) throws IOException {
        log.debug("call remove update id - {}", external.getId());
        External update = repository.update(external);
        updater.update(update);
        return update;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void remove(@PathParam("id") Long id) throws IOException {
        log.debug("call remove user id - {}", id);
        External ext  = repository.find(id);
        ext.setDeleted(true);
        updater.remove(ext);
        repository.update(ext);

    }
}
