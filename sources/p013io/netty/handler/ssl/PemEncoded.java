package p013io.netty.handler.ssl;

import p013io.netty.buffer.ByteBuf;
import p013io.netty.buffer.ByteBufHolder;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.ssl.PemEncoded */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/PemEncoded.class */
public interface PemEncoded extends ByteBufHolder {
    boolean isSensitive();

    @Override // p013io.netty.buffer.ByteBufHolder
    PemEncoded copy();

    @Override // p013io.netty.buffer.ByteBufHolder
    PemEncoded duplicate();

    @Override // p013io.netty.buffer.ByteBufHolder
    PemEncoded retainedDuplicate();

    @Override // p013io.netty.buffer.ByteBufHolder
    PemEncoded replace(ByteBuf byteBuf);

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    PemEncoded retain();

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    PemEncoded retain(int i);

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    PemEncoded touch();

    @Override // p013io.netty.buffer.ByteBufHolder, p013io.netty.util.ReferenceCounted
    PemEncoded touch(Object obj);
}
