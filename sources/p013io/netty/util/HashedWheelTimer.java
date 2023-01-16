package p013io.netty.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;
import org.jline.builtins.TTop;
import p013io.netty.util.concurrent.ImmediateExecutor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.HashedWheelTimer */
/* loaded from: grasscutter.jar:io/netty/util/HashedWheelTimer.class */
public class HashedWheelTimer implements Timer {
    static final InternalLogger logger;
    private static final AtomicInteger INSTANCE_COUNTER;
    private static final AtomicBoolean WARNED_TOO_MANY_INSTANCES;
    private static final int INSTANCE_COUNT_LIMIT = 64;
    private static final long MILLISECOND_NANOS;
    private static final ResourceLeakDetector<HashedWheelTimer> leakDetector;
    private static final AtomicIntegerFieldUpdater<HashedWheelTimer> WORKER_STATE_UPDATER;
    private final ResourceLeakTracker<HashedWheelTimer> leak;
    private final Worker worker;
    private final Thread workerThread;
    public static final int WORKER_STATE_INIT = 0;
    public static final int WORKER_STATE_STARTED = 1;
    public static final int WORKER_STATE_SHUTDOWN = 2;
    private volatile int workerState;
    private final long tickDuration;
    private final HashedWheelBucket[] wheel;
    private final int mask;
    private final CountDownLatch startTimeInitialized;
    private final Queue<HashedWheelTimeout> timeouts;
    private final Queue<HashedWheelTimeout> cancelledTimeouts;
    private final AtomicLong pendingTimeouts;
    private final long maxPendingTimeouts;
    private final Executor taskExecutor;
    private volatile long startTime;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !HashedWheelTimer.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(HashedWheelTimer.class);
        INSTANCE_COUNTER = new AtomicInteger();
        WARNED_TOO_MANY_INSTANCES = new AtomicBoolean();
        MILLISECOND_NANOS = TimeUnit.MILLISECONDS.toNanos(1);
        leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(HashedWheelTimer.class, 1);
        WORKER_STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimer.class, "workerState");
    }

    public HashedWheelTimer() {
        this(Executors.defaultThreadFactory());
    }

    public HashedWheelTimer(long tickDuration, TimeUnit unit) {
        this(Executors.defaultThreadFactory(), tickDuration, unit);
    }

    public HashedWheelTimer(long tickDuration, TimeUnit unit, int ticksPerWheel) {
        this(Executors.defaultThreadFactory(), tickDuration, unit, ticksPerWheel);
    }

    public HashedWheelTimer(ThreadFactory threadFactory) {
        this(threadFactory, 100, TimeUnit.MILLISECONDS);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long tickDuration, TimeUnit unit) {
        this(threadFactory, tickDuration, unit, 512);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long tickDuration, TimeUnit unit, int ticksPerWheel) {
        this(threadFactory, tickDuration, unit, ticksPerWheel, true);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long tickDuration, TimeUnit unit, int ticksPerWheel, boolean leakDetection) {
        this(threadFactory, tickDuration, unit, ticksPerWheel, leakDetection, -1);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long tickDuration, TimeUnit unit, int ticksPerWheel, boolean leakDetection, long maxPendingTimeouts) {
        this(threadFactory, tickDuration, unit, ticksPerWheel, leakDetection, maxPendingTimeouts, ImmediateExecutor.INSTANCE);
    }

    public HashedWheelTimer(ThreadFactory threadFactory, long tickDuration, TimeUnit unit, int ticksPerWheel, boolean leakDetection, long maxPendingTimeouts, Executor taskExecutor) {
        this.worker = new Worker();
        this.startTimeInitialized = new CountDownLatch(1);
        this.timeouts = PlatformDependent.newMpscQueue();
        this.cancelledTimeouts = PlatformDependent.newMpscQueue();
        this.pendingTimeouts = new AtomicLong(0);
        ObjectUtil.checkNotNull(threadFactory, "threadFactory");
        ObjectUtil.checkNotNull(unit, "unit");
        ObjectUtil.checkPositive(tickDuration, "tickDuration");
        ObjectUtil.checkPositive(ticksPerWheel, "ticksPerWheel");
        this.taskExecutor = (Executor) ObjectUtil.checkNotNull(taskExecutor, "taskExecutor");
        this.wheel = createWheel(ticksPerWheel);
        this.mask = this.wheel.length - 1;
        long duration = unit.toNanos(tickDuration);
        if (duration >= LongCompanionObject.MAX_VALUE / ((long) this.wheel.length)) {
            throw new IllegalArgumentException(String.format("tickDuration: %d (expected: 0 < tickDuration in nanos < %d", Long.valueOf(tickDuration), Long.valueOf(LongCompanionObject.MAX_VALUE / ((long) this.wheel.length))));
        }
        if (duration < MILLISECOND_NANOS) {
            logger.warn("Configured tickDuration {} smaller than {}, using 1ms.", Long.valueOf(tickDuration), Long.valueOf(MILLISECOND_NANOS));
            this.tickDuration = MILLISECOND_NANOS;
        } else {
            this.tickDuration = duration;
        }
        this.workerThread = threadFactory.newThread(this.worker);
        this.leak = (leakDetection || !this.workerThread.isDaemon()) ? leakDetector.track(this) : null;
        this.maxPendingTimeouts = maxPendingTimeouts;
        if (INSTANCE_COUNTER.incrementAndGet() > 64 && WARNED_TOO_MANY_INSTANCES.compareAndSet(false, true)) {
            reportTooManyInstances();
        }
    }

    protected void finalize() throws Throwable {
        try {
            finalize();
            if (WORKER_STATE_UPDATER.getAndSet(this, 2) != 2) {
                INSTANCE_COUNTER.decrementAndGet();
            }
        } catch (Throwable th) {
            if (WORKER_STATE_UPDATER.getAndSet(this, 2) != 2) {
                INSTANCE_COUNTER.decrementAndGet();
            }
            throw th;
        }
    }

    private static HashedWheelBucket[] createWheel(int ticksPerWheel) {
        ObjectUtil.checkInRange(ticksPerWheel, 1, 1073741824, "ticksPerWheel");
        HashedWheelBucket[] wheel = new HashedWheelBucket[normalizeTicksPerWheel(ticksPerWheel)];
        for (int i = 0; i < wheel.length; i++) {
            wheel[i] = new HashedWheelBucket();
        }
        return wheel;
    }

    private static int normalizeTicksPerWheel(int ticksPerWheel) {
        int normalizedTicksPerWheel = 1;
        while (normalizedTicksPerWheel < ticksPerWheel) {
            normalizedTicksPerWheel <<= 1;
        }
        return normalizedTicksPerWheel;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public void start() {
        switch (WORKER_STATE_UPDATER.get(this)) {
            case 0:
                if (WORKER_STATE_UPDATER.compareAndSet(this, 0, 1)) {
                    this.workerThread.start();
                    break;
                }
                break;
            case 1:
                break;
            case 2:
                throw new IllegalStateException("cannot be started once stopped");
            default:
                throw new Error("Invalid WorkerState");
        }
        while (this.startTime == 0) {
            try {
                this.startTimeInitialized.await();
            } catch (InterruptedException e) {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:25:0x009a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.util.Timer
    public java.util.Set<p013io.netty.util.Timeout> stop() {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.HashedWheelTimer.stop():java.util.Set");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p013io.netty.util.Timer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p013io.netty.util.Timeout newTimeout(p013io.netty.util.TimerTask r8, long r9, java.util.concurrent.TimeUnit r11) {
        /*
            r7 = this;
            r0 = r8
            java.lang.String r1 = "task"
            java.lang.Object r0 = p013io.netty.util.internal.ObjectUtil.checkNotNull(r0, r1)
            r0 = r11
            java.lang.String r1 = "unit"
            java.lang.Object r0 = p013io.netty.util.internal.ObjectUtil.checkNotNull(r0, r1)
            r0 = r7
            java.util.concurrent.atomic.AtomicLong r0 = r0.pendingTimeouts
            long r0 = r0.incrementAndGet()
            r12 = r0
            r0 = r7
            long r0 = r0.maxPendingTimeouts
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0064
            r0 = r12
            r1 = r7
            long r1 = r1.maxPendingTimeouts
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0064
            r0 = r7
            java.util.concurrent.atomic.AtomicLong r0 = r0.pendingTimeouts
            long r0 = r0.decrementAndGet()
            java.util.concurrent.RejectedExecutionException r0 = new java.util.concurrent.RejectedExecutionException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Number of pending timeouts ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r12
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ") is greater than or equal to maximum allowed pending timeouts ("
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            long r3 = r3.maxPendingTimeouts
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ")"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0064:
            r0 = r7
            r0.start()
            long r0 = java.lang.System.nanoTime()
            r1 = r11
            r2 = r9
            long r1 = r1.toNanos(r2)
            long r0 = r0 + r1
            r1 = r7
            long r1 = r1.startTime
            long r0 = r0 - r1
            r14 = r0
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x008b
            r0 = r14
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x008b
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r14 = r0
        L_0x008b:
            io.netty.util.HashedWheelTimer$HashedWheelTimeout r0 = new io.netty.util.HashedWheelTimer$HashedWheelTimeout
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r14
            r1.<init>(r2, r3, r4)
            r16 = r0
            r0 = r7
            java.util.Queue<io.netty.util.HashedWheelTimer$HashedWheelTimeout> r0 = r0.timeouts
            r1 = r16
            boolean r0 = r0.add(r1)
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.HashedWheelTimer.newTimeout(io.netty.util.TimerTask, long, java.util.concurrent.TimeUnit):io.netty.util.Timeout");
    }

    public long pendingTimeouts() {
        return this.pendingTimeouts.get();
    }

    private static void reportTooManyInstances() {
        if (logger.isErrorEnabled()) {
            String resourceType = StringUtil.simpleClassName((Class<?>) HashedWheelTimer.class);
            logger.error("You are creating too many " + resourceType + " instances. " + resourceType + " is a shared resource that must be reused across the JVM, so that only a few instances are created.");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.HashedWheelTimer$Worker */
    /* loaded from: grasscutter.jar:io/netty/util/HashedWheelTimer$Worker.class */
    public final class Worker implements Runnable {
        private final Set<Timeout> unprocessedTimeouts;
        private long tick;

        private Worker() {
            this.unprocessedTimeouts = new HashSet();
        }

        @Override // java.lang.Runnable
        public void run() {
            HashedWheelTimer.this.startTime = System.nanoTime();
            if (HashedWheelTimer.this.startTime == 0) {
                HashedWheelTimer.this.startTime = 1;
            }
            HashedWheelTimer.this.startTimeInitialized.countDown();
            do {
                long deadline = waitForNextTick();
                if (deadline > 0) {
                    int idx = (int) (this.tick & ((long) HashedWheelTimer.this.mask));
                    processCancelledTasks();
                    HashedWheelBucket bucket = HashedWheelTimer.this.wheel[idx];
                    transferTimeoutsToBuckets();
                    bucket.expireTimeouts(deadline);
                    this.tick++;
                }
            } while (HashedWheelTimer.WORKER_STATE_UPDATER.get(HashedWheelTimer.this) == 1);
            for (HashedWheelBucket bucket2 : HashedWheelTimer.this.wheel) {
                bucket2.clearTimeouts(this.unprocessedTimeouts);
            }
            while (true) {
                HashedWheelTimeout timeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll();
                if (timeout == null) {
                    processCancelledTasks();
                    return;
                } else if (!timeout.isCancelled()) {
                    this.unprocessedTimeouts.add(timeout);
                }
            }
        }

        private void transferTimeoutsToBuckets() {
            HashedWheelTimeout timeout;
            for (int i = 0; i < 100000 && (timeout = (HashedWheelTimeout) HashedWheelTimer.this.timeouts.poll()) != null; i++) {
                if (timeout.state() != 1) {
                    long calculated = timeout.deadline / HashedWheelTimer.this.tickDuration;
                    timeout.remainingRounds = (calculated - this.tick) / ((long) HashedWheelTimer.this.wheel.length);
                    HashedWheelTimer.this.wheel[(int) (Math.max(calculated, this.tick) & ((long) HashedWheelTimer.this.mask))].addTimeout(timeout);
                }
            }
        }

        private void processCancelledTasks() {
            while (true) {
                HashedWheelTimeout timeout = (HashedWheelTimeout) HashedWheelTimer.this.cancelledTimeouts.poll();
                if (timeout != null) {
                    try {
                        timeout.remove();
                    } catch (Throwable t) {
                        if (HashedWheelTimer.logger.isWarnEnabled()) {
                            HashedWheelTimer.logger.warn("An exception was thrown while process a cancellation task", t);
                        }
                    }
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v1 */
        /* JADX WARN: Type inference failed for: r12v3 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v6 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long waitForNextTick() {
            /*
                r7 = this;
                r0 = r7
                io.netty.util.HashedWheelTimer r0 = p013io.netty.util.HashedWheelTimer.this
                long r0 = p013io.netty.util.HashedWheelTimer.access$900(r0)
                r1 = r7
                long r1 = r1.tick
                r2 = 1
                long r1 = r1 + r2
                long r0 = r0 * r1
                r8 = r0
            L_0x000f:
                long r0 = java.lang.System.nanoTime()
                r1 = r7
                io.netty.util.HashedWheelTimer r1 = p013io.netty.util.HashedWheelTimer.this
                long r1 = p013io.netty.util.HashedWheelTimer.access$200(r1)
                long r0 = r0 - r1
                r10 = r0
                r0 = r8
                r1 = r10
                long r0 = r0 - r1
                r1 = 999999(0xf423f, double:4.94065E-318)
                long r0 = r0 + r1
                r1 = 1000000(0xf4240, double:4.940656E-318)
                long r0 = r0 / r1
                r12 = r0
                r0 = r12
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x003d
                r0 = r10
                r1 = -9223372036854775808
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x003b
                r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                return r0
            L_0x003b:
                r0 = r10
                return r0
            L_0x003d:
                boolean r0 = p013io.netty.util.internal.PlatformDependent.isWindows()
                if (r0 == 0) goto L_0x0059
                r0 = r12
                r1 = 10
                long r0 = r0 / r1
                r1 = 10
                long r0 = r0 * r1
                r12 = r0
                r0 = r12
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 != 0) goto L_0x0059
                r0 = 1
                r12 = r0
            L_0x0059:
                r0 = r12
                java.lang.Thread.sleep(r0)     // Catch: InterruptedException -> 0x0061
                goto L_0x0075
            L_0x0061:
                r14 = move-exception
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = p013io.netty.util.HashedWheelTimer.access$600()
                r1 = r7
                io.netty.util.HashedWheelTimer r1 = p013io.netty.util.HashedWheelTimer.this
                int r0 = r0.get(r1)
                r1 = 2
                if (r0 != r1) goto L_0x0075
                r0 = -9223372036854775808
                return r0
            L_0x0075:
                goto L_0x000f
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.HashedWheelTimer.Worker.waitForNextTick():long");
        }

        public Set<Timeout> unprocessedTimeouts() {
            return Collections.unmodifiableSet(this.unprocessedTimeouts);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.HashedWheelTimer$HashedWheelTimeout */
    /* loaded from: grasscutter.jar:io/netty/util/HashedWheelTimer$HashedWheelTimeout.class */
    public static final class HashedWheelTimeout implements Timeout, Runnable {
        private static final int ST_INIT = 0;
        private static final int ST_CANCELLED = 1;
        private static final int ST_EXPIRED = 2;
        private static final AtomicIntegerFieldUpdater<HashedWheelTimeout> STATE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(HashedWheelTimeout.class, TTop.STAT_STATE);
        private final HashedWheelTimer timer;
        private final TimerTask task;
        private final long deadline;
        private volatile int state = 0;
        long remainingRounds;
        HashedWheelTimeout next;
        HashedWheelTimeout prev;
        HashedWheelBucket bucket;

        HashedWheelTimeout(HashedWheelTimer timer, TimerTask task, long deadline) {
            this.timer = timer;
            this.task = task;
            this.deadline = deadline;
        }

        @Override // p013io.netty.util.Timeout
        public Timer timer() {
            return this.timer;
        }

        @Override // p013io.netty.util.Timeout
        public TimerTask task() {
            return this.task;
        }

        @Override // p013io.netty.util.Timeout
        public boolean cancel() {
            if (!compareAndSetState(0, 1)) {
                return false;
            }
            this.timer.cancelledTimeouts.add(this);
            return true;
        }

        void remove() {
            HashedWheelBucket bucket = this.bucket;
            if (bucket != null) {
                bucket.remove(this);
            } else {
                this.timer.pendingTimeouts.decrementAndGet();
            }
        }

        public boolean compareAndSetState(int expected, int state) {
            return STATE_UPDATER.compareAndSet(this, expected, state);
        }

        public int state() {
            return this.state;
        }

        @Override // p013io.netty.util.Timeout
        public boolean isCancelled() {
            return state() == 1;
        }

        @Override // p013io.netty.util.Timeout
        public boolean isExpired() {
            return state() == 2;
        }

        public void expire() {
            if (compareAndSetState(0, 2)) {
                try {
                    this.timer.taskExecutor.execute(this);
                } catch (Throwable t) {
                    if (HashedWheelTimer.logger.isWarnEnabled()) {
                        HashedWheelTimer.logger.warn("An exception was thrown while submit " + TimerTask.class.getSimpleName() + " for execution.", t);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.task.run(this);
            } catch (Throwable t) {
                if (HashedWheelTimer.logger.isWarnEnabled()) {
                    HashedWheelTimer.logger.warn("An exception was thrown by " + TimerTask.class.getSimpleName() + '.', t);
                }
            }
        }

        @Override // java.lang.Object
        public String toString() {
            long remaining = (this.deadline - System.nanoTime()) + this.timer.startTime;
            StringBuilder buf = new StringBuilder(192).append(StringUtil.simpleClassName(this)).append('(').append("deadline: ");
            if (remaining > 0) {
                buf.append(remaining).append(" ns later");
            } else if (remaining < 0) {
                buf.append(-remaining).append(" ns ago");
            } else {
                buf.append("now");
            }
            if (isCancelled()) {
                buf.append(", cancelled");
            }
            return buf.append(", task: ").append(task()).append(')').toString();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.HashedWheelTimer$HashedWheelBucket */
    /* loaded from: grasscutter.jar:io/netty/util/HashedWheelTimer$HashedWheelBucket.class */
    public static final class HashedWheelBucket {
        private HashedWheelTimeout head;
        private HashedWheelTimeout tail;
        static final /* synthetic */ boolean $assertionsDisabled;

        private HashedWheelBucket() {
        }

        static {
            $assertionsDisabled = !HashedWheelTimer.class.desiredAssertionStatus();
        }

        public void addTimeout(HashedWheelTimeout timeout) {
            if ($assertionsDisabled || timeout.bucket == null) {
                timeout.bucket = this;
                if (this.head == null) {
                    this.tail = timeout;
                    this.head = timeout;
                    return;
                }
                this.tail.next = timeout;
                timeout.prev = this.tail;
                this.tail = timeout;
                return;
            }
            throw new AssertionError();
        }

        public void expireTimeouts(long deadline) {
            HashedWheelTimeout timeout = this.head;
            while (timeout != null) {
                HashedWheelTimeout next = timeout.next;
                if (timeout.remainingRounds <= 0) {
                    next = remove(timeout);
                    if (timeout.deadline <= deadline) {
                        timeout.expire();
                    } else {
                        throw new IllegalStateException(String.format("timeout.deadline (%d) > deadline (%d)", Long.valueOf(timeout.deadline), Long.valueOf(deadline)));
                    }
                } else if (timeout.isCancelled()) {
                    next = remove(timeout);
                } else {
                    timeout.remainingRounds--;
                }
                timeout = next;
            }
        }

        public HashedWheelTimeout remove(HashedWheelTimeout timeout) {
            HashedWheelTimeout next = timeout.next;
            if (timeout.prev != null) {
                timeout.prev.next = next;
            }
            if (timeout.next != null) {
                timeout.next.prev = timeout.prev;
            }
            if (timeout == this.head) {
                if (timeout == this.tail) {
                    this.tail = null;
                    this.head = null;
                } else {
                    this.head = next;
                }
            } else if (timeout == this.tail) {
                this.tail = timeout.prev;
            }
            timeout.prev = null;
            timeout.next = null;
            timeout.bucket = null;
            timeout.timer.pendingTimeouts.decrementAndGet();
            return next;
        }

        public void clearTimeouts(Set<Timeout> set) {
            while (true) {
                HashedWheelTimeout timeout = pollTimeout();
                if (timeout != null) {
                    if (!timeout.isExpired() && !timeout.isCancelled()) {
                        set.add(timeout);
                    }
                } else {
                    return;
                }
            }
        }

        private HashedWheelTimeout pollTimeout() {
            HashedWheelTimeout head = this.head;
            if (head == null) {
                return null;
            }
            HashedWheelTimeout next = head.next;
            if (next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = next;
                next.prev = null;
            }
            head.next = null;
            head.prev = null;
            head.bucket = null;
            return head;
        }
    }
}
