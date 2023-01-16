package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/AbstractMapBasedMultiset.class */
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private transient Map<E, Count> backingMap;
    private transient long size;
    @GwtIncompatible
    private static final long serialVersionUID = -2250766705698539974L;

    static /* synthetic */ long access$010(AbstractMapBasedMultiset x0) {
        long j = x0.size;
        x0.size = j - 1;
        return j;
    }

    /* access modifiers changed from: protected */
    public AbstractMapBasedMultiset(Map<E, Count> backingMap) {
        Preconditions.checkArgument(backingMap.isEmpty());
        this.backingMap = backingMap;
    }

    void setBackingMap(Map<E, Count> backingMap) {
        this.backingMap = backingMap;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        return entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        final Iterator<Map.Entry<E, Count>> backingEntries = this.backingMap.entrySet().iterator();
        return new Iterator<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.1
            Map.Entry<E, Count> toRemove;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return backingEntries.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                Map.Entry<E, Count> mapEntry = (Map.Entry) backingEntries.next();
                this.toRemove = mapEntry;
                return mapEntry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                AbstractMapBasedMultiset.this.size -= (long) this.toRemove.getValue().getAndSet(0);
                backingEntries.remove();
                this.toRemove = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<Multiset.Entry<E>> entryIterator() {
        final Iterator<Map.Entry<E, Count>> backingEntries = this.backingMap.entrySet().iterator();
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2
            Map.Entry<E, Count> toRemove;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return backingEntries.hasNext();
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                final Map.Entry<E, Count> mapEntry = (Map.Entry) backingEntries.next();
                this.toRemove = mapEntry;
                return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.AbstractMapBasedMultiset.2.1
                    @Override // com.google.common.collect.Multiset.Entry
                    public E getElement() {
                        return (E) mapEntry.getKey();
                    }

                    @Override // com.google.common.collect.Multiset.Entry
                    public int getCount() {
                        Count frequency;
                        Count count = (Count) mapEntry.getValue();
                        if ((count == null || count.get() == 0) && (frequency = (Count) AbstractMapBasedMultiset.this.backingMap.get(getElement())) != null) {
                            return frequency.get();
                        }
                        if (count == null) {
                            return 0;
                        }
                        return count.get();
                    }
                };
            }

            @Override // java.util.Iterator
            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                AbstractMapBasedMultiset.this.size -= (long) this.toRemove.getValue().getAndSet(0);
                backingEntries.remove();
                this.toRemove = null;
            }
        };
    }

    @Override // com.google.common.collect.Multiset
    public void forEachEntry(ObjIntConsumer<? super E> action) {
        Preconditions.checkNotNull(action);
        this.backingMap.forEach(element, count -> {
            action.accept(element, count.get());
        });
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (Count frequency : this.backingMap.values()) {
            frequency.set(0);
        }
        this.backingMap.clear();
        this.size = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return this.backingMap.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(this.size);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return new MapBasedMultisetIterator();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/AbstractMapBasedMultiset$MapBasedMultisetIterator.class */
    private class MapBasedMultisetIterator implements Iterator<E> {
        final Iterator<Map.Entry<E, Count>> entryIterator;
        Map.Entry<E, Count> currentEntry;
        int occurrencesLeft;
        boolean canRemove;

        MapBasedMultisetIterator() {
            this.entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.occurrencesLeft > 0 || this.entryIterator.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.occurrencesLeft == 0) {
                this.currentEntry = this.entryIterator.next();
                this.occurrencesLeft = this.currentEntry.getValue().get();
            }
            this.occurrencesLeft--;
            this.canRemove = true;
            return this.currentEntry.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.currentEntry.getValue().get() <= 0) {
                throw new ConcurrentModificationException();
            }
            if (this.currentEntry.getValue().addAndGet(-1) == 0) {
                this.entryIterator.remove();
            }
            AbstractMapBasedMultiset.access$010(AbstractMapBasedMultiset.this);
            this.canRemove = false;
        }
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object element) {
        Count frequency = (Count) Maps.safeGet(this.backingMap, element);
        if (frequency == null) {
            return 0;
        }
        return frequency.get();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E element, int occurrences) {
        int oldCount;
        if (occurrences == 0) {
            return count(element);
        }
        Preconditions.checkArgument(occurrences > 0, "occurrences cannot be negative: %s", occurrences);
        Count frequency = this.backingMap.get(element);
        if (frequency == null) {
            oldCount = 0;
            this.backingMap.put(element, new Count(occurrences));
        } else {
            oldCount = frequency.get();
            long newCount = ((long) oldCount) + ((long) occurrences);
            Preconditions.checkArgument(newCount <= 2147483647L, "too many occurrences: %s", newCount);
            frequency.add(occurrences);
        }
        this.size += (long) occurrences;
        return oldCount;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(Object element, int occurrences) {
        int numberRemoved;
        if (occurrences == 0) {
            return count(element);
        }
        Preconditions.checkArgument(occurrences > 0, "occurrences cannot be negative: %s", occurrences);
        Count frequency = this.backingMap.get(element);
        if (frequency == null) {
            return 0;
        }
        int oldCount = frequency.get();
        if (oldCount > occurrences) {
            numberRemoved = occurrences;
        } else {
            numberRemoved = oldCount;
            this.backingMap.remove(element);
        }
        frequency.add(-numberRemoved);
        this.size -= (long) numberRemoved;
        return oldCount;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E element, int count) {
        int oldCount;
        CollectPreconditions.checkNonnegative(count, "count");
        if (count == 0) {
            oldCount = getAndSet(this.backingMap.remove(element), count);
        } else {
            Count existingCounter = this.backingMap.get(element);
            oldCount = getAndSet(existingCounter, count);
            if (existingCounter == null) {
                this.backingMap.put(element, new Count(count));
            }
        }
        this.size += (long) (count - oldCount);
        return oldCount;
    }

    private static int getAndSet(Count i, int count) {
        if (i == null) {
            return 0;
        }
        return i.getAndSet(count);
    }

    @GwtIncompatible
    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }
}
