package p013io.netty.util.concurrent;

import p013io.netty.util.concurrent.ProgressiveFuture;

/* renamed from: io.netty.util.concurrent.GenericProgressiveFutureListener */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/GenericProgressiveFutureListener.class */
public interface GenericProgressiveFutureListener<F extends ProgressiveFuture<?>> extends GenericFutureListener<F> {
    void operationProgressed(F f, long j, long j2) throws Exception;
}
