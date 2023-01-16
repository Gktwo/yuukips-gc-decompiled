package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ForwardingIterator.class */
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Iterator<T> delegate();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return delegate().hasNext();
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public T next() {
        return delegate().next();
    }

    @Override // java.util.Iterator
    public void remove() {
        delegate().remove();
    }
}
