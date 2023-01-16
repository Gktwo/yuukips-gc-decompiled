package com.mongodb.internal.connection;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ClusterableServer.class */
public interface ClusterableServer extends Server {

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/ClusterableServer$ConnectionState.class */
    public enum ConnectionState {
        BEFORE_HANDSHAKE,
        AFTER_HANDSHAKE
    }

    void resetToConnecting();

    void invalidate();

    void invalidate(ConnectionState connectionState, Throwable th, int i, int i2);

    void close();

    boolean isClosed();

    void connect();
}
