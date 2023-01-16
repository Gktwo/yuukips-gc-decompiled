package org.eclipse.jetty.p023io;

/* renamed from: org.eclipse.jetty.io.LogarithmicArrayByteBufferPool */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/LogarithmicArrayByteBufferPool.class */
public class LogarithmicArrayByteBufferPool extends ArrayByteBufferPool {
    public LogarithmicArrayByteBufferPool() {
        this(-1, -1, -1);
    }

    public LogarithmicArrayByteBufferPool(int minCapacity, int maxCapacity) {
        this(minCapacity, maxCapacity, -1, -1, -1);
    }

    public LogarithmicArrayByteBufferPool(int minCapacity, int maxCapacity, int maxQueueLength) {
        this(minCapacity, maxCapacity, maxQueueLength, -1, -1);
    }

    public LogarithmicArrayByteBufferPool(int minCapacity, int maxCapacity, int maxQueueLength, long maxHeapMemory, long maxDirectMemory) {
        super(minCapacity, 1, maxCapacity, maxQueueLength, maxHeapMemory, maxDirectMemory);
    }

    @Override // org.eclipse.jetty.p023io.ArrayByteBufferPool
    protected int bucketFor(int capacity) {
        return 32 - Integer.numberOfLeadingZeros(capacity - 1);
    }

    @Override // org.eclipse.jetty.p023io.ArrayByteBufferPool
    protected int capacityFor(int bucket) {
        return 1 << bucket;
    }

    /* JADX WARN: Type inference failed for: r0v17, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.eclipse.jetty.p023io.ArrayByteBufferPool
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
            if (r0 < 0) goto L_0x005d
            r0 = r10
            r1 = r9
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            java.nio.ByteBuffer r0 = r0.acquire()
            r0 = r11
            r0.resetUpdateTime()
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.p023io.LogarithmicArrayByteBufferPool.releaseMemory(boolean):void");
    }
}
