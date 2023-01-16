package p001ch.qos.logback.core.net.server;

import java.io.Closeable;

/* renamed from: ch.qos.logback.core.net.server.Client */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/Client.class */
public interface Client extends Runnable, Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
