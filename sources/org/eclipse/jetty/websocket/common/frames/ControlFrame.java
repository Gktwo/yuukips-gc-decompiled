package org.eclipse.jetty.websocket.common.frames;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.websocket.api.ProtocolException;
import org.eclipse.jetty.websocket.common.WebSocketFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/frames/ControlFrame.class */
public abstract class ControlFrame extends WebSocketFrame {
    public static final int MAX_CONTROL_PAYLOAD = 125;

    public ControlFrame(byte opcode) {
        super(opcode);
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public void assertValid() {
        if (!isControlFrame()) {
            return;
        }
        if (getPayloadLength() > 125) {
            throw new ProtocolException("Desired payload length [" + getPayloadLength() + "] exceeds maximum control payload length [125]");
        } else if ((this.finRsvOp & 128) == 0) {
            throw new ProtocolException("Cannot have FIN==false on Control frames");
        } else if ((this.finRsvOp & 64) != 0) {
            throw new ProtocolException("Cannot have RSV1==true on Control frames");
        } else if ((this.finRsvOp & 32) != 0) {
            throw new ProtocolException("Cannot have RSV2==true on Control frames");
        } else if ((this.finRsvOp & 16) != 0) {
            throw new ProtocolException("Cannot have RSV3==true on Control frames");
        }
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ControlFrame other = (ControlFrame) obj;
        if (this.data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!this.data.equals(other.data)) {
            return false;
        }
        return this.finRsvOp == other.finRsvOp && Arrays.equals(this.mask, other.mask) && this.masked == other.masked;
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public boolean isControlFrame() {
        return true;
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public boolean isDataFrame() {
        return false;
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame
    public WebSocketFrame setPayload(ByteBuffer buf) {
        if (buf == null || buf.remaining() <= 125) {
            return setPayload(buf);
        }
        throw new ProtocolException("Control Payloads can not exceed 125 bytes in length.");
    }

    @Override // org.eclipse.jetty.websocket.common.WebSocketFrame, org.eclipse.jetty.websocket.api.extensions.Frame
    public ByteBuffer getPayload() {
        if (getPayload() == null) {
            return BufferUtil.EMPTY_BUFFER;
        }
        return getPayload();
    }
}
