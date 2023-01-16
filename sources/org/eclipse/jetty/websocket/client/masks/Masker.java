package org.eclipse.jetty.websocket.client.masks;

import org.eclipse.jetty.websocket.common.WebSocketFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/client/masks/Masker.class */
public interface Masker {
    void setMask(WebSocketFrame webSocketFrame);
}
