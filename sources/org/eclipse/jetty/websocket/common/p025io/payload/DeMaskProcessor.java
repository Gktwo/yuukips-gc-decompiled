package org.eclipse.jetty.websocket.common.p025io.payload;

import java.nio.ByteBuffer;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* renamed from: org.eclipse.jetty.websocket.common.io.payload.DeMaskProcessor */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/payload/DeMaskProcessor.class */
public class DeMaskProcessor implements PayloadProcessor {
    private byte[] maskBytes;
    private int maskInt;
    private int maskOffset;

    @Override // org.eclipse.jetty.websocket.common.p025io.payload.PayloadProcessor
    public void process(ByteBuffer payload) {
        if (this.maskBytes != null) {
            int maskInt = this.maskInt;
            int start = payload.position();
            int end = payload.limit();
            int offset = this.maskOffset;
            while (true) {
                int remaining = end - start;
                if (remaining <= 0) {
                    this.maskOffset = offset;
                    return;
                } else if (remaining < 4 || (offset & 3) != 0) {
                    payload.put(start, (byte) (payload.get(start) ^ this.maskBytes[offset & 3]));
                    start++;
                    offset++;
                } else {
                    payload.putInt(start, payload.getInt(start) ^ maskInt);
                    start += 4;
                    offset += 4;
                }
            }
        }
    }

    public void reset(byte[] mask) {
        this.maskBytes = mask;
        int maskInt = 0;
        if (mask != null) {
            for (byte maskByte : mask) {
                maskInt = (maskInt << 8) + (maskByte & 255);
            }
        }
        this.maskInt = maskInt;
        this.maskOffset = 0;
    }

    @Override // org.eclipse.jetty.websocket.common.p025io.payload.PayloadProcessor
    public void reset(Frame frame) {
        reset(frame.getMask());
    }
}
