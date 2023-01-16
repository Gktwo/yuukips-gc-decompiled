package p013io.netty.channel;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import p013io.netty.util.concurrent.DefaultThreadFactory;

/* renamed from: io.netty.channel.DefaultEventLoop */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultEventLoop.class */
public class DefaultEventLoop extends SingleThreadEventLoop {
    public DefaultEventLoop() {
        this((EventLoopGroup) null);
    }

    public DefaultEventLoop(ThreadFactory threadFactory) {
        this((EventLoopGroup) null, threadFactory);
    }

    public DefaultEventLoop(Executor executor) {
        this((EventLoopGroup) null, executor);
    }

    public DefaultEventLoop(EventLoopGroup parent) {
        this(parent, new DefaultThreadFactory(DefaultEventLoop.class));
    }

    public DefaultEventLoop(EventLoopGroup parent, ThreadFactory threadFactory) {
        super(parent, threadFactory, true);
    }

    public DefaultEventLoop(EventLoopGroup parent, Executor executor) {
        super(parent, executor, true);
    }

    @Override // p013io.netty.util.concurrent.SingleThreadEventExecutor
    protected void run() {
        do {
            Runnable task = takeTask();
            if (task != null) {
                runTask(task);
                updateLastExecutionTime();
            }
        } while (!confirmShutdown());
    }
}
