package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Spliterator;
import java.util.function.Consumer;

/* access modifiers changed from: package-private */
@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/IndexedImmutableSet.class */
public abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    abstract E get(int i);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return CollectSpliterators.indexed(size(), 1297, this::get);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        Preconditions.checkNotNull(consumer);
        int n = size();
        for (int i = 0; i < n; i++) {
            consumer.accept(get(i));
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] dst, int offset) {
        return asList().copyIntoArray(dst, offset);
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return new ImmutableAsList<E>() { // from class: com.google.common.collect.IndexedImmutableSet.1
            @Override // java.util.List
            public E get(int index) {
                return (E) IndexedImmutableSet.this.get(index);
            }

            /* access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableAsList, com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            @Override // com.google.common.collect.ImmutableAsList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return IndexedImmutableSet.this.size();
            }

            @Override // com.google.common.collect.ImmutableAsList
            ImmutableCollection<E> delegateCollection() {
                return IndexedImmutableSet.this;
            }
        };
    }
}
