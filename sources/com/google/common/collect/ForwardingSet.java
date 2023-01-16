package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Set;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ForwardingSet.class */
public abstract class ForwardingSet<E> extends ForwardingCollection<E> implements Set<E> {
    /* access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Set<E> delegate();

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public boolean equals(Object object) {
        return object == this || delegate().equals(object);
    }

    @Override // java.util.Collection, java.lang.Object, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemoveAll(Collection<?> collection) {
        return Sets.removeAllImpl(this, (Collection) Preconditions.checkNotNull(collection));
    }

    protected boolean standardEquals(Object object) {
        return Sets.equalsImpl(this, object);
    }

    protected int standardHashCode() {
        return Sets.hashCodeImpl(this);
    }
}
