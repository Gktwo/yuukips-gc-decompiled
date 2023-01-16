package p013io.javalin.jetty;

import java.net.BindException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandlerContainer;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.URIUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.JavalinConfig;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.core.util.Util;

/* compiled from: JettyServer.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��^\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020&H\u0002J\f\u0010'\u001a\u00020$*\u00020(H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n��\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u000e¢\u0006\u0002\n��R\u0018\u0010\u0015\u001a\u00020\b*\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006)"}, m373d2 = {"Lio/javalin/jetty/JettyServer;", "", "config", "Lio/javalin/core/JavalinConfig;", "(Lio/javalin/core/JavalinConfig;)V", "getConfig", "()Lio/javalin/core/JavalinConfig;", "serverHost", "", "getServerHost", "()Ljava/lang/String;", "setServerHost", "(Ljava/lang/String;)V", "serverPort", "", "getServerPort", "()I", "setServerPort", "(I)V", "started", "", "protocol", "Lorg/eclipse/jetty/server/ServerConnector;", "getProtocol", "(Lorg/eclipse/jetty/server/ServerConnector;)Ljava/lang/String;", "defaultConnector", "server", "Lorg/eclipse/jetty/server/Server;", "defaultSessionHandler", "Lorg/eclipse/jetty/server/session/SessionHandler;", "start", "", "wsAndHttpServlet", "Lio/javalin/jetty/JavalinJettyServlet;", "attachHandler", "Lorg/eclipse/jetty/server/handler/AbstractHandlerContainer;", "Lorg/eclipse/jetty/server/Handler;", "servletContextHandler", "Lorg/eclipse/jetty/servlet/ServletContextHandler;", "unwrap", "Lorg/eclipse/jetty/server/handler/HandlerWrapper;", "javalin"})
/* renamed from: io.javalin.jetty.JettyServer */
/* loaded from: grasscutter.jar:io/javalin/jetty/JettyServer.class */
public final class JettyServer {
    @NotNull
    private final JavalinConfig config;
    @JvmField
    public boolean started;
    private int serverPort = -1;
    @Nullable
    private String serverHost;

