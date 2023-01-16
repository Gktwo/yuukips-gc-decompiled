package org.jctools.queues;

import org.jctools.util.UnsafeLongArrayAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/ConcurrentSequencedCircularArrayQueue.class */
abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    protected final long[] sequenceBuffer;

    public ConcurrentSequencedCircularArrayQueue(int capacity) {
        super(capacity);
        int actualCapacity = (int) (this.mask + 1);
        this.sequenceBuffer = UnsafeLongArrayAccess.allocateLongArray(actualCapacity);
        for (long i = 0; i < ((long) actualCapacity); i++) {
            UnsafeLongArrayAccess.soLongElement(this.sequenceBuffer, UnsafeLongArrayAccess.calcCircularLongElementOffset(i, this.mask), i);
        }
    }
}
