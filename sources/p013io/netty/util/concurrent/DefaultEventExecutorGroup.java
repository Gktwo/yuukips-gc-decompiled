package p013io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

/* renamed from: io.netty.util.concurrent.DefaultEventExecutorGroup */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/DefaultEventExecutorGroup.class */
public class DefaultEventExecutorGroup extends MultithreadEventExecutorGroup {
    public DefaultEventExecutorGroup(int nThreads) {
        this(nThreads, null);
    }

    public DefaultEventExecutorGroup(int nThreads, ThreadFactory threadFactory) {
        this(nThreads, threadFactory, SingleThreadEventExecutor.DEFAULT_MAX_PENDING_EXECUTOR_TASKS, RejectedExecutionHandlers.reject());
    }

    public DefaultEventExecutorGroup(int nThreads, ThreadFactory threadFactory, int maxPendingTasks, RejectedExecutionHandler rejectedHandler) {
        super(nThreads, threadFactory, Integer.valueOf(maxPendingTasks), rejectedHandler);
    }

    @Override // p013io.netty.util.concurrent.MultithreadEventExecutorGroup
    protected EventExecutor newChild(Executor executor, Object... args) throws Exception {
        return new DefaultEventExecutor(this, executor, ((Integer) args[0]).intValue(), (RejectedExecutionHandler) args[1]);
    }
}
