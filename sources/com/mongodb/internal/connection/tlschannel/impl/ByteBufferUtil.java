package com.mongodb.internal.connection.tlschannel.impl;

import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/ByteBufferUtil.class */
public class ByteBufferUtil {
    public static void copy(ByteBuffer src, ByteBuffer dst, int length) {
        if (length < 0) {
            throw new IllegalArgumentException("negative length");
        } else if (src.remaining() < length) {
            throw new IllegalArgumentException(String.format("source buffer does not have enough remaining capacity (%d < %d)", Integer.valueOf(src.remaining()), Integer.valueOf(length)));
        } else if (dst.remaining() < length) {
            throw new IllegalArgumentException(String.format("destination buffer does not have enough remaining capacity (%d < %d)", Integer.valueOf(dst.remaining()), Integer.valueOf(length)));
        } else if (length != 0) {
            ByteBuffer tmp = src.duplicate();
            tmp.limit(src.position() + length);
            dst.put(tmp);
            src.position(src.position() + length);
        }
    }
}
