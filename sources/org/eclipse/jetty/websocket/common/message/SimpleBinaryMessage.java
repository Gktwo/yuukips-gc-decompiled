package org.eclipse.jetty.websocket.common.message;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.ByteArrayOutputStream2;
import org.eclipse.jetty.websocket.common.events.EventDriver;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/SimpleBinaryMessage.class */
public class SimpleBinaryMessage implements MessageAppender {
    private static final int BUFFER_SIZE = 65535;
    private final EventDriver onEvent;
    protected ByteArrayOutputStream2 out;
    private int size;
    protected boolean finished = false;

    public SimpleBinaryMessage(EventDriver onEvent) {
        this.onEvent = onEvent;
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void appendFrame(ByteBuffer payload, boolean isLast) throws IOException {
        if (this.finished) {
            throw new IOException("Cannot append to finished buffer");
        } else if (payload != null) {
            this.onEvent.getPolicy().assertValidBinaryMessageSize(this.size + payload.remaining());
            this.size += payload.remaining();
            if (this.out == null) {
                this.out = isLast ? new ByteArrayOutputStream2(this.size) : new ByteArrayOutputStream2(65535);
            }
            BufferUtil.writeTo(payload, this.out);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void messageComplete() {
        byte[] data;
        this.finished = true;
        if (this.out == null) {
            data = new byte[0];
        } else if (this.out.getCount() == this.out.getBuf().length) {
            data = this.out.getBuf();
        } else {
            data = this.out.toByteArray();
        }
        this.onEvent.onBinaryMessage(data);
    }
}
