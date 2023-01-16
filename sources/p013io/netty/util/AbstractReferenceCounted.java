package p013io.netty.util;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p013io.netty.util.internal.ReferenceCountUpdater;

/* renamed from: io.netty.util.AbstractReferenceCounted */
/* loaded from: grasscutter.jar:io/netty/util/AbstractReferenceCounted.class */
public abstract class AbstractReferenceCounted implements ReferenceCounted {
    private static final long REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCounted.class, "refCnt");
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCounted> AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCounted.class, "refCnt");
    private static final ReferenceCountUpdater<AbstractReferenceCounted> updater = new ReferenceCountUpdater<AbstractReferenceCounted>() { // from class: io.netty.util.AbstractReferenceCounted.1
        @Override // p013io.netty.util.internal.ReferenceCountUpdater
        protected AtomicIntegerFieldUpdater<AbstractReferenceCounted> updater() {
            return AbstractReferenceCounted.AIF_UPDATER;
        }

        @Override // p013io.netty.util.internal.ReferenceCountUpdater
        protected long unsafeOffset() {
            return AbstractReferenceCounted.REFCNT_FIELD_OFFSET;
        }
    };
    private volatile int refCnt = updater.initialValue();

    protected abstract void deallocate();

    @Override // p013io.netty.util.ReferenceCounted
    public int refCnt() {
        return updater.refCnt(this);
    }

    protected final void setRefCnt(int refCnt) {
        updater.setRefCnt(this, refCnt);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public ReferenceCounted retain() {
        return updater.retain(this);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public ReferenceCounted retain(int increment) {
        return updater.retain(this, increment);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public ReferenceCounted touch() {
        return touch(null);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release() {
        return handleRelease(updater.release(this));
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        return handleRelease(updater.release(this, decrement));
    }

    private boolean handleRelease(boolean result) {
        if (result) {
            deallocate();
        }
        return result;
    }
}
