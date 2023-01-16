package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/PeekingIterator.class */
public interface PeekingIterator<E> extends Iterator<E> {
    E peek();

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    E next();

    @Override // java.util.Iterator
    void remove();
}
