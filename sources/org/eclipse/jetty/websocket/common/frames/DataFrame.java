package org.eclipse.jetty.websocket.common.frames;

import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.WebSocketFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/DataFrame.class */
public class DataFrame extends WebSocketFrame {
    /* access modifiers changed from: protected */
    public DataFrame(byte opcode) {
        super(opcode);
    }

    public DataFrame(Frame basedOn) {
        this(basedOn, false);
    }

    public DataFrame(Frame basedOn, boolean continuation) {
        super(basedOn.getOpCode());
        copyHeaders(basedOn);
        if (continuation) {
            setOpCode((byte) 0);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public void assertValid() {
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public boolean isControlFrame() {
        return false;
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public boolean isDataFrame() {
        return true;
    }

    public void setIsContinuation() {
        setOpCode((byte) 0);
    }
}
