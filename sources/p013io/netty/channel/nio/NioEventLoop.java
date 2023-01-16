package p013io.netty.channel.nio;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import p013io.netty.channel.ChannelException;
import p013io.netty.channel.EventLoopException;
import p013io.netty.channel.EventLoopTaskQueueFactory;
import p013io.netty.channel.SelectStrategy;
import p013io.netty.channel.SingleThreadEventLoop;
import p013io.netty.channel.nio.AbstractNioChannel;
import p013io.netty.util.IntSupplier;
import p013io.netty.util.concurrent.RejectedExecutionHandler;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.ReflectionUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.nio.NioEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/nio/NioEventLoop.class */
public final class NioEventLoop extends SingleThreadEventLoop {
    private static final int CLEANUP_INTERVAL = 256;
    private static final int MIN_PREMATURE_SELECTOR_RETURNS = 3;
    private static final int SELECTOR_AUTO_REBUILD_THRESHOLD;
    private Selector selector;
    private Selector unwrappedSelector;
    private SelectedSelectionKeySet selectedKeys;
    private final SelectorProvider provider;
    private static final long AWAKE = -1;
    private static final long NONE = Long.MAX_VALUE;
    private final SelectStrategy selectStrategy;
    private int cancelledKeys;
    private boolean needsToSelectAgain;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NioEventLoop.class);
    private static final boolean DISABLE_KEY_SET_OPTIMIZATION = SystemPropertyUtil.getBoolean("io.netty.noKeySetOptimization", false);
    private final IntSupplier selectNowSupplier = new IntSupplier() { // from class: io.netty.channel.nio.NioEventLoop.1
        @Override // p013io.netty.util.IntSupplier
        public int get() throws Exception {
            return NioEventLoop.this.selectNow();
        }
    };
    private final AtomicLong nextWakeupNanos = new AtomicLong(-1);
    private volatile int ioRatio = 50;

    static {
        if (PlatformDependent.javaVersion() < 7 && SystemPropertyUtil.get("sun.nio.ch.bugLevel") == null) {
            try {
                AccessController.doPrivileged(new PrivilegedAction<Void>() { // from class: io.netty.channel.nio.NioEventLoop.2
                    @Override // java.security.PrivilegedAction
                    public Void run() {
                        System.setProperty("sun.nio.ch.bugLevel", "");
                        return null;
                    }
                });
            } catch (SecurityException e) {
                logger.debug("Unable to get/set System Property: sun.nio.ch.bugLevel", (Throwable) e);
            }
        }
        int selectorAutoRebuildThreshold = SystemPropertyUtil.getInt("io.netty.selectorAutoRebuildThreshold", 512);
        if (selectorAutoRebuildThreshold < 3) {
            selectorAutoRebuildThreshold = 0;
        }
        SELECTOR_AUTO_REBUILD_THRESHOLD = selectorAutoRebuildThreshold;
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.noKeySetOptimization: {}", Boolean.valueOf(DISABLE_KEY_SET_OPTIMIZATION));
            logger.debug("-Dio.netty.selectorAutoRebuildThreshold: {}", Integer.valueOf(SELECTOR_AUTO_REBUILD_THRESHOLD));
        }
    }

    /* access modifiers changed from: package-private */
    public NioEventLoop(NioEventLoopGroup parent, Executor executor, SelectorProvider selectorProvider, SelectStrategy strategy, RejectedExecutionHandler rejectedExecutionHandler, EventLoopTaskQueueFactory taskQueueFactory, EventLoopTaskQueueFactory tailTaskQueueFactory) {
        super(parent, executor, false, newTaskQueue(taskQueueFactory), newTaskQueue(tailTaskQueueFactory), rejectedExecutionHandler);
        this.provider = (SelectorProvider) ObjectUtil.checkNotNull(selectorProvider, "selectorProvider");
        this.selectStrategy = (SelectStrategy) ObjectUtil.checkNotNull(strategy, "selectStrategy");
        SelectorTuple selectorTuple = openSelector();
        this.selector = selectorTuple.selector;
        this.unwrappedSelector = selectorTuple.unwrappedSelector;
    }

    private static Queue<Runnable> newTaskQueue(EventLoopTaskQueueFactory queueFactory) {
        if (queueFactory == null) {
            return newTaskQueue0(DEFAULT_MAX_PENDING_TASKS);
        }
        return queueFactory.newTaskQueue(DEFAULT_MAX_PENDING_TASKS);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.nio.NioEventLoop$SelectorTuple */
    /* loaded from: grasscutter.jar:io/netty/channel/nio/NioEventLoop$SelectorTuple.class */
    public static final class SelectorTuple {
        final Selector unwrappedSelector;
        final Selector selector;

        SelectorTuple(Selector unwrappedSelector) {
            this.unwrappedSelector = unwrappedSelector;
            this.selector = unwrappedSelector;
        }

        SelectorTuple(Selector unwrappedSelector, Selector selector) {
            this.unwrappedSelector = unwrappedSelector;
            this.selector = selector;
        }
    }

    private SelectorTuple openSelector() {
        try {
            final Selector unwrappedSelector = this.provider.openSelector();
            if (DISABLE_KEY_SET_OPTIMIZATION) {
                return new SelectorTuple(unwrappedSelector);
            }
            Object maybeSelectorImplClass = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        return Class.forName("sun.nio.ch.SelectorImpl", false, PlatformDependent.getSystemClassLoader());
                    } catch (Throwable cause) {
                        return cause;
                    }
                }
            });
            if (!(maybeSelectorImplClass instanceof Class) || !((Class) maybeSelectorImplClass).isAssignableFrom(unwrappedSelector.getClass())) {
                if (maybeSelectorImplClass instanceof Throwable) {
                    logger.trace("failed to instrument a special java.util.Set into: {}", unwrappedSelector, (Throwable) maybeSelectorImplClass);
                }
                return new SelectorTuple(unwrappedSelector);
            }
            final Class<?> selectorImplClass = (Class) maybeSelectorImplClass;
            final SelectedSelectionKeySet selectedKeySet = new SelectedSelectionKeySet();
            Object maybeException = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.channel.nio.NioEventLoop.4
                @Override // java.security.PrivilegedAction
                public Object run() {
                    try {
                        Field selectedKeysField = selectorImplClass.getDeclaredField("selectedKeys");
                        Field publicSelectedKeysField = selectorImplClass.getDeclaredField("publicSelectedKeys");
                        if (PlatformDependent.javaVersion() >= 9 && PlatformDependent.hasUnsafe()) {
                            long selectedKeysFieldOffset = PlatformDependent.objectFieldOffset(selectedKeysField);
                            long publicSelectedKeysFieldOffset = PlatformDependent.objectFieldOffset(publicSelectedKeysField);
                            if (!(selectedKeysFieldOffset == -1 || publicSelectedKeysFieldOffset == -1)) {
                                PlatformDependent.putObject(unwrappedSelector, selectedKeysFieldOffset, selectedKeySet);
                                PlatformDependent.putObject(unwrappedSelector, publicSelectedKeysFieldOffset, selectedKeySet);
                                return null;
                            }
                        }
                        Throwable cause = ReflectionUtil.trySetAccessible(selectedKeysField, true);
                        if (cause != null) {
                            return cause;
                        }
                        Throwable cause2 = ReflectionUtil.trySetAccessible(publicSelectedKeysField, true);
                        if (cause2 != null) {
                            return cause2;
                        }
                        selectedKeysField.set(unwrappedSelector, selectedKeySet);
                        publicSelectedKeysField.set(unwrappedSelector, selectedKeySet);
                        return null;
                    } catch (IllegalAccessException e) {
                        return e;
                    } catch (NoSuchFieldException e2) {
                        return e2;
                    }
                }
            });
            if (maybeException instanceof Exception) {
                this.selectedKeys = null;
                logger.trace("failed to instrument a special java.util.Set into: {}", unwrappedSelector, (Exception) maybeException);
                return new SelectorTuple(unwrappedSelector);
            }
            this.selectedKeys = selectedKeySet;
            logger.trace("instrumented a special java.util.Set into: {}", unwrappedSelector);
            return new SelectorTuple(unwrappedSelector, new SelectedSelectionKeySetSelector(unwrappedSelector, selectedKeySet));
        } catch (IOException e) {
            throw new ChannelException("failed to open a new selector", e);
        }
    }

    public SelectorProvider selectorProvider() {
        return this.provider;
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected Queue<Runnable> newTaskQueue(int maxPendingTasks) {
        return newTaskQueue0(maxPendingTasks);
    }

    private static Queue<Runnable> newTaskQueue0(int maxPendingTasks) {
        return maxPendingTasks == Integer.MAX_VALUE ? PlatformDependent.newMpscQueue() : PlatformDependent.newMpscQueue(maxPendingTasks);
    }

    public void register(final SelectableChannel ch, final int interestOps, final NioTask<?> task) {
        ObjectUtil.checkNotNull(ch, "ch");
        if (interestOps == 0) {
            throw new IllegalArgumentException("interestOps must be non-zero.");
        } else if ((interestOps & (ch.validOps() ^ -1)) != 0) {
            throw new IllegalArgumentException("invalid interestOps: " + interestOps + "(validOps: " + ch.validOps() + ')');
        } else {
            ObjectUtil.checkNotNull(task, "task");
            if (isShutdown()) {
                throw new IllegalStateException("event loop shut down");
            } else if (inEventLoop()) {
                register0(ch, interestOps, task);
            } else {
                try {
                    submit((Runnable) new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NioEventLoop.this.register0(ch, interestOps, task);
                        }
                    }).sync();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void register0(SelectableChannel ch, int interestOps, NioTask<?> task) {
        try {
            ch.register(this.unwrappedSelector, interestOps, task);
        } catch (Exception e) {
            throw new EventLoopException("failed to register a channel", e);
        }
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

    public void rebuildSelector() {
        if (!inEventLoop()) {
            execute(new Runnable() { // from class: io.netty.channel.nio.NioEventLoop.6
                @Override // java.lang.Runnable
                public void run() {
                    NioEventLoop.this.rebuildSelector0();
                }
            });
        } else {
            rebuildSelector0();
        }
    }

    @Override // p013io.netty.channel.SingleThreadEventLoop
    public int registeredChannels() {
        return this.selector.keys().size() - this.cancelledKeys;
    }

    /* access modifiers changed from: private */
    public void rebuildSelector0() {
        Selector oldSelector = this.selector;
        if (oldSelector != null) {
            try {
                SelectorTuple newSelectorTuple = openSelector();
                int nChannels = 0;
                for (SelectionKey key : oldSelector.keys()) {
                    Object a = key.attachment();
                    try {
                        if (key.isValid() && key.channel().keyFor(newSelectorTuple.unwrappedSelector) == null) {
                            int interestOps = key.interestOps();
                            key.cancel();
                            SelectionKey newKey = key.channel().register(newSelectorTuple.unwrappedSelector, interestOps, a);
                            if (a instanceof AbstractNioChannel) {
                                ((AbstractNioChannel) a).selectionKey = newKey;
                            }
                            nChannels++;
                        }
                    } catch (Exception e) {
                        logger.warn("Failed to re-register a Channel to the new Selector.", (Throwable) e);
                        if (a instanceof AbstractNioChannel) {
                            AbstractNioChannel ch = (AbstractNioChannel) a;
                            ch.unsafe().close(ch.unsafe().voidPromise());
                        } else {
                            invokeChannelUnregistered((NioTask) a, key, e);
                        }
                    }
                }
                this.selector = newSelectorTuple.selector;
                this.unwrappedSelector = newSelectorTuple.unwrappedSelector;
                try {
                    oldSelector.close();
                } catch (Throwable t) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("Failed to close the old Selector.", t);
                    }
                }
                if (logger.isInfoEnabled()) {
                    logger.info("Migrated " + nChannels + " channel(s) to the new Selector.");
                }
            } catch (Exception e2) {
                logger.warn("Failed to create a new Selector.", (Throwable) e2);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:60:0x0126
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        /*
        // Method dump skipped, instructions count: 591
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.nio.NioEventLoop.run():void");
    }

    private boolean unexpectedSelectorWakeup(int selectCnt) {
        if (Thread.interrupted()) {
            if (!logger.isDebugEnabled()) {
                return true;
            }
            logger.debug("Selector.select() returned prematurely because Thread.currentThread().interrupt() was called. Use NioEventLoop.shutdownGracefully() to shutdown the NioEventLoop.");
            return true;
        } else if (SELECTOR_AUTO_REBUILD_THRESHOLD <= 0 || selectCnt < SELECTOR_AUTO_REBUILD_THRESHOLD) {
            return false;
        } else {
            logger.warn("Selector.select() returned prematurely {} times in a row; rebuilding Selector {}.", Integer.valueOf(selectCnt), this.selector);
            rebuildSelector();
            return true;
        }
    }

    private static void handleLoopException(Throwable t) {
        logger.warn("Unexpected exception in the selector loop.", t);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }

    private void processSelectedKeys() {
        if (this.selectedKeys != null) {
            processSelectedKeysOptimized();
        } else {
            processSelectedKeysPlain(this.selector.selectedKeys());
        }
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void cleanup() {
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("Failed to close a selector.", (Throwable) e);
        }
    }

    /* access modifiers changed from: package-private */
    public void cancel(SelectionKey key) {
        key.cancel();
        this.cancelledKeys++;
        if (this.cancelledKeys >= 256) {
            this.cancelledKeys = 0;
            this.needsToSelectAgain = true;
        }
    }

    private void processSelectedKeysPlain(Set<SelectionKey> selectedKeys) {
        if (!selectedKeys.isEmpty()) {
            Iterator<SelectionKey> i = selectedKeys.iterator();
            while (true) {
                SelectionKey k = i.next();
                Object a = k.attachment();
                i.remove();
                if (a instanceof AbstractNioChannel) {
                    processSelectedKey(k, (AbstractNioChannel) a);
                } else {
                    processSelectedKey(k, (NioTask) a);
                }
                if (i.hasNext()) {
                    if (this.needsToSelectAgain) {
                        selectAgain();
                        Set<SelectionKey> selectedKeys2 = this.selector.selectedKeys();
                        if (!selectedKeys2.isEmpty()) {
                            i = selectedKeys2.iterator();
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void processSelectedKeysOptimized() {
        int i = 0;
        while (i < this.selectedKeys.size) {
            SelectionKey k = this.selectedKeys.keys[i];
            this.selectedKeys.keys[i] = null;
            Object a = k.attachment();
            if (a instanceof AbstractNioChannel) {
                processSelectedKey(k, (AbstractNioChannel) a);
            } else {
                processSelectedKey(k, (NioTask) a);
            }
            if (this.needsToSelectAgain) {
                this.selectedKeys.reset(i + 1);
                selectAgain();
                i = -1;
            }
            i++;
        }
    }

    private void processSelectedKey(SelectionKey k, AbstractNioChannel ch) {
        AbstractNioChannel.NioUnsafe unsafe = ch.unsafe();
        if (!k.isValid()) {
            try {
                if (ch.eventLoop() == this) {
                    unsafe.close(unsafe.voidPromise());
                }
            } catch (Throwable th) {
            }
        } else {
            try {
                int readyOps = k.readyOps();
                if ((readyOps & 8) != 0) {
                    k.interestOps(k.interestOps() & -9);
                    unsafe.finishConnect();
                }
                if ((readyOps & 4) != 0) {
                    ch.unsafe().forceFlush();
                }
                if ((readyOps & 17) != 0 || readyOps == 0) {
                    unsafe.read();
                }
            } catch (CancelledKeyException e) {
                unsafe.close(unsafe.voidPromise());
            }
        }
    }

    private static void processSelectedKey(SelectionKey k, NioTask<SelectableChannel> task) {
        int state;
        try {
            state = 0;
            try {
                task.channelReady(k.channel(), k);
                state = 1;
                switch (1) {
                    case 0:
                        k.cancel();
                        invokeChannelUnregistered(task, k, null);
                        return;
                    case 1:
                        if (!k.isValid()) {
                            invokeChannelUnregistered(task, k, null);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                k.cancel();
                invokeChannelUnregistered(task, k, e);
                switch (2) {
                    case 0:
                        k.cancel();
                        invokeChannelUnregistered(task, k, null);
                        return;
                    case 1:
                        if (!k.isValid()) {
                            invokeChannelUnregistered(task, k, null);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            switch (state) {
                case 0:
                    k.cancel();
                    invokeChannelUnregistered(task, k, null);
                    break;
                case 1:
                    if (!k.isValid()) {
                        invokeChannelUnregistered(task, k, null);
                        break;
                    }
                    break;
            }
            throw th;
        }
    }

    private void closeAll() {
        selectAgain();
        Set<SelectionKey> keys = this.selector.keys();
        Collection<AbstractNioChannel> channels = new ArrayList<>(keys.size());
        for (SelectionKey k : keys) {
            Object a = k.attachment();
            if (a instanceof AbstractNioChannel) {
                channels.add((AbstractNioChannel) a);
            } else {
                k.cancel();
                invokeChannelUnregistered((NioTask) a, k, null);
            }
        }
        for (AbstractNioChannel ch : channels) {
            ch.unsafe().close(ch.unsafe().voidPromise());
        }
    }

    private static void invokeChannelUnregistered(NioTask<SelectableChannel> task, SelectionKey k, Throwable cause) {
        try {
            task.channelUnregistered(k.channel(), cause);
        } catch (Exception e) {
            logger.warn("Unexpected exception while running NioTask.channelUnregistered()", (Throwable) e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    public void wakeup(boolean inEventLoop) {
        if (!inEventLoop && this.nextWakeupNanos.getAndSet(-1) != -1) {
            this.selector.wakeup();
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
    public Selector unwrappedSelector() {
        return this.unwrappedSelector;
    }

    /* access modifiers changed from: package-private */
    public int selectNow() throws IOException {
        return this.selector.selectNow();
    }

    private int select(long deadlineNanos) throws IOException {
        if (deadlineNanos == Long.MAX_VALUE) {
            return this.selector.select();
        }
        long timeoutMillis = deadlineToDelayNanos(deadlineNanos + 995000) / 1000000;
        return timeoutMillis <= 0 ? this.selector.selectNow() : this.selector.select(timeoutMillis);
    }

    private void selectAgain() {
        this.needsToSelectAgain = false;
        try {
            this.selector.selectNow();
        } catch (Throwable t) {
            logger.warn("Failed to update SelectionKeys.", t);
        }
    }
}
