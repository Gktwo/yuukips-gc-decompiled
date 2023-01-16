package org.eclipse.jetty.websocket.client.p024io;

import java.util.concurrent.Executor;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.util.thread.Scheduler;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.client.masks.Masker;
import org.eclipse.jetty.websocket.client.masks.RandomMasker;
import org.eclipse.jetty.websocket.common.WebSocketFrame;
import org.eclipse.jetty.websocket.common.p025io.AbstractWebSocketConnection;

/* renamed from: org.eclipse.jetty.websocket.client.io.WebSocketClientConnection */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/io/WebSocketClientConnection.class */
public class WebSocketClientConnection extends AbstractWebSocketConnection {
    private final Masker masker = new RandomMasker();

    public WebSocketClientConnection(EndPoint endp, Executor executor, Scheduler scheduler, WebSocketPolicy websocketPolicy, ByteBufferPool bufferPool) {
        super(endp, executor, scheduler, websocketPolicy, bufferPool);
    }

    @Override // org.eclipse.jetty.websocket.common.p025io.AbstractWebSocketConnection, org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
    public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        if (frame instanceof WebSocketFrame) {
            this.masker.setMask((WebSocketFrame) frame);
        }
        outgoingFrame(frame, callback, batchMode);
    }
}
