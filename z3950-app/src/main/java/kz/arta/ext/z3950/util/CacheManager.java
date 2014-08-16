package kz.arta.ext.z3950.util;

import kz.arta.ext.z3950.model.Book;
import org.marc4j.marc.Record;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by timur on 8/13/2014 11:04 AM.
 */
//[TODO] cache
public class CacheManager {
    private static CacheManager instance;

    private Map<Long, Map<String, Record>> records;

    private CacheManager() {
        records = new HashMap<Long, Map<String, Record>>();
    }

    public static synchronized CacheManager getInstance(){
        if (instance == null){
            instance = new CacheManager();
        }
        return instance;
    }

    public void addRecord(Book book){
        Map<String, Record> librariesMap  = records.get(book.getLibraryId());
        if (librariesMap == null){
            librariesMap = new HashMap<String, Record>();
            records.put(book.getLibraryId(), librariesMap);
        }
        librariesMap.put(book.getId(), book.getRecord());
    }


    public Record getRecord(Book book){
        Map<String, Record> librariesMap  = records.get(book.getLibraryId());
        if (librariesMap == null){
            return null;
        }
        return librariesMap.get(book.getId());
    }
}
