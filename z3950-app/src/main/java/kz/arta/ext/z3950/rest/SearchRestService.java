package kz.arta.ext.z3950.rest;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.z3950.convert.IMarcConverter;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.search.MultiResult;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.model.search.SimpleSearch;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.service.LibraryRepository;
import kz.arta.ext.z3950.service.Z3950Searcher;
import kz.arta.ext.z3950.util.CacheManager;
import kz.arta.ext.z3950.util.CodeConstants;
import org.apache.logging.log4j.Logger;
import org.marc4j.marc.Record;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 25/07/2014 12:01.
 */

@Path("/search")
public class SearchRestService {
    @Inject
    private Logger log;

    @Inject
    private LibraryRepository libraryRepository;

    @Inject
    private Z3950Searcher searcher;

    @Inject
    private IMarcConverter marcConverter;

    @Inject
    private LibraryBookReader reader;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getFindLibraries")
    public List<Library> getFindLibraries() {

        return libraryRepository.getLibraryList();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("simpleSeacrh")
    public List<Book> simpleSeacrh(SimpleSearch simpleSeacrh) {
        /***/
        try {
            SearchResult result = searcher.search(simpleSeacrh);
            List<Book> books = new ArrayList<Book>();
            for (Record record : result.getRecords()) {
                Book book = marcConverter.convert(record);
                book.setRecord(record);
                books.add(book);
                CacheManager.getInstance().addRecord(book);
                book.setRecord(null);
            }
            return books;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("multiSeacrh")
    public MultiResult multiSeacrh(SimpleSearch simpleSeacrh) {
        try {
            return searcher.searchMulti(simpleSeacrh);
        } catch (Exception e) {
            log.error(e);
            return new MultiResult(simpleSeacrh.getLibraryId(), 0l);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("importBook")
    public String importBook(Book book) {
        try {

            Record record = CacheManager.getInstance().getRecord(book);
            LibraryBook libraryBook = marcConverter.reverseConvert(record);
            reader.setRegistryUUID(getNeedReest(book.getBooktype()));
            return reader.Save(libraryBook, ConfigUtils.getQueryContext());
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private String getNeedReest(String booktype) {
        return ConfigReader.getPropertyValue(booktype + CodeConstants.REGISTRY_UUID);
    }

}
