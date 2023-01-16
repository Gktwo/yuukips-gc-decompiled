package p013io.netty.util.concurrent;

import p013io.netty.util.concurrent.Future;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PromiseNotificationUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.concurrent.PromiseNotifier */
/* loaded from: grasscutter.jar:io/netty/util/concurrent/PromiseNotifier.class */
public class PromiseNotifier<V, F extends Future<V>> implements GenericFutureListener<F> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(PromiseNotifier.class);
    private final Promise<? super V>[] promises;
    private final boolean logNotifyFailure;

    @SafeVarargs
    public PromiseNotifier(Promise<? super V>... promises) {
        this(true, promises);
    }

    @SafeVarargs
    public PromiseNotifier(boolean logNotifyFailure, Promise<? super V>... promises) {
        ObjectUtil.checkNotNull(promises, "promises");
        for (Promise<? super V> promise : promises) {
            ObjectUtil.checkNotNullWithIAE(promise, "promise");
        }
        this.promises = (Promise[]) promises.clone();
        this.logNotifyFailure = logNotifyFailure;
    }

    public static <V, F extends Future<V>> F cascade(F future, Promise<? super V> promise) {
        return (F) cascade(true, future, promise);
    }

    public static <V, F extends Future<V>> F cascade(boolean logNotifyFailure, final F future, final Promise<? super V> promise) {
        promise.addListener((GenericFutureListener<? extends Future<? super Object>>) new FutureListener() { // from class: io.netty.util.concurrent.PromiseNotifier.1
            @Override // p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future f) {
                if (f.isCancelled()) {
                    future.cancel(false);
                }
            }
        });
        future.addListener(new PromiseNotifier(logNotifyFailure, new Promise[]{promise}) { // from class: io.netty.util.concurrent.PromiseNotifier.2
            /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.netty.util.concurrent.PromiseNotifier$2 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // p013io.netty.util.concurrent.PromiseNotifier, p013io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future f) throws Exception {
                if (!promise.isCancelled() || !f.isCancelled()) {
                    operationComplete(future);
                }
            }
        });
        return future;
    }

    @Override // p013io.netty.util.concurrent.GenericFutureListener
    public void operationComplete(F future) throws Exception {
        InternalLogger internalLogger = this.logNotifyFailure ? logger : null;
        if (future.isSuccess()) {
            Object obj = future.get();
            for (Promise<? super V> p : this.promises) {
                PromiseNotificationUtil.trySuccess(p, obj, internalLogger);
            }
        } else if (future.isCancelled()) {
            for (Promise<? super V> p2 : this.promises) {
                PromiseNotificationUtil.tryCancel(p2, internalLogger);
            }
        } else {
            Throwable cause = future.cause();
            for (Promise<? super V> p3 : this.promises) {
                PromiseNotificationUtil.tryFailure(p3, cause, internalLogger);
            }
        }
    }
}
