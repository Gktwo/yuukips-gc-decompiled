package p013io.netty.util.internal.shaded.org.jctools.queues;

import p013io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess;

/* compiled from: MpscArrayQueue.java */
/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueueProducerLimitField */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/MpscArrayQueueProducerLimitField.class */
public abstract class MpscArrayQueueProducerLimitField<E> extends MpscArrayQueueMidPad<E> {
    private static final long P_LIMIT_OFFSET = UnsafeAccess.fieldOffset(MpscArrayQueueProducerLimitField.class, "producerLimit");
    private volatile long producerLimit;

    /* access modifiers changed from: package-private */
    public MpscArrayQueueProducerLimitField(int capacity) {
        super(capacity);
        this.producerLimit = (long) capacity;
    }

    final long lvProducerLimit() {
        return this.producerLimit;
    }

    final void soProducerLimit(long newValue) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_LIMIT_OFFSET, newValue);
    }
}
