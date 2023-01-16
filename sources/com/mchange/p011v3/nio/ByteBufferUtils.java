package com.mchange.p011v3.nio;

import java.nio.ByteBuffer;

/* renamed from: com.mchange.v3.nio.ByteBufferUtils */
/* loaded from: grasscutter.jar:com/mchange/v3/nio/ByteBufferUtils.class */
public final class ByteBufferUtils {
    public static byte[] newArray(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return (byte[]) byteBuffer.array().clone();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    private ByteBufferUtils() {
    }
}
