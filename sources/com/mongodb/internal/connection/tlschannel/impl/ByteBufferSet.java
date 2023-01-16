package com.mongodb.internal.connection.tlschannel.impl;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/ByteBufferSet.class */
public class ByteBufferSet {
    public final ByteBuffer[] array;
    public final int offset;
    public final int length;

    public ByteBufferSet(ByteBuffer[] array, int offset, int length) {
        if (array == null) {
            throw new NullPointerException();
        } else if (array.length < offset) {
            throw new IndexOutOfBoundsException();
        } else if (array.length < offset + length) {
            throw new IndexOutOfBoundsException();
        } else {
            for (int i = offset; i < offset + length; i++) {
                if (array[i] == null) {
                    throw new NullPointerException();
                }
            }
            this.array = array;
            this.offset = offset;
            this.length = length;
        }
    }

    public ByteBufferSet(ByteBuffer[] array) {
        this(array, 0, array.length);
    }

    public ByteBufferSet(ByteBuffer buffer) {
        this(new ByteBuffer[]{buffer});
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    public long remaining() {
        char c = 0;
        for (int i = this.offset; i < this.offset + this.length; i++) {
            c += (long) this.array[i].remaining();
        }
        return c;
    }

    public int putRemaining(ByteBuffer from) {
        int totalBytes = 0;
        for (int i = this.offset; i < this.offset + this.length && from.hasRemaining(); i++) {
            ByteBuffer dstBuffer = this.array[i];
            int bytes = Math.min(from.remaining(), dstBuffer.remaining());
            ByteBufferUtil.copy(from, dstBuffer, bytes);
            totalBytes += bytes;
        }
        return totalBytes;
    }

    public ByteBufferSet put(ByteBuffer from, int length) {
        int pending;
        if (from.remaining() < length) {
            throw new IllegalArgumentException();
        } else if (remaining() < ((long) length)) {
            throw new IllegalArgumentException();
        } else {
            int totalBytes = 0;
            for (int i = this.offset; i < this.offset + this.length && (pending = length - totalBytes) != 0; i++) {
                int bytes = Math.min(pending, (int) remaining());
                ByteBufferUtil.copy(from, this.array[i], bytes);
                totalBytes += bytes;
            }
            return this;
        }
    }

    public int getRemaining(ByteBuffer dst) {
        int totalBytes = 0;
        for (int i = this.offset; i < this.offset + this.length && dst.hasRemaining(); i++) {
            ByteBuffer srcBuffer = this.array[i];
            int bytes = Math.min(dst.remaining(), srcBuffer.remaining());
            ByteBufferUtil.copy(srcBuffer, dst, bytes);
            totalBytes += bytes;
        }
        return totalBytes;
    }

    public ByteBufferSet get(ByteBuffer dst, int length) {
        int pending;
        if (remaining() < ((long) length)) {
            throw new IllegalArgumentException();
        } else if (dst.remaining() < length) {
            throw new IllegalArgumentException();
        } else {
            int totalBytes = 0;
            for (int i = this.offset; i < this.offset + this.length && (pending = length - totalBytes) != 0; i++) {
                ByteBuffer srcBuffer = this.array[i];
                int bytes = Math.min(pending, srcBuffer.remaining());
                ByteBufferUtil.copy(srcBuffer, dst, bytes);
                totalBytes += bytes;
            }
            return this;
        }
    }

    public boolean hasRemaining() {
        return remaining() > 0;
    }

    public boolean isReadOnly() {
        for (int i = this.offset; i < this.offset + this.length; i++) {
            if (this.array[i].isReadOnly()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "ByteBufferSet[array=" + Arrays.toString(this.array) + ", offset=" + this.offset + ", length=" + this.length + "]";
    }
}
