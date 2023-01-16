package org.jctools.queues;

import org.jctools.util.UnsafeAccess;

/* compiled from: MpscArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/MpscArrayQueueProducerLimitField.class */
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
