package kcp.highway.threadPool.order.waiteStrategy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/order/waiteStrategy/SleepingWaitConditionStrategy.class */
public final class SleepingWaitConditionStrategy implements WaitConditionStrategy {
    protected final Logger log;
    private static final int DEFAULT_RETRIES = 200;
    private final int retries;

    public SleepingWaitConditionStrategy() {
        this(200);
    }

    public SleepingWaitConditionStrategy(int retries) {
        this.log = LoggerFactory.getLogger(getClass());
        this.retries = retries;
    }

    @Override // kcp.highway.threadPool.order.waiteStrategy.WaitConditionStrategy
    public <T> T waitFor(WaitCondition<T> waitCondition, long timeOut, TimeUnit unit) {
        T task;
        int counter = this.retries;
        long endTime = System.nanoTime() + unit.toNanos(timeOut);
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
        if (counter > 100) {
            counter--;
        } else if (counter > 0) {
            counter--;
            Thread.yield();
        } else {
            LockSupport.parkNanos(1);
        }
        return counter;
    }
}
