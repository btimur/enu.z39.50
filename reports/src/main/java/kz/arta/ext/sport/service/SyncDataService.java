package kz.arta.ext.sport.service;

import org.slf4j.Logger;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by admin on 23.10.14.
 */
@Singleton
@Startup
public class SyncDataService {

    @Inject
    private Logger log;

    @Inject
    private SyncDataManager syncDataManager;

    @Schedule(second = "0", minute ="0", hour = "*/2")
    public void runTask() throws IOException {
        log.info("sport-app: run sync data");
        syncDataManager.Run();
        log.info("sport-app: finish sync data");
    }

}
