package p013io.netty.util.concurrent;

/* renamed from: io.netty.util.concurrent.RejectedExecutionHandler */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/RejectedExecutionHandler.class */
public interface RejectedExecutionHandler {
    void rejected(Runnable runnable, SingleThreadEventExecutor singleThreadEventExecutor);
}
