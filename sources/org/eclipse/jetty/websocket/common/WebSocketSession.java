package org.eclipse.jetty.websocket.common;

import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.CloseStatus;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.SuspendToken;
import org.eclipse.jetty.websocket.api.UpgradeRequest;
import org.eclipse.jetty.websocket.api.UpgradeResponse;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.ExtensionFactory;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;
import org.eclipse.jetty.websocket.common.events.EventDriver;
import org.eclipse.jetty.websocket.common.p025io.DisconnectCallback;
import org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope;
import org.eclipse.jetty.websocket.common.scopes.WebSocketSessionScope;

@ManagedObject("A Jetty WebSocket Session")
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/WebSocketSession.class */
public class WebSocketSession extends ContainerLifeCycle implements Session, RemoteEndpointFactory, WebSocketSessionScope, IncomingFrames, OutgoingFrames, Connection.Listener {
    private static final Logger LOG = Log.getLogger(WebSocketSession.class);
    private static final RemoteEndpointFactory defaultRemoteEndpointFactory;
    private final WebSocketContainerScope containerScope;
    private final URI requestURI;
    private final LogicalConnection connection;
    private final EventDriver websocket;
    private final Executor executor;
    private final WebSocketPolicy policy;
    private final RemoteEndpointFactory remoteEndpointFactory;
    private final ClassLoader classLoader;
    private ExtensionFactory extensionFactory;
    private String protocolVersion;
    private RemoteEndpoint remote;
    private final IncomingFrames incomingHandler;
    private OutgoingFrames outgoingHandler;
    private UpgradeRequest upgradeRequest;
    private UpgradeResponse upgradeResponse;
    private CompletableFuture<Session> openFuture;
    private final AtomicBoolean onCloseCalled = new AtomicBoolean(false);
    private final Map<String, String[]> parameterMap = new HashMap();

