package kz.arta.ext.api.rest;

import kz.arta.ext.api.data.StartFileResponse;
import kz.arta.ext.common.util.CodeConstants;
import org.codehaus.jackson.map.ObjectMapper;

import java.net.URLEncoder;

/**
 * Created by timur on 9/26/14.
 * для работы с rest  операции с файлами
 */
public class FileReader extends RestQuery {

    public String startUploadFile(RestQueryContext context) {
        try {

            String query = "/rest/api/storage/start_upload";
            String resultData = doGetQuery(context, query);
            log.debug("resultData = {}", resultData);
            ObjectMapper objectMapper = new ObjectMapper();
            StartFileResponse response = objectMapper.readValue(resultData, StartFileResponse.class);
            if (response.getErrorCode().equals(CodeConstants.NO_ERROR)) {
                return response.getFile();
            }
        } catch (Exception e) {
            log.error("error startUploadFile ", e);

        }
        return null;
    }

    public boolean uploadPart(RestQueryContext context, String file, String data) {
        try {
            log.debug("uploadPart size ={}", data.length());
            String query = String.format("/rest/api/storage/upload_part?file=%s",
                    file);
            log.info("query  - {}", query );
            String resultData = doPostQuery(context, query, data, "body");
            log.debug("resultData = {}", resultData);
            ObjectMapper objectMapper = new ObjectMapper();
            StartFileResponse response = objectMapper.readValue(resultData, StartFileResponse.class);
            if (response.getErrorCode().equals(CodeConstants.NO_ERROR)) {
                return true;
            } else {
                log.error("error upload file {} errorCode - {} errorMessage - {} ", file,
                        response.getErrorCode(), response.getErrorMessage());
            }
        } catch (Exception e) {
            log.error("error startUploadFile ", e);

        }
        return false;
    }


    public boolean createAttachment(RestQueryContext context, String docId, String fileName, String filePath) {
        try {

            String query = String.format("/rest/api/storage/document/%s/attachment/create", docId);
            String data = String.format("docID=%s&path=ase:attachmentContainer&fileName=%s&filePath=%s&",
                    docId, URLEncoder.encode(fileName, CodeConstants.ENCODING_UFT_8),
                    URLEncoder.encode(filePath, CodeConstants.ENCODING_UFT_8));
            log.info("query  - {}", query );
            String resultData = doPostBodyQuery(context, query, data);
            log.debug("resultData = {}", resultData);
            ObjectMapper objectMapper = new ObjectMapper();
            StartFileResponse response = objectMapper.readValue(resultData, StartFileResponse.class);
            if (response.getErrorCode().equals(CodeConstants.NO_ERROR)) {
                return true;
            } else {
                log.error("error createAttachment doc {} filePath -{} errorCode - {} errorMessage - {} ", docId,
                        filePath,
                        response.getErrorCode(), response.getErrorMessage());
            }
        } catch (Exception e) {
            log.error("error createAttachment ", e);

        }
        return false;
    }
}
