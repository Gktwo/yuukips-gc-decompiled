package org.eclipse.jetty.websocket.common.events;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.api.extensions.IncomingFrames;
import org.eclipse.jetty.websocket.common.CloseInfo;
import org.eclipse.jetty.websocket.common.WebSocketSession;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/EventDriver.class */
public interface EventDriver extends IncomingFrames {
    WebSocketPolicy getPolicy();

    WebSocketSession getSession();

    BatchMode getBatchMode();

    void onBinaryFrame(ByteBuffer byteBuffer, boolean z) throws IOException;

    void onBinaryMessage(byte[] bArr);

    void onClose(CloseInfo closeInfo);

    void onConnect();

    void onContinuationFrame(ByteBuffer byteBuffer, boolean z) throws IOException;

    void onError(Throwable th);

    void onFrame(Frame frame);

    void onInputStream(InputStream inputStream) throws IOException;

    void onPing(ByteBuffer byteBuffer);

    void onPong(ByteBuffer byteBuffer);

    void onReader(Reader reader) throws IOException;

    void onTextFrame(ByteBuffer byteBuffer, boolean z) throws IOException;

    void onTextMessage(String str);

    void openSession(WebSocketSession webSocketSession);
}
