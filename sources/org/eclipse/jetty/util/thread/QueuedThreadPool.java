package org.eclipse.jetty.util.thread;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kcp.highway.Kcp;
import org.eclipse.jetty.util.AtomicBiInteger;
import org.eclipse.jetty.util.BlockingArrayQueue;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.ThreadPool;
import p013io.javalin.http.sse.EmitterKt;

@ManagedObject("A thread pool")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/QueuedThreadPool.class */
public class QueuedThreadPool extends ContainerLifeCycle implements ThreadFactory, ThreadPool.SizedThreadPool, Dumpable, TryExecutor {
    private static final Logger LOG = Log.getLogger(QueuedThreadPool.class);
    private static final Runnable NOOP = () -> {
    };
    private final AtomicBiInteger _counts;
    private final AtomicLong _lastShrink;
    private final Set<Thread> _threads;
    private final Object _joinLock;
    private final BlockingQueue<Runnable> _jobs;
    private final ThreadGroup _threadGroup;
    private final ThreadFactory _threadFactory;
    private String _name;
    private int _idleTimeout;
    private int _maxThreads;
    private int _minThreads;
    private int _reservedThreads;
    private TryExecutor _tryExecutor;
    private int _priority;
    private boolean _daemon;
    private boolean _detailedDump;
    private int _lowThreadsThreshold;
    private ThreadPoolBudget _budget;
    private final Runnable _runnable;

    public QueuedThreadPool() {
        this(200);
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads) {
        this(maxThreads, Math.min(8, maxThreads));
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads) {
        this(maxThreads, minThreads, (int) Kcp.IKCP_RTO_MAX);
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads, @Name("queue") BlockingQueue<Runnable> queue) {
        this(maxThreads, minThreads, Kcp.IKCP_RTO_MAX, -1, queue, null);
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads, @Name("idleTimeout") int idleTimeout) {
        this(maxThreads, minThreads, idleTimeout, null);
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads, @Name("idleTimeout") int idleTimeout, @Name("queue") BlockingQueue<Runnable> queue) {
        this(maxThreads, minThreads, idleTimeout, queue, null);
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads, @Name("idleTimeout") int idleTimeout, @Name("queue") BlockingQueue<Runnable> queue, @Name("threadGroup") ThreadGroup threadGroup) {
        this(maxThreads, minThreads, idleTimeout, -1, queue, threadGroup);
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads, @Name("idleTimeout") int idleTimeout, @Name("reservedThreads") int reservedThreads, @Name("queue") BlockingQueue<Runnable> queue, @Name("threadGroup") ThreadGroup threadGroup) {
        this(maxThreads, minThreads, idleTimeout, reservedThreads, queue, threadGroup, null);
    }

