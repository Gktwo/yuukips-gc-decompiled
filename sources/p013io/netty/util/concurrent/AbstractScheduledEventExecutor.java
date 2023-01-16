package p013io.netty.util.concurrent;

import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;
import org.quartz.jobs.NativeJob;
import p013io.netty.util.internal.DefaultPriorityQueue;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PriorityQueue;

/* renamed from: io.netty.util.concurrent.AbstractScheduledEventExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/AbstractScheduledEventExecutor.class */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR;
    private static final long START_TIME;
    static final Runnable WAKEUP_TASK;
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;
    long nextTaskId;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !AbstractScheduledEventExecutor.class.desiredAssertionStatus();
        SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
            public int compare(ScheduledFutureTask<?> o1, ScheduledFutureTask<?> o2) {
                return o1.compareTo((Delayed) o2);
            }
        };
        START_TIME = System.nanoTime();
        WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
            @Override // java.lang.Runnable
            public void run() {
            }
        };
    }

    /* access modifiers changed from: protected */
    public AbstractScheduledEventExecutor() {
    }

    /* access modifiers changed from: protected */
    public AbstractScheduledEventExecutor(EventExecutorGroup parent) {
        super(parent);
    }

    /* access modifiers changed from: protected */
    public long getCurrentTimeNanos() {
        return defaultCurrentTimeNanos();
    }

    @Deprecated
    protected static long nanoTime() {
        return defaultCurrentTimeNanos();
    }

    static long defaultCurrentTimeNanos() {
        return System.nanoTime() - START_TIME;
    }

    static long deadlineNanos(long nanoTime, long delay) {
        long deadlineNanos = nanoTime + delay;
        return deadlineNanos < 0 ? LongCompanionObject.MAX_VALUE : deadlineNanos;
    }

    protected static long deadlineToDelayNanos(long deadlineNanos) {
        return ScheduledFutureTask.deadlineToDelayNanos(defaultCurrentTimeNanos(), deadlineNanos);
    }

    protected static long initialNanoTime() {
        return START_TIME;
    }

    /* access modifiers changed from: package-private */
    public PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    /* access modifiers changed from: protected */
    public void cancelScheduledTasks() {
        if ($assertionsDisabled || inEventLoop()) {
            PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue = this.scheduledTaskQueue;
            if (!isNullOrEmpty(scheduledTaskQueue)) {
                for (ScheduledFutureTask<?> task : (ScheduledFutureTask[]) scheduledTaskQueue.toArray(new ScheduledFutureTask[0])) {
                    task.cancelWithoutRemove(false);
                }
                scheduledTaskQueue.clearIgnoringIndexes();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    protected final Runnable pollScheduledTask() {
        return pollScheduledTask(getCurrentTimeNanos());
    }

    protected final Runnable pollScheduledTask(long nanoTime) {
        if ($assertionsDisabled || inEventLoop()) {
            ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
            if (scheduledTask == null || scheduledTask.deadlineNanos() - nanoTime > 0) {
                return null;
            }
            this.scheduledTaskQueue.remove();
            scheduledTask.setConsumed();
            return scheduledTask;
        }
        throw new AssertionError();
    }

    protected final long nextScheduledTaskNano() {
        ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
        if (scheduledTask != null) {
            return scheduledTask.delayNanos();
        }
        return -1;
    }

    protected final long nextScheduledTaskDeadlineNanos() {
        ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
        if (scheduledTask != null) {
            return scheduledTask.deadlineNanos();
        }
        return -1;
    }

    final ScheduledFutureTask<?> peekScheduledTask() {
        Queue<ScheduledFutureTask<?>> scheduledTaskQueue = this.scheduledTaskQueue;
        if (scheduledTaskQueue != null) {
            return scheduledTaskQueue.peek();
        }
        return null;
    }

    protected final boolean hasScheduledTasks() {
        ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
        return scheduledTask != null && scheduledTask.deadlineNanos() <= getCurrentTimeNanos();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.util.concurrent.TimeUnit, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p013io.netty.util.concurrent.ScheduledFuture<?> schedule(java.lang.Runnable r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            r0 = r12
            java.lang.String r1 = "command"
            java.lang.Object r0 = p013io.netty.util.internal.ObjectUtil.checkNotNull(r0, r1)
            r0 = r15
            java.lang.String r1 = "unit"
            java.lang.Object r0 = p013io.netty.util.internal.ObjectUtil.checkNotNull(r0, r1)
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            r0 = 0
            r13 = r0
        L_0x0017:
            r0 = r11
            r1 = r13
            r2 = r15
            r0.validateScheduled0(r1, r2)
            r0 = r11
            io.netty.util.concurrent.ScheduledFutureTask r1 = new io.netty.util.concurrent.ScheduledFutureTask
            r2 = r1
            r3 = r11
            r4 = r12
            r5 = r11
            long r5 = r5.getCurrentTimeNanos()
            r6 = r15
            r7 = r13
            long r6 = r6.toNanos(r7)
            long r5 = deadlineNanos(r5, r6)
            r2.<init>(r3, r4, r5)
            io.netty.util.concurrent.ScheduledFuture r0 = r0.schedule(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.concurrent.AbstractScheduledEventExecutor.schedule(java.lang.Runnable, long, java.util.concurrent.TimeUnit):io.netty.util.concurrent.ScheduledFuture");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [java.util.concurrent.TimeUnit, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1, types: [long] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <V> p013io.netty.util.concurrent.ScheduledFuture<V> schedule(java.util.concurrent.Callable<V> r12, long r13, java.util.concurrent.TimeUnit r15) {
        /*
            r11 = this;
            r0 = r12
            java.lang.String r1 = "callable"
            java.lang.Object r0 = p013io.netty.util.internal.ObjectUtil.checkNotNull(r0, r1)
            r0 = r15
            java.lang.String r1 = "unit"
            java.lang.Object r0 = p013io.netty.util.internal.ObjectUtil.checkNotNull(r0, r1)
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            r0 = 0
            r13 = r0
        L_0x0017:
            r0 = r11
            r1 = r13
            r2 = r15
            r0.validateScheduled0(r1, r2)
            r0 = r11
            io.netty.util.concurrent.ScheduledFutureTask r1 = new io.netty.util.concurrent.ScheduledFutureTask
            r2 = r1
            r3 = r11
            r4 = r12
            r5 = r11
            long r5 = r5.getCurrentTimeNanos()
            r6 = r15
            r7 = r13
            long r6 = r6.toNanos(r7)
            long r5 = deadlineNanos(r5, r6)
            r2.<init>(r3, r4, r5)
            io.netty.util.concurrent.ScheduledFuture r0 = r0.schedule(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.concurrent.AbstractScheduledEventExecutor.schedule(java.util.concurrent.Callable, long, java.util.concurrent.TimeUnit):io.netty.util.concurrent.ScheduledFuture");
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        ObjectUtil.checkNotNull(command, NativeJob.PROP_COMMAND);
        ObjectUtil.checkNotNull(unit, "unit");
        if (initialDelay < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(initialDelay)));
        } else if (period <= 0) {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(period)));
        } else {
            validateScheduled0(initialDelay, unit);
            validateScheduled0(period, unit);
            return schedule(new ScheduledFutureTask(this, command, deadlineNanos(getCurrentTimeNanos(), unit.toNanos(initialDelay)), unit.toNanos(period)));
        }
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
        ObjectUtil.checkNotNull(command, NativeJob.PROP_COMMAND);
        ObjectUtil.checkNotNull(unit, "unit");
        if (initialDelay < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(initialDelay)));
        } else if (delay <= 0) {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(delay)));
        } else {
            validateScheduled0(initialDelay, unit);
            validateScheduled0(delay, unit);
            return schedule(new ScheduledFutureTask(this, command, deadlineNanos(getCurrentTimeNanos(), unit.toNanos(initialDelay)), -unit.toNanos(delay)));
        }
    }

    private void validateScheduled0(long amount, TimeUnit unit) {
        validateScheduled(amount, unit);
    }

    @Deprecated
    protected void validateScheduled(long amount, TimeUnit unit) {
    }

    /* access modifiers changed from: package-private */
    public final void scheduleFromEventLoop(ScheduledFutureTask<?> task) {
        PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue = scheduledTaskQueue();
        long j = this.nextTaskId + 1;
        this.nextTaskId = j;
        scheduledTaskQueue.add(task.setId(j));
    }

    private <V> ScheduledFuture<V> schedule(ScheduledFutureTask<V> task) {
        if (inEventLoop()) {
            scheduleFromEventLoop(task);
        } else {
            long deadlineNanos = task.deadlineNanos();
            if (beforeScheduledTaskSubmitted(deadlineNanos)) {
                execute(task);
            } else {
                lazyExecute(task);
                if (afterScheduledTaskSubmitted(deadlineNanos)) {
                    execute(WAKEUP_TASK);
                }
            }
        }
        return task;
    }

    /* access modifiers changed from: package-private */
    public final void removeScheduled(ScheduledFutureTask<?> task) {
        if (!$assertionsDisabled && !task.isCancelled()) {
            throw new AssertionError();
        } else if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(task);
        } else {
            lazyExecute(task);
        }
    }

    protected boolean beforeScheduledTaskSubmitted(long deadlineNanos) {
        return true;
    }

    protected boolean afterScheduledTaskSubmitted(long deadlineNanos) {
        return true;
    }
}
