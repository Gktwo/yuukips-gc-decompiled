package org.eclipse.jetty.websocket.common.message;

import java.io.IOException;
import java.nio.ByteBuffer;
import org.eclipse.jetty.util.Utf8StringBuilder;
import org.eclipse.jetty.websocket.common.events.EventDriver;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/SimpleTextMessage.class */
public class SimpleTextMessage implements MessageAppender {
    private final EventDriver onEvent;
    private int size;
    protected final Utf8StringBuilder utf = new Utf8StringBuilder(1024);
    protected boolean finished = false;

    public SimpleTextMessage(EventDriver onEvent) {
        this.size = 0;
        this.onEvent = onEvent;
        this.size = 0;
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void appendFrame(ByteBuffer payload, boolean isLast) throws IOException {
        if (this.finished) {
            throw new IOException("Cannot append to finished buffer");
        } else if (payload != null) {
            this.onEvent.getPolicy().assertValidTextMessageSize(this.size + payload.remaining());
            this.size += payload.remaining();
            this.utf.append(payload);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void messageComplete() {
        this.finished = true;
        this.onEvent.onTextMessage(this.utf.toString());
    }
}
