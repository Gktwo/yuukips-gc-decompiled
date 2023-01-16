package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* renamed from: org.eclipse.jetty.io.ArrayByteBufferPool */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ArrayByteBufferPool.class */
public class ArrayByteBufferPool extends AbstractByteBufferPool implements Dumpable {
    private static final Logger LOG = Log.getLogger(ArrayByteBufferPool.class);
    private final int _maxCapacity;
    private final int _minCapacity;
    private final ByteBufferPool.Bucket[] _direct;
    private final ByteBufferPool.Bucket[] _indirect;
    private boolean _detailedDump;

    @Override // org.eclipse.jetty.p023io.AbstractByteBufferPool
    public /* bridge */ /* synthetic */ long getMemory(boolean z) {
        return getMemory(z);
    }

    @Override // org.eclipse.jetty.p023io.AbstractByteBufferPool
    @ManagedAttribute("The max num of bytes that can be retained from heap ByteBuffers")
    public /* bridge */ /* synthetic */ long getMaxHeapMemory() {
        return getMaxHeapMemory();
    }

    @Override // org.eclipse.jetty.p023io.AbstractByteBufferPool
    @ManagedAttribute("The max num of bytes that can be retained from direct ByteBuffers")
    public /* bridge */ /* synthetic */ long getMaxDirectMemory() {
        return getMaxDirectMemory();
    }

    @Override // org.eclipse.jetty.p023io.AbstractByteBufferPool
    @ManagedAttribute("The bytes retained by heap ByteBuffers")
    public /* bridge */ /* synthetic */ long getHeapMemory() {
        return getHeapMemory();
    }

    @Override // org.eclipse.jetty.p023io.AbstractByteBufferPool
    @ManagedAttribute("The bytes retained by direct ByteBuffers")
    public /* bridge */ /* synthetic */ long getDirectMemory() {
        return getDirectMemory();
    }

    public ArrayByteBufferPool() {
        this(-1, -1, -1);
    }

    public ArrayByteBufferPool(int minCapacity, int factor, int maxCapacity) {
        this(minCapacity, factor, maxCapacity, -1, 0, 0);
    }

    public ArrayByteBufferPool(int minCapacity, int factor, int maxCapacity, int maxQueueLength) {
        this(minCapacity, factor, maxCapacity, maxQueueLength, 0, 0);
    }

