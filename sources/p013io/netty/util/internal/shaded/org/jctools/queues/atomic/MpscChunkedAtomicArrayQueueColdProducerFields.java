package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import p013io.netty.util.internal.shaded.org.jctools.util.Pow2;
import p013io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

/* compiled from: MpscChunkedAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueueColdProducerFields */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/MpscChunkedAtomicArrayQueueColdProducerFields.class */
public abstract class MpscChunkedAtomicArrayQueueColdProducerFields<E> extends BaseMpscLinkedAtomicArrayQueue<E> {
    protected final long maxQueueCapacity;

    /* access modifiers changed from: package-private */
    public MpscChunkedAtomicArrayQueueColdProducerFields(int initialCapacity, int maxCapacity) {
        super(initialCapacity);
        RangeUtil.checkGreaterThanOrEqual(maxCapacity, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(initialCapacity), Pow2.roundToPowerOfTwo(maxCapacity), "initialCapacity");
        this.maxQueueCapacity = ((long) Pow2.roundToPowerOfTwo(maxCapacity)) << 1;
    }
}
