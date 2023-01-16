package org.eclipse.jetty.websocket.common.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.MappedByteBufferPool;
import org.eclipse.jetty.util.DecoratedObjectFactory;
import org.eclipse.jetty.util.DeprecationWarning;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.util.thread.QueuedThreadPool;
import org.eclipse.jetty.websocket.api.WebSocketBehavior;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.common.WebSocketSessionListener;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/scopes/SimpleContainerScope.class */
public class SimpleContainerScope extends ContainerLifeCycle implements WebSocketContainerScope {
    private final ByteBufferPool bufferPool;
    private final DecoratedObjectFactory objectFactory;
    private final WebSocketPolicy policy;
    private final Executor executor;
    private final Logger logger;
    private SslContextFactory sslContextFactory;
    private List<WebSocketSessionListener> sessionListeners;

    public SimpleContainerScope(WebSocketPolicy policy) {
        this(policy, new MappedByteBufferPool());
    }

    public SimpleContainerScope(WebSocketPolicy policy, ByteBufferPool bufferPool) {
        this(policy, bufferPool, new DecoratedObjectFactory());
    }

    public SimpleContainerScope(WebSocketPolicy policy, ByteBufferPool bufferPool, DecoratedObjectFactory objectFactory) {
        this(policy, bufferPool, null, objectFactory);
    }

    public SimpleContainerScope(WebSocketPolicy policy, ByteBufferPool bufferPool, Executor executor, DecoratedObjectFactory objectFactory) {
        this(policy, bufferPool, executor, null, objectFactory);
    }

    public SimpleContainerScope(WebSocketPolicy policy, ByteBufferPool bufferPool, Executor executor, SslContextFactory ssl, DecoratedObjectFactory objectFactory) {
        this.sessionListeners = new ArrayList();
        this.logger = Log.getLogger(getClass());
        this.policy = policy;
        this.bufferPool = bufferPool;
        if (objectFactory == null) {
            this.objectFactory = new DecoratedObjectFactory();
            this.objectFactory.addDecorator(new DeprecationWarning());
        } else {
            this.objectFactory = objectFactory;
        }
        if (ssl != null) {
            this.sslContextFactory = ssl;
        } else if (policy.getBehavior() == WebSocketBehavior.CLIENT) {
            this.sslContextFactory = new SslContextFactory.Client();
        } else if (policy.getBehavior() == WebSocketBehavior.SERVER) {
            this.sslContextFactory = new SslContextFactory.Server();
        }
        if (executor == null) {
            QueuedThreadPool threadPool = new QueuedThreadPool();
            String behavior = "Container";
            if (policy != null) {
                if (policy.getBehavior() == WebSocketBehavior.CLIENT) {
                    behavior = "Client";
                } else if (policy.getBehavior() == WebSocketBehavior.SERVER) {
                    behavior = "Server";
                }
            }
            threadPool.setName(String.format("WebSocket%s@%s", behavior, Integer.valueOf(hashCode())));
            threadPool.setDaemon(true);
            this.executor = threadPool;
            addBean(this.executor);
            return;
        }
        this.executor = executor;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public ByteBufferPool getBufferPool() {
        return this.bufferPool;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public Executor getExecutor() {
        return this.executor;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public DecoratedObjectFactory getObjectFactory() {
        return this.objectFactory;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public SslContextFactory getSslContextFactory() {
        return this.sslContextFactory;
    }

    public void setSslContextFactory(SslContextFactory sslContextFactory) {
        this.sslContextFactory = sslContextFactory;
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
}
