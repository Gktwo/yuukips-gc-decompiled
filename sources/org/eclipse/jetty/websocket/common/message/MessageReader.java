package org.eclipse.jetty.websocket.common.message;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.eclipse.jetty.websocket.api.Session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/MessageReader.class */
public class MessageReader extends InputStreamReader implements MessageAppender {
    private final MessageInputStream stream;

    public MessageReader(Session session) {
        this(new MessageInputStream(session));
    }

    public MessageReader(MessageInputStream stream) {
        super(stream, StandardCharsets.UTF_8);
        this.stream = stream;
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void appendFrame(ByteBuffer payload, boolean isLast) throws IOException {
        this.stream.appendFrame(payload, isLast);
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void messageComplete() {
        this.stream.messageComplete();
    }

    public void handlerComplete() {
        this.stream.handlerComplete();
    }
}
