package kcp.highway.threadPool.order.waiteStrategy;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/order/waiteStrategy/BusySpinWaitConditionStrategy.class */
public final class BusySpinWaitConditionStrategy implements WaitConditionStrategy {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Override // kcp.highway.threadPool.order.waiteStrategy.WaitConditionStrategy
    public <T> T waitFor(WaitCondition<T> waitCondition, long timeOut, TimeUnit unit) {
        T task;
        long endTime = System.nanoTime() + unit.toNanos(timeOut);
        do {
            task = waitCondition.getAttach();
            if (task != null) {
                break;
            }
        } while (System.nanoTime() < endTime);
        return task;
    }

    @Override // kcp.highway.threadPool.order.waiteStrategy.WaitConditionStrategy
    public void signalAllWhenBlocking() {
    }
}
