package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Predicate;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableCollection.class */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    static final int SPLITERATOR_CHARACTERISTICS = 1296;
    private static final Object[] EMPTY_ARRAY = new Object[0];

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    @Override // java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, (int) SPLITERATOR_CHARACTERISTICS);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object[]] */
    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] other) {
        Preconditions.checkNotNull(other);
        int size = size();
        if (other.length < size) {
            Object[] internal = internalArray();
            if (internal != null) {
                return (T[]) Platform.copy(internal, internalArrayStart(), internalArrayEnd(), other);
            }
            other = ObjectArrays.newArray(other, size);
        } else if (other.length > size) {
            other[size] = null;
        }
        copyIntoArray(other, 0);
        return other;
    }

    Object[] internalArray() {
        return null;
    }

    int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> newElements) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> oldElements) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> elementsToKeep) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        switch (size()) {
            case 0:
                return ImmutableList.m1438of();
            case 1:
                return ImmutableList.m1437of((Object) iterator().next());
            default:
                return new RegularImmutableAsList(this, toArray());
        }
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int copyIntoArray(Object[] dst, int offset) {
        UnmodifiableIterator<E> it = iterator();
        while (it.hasNext()) {
            offset++;
            dst[offset] = it.next();
        }
        return offset;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableCollection$Builder.class */
    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        @CanIgnoreReturnValue
        public abstract Builder<E> add(E e);

        public abstract ImmutableCollection<E> build();

        /* access modifiers changed from: package-private */
        public static int expandedCapacity(int oldCapacity, int minCapacity) {
            if (minCapacity < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int newCapacity = oldCapacity + (oldCapacity >> 1) + 1;
            if (newCapacity < minCapacity) {
                newCapacity = Integer.highestOneBit(minCapacity - 1) << 1;
            }
            if (newCapacity < 0) {
                newCapacity = Integer.MAX_VALUE;
            }
            return newCapacity;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... elements) {
            for (E element : elements) {
                add((Builder<E>) element);
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.ImmutableCollection$Builder<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> elements) {
            Iterator<? extends E> it = elements.iterator();
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.ImmutableCollection$Builder<E> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> elements) {
            while (elements.hasNext()) {
                add((Builder<E>) elements.next());
            }
            return this;
        }
    }
}
