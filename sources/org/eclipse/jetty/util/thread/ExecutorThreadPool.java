package org.eclipse.jetty.util.thread;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import kotlin.jvm.internal.LongCompanionObject;
import org.eclipse.jetty.util.ProcessorUtils;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.thread.ThreadPool;

@ManagedObject("A thread pool")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/ExecutorThreadPool.class */
public class ExecutorThreadPool extends ContainerLifeCycle implements ThreadPool.SizedThreadPool, TryExecutor {
    private final ThreadPoolExecutor _executor;
    private final ThreadPoolBudget _budget;
    private final ThreadGroup _group;
    private String _name;
    private int _minThreads;
    private int _reservedThreads;
    private TryExecutor _tryExecutor;
    private int _priority;
    private boolean _daemon;
    private boolean _detailedDump;

    public ExecutorThreadPool() {
        this(200, 8);
    }

    public ExecutorThreadPool(int maxThreads) {
        this(maxThreads, Math.min(8, maxThreads));
    }

    public ExecutorThreadPool(int maxThreads, int minThreads) {
        this(maxThreads, minThreads, new LinkedBlockingQueue());
    }

    public ExecutorThreadPool(int maxThreads, int minThreads, BlockingQueue<Runnable> queue) {
        this(new ThreadPoolExecutor(maxThreads, maxThreads, 60, TimeUnit.SECONDS, queue), minThreads, -1, null);
    }

    public ExecutorThreadPool(ThreadPoolExecutor executor) {
        this(executor, -1);
    }

    public ExecutorThreadPool(ThreadPoolExecutor executor, int reservedThreads) {
        this(executor, reservedThreads, (ThreadGroup) null);
    }

    public ExecutorThreadPool(ThreadPoolExecutor executor, int reservedThreads, ThreadGroup group) {
        this(executor, Math.min(ProcessorUtils.availableProcessors(), executor.getCorePoolSize()), reservedThreads, group);
    }

    private ExecutorThreadPool(ThreadPoolExecutor executor, int minThreads, int reservedThreads, ThreadGroup group) {
        this._name = "etp" + hashCode();
        this._reservedThreads = -1;
        this._tryExecutor = TryExecutor.NO_TRY;
        this._priority = 5;
        int maxThreads = executor.getMaximumPoolSize();
        if (maxThreads < minThreads) {
            executor.shutdownNow();
            throw new IllegalArgumentException("max threads (" + maxThreads + ") cannot be less than min threads (" + minThreads + ")");
        }
        this._executor = executor;
        this._executor.setThreadFactory(this::newThread);
        this._group = group;
        this._minThreads = minThreads;
        this._reservedThreads = reservedThreads;
        this._budget = new ThreadPoolBudget(this);
    }

