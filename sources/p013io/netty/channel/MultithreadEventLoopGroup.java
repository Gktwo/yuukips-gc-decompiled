package p013io.netty.channel;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import p013io.netty.util.NettyRuntime;
import p013io.netty.util.concurrent.DefaultThreadFactory;
import p013io.netty.util.concurrent.EventExecutorChooserFactory;
import p013io.netty.util.concurrent.MultithreadEventExecutorGroup;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.MultithreadEventLoopGroup */
/* loaded from: grasscutter.jar:io/netty/channel/MultithreadEventLoopGroup.class */
public abstract class MultithreadEventLoopGroup extends MultithreadEventExecutorGroup implements EventLoopGroup {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(MultithreadEventLoopGroup.class);
    private static final int DEFAULT_EVENT_LOOP_THREADS = Math.max(1, SystemPropertyUtil.getInt("io.netty.eventLoopThreads", NettyRuntime.availableProcessors() * 2));

    /* access modifiers changed from: protected */
    @Override // p013io.netty.util.concurrent.MultithreadEventExecutorGroup
    public abstract EventLoop newChild(Executor executor, Object... objArr) throws Exception;

    static {
        if (logger.isDebugEnabled()) {
            logger.debug("-Dio.netty.eventLoopThreads: {}", Integer.valueOf(DEFAULT_EVENT_LOOP_THREADS));
        }
    }

    /* access modifiers changed from: protected */
    public MultithreadEventLoopGroup(int nThreads, Executor executor, Object... args) {
        super(nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads, executor, args);
    }

    /* access modifiers changed from: protected */
    public MultithreadEventLoopGroup(int nThreads, ThreadFactory threadFactory, Object... args) {
        super(nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads, threadFactory, args);
    }

    /* access modifiers changed from: protected */
    public MultithreadEventLoopGroup(int nThreads, Executor executor, EventExecutorChooserFactory chooserFactory, Object... args) {
        super(nThreads == 0 ? DEFAULT_EVENT_LOOP_THREADS : nThreads, executor, chooserFactory, args);
    }

    @Override // p013io.netty.util.concurrent.MultithreadEventExecutorGroup
    protected ThreadFactory newDefaultThreadFactory() {
        return new DefaultThreadFactory(getClass(), 10);
    }

    @Override // p013io.netty.util.concurrent.MultithreadEventExecutorGroup, p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    public EventLoop next() {
        return (EventLoop) next();
    }

    @Override // p013io.netty.channel.EventLoopGroup
    public ChannelFuture register(Channel channel) {
        return next().register(channel);
    }

    @Override // p013io.netty.channel.EventLoopGroup
    public ChannelFuture register(ChannelPromise promise) {
        return next().register(promise);
    }

    @Override // p013io.netty.channel.EventLoopGroup
    @Deprecated
    public ChannelFuture register(Channel channel, ChannelPromise promise) {
        return next().register(channel, promise);
    }
}
