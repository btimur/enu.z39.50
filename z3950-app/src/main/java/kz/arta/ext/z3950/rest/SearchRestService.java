package kz.arta.ext.z3950.rest;

import kz.arta.ext.z3950.convert.IMarcConverter;
import kz.arta.ext.z3950.model.Book;
import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.search.SearchCondition;
import kz.arta.ext.z3950.model.search.SearchFilter;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.service.LibraryRepository;
import kz.arta.ext.z3950.service.Z3950Searcher;
import org.apache.log4j.Logger;
import org.marc4j.marc.Record;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.*;
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
    private IMarcConverter marcConverter;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("simpleSeacrh")
    public List<Book> simpleSeacrh(SimpleSeacrh simpleSeacrh) {

        try {
            SearchResult result = getSearchResult(simpleSeacrh);
            List<Book> books = new ArrayList<Book>();
            for (Object record :result.getRecords()) {
                Book book = marcConverter.convert((Record) record);
                book.setRec(record);
                books.add(book);
            }
            //[TODO] cache
            return books;
        } catch (Exception e) {
            log.error(e);
            return null;
        }

    }

    private SearchResult getSearchResult(SimpleSeacrh simpleSeacrh) throws Exception {
        Z3950Searcher searcher = new Z3950Searcher();
        Library library = libraryRepository.getDefaultLibrary();
        SearchFilter filter = new SearchFilter();
        filter.setMaxResult(10);
        SearchCondition condition = new SearchCondition();
        condition.setCql(simpleSeacrh.getTerm());
//        condition.setCql("Title=Филипок");
//        condition.setCql("Identifier=978-5-386-03198-5");
        filter.getConditions().add(condition);
        return searcher.searchCql(library, filter);
    }

}
