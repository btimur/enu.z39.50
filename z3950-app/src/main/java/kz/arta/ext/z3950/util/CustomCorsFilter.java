package kz.arta.ext.z3950.util;

import org.jboss.resteasy.core.ResourceMethod;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.interception.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by timur on 8/24/2014 1:51 PM.
 */
public class CustomCorsFilter implements PreProcessInterceptor, MessageBodyReaderInterceptor, MessageBodyWriterInterceptor
{
    protected boolean allowCredentials = true;
    protected String allowedMethods;
    protected String allowedHeaders;
    protected String exposedHeaders;
    protected int corsMaxAge = -1;
    protected Set<String> allowedOrigins = new HashSet<String>();

    public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
    public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
    public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
    public static final String ORIGIN = "Origin";
    public static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
    public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
    public static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";

//    /**
//     * Put "*" if you want to accept all origins
//     *
//     * @return
//     */
//    public Set<String> getAllowedOrigins()
//    {
//        return allowedOrigins;
//    }
//
//    /**
//     * Defaults to true
//     *
//     * @return
//     */
//    public boolean isAllowCredentials()
//    {
//        return allowCredentials;
//    }
//
//    public void setAllowCredentials(boolean allowCredentials)
//    {
//        this.allowCredentials = allowCredentials;
//    }
//
//    /**
//     * Will allow all by default
//     *
//     * @return
//     */
//    public String getAllowedMethods()
//    {
//        return allowedMethods;
//    }
//
//    /**
//     * Will allow all by default
//     * comma delimited string for Access-Control-Allow-Methods
//     *
//     * @param allowedMethods
//     */
//    public void setAllowedMethods(String allowedMethods)
//    {
//        this.allowedMethods = allowedMethods;
//    }
//
//    public String getAllowedHeaders()
//    {
//        return allowedHeaders;
//    }
//
//    /**
//     * Will allow all by default
//     * comma delimited string for Access-Control-Allow-Headers
//     *
//     * @param allowedHeaders
//     */
//    public void setAllowedHeaders(String allowedHeaders)
//    {
//        this.allowedHeaders = allowedHeaders;
//    }
//
//    public int getCorsMaxAge()
//    {
//        return corsMaxAge;
//    }
//
//    public void setCorsMaxAge(int corsMaxAge)
//    {
//        this.corsMaxAge = corsMaxAge;
//    }
//
//    public String getExposedHeaders()
//    {
//        return exposedHeaders;
//    }
//
//    /**
//     * comma delimited list
//     *
//     * @param exposedHeaders
//     */
//    public void setExposedHeaders(String exposedHeaders)
//    {
//        this.exposedHeaders = exposedHeaders;
//    }
//
//    @Override
//    public void filter(ContainerRequestContext requestContext) throws IOException
//    {
//        String origin = requestContext.getHeaderString(ORIGIN);
//        if (origin == null)
//        {
//            return;
//        }
//        if (requestContext.getMethod().equalsIgnoreCase("OPTIONS"))
//        {
//            preflight(origin, requestContext);
//        }
//        else
//        {
//            checkOrigin(requestContext, origin);
//        }
//    }
//
//    @Override
//    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException
//    {
//        String origin = requestContext.getHeaderString(ORIGIN);
//        if (origin == null || requestContext.getMethod().equalsIgnoreCase("OPTIONS") || requestContext.getProperty("cors.failure") != null)
//        {
//            // don't do anything if origin is null, its an OPTIONS request, or cors.failure is set
//            return;
//        }
//        responseContext.getHeaders().putSingle(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
//        if (allowCredentials) responseContext.getHeaders().putSingle(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
//
//        if (exposedHeaders != null) {
//            responseContext.getHeaders().putSingle(ACCESS_CONTROL_EXPOSE_HEADERS, exposedHeaders);
//        }
//    }
//
//
//    protected void preflight(String origin, ContainerRequestContext requestContext) throws IOException
//    {
//        checkOrigin(requestContext, origin);
//
//        Response.ResponseBuilder builder = Response.ok();
//        builder.header(ACCESS_CONTROL_ALLOW_ORIGIN, origin);
//        if (allowCredentials) builder.header(ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
//        String requestMethods = requestContext.getHeaderString(ACCESS_CONTROL_REQUEST_METHOD);
//        if (requestMethods != null)
//        {
//            if (allowedMethods != null)
//            {
//                requestMethods = this.allowedMethods;
//            }
//            builder.header(ACCESS_CONTROL_ALLOW_METHODS, requestMethods);
//        }
//        String allowHeaders = requestContext.getHeaderString(ACCESS_CONTROL_REQUEST_HEADERS);
//        if (allowHeaders != null)
//        {
//            if (allowedHeaders != null)
//            {
//                allowHeaders = this.allowedHeaders;
//            }
//            builder.header(ACCESS_CONTROL_ALLOW_HEADERS, allowHeaders);
//        }
//        if (corsMaxAge > -1)
//        {
//            builder.header(ACCESS_CONTROL_MAX_AGE, corsMaxAge);
//        }
//        requestContext.abortWith(builder.build());
//
//    }
//
//    protected void checkOrigin(ContainerRequestContext requestContext, String origin)
//    {
//        if (!allowedOrigins.contains("*") && !allowedOrigins.contains(origin))
//        {
//            requestContext.setProperty("cors.failure", true);
//            throw new ForbiddenException("Origin not allowed: " + origin);
//        }
//    }

    @Override
    public Object read(MessageBodyReaderContext context) throws IOException, WebApplicationException {
        return null;
    }

    @Override
    public void write(MessageBodyWriterContext context) throws IOException, WebApplicationException {

    }

    @Override
    public ServerResponse preProcess(HttpRequest request, ResourceMethod method) throws Failure, WebApplicationException {
        return null;
    }
}

