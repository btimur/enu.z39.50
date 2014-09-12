package kz.arta.ext.z3950.util;

import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;
import org.jboss.resteasy.spi.interception.PreProcessInterceptor;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by timur on 8/24/2014 2:23 PM.
 * для бытрой разработки без деплоя включал  CORS
 */
@Provider
@ServerInterceptor
public class CorsInterceptor implements PreProcessInterceptor, MessageBodyWriterInterceptor {

    /**
     * The Origin header set by the browser at each request.
     */
    private static final String ORIGIN = "Origin";


    /**
     * The Access-Control-Allow-Origin header indicates which origin a resource it is specified for can be
     * shared with. ABNF: Access-Control-Allow-Origin = "Access-Control-Allow-Origin" ":" source origin string | "*"
     */
    private static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";


    //
    private static final ThreadLocal<String> REQUEST_ORIGIN = new ThreadLocal<String>();
    //
    private final Set<String> allowedOrigins;


    public CorsInterceptor() {
        this.allowedOrigins = new HashSet<String>();
        this.allowedOrigins.add("*");
    }

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethod method) throws Failure, WebApplicationException {
        if (!allowedOrigins.isEmpty()) {
            REQUEST_ORIGIN.set(request.getHttpHeaders().getRequestHeaders().getFirst(ORIGIN));
        }
        return null;
    }


    @Override
    public void write(MessageBodyWriterContext context) throws IOException, WebApplicationException {
        if (!allowedOrigins.isEmpty() && (allowedOrigins.contains(REQUEST_ORIGIN.get()) || allowedOrigins.contains("*"))) {
//            context.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, REQUEST_ORIGIN.get());
            context.getHeaders().add(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        }
        context.proceed();
    }
}