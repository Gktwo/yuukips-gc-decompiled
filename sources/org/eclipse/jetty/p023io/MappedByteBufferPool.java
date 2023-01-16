package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.eclipse.jetty.p023io.ByteBufferPool;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* renamed from: org.eclipse.jetty.io.MappedByteBufferPool */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/MappedByteBufferPool.class */
public class MappedByteBufferPool extends AbstractByteBufferPool implements Dumpable {
    private static final Logger LOG = Log.getLogger(MappedByteBufferPool.class);
    private final ConcurrentMap<Integer, ByteBufferPool.Bucket> _directBuffers;
    private final ConcurrentMap<Integer, ByteBufferPool.Bucket> _heapBuffers;
    private final Function<Integer, ByteBufferPool.Bucket> _newBucket;
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

    public MappedByteBufferPool() {
        this(-1);
    }

    public MappedByteBufferPool(int factor) {
        this(factor, -1);
    }

    public MappedByteBufferPool(int factor, int maxQueueLength) {
        this(factor, maxQueueLength, null);
    }

    public MappedByteBufferPool(int factor, int maxQueueLength, Function<Integer, ByteBufferPool.Bucket> newBucket) {
        this(factor, maxQueueLength, newBucket, 0, 0);
    }

    public MappedByteBufferPool(int factor, int maxQueueLength, Function<Integer, ByteBufferPool.Bucket> newBucket, long maxHeapMemory, long maxDirectMemory) {
        super(factor, maxQueueLength, maxHeapMemory, maxDirectMemory);
        this._directBuffers = new ConcurrentHashMap();
        this._heapBuffers = new ConcurrentHashMap();
        this._detailedDump = false;
        this._newBucket = newBucket;
    }

    private ByteBufferPool.Bucket newBucket(int key, boolean direct) {
        return this._newBucket != null ? this._newBucket.apply(Integer.valueOf(key)) : new ByteBufferPool.Bucket(this, capacityFor(key), getMaxQueueLength(), updateMemory(direct));
    }