    public ArrayByteBufferPool(int minCapacity, int factor, int maxCapacity, int maxQueueLength, long maxHeapMemory, long maxDirectMemory) {
        super(factor, maxQueueLength, maxHeapMemory, maxDirectMemory);
        this._detailedDump = false;
        int factor2 = getCapacityFactor();
        minCapacity = minCapacity <= 0 ? 0 : minCapacity;
        maxCapacity = maxCapacity <= 0 ? 65536 : maxCapacity;
        if (maxCapacity % factor2 != 0 || factor2 >= maxCapacity) {
            throw new IllegalArgumentException("The capacity factor must be a divisor of maxCapacity");
        }
        this._maxCapacity = maxCapacity;
        this._minCapacity = minCapacity;
        int length = bucketFor(maxCapacity) + 1;
        this._direct = new ByteBufferPool.Bucket[length];
        this._indirect = new ByteBufferPool.Bucket[length];
        for (int i = 0; i < length; i++) {
            this._direct[i] = newBucket(i, true);
            this._indirect[i] = newBucket(i, false);
        }
    }

    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public ByteBuffer acquire(int size, boolean direct) {
        int capacity = size < this._minCapacity ? size : capacityFor(bucketFor(size));
        ByteBufferPool.Bucket bucket = bucketFor(size, direct);
        if (bucket == null) {
            return newByteBuffer(capacity, direct);
        }
        ByteBuffer buffer = bucket.acquire();
        if (buffer == null) {
            return newByteBuffer(capacity, direct);
        }
        return buffer;
    }

    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public void release(ByteBuffer buffer) {
        boolean direct;
        ByteBufferPool.Bucket bucket;
        if (buffer != null) {
            int capacity = buffer.capacity();
            if (capacity != capacityFor(bucketFor(capacity))) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("ByteBuffer {} does not belong to this pool, discarding it", BufferUtil.toDetailString(buffer));
                }
            } else if (capacity <= this._maxCapacity && (bucket = bucketFor(capacity, (direct = buffer.isDirect()))) != null) {
                bucket.release(buffer);
                releaseExcessMemory(direct, (v1) -> {
                    releaseMemory(v1);
                });
            }
        }
    }

    private ByteBufferPool.Bucket newBucket(int key, boolean direct) {
        return new ByteBufferPool.Bucket(this, capacityFor(key), getMaxQueueLength(), updateMemory(direct));
    }

    @Override // org.eclipse.jetty.p023io.AbstractByteBufferPool
    public void clear() {
        clear();
        for (int i = 0; i < this._direct.length; i++) {
            this._direct[i].clear();
            this._indirect[i].clear();
        }
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void releaseMemory(boolean r6) {
        /*
            r5 = this;
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r7 = r0
            r0 = -1
            r9 = r0
            r0 = r5
            r1 = r6
            org.eclipse.jetty.io.ByteBufferPool$Bucket[] r0 = r0.bucketsFor(r1)
            r10 = r0
            r0 = 0
            r11 = r0
        L_0x0011:
            r0 = r11
            r1 = r10
            int r1 = r1.length
            if (r0 >= r1) goto L_0x0046
            r0 = r10
            r1 = r11
            r0 = r0[r1]
            r12 = r0
            r0 = r12
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002b
            goto L_0x0040
        L_0x002b:
            r0 = r12
            long r0 = r0.getLastUpdate()
            r13 = r0
            r0 = r13
            r1 = r7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0040
            r0 = r13
            r7 = r0
            r0 = r11
            r9 = r0
        L_0x0040:
            int r11 = r11 + 1
            goto L_0x0011
        L_0x0046:
            r0 = r9
            if (r0 < 0) goto L_0x0057
            r0 = r10
            r1 = r9
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            r0.clear()
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.ArrayByteBufferPool.releaseMemory(boolean):void");
    }

    protected int bucketFor(int capacity) {
        return (int) Math.ceil(((double) capacity) / ((double) getCapacityFactor()));
    }

    protected int capacityFor(int bucket) {
        return bucket * getCapacityFactor();
    }

    private ByteBufferPool.Bucket bucketFor(int capacity, boolean direct) {
        int bucket;
        if (capacity >= this._minCapacity && (bucket = bucketFor(capacity)) < this._direct.length) {
            return bucketsFor(direct)[bucket];
        }
        return null;
    }

    @ManagedAttribute("The number of pooled direct ByteBuffers")
    public long getDirectByteBufferCount() {
        return getByteBufferCount(true);
    }

    @ManagedAttribute("The number of pooled heap ByteBuffers")
    public long getHeapByteBufferCount() {
        return getByteBufferCount(false);
    }

    private long getByteBufferCount(boolean direct) {
        return Arrays.stream(bucketsFor(direct)).filter((v0) -> {
            return Objects.nonNull(v0);
        }).mapToLong((v0) -> {
            return v0.size();
        }).sum();
    }

    ByteBufferPool.Bucket[] bucketsFor(boolean direct) {
        return direct ? this._direct : this._indirect;
    }

    public boolean isDetailedDump() {
        return this._detailedDump;
    }

    public void setDetailedDump(boolean detailedDump) {
        this._detailedDump = detailedDump;
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        List<Object> dump = new ArrayList<>();
        dump.add(String.format("HeapMemory: %d/%d", Long.valueOf(getHeapMemory()), Long.valueOf(getMaxHeapMemory())));
        dump.add(String.format("DirectMemory: %d/%d", Long.valueOf(getDirectMemory()), Long.valueOf(getMaxDirectMemory())));
        List<ByteBufferPool.Bucket> indirect = (List) Arrays.stream(this._indirect).filter(b -> {
            return !b.isEmpty();
        }).collect(Collectors.toList());
        List<ByteBufferPool.Bucket> direct = (List) Arrays.stream(this._direct).filter(b -> {
            return !b.isEmpty();
        }).collect(Collectors.toList());
        if (isDetailedDump()) {
            dump.add(new DumpableCollection("Indirect Buckets", indirect));
            dump.add(new DumpableCollection("Direct Buckets", direct));
        } else {
            dump.add("Indirect Buckets size=" + indirect.size());
            dump.add("Direct Buckets size=" + direct.size());
        }
        Dumpable.dumpObjects(out, indent, this, dump);
    }

    public String toString() {
        return String.format("%s@%x{minBufferCapacity=%s, maxBufferCapacity=%s, maxQueueLength=%s, factor=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(this._minCapacity), Integer.valueOf(this._maxCapacity), Integer.valueOf(getMaxQueueLength()), Integer.valueOf(getCapacityFactor()));
    }
}
