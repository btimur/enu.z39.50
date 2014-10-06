package test.service;

import kz.arta.ext.api.config.ConfigReader;
import kz.arta.ext.z3950.model.External;
import kz.arta.ext.z3950.service.ExternalUpdater;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by timur on 10/3/14.
 * тесты для апдейта конфигурации
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ConfigReader.class})
public class ExternalUpdaterTest {

    private final File cfgFile = new File("test//zebra.cfg");
    private final File pwdFile = new File("test//zebra.passwd");
    @Mock
    private Logger logger;

    @InjectMocks
    @Spy
    private ExternalUpdater updater = new ExternalUpdater();


    @Before
    public void setUp() throws Exception {
        new File("test").mkdirs();
        FileUtils.copyFile(new File("z3950-app//zebra-enu//zebra.cfg"), cfgFile);
        FileUtils.copyFile(new File("z3950-app//zebra-enu//zebra.passwd"), pwdFile);

        mockStatic(ConfigReader.class);
        when(ConfigReader.getPropertyValue(kz.arta.ext.z3950.util.CodeConstants.ZEBRA_PATH))
                .thenReturn("test");
    }

    @After
    public void tearDown() throws Exception {
        FileUtils.forceDeleteOnExit(cfgFile);
        FileUtils.forceDeleteOnExit(pwdFile);
    }

    @Test
    public void testUpdate() throws IOException {
        External external = new External();
        external.setId(1L);
        external.setLogin("new_user");
        external.setPwd("P@$$w0rd");
        external.setDeleted(false);
        external.setBlock(false);

        // check new user
        updater.update(external);
        String line = ExternalUpdater.listLines(cfgFile, "perm.new_user");
        Assert.assertEquals(line, "perm.new_user:r");
        line = ExternalUpdater.listLines(pwdFile, "new_user");
        Assert.assertEquals(line, "new_user:P@$$w0rd");

        //check upadte pwd
        external.setPwd("newpwd");
        updater.update(external);
        line = ExternalUpdater.listLines(cfgFile, "perm.new_user");
        Assert.assertEquals(line, "perm.new_user:r");
        line = ExternalUpdater.listLines(pwdFile, "new_user");
        Assert.assertEquals(line, "new_user:newpwd");

        //check block user
        external.setBlock(true);
        updater.update(external);
        line = ExternalUpdater.listLines(cfgFile, "perm.new_user");
        Assert.assertNull(line);
        line = ExternalUpdater.listLines(pwdFile, "new_user");
        Assert.assertEquals(line, "new_user:newpwd");
    }

    @Test
    public void testRemove() throws IOException {
        External external = new External();
        external.setId(1L);
        external.setLogin("new_user");
        external.setPwd("P@$$w0rd");
        external.setDeleted(false);
        external.setBlock(false);

        //add user
        updater.update(external);
        // check new user
        updater.remove(external);
        String line = ExternalUpdater.listLines(cfgFile, "perm.new_user");
        Assert.assertNull(line);
        line = ExternalUpdater.listLines(pwdFile, "new_user");
        Assert.assertNull(line);

    }


}
