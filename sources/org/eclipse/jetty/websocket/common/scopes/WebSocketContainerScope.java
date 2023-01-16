package org.eclipse.jetty.websocket.common.scopes;

import java.util.Collection;
import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.DecoratedObjectFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.common.WebSocketSessionListener;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/scopes/WebSocketContainerScope.class */
public interface WebSocketContainerScope {
    ByteBufferPool getBufferPool();

    Executor getExecutor();

    DecoratedObjectFactory getObjectFactory();

    WebSocketPolicy getPolicy();

    SslContextFactory getSslContextFactory();

    boolean isRunning();

    void addSessionListener(WebSocketSessionListener webSocketSessionListener);

    void removeSessionListener(WebSocketSessionListener webSocketSessionListener);

    Collection<WebSocketSessionListener> getSessionListeners();

    default ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }
}
