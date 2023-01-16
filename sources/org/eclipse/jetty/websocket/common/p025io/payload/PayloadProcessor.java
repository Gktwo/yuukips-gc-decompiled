package org.eclipse.jetty.websocket.common.p025io.payload;

import java.nio.ByteBuffer;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/* renamed from: org.eclipse.jetty.websocket.common.io.payload.PayloadProcessor */
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/io/payload/PayloadProcessor.class */
public interface PayloadProcessor {
    void process(ByteBuffer byteBuffer);

    void reset(Frame frame);
}
