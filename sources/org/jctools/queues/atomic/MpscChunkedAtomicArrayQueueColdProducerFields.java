package org.jctools.queues.atomic;

import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;

/* compiled from: MpscChunkedAtomicArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/MpscChunkedAtomicArrayQueueColdProducerFields.class */
abstract class MpscChunkedAtomicArrayQueueColdProducerFields<E> extends BaseMpscLinkedAtomicArrayQueue<E> {
    protected final long maxQueueCapacity;

    /* access modifiers changed from: package-private */
    public MpscChunkedAtomicArrayQueueColdProducerFields(int initialCapacity, int maxCapacity) {
        super(initialCapacity);
        RangeUtil.checkGreaterThanOrEqual(maxCapacity, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(initialCapacity), Pow2.roundToPowerOfTwo(maxCapacity), "initialCapacity");
        this.maxQueueCapacity = ((long) Pow2.roundToPowerOfTwo(maxCapacity)) << 1;
    }
}
