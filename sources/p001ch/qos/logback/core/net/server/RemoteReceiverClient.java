package p001ch.qos.logback.core.net.server;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import p001ch.qos.logback.core.spi.ContextAware;

/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.net.server.RemoteReceiverClient */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/RemoteReceiverClient.class */
public interface RemoteReceiverClient extends Client, ContextAware {
    void setQueue(BlockingQueue<Serializable> blockingQueue);

    boolean offer(Serializable serializable);
}
