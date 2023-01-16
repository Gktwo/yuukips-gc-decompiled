package p013io.netty.buffer;

import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.buffer.DefaultByteBufHolder */
/* loaded from: grasscutter.jar:io/netty/buffer/DefaultByteBufHolder.class */
public class DefaultByteBufHolder implements ByteBufHolder {
    private final ByteBuf data;

    public DefaultByteBufHolder(ByteBuf data) {
        this.data = (ByteBuf) ObjectUtil.checkNotNull(data, "data");
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return ByteBufUtil.ensureAccessible(this.data);
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public ByteBufHolder copy() {
        return replace(this.data.copy());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public ByteBufHolder duplicate() {
        return replace(this.data.duplicate());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public ByteBufHolder retainedDuplicate() {
        return replace(this.data.retainedDuplicate());
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public ByteBufHolder replace(ByteBuf content) {
        return new DefaultByteBufHolder(content);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public int refCnt() {
        return this.data.refCnt();
    }

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public ByteBufHolder retain() {
        this.data.retain();
        return this;
    }

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public ByteBufHolder retain(int increment) {
        this.data.retain(increment);
        return this;
    }

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public ByteBufHolder touch() {
        this.data.touch();
        return this;
    }

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    public ByteBufHolder touch(Object hint) {
        this.data.touch(hint);
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release() {
        return this.data.release();
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        return this.data.release(decrement);
    }

    protected final String contentToString() {
        return this.data.toString();
    }

    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + contentToString() + ')';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.data.equals(((DefaultByteBufHolder) o).data);
    }

    public int hashCode() {
        return this.data.hashCode();
    }
}
