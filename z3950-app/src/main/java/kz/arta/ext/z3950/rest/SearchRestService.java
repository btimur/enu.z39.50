package kz.arta.ext.z3950.rest;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.z3950.convert.MarcConverterBean;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.BookAttribute;
import kz.arta.ext.z3950.model.MarcString;
import kz.arta.ext.z3950.model.search.MultiResult;
import kz.arta.ext.z3950.model.search.SearchOneResult;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.model.search.SimpleSearch;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.service.LibraryRepository;
import kz.arta.ext.z3950.service.Z3950Searcher;
import kz.arta.ext.z3950.util.CacheManager;
import org.apache.logging.log4j.Logger;
import org.marc4j.marc.Record;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    private LibraryBookReader reader;

    @Inject
    private MarcConverterBean marcConverterBean;



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("simpleSeacrh")
    public SearchOneResult simpleSeacrh(SimpleSearch simpleSeacrh) {
        /***/
        SearchOneResult result = new SearchOneResult();
        try {
            SearchResult res = searcher.search(simpleSeacrh);

            result.setCount(res.getCount());
            for (Record record : res.getRecords()) {
                Book book = marcConverterBean.getConverter(libraryRepository.find(simpleSeacrh.getLibraryId())).convert(record);
                book.setRecord(record);
                book.setLibraryId(simpleSeacrh.getLibraryId());
                result.getBooks().add(book);
                CacheManager.getInstance().addRecord(book);
                book.setRecord(null);
            }
        } catch (Exception e) {
            log.error(e);
        }
        return result;
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
    public boolean importBook(Book book) {
        try {

            Record record = CacheManager.getInstance().getRecord(book);
            LibraryBook libraryBook = marcConverterBean.getConverter(libraryRepository.find(book.getLibraryId()))
                    .reverseConvert(record);
            return reader.upadateBook(book.getDataUUID(), libraryBook, ConfigUtils.getQueryContext());
        } catch (Exception e) {
            log.error(e);
            return false;
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("loadMarc")
    public MarcString loadMarc(@QueryParam("id") String id, @QueryParam("libraryId") Long libraryId) {
        try {

            Record record = getRecordFromCache(id, libraryId);
            MarcString marcString = new MarcString();
            String[] inputData =  record.toString().split("\n");
            StringBuilder builder = new StringBuilder(" <table class=\"tableMARC21Tagged\">\n");
            for(int i=0;i<inputData.length;i++)
            {
                String val = inputData[i].trim();
                String[] subVal = val.split("\t");
                builder.append("<tr>");
                if(subVal.length>0)
                {
                    builder.append("<td><strong>").append(subVal[0]).append("</strong></td>");
                }
                if(subVal.length>1)
                {
                    builder.append("<td>").append(subVal[1]).append("</td>");
                }
                builder.append("</tr>");
            }
            builder.append("<table>");
            marcString.setMarc(record.toString());
            return marcString;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    protected Book getSimpleBook(String id, Long libraryId) {
        Book book = new Book();
        book.setId(id);
        book.setLibraryId(libraryId);
        return book;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("loadDescr")
    public List<BookAttribute> loadDescr(@QueryParam("id") String id, @QueryParam("libraryId") Long libraryId) {
        try {
            Record record = getRecordFromCache(id, libraryId);
            return marcConverterBean.getConverter(libraryRepository.find(libraryId)).loadDescr(record);
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    protected Record getRecordFromCache(String id, Long libraryId) {
        Book book = getSimpleBook(id, libraryId);
        return CacheManager.getInstance().getRecord(book);
    }
}