    public JettyServer(@NotNull JavalinConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    @NotNull
    public final JavalinConfig getConfig() {
        return this.config;
    }

    public final int getServerPort() {
        return this.serverPort;
    }

    public final void setServerPort(int i) {
        this.serverPort = i;
    }

    @Nullable
    public final String getServerHost() {
        return this.serverHost;
    }

    public final void setServerHost(@Nullable String str) {
        this.serverHost = str;
    }

    @NotNull
    public final Server server() {
        JavalinConfig.Inner inner = this.config.inner;
        Server server = this.config.inner.server;
        inner.server = server == null ? JettyUtil.getOrDefault(this.config.inner.server) : server;
        Server server2 = this.config.inner.server;
        Intrinsics.checkNotNull(server2);
        Intrinsics.checkNotNullExpressionValue(server2, "config.inner.server!!");
        return server2;
    }

    /* JADX INFO: Multiple debug info for r0v13 io.javalin.jetty.JettyServer$start$wsAndHttpHandler$1: [D('$this$start_u24lambda_u2d0' io.javalin.jetty.JettyServer$start$wsAndHttpHandler$1), D('wsAndHttpHandler' io.javalin.jetty.JettyServer$start$wsAndHttpHandler$1)] */
    public final void start(@NotNull JavalinJettyServlet wsAndHttpServlet) throws BindException {
        AbstractHandlerContainer abstractHandlerContainer;
        Intrinsics.checkNotNullParameter(wsAndHttpServlet, "wsAndHttpServlet");
        if (this.serverPort == -1 && this.config.inner.server == null) {
            this.serverPort = 8080;
            JavalinLogger.startup("No port specified, starting on port " + this.serverPort + ". Call start(port) to change ports.");
        }
        JavalinConfig.Inner inner = this.config.inner;
        SessionHandler sessionHandler = this.config.inner.sessionHandler;
        inner.sessionHandler = sessionHandler == null ? defaultSessionHandler() : sessionHandler;
        String str = this.config.contextPath;
        Intrinsics.checkNotNullExpressionValue(str, "config.contextPath");
        JettyServer$start$wsAndHttpHandler$1 wsAndHttpHandler = new ServletContextHandler(null, Util.normalizeContextPath(str)) { // from class: io.javalin.jetty.JettyServer$start$wsAndHttpHandler$1
            final /* synthetic */ Void $nullParent;

            /* access modifiers changed from: package-private */
            {
                this.$nullParent = $nullParent;
            }

            @Override // org.eclipse.jetty.server.handler.ContextHandler, org.eclipse.jetty.server.handler.ScopedHandler
            public void doHandle(@NotNull String target, @NotNull Request jettyRequest, @NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
                Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
                Intrinsics.checkNotNullParameter(jettyRequest, "jettyRequest");
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(response, "response");
                request.setAttribute("jetty-target", target);
                request.setAttribute("jetty-request", jettyRequest);
                nextHandle(target, jettyRequest, request, response);
            }
        };
        wsAndHttpHandler.setSessionHandler(getConfig().inner.sessionHandler);
        Consumer<ServletContextHandler> consumer = getConfig().inner.servletContextHandlerConsumer;
        if (consumer != null) {
            consumer.accept(wsAndHttpHandler);
        }
        wsAndHttpHandler.addServlet(new ServletHolder(wsAndHttpServlet), "/*");
        Server $this$start_u24lambda_u2d1 = server();
        if ($this$start_u24lambda_u2d1.getHandler() == null) {
            abstractHandlerContainer = wsAndHttpHandler;
        } else {
            Handler handler = $this$start_u24lambda_u2d1.getHandler();
            Intrinsics.checkNotNullExpressionValue(handler, "handler");
            abstractHandlerContainer = attachHandler(handler, wsAndHttpHandler);
        }
        $this$start_u24lambda_u2d1.setHandler(abstractHandlerContainer);
        Connector[] connectors = $this$start_u24lambda_u2d1.getConnectors();
        Intrinsics.checkNotNullExpressionValue(connectors, "connectors");
        if (connectors.length == 0) {
            $this$start_u24lambda_u2d1.setConnectors(new ServerConnector[]{defaultConnector($this$start_u24lambda_u2d1)});
        }
        $this$start_u24lambda_u2d1.start();
        JavalinLogger.INSTANCE.logAllDelayed$javalin();
        Connector[] connectors2 = server().getConnectors();
        Intrinsics.checkNotNullExpressionValue(connectors2, "server().connectors");
        Connector[] connectorArr = connectors2;
        Collection destination$iv$iv = new ArrayList();
        for (Connector connector : connectorArr) {
            if (connector instanceof ServerConnector) {
                destination$iv$iv.add(connector);
            }
        }
        for (ServerConnector it : (List) destination$iv$iv) {
            StringBuilder append = new StringBuilder().append("Listening on ").append(getProtocol(it)).append("://");
            String host = it.getHost();
            JavalinLogger.startup(append.append(host == null ? "localhost" : host).append(':').append(it.getLocalPort()).append(getConfig().contextPath).toString());
        }
        Connector[] connectors3 = server().getConnectors();
        Intrinsics.checkNotNullExpressionValue(connectors3, "server().connectors");
        Connector[] connectorArr2 = connectors3;
        Collection destination$iv$iv2 = new ArrayList();
        for (Connector it2 : connectorArr2) {
            if (!(it2 instanceof ServerConnector)) {
                destination$iv$iv2.add(it2);
            }
        }
        for (Connector it3 : (List) destination$iv$iv2) {
            JavalinLogger.startup(Intrinsics.stringPlus("Binding to: ", it3));
        }
        JettyUtil.INSTANCE.reEnableJettyLogger();
        Connector connector2 = server().getConnectors()[0];
        ServerConnector serverConnector = connector2 instanceof ServerConnector ? (ServerConnector) connector2 : null;
        this.serverPort = serverConnector == null ? -1 : serverConnector.getLocalPort();
    }

    private final ServerConnector defaultConnector(Server server) {
        ServerConnector $this$defaultConnector_u24lambda_u2d6 = new ServerConnector(server);
        $this$defaultConnector_u24lambda_u2d6.setPort(getServerPort());
        $this$defaultConnector_u24lambda_u2d6.setHost(getServerHost());
        Iterable<ConnectionFactory> $this$forEach$iv = $this$defaultConnector_u24lambda_u2d6.getConnectionFactories();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "this.connectionFactories");
        for (ConnectionFactory it : $this$forEach$iv) {
            if (it instanceof HttpConnectionFactory) {
                ((HttpConnectionFactory) it).getHttpConfiguration().setSendServerVersion(false);
            }
        }
        return $this$defaultConnector_u24lambda_u2d6;
    }

