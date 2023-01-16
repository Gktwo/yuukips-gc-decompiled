package kcp.highway.threadPool.order.waiteStrategy;

import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/order/waiteStrategy/WaitConditionStrategy.class */
public interface WaitConditionStrategy {
    <T> T waitFor(WaitCondition<T> waitCondition, long j, TimeUnit timeUnit) throws InterruptedException;

    void signalAllWhenBlocking();
}
