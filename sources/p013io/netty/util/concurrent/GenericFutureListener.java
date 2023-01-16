package p013io.netty.util.concurrent;

import java.util.EventListener;
import p013io.netty.util.concurrent.Future;

/* renamed from: io.netty.util.concurrent.GenericFutureListener */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/GenericFutureListener.class */
public interface GenericFutureListener<F extends Future<?>> extends EventListener {
    void operationComplete(F f) throws Exception;
}
