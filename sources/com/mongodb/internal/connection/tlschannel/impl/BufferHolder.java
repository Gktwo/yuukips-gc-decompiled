package com.mongodb.internal.connection.tlschannel.impl;

import com.mongodb.internal.connection.tlschannel.BufferAllocator;
import java.nio.ByteBuffer;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/BufferHolder.class */
public class BufferHolder {
    private static final Logger logger = LoggerFactory.getLogger(BufferHolder.class);
    private static final byte[] zeros = new byte[TlsChannelImpl.maxTlsPacketSize];
    public final String name;
    public final BufferAllocator allocator;
    public final boolean plainData;
    public final int maxSize;
    public final boolean opportunisticDispose;
    public ByteBuffer buffer;
    public int lastSize;

    public BufferHolder(String name, Optional<ByteBuffer> buffer, BufferAllocator allocator, int initialSize, int maxSize, boolean plainData, boolean opportunisticDispose) {
        this.name = name;
        this.allocator = allocator;
        this.buffer = buffer.orElse(null);
        this.maxSize = maxSize;
        this.plainData = plainData;
        this.opportunisticDispose = opportunisticDispose;
        this.lastSize = ((Integer) buffer.map(b -> {
            return Integer.valueOf(b.capacity());
        }).orElse(Integer.valueOf(initialSize))).intValue();
    }

    public void prepare() {
        if (this.buffer == null) {
            this.buffer = this.allocator.allocate(this.lastSize);
        }
    }

    public boolean release() {
        if (!this.opportunisticDispose || this.buffer.position() != 0) {
            return false;
        }
        return dispose();
    }

    public boolean dispose() {
        if (this.buffer == null) {
            return false;
        }
        this.allocator.free(this.buffer);
        this.buffer = null;
        return true;
    }

    public void resize(int newCapacity) {
        if (newCapacity > this.maxSize) {
            throw new IllegalArgumentException(String.format("new capacity (%s) bigger than absolute max size (%s)", Integer.valueOf(newCapacity), Integer.valueOf(this.maxSize)));
        }
        logger.trace("resizing buffer {}, increasing from {} to {} (manual sizing)", this.name, Integer.valueOf(this.buffer.capacity()), Integer.valueOf(newCapacity));
        resizeImpl(newCapacity);
    }

    public void enlarge() {
        if (this.buffer.capacity() >= this.maxSize) {
            throw new IllegalStateException(String.format("%s buffer insufficient despite having capacity of %d", this.name, Integer.valueOf(this.buffer.capacity())));
        }
        int newCapacity = Math.min(this.buffer.capacity() * 2, this.maxSize);
        logger.trace("enlarging buffer {}, increasing from {} to {} (automatic enlarge)", this.name, Integer.valueOf(this.buffer.capacity()), Integer.valueOf(newCapacity));
        resizeImpl(newCapacity);
    }

    private void resizeImpl(int newCapacity) {
        ByteBuffer newBuffer = this.allocator.allocate(newCapacity);
        this.buffer.flip();
        newBuffer.put(this.buffer);
        if (this.plainData) {
            zero();
        }
        this.allocator.free(this.buffer);
        this.buffer = newBuffer;
        this.lastSize = newCapacity;
    }

    public void zeroRemaining() {
        zero(this.buffer.position());
    }

    public void zero() {
        zero(0);
    }

    private void zero(int position) {
        this.buffer.mark();
        this.buffer.position(position);
        int size = this.buffer.remaining();
        int length = Math.min(size, zeros.length);
        int offset = 0;
        while (length > 0) {
            this.buffer.put(zeros, 0, length);
            offset += length;
            length = Math.min(size - offset, zeros.length);
        }
        this.buffer.reset();
    }

    public boolean nullOrEmpty() {
        return this.buffer == null || this.buffer.position() == 0;
    }
}
