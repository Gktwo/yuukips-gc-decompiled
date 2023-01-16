package org.eclipse.jetty.websocket.common.message;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/message/MessageAppender.class */
public interface MessageAppender {
    void appendFrame(ByteBuffer byteBuffer, boolean z) throws IOException;

    void messageComplete();
}
