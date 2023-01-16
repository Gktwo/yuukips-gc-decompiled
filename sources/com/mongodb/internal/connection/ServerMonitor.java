package com.mongodb.internal.connection;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ServerMonitor.class */
public interface ServerMonitor {
    void start();

    void connect();

    void close();

    void cancelCurrentCheck();
}
