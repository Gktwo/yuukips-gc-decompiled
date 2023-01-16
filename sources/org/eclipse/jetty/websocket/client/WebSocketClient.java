package org.eclipse.jetty.websocket.client;

import java.io.IOException;
import java.net.CookieStore;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.DecoratedObjectFactory;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.util.thread.ShutdownThread;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketBehavior;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.ExtensionFactory;
import org.eclipse.jetty.websocket.client.masks.Masker;
import org.eclipse.jetty.websocket.client.masks.RandomMasker;
import org.eclipse.jetty.websocket.client.p024io.ConnectionManager;
import org.eclipse.jetty.websocket.client.p024io.UpgradeListener;
import org.eclipse.jetty.websocket.common.SessionFactory;
import org.eclipse.jetty.websocket.common.SessionTracker;
import org.eclipse.jetty.websocket.common.WebSocketSession;
import org.eclipse.jetty.websocket.common.WebSocketSessionFactory;
import org.eclipse.jetty.websocket.common.WebSocketSessionListener;
import org.eclipse.jetty.websocket.common.events.EventDriverFactory;
import org.eclipse.jetty.websocket.common.extensions.WebSocketExtensionFactory;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/WebSocketClient.class */
public class WebSocketClient extends ContainerLifeCycle implements WebSocketContainerScope {
    private static final Logger LOG = Log.getLogger(WebSocketClient.class);
    private final HttpClient httpClient;
    private final Supplier<DecoratedObjectFactory> objectFactorySupplier;
    private final ClassLoader classloader;
    private final WebSocketPolicy policy;
    private final WebSocketExtensionFactory extensionRegistry;
    private final SessionTracker sessionTracker;
    private final List<WebSocketSessionListener> sessionListeners;
    private EventDriverFactory eventDriverFactory;
    private SessionFactory sessionFactory;
    private boolean stopAtShutdown;

    public WebSocketClient() {
        this(HttpClientProvider.get(null), (DecoratedObjectFactory) null);
    }

    public WebSocketClient(HttpClient httpClient) {
        this(httpClient, (DecoratedObjectFactory) null);
    }

    public WebSocketClient(HttpClient httpClient, DecoratedObjectFactory decoratedObjectFactory) {
        this.sessionTracker = new SessionTracker();
        this.sessionListeners = new ArrayList();
        this.stopAtShutdown = true;
        this.classloader = Thread.currentThread().getContextClassLoader();
        this.httpClient = (HttpClient) Objects.requireNonNull(httpClient, "HttpClient");
        addBean(httpClient);
        addBean(this.sessionTracker);
        addSessionListener(this.sessionTracker);
        this.policy = WebSocketPolicy.newClientPolicy();
        DecoratedObjectFactory objectFactory = decoratedObjectFactory == null ? new DecoratedObjectFactory() : decoratedObjectFactory;
        this.objectFactorySupplier = () -> {
            return objectFactory;
        };
        this.extensionRegistry = new WebSocketExtensionFactory(this);
        addBean(this.extensionRegistry);
        this.eventDriverFactory = new EventDriverFactory(this);
        this.sessionFactory = new WebSocketSessionFactory(this);
    }

    @Deprecated
    public WebSocketClient(SslContextFactory sslContextFactory) {
        this(newHttpClient(sslContextFactory, null, null), (DecoratedObjectFactory) null);
    }

    @Deprecated
    public WebSocketClient(Executor executor) {
        this(newHttpClient(null, executor, null), (DecoratedObjectFactory) null);
    }

    @Deprecated
    public WebSocketClient(ByteBufferPool bufferPool) {
        this(newHttpClient(null, null, bufferPool), (DecoratedObjectFactory) null);
    }

    @Deprecated
    public WebSocketClient(SslContextFactory sslContextFactory, Executor executor) {
        this(newHttpClient(sslContextFactory, executor, null), (DecoratedObjectFactory) null);
    }

    @Deprecated
    public WebSocketClient(WebSocketContainerScope scope) {
        this(newHttpClient(scope.getSslContextFactory(), scope.getExecutor(), scope.getBufferPool()), scope.getObjectFactory());
    }

    @Deprecated
    public WebSocketClient(WebSocketContainerScope scope, SslContextFactory sslContextFactory) {
        this(newHttpClient(sslContextFactory, scope.getExecutor(), scope.getBufferPool()), scope.getObjectFactory());
    }

    @Deprecated
    public WebSocketClient(SslContextFactory sslContextFactory, Executor executor, ByteBufferPool bufferPool) {
        this(newHttpClient(sslContextFactory, executor, bufferPool), (DecoratedObjectFactory) null);
    }

    @Deprecated
    public WebSocketClient(WebSocketContainerScope scope, EventDriverFactory eventDriverFactory, SessionFactory sessionFactory) {
        this(scope, eventDriverFactory, sessionFactory, HttpClientProvider.get(scope));
    }

