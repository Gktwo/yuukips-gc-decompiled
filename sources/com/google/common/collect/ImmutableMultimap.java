package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultimap.class */
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public abstract ImmutableCollection<V> get(K k);

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.AbstractMultimap, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, java.lang.Object, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m1413of() {
        return ImmutableListMultimap.m1425of();
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m1412of(K k1, V v1) {
        return ImmutableListMultimap.m1424of((Object) k1, (Object) v1);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m1411of(K k1, V v1, K k2, V v2) {
        return ImmutableListMultimap.m1423of((Object) k1, (Object) v1, (Object) k2, (Object) v2);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m1410of(K k1, V v1, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.m1422of((Object) k1, (Object) v1, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m1409of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.m1421of((Object) k1, (Object) v1, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    /* renamed from: of */
    public static <K, V> ImmutableMultimap<K, V> m1408of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.m1420of((Object) k1, (Object) v1, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultimap$Builder.class */
    public static class Builder<K, V> {
        Map<K, Collection<V>> builderMap = Platform.preservesInsertionOrderOnPutsMap();
        Comparator<? super K> keyComparator;
        Comparator<? super V> valueComparator;

        Collection<V> newMutableValueCollection() {
            return new ArrayList();
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(K key, V value) {
            CollectPreconditions.checkEntryNotNull(key, value);
            Collection<V> valueCollection = this.builderMap.get(key);
            if (valueCollection == null) {
                Map<K, Collection<V>> map = this.builderMap;
                Collection<V> newMutableValueCollection = newMutableValueCollection();
                valueCollection = newMutableValueCollection;
                map.put(key, newMutableValueCollection);
            }
            valueCollection.add(value);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            for (Map.Entry<? extends K, ? extends V> entry : entries) {
                put(entry);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K key, Iterable<? extends V> values) {
            if (key == null) {
                throw new NullPointerException("null key in entry: null=" + Iterables.toString(values));
            }
            Collection<V> valueCollection = this.builderMap.get(key);
            if (valueCollection != null) {
                for (V value : values) {
                    CollectPreconditions.checkEntryNotNull(key, value);
                    valueCollection.add(value);
                }
                return this;
            }
            Iterator<? extends V> valuesItr = values.iterator();
            if (!valuesItr.hasNext()) {
                return this;
            }
            Collection<V> valueCollection2 = newMutableValueCollection();
            while (valuesItr.hasNext()) {
                V value2 = (V) valuesItr.next();
                CollectPreconditions.checkEntryNotNull(key, value2);
                valueCollection2.add(value2);
            }
            this.builderMap.put(key, valueCollection2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K key, V... values) {
            return putAll((Builder<K, V>) key, Arrays.asList(values));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), entry.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(keyComparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(valueComparator);
            return this;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<K, V> combine(Builder<K, V> other) {
            for (Map.Entry<K, Collection<V>> entry : other.builderMap.entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), entry.getValue());
            }
            return this;
        }

        public ImmutableMultimap<K, V> build() {
            Collection<Map.Entry<K, Collection<V>>> mapEntries = this.builderMap.entrySet();
            if (this.keyComparator != null) {
                mapEntries = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(mapEntries);
            }
            return ImmutableListMultimap.fromMapEntries(mapEntries, this.valueComparator);
        }
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> kvMultimap = (ImmutableMultimap) multimap;
            if (!kvMultimap.isPartialView()) {
                return kvMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((Multimap) multimap);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return ImmutableListMultimap.copyOf((Iterable) entries);
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultimap$FieldSettersHolder.class */
    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");

        FieldSettersHolder() {
        }
    }

    /* access modifiers changed from: package-private */
    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> map, int size) {
        this.map = map;
        this.size = size;
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> removeAll(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> replaceValues(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    boolean isPartialView() {
        return this.map.isPartialView();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(Object value) {
        return value != null && containsValue(value);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: com.google.common.collect.ImmutableMap<K, ? extends com.google.common.collect.ImmutableCollection<V>>, com.google.common.collect.ImmutableMap<K, java.util.Collection<V>> */
    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableMap<K, Collection<V>> asMap() {
        return (ImmutableMap<K, ? extends ImmutableCollection<V>>) this.map;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) entries();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultimap$EntryCollection.class */
    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        @Weak
        final ImmutableMultimap<K, V> multimap;
        private static final long serialVersionUID = 0;

        EntryCollection(ImmutableMultimap<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) object;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableMultimap.1
            final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> asMapItr;
            K currentKey = null;
            Iterator<V> valueItr = Iterators.emptyIterator();

            {
                this.asMapItr = ImmutableMultimap.this.map.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.valueItr.hasNext() || this.asMapItr.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                if (!this.valueItr.hasNext()) {
                    Map.Entry<K, ? extends ImmutableCollection<V>> entry = (Map.Entry) this.asMapItr.next();
                    this.currentKey = entry.getKey();
                    this.valueItr = ((ImmutableCollection) entry.getValue()).iterator();
                }
                return Maps.immutableEntry(this.currentKey, this.valueItr.next());
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return CollectSpliterators.flatMap(asMap().entrySet().spliterator(), keyToValueCollectionEntry -> {
            Object key = keyToValueCollectionEntry.getKey();
            return CollectSpliterators.map(((Collection) keyToValueCollectionEntry.getValue()).spliterator(), value -> {
                return Maps.immutableEntry(key, value);
            });
        }, 64 | (this instanceof SetMultimap ? 1 : 0), (long) size());
    }

    @Override // com.google.common.collect.Multimap
    public void forEach(BiConsumer<? super K, ? super V> action) {
        Preconditions.checkNotNull(action);
        asMap().forEach(key, valueCollection -> {
            valueCollection.forEach(value -> {
                action.accept(key, value);
            });
        });
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) keys();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultimap$Keys.class */
    public class Keys extends ImmutableMultiset<K> {
        Keys() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object object) {
            return ImmutableMultimap.this.containsKey(object);
        }

        @Override // com.google.common.collect.Multiset
        public int count(Object element) {
            Collection<V> values = (Collection) ImmutableMultimap.this.map.get(element);
            if (values == null) {
                return 0;
            }
            return values.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        Multiset.Entry<K> getEntry(int index) {
            Map.Entry<K, ? extends Collection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(index);
            return Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultimap$KeysSerializedForm.class */
    private static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        KeysSerializedForm(ImmutableMultimap<?, ?> multimap) {
            this.multimap = multimap;
        }

        Object readResolve() {
            return this.multimap.keys();
        }
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) values();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    public UnmodifiableIterator<V> valueIterator() {
        return new UnmodifiableIterator<V>() { // from class: com.google.common.collect.ImmutableMultimap.2
            Iterator<? extends ImmutableCollection<V>> valueCollectionItr;
            Iterator<V> valueItr = Iterators.emptyIterator();

            {
                this.valueCollectionItr = ImmutableMultimap.this.map.values().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.valueItr.hasNext() || this.valueCollectionItr.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                if (!this.valueItr.hasNext()) {
                    this.valueItr = ((ImmutableCollection) this.valueCollectionItr.next()).iterator();
                }
                return this.valueItr.next();
            }
        };
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableMultimap$Values.class */
    public static final class Values<K, V> extends ImmutableCollection<V> {
        @Weak
        private final transient ImmutableMultimap<K, V> multimap;
        private static final long serialVersionUID = 0;

        Values(ImmutableMultimap<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object object) {
            return this.multimap.containsValue(object);
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        public int copyIntoArray(Object[] dst, int offset) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> it = this.multimap.map.values().iterator();
            while (it.hasNext()) {
                offset = ((ImmutableCollection) it.next()).copyIntoArray(dst, offset);
            }
            return offset;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }
    }
}
