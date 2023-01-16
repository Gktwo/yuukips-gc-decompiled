package kcp.highway.erasure.bytebuf;

import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/erasure/bytebuf/ByteBufCodingLoop.class */
public interface ByteBufCodingLoop {
    void codeSomeShards(byte[][] bArr, ByteBuf[] byteBufArr, int i, ByteBuf[] byteBufArr2, int i2, int i3, int i4);

    boolean checkSomeShards(byte[][] bArr, ByteBuf[] byteBufArr, int i, byte[][] bArr2, int i2, int i3, int i4, byte[] bArr3);
}
