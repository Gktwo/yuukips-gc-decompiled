package p013io.netty.buffer;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import p013io.netty.util.internal.ReferenceCountUpdater;

/* renamed from: io.netty.buffer.AbstractReferenceCountedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/AbstractReferenceCountedByteBuf.class */
public abstract class AbstractReferenceCountedByteBuf extends AbstractByteBuf {
    private static final long REFCNT_FIELD_OFFSET = ReferenceCountUpdater.getUnsafeOffset(AbstractReferenceCountedByteBuf.class, "refCnt");
    private static final AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> AIF_UPDATER = AtomicIntegerFieldUpdater.newUpdater(AbstractReferenceCountedByteBuf.class, "refCnt");
    private static final ReferenceCountUpdater<AbstractReferenceCountedByteBuf> updater = new ReferenceCountUpdater<AbstractReferenceCountedByteBuf>() { // from class: io.netty.buffer.AbstractReferenceCountedByteBuf.1
        @Override // p013io.netty.util.internal.ReferenceCountUpdater
        protected AtomicIntegerFieldUpdater<AbstractReferenceCountedByteBuf> updater() {
            return AbstractReferenceCountedByteBuf.AIF_UPDATER;
        }

        @Override // p013io.netty.util.internal.ReferenceCountUpdater
        protected long unsafeOffset() {
            return AbstractReferenceCountedByteBuf.REFCNT_FIELD_OFFSET;
        }
    };
    private volatile int refCnt;

    protected abstract void deallocate();

    /* access modifiers changed from: protected */
    public AbstractReferenceCountedByteBuf(int maxCapacity) {
        super(maxCapacity);
        updater.setInitialValue(this);
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.netty.buffer.ByteBuf
    public boolean isAccessible() {
        return updater.isLiveNonVolatile(this);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public int refCnt() {
        return updater.refCnt(this);
    }

    protected final void setRefCnt(int refCnt) {
        updater.setRefCnt(this, refCnt);
    }

    protected final void resetRefCnt() {
        updater.resetRefCnt(this);
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return updater.retain(this);
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain(int increment) {
        return updater.retain(this, increment);
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    @Override // p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch(Object hint) {
        return this;
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
