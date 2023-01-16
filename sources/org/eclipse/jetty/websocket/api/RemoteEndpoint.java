package org.eclipse.jetty.websocket.api;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.concurrent.Future;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/RemoteEndpoint.class */
public interface RemoteEndpoint {
    void sendBytes(ByteBuffer byteBuffer) throws IOException;

    Future<Void> sendBytesByFuture(ByteBuffer byteBuffer);

    void sendBytes(ByteBuffer byteBuffer, WriteCallback writeCallback);

    void sendPartialBytes(ByteBuffer byteBuffer, boolean z) throws IOException;

    void sendPartialString(String str, boolean z) throws IOException;

    void sendPing(ByteBuffer byteBuffer) throws IOException;

    void sendPong(ByteBuffer byteBuffer) throws IOException;

    void sendString(String str) throws IOException;

    Future<Void> sendStringByFuture(String str);

    void sendString(String str, WriteCallback writeCallback);

    BatchMode getBatchMode();

    void setBatchMode(BatchMode batchMode);

    int getMaxOutgoingFrames();

    void setMaxOutgoingFrames(int i);

    InetSocketAddress getInetSocketAddress();

    void flush() throws IOException;
}
