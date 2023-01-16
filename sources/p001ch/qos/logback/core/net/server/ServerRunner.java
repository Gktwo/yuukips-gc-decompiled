package p001ch.qos.logback.core.net.server;

import java.io.IOException;
import p001ch.qos.logback.core.net.server.Client;
import p001ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.core.net.server.ServerRunner */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/ServerRunner.class */
public interface ServerRunner<T extends Client> extends ContextAware, Runnable {
    boolean isRunning();

    void stop() throws IOException;

    void accept(ClientVisitor<T> clientVisitor);
}
