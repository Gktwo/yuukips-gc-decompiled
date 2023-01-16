package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketListener.class */
public interface WebSocketListener extends WebSocketConnectionListener {
    void onWebSocketBinary(byte[] bArr, int i, int i2);

    void onWebSocketText(String str);
}
