package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: MpscArrayQueue.java */
/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueueConsumerIndexField */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MpscArrayQueueConsumerIndexField.class */
public abstract class MpscArrayQueueConsumerIndexField<E> extends MpscArrayQueueL2Pad<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueConsumerIndexField.class, "consumerIndex");
    private volatile long consumerIndex;

    /* access modifiers changed from: package-private */
    public MpscArrayQueueConsumerIndexField(int capacity) {
        super(capacity);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    final long lpConsumerIndex() {
        return UnsafeAccess.UNSAFE.getLong(this, C_INDEX_OFFSET);
    }

    final void soConsumerIndex(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, C_INDEX_OFFSET, newValue);
    }
}
