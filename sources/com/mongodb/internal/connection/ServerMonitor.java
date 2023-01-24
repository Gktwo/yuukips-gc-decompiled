package com.mongodb.internal.connection;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ServerMonitor.class */
interface ServerMonitor {
    void start();

    void connect();

    void close();

    void cancelCurrentCheck();
}
