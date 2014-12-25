package kz.arta.ext.sport.service;

import kz.arta.ext.api.config.ConfigUtils;
import kz.arta.ext.api.rest.RestQueryContext;
import kz.arta.ext.sport.model.synergy.Department;
import kz.arta.ext.sport.model.synergy.UserChooser;
import kz.arta.ext.sport.rest.api.DepartmentReader;
import kz.arta.ext.sport.rest.api.UserChooserReader;
import kz.arta.ext.sport.service.repository.DepartmentRepository;
import kz.arta.ext.sport.service.repository.UserChooserRepository;
import kz.arta.ext.sport.util.CodeConstants;
import org.slf4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.io.IOException;

/**
 * Created by admin on 20.10.14.
 */
@Stateless
public class SyncDataManager {

    @SuppressWarnings("CdiInjectionPointsInspection")
    @Inject
    private Logger logger;

    @Inject
    private DepartmentReader departmentReader;

    @Inject
    private UserChooserReader userChooserReader;

    @Inject
    private UserChooserRepository userChooserRepository;

    @Inject
    private DepartmentRepository departmentRepository;

    public boolean Run() throws IOException {

        boolean result = true;
        logger.info("reports.syncData run");
        syncDeparment();
        syncUserChooser();
        return result;
    }

    private void syncUserChooser() throws IOException {
        logger.info("reports: sync UserChooser database begin");

        RestQueryContext context = ConfigUtils.getQueryContext();
        fillUserChoosers(CodeConstants.MALE_GROUP, CodeConstants.MALE_INDEX, context);
        fillUserChoosers(CodeConstants.FEMALE_GROUP, CodeConstants.FEMALE_INDEX, context);
        fillUserChoosers(CodeConstants.FEMALE_ABULT, CodeConstants.FEMALE_INDEX, context);
        fillUserChoosers(CodeConstants.FEMALE_JUNIOR, CodeConstants.FEMALE_INDEX, context);
        fillUserChoosers(CodeConstants.FEMALE_YOUTH, CodeConstants.FEMALE_INDEX, context);
        logger.info("reports: sync UserChooser database end");
    }

    private void fillUserChoosers(String code, int index, RestQueryContext context) throws IOException {
        boolean finish =false;
        int startRecord=0;
        int recordsCount =100;
        while (!finish)
        {
            UserChooser[] users = userChooserReader.getListUserChooser(code,startRecord,recordsCount,context);
            if(users ==null || users.length==0)
            {
                finish=true;
            }
            if(users!=null)
            {
            for(UserChooser chooser : users)
            {
                chooser.setSexIndex(index);
                userChooserReader.fillDepartment(chooser, context);
                userChooserReader.fillUserAdditionalForm(chooser, context);
                userChooserRepository.save(chooser);
            }
            }
//            finish=true;
            startRecord = startRecord+recordsCount;
        }
    }

    private void syncDeparment() throws IOException {
        logger.info("reports: sync Deparment database begin");
        userChooserRepository.clear();
        logger.info("reports: clear Users");
        departmentRepository.clear();
        logger.info("reports: clear Departments");
        RestQueryContext context = ConfigUtils.getQueryContext();
        logger.info("reports: RestQueryContext Address: {}, Login: {} ",context.getAddress(),context.getLogin());
        Department department = departmentReader.getDepartment(CodeConstants.ROOT_DEPARTMENT,context);
        if(department!=null)
        {
            logger.info("get Department ID: {}, Name: {} ",department.getDepartmentID(),department.getNameRu() );
            departmentRepository.save(department);
        }else{
            logger.info("reports: not found  Department ID: {}",CodeConstants.ROOT_DEPARTMENT);
        }
        logger.info("sync Department database end");
    }




}
