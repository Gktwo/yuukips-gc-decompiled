package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: MpscArrayQueue.java */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueueProducerIndexField */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MpscArrayQueueProducerIndexField.class */
abstract class MpscArrayQueueProducerIndexField<E> extends MpscArrayQueueL1Pad<E> {
    private static final long P_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueProducerIndexField.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: package-private */
    public MpscArrayQueueProducerIndexField(int capacity) {
        super(capacity);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    final boolean casProducerIndex(long expect, long newValue) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, P_INDEX_OFFSET, expect, newValue);
    }
}
