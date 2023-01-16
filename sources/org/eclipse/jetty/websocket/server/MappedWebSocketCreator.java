package org.eclipse.jetty.websocket.server;

import org.eclipse.jetty.websocket.server.pathmap.PathSpec;
import org.eclipse.jetty.websocket.servlet.WebSocketCreator;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/MappedWebSocketCreator.class */
public interface MappedWebSocketCreator {
    void addMapping(String str, WebSocketCreator webSocketCreator);

    @Deprecated
    void addMapping(PathSpec pathSpec, WebSocketCreator webSocketCreator);

    void addMapping(org.eclipse.jetty.http.pathmap.PathSpec pathSpec, WebSocketCreator webSocketCreator);

    WebSocketCreator getMapping(String str);

    boolean removeMapping(String str);
}
