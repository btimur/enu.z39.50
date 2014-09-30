package kz.arta.ext.ocr.rest;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.ocr.model.RecognizeTask;
import kz.arta.ext.ocr.recognizer.RecognizeManager;
import kz.arta.ext.ocr.service.RecognizeService;
import kz.arta.ext.ocr.service.RecognizeTaskRepository;
import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;
import java.util.Map;

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
    @Path("start")
    public boolean start(@QueryParam("documentID")String documentID,
                         @QueryParam("dataUUID")String dataUUID,
                         @QueryParam("filename")String filename) {
        log.info("start ocr documentID - {} , dataUUID - {}, filename - {}", documentID, dataUUID, filename);
        return service.startTask(documentID, dataUUID, filename);
    }

    @POST
    @Path("/upload")
    @Consumes("multipart/form-data")
    public Response uploadFile(MultipartFormDataInput input) throws IOException {
//                               @QueryParam("flowChunkNumber")Integer flowChunkNumber,
//                               @QueryParam("flowTotalChunks")Integer flowTotalChunks,
//                               @QueryParam("flowChunkSize")Integer flowChunkSize,
//                               @QueryParam("flowTotalSize")Integer flowTotalSize,
//                               @QueryParam("flowIdentifier")String flowIdentifier,
//                               @QueryParam("flowFilename")String flowFilename,
//                               @QueryParam("flowRelativePath")String flowRelativePath
//                               ) {


        Map<String, List<InputPart>> formParts = input.getFormDataMap();
        String fileName = formParts.get("flowFilename").get(0).getBodyAsString();
        String flowChunkNumber = formParts.get("flowChunkNumber").get(0).getBodyAsString();
        String flowTotalSize = formParts.get("flowTotalSize").get(0).getBodyAsString();
        log.info("load file {} chunk - {} totalSize -{}", fileName, flowChunkNumber, flowTotalSize);
        List<InputPart> inPart = formParts.get("file");

        for (InputPart inputPart : inPart) {

            try {

                // Retrieve headers, read the Content-Disposition header to obtain the original name of the file
                MultivaluedMap<String, String> headers = inputPart.getHeaders();
//                fileName = parseFileName(headers);

                // Handle the body of that part with an InputStream
                InputStream istream = inputPart.getBody(InputStream.class,null);

                fileName = ConfigReader.getPropertyValue(RecognizeManager.OCR_TEMP_DIR) + "//" + fileName;

                saveFile(istream, fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String output = "File saved to server location : " + fileName;

        return Response.status(200).entity(output).build();
    }
//    // Parse Content-Disposition header to get the original file name
//    private String parseFileName(MultivaluedMap<String, String> headers) {
//        String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");
//        for (String name : contentDispositionHeader) {
//            if ((name.trim().startsWith("filename"))) {
//                String[] tmp = name.split("=");
//                String fileName = tmp[1].trim().replaceAll("\"","");
//                return fileName;
//            }
//        }
//        return "randomName";
//    }

    private void saveFile(InputStream uploadedInputStream, String serverLocation) {

        try {
            FileWriter writer = new FileWriter(serverLocation, true);
            IOUtils.copy(uploadedInputStream, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
