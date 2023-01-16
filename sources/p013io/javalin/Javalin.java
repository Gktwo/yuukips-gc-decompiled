package p013io.javalin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.jetty.server.Server;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.apibuilder.ApiBuilder;
import p013io.javalin.apibuilder.EndpointGroup;
import p013io.javalin.core.JavalinConfig;
import p013io.javalin.core.event.EventListener;
import p013io.javalin.core.event.EventManager;
import p013io.javalin.core.event.HandlerMetaInfo;
import p013io.javalin.core.event.JavalinEvent;
import p013io.javalin.core.event.WsHandlerMetaInfo;
import p013io.javalin.core.security.RouteRole;
import p013io.javalin.core.util.JavalinBindException;
import p013io.javalin.core.util.JavalinException;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.core.util.Util;
import p013io.javalin.core.validation.JavalinValidation;
import p013io.javalin.http.ErrorMapperKt;
import p013io.javalin.http.ExceptionHandler;
import p013io.javalin.http.Handler;
import p013io.javalin.http.HandlerType;
import p013io.javalin.http.JavalinServlet;
import p013io.javalin.http.sse.SseClient;
import p013io.javalin.http.sse.SseHandler;
import p013io.javalin.jetty.JavalinJettyServlet;
import p013io.javalin.jetty.JettyServer;
import p013io.javalin.jetty.JettyUtil;
import p013io.javalin.websocket.WsConfig;
import p013io.javalin.websocket.WsExceptionHandler;
import p013io.javalin.websocket.WsHandlerType;

/* renamed from: io.javalin.Javalin */
/* loaded from: grasscutter.jar:io/javalin/Javalin.class */
public class Javalin implements AutoCloseable {
    public JavalinConfig _conf;
    protected JettyServer jettyServer;
    protected JavalinJettyServlet javalinJettyServlet;
    protected JavalinServlet javalinServlet;
    protected EventManager eventManager;

    protected Javalin() {
        this._conf = new JavalinConfig();
        this.javalinServlet = new JavalinServlet(this._conf);
        this.eventManager = new EventManager();
        this.jettyServer = new JettyServer(this._conf);
        this.javalinJettyServlet = new JavalinJettyServlet(this._conf, this.javalinServlet);
    }

    public Javalin(JettyServer jettyServer, JavalinJettyServlet jettyServlet) {
        this._conf = new JavalinConfig();
        this.javalinServlet = new JavalinServlet(this._conf);
        this.eventManager = new EventManager();
        this.jettyServer = jettyServer;
        this.javalinJettyServlet = jettyServlet;
    }

    public static Javalin create() {
        return create(config -> {
        });
    }

    public static Javalin create(Consumer<JavalinConfig> config) {
        Javalin app = new Javalin();
        JavalinValidation.addValidationExceptionMapper(app);
        JavalinConfig.applyUserConfig(app, app._conf, config);
        JettyUtil.maybeLogIfServerNotStarted(app.jettyServer);
        return app;
    }

    public static Javalin createStandalone(Consumer<JavalinConfig> config) {
        Javalin app = new Javalin(null, null);
        JavalinConfig.applyUserConfig(app, app._conf, config);
        return app;
    }

    public static Javalin createStandalone() {
        return createStandalone(config -> {
        });
    }

    public JavalinServlet javalinServlet() {
        return this.javalinServlet;
    }

    @Nullable
    public JettyServer jettyServer() {
        return this.jettyServer;
    }

    public Javalin start(String host, int port) {
        this.jettyServer.setServerHost(host);
        return start(port);
    }

    public Javalin start(int port) {
        this.jettyServer.setServerPort(port);
        return start();
    }

