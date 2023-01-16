package p013io.netty.util.internal;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import org.quartz.jobs.NativeJob;
import p013io.netty.util.concurrent.EventExecutor;
import p013io.netty.util.concurrent.FastThreadLocal;

/* renamed from: io.netty.util.internal.ThreadExecutorMap */
/* loaded from: grasscutter.jar:io/netty/util/internal/ThreadExecutorMap.class */
public final class ThreadExecutorMap {
    private static final FastThreadLocal<EventExecutor> mappings = new FastThreadLocal<>();

    private ThreadExecutorMap() {
    }

    public static EventExecutor currentExecutor() {
        return mappings.get();
    }

    /* access modifiers changed from: private */
    public static void setCurrentEventExecutor(EventExecutor executor) {
        mappings.set(executor);
    }

    public static Executor apply(final Executor executor, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(executor, "executor");
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new Executor() { // from class: io.netty.util.internal.ThreadExecutorMap.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable command) {
                executor.execute(ThreadExecutorMap.apply(command, eventExecutor));
            }
        };
    }

    public static Runnable apply(final Runnable command, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(command, NativeJob.PROP_COMMAND);
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new Runnable() { // from class: io.netty.util.internal.ThreadExecutorMap.2
            @Override // java.lang.Runnable
            public void run() {
                ThreadExecutorMap.setCurrentEventExecutor(eventExecutor);
                try {
                    command.run();
                    ThreadExecutorMap.setCurrentEventExecutor(null);
                } catch (Throwable th) {
                    ThreadExecutorMap.setCurrentEventExecutor(null);
                    throw th;
                }
            }
        };
    }

    public static ThreadFactory apply(final ThreadFactory threadFactory, final EventExecutor eventExecutor) {
        ObjectUtil.checkNotNull(threadFactory, NativeJob.PROP_COMMAND);
        ObjectUtil.checkNotNull(eventExecutor, "eventExecutor");
        return new ThreadFactory() { // from class: io.netty.util.internal.ThreadExecutorMap.3
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable r) {
                return threadFactory.newThread(ThreadExecutorMap.apply(r, eventExecutor));
            }
        };
    }
}
