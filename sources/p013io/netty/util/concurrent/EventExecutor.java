package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.EventExecutor */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/EventExecutor.class */
public interface EventExecutor extends EventExecutorGroup {
    @Override // p013io.netty.util.concurrent.EventExecutorGroup, p013io.netty.channel.EventLoopGroup
    EventExecutor next();

    @Override // p013io.netty.channel.EventLoop
    EventExecutorGroup parent();

    boolean inEventLoop();

    boolean inEventLoop(Thread thread);

    <V> Promise<V> newPromise();

    <V> ProgressivePromise<V> newProgressivePromise();

    <V> Future<V> newSucceededFuture(V v);

    <V> Future<V> newFailedFuture(Throwable th);
}
