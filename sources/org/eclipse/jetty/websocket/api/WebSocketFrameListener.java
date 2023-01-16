package org.eclipse.jetty.websocket.api;

import org.eclipse.jetty.websocket.api.extensions.Frame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/WebSocketFrameListener.class */
public interface WebSocketFrameListener extends WebSocketConnectionListener {
    void onWebSocketFrame(Frame frame);
}