    private final SessionHandler defaultSessionHandler() {
        SessionHandler $this$defaultSessionHandler_u24lambda_u2d7 = new SessionHandler();
        $this$defaultSessionHandler_u24lambda_u2d7.setHttpOnly(true);
        return $this$defaultSessionHandler_u24lambda_u2d7;
    }

    private final String getProtocol(ServerConnector $this$protocol) {
        return $this$protocol.getProtocols().contains("ssl") ? URIUtil.HTTPS : URIUtil.HTTP;
    }

    private final AbstractHandlerContainer attachHandler(Handler $this$attachHandler, ServletContextHandler servletContextHandler) {
        if ($this$attachHandler instanceof HandlerCollection) {
            ((HandlerCollection) $this$attachHandler).addHandler(servletContextHandler);
            return (AbstractHandlerContainer) $this$attachHandler;
        } else if ($this$attachHandler instanceof HandlerWrapper) {
            HandlerWrapper $this$attachHandler_u24lambda_u2d9 = (HandlerWrapper) $this$attachHandler;
            Handler unwrap = unwrap($this$attachHandler_u24lambda_u2d9);
            HandlerCollection handlerCollection = unwrap instanceof HandlerCollection ? (HandlerCollection) unwrap : null;
            if (handlerCollection != null) {
                handlerCollection.addHandler(servletContextHandler);
            }
            Handler unwrap2 = unwrap($this$attachHandler_u24lambda_u2d9);
            HandlerWrapper handlerWrapper = unwrap2 instanceof HandlerWrapper ? (HandlerWrapper) unwrap2 : null;
            if (handlerWrapper != null) {
                handlerWrapper.setHandler(servletContextHandler);
            }
            return (AbstractHandlerContainer) $this$attachHandler;
        } else {
            throw new IllegalStateException("Server has unsupported Handler attached to it (must be HandlerCollection or HandlerWrapper)");
        }
    }

    private final Handler unwrap(HandlerWrapper $this$unwrap) {
        Handler handler = $this$unwrap.getHandler();
        if (handler == null) {
            return $this$unwrap;
        }
        if (handler instanceof HandlerCollection) {
            Handler handler2 = $this$unwrap.getHandler();
            Intrinsics.checkNotNullExpressionValue(handler2, "this.handler");
            return handler2;
        } else if (handler instanceof HandlerWrapper) {
            Handler handler3 = $this$unwrap.getHandler();
            if (handler3 != null) {
                return unwrap((HandlerWrapper) handler3);
            }
            throw new NullPointerException("null cannot be cast to non-null type org.eclipse.jetty.server.handler.HandlerWrapper");
        } else {
            throw new IllegalStateException("HandlerWrapper has unsupported Handler type (must be HandlerCollection or HandlerWrapper");
        }
    }
}