    public WebSocketClient(WebSocketContainerScope scope, EventDriverFactory eventDriverFactory, SessionFactory sessionFactory, HttpClient httpClient) {
        this.sessionTracker = new SessionTracker();
        this.sessionListeners = new ArrayList();
        this.stopAtShutdown = true;
        this.classloader = Thread.currentThread().getContextClassLoader();
        this.httpClient = httpClient == null ? HttpClientProvider.get(scope) : httpClient;
        addBean(this.httpClient);
        addBean(this.sessionTracker);
        addSessionListener(this.sessionTracker);
        this.policy = scope.getPolicy().delegateAs(WebSocketBehavior.CLIENT);
        Objects.requireNonNull(scope);
        this.objectFactorySupplier = this::getObjectFactory;
        this.extensionRegistry = new WebSocketExtensionFactory(this);
        addBean(this.extensionRegistry);
        this.eventDriverFactory = eventDriverFactory == null ? new EventDriverFactory(this) : eventDriverFactory;
        this.sessionFactory = sessionFactory == null ? new WebSocketSessionFactory(this) : sessionFactory;
    }

    private static HttpClient newHttpClient(SslContextFactory sslContextFactory, Executor executor, ByteBufferPool bufferPool) {
        HttpClient httpClient = new HttpClient(sslContextFactory);
        httpClient.setExecutor(executor);
        httpClient.setByteBufferPool(bufferPool);
        return httpClient;
    }

    public Future<Session> connect(Object websocket, URI toUri) throws IOException {
        ClientUpgradeRequest request = new ClientUpgradeRequest(toUri);
        request.setRequestURI(toUri);
        request.setLocalEndpoint(websocket);
        return connect(websocket, toUri, request);
    }

    public Future<Session> connect(Object websocket, URI toUri, ClientUpgradeRequest request) throws IOException {
        return connect(websocket, toUri, request, null);
    }

