package org.eclipse.jetty.websocket.common;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Utf8Appendable;
import org.eclipse.jetty.util.Utf8StringBuilder;
import org.eclipse.jetty.websocket.api.BadPayloadException;
import org.eclipse.jetty.websocket.api.ProtocolException;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.frames.CloseFrame;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/CloseInfo.class */
public class CloseInfo {
    private int statusCode;
    private byte[] reasonBytes;

    public CloseInfo() {
        this(1005, (String) null);
    }

    public CloseInfo(ByteBuffer payload, boolean validate) {
        this.statusCode = 0;
        this.statusCode = 1005;
        if (payload != null && payload.remaining() != 0) {
            ByteBuffer data = payload.slice();
            if (data.remaining() == 1 && validate) {
                throw new ProtocolException("Invalid 1 byte payload");
            } else if (data.remaining() >= 2) {
                this.statusCode = 0;
                this.statusCode |= (data.get() & 255) << 8;
                this.statusCode |= data.get() & 255;
                if (validate) {
                    assertValidStatusCode(this.statusCode);
                }
                if (data.remaining() > 0) {
                    int len = Math.min(data.remaining(), 123);
                    this.reasonBytes = new byte[len];
                    data.get(this.reasonBytes, 0, len);
                    if (validate) {
                        try {
                            new Utf8StringBuilder().append(this.reasonBytes, 0, this.reasonBytes.length);
                        } catch (Utf8Appendable.NotUtf8Exception e) {
                            throw new BadPayloadException("Invalid Close Reason", e);
                        }
                    }
                }
            }
        }
    }

    public CloseInfo(Frame frame) {
        this(frame.getPayload(), false);
    }

    public CloseInfo(Frame frame, boolean validate) {
        this(frame.getPayload(), validate);
    }

    public CloseInfo(int statusCode) {
        this(statusCode, (String) null);
    }

    public CloseInfo(int statusCode, String reason) {
        this.statusCode = 0;
        this.statusCode = statusCode;
        if (reason != null) {
            byte[] utf8Bytes = reason.getBytes(StandardCharsets.UTF_8);
            if (utf8Bytes.length > 123) {
                this.reasonBytes = new byte[123];
                System.arraycopy(utf8Bytes, 0, this.reasonBytes, 0, 123);
                return;
            }
            this.reasonBytes = utf8Bytes;
        }
    }

    private void assertValidStatusCode(int statusCode) {
        if (statusCode <= 999 || statusCode >= 5000) {
            throw new ProtocolException("Out of range close status code: " + statusCode);
        } else if (statusCode == 1006 || statusCode == 1005 || statusCode == 1015) {
            throw new ProtocolException("Frame forbidden close status code: " + statusCode);
        } else if (statusCode >= 1000 && statusCode <= 2999 && !StatusCode.isTransmittable(statusCode)) {
            throw new ProtocolException("RFC6455 and IANA Undefined close status code: " + statusCode);
        }
    }

    private ByteBuffer asByteBuffer() {
        if (this.statusCode == 1006 || this.statusCode == 1005 || this.statusCode == -1) {
            return null;
        }
        int len = 2;
        boolean hasReason = this.reasonBytes != null && this.reasonBytes.length > 0;
        if (hasReason) {
            len = 2 + this.reasonBytes.length;
        }
        ByteBuffer buf = BufferUtil.allocate(len);
        BufferUtil.flipToFill(buf);
        buf.put((byte) ((this.statusCode >>> 8) & 255));
        buf.put((byte) ((this.statusCode >>> 0) & 255));
        if (hasReason) {
            buf.put(this.reasonBytes, 0, this.reasonBytes.length);
        }
        BufferUtil.flipToFlush(buf, 0);
        return buf;
    }

    public CloseFrame asFrame() {
        CloseFrame frame = new CloseFrame();
        frame.setFin(true);
        if (!(this.statusCode == 1006 || this.statusCode == 1005 || this.statusCode == 1015)) {
            assertValidStatusCode(this.statusCode);
            frame.setPayload(asByteBuffer());
        }
        return frame;
    }

    public String getReason() {
        if (this.reasonBytes == null) {
            return null;
        }
        return new String(this.reasonBytes, StandardCharsets.UTF_8);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean isHarsh() {
        return (this.statusCode == 1000 || this.statusCode == 1005) ? false : true;
    }

    public boolean isAbnormal() {
        return this.statusCode != 1000;
    }

    public String toString() {
        return String.format("CloseInfo[code=%d,reason=%s]", Integer.valueOf(this.statusCode), getReason());
    }
}
