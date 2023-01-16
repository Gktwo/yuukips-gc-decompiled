package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collector;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/Maps.class */
public final class Maps {

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$EntryFunction.class */
    public enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    @FunctionalInterface
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$EntryTransformer.class */
    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(K k, V1 v1);
    }

    private Maps() {
    }

    /* access modifiers changed from: package-private */
    public static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
        return EntryFunction.KEY;
    }

    /* access modifiers changed from: package-private */
    public static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    /* access modifiers changed from: package-private */
    public static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> entryIterator) {
        return new TransformedIterator<Map.Entry<K, V>, K>(entryIterator) { // from class: com.google.common.collect.Maps.1
            @Override // com.google.common.collect.TransformedIterator
            /* bridge */ /* synthetic */ Object transform(Object obj) {
                return transform((Map.Entry<Object, V>) ((Map.Entry) obj));
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
            K transform(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> entryIterator) {
        return new TransformedIterator<Map.Entry<K, V>, V>(entryIterator) { // from class: com.google.common.collect.Maps.2
            @Override // com.google.common.collect.TransformedIterator
            /* bridge */ /* synthetic */ Object transform(Object obj) {
                return transform((Map.Entry<K, Object>) ((Map.Entry) obj));
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
            V transform(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: java.util.EnumMap */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtCompatible(serializable = true)
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap) map;
        }
        Iterator<? extends Map.Entry<K, ? extends V>> entryItr = map.entrySet().iterator();
        if (!entryItr.hasNext()) {
            return ImmutableMap.m1419of();
        }
        Map.Entry<K, ? extends V> entry1 = entryItr.next();
        K key1 = entry1.getKey();
        Object value = entry1.getValue();
        CollectPreconditions.checkEntryNotNull(key1, value);
        EnumMap enumMap = new EnumMap(key1.getDeclaringClass());
        enumMap.put((EnumMap) key1, (K) value);
        while (entryItr.hasNext()) {
            Map.Entry<K, ? extends V> entry = entryItr.next();
            K key = entry.getKey();
            Object value2 = entry.getValue();
            CollectPreconditions.checkEntryNotNull(key, value2);
            enumMap.put((EnumMap) key, (K) value2);
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$Accumulator.class */
    private static class Accumulator<K extends Enum<K>, V> {
        private final BinaryOperator<V> mergeFunction;
        private EnumMap<K, V> map = null;

        Accumulator(BinaryOperator<V> mergeFunction) {
            this.mergeFunction = mergeFunction;
        }

        void put(K key, V value) {
            if (this.map == null) {
                this.map = new EnumMap<>(key.getDeclaringClass());
            }
            this.map.merge(key, value, this.mergeFunction);
        }

        Accumulator<K, V> combine(Accumulator<K, V> other) {
            if (this.map == null) {
                return other;
            }
            if (other.map == null) {
                return this;
            }
            other.map.forEach(this::put);
            return this;
        }

        ImmutableMap<K, V> toImmutableMap() {
            return this.map == null ? ImmutableMap.m1419of() : ImmutableEnumMap.asImmutable(this.map);
        }
    }

    public static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(java.util.function.Function<? super T, ? extends K> keyFunction, java.util.function.Function<? super T, ? extends V> valueFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        return Collector.of(() -> {
            return new Accumulator(v1, v2 -> {
                throw new IllegalArgumentException("Multiple values for key: " + v1 + ", " + v2);
            });
        }, accum, t -> {
            accum.put((Enum) Preconditions.checkNotNull(keyFunction.apply(t), "Null key for input %s", t), Preconditions.checkNotNull(valueFunction.apply(t), "Null value for input %s", t));
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, (v0) -> {
            return v0.toImmutableMap();
        }, Collector.Characteristics.UNORDERED);
    }

    public static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(java.util.function.Function<? super T, ? extends K> keyFunction, java.util.function.Function<? super T, ? extends V> valueFunction, BinaryOperator<V> mergeFunction) {
        Preconditions.checkNotNull(keyFunction);
        Preconditions.checkNotNull(valueFunction);
        Preconditions.checkNotNull(mergeFunction);
        return Collector.of(() -> {
            return new Accumulator(mergeFunction);
        }, accum, t -> {
            accum.put((Enum) Preconditions.checkNotNull(keyFunction.apply(t), "Null key for input %s", t), Preconditions.checkNotNull(valueFunction.apply(t), "Null value for input %s", t));
        }, (v0, v1) -> {
            return v0.combine(v1);
        }, (v0) -> {
            return v0.toImmutableMap();
        }, new Collector.Characteristics[0]);
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
        return new HashMap<>(capacity(expectedSize));
    }

    /* access modifiers changed from: package-private */
    public static int capacity(int expectedSize) {
        if (expectedSize < 3) {
            CollectPreconditions.checkNonnegative(expectedSize, "expectedSize");
            return expectedSize + 1;
        } else if (expectedSize < 1073741824) {
            return (int) ((((float) expectedSize) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int expectedSize) {
        return new LinkedHashMap<>(capacity(expectedSize));
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> map) {
        return new TreeMap<>((SortedMap) map);
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(Comparator<C> comparator) {
        return new TreeMap<>((Comparator<? super K>) comparator);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> type) {
        return new EnumMap<>((Class) Preconditions.checkNotNull(type));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right) {
        if (left instanceof SortedMap) {
            return difference((SortedMap) ((SortedMap) left), (Map) right);
        }
        return difference(left, right, Equivalence.equals());
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence) {
        Preconditions.checkNotNull(valueEquivalence);
        Map<K, V> onlyOnLeft = newLinkedHashMap();
        Map<K, V> onlyOnRight = new LinkedHashMap<>(right);
        Map<K, V> onBoth = newLinkedHashMap();
        Map<K, MapDifference.ValueDifference<V>> differences = newLinkedHashMap();
        doDifference(left, right, valueEquivalence, onlyOnLeft, onlyOnRight, onBoth, differences);
        return new MapDifferenceImpl(onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> left, Map<? extends K, ? extends V> right) {
        Preconditions.checkNotNull(left);
        Preconditions.checkNotNull(right);
        Comparator<? super K> comparator = orNaturalOrder(left.comparator());
        SortedMap<K, V> onlyOnLeft = newTreeMap(comparator);
        SortedMap<K, V> onlyOnRight = newTreeMap(comparator);
        onlyOnRight.putAll(right);
        SortedMap<K, V> onBoth = newTreeMap(comparator);
        SortedMap<K, MapDifference.ValueDifference<V>> differences = newTreeMap(comparator);
        doDifference(left, right, Equivalence.equals(), onlyOnLeft, onlyOnRight, onBoth, differences);
        return new SortedMapDifferenceImpl(onlyOnLeft, onlyOnRight, onBoth, differences);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.Map<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.Map<K, V> */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: java.util.Map<K, com.google.common.collect.MapDifference$ValueDifference<V>> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: ? super V */
    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> void doDifference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence, Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, MapDifference.ValueDifference<V>> differences) {
        for (Map.Entry<? extends K, ? extends V> entry : left.entrySet()) {
            Object key = entry.getKey();
            Object obj = (Object) entry.getValue();
            if (right.containsKey(key)) {
                Object obj2 = (V) onlyOnRight.remove(key);
                if (valueEquivalence.equivalent(obj, obj2)) {
                    onBoth.put(key, obj);
                } else {
                    differences.put(key, ValueDifferenceImpl.create(obj, obj2));
                }
            } else {
                onlyOnLeft.put(key, obj);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <K, V> Map<K, V> unmodifiableMap(Map<K, ? extends V> map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$MapDifferenceImpl.class */
    public static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;
        final Map<K, V> onBoth;
        final Map<K, MapDifference.ValueDifference<V>> differences;

        MapDifferenceImpl(Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, MapDifference.ValueDifference<V>> differences) {
            this.onlyOnLeft = Maps.unmodifiableMap(onlyOnLeft);
            this.onlyOnRight = Maps.unmodifiableMap(onlyOnRight);
            this.onBoth = Maps.unmodifiableMap(onBoth);
            this.differences = Maps.unmodifiableMap(differences);
        }

        @Override // com.google.common.collect.MapDifference
        public boolean areEqual() {
            return this.onlyOnLeft.isEmpty() && this.onlyOnRight.isEmpty() && this.differences.isEmpty();
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, V> entriesOnlyOnLeft() {
            return this.onlyOnLeft;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, V> entriesOnlyOnRight() {
            return this.onlyOnRight;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, V> entriesInCommon() {
            return this.onBoth;
        }

        @Override // com.google.common.collect.MapDifference
        public Map<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        @Override // com.google.common.collect.MapDifference
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof MapDifference)) {
                return false;
            }
            MapDifference<?, ?> other = (MapDifference) object;
            return entriesOnlyOnLeft().equals(other.entriesOnlyOnLeft()) && entriesOnlyOnRight().equals(other.entriesOnlyOnRight()) && entriesInCommon().equals(other.entriesInCommon()) && entriesDiffering().equals(other.entriesDiffering());
        }

        @Override // com.google.common.collect.MapDifference
        public int hashCode() {
            return Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
        }

        public String toString() {
            if (areEqual()) {
                return "equal";
            }
            StringBuilder result = new StringBuilder("not equal");
            if (!this.onlyOnLeft.isEmpty()) {
                result.append(": only on left=").append(this.onlyOnLeft);
            }
            if (!this.onlyOnRight.isEmpty()) {
                result.append(": only on right=").append(this.onlyOnRight);
            }
            if (!this.differences.isEmpty()) {
                result.append(": value differences=").append(this.differences);
            }
            return result.toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$ValueDifferenceImpl.class */
    public static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
        private final V left;
        private final V right;

        static <V> MapDifference.ValueDifference<V> create(V left, V right) {
            return new ValueDifferenceImpl(left, right);
        }

        private ValueDifferenceImpl(V left, V right) {
            this.left = left;
            this.right = right;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V leftValue() {
            return this.left;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public V rightValue() {
            return this.right;
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public boolean equals(Object object) {
            if (!(object instanceof MapDifference.ValueDifference)) {
                return false;
            }
            MapDifference.ValueDifference<?> that = (MapDifference.ValueDifference) object;
            return Objects.equal(this.left, that.leftValue()) && Objects.equal(this.right, that.rightValue());
        }

        @Override // com.google.common.collect.MapDifference.ValueDifference
        public int hashCode() {
            return Objects.hashCode(this.left, this.right);
        }

        public String toString() {
            return "(" + this.left + ", " + this.right + ")";
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$SortedMapDifferenceImpl.class */
    public static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        SortedMapDifferenceImpl(SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, MapDifference.ValueDifference<V>> differences) {
            super(onlyOnLeft, onlyOnRight, onBoth, differences);
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return (SortedMap) entriesDiffering();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, V> entriesInCommon() {
            return (SortedMap) entriesInCommon();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, V> entriesOnlyOnLeft() {
            return (SortedMap) entriesOnlyOnLeft();
        }

        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public SortedMap<K, V> entriesOnlyOnRight() {
            return (SortedMap) entriesOnlyOnRight();
        }
    }

    static <E> Comparator<? super E> orNaturalOrder(Comparator<? super E> comparator) {
        if (comparator != null) {
            return comparator;
        }
        return Ordering.natural();
    }

    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        return new AsMapView(set, function);
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> set, Function<? super K, V> function) {
        return new SortedAsMapView(set, function);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> set, Function<? super K, V> function) {
        return new NavigableAsMapView(set, function);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$AsMapView.class */
    public static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {
        private final Set<K> set;
        final Function<? super K, V> function;

        Set<K> backingSet() {
            return this.set;
        }

        AsMapView(Set<K> set, Function<? super K, V> function) {
            this.set = (Set) Preconditions.checkNotNull(set);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set<K> createKeySet() {
            return Maps.removeOnlySet(backingSet());
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<V> createValues() {
            return Collections2.transform(this.set, this.function);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return backingSet().size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return backingSet().contains(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            return getOrDefault(key, null);
        }

        @Override // java.util.Map
        public V getOrDefault(Object key, V defaultValue) {
            if (Collections2.safeContains(backingSet(), key)) {
                return this.function.apply(key);
            }
            return defaultValue;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object key) {
            if (backingSet().remove(key)) {
                return this.function.apply(key);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            backingSet().clear();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>() { // from class: com.google.common.collect.Maps.AsMapView.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                Map<K, V> map() {
                    return AsMapView.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
                public Iterator<Map.Entry<K, V>> iterator() {
                    return Maps.asMapEntryIterator(AsMapView.this.backingSet(), AsMapView.this.function);
                }
            };
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            Preconditions.checkNotNull(action);
            backingSet().forEach(k -> {
                action.accept(action, this.function.apply(action));
            });
        }
    }

    /* access modifiers changed from: package-private */
    public static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> set, final Function<? super K, V> function) {
        return new TransformedIterator<K, Map.Entry<K, V>>(set.iterator()) { // from class: com.google.common.collect.Maps.3
            @Override // com.google.common.collect.TransformedIterator
            Map.Entry<K, V> transform(K key) {
                return Maps.immutableEntry(key, function.apply(key));
            }
        };
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$SortedAsMapView.class */
    public static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        SortedAsMapView(SortedSet<K> set, Function<? super K, V> function) {
            super(set, function);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.AsMapView
        public SortedSet<K> backingSet() {
            return (SortedSet) backingSet();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return backingSet().comparator();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return Maps.removeOnlySortedSet(backingSet());
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return Maps.asMap((SortedSet) backingSet().subSet(fromKey, toKey), this.function);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K toKey) {
            return Maps.asMap((SortedSet) backingSet().headSet(toKey), this.function);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K fromKey) {
            return Maps.asMap((SortedSet) backingSet().tailSet(fromKey), this.function);
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return backingSet().first();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return backingSet().last();
        }
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$NavigableAsMapView.class */
    public static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
        private final NavigableSet<K> set;
        private final Function<? super K, V> function;

        NavigableAsMapView(NavigableSet<K> ks, Function<? super K, V> vFunction) {
            this.set = (NavigableSet) Preconditions.checkNotNull(ks);
            this.function = (Function) Preconditions.checkNotNull(vFunction);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.asMap((NavigableSet) this.set.subSet(fromKey, fromInclusive, toKey, toInclusive), (Function) this.function);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Maps.asMap((NavigableSet) this.set.headSet(toKey, inclusive), (Function) this.function);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Maps.asMap((NavigableSet) this.set.tailSet(fromKey, inclusive), (Function) this.function);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.set.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            return getOrDefault(key, null);
        }

        @Override // java.util.Map
        public V getOrDefault(Object key, V defaultValue) {
            if (Collections2.safeContains(this.set, key)) {
                return this.function.apply(key);
            }
            return defaultValue;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.set.clear();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return Maps.asMapEntryIterator(this.set, this.function);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return CollectSpliterators.map(this.set.spliterator(), e -> {
                return Maps.immutableEntry(e, this.function.apply(e));
            });
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V> action) {
            this.set.forEach(k -> {
                action.accept(action, this.function.apply(action));
            });
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return descendingMap().entrySet().iterator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Maps.removeOnlyNavigableSet(this.set);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.set.size();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.asMap((NavigableSet) this.set.descendingSet(), (Function) this.function);
        }
    }

    /* access modifiers changed from: private */
    public static <E> Set<E> removeOnlySet(final Set<E> set) {
        return new ForwardingSet<E>() { // from class: com.google.common.collect.Maps.4
            /* access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<E> delegate() {
                return set;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
            public boolean add(E element) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
            public boolean addAll(Collection<? extends E> es) {
                throw new UnsupportedOperationException();
            }
        };
    }

    /* access modifiers changed from: private */
    public static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> set) {
        return new ForwardingSortedSet<E>() { // from class: com.google.common.collect.Maps.5
            /* access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public SortedSet<E> delegate() {
                return set;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
            public boolean add(E element) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
            public boolean addAll(Collection<? extends E> es) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet<E> headSet(E toElement) {
                return Maps.removeOnlySortedSet(headSet(toElement));
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet<E> subSet(E fromElement, E toElement) {
                return Maps.removeOnlySortedSet(subSet(fromElement, toElement));
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet<E> tailSet(E fromElement) {
                return Maps.removeOnlySortedSet(tailSet(fromElement));
            }
        };
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    public static <E> NavigableSet<E> removeOnlyNavigableSet(final NavigableSet<E> set) {
        return new ForwardingNavigableSet<E>() { // from class: com.google.common.collect.Maps.6
            /* access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public NavigableSet<E> delegate() {
                return set;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
            public boolean add(E element) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
            public boolean addAll(Collection<? extends E> es) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet<E> headSet(E toElement) {
                return Maps.removeOnlySortedSet(headSet(toElement));
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet<E> headSet(E toElement, boolean inclusive) {
                return Maps.removeOnlyNavigableSet(headSet(toElement, inclusive));
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet<E> subSet(E fromElement, E toElement) {
                return Maps.removeOnlySortedSet(subSet(fromElement, toElement));
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
                return Maps.removeOnlyNavigableSet(subSet(fromElement, fromInclusive, toElement, toInclusive));
            }

            @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
            public SortedSet<E> tailSet(E fromElement) {
                return Maps.removeOnlySortedSet(tailSet(fromElement));
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
                return Maps.removeOnlyNavigableSet(tailSet(fromElement, inclusive));
            }

            @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
            public NavigableSet<E> descendingSet() {
                return Maps.removeOnlyNavigableSet(descendingSet());
            }
        };
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> keys, Function<? super K, V> valueFunction) {
        return toMap(keys.iterator(), valueFunction);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> keys, Function<? super K, V> valueFunction) {
        Preconditions.checkNotNull(valueFunction);
        Map<K, V> builder = newLinkedHashMap();
        while (keys.hasNext()) {
            K key = keys.next();
            builder.put(key, valueFunction.apply(key));
        }
        return ImmutableMap.copyOf(builder);
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> values, Function<? super V, K> keyFunction) {
        return uniqueIndex(values.iterator(), keyFunction);
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> values, Function<? super V, K> keyFunction) {
        Preconditions.checkNotNull(keyFunction);
        ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
        while (values.hasNext()) {
            V value = values.next();
            builder.put(keyFunction.apply(value), value);
        }
        try {
            return builder.build();
        } catch (IllegalArgumentException duplicateKeys) {
            throw new IllegalArgumentException(duplicateKeys.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    @GwtIncompatible
    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
        Enumeration<?> e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            builder.put(key, properties.getProperty(key));
        }
        return builder.build();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> immutableEntry(K key, V value) {
        return new ImmutableEntry(key, value);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> entrySet) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(entrySet));
    }

    /* access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> unmodifiableEntry(final Map.Entry<? extends K, ? extends V> entry) {
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V>() { // from class: com.google.common.collect.Maps.7
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, K] */
            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public K getKey() {
                return entry.getKey();
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [V, java.lang.Object] */
            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public V getValue() {
                return entry.getValue();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static <K, V> UnmodifiableIterator<Map.Entry<K, V>> unmodifiableEntryIterator(final Iterator<Map.Entry<K, V>> entryIterator) {
        return new UnmodifiableIterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.Maps.8
            @Override // java.util.Iterator
            public boolean hasNext() {
                return entryIterator.hasNext();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return Maps.unmodifiableEntry((Map.Entry) entryIterator.next());
            }
        };
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$UnmodifiableEntries.class */
    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> entries;

        /* access modifiers changed from: package-private */
        public UnmodifiableEntries(Collection<Map.Entry<K, V>> entries) {
            this.entries = entries;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.unmodifiableEntryIterator(this.entries.iterator());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] array) {
            return (T[]) standardToArray(array);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$UnmodifiableEntrySet.class */
    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        UnmodifiableEntrySet(Set<Map.Entry<K, V>> entries) {
            super(entries);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public boolean equals(Object object) {
            return Sets.equalsImpl(this, object);
        }

        @Override // java.util.Collection, java.lang.Object, java.util.Set
        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> bimap) {
        return new BiMapConverter(bimap);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$BiMapConverter.class */
    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private final BiMap<A, B> bimap;
        private static final long serialVersionUID = 0;

        BiMapConverter(BiMap<A, B> bimap) {
            this.bimap = (BiMap) Preconditions.checkNotNull(bimap);
        }

        @Override // com.google.common.base.Converter
        protected B doForward(A a) {
            return (B) convert(this.bimap, a);
        }

        @Override // com.google.common.base.Converter
        protected A doBackward(B b) {
            return (A) convert(this.bimap.inverse(), b);
        }

        private static <X, Y> Y convert(BiMap<X, Y> bimap, X input) {
            Y output = bimap.get(input);
            Preconditions.checkArgument(output != null, "No non-null mapping present for input: %s", input);
            return output;
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(Object object) {
            if (object instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) object).bimap);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.bimap.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> bimap) {
        return Synchronized.biMap(bimap, null);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> bimap) {
        return new UnmodifiableBiMap(bimap, null);
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$UnmodifiableBiMap.class */
    private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        final Map<K, V> unmodifiableMap;
        final BiMap<? extends K, ? extends V> delegate;
        @RetainedWith
        BiMap<V, K> inverse;
        transient Set<V> values;
        private static final long serialVersionUID = 0;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> delegate, BiMap<V, K> inverse) {
            this.unmodifiableMap = Collections.unmodifiableMap(delegate);
            this.delegate = delegate;
            this.inverse = inverse;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K key, V value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            BiMap<V, K> result = this.inverse;
            if (result != null) {
                return result;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Set<V> values() {
            Set<V> result = this.values;
            if (result != null) {
                return result;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> fromMap, Function<? super V1, V2> function) {
        return transformEntries(fromMap, asEntryTransformer(function));
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> fromMap, Function<? super V1, V2> function) {
        return transformEntries((SortedMap) fromMap, asEntryTransformer(function));
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> fromMap, Function<? super V1, V2> function) {
        return transformEntries((NavigableMap) fromMap, asEntryTransformer(function));
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesMap(fromMap, transformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesSortedMap(fromMap, transformer);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
        return new TransformedEntriesNavigableMap(fromMap, transformer);
    }

    /* access modifiers changed from: package-private */
    public static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return new EntryTransformer<K, V1, V2>() { // from class: com.google.common.collect.Maps.9
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, V2] */
            @Override // com.google.common.collect.Maps.EntryTransformer
            public V2 transformEntry(K key, V1 value) {
                return function.apply(value);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static <K, V1, V2> Function<V1, V2> asValueToValueFunction(final EntryTransformer<? super K, V1, V2> transformer, final K key) {
        Preconditions.checkNotNull(transformer);
        return new Function<V1, V2>() { // from class: com.google.common.collect.Maps.10
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, V2] */
            @Override // com.google.common.base.Function, java.util.function.Function
            public V2 apply(V1 v1) {
                return transformer.transformEntry(key, v1);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(final EntryTransformer<? super K, ? super V1, V2> transformer) {
        Preconditions.checkNotNull(transformer);
        return new Function<Map.Entry<K, V1>, V2>() { // from class: com.google.common.collect.Maps.11
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, V2] */
            public V2 apply(Map.Entry<K, V1> entry) {
                return transformer.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> transformer, final Map.Entry<K, V1> entry) {
        Preconditions.checkNotNull(transformer);
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V2>() { // from class: com.google.common.collect.Maps.12
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, K] */
            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public K getKey() {
                return entry.getKey();
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, V2] */
            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
            public V2 getValue() {
                return transformer.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    /* access modifiers changed from: package-private */
    public static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(final EntryTransformer<? super K, ? super V1, V2> transformer) {
        Preconditions.checkNotNull(transformer);
        return new Function<Map.Entry<K, V1>, Map.Entry<K, V2>>() { // from class: com.google.common.collect.Maps.13
            public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
                return Maps.transformEntry(transformer, entry);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$TransformedEntriesMap.class */
    public static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMap(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            this.fromMap = (Map) Preconditions.checkNotNull(fromMap);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(transformer);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.fromMap.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return this.fromMap.containsKey(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V2 get(Object key) {
            return getOrDefault(key, null);
        }

        @Override // java.util.Map
        public V2 getOrDefault(Object key, V2 defaultValue) {
            V1 value = this.fromMap.get(key);
            return (value != null || this.fromMap.containsKey(key)) ? this.transformer.transformEntry(key, value) : defaultValue;
        }

        /* JADX DEBUG: Type inference failed for r2v2. Raw type applied. Possible types: V1, ? super V1 */
        @Override // java.util.AbstractMap, java.util.Map
        public V2 remove(Object key) {
            if (this.fromMap.containsKey(key)) {
                return this.transformer.transformEntry(key, (V1) this.fromMap.remove(key));
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.fromMap.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Spliterator<Map.Entry<K, V2>> entrySpliterator() {
            return CollectSpliterators.map(this.fromMap.entrySet().spliterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        @Override // java.util.Map
        public void forEach(BiConsumer<? super K, ? super V2> action) {
            Preconditions.checkNotNull(action);
            this.fromMap.forEach(k, v1 -> {
                action.accept(action, this.transformer.transformEntry(action, v1));
            });
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V2> values() {
            return new Values(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$TransformedEntriesSortedMap.class */
    public static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        protected SortedMap<K, V1> fromMap() {
            return (SortedMap) this.fromMap;
        }

        TransformedEntriesSortedMap(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMap, transformer);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return fromMap().firstKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> headMap(K toKey) {
            return Maps.transformEntries((SortedMap) fromMap().headMap(toKey), this.transformer);
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return fromMap().lastKey();
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> subMap(K fromKey, K toKey) {
            return Maps.transformEntries((SortedMap) fromMap().subMap(fromKey, toKey), this.transformer);
        }

        @Override // java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V2> tailMap(K fromKey) {
            return Maps.transformEntries((SortedMap) fromMap().tailMap(fromKey), this.transformer);
        }
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$TransformedEntriesNavigableMap.class */
    public static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        TransformedEntriesNavigableMap(NavigableMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer) {
            super(fromMap, transformer);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> ceilingEntry(K key) {
            return transformEntry(fromMap().ceilingEntry(key));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K key) {
            return fromMap().ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return fromMap().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> descendingMap() {
            return Maps.transformEntries((NavigableMap) fromMap().descendingMap(), this.transformer);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> firstEntry() {
            return transformEntry(fromMap().firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> floorEntry(K key) {
            return transformEntry(fromMap().floorEntry(key));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K key) {
            return fromMap().floorKey(key);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K toKey) {
            return headMap(toKey, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> headMap(K toKey, boolean inclusive) {
            return Maps.transformEntries((NavigableMap) fromMap().headMap(toKey, inclusive), this.transformer);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> higherEntry(K key) {
            return transformEntry(fromMap().higherEntry(key));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K key) {
            return fromMap().higherKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lastEntry() {
            return transformEntry(fromMap().lastEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> lowerEntry(K key) {
            return transformEntry(fromMap().lowerEntry(key));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K key) {
            return fromMap().lowerKey(key);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return fromMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollFirstEntry() {
            return transformEntry(fromMap().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V2> pollLastEntry() {
            return transformEntry(fromMap().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.transformEntries((NavigableMap) fromMap().subMap(fromKey, fromInclusive, toKey, toInclusive), this.transformer);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> subMap(K fromKey, K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K fromKey) {
            return tailMap(fromKey, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V2> tailMap(K fromKey, boolean inclusive) {
            return Maps.transformEntries((NavigableMap) fromMap().tailMap(fromKey, inclusive), this.transformer);
        }

        private Map.Entry<K, V2> transformEntry(Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return Maps.transformEntry(this.transformer, entry);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        public NavigableMap<K, V1> fromMap() {
            return (NavigableMap) fromMap();
        }
    }

    /* access modifiers changed from: package-private */
    public static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> keyPredicate) {
        return Predicates.compose(keyPredicate, keyFunction());
    }

    /* access modifiers changed from: package-private */
    public static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> valuePredicate) {
        return Predicates.compose(valuePredicate, valueFunction());
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        Preconditions.checkNotNull(keyPredicate);
        Predicate<Map.Entry<K, ?>> entryPredicate = keyPredicateOnEntries(keyPredicate);
        if (unfiltered instanceof AbstractFilteredMap) {
            return filterFiltered((AbstractFilteredMap) unfiltered, entryPredicate);
        }
        return new FilteredKeyMap((Map) Preconditions.checkNotNull(unfiltered), keyPredicate, entryPredicate);
    }

    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        return filterEntries((SortedMap) unfiltered, keyPredicateOnEntries(keyPredicate));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        return filterEntries((NavigableMap) unfiltered, keyPredicateOnEntries(keyPredicate));
    }

    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> unfiltered, Predicate<? super K> keyPredicate) {
        Preconditions.checkNotNull(keyPredicate);
        return filterEntries((BiMap) unfiltered, keyPredicateOnEntries(keyPredicate));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return filterEntries(unfiltered, valuePredicateOnEntries(valuePredicate));
    }

    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return filterEntries((SortedMap) unfiltered, valuePredicateOnEntries(valuePredicate));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return filterEntries((NavigableMap) unfiltered, valuePredicateOnEntries(valuePredicate));
    }

    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> unfiltered, Predicate<? super V> valuePredicate) {
        return filterEntries((BiMap) unfiltered, valuePredicateOnEntries(valuePredicate));
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        if (unfiltered instanceof AbstractFilteredMap) {
            return filterFiltered((AbstractFilteredMap) unfiltered, entryPredicate);
        }
        return new FilteredEntryMap((Map) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        if (unfiltered instanceof FilteredEntrySortedMap) {
            return filterFiltered((FilteredEntrySortedMap) unfiltered, (Predicate) entryPredicate);
        }
        return new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(entryPredicate);
        if (unfiltered instanceof FilteredEntryNavigableMap) {
            return filterFiltered((FilteredEntryNavigableMap) unfiltered, entryPredicate);
        }
        return new FilteredEntryNavigableMap((NavigableMap) Preconditions.checkNotNull(unfiltered), entryPredicate);
    }

    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        Preconditions.checkNotNull(unfiltered);
        Preconditions.checkNotNull(entryPredicate);
        return unfiltered instanceof FilteredEntryBiMap ? filterFiltered((FilteredEntryBiMap) unfiltered, (Predicate) entryPredicate) : new FilteredEntryBiMap(unfiltered, entryPredicate);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return new FilteredEntryMap(map.unfiltered, Predicates.and(map.predicate, entryPredicate));
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return new FilteredEntrySortedMap(map.sortedMap(), Predicates.and(map.predicate, entryPredicate));
    }

    @GwtIncompatible
    private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return new FilteredEntryNavigableMap(((FilteredEntryNavigableMap) map).unfiltered, Predicates.and(((FilteredEntryNavigableMap) map).entryPredicate, entryPredicate));
    }

    private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate) {
        return new FilteredEntryBiMap(map.unfiltered(), Predicates.and(map.predicate, entryPredicate));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$AbstractFilteredMap.class */
    public static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
        final Map<K, V> unfiltered;
        final Predicate<? super Map.Entry<K, V>> predicate;

        AbstractFilteredMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate) {
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        boolean apply(Object key, V value) {
            return this.predicate.apply(Maps.immutableEntry(key, value));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K key, V value) {
            Preconditions.checkArgument(apply(key, value));
            return this.unfiltered.put(key, value);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.Maps$AbstractFilteredMap<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                Preconditions.checkArgument(apply(entry.getKey(), entry.getValue()));
            }
            this.unfiltered.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && apply(key, this.unfiltered.get(key));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            V value = this.unfiltered.get(key);
            if (value == null || !apply(key, value)) {
                return null;
            }
            return value;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object key) {
            if (containsKey(key)) {
                return this.unfiltered.remove(key);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<V> createValues() {
            return new FilteredMapValues(this, this.unfiltered, this.predicate);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredMapValues.class */
    private static final class FilteredMapValues<K, V> extends Values<K, V> {
        final Map<K, V> unfiltered;
        final Predicate<? super Map.Entry<K, V>> predicate;

        FilteredMapValues(Map<K, V> filteredMap, Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate) {
            super(filteredMap);
            this.unfiltered = unfiltered;
            this.predicate = predicate;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object o) {
            Iterator<Map.Entry<K, V>> entryItr = this.unfiltered.entrySet().iterator();
            while (entryItr.hasNext()) {
                Map.Entry<K, V> entry = entryItr.next();
                if (this.predicate.apply(entry) && Objects.equal(entry.getValue(), o)) {
                    entryItr.remove();
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> entryItr = this.unfiltered.entrySet().iterator();
            boolean result = false;
            while (entryItr.hasNext()) {
                Map.Entry<K, V> entry = entryItr.next();
                if (this.predicate.apply(entry) && collection.contains(entry.getValue())) {
                    entryItr.remove();
                    result = true;
                }
            }
            return result;
        }

        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> entryItr = this.unfiltered.entrySet().iterator();
            boolean result = false;
            while (entryItr.hasNext()) {
                Map.Entry<K, V> entry = entryItr.next();
                if (this.predicate.apply(entry) && !collection.contains(entry.getValue())) {
                    entryItr.remove();
                    result = true;
                }
            }
            return result;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] array) {
            return (T[]) Lists.newArrayList(iterator()).toArray(array);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredKeyMap.class */
    private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        final Predicate<? super K> keyPredicate;

        FilteredKeyMap(Map<K, V> unfiltered, Predicate<? super K> keyPredicate, Predicate<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.keyPredicate = keyPredicate;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), this.predicate);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<K> createKeySet() {
            return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
        }

        @Override // com.google.common.collect.Maps.AbstractFilteredMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return this.unfiltered.containsKey(key) && this.keyPredicate.apply(key);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredEntryMap.class */
    public static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        final Set<Map.Entry<K, V>> filteredEntrySet;

        FilteredEntryMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
            this.filteredEntrySet = Sets.filter(unfiltered.entrySet(), this.predicate);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet();
        }

        /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredEntryMap$EntrySet.class */
        private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            private EntrySet() {
            }

            /* access modifiers changed from: protected */
            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public Set<Map.Entry<K, V>> delegate() {
                return FilteredEntryMap.this.filteredEntrySet;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(FilteredEntryMap.this.filteredEntrySet.iterator()) { // from class: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1
                    @Override // com.google.common.collect.TransformedIterator
                    /* bridge */ /* synthetic */ Object transform(Object obj) {
                        return transform((Map.Entry) ((Map.Entry) obj));
                    }

                    Map.Entry<K, V> transform(final Map.Entry<K, V> entry) {
                        return new ForwardingMapEntry<K, V>() { // from class: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1.1
                            /* access modifiers changed from: protected */
                            @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                            public Map.Entry<K, V> delegate() {
                                return entry;
                            }

                            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                            public V setValue(V newValue) {
                                Preconditions.checkArgument(FilteredEntryMap.this.apply(getKey(), newValue));
                                return setValue(newValue);
                            }
                        };
                    }
                };
            }
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<K> createKeySet() {
            return new KeySet();
        }

        static <K, V> boolean removeAllKeys(Map<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate, Collection<?> keyCollection) {
            Iterator<Map.Entry<K, V>> entryItr = map.entrySet().iterator();
            boolean result = false;
            while (entryItr.hasNext()) {
                Map.Entry<K, V> entry = entryItr.next();
                if (entryPredicate.apply(entry) && keyCollection.contains(entry.getKey())) {
                    entryItr.remove();
                    result = true;
                }
            }
            return result;
        }

        static <K, V> boolean retainAllKeys(Map<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate, Collection<?> keyCollection) {
            Iterator<Map.Entry<K, V>> entryItr = map.entrySet().iterator();
            boolean result = false;
            while (entryItr.hasNext()) {
                Map.Entry<K, V> entry = entryItr.next();
                if (entryPredicate.apply(entry) && !keyCollection.contains(entry.getKey())) {
                    entryItr.remove();
                    result = true;
                }
            }
            return result;
        }

        /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredEntryMap$KeySet.class */
        class KeySet extends KeySet<K, V> {
            KeySet() {
                super(FilteredEntryMap.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object o) {
                if (!FilteredEntryMap.this.containsKey(o)) {
                    return false;
                }
                FilteredEntryMap.this.unfiltered.remove(o);
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return FilteredEntryMap.removeAllKeys(FilteredEntryMap.this.unfiltered, FilteredEntryMap.this.predicate, collection);
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return FilteredEntryMap.retainAllKeys(FilteredEntryMap.this.unfiltered, FilteredEntryMap.this.predicate, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] array) {
                return (T[]) Lists.newArrayList(iterator()).toArray(array);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredEntrySortedMap.class */
    public static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {
        FilteredEntrySortedMap(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
            super(unfiltered, entryPredicate);
        }

        SortedMap<K, V> sortedMap() {
            return (SortedMap) this.unfiltered;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public SortedSet<K> keySet() {
            return (SortedSet) keySet();
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public SortedSet<K> createKeySet() {
            return new SortedKeySet();
        }

        /* access modifiers changed from: package-private */
        /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredEntrySortedMap$SortedKeySet.class */
        public class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            SortedKeySet() {
                super();
            }

            @Override // java.util.SortedSet
            public Comparator<? super K> comparator() {
                return FilteredEntrySortedMap.this.sortedMap().comparator();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> subSet(K fromElement, K toElement) {
                return (SortedSet) FilteredEntrySortedMap.this.subMap(fromElement, toElement).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> headSet(K toElement) {
                return (SortedSet) FilteredEntrySortedMap.this.headMap(toElement).keySet();
            }

            @Override // java.util.SortedSet
            public SortedSet<K> tailSet(K fromElement) {
                return (SortedSet) FilteredEntrySortedMap.this.tailMap(fromElement).keySet();
            }

            @Override // java.util.SortedSet
            public K first() {
                return (K) FilteredEntrySortedMap.this.firstKey();
            }

            @Override // java.util.SortedSet
            public K last() {
                return (K) FilteredEntrySortedMap.this.lastKey();
            }
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return keySet().iterator().next();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.common.collect.Maps$FilteredEntrySortedMap<K, V> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.SortedMap
        public K lastKey() {
            SortedMap<K, V> headMap = sortedMap();
            while (true) {
                K key = headMap.lastKey();
                if (apply(key, this.unfiltered.get(key))) {
                    return key;
                }
                headMap = sortedMap().headMap(key);
            }
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> headMap(K toKey) {
            return new FilteredEntrySortedMap(sortedMap().headMap(toKey), this.predicate);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return new FilteredEntrySortedMap(sortedMap().subMap(fromKey, toKey), this.predicate);
        }

        @Override // java.util.SortedMap
        public SortedMap<K, V> tailMap(K fromKey) {
            return new FilteredEntrySortedMap(sortedMap().tailMap(fromKey), this.predicate);
        }
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredEntryNavigableMap.class */
    public static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
        private final NavigableMap<K, V> unfiltered;
        private final Predicate<? super Map.Entry<K, V>> entryPredicate;
        private final Map<K, V> filteredDelegate;

        FilteredEntryNavigableMap(NavigableMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate) {
            this.unfiltered = (NavigableMap) Preconditions.checkNotNull(unfiltered);
            this.entryPredicate = entryPredicate;
            this.filteredDelegate = new FilteredEntryMap(unfiltered, entryPredicate);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return this.unfiltered.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return new NavigableKeySet<K, V>(this) { // from class: com.google.common.collect.Maps.FilteredEntryNavigableMap.1
                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMap.removeAllKeys(FilteredEntryNavigableMap.this.unfiltered, FilteredEntryNavigableMap.this.entryPredicate, collection);
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMap.retainAllKeys(FilteredEntryNavigableMap.this.unfiltered, FilteredEntryNavigableMap.this.entryPredicate, collection);
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Collection<V> values() {
            return new FilteredMapValues(this, this.unfiltered, this.entryPredicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator<Map.Entry<K, V>> entryIterator() {
            return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.filteredDelegate.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.AbstractMap, java.util.Map
        public V get(Object key) {
            return this.filteredDelegate.get(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object key) {
            return this.filteredDelegate.containsKey(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K key, V value) {
            return this.filteredDelegate.put(key, value);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object key) {
            return this.filteredDelegate.remove(key);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> m) {
            this.filteredDelegate.putAll(m);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            this.filteredDelegate.clear();
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return this.filteredDelegate.entrySet();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return Maps.filterEntries((NavigableMap) this.unfiltered.descendingMap(), (Predicate) this.entryPredicate);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.filterEntries((NavigableMap) this.unfiltered.subMap(fromKey, fromInclusive, toKey, toInclusive), (Predicate) this.entryPredicate);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Maps.filterEntries((NavigableMap) this.unfiltered.headMap(toKey, inclusive), (Predicate) this.entryPredicate);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Maps.filterEntries((NavigableMap) this.unfiltered.tailMap(fromKey, inclusive), (Predicate) this.entryPredicate);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$FilteredEntryBiMap.class */
    public static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
        @RetainedWith
        private final BiMap<V, K> inverse;

        private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(final Predicate<? super Map.Entry<K, V>> forwardPredicate) {
            return new Predicate<Map.Entry<V, K>>() { // from class: com.google.common.collect.Maps.FilteredEntryBiMap.1
                @Override // com.google.common.base.Predicate
                public /* bridge */ /* synthetic */ boolean apply(Object obj) {
                    return apply((Map.Entry) ((Map.Entry) obj));
                }

                public boolean apply(Map.Entry<V, K> input) {
                    return forwardPredicate.apply(Maps.immutableEntry(input.getValue(), input.getKey()));
                }
            };
        }

        FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate) {
            super(delegate, predicate);
            this.inverse = new FilteredEntryBiMap(delegate.inverse(), inversePredicate(predicate), this);
        }

        private FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> inverse) {
            super(delegate, predicate);
            this.inverse = inverse;
        }

        BiMap<K, V> unfiltered() {
            return (BiMap) this.unfiltered;
        }

        @Override // com.google.common.collect.BiMap
        public V forcePut(K key, V value) {
            Preconditions.checkArgument(apply(key, value));
            return unfiltered().forcePut(key, value);
        }

        @Override // java.util.Map
        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
            unfiltered().replaceAll(key, value -> {
                return this.predicate.apply(Maps.immutableEntry(function, value)) ? function.apply(function, value) : value;
            });
        }

        @Override // com.google.common.collect.BiMap
        public BiMap<V, K> inverse() {
            return this.inverse;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Set<V> values() {
            return this.inverse.keySet();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.NavigableMap<K, ? extends V> */
    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> map) {
        Preconditions.checkNotNull(map);
        if (map instanceof UnmodifiableNavigableMap) {
            return map;
        }
        return new UnmodifiableNavigableMap(map);
    }

    /* access modifiers changed from: private */
    public static <K, V> Map.Entry<K, V> unmodifiableOrNull(Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return unmodifiableEntry(entry);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$UnmodifiableNavigableMap.class */
    public static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        private final NavigableMap<K, ? extends V> delegate;
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> delegate) {
            this.delegate = delegate;
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> delegate, UnmodifiableNavigableMap<K, V> descendingMap) {
            this.delegate = delegate;
            this.descendingMap = descendingMap;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.lowerEntry(key));
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K key) {
            return this.delegate.lowerKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.floorEntry(key));
        }

        @Override // java.util.NavigableMap
        public K floorKey(K key) {
            return this.delegate.floorKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.ceilingEntry(key));
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K key) {
            return this.delegate.ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K key) {
            return Maps.unmodifiableOrNull(this.delegate.higherEntry(key));
        }

        @Override // java.util.NavigableMap
        public K higherKey(K key) {
            return this.delegate.higherKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return Maps.unmodifiableOrNull(this.delegate.firstEntry());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return Maps.unmodifiableOrNull(this.delegate.lastEntry());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> result = this.descendingMap;
            if (result != null) {
                return result;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap;
            return unmodifiableNavigableMap;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return Maps.unmodifiableNavigableMap(this.delegate.subMap(fromKey, fromInclusive, toKey, toInclusive));
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K toKey) {
            return headMap(toKey, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return Maps.unmodifiableNavigableMap(this.delegate.headMap(toKey, inclusive));
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K fromKey) {
            return tailMap(fromKey, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return Maps.unmodifiableNavigableMap(this.delegate.tailMap(fromKey, inclusive));
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap) {
        return Synchronized.navigableMap(navigableMap);
    }

    /* access modifiers changed from: package-private */
    @GwtCompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$ViewCachingAbstractMap.class */
    public static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private transient Collection<V> values;

        abstract Set<Map.Entry<K, V>> createEntrySet();

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> result = this.entrySet;
            if (result != null) {
                return result;
            }
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> result = this.keySet;
            if (result != null) {
                return result;
            }
            Set<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }

        Set<K> createKeySet() {
            return new KeySet(this);
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Collection<V> values() {
            Collection<V> result = this.values;
            if (result != null) {
                return result;
            }
            Collection<V> createValues = createValues();
            this.values = createValues;
            return createValues;
        }

        Collection<V> createValues() {
            return new Values(this);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$IteratorBasedAbstractMap.class */
    static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();

        abstract Iterator<Map.Entry<K, V>> entryIterator();

        Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), (long) size(), 65);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new EntrySet<K, V>() { // from class: com.google.common.collect.Maps.IteratorBasedAbstractMap.1
                @Override // com.google.common.collect.Maps.EntrySet
                Map<K, V> map() {
                    return IteratorBasedAbstractMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
                public Iterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedAbstractMap.this.entryIterator();
                }

                @Override // java.util.Collection, java.util.Set, java.lang.Iterable
                public Spliterator<Map.Entry<K, V>> spliterator() {
                    return IteratorBasedAbstractMap.this.entrySpliterator();
                }

                @Override // java.lang.Iterable
                public void forEach(Consumer<? super Map.Entry<K, V>> action) {
                    IteratorBasedAbstractMap.this.forEachEntry(action);
                }
            };
        }

        void forEachEntry(Consumer<? super Map.Entry<K, V>> action) {
            entryIterator().forEachRemaining(action);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.clear(entryIterator());
        }
    }

    /* access modifiers changed from: package-private */
    public static <V> V safeGet(Map<?, V> map, Object key) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(key);
        } catch (ClassCastException | NullPointerException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean safeContainsKey(Map<?, ?> map, Object key) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(key);
        } catch (ClassCastException | NullPointerException e) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static <V> V safeRemove(Map<?, V> map, Object key) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(key);
        } catch (ClassCastException | NullPointerException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean containsKeyImpl(Map<?, ?> map, Object key) {
        return Iterators.contains(keyIterator(map.entrySet().iterator()), key);
    }

    /* access modifiers changed from: package-private */
    public static boolean containsValueImpl(Map<?, ?> map, Object value) {
        return Iterators.contains(valueIterator(map.entrySet().iterator()), value);
    }

    /* access modifiers changed from: package-private */
    public static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> c, Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        return c.contains(unmodifiableEntry((Map.Entry) o));
    }

    /* access modifiers changed from: package-private */
    public static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> c, Object o) {
        if (!(o instanceof Map.Entry)) {
            return false;
        }
        return c.remove(unmodifiableEntry((Map.Entry) o));
    }

    /* access modifiers changed from: package-private */
    public static boolean equalsImpl(Map<?, ?> map, Object object) {
        if (map == object) {
            return true;
        }
        if (object instanceof Map) {
            return map.entrySet().equals(((Map) object).entrySet());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public static String toStringImpl(Map<?, ?> map) {
        StringBuilder sb = Collections2.newStringBuilderForCollection(map.size()).append('{');
        boolean first = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            first = false;
            sb.append(entry.getKey()).append('=').append(entry.getValue());
        }
        return sb.append('}').toString();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public static <K, V> void putAllImpl(Map<K, V> self, Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            self.put(entry.getKey(), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$KeySet.class */
    public static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
        @Weak
        final Map<K, V> map;

        /* access modifiers changed from: package-private */
        public KeySet(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        Map<K, V> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super K> action) {
            Preconditions.checkNotNull(action);
            this.map.forEach(k, v -> {
                action.accept(k);
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return map().containsKey(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!contains(o)) {
                return false;
            }
            map().remove(o);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }
    }

    /* access modifiers changed from: package-private */
    public static <K> K keyOrNull(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* access modifiers changed from: package-private */
    public static <V> V valueOrNull(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$SortedKeySet.class */
    static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        /* access modifiers changed from: package-private */
        public SortedKeySet(SortedMap<K, V> map) {
            super(map);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.KeySet
        public SortedMap<K, V> map() {
            return (SortedMap) map();
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return map().comparator();
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K fromElement, K toElement) {
            return new SortedKeySet(map().subMap(fromElement, toElement));
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K toElement) {
            return new SortedKeySet(map().headMap(toElement));
        }

        @Override // java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K fromElement) {
            return new SortedKeySet(map().tailMap(fromElement));
        }

        @Override // java.util.SortedSet
        public K first() {
            return map().firstKey();
        }

        @Override // java.util.SortedSet
        public K last() {
            return map().lastKey();
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$NavigableKeySet.class */
    public static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        /* access modifiers changed from: package-private */
        public NavigableKeySet(NavigableMap<K, V> map) {
            super(map);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        public NavigableMap<K, V> map() {
            return (NavigableMap) this.map;
        }

        @Override // java.util.NavigableSet
        public K lower(K e) {
            return map().lowerKey(e);
        }

        @Override // java.util.NavigableSet
        public K floor(K e) {
            return map().floorKey(e);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K e) {
            return map().ceilingKey(e);
        }

        @Override // java.util.NavigableSet
        public K higher(K e) {
            return map().higherKey(e);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) Maps.keyOrNull(map().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) Maps.keyOrNull(map().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return map().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive) {
            return map().subMap(fromElement, fromInclusive, toElement, toInclusive).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K fromElement, K toElement) {
            return subSet(fromElement, true, toElement, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K toElement, boolean inclusive) {
            return map().headMap(toElement, inclusive).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K toElement) {
            return headSet(toElement, false);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K fromElement, boolean inclusive) {
            return map().tailMap(fromElement, inclusive).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K fromElement) {
            return tailSet(fromElement, true);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$Values.class */
    public static class Values<K, V> extends AbstractCollection<V> {
        @Weak
        final Map<K, V> map;

        /* access modifiers changed from: package-private */
        public Values(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        final Map<K, V> map() {
            return this.map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super V> action) {
            Preconditions.checkNotNull(action);
            this.map.forEach(k, v -> {
                action.accept(v);
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object o) {
            try {
                return remove(o);
            } catch (UnsupportedOperationException e) {
                for (Map.Entry<K, V> entry : map().entrySet()) {
                    if (Objects.equal(o, entry.getValue())) {
                        map().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> c) {
            try {
                return removeAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<K> toRemove = Sets.newHashSet();
                for (Map.Entry<K, V> entry : map().entrySet()) {
                    if (c.contains(entry.getValue())) {
                        toRemove.add(entry.getKey());
                    }
                }
                return map().keySet().removeAll(toRemove);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> c) {
            try {
                return retainAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<K> toRetain = Sets.newHashSet();
                for (Map.Entry<K, V> entry : map().entrySet()) {
                    if (c.contains(entry.getValue())) {
                        toRetain.add(entry.getKey());
                    }
                }
                return map().keySet().retainAll(toRetain);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return map().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object o) {
            return map().containsValue(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            map().clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$EntrySet.class */
    public static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        abstract Map<K, V> map();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return map().size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            map().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry)) {
                return false;
            }
            Map.Entry<?, ?> entry = (Map.Entry) o;
            Object key = entry.getKey();
            Object safeGet = Maps.safeGet(map(), key);
            return Objects.equal(safeGet, entry.getValue()) && (safeGet != null || map().containsKey(key));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return map().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (contains(o)) {
                return map().keySet().remove(((Map.Entry) o).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c) {
            try {
                return removeAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                return Sets.removeAllImpl(this, c.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c) {
            try {
                return retainAll((Collection) Preconditions.checkNotNull(c));
            } catch (UnsupportedOperationException e) {
                Set<Object> keys = Sets.newHashSetWithExpectedSize(c.size());
                for (Object o : c) {
                    if (contains(o)) {
                        keys.add(((Map.Entry) o).getKey());
                    }
                }
                return map().keySet().retainAll(keys);
            }
        }
    }

    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/collect/Maps$DescendingMap.class */
    static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
        private transient Comparator<? super K> comparator;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient NavigableSet<K> navigableKeySet;

        abstract NavigableMap<K, V> forward();

        abstract Iterator<Map.Entry<K, V>> entryIterator();

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Map<K, V> delegate() {
            return forward();
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> result = this.comparator;
            if (result == null) {
                Comparator<? super K> forwardCmp = forward().comparator();
                if (forwardCmp == null) {
                    forwardCmp = Ordering.natural();
                }
                Comparator<? super K> reverse = reverse(forwardCmp);
                this.comparator = reverse;
                result = reverse;
            }
            return result;
        }

        private static <T> Ordering<T> reverse(Comparator<T> forward) {
            return Ordering.from(forward).reverse();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return forward().lastKey();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return forward().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K key) {
            return forward().higherEntry(key);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K key) {
            return forward().higherKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K key) {
            return forward().ceilingEntry(key);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K key) {
            return forward().ceilingKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K key) {
            return forward().floorEntry(key);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K key) {
            return forward().floorKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K key) {
            return forward().lowerEntry(key);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K key) {
            return forward().lowerKey(key);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return forward().lastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return forward().firstEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return forward().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return forward().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return forward();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> result = this.entrySet;
            if (result != null) {
                return result;
            }
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }

        Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>() { // from class: com.google.common.collect.Maps.DescendingMap.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                Map<K, V> map() {
                    return DescendingMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
                public Iterator<Map.Entry<K, V>> iterator() {
                    return DescendingMap.this.entryIterator();
                }
            };
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> result = this.navigableKeySet;
            if (result != null) {
                return result;
            }
            NavigableKeySet navigableKeySet = new NavigableKeySet(this);
            this.navigableKeySet = navigableKeySet;
            return navigableKeySet;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return forward().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            return forward().subMap(toKey, toInclusive, fromKey, fromInclusive).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            return forward().tailMap(toKey, inclusive).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K toKey) {
            return headMap(toKey, false);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            return forward().headMap(fromKey, inclusive).descendingMap();
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K fromKey) {
            return tailMap(fromKey, true);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public Collection<V> values() {
            return new Values(this);
        }

        @Override // com.google.common.collect.ForwardingObject, java.lang.Object
        public String toString() {
            return standardToString();
        }
    }

    /* access modifiers changed from: package-private */
    public static <E> ImmutableMap<E, Integer> indexMap(Collection<E> list) {
        ImmutableMap.Builder<E, Integer> builder = new ImmutableMap.Builder<>(list.size());
        int i = 0;
        for (E e : list) {
            i++;
            builder.put(e, Integer.valueOf(i));
        }
        return builder.build();
    }

    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> map, Range<K> range) {
        if (map.comparator() != null && map.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(map.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            return map.subMap(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED, range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        } else if (range.hasLowerBound()) {
            return map.tailMap(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED);
        } else if (!range.hasUpperBound()) {
            return (NavigableMap) Preconditions.checkNotNull(map);
        } else {
            return map.headMap(range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        }
    }
}
