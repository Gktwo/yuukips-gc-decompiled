package org.eclipse.jetty.p023io;

import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;

/* access modifiers changed from: package-private */
@ManagedObject
/* renamed from: org.eclipse.jetty.io.AbstractByteBufferPool */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/AbstractByteBufferPool.class */
public abstract class AbstractByteBufferPool implements ByteBufferPool {
    private final int _factor;
    private final int _maxQueueLength;
    private final long _maxHeapMemory;
    private final long _maxDirectMemory;
    private final AtomicLong _heapMemory = new AtomicLong();
    private final AtomicLong _directMemory = new AtomicLong();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* access modifiers changed from: protected */
    public AbstractByteBufferPool(int factor, int maxQueueLength, long j, long j2) {
        this._factor = factor <= 0 ? 1024 : factor;
        this._maxQueueLength = maxQueueLength;
        this._maxHeapMemory = ((j > 0 ? 1 : (j == 0 ? 0 : -1)) != 0 ? j : Runtime.getRuntime().maxMemory() / 4) == true ? 1 : 0;
        this._maxDirectMemory = ((j2 > 0 ? 1 : (j2 == 0 ? 0 : -1)) != 0 ? j2 : Runtime.getRuntime().maxMemory() / 4) == true ? 1 : 0;
    }

    protected int getCapacityFactor() {
        return this._factor;
    }

    protected int getMaxQueueLength() {
        return this._maxQueueLength;
    }

    @Deprecated
    protected void decrementMemory(ByteBuffer buffer) {
        updateMemory(buffer, false);
    }

    @Deprecated
    protected void incrementMemory(ByteBuffer buffer) {
        updateMemory(buffer, true);
    }

    private void updateMemory(ByteBuffer buffer, boolean addOrSub) {
        AtomicLong memory = buffer.isDirect() ? this._directMemory : this._heapMemory;
        int capacity = buffer.capacity();
        memory.addAndGet(addOrSub ? (long) capacity : (long) (-capacity));
    }

    protected void releaseExcessMemory(boolean direct, Consumer<Boolean> clearFn) {
        long maxMemory = direct ? this._maxDirectMemory : this._maxHeapMemory;
        if (maxMemory > 0) {
            while (getMemory(direct) > maxMemory) {
                clearFn.accept(Boolean.valueOf(direct));
            }
        }
    }

    @ManagedAttribute("The bytes retained by direct ByteBuffers")
    public long getDirectMemory() {
        return getMemory(true);
    }

    @ManagedAttribute("The bytes retained by heap ByteBuffers")
    public long getHeapMemory() {
        return getMemory(false);
    }

    @ManagedAttribute("The max num of bytes that can be retained from direct ByteBuffers")
    public long getMaxDirectMemory() {
        return this._maxDirectMemory;
    }

    @ManagedAttribute("The max num of bytes that can be retained from heap ByteBuffers")
    public long getMaxHeapMemory() {
        return this._maxHeapMemory;
    }

    public long getMemory(boolean direct) {
        return (direct ? this._directMemory : this._heapMemory).get();
    }

    IntConsumer updateMemory(boolean direct) {
        if (direct) {
            AtomicLong atomicLong = this._directMemory;
            Objects.requireNonNull(atomicLong);
            return (v1) -> {
                r0.addAndGet(v1);
            };
        }
        AtomicLong atomicLong2 = this._heapMemory;
        Objects.requireNonNull(atomicLong2);
        return (v1) -> {
            r0.addAndGet(v1);
        };
    }

    @ManagedOperation(value = "Clears this ByteBufferPool", impact = "ACTION")
    public void clear() {
        this._heapMemory.set(0);
        this._directMemory.set(0);
    }
}
