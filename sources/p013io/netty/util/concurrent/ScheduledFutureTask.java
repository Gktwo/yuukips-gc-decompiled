package p013io.netty.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import p013io.netty.util.internal.DefaultPriorityQueue;
import p013io.netty.util.internal.PriorityQueueNode;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.concurrent.ScheduledFutureTask */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/ScheduledFutureTask.class */
public final class ScheduledFutureTask<V> extends PromiseTask<V> implements ScheduledFuture<V>, PriorityQueueNode {

    /* renamed from: id */
    private long f999id;
    private long deadlineNanos;
    private final long periodNanos;
    private int queueIndex;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ScheduledFutureTask.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public ScheduledFutureTask(AbstractScheduledEventExecutor executor, Runnable runnable, long nanoTime) {
        super(executor, runnable);
        this.queueIndex = -1;
        this.deadlineNanos = nanoTime;
        this.periodNanos = 0;
    }

    /* access modifiers changed from: package-private */
    public ScheduledFutureTask(AbstractScheduledEventExecutor executor, Runnable runnable, long nanoTime, long period) {
        super(executor, runnable);
        this.queueIndex = -1;
        this.deadlineNanos = nanoTime;
        this.periodNanos = validatePeriod(period);
    }

    /* access modifiers changed from: package-private */
    public ScheduledFutureTask(AbstractScheduledEventExecutor executor, Callable<V> callable, long nanoTime, long period) {
        super(executor, callable);
        this.queueIndex = -1;
        this.deadlineNanos = nanoTime;
        this.periodNanos = validatePeriod(period);
    }

    /* access modifiers changed from: package-private */
    public ScheduledFutureTask(AbstractScheduledEventExecutor executor, Callable<V> callable, long nanoTime) {
        super(executor, callable);
        this.queueIndex = -1;
        this.deadlineNanos = nanoTime;
        this.periodNanos = 0;
    }

    private static long validatePeriod(long period) {
        if (period != 0) {
            return period;
        }
        throw new IllegalArgumentException("period: 0 (expected: != 0)");
    }

    /* access modifiers changed from: package-private */
    public ScheduledFutureTask<V> setId(long id) {
        if (this.f999id == 0) {
            this.f999id = id;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.DefaultPromise
    public EventExecutor executor() {
        return executor();
    }

    public long deadlineNanos() {
        return this.deadlineNanos;
    }

    /* access modifiers changed from: package-private */
    public void setConsumed() {
        if (this.periodNanos != 0) {
            return;
        }
        if ($assertionsDisabled || scheduledExecutor().getCurrentTimeNanos() >= this.deadlineNanos) {
            this.deadlineNanos = 0;
            return;
        }
        throw new AssertionError();
    }

    public long delayNanos() {
        return delayNanos(scheduledExecutor().getCurrentTimeNanos());
    }

    /* access modifiers changed from: package-private */
    public static long deadlineToDelayNanos(long currentTimeNanos, long deadlineNanos) {
        if (deadlineNanos == 0) {
            return 0;
        }
        return Math.max(0L, deadlineNanos - currentTimeNanos);
    }

    public long delayNanos(long currentTimeNanos) {
        return deadlineToDelayNanos(currentTimeNanos, this.deadlineNanos);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayNanos(), TimeUnit.NANOSECONDS);
    }

    public int compareTo(Delayed o) {
        if (this == o) {
            return 0;
        }
        ScheduledFutureTask<?> that = (ScheduledFutureTask) o;
        long d = deadlineNanos() - that.deadlineNanos();
        if (d < 0) {
            return -1;
        }
        if (d > 0) {
            return 1;
        }
        if (this.f999id < that.f999id) {
            return -1;
        }
        if ($assertionsDisabled || this.f999id != that.f999id) {
            return 1;
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.util.concurrent.PromiseTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        if ($assertionsDisabled || executor().inEventLoop()) {
            try {
                if (delayNanos() <= 0) {
                    if (this.periodNanos == 0) {
                        if (setUncancellableInternal()) {
                            setSuccessInternal(runTask());
                        }
                    } else if (!isCancelled()) {
                        runTask();
                        if (!executor().isShutdown()) {
                            if (this.periodNanos > 0) {
                                this.deadlineNanos += this.periodNanos;
                            } else {
                                this.deadlineNanos = scheduledExecutor().getCurrentTimeNanos() - this.periodNanos;
                            }
                            if (!isCancelled()) {
                                scheduledExecutor().scheduledTaskQueue().add(this);
                            }
                        }
                    }
                } else if (isCancelled()) {
                    scheduledExecutor().scheduledTaskQueue().removeTyped(this);
                } else {
                    scheduledExecutor().scheduleFromEventLoop(this);
                }
            } catch (Throwable cause) {
                setFailureInternal(cause);
            }
        } else {
            throw new AssertionError();
        }
    }

    private AbstractScheduledEventExecutor scheduledExecutor() {
        return (AbstractScheduledEventExecutor) executor();
    }

    @Override // p013io.netty.util.concurrent.PromiseTask, p013io.netty.util.concurrent.DefaultPromise, p013io.netty.util.concurrent.Future, java.util.concurrent.Future
    public boolean cancel(boolean mayInterruptIfRunning) {
        boolean canceled = cancel(mayInterruptIfRunning);
        if (canceled) {
            scheduledExecutor().removeScheduled(this);
        }
        return canceled;
    }

    /* access modifiers changed from: package-private */
    public boolean cancelWithoutRemove(boolean mayInterruptIfRunning) {
        return cancel(mayInterruptIfRunning);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.PromiseTask, p013io.netty.util.concurrent.DefaultPromise
    public StringBuilder toStringBuilder() {
        StringBuilder buf = toStringBuilder();
        buf.setCharAt(buf.length() - 1, ',');
        return buf.append(" deadline: ").append(this.deadlineNanos).append(", period: ").append(this.periodNanos).append(')');
    }

    @Override // p013io.netty.util.internal.PriorityQueueNode
    public int priorityQueueIndex(DefaultPriorityQueue<?> queue) {
        return this.queueIndex;
    }

    @Override // p013io.netty.util.internal.PriorityQueueNode
    public void priorityQueueIndex(DefaultPriorityQueue<?> queue, int i) {
        this.queueIndex = i;
    }
}
