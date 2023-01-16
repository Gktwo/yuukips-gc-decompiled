package org.eclipse.jetty.websocket.api;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketConnectionListener.class */
public interface WebSocketConnectionListener {
    void onWebSocketClose(int i, String str);

    void onWebSocketConnect(Session session);

    void onWebSocketError(Throwable th);
}
