package org.eclipse.jetty.websocket.api;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketPartialListener.class */
public interface WebSocketPartialListener extends WebSocketConnectionListener {
    void onWebSocketPartialBinary(ByteBuffer byteBuffer, boolean z);

    void onWebSocketPartialText(String str, boolean z);
}
