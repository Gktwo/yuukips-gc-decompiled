package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.Pow2;
import p013io.netty.util.internal.shaded.org.jctools.util.RangeUtil;

/* compiled from: MpscChunkedArrayQueue.java */
/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MpscChunkedArrayQueueColdProducerFields */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MpscChunkedArrayQueueColdProducerFields.class */
public abstract class MpscChunkedArrayQueueColdProducerFields<E> extends BaseMpscLinkedArrayQueue<E> {
    protected final long maxQueueCapacity;

    /* access modifiers changed from: package-private */
    public MpscChunkedArrayQueueColdProducerFields(int initialCapacity, int maxCapacity) {
        super(initialCapacity);
        RangeUtil.checkGreaterThanOrEqual(maxCapacity, 4, "maxCapacity");
        RangeUtil.checkLessThan(Pow2.roundToPowerOfTwo(initialCapacity), Pow2.roundToPowerOfTwo(maxCapacity), "initialCapacity");
        this.maxQueueCapacity = ((long) Pow2.roundToPowerOfTwo(maxCapacity)) << 1;
    }
}
