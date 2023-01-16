package org.eclipse.jetty.websocket.common.scopes;

import org.eclipse.jetty.websocket.common.WebSocketSession;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/scopes/WebSocketSessionScope.class */
public interface WebSocketSessionScope {
    WebSocketSession getWebSocketSession();

    WebSocketContainerScope getContainerScope();
}
