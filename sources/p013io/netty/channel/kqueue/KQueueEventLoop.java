package p013io.netty.channel.kqueue;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p013io.netty.channel.EventLoopGroup;
import p013io.netty.channel.EventLoopTaskQueueFactory;
import p013io.netty.channel.SelectStrategy;
import p013io.netty.channel.SingleThreadEventLoop;
import p013io.netty.channel.kqueue.AbstractKQueueChannel;
import p013io.netty.channel.unix.FileDescriptor;
import p013io.netty.channel.unix.IovArray;
import p013io.netty.util.IntSupplier;
import p013io.netty.util.collection.IntObjectHashMap;
import p013io.netty.util.collection.IntObjectMap;
import p013io.netty.util.concurrent.RejectedExecutionHandler;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.kqueue.KQueueEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/kqueue/KQueueEventLoop.class */
public final class KQueueEventLoop extends SingleThreadEventLoop {
    private static final InternalLogger logger;
    private static final AtomicIntegerFieldUpdater<KQueueEventLoop> WAKEN_UP_UPDATER;
    private static final int KQUEUE_WAKE_UP_IDENT = 0;
    private final boolean allowGrowing;
    private final KQueueEventArray changeList;
    private final KQueueEventArray eventList;
    private final SelectStrategy selectStrategy;
    private volatile int wakenUp;
    static final /* synthetic */ boolean $assertionsDisabled;
    private final IovArray iovArray = new IovArray();
    private final IntSupplier selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.kqueue.KQueueEventLoop.1
        @Override // p013io.netty.util.IntSupplier
        public int get() throws Exception {
            return KQueueEventLoop.this.kqueueWaitNow();
        }
    };
    private final IntObjectMap<AbstractKQueueChannel> channels = new IntObjectHashMap(4096);
    private volatile int ioRatio = 50;
    private final FileDescriptor kqueueFd = Native.newKQueue();

    static {
        $assertionsDisabled = !KQueueEventLoop.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(KQueueEventLoop.class);
        WAKEN_UP_UPDATER = AtomicIntegerFieldUpdater.newUpdater(KQueueEventLoop.class, "wakenUp");
        KQueue.ensureAvailability();
    }

    /* access modifiers changed from: package-private */
    public KQueueEventLoop(EventLoopGroup parent, Executor executor, int maxEvents, SelectStrategy strategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory taskQueueFactory, EventLoopTaskQueueFactory tailTaskQueueFactory) {
        super(parent, executor, false, newTaskQueue(taskQueueFactory), newTaskQueue(tailTaskQueueFactory), rejectedExecutionHandler);
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(strategy, "strategy");
        if (maxEvents == 0) {
            this.allowGrowing = true;
            maxEvents = 4096;
        } else {
            this.allowGrowing = false;
        }
        this.changeList = new KQueueEventArray(maxEvents);
        this.eventList = new KQueueEventArray(maxEvents);
        int result = Native.keventAddUserEvent(this.kqueueFd.intValue(), 0);
        if (result < 0) {
            cleanup();
            throw new IllegalStateException("kevent failed to add user event with errno: " + (-result));
        }
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory queueFactory) {
        if (queueFactory == null) {
            return newTaskQueue0(DEFAULT_MAX_PENDING_TASKS);
        }
        return queueFactory.newTaskQueue(DEFAULT_MAX_PENDING_TASKS);
    }

    /* access modifiers changed from: package-private */
    public void add(AbstractKQueueChannel ch) {
        if ($assertionsDisabled || inEventLoop()) {
            AbstractKQueueChannel old = this.channels.put(ch.mo1175fd().intValue(), (int) ch);
            if (!$assertionsDisabled && old != null && old.isOpen()) {
                throw new AssertionError();
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void evSet(AbstractKQueueChannel ch, short filter, short flags, int fflags) {
        if ($assertionsDisabled || inEventLoop()) {
            this.changeList.evSet(ch, filter, flags, fflags);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void remove(AbstractKQueueChannel ch) throws Exception {
        if ($assertionsDisabled || inEventLoop()) {
            int fd = ch.mo1175fd().intValue();
            AbstractKQueueChannel old = this.channels.remove(fd);
            if (old != null && old != ch) {
                this.channels.put(fd, (int) old);
                if (!$assertionsDisabled && ch.isOpen()) {
                    throw new AssertionError();
                }
            } else if (ch.isOpen()) {
                ch.unregisterFilters();
            }
        } else {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public IovArray cleanArray() {
        this.iovArray.clear();
        return this.iovArray;
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean inEventLoop) {
        if (!inEventLoop && WAKEN_UP_UPDATER.compareAndSet(this, 0, 1)) {
            wakeup();
        }
    }

    private void wakeup() {
        Native.keventTriggerUserEvent(this.kqueueFd.intValue(), 0);
    }

    private int kqueueWait(boolean oldWakeup) throws IOException {
        if (oldWakeup && hasTasks()) {
            return kqueueWaitNow();
        }
        long totalDelay = delayNanos(System.nanoTime());
        int delaySeconds = (int) Math.min(totalDelay / 1000000000, 2147483647L);
        return kqueueWait(delaySeconds, (int) Math.min(totalDelay - (((long) delaySeconds) * 1000000000), 2147483647L));
    }

    /* access modifiers changed from: private */
    public int kqueueWaitNow() throws IOException {
        return kqueueWait(0, 0);
    }

    private int kqueueWait(int timeoutSec, int timeoutNs) throws IOException {
        int numEvents = Native.keventWait(this.kqueueFd.intValue(), this.changeList, this.eventList, timeoutSec, timeoutNs);
        this.changeList.clear();
        return numEvents;
    }

    private void processReady(int ready) {
        for (int i = 0; i < ready; i++) {
            short filter = this.eventList.filter(i);
            short flags = this.eventList.flags(i);
            int fd = this.eventList.m1180fd(i);
            if (filter != Native.EVFILT_USER && (flags & Native.EV_ERROR) == 0) {
                AbstractKQueueChannel channel = this.channels.get(fd);
                if (channel == null) {
                    logger.warn("events[{}]=[{}, {}] had no channel!", Integer.valueOf(i), Integer.valueOf(this.eventList.m1180fd(i)), Short.valueOf(filter));
                } else {
                    AbstractKQueueChannel.AbstractKQueueUnsafe unsafe = (AbstractKQueueChannel.AbstractKQueueUnsafe) channel.unsafe();
                    if (filter == Native.EVFILT_WRITE) {
                        unsafe.writeReady();
                    } else if (filter == Native.EVFILT_READ) {
                        unsafe.readReady(this.eventList.data(i));
                    } else if (filter == Native.EVFILT_SOCK && (this.eventList.fflags(i) & Native.NOTE_RDHUP) != 0) {
                        unsafe.readEOF();
                    }
                    if ((flags & Native.EV_EOF) != 0) {
                        unsafe.readEOF();
                    }
                }
            } else if (!$assertionsDisabled && filter == Native.EVFILT_USER && !(filter == Native.EVFILT_USER && fd == 0)) {
                throw new AssertionError();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x00fc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0000 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098 A[Catch: Error -> 0x0118, Throwable -> 0x011b, all -> 0x0143, TryCatch #12 {Error -> 0x0118, Throwable -> 0x011b, blocks: (B:2:0x0000, B:3:0x0013, B:15:0x004f, B:19:0x0061, B:21:0x006d, B:22:0x0071, B:26:0x0080, B:28:0x0086, B:30:0x008e, B:31:0x0094, B:33:0x0098, B:36:0x00a0, B:37:0x00a5, B:38:0x00a8, B:40:0x00c1, B:41:0x00c4, B:42:0x00da, B:43:0x00db, B:45:0x00e2, B:47:0x00ed), top: B:90:0x0000, outer: #2 }] */
    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void run() {
        /*
        // Method dump skipped, instructions count: 368
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.kqueue.KQueueEventLoop.run():void");
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected Queue<Runnable> newTaskQueue(int maxPendingTasks) {
        return newTaskQueue0(maxPendingTasks);
    }

    private static Queue<Runnable> newTaskQueue0(int maxPendingTasks) {
        return maxPendingTasks == Integer.MAX_VALUE ? PlatformDependent.newMpscQueue() : PlatformDependent.newMpscQueue(maxPendingTasks);
    }

    public int getIoRatio() {
        return this.ioRatio;
    }

    public void setIoRatio(int ioRatio) {
        if (ioRatio <= 0 || ioRatio > 100) {
            throw new IllegalArgumentException("ioRatio: " + ioRatio + " (expected: 0 < ioRatio <= 100)");
        }
        this.ioRatio = ioRatio;
    }

    @Override // p013io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.channels.size();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:3:0x000a
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        /*
            r4 = this;
            r0 = r4
            io.netty.channel.unix.FileDescriptor r0 = r0.kqueueFd     // Catch: all -> 0x0027, IOException -> 0x000a
            r0.close()     // Catch: all -> 0x0027, IOException -> 0x000a
            goto L_0x0016
        L_0x000a:
            r5 = move-exception
            io.netty.util.internal.logging.InternalLogger r0 = p013io.netty.channel.kqueue.KQueueEventLoop.logger     // Catch: all -> 0x0027
            java.lang.String r1 = "Failed to close the kqueue fd."
            r2 = r5
            r0.warn(r1, r2)     // Catch: all -> 0x0027
        L_0x0016:
            r0 = r4
            io.netty.channel.kqueue.KQueueEventArray r0 = r0.changeList
            r0.free()
            r0 = r4
            io.netty.channel.kqueue.KQueueEventArray r0 = r0.eventList
            r0.free()
            goto L_0x0038
        L_0x0027:
            r6 = move-exception
            r0 = r4
            io.netty.channel.kqueue.KQueueEventArray r0 = r0.changeList
            r0.free()
            r0 = r4
            io.netty.channel.kqueue.KQueueEventArray r0 = r0.eventList
            r0.free()
            r0 = r6
            throw r0
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.kqueue.KQueueEventLoop.cleanup():void");
    }

    private void closeAll() {
        try {
            kqueueWaitNow();
        } catch (IOException e) {
        }
        AbstractKQueueChannel[] localChannels = (AbstractKQueueChannel[]) this.channels.values().toArray(new AbstractKQueueChannel[0]);
        for (AbstractKQueueChannel ch : localChannels) {
            ch.unsafe().close(ch.unsafe().voidPromise());
        }
    }

    private static void handleLoopException(Throwable t) {
        logger.warn("Unexpected exception in the selector loop.", t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
}
