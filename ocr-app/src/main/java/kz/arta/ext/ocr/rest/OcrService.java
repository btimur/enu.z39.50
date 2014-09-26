package kz.arta.ext.ocr.rest;

import kz.arta.ext.ocr.model.RecognizeTask;
import kz.arta.ext.ocr.service.RecognizeService;
import kz.arta.ext.ocr.service.RecognizeTaskRepository;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by timur on 9/25/14.
 * rest оберктка
 */
@Path("/ocr")
public class OcrService {

    @Inject
    private Logger log;

    @Inject
    private RecognizeService service;

    @Inject
    private RecognizeTaskRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getFindLibraries")
    public boolean start(RecognizeTask task) {
        return service.startTask(task);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getFindLibraries")
    public List<RecognizeTask> getTasks() {

        return repository.getRecognizeTasks();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public RecognizeTask get(@PathParam("id") Long id) {
        return repository.find(id);
    }
}
