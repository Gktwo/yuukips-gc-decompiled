package p001ch.qos.logback.classic.net.server;

import java.util.concurrent.Executor;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.net.server.ConcurrentServerRunner;
import p001ch.qos.logback.core.net.server.ServerListener;

/* renamed from: ch.qos.logback.classic.net.server.RemoteAppenderServerRunner */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/server/RemoteAppenderServerRunner.class */
class RemoteAppenderServerRunner extends ConcurrentServerRunner<RemoteAppenderClient> {
    public RemoteAppenderServerRunner(ServerListener<RemoteAppenderClient> listener, Executor executor) {
        super(listener, executor);
    }

    /* access modifiers changed from: protected */
    public boolean configureClient(RemoteAppenderClient client) {
        client.setLoggerContext((LoggerContext) getContext());
        return true;
    }
}