    public Javalin start() {
        Util.logJavalinBanner(this._conf.showJavalinBanner);
        JettyUtil.disableJettyLogger();
        long startupTimer = System.currentTimeMillis();
        if (this.jettyServer.started) {
            throw new IllegalStateException("Server already started. If you are trying to call start() on an instance of Javalin that was stopped using stop(), please create a new instance instead.");
        }
        this.jettyServer.started = true;
        Util.printHelpfulMessageIfLoggerIsMissing();
        this.eventManager.fireEvent(JavalinEvent.SERVER_STARTING);
        try {
            JavalinLogger.startup("Starting Javalin ...");
            Util.logJavalinVersion();
            this.jettyServer.start(this.javalinJettyServlet);
            JavalinLogger.startup("Javalin started in " + (System.currentTimeMillis() - startupTimer) + "ms \\o/");
            this.eventManager.fireEvent(JavalinEvent.SERVER_STARTED);
            return this;
        } catch (Exception e) {
            JavalinLogger.error("Failed to start Javalin");
            this.eventManager.fireEvent(JavalinEvent.SERVER_START_FAILED);
            if (Boolean.TRUE.equals(this.jettyServer.server().getAttribute("is-default-server"))) {
                stop();
            }
            if (e.getMessage() != null && e.getMessage().contains("Failed to bind to")) {
                throw new JavalinBindException("Port already in use. Make sure no other process is using port " + Util.getPort(e) + " and try again.", e);
            } else if (e.getMessage() == null || !e.getMessage().contains("Permission denied")) {
                throw new JavalinException(e);
            } else {
                throw new JavalinBindException("Port 1-1023 require elevated privileges (process must be started by admin).", e);
            }
        }
    }

    public Javalin stop() {
        JavalinLogger.info("Stopping Javalin ...");
        this.eventManager.fireEvent(JavalinEvent.SERVER_STOPPING);
        try {
            this.jettyServer.server().stop();
            JavalinLogger.info("Javalin has stopped");
            this.eventManager.fireEvent(JavalinEvent.SERVER_STOPPED);
            return this;
        } catch (Exception e) {
            this.eventManager.fireEvent(JavalinEvent.SERVER_STOP_FAILED);
            JavalinLogger.error("Javalin failed to stop gracefully", e);
            throw new JavalinException(e);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Server server = this.jettyServer.server();
        if (!server.isStopping() && !server.isStopped()) {
            stop();
        }
    }

    public Javalin events(Consumer<EventListener> listener) {
        listener.accept(new EventListener(this.eventManager));
        return this;
    }

    public int port() {
        return this.jettyServer.getServerPort();
    }

    public Javalin attribute(String key, Object value) {
        this._conf.inner.appAttributes.put(key, value);
        return this;
    }

    public <T> T attribute(String key) {
        return (T) this._conf.inner.appAttributes.get(key);
    }

    public Javalin routes(@NotNull EndpointGroup endpointGroup) {
        ApiBuilder.setStaticJavalin(this);
        try {
            endpointGroup.addEndpoints();
            ApiBuilder.clearStaticJavalin();
            return this;
        } catch (Throwable th) {
            ApiBuilder.clearStaticJavalin();
            throw th;
        }
    }

    public <T extends Exception> Javalin exception(@NotNull Class<T> exceptionClass, @NotNull ExceptionHandler<? super T> exceptionHandler) {
        this.javalinServlet.getExceptionMapper().getHandlers().put(exceptionClass, exceptionHandler);
        return this;
    }

    public Javalin error(int statusCode, @NotNull Handler handler) {
        this.javalinServlet.getErrorMapper().getErrorHandlerMap().put(Integer.valueOf(statusCode), handler);
        return this;
    }

    public Javalin error(int statusCode, @NotNull String contentType, @NotNull Handler handler) {
        return error(statusCode, ErrorMapperKt.contentTypeWrap(contentType, handler));
    }

    public Javalin addHandler(@NotNull HandlerType handlerType, @NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        Set<RouteRole> roleSet = new HashSet<>(Arrays.asList(roles));
        this.javalinServlet.addHandler(handlerType, path, handler, roleSet);
        this.eventManager.fireHandlerAddedEvent(new HandlerMetaInfo(handlerType, Util.prefixContextPath(this.javalinServlet.getConfig().contextPath, path), handler, roleSet));
        return this;
    }

    public Javalin addHandler(@NotNull HandlerType httpMethod, @NotNull String path, @NotNull Handler handler) {
        return addHandler(httpMethod, path, handler, new RouteRole[0]);
    }

    public Javalin get(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.GET, path, handler);
    }

