package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/collect/CompactLinkedHashSet.class */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int[] predecessor;
    private transient int[] successor;
    private transient int firstEntry;
    private transient int lastEntry;

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> set = createWithExpectedSize(collection.size());
        set.addAll(collection);
        return set;
    }

    public static <E> CompactLinkedHashSet<E> create(E... elements) {
        CompactLinkedHashSet<E> set = createWithExpectedSize(elements.length);
        Collections.addAll(set, elements);
        return set;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int expectedSize) {
        return new CompactLinkedHashSet<>(expectedSize);
    }

    CompactLinkedHashSet() {
    }

    CompactLinkedHashSet(int expectedSize) {
        super(expectedSize);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void init(int expectedSize, float loadFactor) {
        init(expectedSize, loadFactor);
        this.predecessor = new int[expectedSize];
        this.successor = new int[expectedSize];
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    private void succeeds(int pred, int succ) {
        if (pred == -2) {
            this.firstEntry = succ;
        } else {
            this.successor[pred] = succ;
        }
        if (succ == -2) {
            this.lastEntry = pred;
        } else {
            this.predecessor[succ] = pred;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int entryIndex, E object, int hash) {
        insertEntry(entryIndex, object, hash);
        succeeds(this.lastEntry, entryIndex);
        succeeds(entryIndex, -2);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void moveEntry(int dstIndex) {
        int srcIndex = size() - 1;
        moveEntry(dstIndex);
        succeeds(this.predecessor[dstIndex], this.successor[dstIndex]);
        if (srcIndex != dstIndex) {
            succeeds(this.predecessor[srcIndex], dstIndex);
            succeeds(dstIndex, this.successor[srcIndex]);
        }
        this.predecessor[srcIndex] = -1;
        this.successor[srcIndex] = -1;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
        Arrays.fill(this.predecessor, -1);
        Arrays.fill(this.successor, -1);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int newCapacity) {
        resizeEntries(newCapacity);
        int oldCapacity = this.predecessor.length;
        this.predecessor = Arrays.copyOf(this.predecessor, newCapacity);
        this.successor = Arrays.copyOf(this.successor, newCapacity);
        if (oldCapacity < newCapacity) {
            Arrays.fill(this.predecessor, oldCapacity, newCapacity, -1);
            Arrays.fill(this.successor, oldCapacity, newCapacity, -1);
        }
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] a) {
        return (T[]) ObjectArrays.toArrayImpl(this, a);
    }

    @Override // com.google.common.collect.CompactHashSet
    int firstEntryIndex() {
        return this.firstEntry;
    }

    @Override // com.google.common.collect.CompactHashSet
    int adjustAfterRemove(int indexBeforeRemove, int indexRemoved) {
        return indexBeforeRemove == size() ? indexRemoved : indexBeforeRemove;
    }

    @Override // com.google.common.collect.CompactHashSet
    int getSuccessor(int entryIndex) {
        return this.successor[entryIndex];
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.Collection, java.util.Set, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this, 17);
    }

    @Override // com.google.common.collect.CompactHashSet, java.lang.Iterable
    public void forEach(Consumer<? super E> action) {
        Preconditions.checkNotNull(action);
        int i = this.firstEntry;
        while (i != -2) {
            action.accept(this.elements[i]);
            i = this.successor[i];
        }
    }
}
