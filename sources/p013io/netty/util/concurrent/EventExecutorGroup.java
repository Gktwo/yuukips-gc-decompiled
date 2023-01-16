package p013io.netty.util.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* renamed from: io.netty.util.concurrent.EventExecutorGroup */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/EventExecutorGroup.class */
public interface EventExecutorGroup extends ScheduledExecutorService, Iterable<EventExecutor> {
    boolean isShuttingDown();

    Future<?> shutdownGracefully();

    Future<?> shutdownGracefully(long j, long j2, TimeUnit timeUnit);

    Future<?> terminationFuture();

    @Override // java.util.concurrent.ExecutorService
    @Deprecated
    void shutdown();

    @Override // p013io.netty.util.concurrent.EventExecutorGroup
    @Deprecated
    List<Runnable> shutdownNow();

    @Override // p013io.netty.channel.EventLoopGroup
    EventExecutor next();

    @Override // java.lang.Iterable
    Iterator<EventExecutor> iterator();

    @Override // java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    Future<?> submit(Runnable runnable);

    @Override // java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    <T> Future<T> submit(Runnable runnable, T t);

    @Override // java.util.concurrent.ExecutorService, p013io.netty.util.concurrent.EventExecutorGroup
    <T> Future<T> submit(Callable<T> callable);

    @Override // java.util.concurrent.ScheduledExecutorService
    ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    @Override // java.util.concurrent.ScheduledExecutorService
    ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit);
}
