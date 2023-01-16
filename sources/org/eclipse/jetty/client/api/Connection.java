package org.eclipse.jetty.client.api;

import java.io.Closeable;
import org.eclipse.jetty.client.api.Response;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/api/Connection.class */
public interface Connection extends Closeable {
    void send(Request request, Response.CompleteListener completeListener);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean isClosed();
}
