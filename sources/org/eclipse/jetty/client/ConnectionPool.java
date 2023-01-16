package org.eclipse.jetty.client;

import java.io.Closeable;
import java.util.concurrent.CompletableFuture;
import org.eclipse.jetty.client.api.Connection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/ConnectionPool.class */
public interface ConnectionPool extends Closeable {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ConnectionPool$Factory.class */
    public interface Factory {
        ConnectionPool newConnectionPool(HttpDestination httpDestination);
    }

    boolean isActive(Connection connection);

    boolean isEmpty();

    boolean isClosed();

    Connection acquire();

    boolean release(Connection connection);

    boolean remove(Connection connection);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    default CompletableFuture<Void> preCreateConnections(int connectionCount) {
        return CompletableFuture.completedFuture(null);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/ConnectionPool$Multiplexable.class */
    public interface Multiplexable {
        int getMaxMultiplex();

        @Deprecated
        default void setMaxMultiplex(int maxMultiplex) {
        }
    }
}
