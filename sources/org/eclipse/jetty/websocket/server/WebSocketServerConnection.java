package org.eclipse.jetty.websocket.server;

import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.common.p025io.AbstractWebSocketConnection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/WebSocketServerConnection.class */
public class WebSocketServerConnection extends AbstractWebSocketConnection implements Connection.UpgradeTo {
    public WebSocketServerConnection(EndPoint endp, Executor executor, Scheduler scheduler, WebSocketPolicy policy, ByteBufferPool bufferPool) {
        super(endp, executor, scheduler, policy, bufferPool);
        if (policy.getIdleTimeout() > 0) {
            endp.setIdleTimeout(policy.getIdleTimeout());
        }
    }
}
