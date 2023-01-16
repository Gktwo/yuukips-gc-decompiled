package p013io.netty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.util.concurrent.ThreadPerTaskExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/ThreadPerTaskExecutor.class */
public final class ThreadPerTaskExecutor implements Executor {
    private final ThreadFactory threadFactory;

    public ThreadPerTaskExecutor(ThreadFactory threadFactory) {
        this.threadFactory = (ThreadFactory) ObjectUtil.checkNotNull(threadFactory, "threadFactory");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        this.threadFactory.newThread(command).start();
    }
}
