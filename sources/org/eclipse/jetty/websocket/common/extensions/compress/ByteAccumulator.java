package org.eclipse.jetty.websocket.common.extensions.compress;

import java.nio.ByteBuffer;
import org.eclipse.jetty.p023io.ByteBufferAccumulator;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.websocket.api.MessageTooLargeException;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/compress/ByteAccumulator.class */
public class ByteAccumulator implements AutoCloseable {
    private static final int MIN_SPACE = 8;
    private final ByteBufferAccumulator accumulator;
    private final int maxSize;
    private int length;

    public ByteAccumulator(int maxOverallBufferSize) {
        this(maxOverallBufferSize, null);
    }

    public ByteAccumulator(int maxOverallBufferSize, ByteBufferPool byteBufferPool) {
        this.length = 0;
        this.maxSize = maxOverallBufferSize;
        this.accumulator = new ByteBufferAccumulator(byteBufferPool, false);
    }

    public int getLength() {
        return this.length;
    }

    public ByteBuffer ensureBuffer(int minAllocationSize) {
        return this.accumulator.ensureBuffer(8, minAllocationSize);
    }

    public void addLength(int read) {
        this.length += read;
        if (this.length > this.maxSize) {
            throw new MessageTooLargeException(String.format("Resulting message size [%d] is too large for configured max of [%d]", Integer.valueOf(this.length), Integer.valueOf(this.maxSize)));
        }
    }

    public void copyChunk(byte[] buf, int offset, int length) {
        copyChunk(BufferUtil.toBuffer(buf, offset, length));
    }

    public void copyChunk(ByteBuffer buffer) {
        int remaining = buffer.remaining();
        if (this.length + remaining > this.maxSize) {
            throw new MessageTooLargeException(String.format("Resulting message size [%d] is too large for configured max of [%d]", Integer.valueOf(this.length + remaining), Integer.valueOf(this.maxSize)));
        }
        this.length += remaining;
        this.accumulator.copyBuffer(buffer);
    }

    public void transferTo(ByteBuffer buffer) {
        BufferUtil.flipToFlush(buffer, 0);
        int availableSpace = BufferUtil.space(buffer);
        if (availableSpace < this.length) {
            throw new IllegalArgumentException(String.format("Not enough space in ByteBuffer remaining [%d] for accumulated buffers length [%d]", Integer.valueOf(availableSpace), Integer.valueOf(this.length)));
        }
        this.accumulator.writeTo(buffer);
        close();
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.accumulator.close();
    }
}
