package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableListMultimap.class */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
    @RetainedWith
    @LazyInit
    private transient ImmutableListMultimap<V, K> inverse;
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction, "keyFunction");
        Preconditions.checkNotNull(valueFunction, "valueFunction");
        return Collector.of(ImmutableListMultimap::builder, builder, t -> {
            builder.put((Builder) keyFunction.apply(t), valueFunction.apply(t));
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, (v0) -> {
            return v0.build();
        }, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends Stream<? extends V>> valuesFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valuesFunction);
        Function r0 = input -> {
            return Preconditions.checkNotNull(keyFunction.apply(input));
        };
        Function r1 = input -> {
            return ((Stream) valuesFunction.apply(input)).peek(Preconditions::checkNotNull);
        };
        MultimapBuilder.ListMultimapBuilder<Object, Object> arrayListValues = MultimapBuilder.linkedHashKeys().arrayListValues();
        arrayListValues.getClass();
        return Collectors.collectingAndThen(Multimaps.flatteningToMultimap(r0, r1, this::build), (v0) -> {
            return copyOf(v0);
        });
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m1425of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m1424of(K k1, V v1) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m1423of(K k1, V v1, K k2, V v2) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        builder.put((Builder<K, V>) k2, (K) v2);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m1422of(K k1, V v1, K k2, V v2, K k3, V v3) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        builder.put((Builder<K, V>) k2, (K) v2);
        builder.put((Builder<K, V>) k3, (K) v3);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m1421of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder<K, V> builder = builder();
        builder.put((Builder<K, V>) k1, (K) v1);
        builder.put((Builder<K, V>) k2, (K) v2);
        builder.put((Builder<K, V>) k3, (K) v3);
        builder.put((Builder<K, V>) k4, (K) v4);
        return builder.build();
    }

    /* renamed from: of */
    public static <K, V> ImmutableListMultimap<K, V> m1420of(K k1, V v1, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
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

    /* loaded from: grasscutter.jar:com/google/common/collect/ImmutableListMultimap$Builder.class */
    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
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
            putAll((Builder<K, V>) key, (Object[]) values);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            putAll((Multimap) multimap);
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
        public ImmutableListMultimap<K, V> build() {
            return (ImmutableListMultimap) build();
        }
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap.isEmpty()) {
            return m1425of();
        }
        if (multimap instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> kvMultimap = (ImmutableListMultimap) multimap;
            if (!kvMultimap.isPartialView()) {
                return kvMultimap;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), null);
    }

    @Beta
    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> entries) {
        return new Builder().putAll((Iterable) entries).build();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> mapEntries, Comparator<? super V> valueComparator) {
        ImmutableList<V> list;
        if (mapEntries.isEmpty()) {
            return m1425of();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(mapEntries.size());
        int size = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : mapEntries) {
            Object key = entry.getKey();
            Collection<? extends V> values = (Collection) entry.getValue();
            if (valueComparator == null) {
                list = ImmutableList.copyOf((Collection) values);
            } else {
                list = ImmutableList.sortedCopyOf(valueComparator, values);
            }
            if (!list.isEmpty()) {
                builder.put(key, list);
                size += list.size();
            }
        }
        return new ImmutableListMultimap<>(builder.build(), size);
    }

    /* access modifiers changed from: package-private */
    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> map, int size) {
        super(map, size);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public ImmutableList<V> get(K key) {
        ImmutableList<V> list = (ImmutableList) this.map.get(key);
        return list == null ? ImmutableList.m1438of() : list;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> result = this.inverse;
        if (result != null) {
            return result;
        }
        ImmutableListMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableListMultimap<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableListMultimap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        Builder builder = builder();
        UnmodifiableIterator it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> entry = (Map.Entry) it.next();
            builder.put((Builder) entry.getValue(), (Object) entry.getKey());
        }
        ImmutableListMultimap<V, K> invertedMultimap = builder.build();
        invertedMultimap.inverse = this;
        return invertedMultimap;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> removeAll(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> replaceValues(K key, Iterable<? extends V> values) {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        Serialization.writeMultimap(this, stream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: com.google.common.collect.ImmutableMap$Builder */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        int keyCount = stream.readInt();
        if (keyCount < 0) {
            throw new InvalidObjectException("Invalid key count " + keyCount);
        }
        ImmutableMap.Builder<Object, ImmutableList<Object>> builder = ImmutableMap.builder();
        int tmpSize = 0;
        for (int i = 0; i < keyCount; i++) {
            Object key = stream.readObject();
            int valueCount = stream.readInt();
            if (valueCount <= 0) {
                throw new InvalidObjectException("Invalid value count " + valueCount);
            }
            ImmutableList.Builder<Object> valuesBuilder = ImmutableList.builder();
            for (int j = 0; j < valueCount; j++) {
                valuesBuilder.add((ImmutableList.Builder<Object>) stream.readObject());
            }
            builder.put(key, valuesBuilder.build());
            tmpSize += valueCount;
        }
        try {
            ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set((Serialization.FieldSetter<ImmutableMultimap>) this, (Object) builder.build());
            ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set((Serialization.FieldSetter<ImmutableMultimap>) this, tmpSize);
        } catch (IllegalArgumentException e) {
            throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
        }
    }
}
