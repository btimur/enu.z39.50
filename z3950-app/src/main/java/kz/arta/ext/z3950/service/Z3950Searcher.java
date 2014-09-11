package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.QueryType;
import kz.arta.ext.z3950.model.search.MultiResult;
import kz.arta.ext.z3950.model.search.SearchFilter;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.model.search.SimpleSearch;
import kz.arta.ext.z3950.search.QueryBuilderFactory;
import kz.arta.ext.z3950.util.SomeMarcStreamReader;
import org.marc4j.MarcReader;
import org.slf4j.Logger;
import org.yaz4j.*;
import org.yaz4j.exception.ZoomException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.ByteArrayInputStream;

/**
 * Created by timur on 25/07/2014 12:47.
 * Бин поиска по протоколу Z39.50
 */
@Stateless
public class Z3950Searcher {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger log;

    @Inject
    private LibraryRepository libraryRepository;

    public SearchResult search(Library library, SearchFilter filter) throws Exception {
        Connection con = new Connection(library.getZhost(), library.getZport());
        con.setSyntax(library.getzFormat());
        con.setDatabaseName(library.getZdb());
        SearchResult result;
        try {
            con.connect();
            PrefixQuery query =
                    new PrefixQuery(filter.createPrefixQueryString());
            ResultSet set = con.search(query);
            log.info("Showing {} of {}", set.getHitCount(), filter.getMaxResult());
            result = new SearchResult();
            for (int i = 0; i < set.getHitCount() && i < filter.getMaxResult(); i++) {
                Record rec = set.getRecord(i);
                log.debug(rec.getSyntax());
                org.marc4j.marc.Record marc = readMarc(rec, library);
                log.debug(marc.toString());
                result.getRecords().add(marc);
            }

        } catch (ZoomException ze) {
            throw new Exception(ze);
        } finally {
            con.close();
        }
        return result;
    }

    public MultiResult searchMulti(SimpleSearch search) throws Exception {
        Library library = libraryRepository.find(search.getLibraryId());
        log.debug("searchMulti library {}, search = {}", library, search);

        Connection con = new Connection(library.getZhost(), library.getZport());
        con.setSyntax(library.getzFormat());
        con.setDatabaseName(library.getZdb());
        MultiResult result = new MultiResult();
        result.setLibraryId(search.getLibraryId());
        result.setCountResult(0L);
        try {
            con.connect();
            Query query = QueryBuilderFactory.createBuilder(QueryType.valueOf(library.getQueryType())).createQuery(search);
            ResultSet set = con.search(query);
            log.info("Showing {} of {}", search.getMaxResult(), set.getHitCount());
            result.setCountResult(set.getHitCount());

        } catch (ZoomException ze) {
            throw new Exception(ze);
        } finally {
            con.close();
        }
        return result;
    }

    public SearchResult search(SimpleSearch search) throws Exception {
        Library library = libraryRepository.find(search.getLibraryId());
        Connection con = new Connection(library.getZhost(), library.getZport());
        con.setSyntax(library.getzFormat());
        con.setDatabaseName(library.getZdb());
        SearchResult result;
        try {
            con.connect();
            Query query = QueryBuilderFactory.createBuilder(QueryType.valueOf(library.getQueryType())).createQuery(search);
            ResultSet set = con.search(query);
            log.info("Showing {} of {}", search.getMaxResult(), set.getHitCount());
            result = new SearchResult();
            for (int i = search.getNextElement(); i < set.getHitCount()
                    && i < search.getNextElement() + search.getMaxResult(); i++) {
                Record rec = set.getRecord(i);
                log.debug(rec.getSyntax());
                log.debug(rec.render());
                result.getRecords().add(readMarc(rec, library));
            }
            result.setCount(set.getHitCount());

        } catch (ZoomException ze) {
            throw new Exception(ze);
        } finally {
            con.close();
        }
        return result;
    }

    public org.marc4j.marc.Record readMarc(Record rec, Library library) {
        byte[] b = rec.getContent();
        ByteArrayInputStream stream = new ByteArrayInputStream(b);
        MarcReader reader = new SomeMarcStreamReader(stream, library.getEncoding());
        return reader.next();
    }
}
