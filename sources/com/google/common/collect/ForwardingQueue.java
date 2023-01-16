package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ForwardingQueue.class */
public abstract class ForwardingQueue<E> extends ForwardingCollection<E> implements Queue<E> {
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E o) {
        return delegate().offer(o);
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E remove() {
        return delegate().remove();
    }

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    protected boolean standardOffer(E e) {
        try {
            return add(e);
        } catch (IllegalStateException e2) {
            return false;
        }
    }

    protected E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    protected E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException e) {
            return null;
        }
    }
}
