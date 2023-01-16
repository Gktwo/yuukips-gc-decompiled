package org.eclipse.jetty.websocket.api;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketPingPongListener.class */
public interface WebSocketPingPongListener extends WebSocketConnectionListener {
    void onWebSocketPing(ByteBuffer byteBuffer);

    void onWebSocketPong(ByteBuffer byteBuffer);
}
