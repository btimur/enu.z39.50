package kz.arta.ext.z3950.rest;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.z3950.convert.MarcConverterBean;
import kz.arta.ext.z3950.model.*;
import kz.arta.ext.z3950.model.search.MultiResult;
import kz.arta.ext.z3950.model.search.SearchOneResult;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.model.search.SimpleSearch;
import kz.arta.ext.z3950.model.synergy.LibraryBook;
import kz.arta.ext.z3950.rest.api.LibraryBookReader;
import kz.arta.ext.z3950.service.LibraryRepository;
import kz.arta.ext.z3950.service.Z3950Searcher;
import kz.arta.ext.z3950.util.CacheManager;
import org.marc4j.marc.*;
import org.slf4j.Logger;

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
            log.error("error search", e);
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
            log.error("error multi search", e);
            return new MultiResult(simpleSeacrh.getLibraryId(), 0l);
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("importBook")
    public ImportWrapper importBook(Book book) {
        try {

            Record record = CacheManager.getInstance().getRecord(book);
            LibraryBook libraryBook = marcConverterBean.getConverter(libraryRepository.find(book.getLibraryId()))
                    .reverseConvert(record);
            return reader.createBook(libraryBook, getRegistryUUID(book.getBooktype()), ConfigUtils.getQueryContext());
        } catch (Exception e) {
            log.error("error import book", e);

            return new ImportWrapper(false);
        }
    }

    private String getRegistryUUID(String booktype) {
        return booktype;
//        return ConfigReader.getPropertyValue(booktype);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("loadMarc")
    public MarcString loadMarc(@QueryParam("id") String id, @QueryParam("libraryId") Long libraryId) {
        try {

            Record record = getRecordFromCache(id, libraryId);

            MarcTextFiled leader = new MarcTextFiled("LDR", record.getLeader().toString(), null);
            MarcString marcString = new MarcString(leader);

            for (VariableField variableField : record.getVariableFields()) {
                MarcTextFiled field;
                if (variableField instanceof DataField) {
                    char[] inds = new char[]{((DataField) variableField).getIndicator1(),
                            ((DataField) variableField).getIndicator2()};
                    field = new MarcTextFiled(variableField.getTag(), null, new String(inds));
                    for (Subfield subfield : ((DataField) variableField).getSubfields()) {
                        MarcSubTextFiled sub = new MarcSubTextFiled(String.valueOf(subfield.getCode()), subfield.getData());
                        field.getSubfields().add(sub);
                    }
                } else {
                    field = new MarcTextFiled(variableField.getTag(), ((ControlField) variableField).getData(), null);
                }

                marcString.getFields().add(field);
            }
//            marcString.setMarc(record.toString().trim());
            return marcString;
        } catch (Exception e) {
            log.error("error load marc", e);
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
            log.error("error load simple description", e);
            return null;
        }
    }

    protected Record getRecordFromCache(String id, Long libraryId) {
        Book book = getSimpleBook(id, libraryId);
        return CacheManager.getInstance().getRecord(book);
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("getRegistries")
//    public List<RegistryBookWrapper> getRegistries(){
//        List list = new ArrayList();
//        RegistryBookWrapper registry = new RegistryBookWrapper();
//        registry.setName("test");
//        registry.setRegistryUUID("testUUID");
//        list.add(registry);
//        return list;
//    }
}