    public Javalin post(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.POST, path, handler);
    }

    public Javalin put(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.PUT, path, handler);
    }

    public Javalin patch(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.PATCH, path, handler);
    }

    public Javalin delete(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.DELETE, path, handler);
    }

    public Javalin head(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.HEAD, path, handler);
    }

    public Javalin options(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.OPTIONS, path, handler);
    }

    public Javalin get(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        return addHandler(HandlerType.GET, path, handler, roles);
    }

    public Javalin post(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        return addHandler(HandlerType.POST, path, handler, roles);
    }

    public Javalin put(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        return addHandler(HandlerType.PUT, path, handler, roles);
    }

    public Javalin patch(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        return addHandler(HandlerType.PATCH, path, handler, roles);
    }

    public Javalin delete(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        return addHandler(HandlerType.DELETE, path, handler, roles);
    }

    public Javalin head(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        return addHandler(HandlerType.HEAD, path, handler, roles);
    }

    public Javalin options(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
        return addHandler(HandlerType.OPTIONS, path, handler, roles);
    }

    public Javalin sse(@NotNull String path, @NotNull Consumer<SseClient> client) {
        return sse(path, client, new RouteRole[0]);
    }

    public Javalin sse(@NotNull String path, @NotNull SseHandler handler) {
        return get(path, handler);
    }

    public Javalin sse(@NotNull String path, @NotNull Consumer<SseClient> client, @NotNull RouteRole... roles) {
        return get(path, new SseHandler(client), roles);
    }

    public Javalin before(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.BEFORE, path, handler);
    }

    public Javalin before(@NotNull Handler handler) {
        return before("*", handler);
    }

    public Javalin after(@NotNull String path, @NotNull Handler handler) {
        return addHandler(HandlerType.AFTER, path, handler);
    }

    public Javalin after(@NotNull Handler handler) {
        return after("*", handler);
    }

    public <T extends Exception> Javalin wsException(@NotNull Class<T> exceptionClass, @NotNull WsExceptionHandler<? super T> exceptionHandler) {
        this.javalinJettyServlet.getWsExceptionMapper().getHandlers().put(exceptionClass, exceptionHandler);
        return this;
    }

    private Javalin addWsHandler(@NotNull WsHandlerType handlerType, @NotNull String path, @NotNull Consumer<WsConfig> wsConfig, @NotNull RouteRole... roles) {
        Set<RouteRole> roleSet = new HashSet<>(Arrays.asList(roles));
        this.javalinJettyServlet.addHandler(handlerType, path, wsConfig, roleSet);
        this.eventManager.fireWsHandlerAddedEvent(new WsHandlerMetaInfo(handlerType, Util.prefixContextPath(this.javalinServlet.getConfig().contextPath, path), wsConfig, roleSet));
        return this;
    }

    private Javalin addWsHandler(@NotNull WsHandlerType handlerType, @NotNull String path, @NotNull Consumer<WsConfig> wsConfig) {
        return addWsHandler(handlerType, path, wsConfig, new RouteRole[0]);
    }

    /* renamed from: ws */
    public Javalin m1191ws(@NotNull String path, @NotNull Consumer<WsConfig> ws) {
        return m1190ws(path, ws, new RouteRole[0]);
    }

    /* renamed from: ws */
    public Javalin m1190ws(@NotNull String path, @NotNull Consumer<WsConfig> ws, @NotNull RouteRole... roles) {
        return addWsHandler(WsHandlerType.WEBSOCKET, path, ws, roles);
    }

    public Javalin wsBefore(@NotNull String path, @NotNull Consumer<WsConfig> wsConfig) {
        return addWsHandler(WsHandlerType.WS_BEFORE, path, wsConfig);
    }

    public Javalin wsBefore(@NotNull Consumer<WsConfig> wsConfig) {
        return wsBefore("*", wsConfig);
    }

    public Javalin wsAfter(@NotNull String path, @NotNull Consumer<WsConfig> wsConfig) {
        return addWsHandler(WsHandlerType.WS_AFTER, path, wsConfig);
    }

    public Javalin wsAfter(@NotNull Consumer<WsConfig> wsConfig) {
        return wsAfter("*", wsConfig);
    }
}
