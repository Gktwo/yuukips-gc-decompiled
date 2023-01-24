package p013io.netty.buffer;

import java.nio.ByteOrder;
import p013io.netty.util.ResourceLeakTracker;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.buffer.SimpleLeakAwareCompositeByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/SimpleLeakAwareCompositeByteBuf.class */
class SimpleLeakAwareCompositeByteBuf extends WrappedCompositeByteBuf {
    final ResourceLeakTracker<ByteBuf> leak;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SimpleLeakAwareCompositeByteBuf.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public SimpleLeakAwareCompositeByteBuf(CompositeByteBuf wrapped, ResourceLeakTracker<ByteBuf> leak) {
        super(wrapped);
        this.leak = (ResourceLeakTracker) ObjectUtil.checkNotNull(leak, "leak");
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release() {
        ByteBuf unwrapped = unwrap();
        if (!release()) {
            return false;
        }
        closeLeak(unwrapped);
        return true;
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractReferenceCountedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        ByteBuf unwrapped = unwrap();
        if (!release(decrement)) {
            return false;
        }
        closeLeak(unwrapped);
        return true;
    }

    private void closeLeak(ByteBuf trackedByteBuf) {
        boolean closed = this.leak.close(trackedByteBuf);
        if (!$assertionsDisabled && !closed) {
            throw new AssertionError();
        }
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder endianness) {
        if (order() == endianness) {
            return this;
        }
        return newLeakAwareByteBuf(order(endianness));
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return newLeakAwareByteBuf(slice());
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return newLeakAwareByteBuf(retainedSlice());
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        return newLeakAwareByteBuf(slice(index, length));
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        return newLeakAwareByteBuf(retainedSlice(index, length));
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return newLeakAwareByteBuf(duplicate());
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return newLeakAwareByteBuf(retainedDuplicate());
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int length) {
        return newLeakAwareByteBuf(readSlice(length));
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int length) {
        return newLeakAwareByteBuf(readRetainedSlice(length));
    }

    @Override // p013io.netty.buffer.WrappedCompositeByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return newLeakAwareByteBuf(asReadOnly());
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf wrapped) {
        return newLeakAwareByteBuf(wrapped, unwrap(), this.leak);
    }

    protected SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf wrapped, ByteBuf trackedByteBuf, ResourceLeakTracker<ByteBuf> leakTracker) {
        return new SimpleLeakAwareByteBuf(wrapped, trackedByteBuf, leakTracker);
    }
}
