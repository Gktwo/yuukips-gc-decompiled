package org.eclipse.jetty.server;

import java.io.Closeable;
import java.io.IOException;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/NetworkConnector.class */
public interface NetworkConnector extends Connector, Closeable {
    void open() throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean isOpen();

    String getHost();

    int getPort();

    int getLocalPort();
}
