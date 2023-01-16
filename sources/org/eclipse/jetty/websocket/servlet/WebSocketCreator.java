package org.eclipse.jetty.websocket.servlet;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/servlet/WebSocketCreator.class */
public interface WebSocketCreator {
    Object createWebSocket(ServletUpgradeRequest servletUpgradeRequest, ServletUpgradeResponse servletUpgradeResponse);
}
