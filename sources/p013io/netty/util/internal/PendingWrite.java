package p013io.netty.util.internal;

import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.concurrent.Promise;
import p013io.netty.util.internal.ObjectPool;

/* renamed from: io.netty.util.internal.PendingWrite */
/* loaded from: grasscutter.jar:io/netty/util/internal/PendingWrite.class */
public final class PendingWrite {
    private static final ObjectPool<PendingWrite> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PendingWrite>() { // from class: io.netty.util.internal.PendingWrite.1
        @Override // p013io.netty.util.internal.ObjectPool.ObjectCreator
        public PendingWrite newObject(ObjectPool.Handle<PendingWrite> handle) {
            return new PendingWrite(handle);
        }
    });
    private final ObjectPool.Handle<PendingWrite> handle;
    private Object msg;
    private Promise<Void> promise;

    public static PendingWrite newInstance(Object msg, Promise<Void> promise) {
        PendingWrite pending = RECYCLER.get();
        pending.msg = msg;
        pending.promise = promise;
        return pending;
    }

    private PendingWrite(ObjectPool.Handle<PendingWrite> handle) {
        this.handle = handle;
    }

    public boolean recycle() {
        this.msg = null;
        this.promise = null;
        this.handle.recycle(this);
        return true;
    }

    public boolean failAndRecycle(Throwable cause) {
        ReferenceCountUtil.release(this.msg);
        if (this.promise != null) {
            this.promise.setFailure(cause);
        }
        return recycle();
    }

    public boolean successAndRecycle() {
        if (this.promise != null) {
            this.promise.setSuccess(null);
        }
        return recycle();
    }

    public Object msg() {
        return this.msg;
    }

    public Promise<Void> promise() {
        return this.promise;
    }

    public Promise<Void> recycleAndGet() {
        Promise<Void> promise = this.promise;
        recycle();
        return promise;
    }
}