    static {
        Iterator<RemoteEndpointFactory> iter = ServiceLoader.load(RemoteEndpointFactory.class).iterator();
        defaultRemoteEndpointFactory = iter.hasNext() ? iter.next() : null;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Discovered default RemoteEndpointFactory: {}", defaultRemoteEndpointFactory);
        }
    }

    public WebSocketSession(WebSocketContainerScope containerScope, URI requestURI, EventDriver websocket, LogicalConnection connection) {
        Objects.requireNonNull(containerScope, "Container Scope cannot be null");
        Objects.requireNonNull(requestURI, "Request URI cannot be null");
        this.classLoader = containerScope.getClassLoader();
        this.containerScope = containerScope;
        this.requestURI = requestURI;
        this.websocket = websocket;
        this.connection = connection;
        this.executor = connection.getExecutor();
        this.outgoingHandler = connection;
        this.incomingHandler = websocket;
        this.policy = websocket.getPolicy();
        this.remoteEndpointFactory = defaultRemoteEndpointFactory == null ? this : defaultRemoteEndpointFactory;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Using RemoteEndpointFactory: {}", this.remoteEndpointFactory);
        }
        this.connection.setSession(this);
        addBean(this.connection);
        addBean(this.websocket);
        notifySessionListeners(containerScope, listener -> {
            listener.onSessionCreated(this);
        });
    }

    public void close(Throwable cause) {
        this.connection.close(cause);
    }

    @Override // org.eclipse.jetty.websocket.api.Session, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(new CloseInfo(1000), (Callback) null);
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public void close(CloseStatus closeStatus) {
        close(new CloseInfo(closeStatus.getCode(), closeStatus.getPhrase()), (Callback) null);
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public void close(int statusCode, String reason) {
        close(new CloseInfo(statusCode, reason), (Callback) null);
    }

    private void close(CloseInfo closeInfo, Callback callback) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("close({})", closeInfo);
        }
        this.connection.close(closeInfo, callback);
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public void disconnect() {
        this.connection.disconnect();
    }

    public void dispatch(Runnable runnable) {
        this.executor.execute(runnable);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("starting - {}", this);
        }
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("stopping - {}", this);
        }
        this.connection.close(new CloseInfo(1001, "Shutdown"), new DisconnectCallback(this.connection));
        doStop();
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dumpSelf() {
        return String.format("%s@%x[behavior=%s,batchMode=%s,idleTimeout=%d,requestURI=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), getPolicy().getBehavior(), getBatchMode(), Long.valueOf(getIdleTimeout()), getRequestURI());
    }

    public ByteBufferPool getBufferPool() {
        return this.connection.getBufferPool();
    }

    public ClassLoader getClassLoader() {
        return getClass().getClassLoader();
    }

    public LogicalConnection getConnection() {
        return this.connection;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketSessionScope
    public WebSocketContainerScope getContainerScope() {
        return this.containerScope;
    }

    public ExtensionFactory getExtensionFactory() {
        return this.extensionFactory;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public long getIdleTimeout() {
        return this.connection.getMaxIdleTimeout();
    }

    @ManagedAttribute(readonly = true)
    public IncomingFrames getIncomingHandler() {
        return this.incomingHandler;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public InetSocketAddress getLocalAddress() {
        return this.connection.getLocalAddress();
    }

    @ManagedAttribute(readonly = true)
    public OutgoingFrames getOutgoingHandler() {
        return this.outgoingHandler;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public String getProtocolVersion() {
        return this.protocolVersion;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public RemoteEndpoint getRemote() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("[{}] {}.getRemote()", this.policy.getBehavior(), getClass().getSimpleName());
        }
        return this.remote;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public InetSocketAddress getRemoteAddress() {
        return this.remote.getInetSocketAddress();
    }

    public URI getRequestURI() {
        return this.requestURI;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public UpgradeRequest getUpgradeRequest() {
        return this.upgradeRequest;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public UpgradeResponse getUpgradeResponse() {
        return this.upgradeResponse;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketSessionScope
    public WebSocketSession getWebSocketSession() {
        return this;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(Frame frame) {
        ClassLoader old = Thread.currentThread().getContextClassLoader();
        try {
            Thread.currentThread().setContextClassLoader(this.classLoader);
            if (this.connection.canReadWebSocketFrames()) {
                this.incomingHandler.incomingFrame(frame);
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("Attempt to process frame when in wrong connection state: " + this.connection.toStateString(), new RuntimeException("TRACE"));
            }
            Thread.currentThread().setContextClassLoader(old);
        } catch (Throwable th) {
            Thread.currentThread().setContextClassLoader(old);
            throw th;
        }
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
    public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        if (this.onCloseCalled.get()) {
            if (callback != null) {
                try {
                    callback.writeFailed(new WebSocketException("Session closed"));
                } catch (Throwable x) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Exception while notifying failure of callback " + callback, x);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        this.outgoingHandler.outgoingFrame(frame, callback, batchMode);
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public boolean isOpen() {
        return this.connection != null && !this.onCloseCalled.get() && this.connection.isOpen();
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public boolean isSecure() {
        if (this.upgradeRequest != null) {
            return "wss".equalsIgnoreCase(this.upgradeRequest.getRequestURI().getScheme());
        }
        throw new IllegalStateException("No valid UpgradeRequest yet");
    }

    public void callApplicationOnClose(CloseInfo closeInfo) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("callApplicationOnClose({})", closeInfo);
        }
        if (this.onCloseCalled.compareAndSet(false, true)) {
            try {
                this.websocket.onClose(closeInfo);
            } catch (Throwable t) {
                LOG.warn("Exception while notifying onClose", t);
            }
        }
    }

    public void callApplicationOnError(Throwable cause) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("callApplicationOnError()", cause);
        }
        if (this.openFuture != null) {
            this.openFuture.completeExceptionally(cause);
        }
        if (!this.onCloseCalled.get()) {
            try {
                this.websocket.onError(cause);
            } catch (Throwable t) {
                LOG.warn("Exception while notifying onError", t);
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onClosed(Connection connection) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("[{}] {}.onSessionClosed()", this.policy.getBehavior(), getClass().getSimpleName());
        }
        if (connection == this.connection) {
            this.connection.disconnect();
            try {
                notifySessionListeners(this.containerScope, listener -> {
                    listener.onSessionClosed(this);
                });
            } catch (Throwable cause) {
                LOG.ignore(cause);
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onOpened(Connection connection) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("[{}] {}.onSessionOpened()", this.policy.getBehavior(), getClass().getSimpleName());
        }
        open();
    }

    @Override // org.eclipse.jetty.websocket.common.RemoteEndpointFactory
    public WebSocketRemoteEndpoint newRemoteEndpoint(LogicalConnection connection, OutgoingFrames outgoingFrames, BatchMode batchMode) {
        return new WebSocketRemoteEndpoint(connection, outgoingFrames, getBatchMode());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x00be
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void open() {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.WebSocketSession.open():void");
    }

    public void setExtensionFactory(ExtensionFactory extensionFactory) {
        this.extensionFactory = extensionFactory;
    }

    public void setFuture(CompletableFuture<Session> fut) {
        this.openFuture = fut;
        fut.whenComplete(s, t -> {
            if (t != null) {
                close(t);
            }
        });
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public void setIdleTimeout(long ms) {
        this.connection.setMaxIdleTimeout(ms);
    }

    public void setOutgoingHandler(OutgoingFrames outgoing) {
        this.outgoingHandler = outgoing;
    }

    @Deprecated
    public void setPolicy(WebSocketPolicy policy) {
    }

    public void setUpgradeRequest(UpgradeRequest request) {
        this.upgradeRequest = request;
        this.protocolVersion = request.getProtocolVersion();
        this.parameterMap.clear();
        if (request.getParameterMap() != null) {
            for (Map.Entry<String, List<String>> entry : request.getParameterMap().entrySet()) {
                List<String> values = entry.getValue();
                if (values != null) {
                    this.parameterMap.put(entry.getKey(), (String[]) values.toArray(new String[values.size()]));
                } else {
                    this.parameterMap.put(entry.getKey(), new String[0]);
                }
            }
        }
    }

    public void setUpgradeResponse(UpgradeResponse response) {
        this.upgradeResponse = response;
    }

    @Override // org.eclipse.jetty.websocket.api.Session
    public SuspendToken suspend() {
        if (!this.onCloseCalled.get()) {
            return this.connection.suspend();
        }
        throw new IllegalStateException("Not open");
    }

    public BatchMode getBatchMode() {
        return BatchMode.AUTO;
    }

    private void notifySessionListeners(WebSocketContainerScope scope, Consumer<WebSocketSessionListener> consumer) {
        for (WebSocketSessionListener listener : scope.getSessionListeners()) {
            try {
                consumer.accept(listener);
            } catch (Throwable x) {
                LOG.info("Exception while invoking listener " + listener, x);
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("WebSocketSession[");
        builder.append("websocket=").append(this.websocket);
        builder.append(",behavior=").append(this.policy.getBehavior());
        builder.append(",connection=").append(this.connection);
        builder.append(",remote=").append(this.remote);
        builder.append(",incoming=").append(this.incomingHandler);
        builder.append(",outgoing=").append(this.outgoingHandler);
        builder.append("]");
        return builder.toString();
    }
}
