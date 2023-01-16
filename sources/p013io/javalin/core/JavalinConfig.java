package p013io.javalin.core;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.Javalin;
import p013io.javalin.core.compression.Brotli;
import p013io.javalin.core.compression.CompressionStrategy;
import p013io.javalin.core.compression.Gzip;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.core.plugin.PluginAlreadyRegisteredException;
import p013io.javalin.core.plugin.PluginInitLifecycleViolationException;
import p013io.javalin.core.plugin.PluginLifecycleInit;
import p013io.javalin.core.plugin.PluginNotFoundException;
import p013io.javalin.core.security.AccessManager;
import p013io.javalin.core.security.SecurityUtil;
import p013io.javalin.core.util.CorsPlugin;
import p013io.javalin.core.util.Headers;
import p013io.javalin.core.util.HeadersPlugin;
import p013io.javalin.core.util.HttpAllowedMethodsOnRoutesUtil;
import p013io.javalin.core.util.LogUtil;
import p013io.javalin.http.ContentType;
import p013io.javalin.http.ContextResolver;
import p013io.javalin.http.ContextResolverKt;
import p013io.javalin.http.Handler;
import p013io.javalin.http.RequestLogger;
import p013io.javalin.http.SinglePageHandler;
import p013io.javalin.http.staticfiles.Location;
import p013io.javalin.http.staticfiles.ResourceHandler;
import p013io.javalin.http.staticfiles.StaticFileConfig;
import p013io.javalin.http.util.ContextUtil;
import p013io.javalin.jetty.JettyResourceHandler;
import p013io.javalin.jetty.JettyUtil;
import p013io.javalin.plugin.json.JavalinJackson;
import p013io.javalin.plugin.json.JsonMapper;
import p013io.javalin.plugin.json.JsonMapperKt;
import p013io.javalin.websocket.WsConfig;

/* renamed from: io.javalin.core.JavalinConfig */
/* loaded from: grasscutter.jar:io/javalin/core/JavalinConfig.class */
public class JavalinConfig {
    public boolean autogenerateEtags = false;
    public boolean prefer405over404 = false;
    public boolean enforceSsl = false;
    public boolean showJavalinBanner = true;
    public boolean ignoreTrailingSlashes = true;
    @NotNull
    public String defaultContentType = ContentType.PLAIN;
    @NotNull
    public String contextPath = "/";
    public Long maxRequestSize = 1000000L;
    @NotNull
    public Long asyncRequestTimeout = 0L;
    @NotNull
    public Inner inner = new Inner();

    /* renamed from: io.javalin.core.JavalinConfig$Inner */
    /* loaded from: grasscutter.jar:io/javalin/core/JavalinConfig$Inner.class */
    public static class Inner {
        @NotNull
        public Map<Class<? extends Plugin>, Plugin> plugins = new LinkedHashMap();
        @NotNull
        public Map<String, Object> appAttributes = new HashMap();
        @Nullable
        public RequestLogger requestLogger = null;
        @Nullable
        public ResourceHandler resourceHandler = null;
        @NotNull
        public AccessManager accessManager = SecurityUtil::noopAccessManager;
        @NotNull
        public SinglePageHandler singlePageHandler = new SinglePageHandler();
        @Nullable
        public SessionHandler sessionHandler = null;
        @Nullable
        public Consumer<WebSocketServletFactory> wsFactoryConfig = null;
        @Nullable
        public WsConfig wsLogger = null;
        @Nullable
        public Server server = null;
        @Nullable
        public Consumer<ServletContextHandler> servletContextHandlerConsumer = null;
        @NotNull
        public CompressionStrategy compressionStrategy = CompressionStrategy.GZIP;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.util.Map<java.lang.Class<? extends io.javalin.core.plugin.Plugin>, io.javalin.core.plugin.Plugin> */
    /* JADX WARN: Multi-variable type inference failed */
    public void registerPlugin(@NotNull Plugin plugin) {
        if (this.inner.plugins.containsKey(plugin.getClass())) {
            throw new PluginAlreadyRegisteredException(plugin.getClass());
        }
        this.inner.plugins.put(plugin.getClass(), plugin);
    }

    public <T extends Plugin> T getPlugin(@NotNull Class<T> pluginClass) {
        T result = (T) this.inner.plugins.get(pluginClass);
        if (result != null) {
            return result;
        }
        throw new PluginNotFoundException(pluginClass);
    }

    public void enableDevLogging() {
        requestLogger((v0, v1) -> {
            LogUtil.requestDevLogger(v0, v1);
        });
        wsLogger(LogUtil::wsDevLogger);
        registerPlugin(new LogUtil.HandlerLoggingPlugin());
    }

    public void enableWebjars() {
        addStaticFiles(staticFiles -> {
            staticFiles.directory = "META-INF/resources/webjars";
            staticFiles.headers.put("Cache-Control", "max-age=31622400");
        });
    }

    public void addStaticFiles(@NotNull String directory, @NotNull Location location) {
        addStaticFiles(staticFiles -> {
            staticFiles.directory = directory;
            staticFiles.location = location;
        });
    }

