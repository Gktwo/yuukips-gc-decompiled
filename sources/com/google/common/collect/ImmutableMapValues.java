package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMapValues.class */
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    private final ImmutableMap<K, V> map;

    /* access modifiers changed from: package-private */
    public ImmutableMapValues(ImmutableMap<K, V> map) {
        this.map = map;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<V> iterator() {
        return new UnmodifiableIterator<V>() { // from class: com.google.common.collect.ImmutableMapValues.1
            final UnmodifiableIterator<Map.Entry<K, V>> entryItr;

            {
                this.entryItr = ImmutableMapValues.this.map.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.entryItr.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                return this.entryItr.next().getValue();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<V> spliterator() {
        return CollectSpliterators.map(this.map.entrySet().spliterator(), (v0) -> {
            return v0.getValue();
        });
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object object) {
        return object != null && Iterators.contains(iterator(), object);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> entryList = this.map.entrySet().asList();
        return new ImmutableAsList<V>() { // from class: com.google.common.collect.ImmutableMapValues.2
            @Override // java.util.List
            public V get(int index) {
                return (V) ((Map.Entry) entryList.get(index)).getValue();
            }

            @Override // com.google.common.collect.ImmutableAsList
            ImmutableCollection<V> delegateCollection() {
                return ImmutableMapValues.this;
            }
        };
    }

    @Override // java.lang.Iterable
    @GwtIncompatible
    public void forEach(Consumer<? super V> action) {
        Preconditions.checkNotNull(action);
        this.map.forEach(k, v -> {
            action.accept(v);
        });
    }

    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new SerializedForm(this.map);
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMapValues$SerializedForm.class */
    private static class SerializedForm<V> implements Serializable {
        final ImmutableMap<?, V> map;
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableMap<?, V> map) {
            this.map = map;
        }

        Object readResolve() {
            return this.map.values();
        }
    }
}
