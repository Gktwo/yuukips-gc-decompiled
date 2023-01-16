package org.eclipse.jetty.websocket.server;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.MappedByteBufferPool;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnection;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.DecoratedObjectFactory;
import org.eclipse.jetty.util.DeprecationWarning;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.compression.DeflaterPool;
import org.eclipse.jetty.util.compression.InflaterPool;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.util.thread.ScheduledExecutorScheduler;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.websocket.api.InvalidWebSocketException;
import org.eclipse.jetty.websocket.api.WebSocketConstants;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.ExtensionFactory;
import org.eclipse.jetty.websocket.api.util.QuoteUtil;
import org.eclipse.jetty.websocket.common.LogicalConnection;
import org.eclipse.jetty.websocket.common.SessionFactory;
import org.eclipse.jetty.websocket.common.SessionTracker;
import org.eclipse.jetty.websocket.common.WebSocketSession;
import org.eclipse.jetty.websocket.common.WebSocketSessionFactory;
import org.eclipse.jetty.websocket.common.WebSocketSessionListener;
import org.eclipse.jetty.websocket.common.events.EventDriver;
import org.eclipse.jetty.websocket.common.events.EventDriverFactory;
import org.eclipse.jetty.websocket.common.extensions.ExtensionStack;
import org.eclipse.jetty.websocket.common.extensions.WebSocketExtensionFactory;
import org.eclipse.jetty.websocket.common.p025io.AbstractWebSocketConnection;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/WebSocketServerFactory.class */
public class WebSocketServerFactory extends ContainerLifeCycle implements WebSocketCreator, WebSocketContainerScope, WebSocketServletFactory {
    private static final Logger LOG = Log.getLogger(WebSocketServerFactory.class);
    private static final String WEBSOCKET_INFLATER_POOL_ATTRIBUTE = "jetty.websocket.inflater";
    private static final String WEBSOCKET_DEFLATER_POOL_ATTRIBUTE = "jetty.websocket.deflater";
    private final ClassLoader contextClassloader;
    private final Map<Integer, WebSocketHandshake> handshakes;
    private final Scheduler scheduler;
    private final List<WebSocketSessionListener> listeners;
    private final String supportedVersions;
    private final WebSocketPolicy defaultPolicy;
    private final EventDriverFactory eventDriverFactory;
    private final ByteBufferPool bufferPool;
    private final WebSocketExtensionFactory extensionFactory;
    private final ServletContext context;
    private final List<SessionFactory> sessionFactories;
    private final SessionTracker sessionTracker;
    private final List<Class<?>> registeredSocketClasses;
    private Executor executor;
    private DecoratedObjectFactory objectFactory;
    private WebSocketCreator creator;

    public WebSocketServerFactory() {
        this(WebSocketPolicy.newServerPolicy(), (Executor) null, new MappedByteBufferPool());
    }

    public WebSocketServerFactory(ServletContext context) {
        this(context, WebSocketPolicy.newServerPolicy(), (ByteBufferPool) null);
    }

    public WebSocketServerFactory(ServletContext context, ByteBufferPool bufferPool) {
        this(context, WebSocketPolicy.newServerPolicy(), bufferPool);
    }

    public WebSocketServerFactory(ServletContext context, WebSocketPolicy policy) {
        this(context, policy, (ByteBufferPool) null);
    }

    public WebSocketServerFactory(ServletContext context, WebSocketPolicy policy, ByteBufferPool bufferPool) {
        this((ServletContext) Objects.requireNonNull(context, ServletContext.class.getName()), policy, null, null, bufferPool);
    }

    /* access modifiers changed from: protected */
    public WebSocketServerFactory(WebSocketPolicy policy, Executor executor, ByteBufferPool bufferPool) {
        this(null, policy, new DecoratedObjectFactory(), executor, bufferPool);
    }

