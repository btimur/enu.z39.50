package test;

import kz.arta.ext.z3950.model.SimpleSearch;
import kz.arta.ext.z3950.search.CqlBuilder;
import kz.arta.ext.z3950.search.IQueryBuilder;
import kz.arta.ext.z3950.search.PqlBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by timur on 8/12/2014 2:51 PM.
 */
public class QLBuildTest {

    @Test
      public void testSimplePql(){
        SimpleSearch simpleSeacrh = new SimpleSearch();
        simpleSeacrh.setTerm("test");
        simpleSeacrh.setAdvancedSearch(false);
        IQueryBuilder builder = new PqlBuilder();
        String pql = builder.createQueryString(simpleSeacrh);
        Assert.assertNotNull(pql);
        Assert.assertEquals(pql, "@attr 1=1035 @attr 2=3 @attr 3=3 \"test\"");
    }

    @Test
    public void testSimpleCql(){
        SimpleSearch simpleSeacrh = new SimpleSearch();
        simpleSeacrh.setTerm("test");
        simpleSeacrh.setAdvancedSearch(false);
        IQueryBuilder builder = new CqlBuilder();
        String pql = builder.createQueryString(simpleSeacrh);
        Assert.assertNotNull(pql);
        Assert.assertEquals(pql, "test");
    }

    @Test
    public void testAdvancedPql(){
        SimpleSearch simpleSeacrh = new SimpleSearch();
        simpleSeacrh.setTerm("test");
        simpleSeacrh.setIsbn("isbn");
        simpleSeacrh.setAdvancedSearch(true);
        IQueryBuilder builder = new PqlBuilder();
        String pql = builder.createQueryString(simpleSeacrh);
        Assert.assertNotNull(pql);
        Assert.assertEquals(pql, "@attr 1=7 \"isbn\"");

        simpleSeacrh.setAddAuthor("author2");
        pql = builder.createQueryString(simpleSeacrh);
        Assert.assertEquals(pql, "@and @attr 1=7 \"isbn\" @attr 1=1005 \"author2\"");

        simpleSeacrh.setIssn("issn");
        pql = builder.createQueryString(simpleSeacrh);
        Assert.assertEquals(pql, "@and @attr 1=7 \"isbn\" @and @attr 1=1005 \"author2\" @attr 1=8 \"issn\"");

        simpleSeacrh.setParallelTitle("title2");
        pql = builder.createQueryString(simpleSeacrh);
        Assert.assertEquals(pql, "@and @attr 1=7 \"isbn\" @and @attr 1=1005 \"author2\" @and @attr 1=8 \"issn\" @attr 1=35 \"title2\"");


    }
}
