package org.eclipse.jetty.websocket.common.message;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/NullMessage.class */
public class NullMessage implements MessageAppender {
    public static final MessageAppender INSTANCE = new NullMessage();

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void appendFrame(ByteBuffer framePayload, boolean isLast) {
        framePayload.position(framePayload.limit());
    }

    @Override // org.eclipse.jetty.websocket.common.message.MessageAppender
    public void messageComplete() {
    }
}
