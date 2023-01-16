package org.eclipse.jetty.util.thread;

import java.util.concurrent.BlockingQueue;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/MonitoredQueuedThreadPool.class */
public class MonitoredQueuedThreadPool extends QueuedThreadPool {
    private final CounterStatistic queueStats;
    private final SampleStatistic queueLatencyStats;
    private final SampleStatistic taskLatencyStats;
    private final CounterStatistic threadStats;

    public MonitoredQueuedThreadPool() {
        this(256);
    }

    public MonitoredQueuedThreadPool(int maxThreads) {
        this(maxThreads, maxThreads, 86400000, new BlockingArrayQueue(maxThreads, 256));
    }

    public MonitoredQueuedThreadPool(int maxThreads, int minThreads, int idleTimeOut, BlockingQueue<Runnable> queue) {
        super(maxThreads, minThreads, idleTimeOut, queue);
        this.queueStats = new CounterStatistic();
        this.queueLatencyStats = new SampleStatistic();
        this.taskLatencyStats = new SampleStatistic();
        this.threadStats = new CounterStatistic();
        addBean(this.queueStats);
        addBean(this.queueLatencyStats);
        addBean(this.taskLatencyStats);
        addBean(this.threadStats);
    }

    @Override // org.eclipse.jetty.util.thread.QueuedThreadPool, java.util.concurrent.Executor, org.eclipse.jetty.util.thread.TryExecutor
    public void execute(final Runnable job) {
        this.queueStats.increment();
        final long begin = System.nanoTime();
        execute(new Runnable() { // from class: org.eclipse.jetty.util.thread.MonitoredQueuedThreadPool.1
            @Override // java.lang.Runnable
            public void run() {
                long queueLatency = System.nanoTime() - begin;
                MonitoredQueuedThreadPool.this.queueStats.decrement();
                MonitoredQueuedThreadPool.this.threadStats.increment();
                MonitoredQueuedThreadPool.this.queueLatencyStats.record(queueLatency);
                long start = System.nanoTime();
                try {
                    job.run();
                    long taskLatency = System.nanoTime() - start;
                    MonitoredQueuedThreadPool.this.threadStats.decrement();
                    MonitoredQueuedThreadPool.this.taskLatencyStats.record(taskLatency);
                } catch (Throwable th) {
                    long taskLatency2 = System.nanoTime() - start;
                    MonitoredQueuedThreadPool.this.threadStats.decrement();
                    MonitoredQueuedThreadPool.this.taskLatencyStats.record(taskLatency2);
                    throw th;
                }
            }

            @Override // java.lang.Object
            public String toString() {
                return job.toString();
            }
        });
    }

    @ManagedOperation(value = "resets the statistics", impact = "ACTION")
    public void reset() {
        this.queueStats.reset();
        this.queueLatencyStats.reset();
        this.taskLatencyStats.reset();
        this.threadStats.reset(0);
    }

    @ManagedAttribute("the number of tasks executed")
    public long getTasks() {
        return this.taskLatencyStats.getCount();
    }

    @ManagedAttribute("the maximum number of busy threads")
    public int getMaxBusyThreads() {
        return (int) this.threadStats.getMax();
    }

    @ManagedAttribute("the maximum task queue size")
    public int getMaxQueueSize() {
        return (int) this.queueStats.getMax();
    }

    @ManagedAttribute("the average time a task remains in the queue, in nanoseconds")
    public long getAverageQueueLatency() {
        return (long) this.queueLatencyStats.getMean();
    }

    @ManagedAttribute("the maximum time a task remains in the queue, in nanoseconds")
    public long getMaxQueueLatency() {
        return this.queueLatencyStats.getMax();
    }

    @ManagedAttribute("the average task execution time, in nanoseconds")
    public long getAverageTaskLatency() {
        return (long) this.taskLatencyStats.getMean();
    }

    @ManagedAttribute("the maximum task execution time, in nanoseconds")
    public long getMaxTaskLatency() {
        return this.taskLatencyStats.getMax();
    }
}
