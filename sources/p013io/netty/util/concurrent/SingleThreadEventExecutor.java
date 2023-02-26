package p013io.netty.util.concurrent;

import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.Async;
import org.jline.builtins.TTop;
import p013io.netty.util.concurrent.AbstractEventExecutor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.ThreadExecutorMap;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.SingleThreadEventExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/SingleThreadEventExecutor.class */
public abstract class SingleThreadEventExecutor extends AbstractScheduledEventExecutor implements OrderedEventExecutor {
    static final int DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
    private static final InternalLogger logger;
    private static final int ST_NOT_STARTED = 1;
    private static final int ST_STARTED = 2;
    private static final int ST_SHUTTING_DOWN = 3;
    private static final int ST_SHUTDOWN = 4;
    private static final int ST_TERMINATED = 5;
    private static final Runnable NOOP_TASK;
    private static final AtomicIntegerFieldUpdater<SingleThreadEventExecutor> STATE_UPDATER;
    private static final AtomicReferenceFieldUpdater<SingleThreadEventExecutor, ThreadProperties> PROPERTIES_UPDATER;
    private final Queue<Runnable> taskQueue;
    private volatile Thread thread;
    private volatile ThreadProperties threadProperties;
    private final Executor executor;
    private volatile boolean interrupted;
    private final CountDownLatch threadLock;
    private final Set<Runnable> shutdownHooks;
    private final boolean addTaskWakesUp;
    private final int maxPendingTasks;
    private final RejectedExecutionHandler rejectedExecutionHandler;
    private long lastExecutionTime;
    private volatile int state;
    private volatile long gracefulShutdownQuietPeriod;
    private volatile long gracefulShutdownTimeout;
    private long gracefulShutdownStartTime;
    private final Promise<?> terminationFuture;
    private static final long SCHEDULE_PURGE_INTERVAL;
    static final /* synthetic */ boolean $assertionsDisabled;

    @Deprecated
    /* renamed from: io.netty.util.concurrent.SingleThreadEventExecutor$NonWakeupRunnable */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/SingleThreadEventExecutor$NonWakeupRunnable.class */
    protected interface NonWakeupRunnable extends AbstractEventExecutor.LazyRunnable {
    }

    protected abstract void run();

