package p001ch.qos.logback.core.net.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;

/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.net.server.RemoteReceiverServerRunner */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/RemoteReceiverServerRunner.class */
public class RemoteReceiverServerRunner extends ConcurrentServerRunner<RemoteReceiverClient> {
    private final int clientQueueSize;

    public RemoteReceiverServerRunner(ServerListener<RemoteReceiverClient> listener, Executor executor, int clientQueueSize) {
        super(listener, executor);
        this.clientQueueSize = clientQueueSize;
    }

    /* access modifiers changed from: protected */
    public boolean configureClient(RemoteReceiverClient client) {
        client.setContext(getContext());
        client.setQueue(new ArrayBlockingQueue(this.clientQueueSize));
        return true;
    }
}
