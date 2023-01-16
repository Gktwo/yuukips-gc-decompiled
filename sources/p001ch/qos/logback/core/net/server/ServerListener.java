package p001ch.qos.logback.core.net.server;

import java.io.Closeable;
import java.io.IOException;
import p001ch.qos.logback.core.net.server.Client;

/* renamed from: ch.qos.logback.core.net.server.ServerListener */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/ServerListener.class */
public interface ServerListener<T extends Client> extends Closeable {
    T acceptClient() throws IOException, InterruptedException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
