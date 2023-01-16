package org.eclipse.jetty.websocket.common.frames;

import java.nio.ByteBuffer;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/TextFrame.class */
public class TextFrame extends DataFrame {
    public TextFrame() {
        super((byte) 1);
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame, org.eclipse.jetty.websocket.api.extensions.Frame
    public Frame.Type getType() {
        if (getOpCode() == 0) {
            return Frame.Type.CONTINUATION;
        }
        return Frame.Type.TEXT;
    }

    public TextFrame setPayload(String str) {
        setPayload(ByteBuffer.wrap(StringUtil.getUtf8Bytes(str)));
        return this;
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public String getPayloadAsUTF8() {
        if (this.data == null) {
            return null;
        }
        return BufferUtil.toUTF8String(this.data);
    }
}
