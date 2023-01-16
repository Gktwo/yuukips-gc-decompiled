package org.jctools.queues;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* compiled from: MpscChunkedArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/MpscChunkedArrayQueueColdProducerFields.class */
abstract class MpscChunkedArrayQueueColdProducerFields<E> extends BaseMpscLinkedArrayQueue<E> {
    protected final long maxQueueCapacity;

    /* access modifiers changed from: package-private */
    public MpscChunkedArrayQueueColdProducerFields(int initialCapacity, int maxCapacity) {
        super(initialCapacity);
        RangeUtil.checkGreaterThanOrEqual(maxCapacity, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(initialCapacity), Pow2.roundToPowerOfTwo(maxCapacity), "initialCapacity");
        this.maxQueueCapacity = ((long) Pow2.roundToPowerOfTwo(maxCapacity)) << 1;
    }
}
