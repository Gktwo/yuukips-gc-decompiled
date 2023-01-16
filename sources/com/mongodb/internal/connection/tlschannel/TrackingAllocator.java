package com.mongodb.internal.connection.tlschannel;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/TrackingAllocator.class */
public class TrackingAllocator implements BufferAllocator {
    private BufferAllocator impl;
    private LongAdder bytesAllocatedAdder = new LongAdder();
    private LongAdder bytesDeallocatedAdder = new LongAdder();
    private AtomicLong currentAllocationSize = new AtomicLong();
    private LongAccumulator maxAllocationSizeAcc = new LongAccumulator(Math::max, 0);
    private LongAdder buffersAllocatedAdder = new LongAdder();
    private LongAdder buffersDeallocatedAdder = new LongAdder();

    public TrackingAllocator(BufferAllocator impl) {
        this.impl = impl;
    }

    @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
    public ByteBuffer allocate(int size) {
        this.bytesAllocatedAdder.add((long) size);
        this.currentAllocationSize.addAndGet((long) size);
        this.buffersAllocatedAdder.increment();
        return this.impl.allocate(size);
    }

    @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
    public void free(ByteBuffer buffer) {
        int size = buffer.capacity();
        this.bytesDeallocatedAdder.add((long) size);
        this.maxAllocationSizeAcc.accumulate(this.currentAllocationSize.longValue());
        this.currentAllocationSize.addAndGet((long) (-size));
        this.buffersDeallocatedAdder.increment();
        this.impl.free(buffer);
    }

    public long bytesAllocated() {
        return this.bytesAllocatedAdder.longValue();
    }

    public long bytesDeallocated() {
        return this.bytesDeallocatedAdder.longValue();
    }

    public long currentAllocation() {
        return this.currentAllocationSize.longValue();
    }

    public long maxAllocation() {
        return this.maxAllocationSizeAcc.longValue();
    }

    public long buffersAllocated() {
        return this.buffersAllocatedAdder.longValue();
    }

    public long buffersDeallocated() {
        return this.buffersDeallocatedAdder.longValue();
    }
}
