package org.eclipse.jetty.websocket.common.frames;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/PongFrame.class */
public class PongFrame extends ControlFrame {
    public PongFrame() {
        super((byte) 10);
    }

    public PongFrame setPayload(byte[] bytes) {
        setPayload(ByteBuffer.wrap(bytes));
        return this;
    }

    public PongFrame setPayload(String payload) {
        setPayload(StringUtil.getUtf8Bytes(payload));
        return this;
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame, org.eclipse.jetty.websocket.api.extensions.Frame
    public Frame.Type getType() {
        return Frame.Type.PONG;
    }
}