    @Override // org.eclipse.jetty.p023io.ByteBufferPool
    public ByteBuffer acquire(int size, boolean direct) {
        int b = bucketFor(size);
        int capacity = capacityFor(b);
        ByteBufferPool.Bucket bucket = bucketsFor(direct).get(Integer.valueOf(b));
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
        if (buffer != null) {
            int capacity = buffer.capacity();
            int b = bucketFor(capacity);
            if (capacity == capacityFor(b)) {
                boolean direct = buffer.isDirect();
                bucketsFor(direct).computeIfAbsent(Integer.valueOf(b), i -> {
                    return newBucket(direct.intValue(), direct);
                }).release(buffer);
                releaseExcessMemory(direct, (v1) -> {
                    releaseMemory(v1);
                });
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("ByteBuffer {} does not belong to this pool, discarding it", BufferUtil.toDetailString(buffer));
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractByteBufferPool
    public void clear() {
        clear();
        this._directBuffers.values().forEach((v0) -> {
            v0.clear();
        });
        this._directBuffers.clear();
        this._heapBuffers.values().forEach((v0) -> {
            v0.clear();
        });
        this._heapBuffers.clear();
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
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
            java.util.concurrent.ConcurrentMap r0 = r0.bucketsFor(r1)
            r10 = r0
            r0 = r10
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r11 = r0
        L_0x001c:
            r0 = r11
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x006c
            r0 = r11
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r12 = r0
            r0 = r12
            java.lang.Object r0 = r0.getValue()
            org.eclipse.jetty.io.ByteBufferPool$Bucket r0 = (org.eclipse.jetty.p023io.ByteBufferPool.Bucket) r0
            r13 = r0
            r0 = r13
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0049
            goto L_0x001c
        L_0x0049:
            r0 = r13
            long r0 = r0.getLastUpdate()
            r14 = r0
            r0 = r14
            r1 = r7
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0069
            r0 = r14
            r7 = r0
            r0 = r12
            java.lang.Object r0 = r0.getKey()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r9 = r0
        L_0x0069:
            goto L_0x001c
        L_0x006c:
            r0 = r9
            if (r0 < 0) goto L_0x008c
            r0 = r10
            r1 = r9
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r0 = r0.remove(r1)
            org.eclipse.jetty.io.ByteBufferPool$Bucket r0 = (org.eclipse.jetty.p023io.ByteBufferPool.Bucket) r0
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L_0x008c
            r0 = r11
            r0.clear()
        L_0x008c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.MappedByteBufferPool.releaseMemory(boolean):void");
    }

    protected int bucketFor(int capacity) {
        return (int) Math.ceil(((double) capacity) / ((double) getCapacityFactor()));
    }

    protected int capacityFor(int bucket) {
        return bucket * getCapacityFactor();
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
        return bucketsFor(direct).values().stream().mapToLong((v0) -> {
            return v0.size();
        }).sum();
    }

    ConcurrentMap<Integer, ByteBufferPool.Bucket> bucketsFor(boolean direct) {
        return direct ? this._directBuffers : this._heapBuffers;
    }

    /* renamed from: org.eclipse.jetty.io.MappedByteBufferPool$Tagged */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/MappedByteBufferPool$Tagged.class */
    public static class Tagged extends MappedByteBufferPool {
        private final AtomicInteger tag = new AtomicInteger();

        @Override // org.eclipse.jetty.p023io.MappedByteBufferPool, org.eclipse.jetty.p023io.AbstractByteBufferPool
        public /* bridge */ /* synthetic */ long getMemory(boolean z) {
            return getMemory(z);
        }

        @Override // org.eclipse.jetty.p023io.MappedByteBufferPool, org.eclipse.jetty.p023io.AbstractByteBufferPool
        @ManagedAttribute("The max num of bytes that can be retained from heap ByteBuffers")
        public /* bridge */ /* synthetic */ long getMaxHeapMemory() {
            return getMaxHeapMemory();
        }

        @Override // org.eclipse.jetty.p023io.MappedByteBufferPool, org.eclipse.jetty.p023io.AbstractByteBufferPool
        @ManagedAttribute("The max num of bytes that can be retained from direct ByteBuffers")
        public /* bridge */ /* synthetic */ long getMaxDirectMemory() {
            return getMaxDirectMemory();
        }

        @Override // org.eclipse.jetty.p023io.MappedByteBufferPool, org.eclipse.jetty.p023io.AbstractByteBufferPool
        @ManagedAttribute("The bytes retained by heap ByteBuffers")
        public /* bridge */ /* synthetic */ long getHeapMemory() {
            return getHeapMemory();
        }

        @Override // org.eclipse.jetty.p023io.MappedByteBufferPool, org.eclipse.jetty.p023io.AbstractByteBufferPool
        @ManagedAttribute("The bytes retained by direct ByteBuffers")
        public /* bridge */ /* synthetic */ long getDirectMemory() {
            return getDirectMemory();
        }

        @Override // org.eclipse.jetty.p023io.ByteBufferPool
        public ByteBuffer newByteBuffer(int capacity, boolean direct) {
            ByteBuffer buffer = newByteBuffer(capacity + 4, direct);
            buffer.limit(buffer.capacity());
            buffer.putInt(this.tag.incrementAndGet());
            ByteBuffer slice = buffer.slice();
            BufferUtil.clear(slice);
            return slice;
        }
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
        if (isDetailedDump()) {
            dump.add(new DumpableCollection("Indirect Buckets", this._heapBuffers.values()));
            dump.add(new DumpableCollection("Direct Buckets", this._directBuffers.values()));
        } else {
            dump.add("Indirect Buckets size=" + this._heapBuffers.size());
            dump.add("Direct Buckets size=" + this._directBuffers.size());
        }
        Dumpable.dumpObjects(out, indent, this, dump);
    }

    public String toString() {
        return String.format("%s@%x{maxQueueLength=%s, factor=%s}", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getMaxQueueLength()), Integer.valueOf(getCapacityFactor()));
    }
}
