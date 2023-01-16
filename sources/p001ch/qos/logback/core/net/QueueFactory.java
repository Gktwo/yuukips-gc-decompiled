package p001ch.qos.logback.core.net;

import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: ch.qos.logback.core.net.QueueFactory */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/QueueFactory.class */
public class QueueFactory {
    public <E> LinkedBlockingDeque<E> newLinkedBlockingDeque(int capacity) {
        return new LinkedBlockingDeque<>(capacity < 1 ? 1 : capacity);
    }
}
