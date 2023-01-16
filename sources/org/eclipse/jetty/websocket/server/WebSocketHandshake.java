package org.eclipse.jetty.websocket.server;

import java.io.IOException;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeRequest;
import org.eclipse.jetty.websocket.servlet.ServletUpgradeResponse;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/WebSocketHandshake.class */
public interface WebSocketHandshake {
    void doHandshakeResponse(ServletUpgradeRequest servletUpgradeRequest, ServletUpgradeResponse servletUpgradeResponse) throws IOException;
}
