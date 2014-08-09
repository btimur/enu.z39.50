package kz.arta.ext.z3950.service;

import kz.arta.ext.z3950.util.RuMarcStreamReader;
import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.search.SearchFilter;
import kz.arta.ext.z3950.model.search.SearchResult;
import org.marc4j.MarcReader;
import org.yaz4j.*;
import org.yaz4j.exception.ZoomException;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

/**
 * Created by timur on 25/07/2014 12:47.
 */

public class Z3950Searcher {

//    @Inject
//    private Logger log;

    public SearchResult search(Library library, SearchFilter filter) throws Exception {
        Connection con = new Connection(library.getZhost(), library.getZport());
        con.setSyntax(library.getzFormat().name());
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
                String oneRecord = rec.render();
                System.out.println(oneRecord);
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

    public SearchResult searchCql(Library library, SearchFilter filter) throws Exception {
        Connection con = new Connection(library.getZhost(), library.getZport());
        con.setSyntax(library.getzFormat().name());
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

    private org.marc4j.marc.Record readMarc(Record rec, Library library) {
        byte[] b = rec.getContent();
        Charset charset = Charset.forName("UTF-8");
        String s = new String(b, charset);
        ByteArrayInputStream stream = new ByteArrayInputStream(b);
//        RecordReader recordReader = (RecordReader) new ClassPathXmlApplicationContext(RecordReader.class.getName() + ".xml")
//                .getBean("marcFileReader");
//            List<ppa.marc.domain.Record> records = recordReader.read(stream);

        MarcReader reader = new RuMarcStreamReader(stream, library.getEncoding());
        return reader.next();

    }

}
