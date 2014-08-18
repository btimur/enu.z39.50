package test;


import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.QueryType;
import kz.arta.ext.z3950.model.search.SimpleSearch;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.search.QueryBuilderFactory;
import kz.arta.ext.z3950.service.Z3950Searcher;
import org.junit.Before;
import org.junit.Test;
import org.yaz4j.Connection;
import org.yaz4j.Query;
import org.yaz4j.Record;
import org.yaz4j.ResultSet;
import org.yaz4j.exception.ZoomException;

/**
 * Created by timur on 25/07/2014 15:30.
 */
//@RunWith(Arquillian.class)
public class TestSearch  {


    private Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        //// pushkinlibrary
//        library.setZhost("irbis.pushkinlibrary.kz");
//        library.setZdb("ibis");
//        library.setZport(210);
//        library.setzFormat(FormatEnum.RUSMARC.name());
//        library.setQueryType(QueryType.PREFIX_QUERY.name());


        library.setZhost("zserv.libfl.ru");
        library.setZdb("books");
        library.setZport(210);
        library.setzFormat(FormatEnum.USMARC.name());
        library.setQueryType(QueryType.PREFIX_QUERY.name());

        // library congress
//        library.setZhost("lx2.loc.gov");
//        library.setZdb("LCDB");
//        library.setZport(210);
//        library.setzFormat(FormatEnum.XML);

//        ГПНТБ России. Электронный каталог
//        library.setZhost("193.233.14.5");
//        library.setZport(9999);
//        library.setZdb("katb");
//        library.setzFormat(FormatEnum.RUSMARC);
//        library.setEncoding("cp1251");
//        library.setQueryType(QueryType.PREFIX_QUERY);

//        //Самарский государственный университет - Научная библиотека
//        library.setZhost("z3950.ssu.samara.ru");
//        library.setZport(210);
//        library.setZdb("books");
//        library.setzFormat(FormatEnum.SUTRS);


//        library.setZhost("aleph.rsl.ru");
//        library.setZport(9909);
//        library.setZdb("rsl01");
//        library.setzFormat(FormatEnum.RUSMARC);

//        library.setZhost("z3950.lib.vsu.ru");//www.benran.ru
//        library.setZport(210);
//        library.setZdb("books");
//        library.setzFormat(FormatEnum.UNIMARC);
//        library.setEncoding("cp1251");
    }

    @Test
    public void TestZ3950Searcher() throws Exception {

        SimpleSearch search = new SimpleSearch();
        Z3950Searcher searcher = new Z3950Searcher();
//        condition.setCql("физика");
//        condition.setCql("@attr 1=4 @attr 2=3 @attr 4=2 \"XML\"");
        search.setTerm("Толстой");
        search.setMaxResult(10);
//        condition.setCql("@and @attr 1=7 \"5-8459-0115-4\" @and @attr 1=1003  \"Либерти\" @attr 1=4 @attr 2=3 @attr 3=3 \"web\" ");
//        condition.setCql("isbn=\"5-8459-0115-4\"");
//        condition.setCql("Identifier=978-5-386-03198-5");
//        filter.getConditions().add(condition);

        Connection con = new Connection(library.getZhost(), library.getZport());
        con.setSyntax(library.getzFormat());
        con.setDatabaseName(library.getZdb());
        SearchResult result;
        try {
            con.connect();
            Query query = QueryBuilderFactory.createBuilder(QueryType.valueOf(library.getQueryType())).createQuery(search);
            ResultSet set = con.search(query);
            result = new SearchResult();
            for (int i = 0; i < set.getHitCount() && i < search.getMaxResult(); i++) {
                Record rec = set.getRecord(i);
                System.out.println(rec.getSyntax());
                org.marc4j.marc.Record marc = searcher.readMarc(rec, library);
                System.out.println(marc.toString());
                result.getRecords().add(marc);
            }
            result.setCount(set.getHitCount());

        } catch (ZoomException ze) {
            throw new Exception(ze);
        } finally {
            con.close();
        }
//        SearchResult result = searcher.searchCql(library, filter);
        org.junit.Assert.assertNotNull(result);


    }
}
