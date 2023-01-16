package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingQueue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@CanIgnoreReturnValue
@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/ForwardingBlockingQueue.class */
public abstract class ForwardingBlockingQueue<E> extends ForwardingQueue<E> implements BlockingQueue<E> {
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract BlockingQueue<E> delegate();

    protected ForwardingBlockingQueue() {
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c, int maxElements) {
        return delegate().drainTo(c, maxElements);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c) {
        return delegate().drainTo(c);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().offer(e, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().poll(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        delegate().put(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }
}
