package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSetMultimap.class */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    private final transient ImmutableSet<V> emptySet;
    @RetainedWith
    @LazyInit
    private transient ImmutableSetMultimap<V, K> inverse;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction, "keyFunction");
        Preconditions.checkNotNull(valueFunction, "valueFunction");
        return Collector.of(ImmutableSetMultimap::builder, builder, t -> {
            builder.put((Builder) keyFunction.apply(t), valueFunction.apply(t));
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, (v0) -> {
            return v0.build();
        }, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends Stream<? extends V>> valuesFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valuesFunction);
        Function r0 = input -> {
            return Preconditions.checkNotNull(keyFunction.apply(input));
        };
        Function r1 = input -> {
            return ((Stream) valuesFunction.apply(input)).peek(Preconditions::checkNotNull);
        };
        MultimapBuilder.SetMultimapBuilder<Object, Object> linkedHashSetValues = MultimapBuilder.linkedHashKeys().linkedHashSetValues();
        linkedHashSetValues.getClass();
        return Collectors.collectingAndThen(Multimaps.flatteningToMultimap(r0, r1, this::build), (v0) -> {
            return copyOf(v0);
        });
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m1389of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m1388of(K k1, V v1) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m1387of(K k1, V v1, K k2, V v2) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        builder.put((Builder<K, V>) k2, (K) v2);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m1386of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        builder.put((Builder<K, V>) k2, (K) v2);
        builder.put((Builder<K, V>) k3, (K) v3);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m1385of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        builder.put((Builder<K, V>) k2, (K) v2);
        builder.put((Builder<K, V>) k3, (K) v3);
        builder.put((Builder<K, V>) k4, (K) v4);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableSetMultimap<K, V> m1384of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        builder.put((Builder<K, V>) k2, (K) v2);
        builder.put((Builder<K, V>) k3, (K) v3);
        builder.put((Builder<K, V>) k4, (K) v4);
        builder.put((Builder<K, V>) k5, (K) v5);
        return builder.build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSetMultimap$Builder.class */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        Collection<V> newMutableValueCollection() {
            return Platform.preservesInsertionOrderOnAddsSet();
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K key, V value) {
            put((Builder<K, V>) key, (K) value);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
            putAll((Iterable) entries);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K key, Iterable<? extends V> values) {
            putAll((Builder<K, V>) key, (Iterable) values);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(K key, V... values) {
            return putAll((Builder<K, V>) key, (Iterable) Arrays.asList(values));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : multimap.asMap().entrySet()) {
                putAll((Builder<K, V>) entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> combine(ImmutableMultimap.Builder<K, V> other) {
            combine((ImmutableMultimap.Builder) other);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator) {
            orderKeysBy((Comparator) keyComparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator) {
            orderValuesBy((Comparator) valueComparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        public ImmutableSetMultimap<K, V> build() {
            Collection<Map.Entry<K, Collection<V>>> mapEntries = this.builderMap.entrySet();
            if (this.keyComparator != null) {
                mapEntries = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(mapEntries);
            }
            return ImmutableSetMultimap.fromMapEntries(mapEntries, this.valueComparator);
        }
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        return copyOf(multimap, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap, Comparator<? super V> valueComparator) {
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty() && valueComparator == null) {
            return m1389of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> kvMultimap = (ImmutableSetMultimap) multimap;
            if (!kvMultimap.isPartialView()) {
                return kvMultimap;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), valueComparator);
    }

    @Beta
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return new Builder().putAll((Iterable) entries).build();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> mapEntries, Comparator<? super V> valueComparator) {
        if (mapEntries.isEmpty()) {
            return m1389of();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(mapEntries.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : mapEntries) {
            Object key = entry.getKey();
            ImmutableSet<V> set = valueSet(valueComparator, (Collection) entry.getValue());
            if (!set.isEmpty()) {
                builder.put(key, set);
                size += set.size();
            }
        }
        return new ImmutableSetMultimap<>(builder.build(), size, valueComparator);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> map, int size, Comparator<? super V> valueComparator) {
        super(map, size);
        this.emptySet = emptySet(valueComparator);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableSet<V> get(K key) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.map.get(key), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> result = this.inverse;
        if (result != null) {
            return result;
        }
        ImmutableSetMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSetMultimap<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableSetMultimap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        Builder builder = builder();
        UnmodifiableIterator it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> entry = (Map.Entry) it.next();
            builder.put((Builder) entry.getValue(), (Object) entry.getKey());
        }
        ImmutableSetMultimap<V, K> invertedMultimap = builder.build();
        invertedMultimap.inverse = this;
        return invertedMultimap;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> removeAll(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> replaceValues(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> result = this.entries;
        if (result != null) {
            return result;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entries = entrySet;
        return entrySet;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSetMultimap$EntrySet.class */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        @Weak
        private final transient ImmutableSetMultimap<K, V> multimap;

        EntrySet(ImmutableSetMultimap<K, V> multimap) {
            this.multimap = multimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object object) {
            if (!(object instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) object;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }
    }

    private static <V> ImmutableSet<V> valueSet(Comparator<? super V> valueComparator, Collection<? extends V> values) {
        if (valueComparator == null) {
            return ImmutableSet.copyOf((Collection) values);
        }
        return ImmutableSortedSet.copyOf((Comparator) valueComparator, (Collection) values);
    }

    private static <V> ImmutableSet<V> emptySet(Comparator<? super V> valueComparator) {
        if (valueComparator == null) {
            return ImmutableSet.m1396of();
        }
        return ImmutableSortedSet.emptySet(valueComparator);
    }

    private static <V> ImmutableSet.Builder<V> valuesBuilder(Comparator<? super V> valueComparator) {
        return valueComparator == null ? new ImmutableSet.Builder<>() : new ImmutableSortedSet.Builder(valueComparator);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(valueComparator());
        Serialization.writeMultimap(this, stream);
    }

    Comparator<? super V> valueComparator() {
        if (this.emptySet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) this.emptySet).comparator();
        }
        return null;
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableSetMultimap$SetFieldSettersHolder.class */
    private static final class SetFieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableSetMultimap> EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");

        private SetFieldSettersHolder() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        Comparator<Object> valueComparator = (Comparator) stream.readObject();
        int keyCount = stream.readInt();
        if (keyCount < 0) {
            throw new InvalidObjectException("Invalid key count " + keyCount);
        }
        ImmutableMap.Builder<Object, ImmutableSet<Object>> builder = ImmutableMap.builder();
        int tmpSize = 0;
        for (int i = 0; i < keyCount; i++) {
            Object key = stream.readObject();
            int valueCount = stream.readInt();
            if (valueCount <= 0) {
                throw new InvalidObjectException("Invalid value count " + valueCount);
            }
            ImmutableSet.Builder<Object> valuesBuilder = valuesBuilder(valueComparator);
            for (int j = 0; j < valueCount; j++) {
                valuesBuilder.add((ImmutableSet.Builder<Object>) stream.readObject());
            }
            ImmutableSet<Object> valueSet = valuesBuilder.build();
            if (valueSet.size() != valueCount) {
                throw new InvalidObjectException("Duplicate key-value pairs exist for key " + key);
            }
            builder.put(key, valueSet);
            tmpSize += valueCount;
        }
        try {
            ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set((Serialization.FieldSetter<ImmutableMultimap>) this, (Object) builder.build());
            ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set((Serialization.FieldSetter<ImmutableMultimap>) this, tmpSize);
            SetFieldSettersHolder.EMPTY_SET_FIELD_SETTER.set((Serialization.FieldSetter<ImmutableSetMultimap>) this, (Object) emptySet(valueComparator));
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
