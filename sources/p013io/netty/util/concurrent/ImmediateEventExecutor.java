package p013io.netty.util.concurrent;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import org.quartz.jobs.NativeJob;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.ImmediateEventExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/ImmediateEventExecutor.class */
public final class ImmediateEventExecutor extends AbstractEventExecutor {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ImmediateEventExecutor.class);
    public static final ImmediateEventExecutor INSTANCE = new ImmediateEventExecutor();
    private static final FastThreadLocal<Queue<Runnable>> DELAYED_RUNNABLES = new FastThreadLocal<Queue<Runnable>>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.1
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.concurrent.FastThreadLocal
        public Queue<Runnable> initialValue() throws Exception {
            return new ArrayDeque();
        }
    };
    private static final FastThreadLocal<Boolean> RUNNING = new FastThreadLocal<Boolean>() { // from class: io.netty.util.concurrent.ImmediateEventExecutor.2
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.concurrent.FastThreadLocal
        public Boolean initialValue() throws Exception {
            return false;
        }
    };
    private final Future<?> terminationFuture = new FailedFuture(GlobalEventExecutor.INSTANCE, new UnsupportedOperationException());

    private ImmediateEventExecutor() {
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop() {
        return true;
    }

    @Override // p013io.netty.util.concurrent.EventExecutor
    public boolean inEventLoop(Thread thread) {
        return true;
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> shutdownGracefully(long quietPeriod, long timeout, TimeUnit unit) {
        return terminationFuture();
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public Future<?> terminationFuture() {
        return this.terminationFuture;
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    public void shutdown() {
    }

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    public boolean isShuttingDown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) {
        return false;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        ObjectUtil.checkNotNull(command, NativeJob.PROP_COMMAND);
        if (!RUNNING.get().booleanValue()) {
            RUNNING.set(true);
            try {
                command.run();
                Queue<Runnable> delayedRunnables = DELAYED_RUNNABLES.get();
                while (true) {
                    Runnable runnable = delayedRunnables.poll();
                    if (runnable != null) {
                        try {
                            runnable.run();
                        } catch (Throwable cause) {
                            logger.info("Throwable caught while executing Runnable {}", runnable, cause);
                        }
                    } else {
                        RUNNING.set(false);
                        return;
                    }
                }
            } catch (Throwable th) {
                Queue<Runnable> delayedRunnables2 = DELAYED_RUNNABLES.get();
                while (true) {
                    Runnable runnable2 = delayedRunnables2.poll();
                    if (runnable2 == null) {
                        break;
                    }
                    try {
                        runnable2.run();
                    } catch (Throwable cause2) {
                        logger.info("Throwable caught while executing Runnable {}", runnable2, cause2);
                    }
                }
                RUNNING.set(false);
                throw th;
            }
        } else {
            DELAYED_RUNNABLES.get().add(command);
        }
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor
    public <V> Promise<V> newPromise() {
        return new ImmediatePromise(this);
    }

    @Override // p013io.netty.util.concurrent.AbstractEventExecutor, p013io.netty.util.concurrent.EventExecutor
    public <V> ProgressivePromise<V> newProgressivePromise() {
        return new ImmediateProgressivePromise(this);
    }

    /* renamed from: io.netty.util.concurrent.ImmediateEventExecutor$ImmediatePromise */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/ImmediateEventExecutor$ImmediatePromise.class */
    static class ImmediatePromise<V> extends DefaultPromise<V> {
        ImmediatePromise(EventExecutor executor) {
            super(executor);
        }

        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }

    /* renamed from: io.netty.util.concurrent.ImmediateEventExecutor$ImmediateProgressivePromise */
    /* loaded from: grasscutter.jar:io/netty/util/concurrent/ImmediateEventExecutor$ImmediateProgressivePromise.class */
    static class ImmediateProgressivePromise<V> extends DefaultProgressivePromise<V> {
        ImmediateProgressivePromise(EventExecutor executor) {
            super(executor);
        }

        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.concurrent.DefaultPromise
        public void checkDeadLock() {
        }
    }
}
