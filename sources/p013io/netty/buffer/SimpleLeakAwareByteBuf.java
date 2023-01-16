package p013io.netty.buffer;

import java.nio.ByteOrder;
import p013io.netty.util.ResourceLeakTracker;
import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.SimpleLeakAwareByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/SimpleLeakAwareByteBuf.class */
public class SimpleLeakAwareByteBuf extends WrappedByteBuf {
    private final ByteBuf trackedByteBuf;
    final ResourceLeakTracker<ByteBuf> leak;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !SimpleLeakAwareByteBuf.class.desiredAssertionStatus();
    }

    /* access modifiers changed from: package-private */
    public SimpleLeakAwareByteBuf(ByteBuf wrapped, ByteBuf trackedByteBuf, ResourceLeakTracker<ByteBuf> leak) {
        super(wrapped);
        this.trackedByteBuf = (ByteBuf) ObjectUtil.checkNotNull(trackedByteBuf, "trackedByteBuf");
        this.leak = (ResourceLeakTracker) ObjectUtil.checkNotNull(leak, "leak");
    }

    /* access modifiers changed from: package-private */
    public SimpleLeakAwareByteBuf(ByteBuf wrapped, ResourceLeakTracker<ByteBuf> leak) {
        this(wrapped, wrapped, leak);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return newSharedLeakAwareByteBuf(slice());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return unwrappedDerived(retainedSlice());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        return unwrappedDerived(retainedSlice(index, length));
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return unwrappedDerived(retainedDuplicate());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int length) {
        return unwrappedDerived(readRetainedSlice(length));
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        return newSharedLeakAwareByteBuf(slice(index, length));
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return newSharedLeakAwareByteBuf(duplicate());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int length) {
        return newSharedLeakAwareByteBuf(readSlice(length));
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return newSharedLeakAwareByteBuf(asReadOnly());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        return this;
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf touch(Object hint) {
        return this;
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release() {
        if (!release()) {
            return false;
        }
        closeLeak();
        return true;
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        if (!release(decrement)) {
            return false;
        }
        closeLeak();
        return true;
    }

    private void closeLeak() {
        boolean closed = this.leak.close(this.trackedByteBuf);
        if (!$assertionsDisabled && !closed) {
            throw new AssertionError();
        }
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder endianness) {
        if (order() == endianness) {
            return this;
        }
        return newSharedLeakAwareByteBuf(order(endianness));
    }

    private ByteBuf unwrappedDerived(ByteBuf derived) {
        ByteBuf unwrappedDerived = unwrapSwapped(derived);
        if (!(unwrappedDerived instanceof AbstractPooledDerivedByteBuf)) {
            return newSharedLeakAwareByteBuf(derived);
        }
        ((AbstractPooledDerivedByteBuf) unwrappedDerived).parent(this);
        ResourceLeakTracker<ByteBuf> newLeak = AbstractByteBuf.leakDetector.track(derived);
        if (newLeak == null) {
            return derived;
        }
        return newLeakAwareByteBuf(derived, newLeak);
    }

    private static ByteBuf unwrapSwapped(ByteBuf buf) {
        if (!(buf instanceof SwappedByteBuf)) {
            return buf;
        }
        do {
            buf = buf.unwrap();
        } while (buf instanceof SwappedByteBuf);
        return buf;
    }

    private SimpleLeakAwareByteBuf newSharedLeakAwareByteBuf(ByteBuf wrapped) {
        return newLeakAwareByteBuf(wrapped, this.trackedByteBuf, this.leak);
    }

    private SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf wrapped, ResourceLeakTracker<ByteBuf> leakTracker) {
        return newLeakAwareByteBuf(wrapped, wrapped, leakTracker);
    }

    protected SimpleLeakAwareByteBuf newLeakAwareByteBuf(ByteBuf buf, ByteBuf trackedByteBuf, ResourceLeakTracker<ByteBuf> leakTracker) {
        return new SimpleLeakAwareByteBuf(buf, trackedByteBuf, leakTracker);
    }
}
