package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;

@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/JdkBackedImmutableSet.class */
final class JdkBackedImmutableSet<E> extends IndexedImmutableSet<E> {
    private final Set<?> delegate;
    private final ImmutableList<E> delegateList;

    /* access modifiers changed from: package-private */
    public JdkBackedImmutableSet(Set<?> delegate, ImmutableList<E> delegateList) {
        this.delegate = delegate;
        this.delegateList = delegateList;
    }

    @Override // com.google.common.collect.IndexedImmutableSet
    E get(int index) {
        return this.delegateList.get(index);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object object) {
        return this.delegate.contains(object);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegateList.size();
    }
}