    @ManagedAttribute("name of this thread pool")
    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        this._name = name;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    @ManagedAttribute("minimum number of threads in the pool")
    public int getMinThreads() {
        return this._minThreads;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public void setMinThreads(int threads) {
        this._minThreads = threads;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    @ManagedAttribute("maximum number of threads in the pool")
    public int getMaxThreads() {
        return this._executor.getMaximumPoolSize();
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public void setMaxThreads(int threads) {
        if (this._budget != null) {
            this._budget.check(threads);
        }
        this._executor.setCorePoolSize(threads);
        this._executor.setMaximumPoolSize(threads);
    }

    @ManagedAttribute("maximum time a thread may be idle in ms")
    public int getIdleTimeout() {
        return (int) this._executor.getKeepAliveTime(TimeUnit.MILLISECONDS);
    }

    public void setIdleTimeout(int idleTimeout) {
        this._executor.setKeepAliveTime((long) idleTimeout, TimeUnit.MILLISECONDS);
    }

    @ManagedAttribute("the number of reserved threads in the pool")
    public int getReservedThreads() {
        if (isStarted()) {
            return ((ReservedThreadExecutor) getBean((Class<Object>) ReservedThreadExecutor.class)).getCapacity();
        }
        return this._reservedThreads;
    }

    public void setReservedThreads(int reservedThreads) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        this._reservedThreads = reservedThreads;
    }

    public void setThreadsPriority(int priority) {
        this._priority = priority;
    }

    public int getThreadsPriority() {
        return this._priority;
    }

    @ManagedAttribute("whether this thread pool uses daemon threads")
    public boolean isDaemon() {
        return this._daemon;
    }

    public void setDaemon(boolean daemon) {
        this._daemon = daemon;
    }

    @ManagedAttribute("reports additional details in the dump")
    public boolean isDetailedDump() {
        return this._detailedDump;
    }

    public void setDetailedDump(boolean detailedDump) {
        this._detailedDump = detailedDump;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    @ManagedAttribute("number of threads in the pool")
    public int getThreads() {
        return this._executor.getPoolSize();
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    @ManagedAttribute("number of idle threads in the pool")
    public int getIdleThreads() {
        return this._executor.getPoolSize() - this._executor.getActiveCount();
    }

    @Override // java.util.concurrent.Executor, org.eclipse.jetty.util.thread.TryExecutor
    public void execute(Runnable command) {
        this._executor.execute(command);
    }

    @Override // org.eclipse.jetty.util.thread.TryExecutor
    public boolean tryExecute(Runnable task) {
        TryExecutor tryExecutor = this._tryExecutor;
        return tryExecutor != null && tryExecutor.tryExecute(task);
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    @ManagedAttribute(value = "thread pool is low on threads", readonly = true)
    public boolean isLowOnThreads() {
        return getThreads() == getMaxThreads() && this._executor.getQueue().size() >= getIdleThreads();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._executor.isShutdown()) {
            throw new IllegalStateException("This thread pool is not restartable");
        }
        for (int i = 0; i < this._minThreads; i++) {
            this._executor.prestartCoreThread();
        }
        this._tryExecutor = new ReservedThreadExecutor(this, this._reservedThreads);
        addBean(this._tryExecutor);
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        removeBean(this._tryExecutor);
        this._tryExecutor = TryExecutor.NO_TRY;
        this._executor.shutdownNow();
        this._budget.reset();
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public void join() throws InterruptedException {
        this._executor.awaitTermination(LongCompanionObject.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public ThreadPoolBudget getThreadPoolBudget() {
        return this._budget;
    }

    protected Thread newThread(Runnable job) {
        Thread thread = new Thread(this._group, job);
        thread.setDaemon(isDaemon());
        thread.setPriority(getThreadsPriority());
        thread.setName(getName() + "-" + thread.getId());
        return thread;
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        String prefix = getName() + "-";
        List<Dumpable> threads = (List) Thread.getAllStackTraces().entrySet().stream().filter(entry -> {
            return ((Thread) entry.getKey()).getName().startsWith(prefix);
        }).map(entry -> {
            final Thread thread = (Thread) entry.getKey();
            final StackTraceElement[] frames = (StackTraceElement[]) entry.getValue();
            String knownMethod = null;
            int length = frames.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement frame = frames[i];
                if (!"getTask".equals(frame.getMethodName()) || !frame.getClassName().endsWith("ThreadPoolExecutor")) {
                    if (!"reservedWait".equals(frame.getMethodName()) || !frame.getClassName().endsWith("ReservedThread")) {
                        if (!"select".equals(frame.getMethodName()) || !frame.getClassName().endsWith("SelectorProducer")) {
                            if ("accept".equals(frame.getMethodName()) && frame.getClassName().contains("ServerConnector")) {
                                knownMethod = "ACCEPTING ";
                                break;
                            }
                            i++;
                        } else {
                            knownMethod = "SELECTING ";
                            break;
                        }
                    } else {
                        knownMethod = "RESERVED ";
                        break;
                    }
                } else {
                    knownMethod = "IDLE ";
                    break;
                }
            }
            final String known = knownMethod == null ? "" : knownMethod;
            return new Dumpable() { // from class: org.eclipse.jetty.util.thread.ExecutorThreadPool.1
                @Override // org.eclipse.jetty.util.component.Dumpable
                public void dump(Appendable out2, String indent2) throws IOException {
                    StringBuilder b = new StringBuilder();
                    b.append(thread.getId()).append(" ").append(thread.getName()).append(" p=").append(thread.getPriority()).append(" ").append(known).append(thread.getState().toString());
                    if (!ExecutorThreadPool.this.isDetailedDump()) {
                        b.append(" @ ").append(frames.length > 0 ? String.valueOf(frames[0]) : "<no_stack_frames>");
                        Dumpable.dumpObject(out2, b.toString());
                    } else if (known.isEmpty()) {
                        Dumpable.dumpObjects(out2, indent2, b.toString(), frames);
                    } else {
                        Dumpable.dumpObject(out2, b.toString());
                    }
                }

                @Override // org.eclipse.jetty.util.component.Dumpable
                public String dump() {
                    return null;
                }
            };
        }).collect(Collectors.toList());
        List<Runnable> jobs = Collections.emptyList();
        if (isDetailedDump()) {
            jobs = new ArrayList<>(this._executor.getQueue());
        }
        dumpObjects(out, indent, threads, new DumpableCollection("jobs", jobs));
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[%s]@%x{%s,%d<=%d<=%d,i=%d,q=%d,%s}", getClass().getSimpleName(), getName(), Integer.valueOf(hashCode()), getState(), Integer.valueOf(getMinThreads()), Integer.valueOf(getThreads()), Integer.valueOf(getMaxThreads()), Integer.valueOf(getIdleThreads()), Integer.valueOf(this._executor.getQueue().size()), this._tryExecutor);
    }
}
