package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/SingletonImmutableSet.class */
public final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E element;
    @LazyInit
    private transient int cachedHashCode;

    /* access modifiers changed from: package-private */
    public SingletonImmutableSet(E element) {
        this.element = (E) Preconditions.checkNotNull(element);
    }

    SingletonImmutableSet(E element, int hashCode) {
        this.element = element;
        this.cachedHashCode = hashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object target) {
        return this.element.equals(target);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return Iterators.singletonIterator(this.element);
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return ImmutableList.m1437of((Object) this.element);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] dst, int offset) {
        dst[offset] = this.element;
        return offset + 1;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.lang.Object, java.util.Set
    public final int hashCode() {
        int code = this.cachedHashCode;
        if (code == 0) {
            int hashCode = this.element.hashCode();
            code = hashCode;
            this.cachedHashCode = hashCode;
        }
        return code;
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean isHashCodeFast() {
        return this.cachedHashCode != 0;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return '[' + this.element.toString() + ']';
    }
}
