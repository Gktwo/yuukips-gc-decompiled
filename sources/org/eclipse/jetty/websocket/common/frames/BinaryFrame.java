package org.eclipse.jetty.websocket.common.frames;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/BinaryFrame.class */
public class BinaryFrame extends DataFrame {
    public BinaryFrame() {
        super((byte) 2);
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public BinaryFrame setPayload(ByteBuffer buf) {
        setPayload(buf);
        return this;
    }

    public BinaryFrame setPayload(byte[] buf) {
        setPayload(ByteBuffer.wrap(buf));
        return this;
    }

    public BinaryFrame setPayload(String payload) {
        setPayload(StringUtil.getUtf8Bytes(payload));
        return this;
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame, org.eclipse.jetty.websocket.api.extensions.Frame
    public Frame.Type getType() {
        if (getOpCode() == 0) {
            return Frame.Type.CONTINUATION;
        }
        return Frame.Type.BINARY;
    }
}
