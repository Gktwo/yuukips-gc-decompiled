package org.eclipse.jetty.websocket.common.scopes;

import java.util.Collection;
import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.DecoratedObjectFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.common.WebSocketSessionListener;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/scopes/DelegatedContainerScope.class */
public class DelegatedContainerScope implements WebSocketContainerScope {
    private final WebSocketPolicy policy;
    private final WebSocketContainerScope delegate;

    public DelegatedContainerScope(WebSocketPolicy policy, WebSocketContainerScope parentScope) {
        this.policy = policy;
        this.delegate = parentScope;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public ByteBufferPool getBufferPool() {
        return this.delegate.getBufferPool();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public Executor getExecutor() {
        return this.delegate.getExecutor();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public DecoratedObjectFactory getObjectFactory() {
        return this.delegate.getObjectFactory();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public WebSocketPolicy getPolicy() {
        return this.policy;
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public SslContextFactory getSslContextFactory() {
        return this.delegate.getSslContextFactory();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public boolean isRunning() {
        return this.delegate.isRunning();
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public void addSessionListener(WebSocketSessionListener listener) {
        this.delegate.addSessionListener(listener);
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public void removeSessionListener(WebSocketSessionListener listener) {
        this.delegate.removeSessionListener(listener);
    }

    @Override // org.eclipse.jetty.websocket.common.scopes.WebSocketContainerScope
    public Collection<WebSocketSessionListener> getSessionListeners() {
        return this.delegate.getSessionListeners();
    }
}
