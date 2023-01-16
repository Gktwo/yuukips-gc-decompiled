package org.jctools.queues.atomic;

/* compiled from: SpscAtomicArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpscAtomicArrayQueueColdField.class */
abstract class SpscAtomicArrayQueueColdField<E> extends AtomicReferenceArrayQueue<E> {
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    final int lookAheadStep = Math.min(capacity() / 4, MAX_LOOK_AHEAD_STEP);

    /* access modifiers changed from: package-private */
    public SpscAtomicArrayQueueColdField(int capacity) {
        super(capacity);
    }
}