    private WebSocketServerFactory(ServletContext context, WebSocketPolicy policy, DecoratedObjectFactory objectFactory, Executor executor, ByteBufferPool bufferPool) {
        Server server;
        this.handshakes = new HashMap();
        this.scheduler = new ScheduledExecutorScheduler(String.format("WebSocket-Scheduler-%x", Integer.valueOf(hashCode())), false);
        this.listeners = new ArrayList();
        this.sessionFactories = new ArrayList();
        this.sessionTracker = new SessionTracker();
        this.registeredSocketClasses = new ArrayList();
        this.context = context;
        this.defaultPolicy = policy;
        this.objectFactory = objectFactory;
        this.executor = executor;
        this.creator = this;
        this.contextClassloader = Thread.currentThread().getContextClassLoader();
        this.eventDriverFactory = new EventDriverFactory(this);
        if (context == null) {
            this.extensionFactory = new WebSocketExtensionFactory(this);
        } else {
            DeflaterPool deflaterPool = (DeflaterPool) context.getAttribute(WEBSOCKET_DEFLATER_POOL_ATTRIBUTE);
            InflaterPool inflaterPool = (InflaterPool) context.getAttribute(WEBSOCKET_INFLATER_POOL_ATTRIBUTE);
            ContextHandler contextHandler = ContextHandler.getContextHandler(context);
            Server server2 = contextHandler == null ? null : contextHandler.getServer();
            if (server2 != null) {
                deflaterPool = deflaterPool == null ? DeflaterPool.ensurePool(server2) : deflaterPool;
                if (inflaterPool == null) {
                    inflaterPool = InflaterPool.ensurePool(server2);
                }
            }
            this.extensionFactory = new WebSocketExtensionFactory(this, inflaterPool, deflaterPool);
            if (server2 != null) {
                if (server2.contains(inflaterPool)) {
                    this.extensionFactory.unmanage(inflaterPool);
                }
                if (server2.contains(deflaterPool)) {
                    this.extensionFactory.unmanage(deflaterPool);
                }
            }
        }
        this.handshakes.put(13, new HandshakeRFC6455());
        this.sessionFactories.add(new WebSocketSessionFactory(this));
        if (bufferPool == null) {
            ContextHandler contextHandler2 = ServletContextHandler.getContextHandler(context);
            if (!(contextHandler2 == null || (server = contextHandler2.getServer()) == null)) {
                bufferPool = (ByteBufferPool) server.getBean((Class<Object>) ByteBufferPool.class);
            }
            if (bufferPool == null) {
                bufferPool = new MappedByteBufferPool();
            }
        }
        this.bufferPool = bufferPool;
        addBean(bufferPool);
        List<Integer> versions = new ArrayList<>(this.handshakes.keySet());
        versions.sort(Collections.reverseOrder());
        StringBuilder rv = new StringBuilder();
        for (Integer num : versions) {
            int v = num.intValue();
            if (rv.length() > 0) {
                rv.append(", ");
            }
            rv.append(v);
        }
        this.supportedVersions = rv.toString();
        addBean(this.scheduler);
        addBean(this.sessionTracker);
        addBean(this.extensionFactory);
        this.listeners.add(this.sessionTracker);
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public void addSessionListener(WebSocketSessionListener listener) {
        this.listeners.add(listener);
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public void removeSessionListener(WebSocketSessionListener listener) {
        this.listeners.remove(listener);
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public Collection<WebSocketSessionListener> getSessionListeners() {
        return this.listeners;
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    public boolean acceptWebSocket(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return acceptWebSocket(getCreator(), request, response);
    }

    /* JADX INFO: finally extract failed */
    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    public boolean acceptWebSocket(WebSocketCreator creator, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClassLoader old;
        try {
            old = Thread.currentThread().getContextClassLoader();
            try {
                Thread.currentThread().setContextClassLoader(this.contextClassloader);
                ServletUpgradeRequest sockreq = new ServletUpgradeRequest(request);
                ServletUpgradeResponse sockresp = new ServletUpgradeResponse(response);
                Object websocketPojo = creator.createWebSocket(sockreq, sockresp);
                if (sockresp.isCommitted()) {
                    Thread.currentThread().setContextClassLoader(old);
                    return false;
                } else if (websocketPojo == null) {
                    sockresp.sendError(503, "Endpoint Creation Failed");
                    Thread.currentThread().setContextClassLoader(old);
                    return false;
                } else {
                    boolean upgrade = upgrade((HttpConnection) request.getAttribute("org.eclipse.jetty.server.HttpConnection"), sockreq, sockresp, this.eventDriverFactory.wrap(getObjectFactory().decorate(websocketPojo)));
                    Thread.currentThread().setContextClassLoader(old);
                    return upgrade;
                }
            } catch (URISyntaxException e) {
                throw new IOException("Unable to accept websocket due to mangled URI", e);
            }
        } catch (Throwable th) {
            Thread.currentThread().setContextClassLoader(old);
            throw th;
        }
    }

    public void addSessionFactory(SessionFactory sessionFactory) {
        if (!this.sessionFactories.contains(sessionFactory)) {
            this.sessionFactories.add(sessionFactory);
        }
    }

    private WebSocketSession createSession(URI requestURI, EventDriver websocket, LogicalConnection connection) {
        if (websocket == null) {
            throw new InvalidWebSocketException("Unable to create Session from null websocket");
        }
        for (SessionFactory impl : this.sessionFactories) {
            if (impl.supports(websocket)) {
                try {
                    return impl.createSession(requestURI, websocket, connection);
                } catch (Throwable e) {
                    throw new InvalidWebSocketException("Unable to create Session", e);
                }
            }
        }
        throw new InvalidWebSocketException("Unable to create Session: unrecognized internal EventDriver type: " + websocket.getClass().getName());
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketCreator
    public Object createWebSocket(ServletUpgradeRequest req, ServletUpgradeResponse resp) {
        if (this.registeredSocketClasses.size() < 1) {
            throw new WebSocketException("No WebSockets have been registered with the factory.  Cannot use default implementation of WebSocketCreator.");
        }
        if (this.registeredSocketClasses.size() > 1) {
            LOG.warn("You have registered more than 1 websocket object, and are using the default WebSocketCreator! Using first registered websocket.", new Object[0]);
        }
        Class<?> firstClass = this.registeredSocketClasses.get(0);
        try {
            return this.objectFactory.createInstance(firstClass);
        } catch (Exception e) {
            throw new WebSocketException("Unable to create instance of " + firstClass, e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this.objectFactory == null) {
            this.objectFactory = findDecoratedObjectFactory();
        }
        if (this.executor == null) {
            this.executor = findExecutor();
        }
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this.sessionTracker.stop();
        this.extensionFactory.stop();
        doStop();
    }

    private DecoratedObjectFactory findDecoratedObjectFactory() {
        DecoratedObjectFactory objectFactory;
        if (this.context != null && (objectFactory = (DecoratedObjectFactory) this.context.getAttribute(DecoratedObjectFactory.ATTR)) != null) {
            return objectFactory;
        }
        DecoratedObjectFactory objectFactory2 = new DecoratedObjectFactory();
        objectFactory2.addDecorator(new DeprecationWarning());
        LOG.info("No DecoratedObjectFactory provided, using new {}", objectFactory2);
        return objectFactory2;
    }

    private Executor findExecutor() {
        Executor contextExecutor;
        Executor executor = (Executor) getBean((Class<Object>) Executor.class);
        if (executor != null) {
            return executor;
        }
        if (this.context != null) {
            Executor contextExecutor2 = (Executor) this.context.getAttribute("org.eclipse.jetty.websocket.Executor");
            if (contextExecutor2 != null) {
                return contextExecutor2;
            }
            Executor contextExecutor3 = (Executor) this.context.getAttribute("org.eclipse.jetty.server.Executor");
            if (contextExecutor3 != null) {
                return contextExecutor3;
            }
            ContextHandler contextHandler = ContextHandler.getContextHandler(this.context);
            if (!(contextHandler == null || (contextExecutor = contextHandler.getServer().getThreadPool()) == null)) {
                return contextExecutor;
            }
        }
        QueuedThreadPool threadPool = new QueuedThreadPool();
        threadPool.setName("WebSocketServerFactory");
        addManaged(threadPool);
        LOG.info("No Executor provided, using new {}", threadPool);
        return threadPool;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public ByteBufferPool getBufferPool() {
        return this.bufferPool;
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    public WebSocketCreator getCreator() {
        return this.creator;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public DecoratedObjectFactory getObjectFactory() {
        return this.objectFactory;
    }

    public EventDriverFactory getEventDriverFactory() {
        return this.eventDriverFactory;
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    public Set<String> getAvailableExtensionNames() {
        return Collections.unmodifiableSet(this.extensionFactory.getExtensionNames());
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    @Deprecated
    public ExtensionFactory getExtensionFactory() {
        return this.extensionFactory;
    }

    public Collection<WebSocketSession> getOpenSessions() {
        return this.sessionTracker.getSessions();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public WebSocketPolicy getPolicy() {
        return this.defaultPolicy;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public SslContextFactory getSslContextFactory() {
        return null;
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    public boolean isUpgradeRequest(HttpServletRequest request, HttpServletResponse response) {
        String connection;
        String upgrade = request.getHeader("Upgrade");
        if (upgrade == null || !"websocket".equalsIgnoreCase(upgrade) || (connection = request.getHeader("Connection")) == null) {
            return false;
        }
        boolean foundUpgradeToken = false;
        Iterator<String> iter = QuoteUtil.splitAt(connection, ",");
        while (true) {
            if (iter.hasNext()) {
                if ("upgrade".equalsIgnoreCase(iter.next())) {
                    foundUpgradeToken = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!foundUpgradeToken || !"GET".equalsIgnoreCase(request.getMethod())) {
            return false;
        }
        if ("HTTP/1.1".equals(request.getProtocol())) {
            return true;
        }
        if ("HTTP/2".equals(request.getProtocol())) {
            LOG.warn("WebSocket Bootstrap from HTTP/2 (RFC8441) not supported in Jetty 9.x", new Object[0]);
            return false;
        }
        LOG.warn("Not a 'HTTP/1.1' request (was [" + request.getProtocol() + "])", new Object[0]);
        return false;
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    public void register(Class<?> websocketPojo) {
        this.registeredSocketClasses.add(websocketPojo);
    }

    @Override // org.eclipse.jetty.websocket.servlet.WebSocketServletFactory
    public void setCreator(WebSocketCreator creator) {
        this.creator = creator;
    }

    private boolean upgrade(HttpConnection http, ServletUpgradeRequest request, ServletUpgradeResponse response, EventDriver driver) throws IOException {
        if (!"websocket".equalsIgnoreCase(request.getHeader("Upgrade"))) {
            throw new IllegalStateException("Not a 'WebSocket: Upgrade' request");
        } else if (!"HTTP/1.1".equals(request.getHttpVersion())) {
            throw new IllegalStateException("Not a 'HTTP/1.1' request");
        } else {
            int version = request.getHeaderInt(WebSocketConstants.SEC_WEBSOCKET_VERSION);
            if (version < 0) {
                version = request.getHeaderInt("Sec-WebSocket-Draft");
            }
            WebSocketHandshake handshaker = this.handshakes.get(Integer.valueOf(version));
            if (handshaker == null) {
                StringBuilder warn = new StringBuilder();
                warn.append("Client ").append(request.getRemoteAddress());
                warn.append(" (:").append(request.getRemotePort());
                warn.append(") User Agent: ");
                String ua = request.getHeader("User-Agent");
                if (ua == null) {
                    warn.append("[unset] ");
                } else {
                    warn.append('\"').append(StringUtil.sanitizeXmlString(ua)).append("\" ");
                }
                warn.append("requested WebSocket version [").append(version);
                warn.append("], Jetty supports version");
                if (this.handshakes.size() > 1) {
                    warn.append('s');
                }
                warn.append(": [").append(this.supportedVersions).append("]");
                LOG.warn(warn.toString(), new Object[0]);
                response.setHeader(WebSocketConstants.SEC_WEBSOCKET_VERSION, this.supportedVersions);
                response.sendError(400, "Unsupported websocket version specification");
                return false;
            }
            ExtensionStack extensionStack = new ExtensionStack(getExtensionFactory());
            if (response.isExtensionsNegotiated()) {
                extensionStack.negotiate(response.getExtensions());
            } else {
                extensionStack.negotiate(request.getExtensions());
            }
            EndPoint endp = http.getEndPoint();
            Connector connector = http.getConnector();
            AbstractWebSocketConnection wsConnection = new WebSocketServerConnection(endp, connector.getExecutor(), this.scheduler, driver.getPolicy(), connector.getByteBufferPool());
            for (Connection.Listener listener : connector.getBeans(Connection.Listener.class)) {
                wsConnection.addListener(listener);
            }
            extensionStack.setPolicy(driver.getPolicy());
            extensionStack.configure(wsConnection.getParser());
            extensionStack.configure(wsConnection.getGenerator());
            if (LOG.isDebugEnabled()) {
                LOG.debug("HttpConnection: {}", http);
                LOG.debug("WebSocketConnection: {}", wsConnection);
            }
            WebSocketSession session = createSession(request.getRequestURI(), driver, wsConnection);
            session.setUpgradeRequest(request);
            response.setExtensions(extensionStack.getNegotiatedExtensions());
            session.setUpgradeResponse(response);
            wsConnection.addListener(session);
            wsConnection.setNextIncomingFrames(extensionStack);
            extensionStack.setNextIncoming(session);
            session.setOutgoingHandler(extensionStack);
            extensionStack.setNextOutgoing(wsConnection);
            session.addManaged(extensionStack);
            if (session.isFailed()) {
                throw new IOException("Session failed to start");
            }
            request.setServletAttribute(HttpConnection.UPGRADE_CONNECTION_ATTRIBUTE, wsConnection);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Handshake Response: {}", handshaker);
            }
            if (getSendServerVersion(connector)) {
                response.setHeader("Server", HttpConfiguration.SERVER_VERSION);
            }
            handshaker.doHandshakeResponse(request, response);
            response.setSuccess(true);
            if (!LOG.isDebugEnabled()) {
                return true;
            }
            LOG.debug("Websocket upgrade {} {} {} {}", request.getRequestURI(), Integer.valueOf(version), response.getAcceptedSubProtocol(), wsConnection);
            return true;
        }
    }

    private boolean getSendServerVersion(Connector connector) {
        HttpConfiguration httpConf;
        ConnectionFactory connFactory = connector.getConnectionFactory(HttpVersion.HTTP_1_1.asString());
        if (connFactory == null || !(connFactory instanceof HttpConnectionFactory) || (httpConf = ((HttpConnectionFactory) connFactory).getHttpConfiguration()) == null) {
            return false;
        }
        return httpConf.getSendServerVersion();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append('@').append(Integer.toHexString(hashCode()));
        sb.append("[defaultPolicy=").append(this.defaultPolicy);
        sb.append(",creator=").append(this.creator.getClass().getName());
        sb.append("]");
        return sb.toString();
    }
}