    static {
        $assertionsDisabled = !SingleThreadEventExecutor.class.desiredAssertionStatus();
        DEFAULT_MAX_PENDING_EXECUTOR_TASKS = Math.max(16, SystemPropertyUtil.getInt("io.netty.eventexecutor.maxPendingTasks", Integer.MAX_VALUE));
        logger = InternalLoggerFactory.getInstance(SingleThreadEventExecutor.class);
        NOOP_TASK = new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.1
            @Override // java.lang.Runnable
            public void run() {
            }
        };
        STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(SingleThreadEventExecutor.class, TTop.STAT_STATE);
        PROPERTIES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(SingleThreadEventExecutor.class, ThreadProperties.class, "threadProperties");
        SCHEDULE_PURGE_INTERVAL = TimeUnit.SECONDS.toNanos(1);
    }

    /* access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup parent, ThreadFactory threadFactory, boolean addTaskWakesUp) {
        this(parent, new ThreadPerTaskExecutor(threadFactory), addTaskWakesUp);
    }

    /* access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup parent, ThreadFactory threadFactory, boolean addTaskWakesUp, int maxPendingTasks, RejectedExecutionHandler rejectedHandler) {
        this(parent, new ThreadPerTaskExecutor(threadFactory), addTaskWakesUp, maxPendingTasks, rejectedHandler);
    }

    /* access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup parent, Executor executor, boolean addTaskWakesUp) {
        this(parent, executor, addTaskWakesUp, DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    /* access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup parent, Executor executor, boolean addTaskWakesUp, int maxPendingTasks, RejectedExecutionHandler rejectedHandler) {
        super(parent);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = addTaskWakesUp;
        this.maxPendingTasks = Math.max(16, maxPendingTasks);
        this.executor = ThreadExecutorMap.apply(executor, this);
        this.taskQueue = newTaskQueue(this.maxPendingTasks);
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedHandler, "rejectedHandler");
    }

    /* access modifiers changed from: protected */
    public SingleThreadEventExecutor(EventExecutorGroup parent, Executor executor, boolean addTaskWakesUp, Queue<Runnable> taskQueue, RejectedExecutionHandler rejectedHandler) {
        super(parent);
        this.threadLock = new CountDownLatch(1);
        this.shutdownHooks = new LinkedHashSet();
        this.state = 1;
        this.terminationFuture = new DefaultPromise(GlobalEventExecutor.INSTANCE);
        this.addTaskWakesUp = addTaskWakesUp;
        this.maxPendingTasks = DEFAULT_MAX_PENDING_EXECUTOR_TASKS;
        this.executor = ThreadExecutorMap.apply(executor, this);
        this.taskQueue = (Queue) ObjectUtil.checkNotNull(taskQueue, "taskQueue");
        this.rejectedExecutionHandler = (RejectedExecutionHandler) ObjectUtil.checkNotNull(rejectedHandler, "rejectedHandler");
    }

    @Deprecated
    protected Queue<Runnable> newTaskQueue() {
        return newTaskQueue(this.maxPendingTasks);
    }

    protected Queue<Runnable> newTaskQueue(int maxPendingTasks) {
        return new LinkedBlockingQueue(maxPendingTasks);
    }

    protected void interruptThread() {
        Thread currentThread = this.thread;
        if (currentThread == null) {
            this.interrupted = true;
        } else {
            currentThread.interrupt();
        }
    }

    protected Runnable pollTask() {
        if ($assertionsDisabled || inEventLoop()) {
            return pollTaskFrom(this.taskQueue);
        }
        throw new AssertionError();
    }

    protected static Runnable pollTaskFrom(Queue<Runnable> taskQueue) {
        Runnable task;
        do {
            task = taskQueue.poll();
        } while (task == WAKEUP_TASK);
        return task;
    }

    protected Runnable takeTask() {
        Runnable task;
        if (!$assertionsDisabled && !inEventLoop()) {
            throw new AssertionError();
        } else if (!(this.taskQueue instanceof BlockingQueue)) {
            throw new UnsupportedOperationException();
        } else {
            BlockingQueue<Runnable> taskQueue = (BlockingQueue) this.taskQueue;
            do {
                ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
                if (scheduledTask == null) {
                    Runnable task2 = null;
                    try {
                        task2 = taskQueue.take();
                        if (task2 == WAKEUP_TASK) {
                            task2 = null;
                        }
                    } catch (InterruptedException e) {
                    }
                    return task2;
                }
                long delayNanos = scheduledTask.delayNanos();
                task = null;
                if (delayNanos > 0) {
                    try {
                        task = taskQueue.poll(delayNanos, TimeUnit.NANOSECONDS);
                    } catch (InterruptedException e2) {
                        return null;
                    }
                }
                if (task == null) {
                    fetchFromScheduledTaskQueue();
                    task = taskQueue.poll();
                }
            } while (task == null);
            return task;
        }
    }

    private boolean fetchFromScheduledTaskQueue() {
        Runnable scheduledTask;
        if (this.scheduledTaskQueue == null || this.scheduledTaskQueue.isEmpty()) {
            return true;
        }
        long nanoTime = getCurrentTimeNanos();
        do {
            scheduledTask = pollScheduledTask(nanoTime);
            if (scheduledTask == null) {
                return true;
            }
        } while (this.taskQueue.offer(scheduledTask));
        this.scheduledTaskQueue.add((ScheduledFutureTask) scheduledTask);
        return false;
    }

    private boolean executeExpiredScheduledTasks() {
        Runnable pollScheduledTask;
        if (this.scheduledTaskQueue == null || this.scheduledTaskQueue.isEmpty()) {
            return false;
        }
        long nanoTime = getCurrentTimeNanos();
        Runnable scheduledTask = pollScheduledTask(nanoTime);
        if (scheduledTask == null) {
            return false;
        }
        do {
            safeExecute(scheduledTask);
            pollScheduledTask = pollScheduledTask(nanoTime);
            scheduledTask = pollScheduledTask;
        } while (pollScheduledTask != null);
        return true;
    }

    protected Runnable peekTask() {
        if ($assertionsDisabled || inEventLoop()) {
            return this.taskQueue.peek();
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public boolean hasTasks() {
        if ($assertionsDisabled || inEventLoop()) {
            return !this.taskQueue.isEmpty();
        }
        throw new AssertionError();
    }

    public int pendingTasks() {
        return this.taskQueue.size();
    }

    protected void addTask(Runnable task) {
        ObjectUtil.checkNotNull(task, "task");
        if (!offerTask(task)) {
            reject(task);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean offerTask(Runnable task) {
        if (isShutdown()) {
            reject();
        }
        return this.taskQueue.offer(task);
    }

    protected boolean removeTask(Runnable task) {
        return this.taskQueue.remove(ObjectUtil.checkNotNull(task, "task"));
    }

    protected boolean runAllTasks() {
        boolean fetchedAll;
        if ($assertionsDisabled || inEventLoop()) {
            boolean ranAtLeastOne = false;
            do {
                fetchedAll = fetchFromScheduledTaskQueue();
                if (runAllTasksFrom(this.taskQueue)) {
                    ranAtLeastOne = true;
                }
            } while (!fetchedAll);
            if (ranAtLeastOne) {
                this.lastExecutionTime = getCurrentTimeNanos();
            }
            afterRunningAllTasks();
            return ranAtLeastOne;
        }
        throw new AssertionError();
    }

    protected final boolean runScheduledAndExecutorTasks(int maxDrainAttempts) {
        if ($assertionsDisabled || inEventLoop()) {
            int drainAttempt = 0;
            while (runExistingTasksFrom(this.taskQueue) | executeExpiredScheduledTasks()) {
                drainAttempt++;
                if (drainAttempt >= maxDrainAttempts) {
                    break;
                }
            }
            if (drainAttempt > 0) {
                this.lastExecutionTime = getCurrentTimeNanos();
            }
            afterRunningAllTasks();
            return drainAttempt > 0;
        }
        throw new AssertionError();
    }

    protected final boolean runAllTasksFrom(Queue<Runnable> taskQueue) {
        Runnable task = pollTaskFrom(taskQueue);
        if (task == null) {
            return false;
        }
        do {
            safeExecute(task);
            task = pollTaskFrom(taskQueue);
        } while (task != null);
        return true;
    }

    private boolean runExistingTasksFrom(Queue<Runnable> taskQueue) {
        Runnable task;
        Runnable task2 = pollTaskFrom(taskQueue);
        if (task2 == null) {
            return false;
        }
        int remaining = Math.min(this.maxPendingTasks, taskQueue.size());
        safeExecute(task2);
        while (true) {
            remaining--;
            if (remaining <= 0 || (task = taskQueue.poll()) == null) {
                return true;
            }
            safeExecute(task);
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    protected boolean runAllTasks(long timeoutNanos) {
        char c;
        fetchFromScheduledTaskQueue();
        Runnable task = pollTask();
        if (task == null) {
            afterRunningAllTasks();
            return false;
        }
        long deadline = timeoutNanos > 0 ? getCurrentTimeNanos() + timeoutNanos : 0;
        char c2 = 0;
        while (true) {
            safeExecute(task);
            c2++;
            if ((c2 & '?') == 0) {
                c = getCurrentTimeNanos();
                if (c >= deadline) {
                    break;
                }
            }
            task = pollTask();
            if (task == null) {
                c = getCurrentTimeNanos();
                break;
            }
        }
        afterRunningAllTasks();
        this.lastExecutionTime = c;
        return true;
    }

    protected void afterRunningAllTasks() {
    }

    protected long delayNanos(long currentTimeNanos) {
        long currentTimeNanos2 = currentTimeNanos - initialNanoTime();
        ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
        if (scheduledTask == null) {
            return SCHEDULE_PURGE_INTERVAL;
        }
        return scheduledTask.delayNanos(currentTimeNanos2);
    }

    protected long deadlineNanos() {
        ScheduledFutureTask<?> scheduledTask = peekScheduledTask();
        if (scheduledTask == null) {
            return getCurrentTimeNanos() + SCHEDULE_PURGE_INTERVAL;
        }
        return scheduledTask.deadlineNanos();
    }

    protected void updateLastExecutionTime() {
        this.lastExecutionTime = getCurrentTimeNanos();
    }

    protected void cleanup() {
    }

    /* access modifiers changed from: protected */
    public void wakeup(boolean inEventLoop) {
        if (!inEventLoop) {
            this.taskQueue.offer(WAKEUP_TASK);
        }
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return thread == this.thread;
    }

    public void addShutdownHook(final Runnable task) {
        if (inEventLoop()) {
            this.shutdownHooks.add(task);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.2
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.add(task);
                }
            });
        }
    }

    public void removeShutdownHook(final Runnable task) {
        if (inEventLoop()) {
            this.shutdownHooks.remove(task);
        } else {
            execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.3
                @Override // java.lang.Runnable
                public void run() {
                    SingleThreadEventExecutor.this.shutdownHooks.remove(task);
                }
            });
        }
    }

    private boolean runShutdownHooks() {
        boolean ran = false;
        while (!this.shutdownHooks.isEmpty()) {
            List<Runnable> copy = new ArrayList<>(this.shutdownHooks);
            this.shutdownHooks.clear();
            for (Runnable task : copy) {
                try {
                    runTask(task);
                    ran = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (ran) {
            this.lastExecutionTime = getCurrentTimeNanos();
        }
        return ran;
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        int newState;
        ObjectUtil.checkPositiveOrZero(quietPeriod, "quietPeriod");
        if (timeout < quietPeriod) {
            throw new IllegalArgumentException("timeout: " + timeout + " (expected >= quietPeriod (" + quietPeriod + "))");
        }
        ObjectUtil.checkNotNull(unit, "unit");
        if (isShuttingDown()) {
            return terminationFuture();
        }
        boolean inEventLoop = inEventLoop();
        while (!isShuttingDown()) {
            boolean wakeup = true;
            int oldState = this.state;
            if (!inEventLoop) {
                switch (oldState) {
                    case 1:
                    case 2:
                        newState = 3;
                        break;
                    default:
                        newState = oldState;
                        wakeup = false;
                        break;
                }
            } else {
                newState = 3;
            }
            if (STATE_UPDATER.compareAndSet(this, oldState, newState)) {
                this.gracefulShutdownQuietPeriod = unit.toNanos(quietPeriod);
                this.gracefulShutdownTimeout = unit.toNanos(timeout);
                if (ensureThreadStarted(oldState)) {
                    return this.terminationFuture;
                }
                if (wakeup) {
                    this.taskQueue.offer(WAKEUP_TASK);
                    if (!this.addTaskWakesUp) {
                        wakeup(inEventLoop);
                    }
                }
                return terminationFuture();
            }
        }
        return terminationFuture();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
        int newState;
        if (!isShutdown()) {
            boolean inEventLoop = inEventLoop();
            while (!isShuttingDown()) {
                boolean wakeup = true;
                int oldState = this.state;
                if (!inEventLoop) {
                    switch (oldState) {
                        case 1:
                        case 2:
                        case 3:
                            newState = 4;
                            break;
                        default:
                            newState = oldState;
                            wakeup = false;
                            break;
                    }
                } else {
                    newState = 4;
                }
                if (STATE_UPDATER.compareAndSet(this, oldState, newState)) {
                    if (!ensureThreadStarted(oldState) && wakeup) {
                        this.taskQueue.offer(WAKEUP_TASK);
                        if (!this.addTaskWakesUp) {
                            wakeup(inEventLoop);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return this.state >= 3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.state >= 4;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.state == 5;
    }

    protected boolean confirmShutdown() {
        if (!isShuttingDown()) {
            return false;
        }
        if (!inEventLoop()) {
            throw new IllegalStateException("must be invoked from an event loop");
        }
        cancelScheduledTasks();
        if (this.gracefulShutdownStartTime == 0) {
            this.gracefulShutdownStartTime = getCurrentTimeNanos();
        }
        if (!runAllTasks() && !runShutdownHooks()) {
            long nanoTime = getCurrentTimeNanos();
            if (isShutdown() || nanoTime - this.gracefulShutdownStartTime > this.gracefulShutdownTimeout || nanoTime - this.lastExecutionTime > this.gracefulShutdownQuietPeriod) {
                return true;
            }
            this.taskQueue.offer(WAKEUP_TASK);
            try {
                Thread.sleep(100);
                return false;
            } catch (InterruptedException e) {
                return false;
            }
        } else if (isShutdown() || this.gracefulShutdownQuietPeriod == 0) {
            return true;
        } else {
            this.taskQueue.offer(WAKEUP_TASK);
            return false;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        ObjectUtil.checkNotNull(unit, "unit");
        if (inEventLoop()) {
            throw new IllegalStateException("cannot await termination of the current thread");
        }
        this.threadLock.await(timeout, unit);
        return isTerminated();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable task) {
        execute0(task);
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor
    public void lazyExecute(Runnable task) {
        lazyExecute0(task);
    }

    private void execute0(@Async.Schedule Runnable task) {
        ObjectUtil.checkNotNull(task, "task");
        execute(task, !(task instanceof AbstractEventExecutor.LazyRunnable) && wakesUpForTask(task));
    }

    private void lazyExecute0(@Async.Schedule Runnable task) {
        execute((Runnable) ObjectUtil.checkNotNull(task, "task"), false);
    }

    private void execute(Runnable task, boolean immediate) {
        boolean inEventLoop = inEventLoop();
        addTask(task);
        if (!inEventLoop) {
            startThread();
            if (isShutdown()) {
                boolean reject = false;
                try {
                    if (removeTask(task)) {
                        reject = true;
                    }
                } catch (UnsupportedOperationException e) {
                }
                if (reject) {
                    reject();
                }
            }
        }
        if (!this.addTaskWakesUp && immediate) {
            wakeup(inEventLoop);
        }
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        throwIfInEventLoop("invokeAny");
        return (T) invokeAny(tasks);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        throwIfInEventLoop("invokeAny");
        return (T) invokeAny(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return invokeAll(tasks);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        throwIfInEventLoop("invokeAll");
        return invokeAll(tasks, timeout, unit);
    }

    private void throwIfInEventLoop(String method) {
        if (inEventLoop()) {
            throw new RejectedExecutionException("Calling " + method + " from within the EventLoop is not allowed");
        }
    }

    public final ThreadProperties threadProperties() {
        ThreadProperties threadProperties = this.threadProperties;
        if (threadProperties == null) {
            Thread thread = this.thread;
            if (thread == null) {
                if ($assertionsDisabled || !inEventLoop()) {
                    submit(NOOP_TASK).syncUninterruptibly();
                    thread = this.thread;
                    if (!$assertionsDisabled && thread == null) {
                        throw new AssertionError();
                    }
                } else {
                    throw new AssertionError();
                }
            }
            threadProperties = new DefaultThreadProperties(thread);
            if (!PROPERTIES_UPDATER.compareAndSet(this, null, threadProperties)) {
                threadProperties = this.threadProperties;
            }
        }
        return threadProperties;
    }

    protected boolean wakesUpForTask(Runnable task) {
        return true;
    }

    protected static void reject() {
        throw new RejectedExecutionException("event executor terminated");
    }

    protected final void reject(Runnable task) {
        this.rejectedExecutionHandler.rejected(task, this);
    }

    private void startThread() {
        if (this.state == 1 && STATE_UPDATER.compareAndSet(this, 1, 2)) {
            boolean success = false;
            try {
                doStartThread();
                success = true;
                if (1 == 0) {
                    STATE_UPDATER.compareAndSet(this, 2, 1);
                }
            } catch (Throwable th) {
                if (!success) {
                    STATE_UPDATER.compareAndSet(this, 2, 1);
                }
                throw th;
            }
        }
    }

    private boolean ensureThreadStarted(int oldState) {
        if (oldState != 1) {
            return false;
        }
        try {
            doStartThread();
            return false;
        } catch (Throwable cause) {
            STATE_UPDATER.set(this, 5);
            this.terminationFuture.tryFailure(cause);
            if (cause instanceof Exception) {
                return true;
            }
            PlatformDependent.throwException(cause);
            return true;
        }
    }

    private void doStartThread() {
        if ($assertionsDisabled || this.thread == null) {
            this.executor.execute(new Runnable() { // from class: io.netty.util.concurrent.SingleThreadEventExecutor.4
                @Override // java.lang.Runnable
                public void run() {
                    int oldState;
                    int oldState2;
                    SingleThreadEventExecutor.this.thread = Thread.currentThread();
                    if (SingleThreadEventExecutor.this.interrupted) {
                        SingleThreadEventExecutor.this.thread.interrupt();
                    }
                    boolean success = false;
                    SingleThreadEventExecutor.this.updateLastExecutionTime();
                    try {
                        SingleThreadEventExecutor.this.run();
                        success = true;
                        do {
                            oldState2 = SingleThreadEventExecutor.this.state;
                            if (oldState2 >= 3) {
                                break;
                            }
                        } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, oldState2, 3));
                        if (1 != 0 && SingleThreadEventExecutor.this.gracefulShutdownStartTime == 0 && SingleThreadEventExecutor.logger.isErrorEnabled()) {
                            SingleThreadEventExecutor.logger.error("Buggy " + EventExecutor.class.getSimpleName() + " implementation; " + SingleThreadEventExecutor.class.getSimpleName() + ".confirmShutdown() must be called before run() implementation terminates.");
                        }
                        do {
                            try {
                            } catch (Throwable th) {
                                try {
                                    SingleThreadEventExecutor.this.cleanup();
                                    FastThreadLocal.removeAll();
                                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                    SingleThreadEventExecutor.this.threadLock.countDown();
                                    int numUserTasks = SingleThreadEventExecutor.this.drainTasks();
                                    if (numUserTasks > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks + ')');
                                    }
                                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                                    throw th;
                                } catch (Throwable th2) {
                                    FastThreadLocal.removeAll();
                                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                    SingleThreadEventExecutor.this.threadLock.countDown();
                                    int numUserTasks2 = SingleThreadEventExecutor.this.drainTasks();
                                    if (numUserTasks2 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks2 + ')');
                                    }
                                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                                    throw th2;
                                }
                            }
                        } while (!SingleThreadEventExecutor.this.confirmShutdown());
                        while (true) {
                            int oldState3 = SingleThreadEventExecutor.this.state;
                            if (oldState3 >= 4 || SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, oldState3, 4)) {
                                break;
                            }
                        }
                        SingleThreadEventExecutor.this.confirmShutdown();
                        try {
                            SingleThreadEventExecutor.this.cleanup();
                            FastThreadLocal.removeAll();
                            SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                            SingleThreadEventExecutor.this.threadLock.countDown();
                            int numUserTasks3 = SingleThreadEventExecutor.this.drainTasks();
                            if (numUserTasks3 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks3 + ')');
                            }
                            SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                        } catch (Throwable th3) {
                            FastThreadLocal.removeAll();
                            SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                            SingleThreadEventExecutor.this.threadLock.countDown();
                            int numUserTasks4 = SingleThreadEventExecutor.this.drainTasks();
                            if (numUserTasks4 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks4 + ')');
                            }
                            SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        do {
                            oldState = SingleThreadEventExecutor.this.state;
                            if (oldState >= 3) {
                                break;
                            }
                        } while (!SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, oldState, 3));
                        if (success && SingleThreadEventExecutor.this.gracefulShutdownStartTime == 0 && SingleThreadEventExecutor.logger.isErrorEnabled()) {
                            SingleThreadEventExecutor.logger.error("Buggy " + EventExecutor.class.getSimpleName() + " implementation; " + SingleThreadEventExecutor.class.getSimpleName() + ".confirmShutdown() must be called before run() implementation terminates.");
                        }
                        do {
                            try {
                            } catch (Throwable th5) {
                                try {
                                    SingleThreadEventExecutor.this.cleanup();
                                    FastThreadLocal.removeAll();
                                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                    SingleThreadEventExecutor.this.threadLock.countDown();
                                    int numUserTasks5 = SingleThreadEventExecutor.this.drainTasks();
                                    if (numUserTasks5 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks5 + ')');
                                    }
                                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                                    throw th5;
                                } catch (Throwable th6) {
                                    FastThreadLocal.removeAll();
                                    SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                                    SingleThreadEventExecutor.this.threadLock.countDown();
                                    int numUserTasks6 = SingleThreadEventExecutor.this.drainTasks();
                                    if (numUserTasks6 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                        SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks6 + ')');
                                    }
                                    SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                                    throw th6;
                                }
                            }
                        } while (!SingleThreadEventExecutor.this.confirmShutdown());
                        while (true) {
                            int oldState4 = SingleThreadEventExecutor.this.state;
                            if (oldState4 >= 4 || SingleThreadEventExecutor.STATE_UPDATER.compareAndSet(SingleThreadEventExecutor.this, oldState4, 4)) {
                                break;
                            }
                        }
                        SingleThreadEventExecutor.this.confirmShutdown();
                        try {
                            SingleThreadEventExecutor.this.cleanup();
                            FastThreadLocal.removeAll();
                            SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                            SingleThreadEventExecutor.this.threadLock.countDown();
                            int numUserTasks7 = SingleThreadEventExecutor.this.drainTasks();
                            if (numUserTasks7 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks7 + ')');
                            }
                            SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                            throw th4;
                        } catch (Throwable th7) {
                            FastThreadLocal.removeAll();
                            SingleThreadEventExecutor.STATE_UPDATER.set(SingleThreadEventExecutor.this, 5);
                            SingleThreadEventExecutor.this.threadLock.countDown();
                            int numUserTasks8 = SingleThreadEventExecutor.this.drainTasks();
                            if (numUserTasks8 > 0 && SingleThreadEventExecutor.logger.isWarnEnabled()) {
                                SingleThreadEventExecutor.logger.warn("An event executor terminated with non-empty task queue (" + numUserTasks8 + ')');
                            }
                            SingleThreadEventExecutor.this.terminationFuture.setSuccess(null);
                            throw th7;
                        }
                    }
                }
            });
            return;
        }
        throw new AssertionError();
    }

    final int drainTasks() {
        int numTasks = 0;
        while (true) {
            Runnable runnable = this.taskQueue.poll();
            if (runnable == null) {
                return numTasks;
            }
            if (WAKEUP_TASK != runnable) {
                numTasks++;
            }
        }
    }

    /* renamed from: io.netty.util.concurrent.SingleThreadEventExecutor$DefaultThreadProperties */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/SingleThreadEventExecutor$DefaultThreadProperties.class */
    private static final class DefaultThreadProperties implements ThreadProperties {

        /* renamed from: t */
        private final Thread f1000t;

        DefaultThreadProperties(Thread t) {
            this.f1000t = t;
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        public Thread.State state() {
            return this.f1000t.getState();
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        public int priority() {
            return this.f1000t.getPriority();
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        public boolean isInterrupted() {
            return this.f1000t.isInterrupted();
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        public boolean isDaemon() {
            return this.f1000t.isDaemon();
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        public String name() {
            return this.f1000t.getName();
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        /* renamed from: id */
        public long mo1172id() {
            return this.f1000t.getId();
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        public StackTraceElement[] stackTrace() {
            return this.f1000t.getStackTrace();
        }

        @Override // p013io.netty.util.concurrent.ThreadProperties
        public boolean isAlive() {
            return this.f1000t.isAlive();
        }
    }
}
