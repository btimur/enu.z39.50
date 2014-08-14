package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.QueryType;
import kz.arta.ext.z3950.model.search.SearchFilter;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.model.SimpleSearch;
import kz.arta.ext.z3950.search.QueryBuilderFactory;
import kz.arta.ext.z3950.util.RuMarcStreamReader;
import org.apache.logging.log4j.Logger;
import org.marc4j.MarcReader;
import org.yaz4j.*;
import org.yaz4j.exception.ZoomException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.ByteArrayInputStream;

/**
 * Created by timur on 25/07/2014 12:47.
 */
@Stateless
public class Z3950Searcher {

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
            System.out.println("Showing " + set.getHitCount() + " of " + filter.getMaxResult());
            result = new SearchResult();
            for (int i = 0; i < set.getHitCount() && i < filter.getMaxResult(); i++) {
                Record rec = set.getRecord(i);
                System.out.println(rec.getSyntax());
//                String oneRecord = rec.render();
//                System.out.println(oneRecord);
//                System.out.println(new String(rec.getContent()));
                org.marc4j.marc.Record e = readMarc(rec, library);
                System.out.println(e);
                result.getRecords().add(e);
            }

        } catch (ZoomException ze) {
            throw new Exception(ze);
        } finally {
            con.close();
        }
        return result;
    }

    public SearchResult searchCql(Library library, SearchFilter filter) throws Exception {
        Connection con = new Connection(library.getZhost(), library.getZport());
        con.setSyntax(library.getzFormat());
        con.setDatabaseName(library.getZdb());
        SearchResult result;
        try {
            con.connect();
            CQLQuery query =
                    new CQLQuery(filter.createCqlQueryString());
            ResultSet set = con.search(query);
            System.out.println("Showing " + set.getHitCount() + " of " + filter.getMaxResult());
            result = new SearchResult();
            for (int i = 0; i < set.getHitCount() && i < filter.getMaxResult(); i++) {
                Record rec = set.getRecord(i);
                System.out.println(rec.getSyntax());
//                String oneRecord = rec.render();
                System.out.println(rec.render());
//                System.out.println(new String(rec.getContent()));
                result.getRecords().add(readMarc(rec, library));
            }

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
            log.info("Showing {0} of {1}",search.getMaxResult(), set.getHitCount());
            result = new SearchResult();
            for (int i = 0; i < set.getHitCount() && i < search.getMaxResult(); i++) {
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
//        Charset charset = Charset.forName("CP1251");
//        String s = new String(b, charset);
        ByteArrayInputStream stream = new ByteArrayInputStream(b);
//        RecordReader recordReader = (RecordReader) new ClassPathXmlApplicationContext(RecordReader.class.getName() + ".xml")
//                .getBean("marcFileReader");
//            List<ppa.marc.domain.Record> records = recordReader.read(stream);

        MarcReader reader = new RuMarcStreamReader(stream, library.getEncoding());

//        SaveMarc(b, next);

        return reader.next();


    }

//    private void SaveMarc(byte[] b, org.marc4j.marc.Record next) {
//        try {
//            FileOutputStream w = new FileOutputStream("c:\\work\\enu\\" + next.getControlNumberField().getData().replace('/','_') + ".mrc");
//            w.write(b);
//            w.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
