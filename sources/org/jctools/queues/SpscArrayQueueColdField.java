package org.jctools.queues;

/* compiled from: SpscArrayQueue.java */
/* loaded from: grasscutter.jar:org/jctools/queues/SpscArrayQueueColdField.class */
abstract class SpscArrayQueueColdField<E> extends ConcurrentCircularArrayQueue<E> {
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    final int lookAheadStep = Math.min(capacity() / 4, MAX_LOOK_AHEAD_STEP);

    /* access modifiers changed from: package-private */
    public SpscArrayQueueColdField(int capacity) {
        super(capacity);
    }
}