    public QueuedThreadPool(@Name("maxThreads") int maxThreads, @Name("minThreads") int minThreads, @Name("idleTimeout") int idleTimeout, @Name("reservedThreads") int reservedThreads, @Name("queue") BlockingQueue<Runnable> queue, @Name("threadGroup") ThreadGroup threadGroup, @Name("threadFactory") ThreadFactory threadFactory) {
        this._counts = new AtomicBiInteger(Integer.MIN_VALUE, 0);
        this._lastShrink = new AtomicLong();
        this._threads = ConcurrentHashMap.newKeySet();
        this._joinLock = new Object();
        this._name = "qtp" + hashCode();
        this._reservedThreads = -1;
        this._tryExecutor = TryExecutor.NO_TRY;
        this._priority = 5;
        this._daemon = false;
        this._detailedDump = false;
        this._lowThreadsThreshold = 1;
        this._runnable = new Runner();
        if (maxThreads < minThreads) {
            throw new IllegalArgumentException("max threads (" + maxThreads + ") less than min threads (" + minThreads + ")");
        }
        setMinThreads(minThreads);
        setMaxThreads(maxThreads);
        setIdleTimeout(idleTimeout);
        setStopTimeout(5000);
        setReservedThreads(reservedThreads);
        if (queue == null) {
            int capacity = Math.max(this._minThreads, 8) * 1024;
            queue = new BlockingArrayQueue(capacity, capacity);
        }
        this._jobs = queue;
        this._threadGroup = threadGroup;
        setThreadPoolBudget(new ThreadPoolBudget(this));
        this._threadFactory = threadFactory == null ? this : threadFactory;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public ThreadPoolBudget getThreadPoolBudget() {
        return this._budget;
    }

    public void setThreadPoolBudget(ThreadPoolBudget budget) {
        if (budget == null || budget.getSizedThreadPool() == this) {
            updateBean(this._budget, budget);
            this._budget = budget;
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        if (this._reservedThreads == 0) {
            this._tryExecutor = NO_TRY;
        } else {
            ReservedThreadExecutor reserved = new ReservedThreadExecutor(this, this._reservedThreads);
            reserved.setIdleTimeout((long) this._idleTimeout, TimeUnit.MILLISECONDS);
            this._tryExecutor = reserved;
        }
        addBean(this._tryExecutor);
        this._lastShrink.set(System.nanoTime());
        doStart();
        this._counts.set(0, 0);
        ensureThreads();
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Stopping {}", this);
        }
        doStop();
        removeBean(this._tryExecutor);
        this._tryExecutor = TryExecutor.NO_TRY;
        int threads = this._counts.getAndSetHi(Integer.MIN_VALUE);
        long timeout = getStopTimeout();
        BlockingQueue<Runnable> jobs = getQueue();
        for (int i = 0; i < threads; i++) {
            jobs.offer(NOOP);
        }
        if (timeout > 0) {
            joinThreads(System.nanoTime() + (TimeUnit.MILLISECONDS.toNanos(timeout) / 2));
        }
        Thread.yield();
        for (Thread thread : this._threads) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Interrupting {}", thread);
            }
            thread.interrupt();
        }
        if (timeout > 0) {
            joinThreads(System.nanoTime() + (TimeUnit.MILLISECONDS.toNanos(timeout) / 2));
            Thread.yield();
            if (LOG.isDebugEnabled()) {
                for (Thread unstopped : this._threads) {
                    StringBuilder dmp = new StringBuilder();
                    for (StackTraceElement element : unstopped.getStackTrace()) {
                        dmp.append(System.lineSeparator()).append("\tat ").append(element);
                    }
                    LOG.warn("Couldn't stop {}{}", unstopped, dmp.toString());
                }
            } else {
                for (Thread unstopped2 : this._threads) {
                    LOG.warn("{} Couldn't stop {}", this, unstopped2);
                }
            }
        }
        while (!this._jobs.isEmpty()) {
            Runnable job = this._jobs.poll();
            if (job instanceof Closeable) {
                try {
                    ((Closeable) job).close();
                } catch (Throwable t) {
                    LOG.warn(t);
                }
            } else if (job != NOOP) {
                LOG.warn("Stopped without executing or closing {}", job);
            }
        }
        if (this._budget != null) {
            this._budget.reset();
        }
        synchronized (this._joinLock) {
            this._joinLock.notifyAll();
        }
    }

    private void joinThreads(long stopByNanos) throws InterruptedException {
        for (Thread thread : this._threads) {
            long canWait = TimeUnit.NANOSECONDS.toMillis(stopByNanos - System.nanoTime());
            if (LOG.isDebugEnabled()) {
                LOG.debug("Waiting for {} for {}", thread, Long.valueOf(canWait));
            }
            if (canWait > 0) {
                thread.join(canWait);
            }
        }
    }

    @ManagedAttribute("maximum time a thread may be idle in ms")
    public int getIdleTimeout() {
        return this._idleTimeout;
    }

    public void setIdleTimeout(int idleTimeout) {
        this._idleTimeout = idleTimeout;
        ReservedThreadExecutor reserved = (ReservedThreadExecutor) getBean((Class<Object>) ReservedThreadExecutor.class);
        if (reserved != null) {
            reserved.setIdleTimeout((long) idleTimeout, TimeUnit.MILLISECONDS);
        }
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    @ManagedAttribute("maximum number of threads in the pool")
    public int getMaxThreads() {
        return this._maxThreads;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public void setMaxThreads(int maxThreads) {
        if (this._budget != null) {
            this._budget.check(maxThreads);
        }
        this._maxThreads = maxThreads;
        if (this._minThreads > this._maxThreads) {
            this._minThreads = this._maxThreads;
        }
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    @ManagedAttribute("minimum number of threads in the pool")
    public int getMinThreads() {
        return this._minThreads;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool.SizedThreadPool
    public void setMinThreads(int minThreads) {
        this._minThreads = minThreads;
        if (this._minThreads > this._maxThreads) {
            this._maxThreads = this._minThreads;
        }
        if (isStarted()) {
            ensureThreads();
        }
    }

    @ManagedAttribute("number of configured reserved threads or -1 for heuristic")
    public int getReservedThreads() {
        return this._reservedThreads;
    }

    public void setReservedThreads(int reservedThreads) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        this._reservedThreads = reservedThreads;
    }

    @ManagedAttribute("name of the thread pool")
    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        }
        this._name = name;
    }

    @ManagedAttribute("priority of threads in the pool")
    public int getThreadsPriority() {
        return this._priority;
    }

    public void setThreadsPriority(int priority) {
        this._priority = priority;
    }

    @ManagedAttribute("thread pool uses daemon threads")
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

    @ManagedAttribute("threshold at which the pool is low on threads")
    public int getLowThreadsThreshold() {
        return this._lowThreadsThreshold;
    }

    public void setLowThreadsThreshold(int lowThreadsThreshold) {
        this._lowThreadsThreshold = lowThreadsThreshold;
    }

    @ManagedAttribute("size of the job queue")
    public int getQueueSize() {
        return Math.max(0, -this._counts.getLo());
    }

    @ManagedAttribute("maximum number (capacity) of reserved threads")
    public int getMaxReservedThreads() {
        TryExecutor tryExecutor = this._tryExecutor;
        if (tryExecutor instanceof ReservedThreadExecutor) {
            return ((ReservedThreadExecutor) tryExecutor).getCapacity();
        }
        return 0;
    }

    @ManagedAttribute("number of available reserved threads")
    public int getAvailableReservedThreads() {
        TryExecutor tryExecutor = this._tryExecutor;
        if (tryExecutor instanceof ReservedThreadExecutor) {
            return ((ReservedThreadExecutor) tryExecutor).getAvailable();
        }
        return 0;
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    @ManagedAttribute("number of threads in the pool")
    public int getThreads() {
        return Math.max(0, this._counts.getHi());
    }

    @ManagedAttribute("number of threads ready to execute transient jobs")
    public int getReadyThreads() {
        return getIdleThreads() + getAvailableReservedThreads();
    }

    @ManagedAttribute("number of threads used by internal components")
    public int getLeasedThreads() {
        return getMaxLeasedThreads() - getMaxReservedThreads();
    }

    @ManagedAttribute("maximum number of threads leased to internal components")
    public int getMaxLeasedThreads() {
        ThreadPoolBudget budget = this._budget;
        if (budget == null) {
            return 0;
        }
        return budget.getLeasedThreads();
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    @ManagedAttribute("number of idle threads but not reserved")
    public int getIdleThreads() {
        return Math.max(0, this._counts.getLo());
    }

    @ManagedAttribute("number of threads executing internal and transient jobs")
    public int getBusyThreads() {
        return getThreads() - getReadyThreads();
    }

    @ManagedAttribute("number of threads executing transient jobs")
    public int getUtilizedThreads() {
        return (getThreads() - getLeasedThreads()) - getReadyThreads();
    }

    @ManagedAttribute("maximum number of threads available to run transient jobs")
    public int getMaxAvailableThreads() {
        return getMaxThreads() - getLeasedThreads();
    }

    @ManagedAttribute("utilization rate of threads executing transient jobs")
    public double getUtilizationRate() {
        return ((double) getUtilizedThreads()) / ((double) getMaxAvailableThreads());
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    @ManagedAttribute(value = "thread pool is low on threads", readonly = true)
    public boolean isLowOnThreads() {
        return ((getMaxThreads() - getThreads()) + getReadyThreads()) - getQueueSize() <= getLowThreadsThreshold();
    }

    @Override // java.util.concurrent.Executor, org.eclipse.jetty.util.thread.TryExecutor
    public void execute(Runnable job) {
        long counts;
        int threads;
        int idle;
        int startThread;
        do {
            counts = this._counts.get();
            threads = AtomicBiInteger.getHi(counts);
            if (threads == Integer.MIN_VALUE) {
                throw new RejectedExecutionException(job.toString());
            }
            idle = AtomicBiInteger.getLo(counts);
            startThread = (idle > 0 || threads >= this._maxThreads) ? 0 : 1;
        } while (!this._counts.compareAndSet(counts, threads + startThread, (idle + startThread) - 1));
        if (!this._jobs.offer(job)) {
            if (addCounts(-startThread, 1 - startThread)) {
                LOG.warn("{} rejected {}", this, job);
            }
            throw new RejectedExecutionException(job.toString());
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("queue {} startThread={}", job, Integer.valueOf(startThread));
        }
        while (true) {
            startThread--;
            if (startThread > 0) {
                startThread();
            } else {
                return;
            }
        }
    }

    @Override // org.eclipse.jetty.util.thread.TryExecutor
    public boolean tryExecute(Runnable task) {
        TryExecutor tryExecutor = this._tryExecutor;
        return tryExecutor != null && tryExecutor.tryExecute(task);
    }

    @Override // org.eclipse.jetty.util.thread.ThreadPool
    public void join() throws InterruptedException {
        synchronized (this._joinLock) {
            while (isRunning()) {
                this._joinLock.wait();
            }
        }
        while (isStopping()) {
            Thread.sleep(1);
        }
    }

    /* access modifiers changed from: private */
    public void ensureThreads() {
        while (true) {
            long counts = this._counts.get();
            int threads = AtomicBiInteger.getHi(counts);
            if (threads != Integer.MIN_VALUE) {
                int idle = AtomicBiInteger.getLo(counts);
                if (threads >= this._minThreads && (idle >= 0 || threads >= this._maxThreads)) {
                    return;
                }
                if (this._counts.compareAndSet(counts, threads + 1, idle + 1)) {
                    startThread();
                }
            } else {
                return;
            }
        }
    }

    protected void startThread() {
        boolean started = false;
        try {
            Thread thread = this._threadFactory.newThread(this._runnable);
            if (LOG.isDebugEnabled()) {
                LOG.debug("Starting {}", thread);
            }
            this._threads.add(thread);
            this._lastShrink.set(System.nanoTime());
            thread.start();
            started = true;
            if (1 == 0) {
                addCounts(-1, -1);
            }
        } catch (Throwable th) {
            if (!started) {
                addCounts(-1, -1);
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public boolean addCounts(int deltaThreads, int deltaIdle) {
        long encoded;
        int threads;
        int idle;
        do {
            encoded = this._counts.get();
            threads = AtomicBiInteger.getHi(encoded);
            idle = AtomicBiInteger.getLo(encoded);
            if (threads == Integer.MIN_VALUE) {
                return false;
            }
        } while (!this._counts.compareAndSet(encoded, AtomicBiInteger.encode(threads + deltaThreads, idle + deltaIdle)));
        return true;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return PrivilegedThreadFactory.newThread(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: RETURN  
              (wrap: java.lang.Thread : 0x0007: INVOKE  (r0v2 java.lang.Thread A[REMOVE]) = 
              (wrap: java.util.function.Supplier : 0x0002: INVOKE_CUSTOM (r0v1 java.util.function.Supplier A[REMOVE]) = 
              (r3v0 'this' org.eclipse.jetty.util.thread.QueuedThreadPool A[D('this' org.eclipse.jetty.util.thread.QueuedThreadPool), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r4v0 'runnable' java.lang.Runnable A[D('runnable' java.lang.Runnable), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r0 I:org.eclipse.jetty.util.thread.QueuedThreadPool), (r1 I:java.lang.Runnable) type: DIRECT call: org.eclipse.jetty.util.thread.QueuedThreadPool.lambda$newThread$1(java.lang.Runnable):java.lang.Thread)
             type: STATIC call: org.eclipse.jetty.util.thread.PrivilegedThreadFactory.newThread(java.util.function.Supplier):java.lang.Thread)
             in method: org.eclipse.jetty.util.thread.QueuedThreadPool.newThread(java.lang.Runnable):java.lang.Thread, file: grasscutter.jar:org/eclipse/jetty/util/thread/QueuedThreadPool.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r3
            r1 = r4
            java.lang.Thread r0 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return r0.lambda$newThread$1(r1);
            }
            java.lang.Thread r0 = org.eclipse.jetty.util.thread.PrivilegedThreadFactory.newThread(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.thread.QueuedThreadPool.newThread(java.lang.Runnable):java.lang.Thread");
    }

    protected void removeThread(Thread thread) {
        this._threads.remove(thread);
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        List<Object> threads = new ArrayList<>(getMaxThreads());
        for (Thread thread : this._threads) {
            StackTraceElement[] trace = thread.getStackTrace();
            String stackTag = getCompressedStackTag(trace);
            String baseThreadInfo = String.format("%s %s tid=%d prio=%d", thread.getName(), thread.getState(), Long.valueOf(thread.getId()), Integer.valueOf(thread.getPriority()));
            if (!StringUtil.isBlank(stackTag)) {
                threads.add(baseThreadInfo + " " + stackTag);
            } else if (isDetailedDump()) {
                threads.add(o, i -> {
                    Dumpable.dumpObjects(o, i, baseThreadInfo, trace);
                });
            } else {
                threads.add(baseThreadInfo + " @ " + (trace.length > 0 ? trace[0].toString() : "???"));
            }
        }
        DumpableCollection threadsDump = new DumpableCollection("threads", threads);
        if (isDetailedDump()) {
            dumpObjects(out, indent, threadsDump, new DumpableCollection("jobs", new ArrayList(getQueue())));
        } else {
            dumpObjects(out, indent, threadsDump);
        }
    }

    private String getCompressedStackTag(StackTraceElement[] trace) {
        for (StackTraceElement t : trace) {
            if ("idleJobPoll".equals(t.getMethodName()) && t.getClassName().equals(Runner.class.getName())) {
                return "IDLE";
            }
            if ("reservedWait".equals(t.getMethodName()) && t.getClassName().endsWith("ReservedThread")) {
                return "RESERVED";
            }
            if ("select".equals(t.getMethodName()) && t.getClassName().endsWith("SelectorProducer")) {
                return "SELECTING";
            }
            if ("accept".equals(t.getMethodName()) && t.getClassName().contains("ServerConnector")) {
                return "ACCEPTING";
            }
        }
        return "";
    }

    protected void runJob(Runnable job) {
        job.run();
    }

    protected BlockingQueue<Runnable> getQueue() {
        return this._jobs;
    }

    @Deprecated
    public void setQueue(BlockingQueue<Runnable> queue) {
        throw new UnsupportedOperationException("Use constructor injection");
    }

    @ManagedOperation("interrupts a pool thread")
    public boolean interruptThread(@Name("id") long id) {
        for (Thread thread : this._threads) {
            if (thread.getId() == id) {
                thread.interrupt();
                return true;
            }
        }
        return false;
    }

    @ManagedOperation("dumps a pool thread stack")
    public String dumpThread(@Name("id") long id) {
        for (Thread thread : this._threads) {
            if (thread.getId() == id) {
                StringBuilder buf = new StringBuilder();
                buf.append(thread.getId()).append(" ").append(thread.getName()).append(" ");
                buf.append(thread.getState()).append(EmitterKt.COMMENT_PREFIX).append(System.lineSeparator());
                for (StackTraceElement element : thread.getStackTrace()) {
                    buf.append("  at ").append(element.toString()).append(System.lineSeparator());
                }
                return buf.toString();
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        long count = this._counts.get();
        return String.format("%s[%s]@%x{%s,%d<=%d<=%d,i=%d,r=%d,q=%d}[%s]", getClass().getSimpleName(), this._name, Integer.valueOf(hashCode()), getState(), Integer.valueOf(getMinThreads()), Integer.valueOf(Math.max(0, AtomicBiInteger.getHi(count))), Integer.valueOf(getMaxThreads()), Integer.valueOf(Math.max(0, AtomicBiInteger.getLo(count))), Integer.valueOf(getReservedThreads()), Integer.valueOf(getQueueSize()), this._tryExecutor);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/thread/QueuedThreadPool$Runner.class */
    private class Runner implements Runnable {
        private Runner() {
        }

        private Runnable idleJobPoll(long idleTimeout) throws InterruptedException {
            return idleTimeout <= 0 ? (Runnable) QueuedThreadPool.this._jobs.take() : (Runnable) QueuedThreadPool.this._jobs.poll(idleTimeout, TimeUnit.MILLISECONDS);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QueuedThreadPool.LOG.isDebugEnabled()) {
                QueuedThreadPool.LOG.debug("Runner started for {}", QueuedThreadPool.this);
            }
            boolean idle = true;
            Runnable job = null;
            while (true) {
                try {
                    if (!QueuedThreadPool.this.addCounts(0, job == null ? 0 : 1)) {
                        break;
                    }
                    idle = true;
                    job = (Runnable) QueuedThreadPool.this._jobs.poll();
                    if (job == null) {
                        long idleTimeout = (long) QueuedThreadPool.this.getIdleTimeout();
                        if (idleTimeout > 0 && QueuedThreadPool.this.getThreads() > QueuedThreadPool.this._minThreads) {
                            long last = QueuedThreadPool.this._lastShrink.get();
                            long now = System.nanoTime();
                            if (now - last > TimeUnit.MILLISECONDS.toNanos(idleTimeout) && QueuedThreadPool.this._lastShrink.compareAndSet(last, now)) {
                                if (QueuedThreadPool.LOG.isDebugEnabled()) {
                                    QueuedThreadPool.LOG.debug("shrinking {}", QueuedThreadPool.this);
                                }
                                Thread.interrupted();
                                break;
                            }
                        }
                        try {
                            job = idleJobPoll(idleTimeout);
                        } catch (InterruptedException e) {
                            if (QueuedThreadPool.LOG.isDebugEnabled()) {
                                QueuedThreadPool.LOG.debug("interrupted {} in {}", job, QueuedThreadPool.this);
                            }
                            QueuedThreadPool.LOG.ignore(e);
                            Thread.interrupted();
                        } catch (Throwable e2) {
                            QueuedThreadPool.LOG.warn(e2);
                            Thread.interrupted();
                        }
                        if (job == null) {
                            Thread.interrupted();
                        }
                    }
                    idle = false;
                    if (QueuedThreadPool.LOG.isDebugEnabled()) {
                        QueuedThreadPool.LOG.debug("run {} in {}", job, QueuedThreadPool.this);
                    }
                    QueuedThreadPool.this.runJob(job);
                    if (QueuedThreadPool.LOG.isDebugEnabled()) {
                        QueuedThreadPool.LOG.debug("ran {} in {}", job, QueuedThreadPool.this);
                    }
                    Thread.interrupted();
                } catch (Throwable th) {
                    Thread thread = Thread.currentThread();
                    QueuedThreadPool.this.removeThread(thread);
                    QueuedThreadPool.this.addCounts(-1, idle ? -1 : 0);
                    if (QueuedThreadPool.LOG.isDebugEnabled()) {
                        QueuedThreadPool.LOG.debug("{} exited for {}", thread, QueuedThreadPool.this);
                    }
                    QueuedThreadPool.this.ensureThreads();
                    throw th;
                }
            }
            Thread thread2 = Thread.currentThread();
            QueuedThreadPool.this.removeThread(thread2);
            QueuedThreadPool.this.addCounts(-1, idle ? -1 : 0);
            if (QueuedThreadPool.LOG.isDebugEnabled()) {
                QueuedThreadPool.LOG.debug("{} exited for {}", thread2, QueuedThreadPool.this);
            }
            QueuedThreadPool.this.ensureThreads();
        }
    }
}
