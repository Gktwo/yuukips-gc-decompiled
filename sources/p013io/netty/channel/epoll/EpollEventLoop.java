package p013io.netty.channel.epoll;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.channel.EventLoopTaskQueueFactory;
import p013io.netty.channel.SelectStrategy;
import p013io.netty.channel.SingleThreadEventLoop;
import p013io.netty.channel.epoll.AbstractEpollChannel;
import p013io.netty.channel.unix.FileDescriptor;
import p013io.netty.channel.unix.IovArray;
import p013io.netty.util.IntSupplier;
import p013io.netty.util.collection.IntObjectMap;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.channel.epoll.EpollEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/epoll/EpollEventLoop.class */
public class EpollEventLoop extends SingleThreadEventLoop {
    private static final InternalLogger logger;
    private static final long EPOLL_WAIT_MILLIS_THRESHOLD;
    private final FileDescriptor epollFd;
    private final FileDescriptor eventFd;
    private final FileDescriptor timerFd;
    private final IntObjectMap<AbstractEpollChannel> channels;
    private final boolean allowGrowing;
    private final EpollEventArray events;
    private IovArray iovArray;
    private NativeDatagramPacketArray datagramPacketArray;
    private final SelectStrategy selectStrategy;
    private final IntSupplier selectNowSupplier;
    private static final long AWAKE = -1;
    private static final long NONE = Long.MAX_VALUE;
    private final AtomicLong nextWakeupNanos;
    private boolean pendingWakeup;
    private volatile int ioRatio;
    private static final long MAX_SCHEDULED_TIMERFD_NS = 999999999;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !EpollEventLoop.class.desiredAssertionStatus();
        logger = InternalLoggerFactory.getInstance(EpollEventLoop.class);
        EPOLL_WAIT_MILLIS_THRESHOLD = SystemPropertyUtil.getLong("io.netty.channel.epoll.epollWaitThreshold", 10);
        Epoll.ensureAvailability();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x00b1
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    EpollEventLoop(p013io.netty.channel.EventLoopGroup r9, java.util.concurrent.Executor r10, int r11, p013io.netty.channel.SelectStrategy r12, p013io.netty.util.concurrent.RejectedExecutionHandler r13, p013io.netty.channel.EventLoopTaskQueueFactory r14, p013io.netty.channel.EventLoopTaskQueueFactory r15) {
        /*
        // Method dump skipped, instructions count: 350
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.epoll.EpollEventLoop.<init>(io.netty.channel.EventLoopGroup, java.util.concurrent.Executor, int, io.netty.channel.SelectStrategy, io.netty.util.concurrent.RejectedExecutionHandler, io.netty.channel.EventLoopTaskQueueFactory, io.netty.channel.EventLoopTaskQueueFactory):void");
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory queueFactory) {
        if (queueFactory == null) {
            return newTaskQueue0(DEFAULT_MAX_PENDING_TASKS);
        }
        return queueFactory.newTaskQueue(DEFAULT_MAX_PENDING_TASKS);
    }

    /* access modifiers changed from: package-private */
    public IovArray cleanIovArray() {
        if (this.iovArray == null) {
            this.iovArray = new IovArray();
        } else {
            this.iovArray.clear();
        }
        return this.iovArray;
    }

    /* access modifiers changed from: package-private */
    public NativeDatagramPacketArray cleanDatagramPacketArray() {
        if (this.datagramPacketArray == null) {
            this.datagramPacketArray = new NativeDatagramPacketArray();
        } else {
            this.datagramPacketArray.clear();
        }
        return this.datagramPacketArray;
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void wakeup(boolean inEventLoop) {
        if (!inEventLoop && this.nextWakeupNanos.getAndSet(-1) != -1) {
            Native.eventFdWrite(this.eventFd.intValue(), 1);
        }
    }

    @Override // p013io.netty.util.concurrent.AbstractScheduledEventExecutor
    protected boolean beforeScheduledTaskSubmitted(long deadlineNanos) {
        return deadlineNanos < this.nextWakeupNanos.get();
    }

    @Override // p013io.netty.util.concurrent.AbstractScheduledEventExecutor
    protected boolean afterScheduledTaskSubmitted(long deadlineNanos) {
        return deadlineNanos < this.nextWakeupNanos.get();
    }

    /* access modifiers changed from: package-private */
    public void add(AbstractEpollChannel ch) throws IOException {
        if ($assertionsDisabled || inEventLoop()) {
            int fd = ch.socket.intValue();
            Native.epollCtlAdd(this.epollFd.intValue(), fd, ch.flags);
            AbstractEpollChannel old = this.channels.put(fd, (int) ch);
            if (!$assertionsDisabled && old != null && old.isOpen()) {
                throw new AssertionError();
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void modify(AbstractEpollChannel ch) throws IOException {
        if ($assertionsDisabled || inEventLoop()) {
            Native.epollCtlMod(this.epollFd.intValue(), ch.socket.intValue(), ch.flags);
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void remove(AbstractEpollChannel ch) throws IOException {
        if ($assertionsDisabled || inEventLoop()) {
            int fd = ch.socket.intValue();
            AbstractEpollChannel old = this.channels.remove(fd);
            if (old != null && old != ch) {
                this.channels.put(fd, (int) old);
                if (!$assertionsDisabled && ch.isOpen()) {
                    throw new AssertionError();
                }
            } else if (ch.isOpen()) {
                Native.epollCtlDel(this.epollFd.intValue(), fd);
            }
        } else {
            throw new AssertionError();
        }
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

    private long epollWait(long deadlineNanos) throws IOException {
        if (deadlineNanos == Long.MAX_VALUE) {
            return Native.epollWait(this.epollFd, this.events, this.timerFd, Integer.MAX_VALUE, 0, EPOLL_WAIT_MILLIS_THRESHOLD);
        }
        long totalDelay = deadlineToDelayNanos(deadlineNanos);
        int delaySeconds = (int) Math.min(totalDelay / 1000000000, 2147483647L);
        return Native.epollWait(this.epollFd, this.events, this.timerFd, delaySeconds, (int) Math.min(totalDelay - (((long) delaySeconds) * 1000000000), (long) MAX_SCHEDULED_TIMERFD_NS), EPOLL_WAIT_MILLIS_THRESHOLD);
    }

    private int epollWaitNoTimerChange() throws IOException {
        return Native.epollWait(this.epollFd, this.events, false);
    }

    /* access modifiers changed from: private */
    public int epollWaitNow() throws IOException {
        return Native.epollWait(this.epollFd, this.events, true);
    }

    private int epollBusyWait() throws IOException {
        return Native.epollBusyWait(this.epollFd, this.events);
    }

    private int epollWaitTimeboxed() throws IOException {
        return Native.epollWait(this.epollFd, this.events, 1000);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:63:0x0157
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        /*
        // Method dump skipped, instructions count: 602
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.epoll.EpollEventLoop.run():void");
    }

    void handleLoopException(Throwable t) {
        logger.warn("Unexpected exception in the selector loop.", t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    private void closeAll() {
        AbstractEpollChannel[] localChannels = (AbstractEpollChannel[]) this.channels.values().toArray(new AbstractEpollChannel[0]);
        for (AbstractEpollChannel ch : localChannels) {
            ch.unsafe().close(ch.unsafe().voidPromise());
        }
    }

    private boolean processReady(EpollEventArray events, int ready) {
        boolean timerFired = false;
        for (int i = 0; i < ready; i++) {
            int fd = events.m1182fd(i);
            if (fd == this.eventFd.intValue()) {
                this.pendingWakeup = false;
            } else if (fd == this.timerFd.intValue()) {
                timerFired = true;
            } else {
                long ev = (long) events.events(i);
                AbstractEpollChannel ch = this.channels.get(fd);
                if (ch != null) {
                    AbstractEpollChannel.AbstractEpollUnsafe unsafe = (AbstractEpollChannel.AbstractEpollUnsafe) ch.unsafe();
                    if ((ev & ((long) (Native.EPOLLERR | Native.EPOLLOUT))) != 0) {
                        unsafe.epollOutReady();
                    }
                    if ((ev & ((long) (Native.EPOLLERR | Native.EPOLLIN))) != 0) {
                        unsafe.epollInReady();
                    }
                    if ((ev & ((long) Native.EPOLLRDHUP)) != 0) {
                        unsafe.epollRdHupReady();
                    }
                } else {
                    try {
                        Native.epollCtlDel(this.epollFd.intValue(), fd);
                    } catch (IOException e) {
                    }
                }
            }
        }
        return timerFired;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x004b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        /*
        // Method dump skipped, instructions count: 228
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.epoll.EpollEventLoop.cleanup():void");
    }
}
