package org.jctools.queues;

/* compiled from: SpmcArrayQueue.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/jctools/queues/SpmcArrayQueueProducerIndexCacheField.class */
public abstract class SpmcArrayQueueProducerIndexCacheField<E> extends SpmcArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    /* access modifiers changed from: package-private */
    public SpmcArrayQueueProducerIndexCacheField(int capacity) {
        super(capacity);
    }

    protected final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    protected final void svProducerIndexCache(long newValue) {
        this.producerIndexCache = newValue;
    }
}
