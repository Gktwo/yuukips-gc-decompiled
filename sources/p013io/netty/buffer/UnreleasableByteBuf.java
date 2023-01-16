package p013io.netty.buffer;

import java.nio.ByteOrder;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.buffer.UnreleasableByteBuf */
/* loaded from: grasscutter.jar:io/netty/buffer/UnreleasableByteBuf.class */
final class UnreleasableByteBuf extends WrappedByteBuf {
    private SwappedByteBuf swappedBuf;

    /* access modifiers changed from: package-private */
    public UnreleasableByteBuf(ByteBuf buf) {
        super(buf instanceof UnreleasableByteBuf ? buf.unwrap() : buf);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder endianness) {
        if (ObjectUtil.checkNotNull(endianness, "endianness") == order()) {
            return this;
        }
        SwappedByteBuf swappedBuf = this.swappedBuf;
        if (swappedBuf == null) {
            SwappedByteBuf swappedByteBuf = new SwappedByteBuf(this);
            swappedBuf = swappedByteBuf;
            this.swappedBuf = swappedByteBuf;
        }
        return swappedBuf;
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.buf.isReadOnly() ? this : new UnreleasableByteBuf(this.buf.asReadOnly());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int length) {
        return new UnreleasableByteBuf(this.buf.readSlice(length));
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int length) {
        return readSlice(length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return new UnreleasableByteBuf(this.buf.slice());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return slice();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf slice(int index, int length) {
        return new UnreleasableByteBuf(this.buf.slice(index, length));
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int index, int length) {
        return slice(index, length);
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return new UnreleasableByteBuf(this.buf.duplicate());
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return duplicate();
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain(int increment) {
        return this;
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.buffer.ByteBuf, p013io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        return this;
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
        return false;
    }

    @Override // p013io.netty.buffer.WrappedByteBuf, p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        return false;
    }
}
