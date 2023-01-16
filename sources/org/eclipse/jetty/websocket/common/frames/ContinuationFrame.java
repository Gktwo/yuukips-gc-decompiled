package org.eclipse.jetty.websocket.common.frames;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/ContinuationFrame.class */
public class ContinuationFrame extends DataFrame {
    public ContinuationFrame() {
        super((byte) 0);
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public ContinuationFrame setPayload(ByteBuffer buf) {
        setPayload(buf);
        return this;
    }

    public ContinuationFrame setPayload(byte[] buf) {
        return setPayload(ByteBuffer.wrap(buf));
    }

    public ContinuationFrame setPayload(String message) {
        return setPayload(StringUtil.getUtf8Bytes(message));
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame, org.eclipse.jetty.websocket.api.extensions.Frame
    public Frame.Type getType() {
        return Frame.Type.CONTINUATION;
    }
}
