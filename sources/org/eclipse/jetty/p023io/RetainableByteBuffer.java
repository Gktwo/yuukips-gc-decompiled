package org.eclipse.jetty.p023io;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.Retainable;

/* renamed from: org.eclipse.jetty.io.RetainableByteBuffer */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/RetainableByteBuffer.class */
public class RetainableByteBuffer implements Retainable {
    private final ByteBufferPool pool;
    private final ByteBuffer buffer;
    private final AtomicInteger references;

    public RetainableByteBuffer(ByteBufferPool pool, int size) {
        this(pool, size, false);
    }

    public RetainableByteBuffer(ByteBufferPool pool, int size, boolean direct) {
        this.pool = pool;
        this.buffer = pool.acquire(size, direct);
        this.references = new AtomicInteger(1);
    }

    public ByteBuffer getBuffer() {
        return this.buffer;
    }

    public int getReferences() {
        return this.references.get();
    }

    @Override // org.eclipse.jetty.util.Retainable
    public void retain() {
        int r;
        do {
            r = this.references.get();
            if (r == 0) {
                throw new IllegalStateException("released " + this);
            }
        } while (!this.references.compareAndSet(r, r + 1));
    }

    public int release() {
        int ref = this.references.decrementAndGet();
        if (ref == 0) {
            this.pool.release(this.buffer);
        } else if (ref < 0) {
            throw new IllegalStateException("already released " + this);
        }
        return ref;
    }

    public int remaining() {
        return this.buffer.remaining();
    }

    public boolean hasRemaining() {
        return remaining() > 0;
    }

    public boolean isEmpty() {
        return !hasRemaining();
    }

    public void clear() {
        BufferUtil.clear(this.buffer);
    }

    public String toString() {
        return String.format("%s@%x{%s,r=%d}", getClass().getSimpleName(), Integer.valueOf(hashCode()), BufferUtil.toDetailString(this.buffer), Integer.valueOf(getReferences()));
    }
}
