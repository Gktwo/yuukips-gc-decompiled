package org.eclipse.jetty.websocket.api;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/Session.class */
public interface Session extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void close(CloseStatus closeStatus);

    void close(int i, String str);

    void disconnect() throws IOException;

    long getIdleTimeout();

    InetSocketAddress getLocalAddress();

    WebSocketPolicy getPolicy();

    String getProtocolVersion();

    RemoteEndpoint getRemote();

    InetSocketAddress getRemoteAddress();

    UpgradeRequest getUpgradeRequest();

    UpgradeResponse getUpgradeResponse();

    boolean isOpen();

    boolean isSecure();

    void setIdleTimeout(long j);

    SuspendToken suspend();
}