    public void addStaticFiles(@NotNull Consumer<StaticFileConfig> userConfig) {
        if (this.inner.resourceHandler == null) {
            this.inner.resourceHandler = new JettyResourceHandler();
        }
        StaticFileConfig finalConfig = new StaticFileConfig();
        userConfig.accept(finalConfig);
        this.inner.resourceHandler.addStaticFileConfig(finalConfig);
    }

    public void addSinglePageRoot(@NotNull String hostedPath, @NotNull String filePath) {
        addSinglePageRoot(hostedPath, filePath, Location.CLASSPATH);
    }

    public void addSinglePageRoot(@NotNull String hostedPath, @NotNull String filePath, @NotNull Location location) {
        this.inner.singlePageHandler.add(hostedPath, filePath, location);
    }

    public void addSinglePageHandler(@NotNull String hostedPath, @NotNull Handler customHandler) {
        this.inner.singlePageHandler.add(hostedPath, customHandler);
    }

    public void enableCorsForAllOrigins() {
        registerPlugin(CorsPlugin.forAllOrigins());
    }

    public void enableCorsForOrigin(@NotNull String... origins) {
        registerPlugin(CorsPlugin.forOrigins(origins));
    }

    public void accessManager(@NotNull AccessManager accessManager) {
        this.inner.accessManager = accessManager;
    }

    public void requestLogger(@NotNull RequestLogger requestLogger) {
        this.inner.requestLogger = requestLogger;
    }

    public void sessionHandler(@NotNull Supplier<SessionHandler> sessionHandlerSupplier) {
        JettyUtil.disableJettyLogger();
        this.inner.sessionHandler = sessionHandlerSupplier.get();
    }

    public void wsFactoryConfig(@NotNull Consumer<WebSocketServletFactory> wsFactoryConfig) {
        this.inner.wsFactoryConfig = wsFactoryConfig;
    }

    public void wsLogger(@NotNull Consumer<WsConfig> ws) {
        WsConfig logger = new WsConfig();
        ws.accept(logger);
        this.inner.wsLogger = logger;
    }

    public void server(Supplier<Server> server) {
        this.inner.server = server.get();
    }

    public void configureServletContextHandler(Consumer<ServletContextHandler> consumer) {
        this.inner.servletContextHandlerConsumer = consumer;
    }

    public void compressionStrategy(Brotli brotli, Gzip gzip) {
        this.inner.compressionStrategy = new CompressionStrategy(brotli, gzip);
    }

    public void compressionStrategy(CompressionStrategy compressionStrategy) {
        this.inner.compressionStrategy = compressionStrategy;
    }

    public void globalHeaders(Supplier<Headers> headers) {
        registerPlugin(new HeadersPlugin(headers.get()));
    }

    public void jsonMapper(JsonMapper jsonMapper) {
        this.inner.appAttributes.put(JsonMapperKt.JSON_MAPPER_KEY, jsonMapper);
    }

    public static void applyUserConfig(Javalin app, JavalinConfig config, Consumer<JavalinConfig> userConfig) {
        userConfig.accept(config);
        AtomicBoolean anyHandlerAdded = new AtomicBoolean(false);
        app.events(listener -> {
            listener.handlerAdded(x -> {
                anyHandlerAdded.set(true);
            });
            listener.wsHandlerAdded(x -> {
                anyHandlerAdded.set(true);
            });
        });
        config.getPluginsExtending(PluginLifecycleInit.class).forEach(plugin -> {
            plugin.init(app);
            if (anyHandlerAdded.get()) {
                throw new PluginInitLifecycleViolationException(((Plugin) plugin).getClass());
            }
        });
        config.inner.plugins.values().forEach(plugin -> {
            plugin.apply(app);
        });
        if (config.enforceSsl) {
            app.before(SecurityUtil::sslRedirect);
        }
        config.inner.appAttributes.putIfAbsent(JsonMapperKt.JSON_MAPPER_KEY, new JavalinJackson());
        app.attribute(ContextUtil.maxRequestSizeKey, config.maxRequestSize);
        config.inner.appAttributes.putIfAbsent(ContextResolverKt.CONTEXT_RESOLVER_KEY, new ContextResolver());
    }

    private <T> Stream<? extends T> getPluginsExtending(Class<T> clazz) {
        Stream<Plugin> stream = this.inner.plugins.values().stream();
        Objects.requireNonNull(clazz);
        return (Stream<? extends T>) stream.filter((v1) -> {
            return r1.isInstance(v1);
        }).map(plugin -> {
            return plugin;
        });
    }

    public void contextResolvers(@NotNull Consumer<ContextResolver> userResolver) {
        ContextResolver finalResolver = new ContextResolver();
        userResolver.accept(finalResolver);
        this.inner.appAttributes.put(ContextResolverKt.CONTEXT_RESOLVER_KEY, finalResolver);
    }

    public void enableHttpAllowedMethodsOnRoutes() {
        registerPlugin(new HttpAllowedMethodsOnRoutesUtil());
    }
}
