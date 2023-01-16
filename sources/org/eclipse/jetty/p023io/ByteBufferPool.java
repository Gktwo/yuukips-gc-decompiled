package org.eclipse.jetty.p023io;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.IntConsumer;
import org.eclipse.jetty.util.BufferUtil;

/* renamed from: org.eclipse.jetty.io.ByteBufferPool */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ByteBufferPool.class */
public interface ByteBufferPool {
    ByteBuffer acquire(int i, boolean z);

    void release(ByteBuffer byteBuffer);

    default void remove(ByteBuffer buffer) {
    }

    default ByteBuffer newByteBuffer(int capacity, boolean direct) {
        return direct ? BufferUtil.allocateDirect(capacity) : BufferUtil.allocate(capacity);
    }

    /* renamed from: org.eclipse.jetty.io.ByteBufferPool$Lease */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ByteBufferPool$Lease.class */
    public static class Lease {
        private final ByteBufferPool byteBufferPool;
        private final List<ByteBuffer> buffers = new ArrayList();
        private final List<Boolean> recycles = new ArrayList();

        public Lease(ByteBufferPool byteBufferPool) {
            this.byteBufferPool = byteBufferPool;
        }

        public ByteBuffer acquire(int capacity, boolean direct) {
            ByteBuffer buffer = this.byteBufferPool.acquire(capacity, direct);
            BufferUtil.clearToFill(buffer);
            return buffer;
        }

        public void append(ByteBuffer buffer, boolean recycle) {
            this.buffers.add(buffer);
            this.recycles.add(Boolean.valueOf(recycle));
        }

        public void insert(int index, ByteBuffer buffer, boolean recycle) {
            this.buffers.add(index, buffer);
            this.recycles.add(index, Boolean.valueOf(recycle));
        }

        public List<ByteBuffer> getByteBuffers() {
            return this.buffers;
        }

        /* JADX WARN: Type inference failed for: r0v11, types: [long] */
        public long getTotalLength() {
            char c = 0;
            for (ByteBuffer buffer : this.buffers) {
                c += (long) buffer.remaining();
            }
            return c;
        }

        public int getSize() {
            return this.buffers.size();
        }

        public void recycle() {
            for (int i = 0; i < this.buffers.size(); i++) {
                ByteBuffer buffer = this.buffers.get(i);
                if (this.recycles.get(i).booleanValue()) {
                    release(buffer);
                }
            }
            this.buffers.clear();
            this.recycles.clear();
        }

        public void release(ByteBuffer buffer) {
            this.byteBufferPool.release(buffer);
        }
    }

    /* renamed from: org.eclipse.jetty.io.ByteBufferPool$Bucket */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ByteBufferPool$Bucket.class */
    public static class Bucket {
        private final Queue<ByteBuffer> _queue;
        private final ByteBufferPool _pool;
        private final int _capacity;
        private final int _maxSize;
        private final AtomicInteger _size;
        private final AtomicLong _lastUpdate;
        private final IntConsumer _memoryFunction;

        @Deprecated
        public Bucket(ByteBufferPool pool, int capacity, int maxSize) {
            this(pool, capacity, maxSize, i -> {
            });
        }

        public Bucket(ByteBufferPool pool, int capacity, int maxSize, IntConsumer memoryFunction) {
            this._queue = new ConcurrentLinkedQueue();
            this._lastUpdate = new AtomicLong(System.nanoTime());
            this._pool = pool;
            this._capacity = capacity;
            this._maxSize = maxSize;
            this._size = maxSize > 0 ? new AtomicInteger() : null;
            this._memoryFunction = (IntConsumer) Objects.requireNonNull(memoryFunction);
        }

        public ByteBuffer acquire() {
            ByteBuffer buffer = this._queue.poll();
            if (buffer != null) {
                if (this._size != null) {
                    this._size.decrementAndGet();
                }
                this._memoryFunction.accept(-buffer.capacity());
            }
            return buffer;
        }

        @Deprecated
        public ByteBuffer acquire(boolean direct) {
            ByteBuffer buffer = acquire();
            if (buffer == null) {
                return this._pool.newByteBuffer(this._capacity, direct);
            }
            return buffer;
        }

        public void release(ByteBuffer buffer) {
            resetUpdateTime();
            BufferUtil.reset(buffer);
            if (this._size == null || this._size.incrementAndGet() <= this._maxSize) {
                this._queue.offer(buffer);
                this._memoryFunction.accept(buffer.capacity());
                return;
            }
            this._size.decrementAndGet();
        }

        /* access modifiers changed from: package-private */
        public void resetUpdateTime() {
            this._lastUpdate.lazySet(System.nanoTime());
        }

        public void clear() {
            int size = this._size == null ? 0 : this._size.get() - 1;
            while (size >= 0 && acquire() != null) {
                if (this._size != null) {
                    size--;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this._queue.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this._queue.size();
        }

        /* access modifiers changed from: package-private */
        public long getLastUpdate() {
            return this._lastUpdate.get();
        }

        public String toString() {
            return String.format("%s@%x{capacity=%d, size=%d, maxSize=%d}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(this._capacity), Integer.valueOf(size()), Integer.valueOf(this._maxSize));
        }
    }
}
