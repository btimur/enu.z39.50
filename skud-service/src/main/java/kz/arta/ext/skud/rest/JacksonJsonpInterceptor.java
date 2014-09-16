package kz.arta.ext.skud.rest;

import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.annotations.interception.ServerInterceptor;
import org.jboss.resteasy.core.MediaTypeMap;
import org.jboss.resteasy.spi.interception.MessageBodyWriterContext;
import org.jboss.resteasy.spi.interception.MessageBodyWriterInterceptor;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by timur on 9/12/14.
 * скопирован с  репозитория т/к/ на севрерах старая версия resteasy
 */
@SuppressWarnings("UnusedDeclaration")
@Provider
@ServerInterceptor
public class JacksonJsonpInterceptor implements MessageBodyWriterInterceptor {

    /**
     * "text/javascript" media type. Default media type of script tags.
     */
    public static final MediaType TEXT_JAVASCRIPT_MEDIA_TYPE = new MediaType("text", "javascript");

    /**
     * "application/javascript" media type.
     */
    public static final MediaType APPLICATION_JAVASCRIPT_MEDIA_TYPE = new MediaType("application", "javascript");

    /**
     * "text/json" media type.
     */
    public static final MediaType TEXT_JSON_TYPE = new MediaType("text", "json");

    /**
     * "application/*+json" media type.
     */
    public static final MediaType APPLICATION_PLUS_JSON_TYPE = new MediaType("application", "*+json");

    /**
     * Default name of the query parameter with the method name.
     */
    public static final String DEFAULT_CALLBACK_QUERY_PARAMETER = "callback";

    /**
     * If response media type is one of this jsonp response may be created.
     */
    public static final MediaTypeMap<String> jsonpCompatibleMediaTypes = new MediaTypeMap<String>();

    /**
     * Default {@link ObjectMapper} for type resolution. Used if none is provided by {@link Providers}.
     */
    protected static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper();

    static {
        jsonpCompatibleMediaTypes.add(MediaType.APPLICATION_JSON_TYPE  , MediaType.APPLICATION_JSON_TYPE.toString());
        jsonpCompatibleMediaTypes.add(APPLICATION_JAVASCRIPT_MEDIA_TYPE, APPLICATION_JAVASCRIPT_MEDIA_TYPE.toString());
        jsonpCompatibleMediaTypes.add(APPLICATION_PLUS_JSON_TYPE       , APPLICATION_PLUS_JSON_TYPE.toString());
        jsonpCompatibleMediaTypes.add(TEXT_JSON_TYPE                   , TEXT_JSON_TYPE.toString());
        jsonpCompatibleMediaTypes.add(TEXT_JAVASCRIPT_MEDIA_TYPE       , TEXT_JAVASCRIPT_MEDIA_TYPE.toString());
    }

    private UriInfo uri;

    private String callbackQueryParameter = DEFAULT_CALLBACK_QUERY_PARAMETER;

    /**
     * The {@link ObjectMapper} used to create typing information.
     */
    protected ObjectMapper objectMapper;

    /**
     * The {@link Providers} used to retrieve the {@link #objectMapper} from.
     */
    protected Providers providers;

    /**
     * {@inheritDoc}
     */
    @Override
    public void write(MessageBodyWriterContext context) throws IOException, WebApplicationException {
        String function = uri.getQueryParameters().getFirst(callbackQueryParameter);
        if (function != null && !function.trim().isEmpty() && !jsonpCompatibleMediaTypes.getPossible(context.getMediaType()).isEmpty()){
            OutputStreamWriter writer = new OutputStreamWriter(context.getOutputStream());

            writer.write(function + "(");
            writer.flush();
            context.proceed();
            writer.write(")");
            writer.flush();
        } else {
            context.proceed();
        }
    }

    /**
     * Search for an {@link ObjectMapper} for the given class and mediaType
     *
     * @param type the {@link Class} to serialize
     * @param mediaType the response {@link MediaType}
     * @return the {@link ObjectMapper}
     */
    protected ObjectMapper getObjectMapper(Class<?> type, MediaType mediaType)
    {
        if (objectMapper != null) {
            return objectMapper;
        }

        if (providers != null) {
            ContextResolver<ObjectMapper> resolver = providers.getContextResolver(ObjectMapper.class, mediaType);
            if (resolver == null) {
                resolver = providers.getContextResolver(ObjectMapper.class, null);
            }
            if (resolver != null) {
                return resolver.getContext(type);
            }
        }

        return DEFAULT_MAPPER;
    }


    /**
     * Setter used by RESTeasy to provide the {@link UriInfo}.
     *
     * @param uri the uri to set
     */
    @Context
    public void setUri(UriInfo uri) {
        this.uri = uri;
    }

    /**
     * Setter used by RESTeasy to provide the {@link Providers}
     *
     * @param providers провайдеры
     */
    @Context
    public void setProviders(Providers providers) {
        this.providers = providers;
    }

    /**
     * Set an fix {@link ObjectMapper}. If this is not set {@link Providers} are used for lookup. If there are is none too, use a default one.
     *
     * @param objectMapper маапер объектов
     */
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * Get the name of the query parameter which contains the JavaScript method name. Default: callback.
     *
     * @return the callbackQueryParameter
     */
    public String getCallbackQueryParameter() {
        return callbackQueryParameter;
    }

    /**
     * Set callback query parameter.
     *
     * @see #getCallbackQueryParameter()
     * @param callbackQueryParameter the callbackQueryParameter to set
     */
    public void setCallbackQueryParameter(String callbackQueryParameter) {
        this.callbackQueryParameter = callbackQueryParameter;
    }

}
