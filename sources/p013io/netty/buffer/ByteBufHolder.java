package p013io.netty.buffer;

import p013io.netty.util.ReferenceCounted;

/* renamed from: io.netty.buffer.ByteBufHolder */
/* loaded from: grasscutter.jar:io/netty/buffer/ByteBufHolder.class */
public interface ByteBufHolder extends ReferenceCounted {
    ByteBuf content();

    ByteBufHolder copy();

    ByteBufHolder duplicate();

    ByteBufHolder retainedDuplicate();

    ByteBufHolder replace(ByteBuf byteBuf);

    @Override // p013io.netty.util.ReferenceCounted
    ByteBufHolder retain();

    @Override // p013io.netty.util.ReferenceCounted
    ByteBufHolder retain(int i);

    @Override // p013io.netty.util.ReferenceCounted
    ByteBufHolder touch();

    @Override // p013io.netty.util.ReferenceCounted
    ByteBufHolder touch(Object obj);
}
