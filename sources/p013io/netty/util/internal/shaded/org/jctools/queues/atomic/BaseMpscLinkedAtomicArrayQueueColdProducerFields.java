package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: BaseMpscLinkedAtomicArrayQueue.java */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueueColdProducerFields */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/BaseMpscLinkedAtomicArrayQueueColdProducerFields.class */
abstract class BaseMpscLinkedAtomicArrayQueueColdProducerFields<E> extends BaseMpscLinkedAtomicArrayQueuePad3<E> {
    private static final AtomicLongFieldUpdater<BaseMpscLinkedAtomicArrayQueueColdProducerFields> P_LIMIT_UPDATER = AtomicLongFieldUpdater.newUpdater(BaseMpscLinkedAtomicArrayQueueColdProducerFields.class, "producerLimit");
    private volatile long producerLimit;
    protected long producerMask;
    protected AtomicReferenceArray<E> producerBuffer;

    final long lvProducerLimit() {
        return this.producerLimit;
    }

    final boolean casProducerLimit(long expect, long newValue) {
        return P_LIMIT_UPDATER.compareAndSet(this, expect, newValue);
    }

    final void soProducerLimit(long newValue) {
        P_LIMIT_UPDATER.lazySet(this, newValue);
    }
}
