package org.eclipse.jetty.websocket.common;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.websocket.api.SuspendToken;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.api.extensions.OutgoingFrames;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/LogicalConnection.class */
public interface LogicalConnection extends OutgoingFrames, SuspendToken {
    boolean canReadWebSocketFrames();

    boolean canWriteWebSocketFrames();

    void close(Throwable th);

    void close(CloseInfo closeInfo, Callback callback);

    void disconnect();

    ByteBufferPool getBufferPool();

    Executor getExecutor();

    String getId();

    long getIdleTimeout();

    InetSocketAddress getLocalAddress();

    long getMaxIdleTimeout();

    void setMaxIdleTimeout(long j);

    WebSocketPolicy getPolicy();

    InetSocketAddress getRemoteAddress();

    boolean isOpen();

    boolean isReading();

    boolean opened();

    boolean opening();

    void remoteClose(CloseInfo closeInfo);

    void setNextIncomingFrames(IncomingFrames incomingFrames);

    void setSession(WebSocketSession webSocketSession);

    SuspendToken suspend();

    String toStateString();
}
