package org.eclipse.jetty.websocket.common;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.frames.BinaryFrame;
import org.eclipse.jetty.websocket.common.frames.CloseFrame;
import org.eclipse.jetty.websocket.common.frames.ContinuationFrame;
import org.eclipse.jetty.websocket.common.frames.PingFrame;
import org.eclipse.jetty.websocket.common.frames.PongFrame;
import org.eclipse.jetty.websocket.common.frames.TextFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/WebSocketFrame.class */
public abstract class WebSocketFrame implements Frame {
    protected byte finRsvOp;
    protected boolean masked = false;
    protected byte[] mask;
    protected ByteBuffer data;

    public abstract void assertValid();

    public abstract boolean isControlFrame();

    public abstract boolean isDataFrame();

    public static WebSocketFrame copy(Frame original) {
        WebSocketFrame copy;
        switch (original.getOpCode()) {
            case 0:
                copy = new ContinuationFrame();
                break;
            case 1:
                copy = new TextFrame();
                break;
            case 2:
                copy = new BinaryFrame();
                break;
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("Cannot copy frame with opcode " + ((int) original.getOpCode()) + " - " + original);
            case 8:
                copy = new CloseFrame();
                break;
            case 9:
                copy = new PingFrame();
                break;
            case 10:
                copy = new PongFrame();
                break;
        }
        copy.copyHeaders(original);
        ByteBuffer payload = original.getPayload();
        if (payload != null) {
            ByteBuffer payloadCopy = ByteBuffer.allocate(payload.remaining());
            payloadCopy.put(payload.slice()).flip();
            copy.setPayload(payloadCopy);
        }
        return copy;
    }

    /* access modifiers changed from: protected */
    public WebSocketFrame(byte opcode) {
        reset();
        setOpCode(opcode);
    }

    protected void copyHeaders(Frame frame) {
        this.finRsvOp = 0;
        this.finRsvOp = (byte) (this.finRsvOp | (frame.isFin() ? (byte) 128 : 0));
        this.finRsvOp = (byte) (this.finRsvOp | (frame.isRsv1() ? (byte) 64 : 0));
        this.finRsvOp = (byte) (this.finRsvOp | (frame.isRsv2() ? (byte) 32 : 0));
        this.finRsvOp = (byte) (this.finRsvOp | (frame.isRsv3() ? (byte) 16 : 0));
        this.finRsvOp = (byte) (this.finRsvOp | (frame.getOpCode() & 15));
        this.masked = frame.isMasked();
        if (this.masked) {
            this.mask = frame.getMask();
        } else {
            this.mask = null;
        }
    }

    protected void copyHeaders(WebSocketFrame copy) {
        this.finRsvOp = copy.finRsvOp;
        this.masked = copy.masked;
        this.mask = null;
        if (copy.mask != null) {
            this.mask = Arrays.copyOf(copy.mask, copy.mask.length);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WebSocketFrame other = (WebSocketFrame) obj;
        if (this.data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!this.data.equals(other.data)) {
            return false;
        }
        return this.finRsvOp == other.finRsvOp && Arrays.equals(this.mask, other.mask) && this.masked == other.masked;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public byte[] getMask() {
        return this.mask;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public final byte getOpCode() {
        return (byte) (this.finRsvOp & 15);
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public ByteBuffer getPayload() {
        return this.data;
    }

    public String getPayloadAsUTF8() {
        return BufferUtil.toUTF8String(getPayload());
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public int getPayloadLength() {
        if (this.data == null) {
            return 0;
        }
        return this.data.remaining();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public Frame.Type getType() {
        return Frame.Type.from(getOpCode());
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * 1) + (this.data == null ? 0 : this.data.hashCode()))) + this.finRsvOp)) + Arrays.hashCode(this.mask);
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean hasPayload() {
        return this.data != null && this.data.hasRemaining();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isFin() {
        return ((byte) (this.finRsvOp & 128)) != 0;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isLast() {
        return isFin();
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isMasked() {
        return this.masked;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isRsv1() {
        return ((byte) (this.finRsvOp & 64)) != 0;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isRsv2() {
        return ((byte) (this.finRsvOp & 32)) != 0;
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.Frame
    public boolean isRsv3() {
        return ((byte) (this.finRsvOp & 16)) != 0;
    }

    public void reset() {
        this.finRsvOp = Byte.MIN_VALUE;
        this.masked = false;
        this.data = null;
        this.mask = null;
    }

    public WebSocketFrame setFin(boolean fin) {
        this.finRsvOp = (byte) ((this.finRsvOp & Byte.MAX_VALUE) | (fin ? 128 : 0));
        return this;
    }

    public Frame setMask(byte[] maskingKey) {
        this.mask = maskingKey;
        this.masked = this.mask != null;
        return this;
    }

    public Frame setMasked(boolean mask) {
        this.masked = mask;
        return this;
    }

    protected WebSocketFrame setOpCode(byte op) {
        this.finRsvOp = (byte) ((this.finRsvOp & 240) | (op & 15));
        return this;
    }

    public WebSocketFrame setPayload(ByteBuffer buf) {
        this.data = buf;
        return this;
    }

    public WebSocketFrame setRsv1(boolean rsv1) {
        this.finRsvOp = (byte) ((this.finRsvOp & 191) | (rsv1 ? 64 : 0));
        return this;
    }

    public WebSocketFrame setRsv2(boolean rsv2) {
        this.finRsvOp = (byte) ((this.finRsvOp & 223) | (rsv2 ? 32 : 0));
        return this;
    }

    public WebSocketFrame setRsv3(boolean rsv3) {
        this.finRsvOp = (byte) ((this.finRsvOp & 239) | (rsv3 ? 16 : 0));
        return this;
    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(OpCode.name((byte) (this.finRsvOp & 15)));
        b.append('[');
        b.append("len=").append(getPayloadLength());
        b.append(",fin=").append((this.finRsvOp & 128) != 0);
        b.append(",rsv=");
        b.append((this.finRsvOp & 64) != 0 ? '1' : '.');
        b.append((this.finRsvOp & 32) != 0 ? '1' : '.');
        b.append((this.finRsvOp & 16) != 0 ? '1' : '.');
        b.append(",masked=").append(this.masked);
        b.append(']');
        return b.toString();
    }
}
