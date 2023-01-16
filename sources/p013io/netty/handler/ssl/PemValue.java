package p013io.netty.handler.ssl;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.util.AbstractReferenceCounted;
import p013io.netty.util.IllegalReferenceCountException;
import p013io.netty.util.internal.ObjectUtil;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.PemValue */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/PemValue.class */
public class PemValue extends AbstractReferenceCounted implements PemEncoded {
    private final ByteBuf content;
    private final boolean sensitive;

    /* access modifiers changed from: package-private */
    public PemValue(ByteBuf content, boolean sensitive) {
        this.content = (ByteBuf) ObjectUtil.checkNotNull(content, "content");
        this.sensitive = sensitive;
    }

    @Override // p013io.netty.handler.ssl.PemEncoded
    public boolean isSensitive() {
        return this.sensitive;
    }

    @Override // p013io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        int count = refCnt();
        if (count > 0) {
            return this.content;
        }
        throw new IllegalReferenceCountException(count);
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemValue copy() {
        return replace(this.content.copy());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemValue duplicate() {
        return replace(this.content.duplicate());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemValue retainedDuplicate() {
        return replace(this.content.retainedDuplicate());
    }

    @Override // p013io.netty.handler.ssl.PemEncoded, p013io.netty.buffer.ByteBufHolder
    public PemValue replace(ByteBuf content) {
        return new PemValue(content, this.sensitive);
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public PemValue touch() {
        return (PemValue) touch();
    }

    @Override // p013io.netty.util.ReferenceCounted
    public PemValue touch(Object hint) {
        this.content.touch(hint);
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public PemValue retain() {
        return (PemValue) retain();
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public PemValue retain(int increment) {
        return (PemValue) retain(increment);
    }

    @Override // p013io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        if (this.sensitive) {
            SslUtils.zeroout(this.content);
        }
        this.content.release();
    }
}
