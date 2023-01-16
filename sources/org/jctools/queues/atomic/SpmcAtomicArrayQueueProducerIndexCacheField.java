package org.jctools.queues.atomic;

/* compiled from: SpmcAtomicArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpmcAtomicArrayQueueProducerIndexCacheField.class */
public abstract class SpmcAtomicArrayQueueProducerIndexCacheField<E> extends SpmcAtomicArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    /* access modifiers changed from: package-private */
    public SpmcAtomicArrayQueueProducerIndexCacheField(int capacity) {
        super(capacity);
    }

    protected final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    protected final void svProducerIndexCache(long newValue) {
        this.producerIndexCache = newValue;
    }
}
