package test;


import kz.arta.ext.z3950.model.FormatEnum;
import kz.arta.ext.z3950.model.Library;
import kz.arta.ext.z3950.model.search.SearchCondition;
import kz.arta.ext.z3950.model.search.SearchFilter;
import kz.arta.ext.z3950.model.search.SearchResult;
import kz.arta.ext.z3950.service.Z3950Searcher;
import org.junit.Before;
import org.junit.Test;

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
//        library.setzFormat(FormatEnum.RUSMARC);

        // library congress
//        library.setZhost("lx2.loc.gov");
//        library.setZdb("LCDB");
//        library.setZport(210);
//        library.setzFormat(FormatEnum.XML);

//        ГПНТБ России. Электронный каталог
        library.setZhost("193.233.14.5");
        library.setZport(9999);
        library.setZdb("katb");
        library.setzFormat(FormatEnum.RUSMARC);
        library.setEncoding("cp1251");

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

        Z3950Searcher searcher = new Z3950Searcher();
        SearchFilter filter = new SearchFilter();
        filter.setMaxResult(10);
        SearchCondition condition = new SearchCondition();
//        condition.setCql("физика");
        condition.setCql("@attr 1=4 @attr 2=3 @attr 4=2 \"XML\"");
//        condition.setCql("Title=Филипок");
//        condition.setCql("Identifier=978-5-386-03198-5");
        filter.getConditions().add(condition);

        SearchResult result = searcher.search(library, filter);
//        SearchResult result = searcher.searchCql(library, filter);
        org.junit.Assert.assertNotNull(result);


    }
}
