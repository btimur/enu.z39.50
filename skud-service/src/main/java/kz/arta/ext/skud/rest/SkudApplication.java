package kz.arta.ext.skud.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Created by Администратор on 04.09.2014.
 * REST приложение для инициализации сервиса и правил инжектов
 */
@ApplicationPath("/skud")
public class SkudApplication extends Application {
    @SuppressWarnings("UnusedDeclaration")
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
