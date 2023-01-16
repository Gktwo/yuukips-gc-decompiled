package kcp.highway.erasure;

import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/erasure/IFecEncode.class */
public interface IFecEncode {
    ByteBuf[] encode(ByteBuf byteBuf);

    void release();
}
