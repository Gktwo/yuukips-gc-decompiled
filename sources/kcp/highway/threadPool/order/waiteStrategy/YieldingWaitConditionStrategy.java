package kcp.highway.threadPool.order.waiteStrategy;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/order/waiteStrategy/YieldingWaitConditionStrategy.class */
public final class YieldingWaitConditionStrategy implements WaitConditionStrategy {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private static final int SPIN_TRIES = 1000;

    @Override // kcp.highway.threadPool.order.waiteStrategy.WaitConditionStrategy
    public <T> T waitFor(WaitCondition<T> waitCondition, long timeOut, TimeUnit unit) {
        T task;
        long endTime = System.nanoTime() + unit.toNanos(timeOut);
        int counter = 1000;
        while (true) {
            task = waitCondition.getAttach();
            if (task != null || System.nanoTime() >= endTime) {
                break;
            }
            counter = applyWaitMethod(counter);
        }
        return task;
    }

    @Override // kcp.highway.threadPool.order.waiteStrategy.WaitConditionStrategy
    public void signalAllWhenBlocking() {
    }

    private int applyWaitMethod(int counter) {
        if (0 == counter) {
            Thread.yield();
        } else {
            counter--;
        }
        return counter;
    }
}