    public Future<Session> connect(Object websocket, URI toUri, ClientUpgradeRequest request, UpgradeListener upgradeListener) throws IOException {
        if (!isStarted()) {
            throw new IllegalStateException(WebSocketClient.class.getSimpleName() + "@" + hashCode() + " is not started");
        } else if (!toUri.isAbsolute()) {
            throw new IllegalArgumentException("WebSocket URI must be absolute");
        } else if (StringUtil.isBlank(toUri.getScheme())) {
            throw new IllegalArgumentException("WebSocket URI must include a scheme");
        } else {
            String scheme = toUri.getScheme().toLowerCase(Locale.ENGLISH);
            if (!"ws".equals(scheme) && !"wss".equals(scheme)) {
                throw new IllegalArgumentException("WebSocket URI scheme only supports [ws] and [wss], not [" + scheme + "]");
            } else if (!"wss".equals(scheme) || this.httpClient.getSslContextFactory() != null) {
                request.setRequestURI(toUri);
                request.setLocalEndpoint(websocket);
                for (ExtensionConfig reqExt : request.getExtensions()) {
                    if (!this.extensionRegistry.isAvailable(reqExt.getName())) {
                        throw new IllegalArgumentException("Requested extension [" + reqExt.getName() + "] is not installed");
                    }
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("connect websocket {} to {}", websocket, toUri);
                }
                init();
                WebSocketUpgradeRequest wsReq = new WebSocketUpgradeRequest(this, this.httpClient, request);
                wsReq.timeout(request.getTimeout(), TimeUnit.MILLISECONDS);
                wsReq.setUpgradeListener(upgradeListener);
                for (Request.Listener l : getBeans(Request.Listener.class)) {
                    wsReq.listener(l);
                }
                return wsReq.sendAsync();
            } else {
                throw new IllegalStateException("HttpClient has no SslContextFactory, wss:// URI's are not supported in this configuration");
            }
        }
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public ClassLoader getClassLoader() {
        return this.classloader;
    }

    public void setEventDriverFactory(EventDriverFactory eventDriverFactory) {
        this.eventDriverFactory = eventDriverFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        Objects.requireNonNull(this.httpClient, "Provided HttpClient is null");
        doStart();
        if (!this.httpClient.isRunning()) {
            throw new IllegalStateException("HttpClient is not running (did you forget to start it?): " + this.httpClient);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Stopping {}", this);
        }
        ShutdownThread.deregister(this);
        this.sessionTracker.stop();
        this.extensionRegistry.stop();
        doStop();
        if (LOG.isDebugEnabled()) {
            LOG.debug("Stopped {}", this);
        }
    }

    @Deprecated
    public boolean isDispatchIO() {
        return this.httpClient.isDispatchIO();
    }

    @Deprecated
    public long getAsyncWriteTimeout() {
        return getPolicy().getAsyncWriteTimeout();
    }

    public SocketAddress getBindAddress() {
        return this.httpClient.getBindAddress();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public ByteBufferPool getBufferPool() {
        return this.httpClient.getByteBufferPool();
    }

    @Deprecated
    public ConnectionManager getConnectionManager() {
        throw new UnsupportedOperationException("ConnectionManager is no longer supported");
    }

    public long getConnectTimeout() {
        return this.httpClient.getConnectTimeout();
    }

    public CookieStore getCookieStore() {
        return this.httpClient.getCookieStore();
    }

    public EventDriverFactory getEventDriverFactory() {
        return this.eventDriverFactory;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public Executor getExecutor() {
        return this.httpClient.getExecutor();
    }

    public ExtensionFactory getExtensionFactory() {
        return this.extensionRegistry;
    }

    @Deprecated
    public Masker getMasker() {
        return new RandomMasker();
    }

    public int getMaxBinaryMessageBufferSize() {
        return getPolicy().getMaxBinaryMessageBufferSize();
    }

    public long getMaxBinaryMessageSize() {
        return (long) getPolicy().getMaxBinaryMessageSize();
    }

    public long getMaxIdleTimeout() {
        return getPolicy().getIdleTimeout();
    }

    public int getMaxTextMessageBufferSize() {
        return getPolicy().getMaxTextMessageBufferSize();
    }

    public long getMaxTextMessageSize() {
        return (long) getPolicy().getMaxTextMessageSize();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public DecoratedObjectFactory getObjectFactory() {
        return this.objectFactorySupplier.get();
    }

    public Set<WebSocketSession> getOpenSessions() {
        return this.sessionTracker.getSessions();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    public Scheduler getScheduler() {
        return this.httpClient.getScheduler();
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public SslContextFactory getSslContextFactory() {
        return this.httpClient.getSslContextFactory();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public void addSessionListener(WebSocketSessionListener listener) {
        this.sessionListeners.add(listener);
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public void removeSessionListener(WebSocketSessionListener listener) {
        this.sessionListeners.remove(listener);
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public Collection<WebSocketSessionListener> getSessionListeners() {
        return this.sessionListeners;
    }

    private synchronized void init() {
        if (isStopAtShutdown() && !ShutdownThread.isRegistered(this)) {
            ShutdownThread.register(this);
        }
    }

    @Deprecated
    protected ConnectionManager newConnectionManager() {
        throw new UnsupportedOperationException("ConnectionManager is no longer supported");
    }

    public void setAsyncWriteTimeout(long ms) {
        getPolicy().setAsyncWriteTimeout(ms);
    }

    @Deprecated
    public void setBindAdddress(SocketAddress bindAddress) {
        setBindAddress(bindAddress);
    }

    public void setBindAddress(SocketAddress bindAddress) {
        this.httpClient.setBindAddress(bindAddress);
    }

    public void setBufferPool(ByteBufferPool bufferPool) {
        this.httpClient.setByteBufferPool(bufferPool);
    }

    public void setConnectTimeout(long ms) {
        this.httpClient.setConnectTimeout(ms);
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.httpClient.setCookieStore(cookieStore);
    }

    @Deprecated
    public void setDaemon(boolean daemon) {
    }

    @Deprecated
    public void setDispatchIO(boolean dispatchIO) {
        this.httpClient.setDispatchIO(dispatchIO);
    }

    public void setExecutor(Executor executor) {
        this.httpClient.setExecutor(executor);
    }

    @Deprecated
    public void setMasker(Masker masker) {
    }

    public void setMaxBinaryMessageBufferSize(int max) {
        getPolicy().setMaxBinaryMessageBufferSize(max);
    }

    public void setMaxIdleTimeout(long ms) {
        getPolicy().setIdleTimeout(ms);
        this.httpClient.setIdleTimeout(ms);
    }

    public void setMaxTextMessageBufferSize(int max) {
        getPolicy().setMaxTextMessageBufferSize(max);
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public synchronized void setStopAtShutdown(boolean stop) {
        if (!stop) {
            ShutdownThread.deregister(this);
        } else if (!this.stopAtShutdown && isStarted() && !ShutdownThread.isRegistered(this)) {
            ShutdownThread.register(this);
        }
        this.stopAtShutdown = stop;
    }

    public boolean isStopAtShutdown() {
        return this.stopAtShutdown;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WebSocketClient)) {
            return false;
        }
        WebSocketClient that = (WebSocketClient) o;
        return Objects.equals(this.httpClient, that.httpClient) && Objects.equals(this.policy, that.policy);
    }

    public int hashCode() {
        return Objects.hash(this.httpClient, this.policy);
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder("WebSocketClient@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append("[httpClient=").append(this.httpClient);
        sb.append(",openSessions.size=");
        sb.append(getOpenSessions().size());
        sb.append(']');
        return sb.toString();
    }
}
