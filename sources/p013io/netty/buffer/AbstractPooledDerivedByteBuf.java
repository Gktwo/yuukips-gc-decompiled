package p013io.netty.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import p013io.netty.util.internal.ObjectPool;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.buffer.AbstractPooledDerivedByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/AbstractPooledDerivedByteBuf.class */
public abstract class AbstractPooledDerivedByteBuf extends AbstractReferenceCountedByteBuf {
    private final ObjectPool.Handle<AbstractPooledDerivedByteBuf> recyclerHandle;
    private AbstractByteBuf rootParent;
    private ByteBuf parent;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !AbstractPooledDerivedByteBuf.class.desiredAssertionStatus();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.netty.util.internal.ObjectPool$Handle<? extends io.netty.buffer.AbstractPooledDerivedByteBuf> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public AbstractPooledDerivedByteBuf(ObjectPool.Handle<? extends AbstractPooledDerivedByteBuf> recyclerHandle) {
        super(0);
        this.recyclerHandle = recyclerHandle;
    }

    /* access modifiers changed from: package-private */
    public final void parent(ByteBuf newParent) {
        if ($assertionsDisabled || (newParent instanceof SimpleLeakAwareByteBuf)) {
            this.parent = newParent;
            return;
        }
        throw new AssertionError();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final AbstractByteBuf unwrap() {
        return this.rootParent;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.netty.buffer.AbstractPooledDerivedByteBuf */
    /* JADX WARN: Multi-variable type inference failed */
    final <U extends AbstractPooledDerivedByteBuf> U init(AbstractByteBuf unwrapped, ByteBuf wrapped, int readerIndex, int writerIndex, int maxCapacity) {
        wrapped.retain();
        this.parent = wrapped;
        this.rootParent = unwrapped;
        try {
            maxCapacity(maxCapacity);
            setIndex0(readerIndex, writerIndex);
            resetRefCnt();
            wrapped = null;
            if (0 != 0) {
                this.rootParent = null;
                this.parent = null;
                wrapped.release();
            }
            return this;
        } catch (Throwable th) {
            if (wrapped != null) {
                this.rootParent = null;
                this.parent = null;
                wrapped.release();
            }
            throw th;
        }
    }

    @Override // p013io.netty.buffer.AbstractReferenceCountedByteBuf
    protected final void deallocate() {
        ByteBuf parent = this.parent;
        this.recyclerHandle.recycle(this);
        parent.release();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // p013io.netty.buffer.ByteBuf
    @Deprecated
    public final ByteOrder order() {
        return unwrap().order();
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return unwrap().isReadOnly();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return unwrap().isDirect();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return unwrap().isContiguous();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // p013io.netty.buffer.ByteBuf
    public final ByteBuffer internalNioBuffer(int index, int length) {
        return nioBuffer(index, length);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public final ByteBuf retainedSlice() {
        int index = readerIndex();
        return retainedSlice(index, writerIndex() - index);
    }

    @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        ensureAccessible();
        return new PooledNonRetainedSlicedByteBuf(this, unwrap(), index, length);
    }

    final ByteBuf duplicate0() {
        ensureAccessible();
        return new PooledNonRetainedDuplicateByteBuf(this, unwrap());
    }

    /* renamed from: io.netty.buffer.AbstractPooledDerivedByteBuf$PooledNonRetainedDuplicateByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/AbstractPooledDerivedByteBuf$PooledNonRetainedDuplicateByteBuf.class */
    private static final class PooledNonRetainedDuplicateByteBuf extends UnpooledDuplicatedByteBuf {
        private final ByteBuf referenceCountDelegate;

        PooledNonRetainedDuplicateByteBuf(ByteBuf referenceCountDelegate, AbstractByteBuf buffer) {
            super(buffer);
            this.referenceCountDelegate = referenceCountDelegate;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        boolean isAccessible0() {
            return this.referenceCountDelegate.isAccessible();
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0(int increment) {
            this.referenceCountDelegate.retain(increment);
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0(Object hint) {
            this.referenceCountDelegate.touch(hint);
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        boolean release0() {
            return this.referenceCountDelegate.release();
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        boolean release0(int decrement) {
            return this.referenceCountDelegate.release(decrement);
        }

        @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, this);
        }

        @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, readerIndex(), writerIndex());
        }

        @Override // p013io.netty.buffer.DuplicatedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf slice(int index, int length) {
            checkIndex(index, length);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), index, length);
        }

        @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice() {
            return retainedSlice(readerIndex(), capacity());
        }

        @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice(int index, int length) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, index, length);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.buffer.AbstractPooledDerivedByteBuf$PooledNonRetainedSlicedByteBuf */
    /* loaded from: grasscutter.jar:io/netty/buffer/AbstractPooledDerivedByteBuf$PooledNonRetainedSlicedByteBuf.class */
    public static final class PooledNonRetainedSlicedByteBuf extends UnpooledSlicedByteBuf {
        private final ByteBuf referenceCountDelegate;

        PooledNonRetainedSlicedByteBuf(ByteBuf referenceCountDelegate, AbstractByteBuf buffer, int index, int length) {
            super(buffer, index, length);
            this.referenceCountDelegate = referenceCountDelegate;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        boolean isAccessible0() {
            return this.referenceCountDelegate.isAccessible();
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        int refCnt0() {
            return this.referenceCountDelegate.refCnt();
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0() {
            this.referenceCountDelegate.retain();
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf retain0(int increment) {
            this.referenceCountDelegate.retain(increment);
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0() {
            this.referenceCountDelegate.touch();
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        ByteBuf touch0(Object hint) {
            this.referenceCountDelegate.touch(hint);
            return this;
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        boolean release0() {
            return this.referenceCountDelegate.release();
        }

        @Override // p013io.netty.buffer.AbstractDerivedByteBuf
        boolean release0(int decrement) {
            return this.referenceCountDelegate.release(decrement);
        }

        @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf duplicate() {
            ensureAccessible();
            return new PooledNonRetainedDuplicateByteBuf(this.referenceCountDelegate, unwrap()).setIndex(idx(readerIndex()), idx(writerIndex()));
        }

        @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf retainedDuplicate() {
            return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
        }

        @Override // p013io.netty.buffer.AbstractUnpooledSlicedByteBuf, p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf slice(int index, int length) {
            checkIndex(index, length);
            return new PooledNonRetainedSlicedByteBuf(this.referenceCountDelegate, unwrap(), idx(index), length);
        }

        @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice() {
            return retainedSlice(0, capacity());
        }

        @Override // p013io.netty.buffer.AbstractByteBuf, p013io.netty.buffer.ByteBuf
        public ByteBuf retainedSlice(int index, int length) {
            return PooledSlicedByteBuf.newInstance(unwrap(), this, idx(index), length);
        }
    }
}
