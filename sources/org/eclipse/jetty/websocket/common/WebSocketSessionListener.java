package org.eclipse.jetty.websocket.common;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/WebSocketSessionListener.class */
public interface WebSocketSessionListener {
    default void onSessionCreated(WebSocketSession session) {
    }

    default void onSessionOpened(WebSocketSession session) {
    }

    default void onSessionClosed(WebSocketSession session) {
    }
}
