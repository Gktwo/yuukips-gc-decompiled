package p014it.unimi.dsi.fastutil.doubles;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMap.class */
public interface Double2ObjectMap<V> extends Double2ObjectFunction<V>, Map<Double, V> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
    void defaultReturnValue(V v);

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
    V defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectSortedMap
    ObjectSet<Entry<V>> double2ObjectEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.doubles.DoubleSet' to match base method */
    @Override // java.util.Map
    Set<Double> keySet();

    @Override // java.util.Map
    ObjectCollection<V> values();

    boolean containsKey(double d);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Object put(Double d, Object obj) {
        return put(d, (Double) obj);
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMap$FastEntrySet.class */
    public interface FastEntrySet<V> extends ObjectSet<Entry<V>> {
        ObjectIterator<Entry<V>> fastIterator();

        default void fastForEach(Consumer<? super Entry<V>> consumer) {
            forEach(consumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    default void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    default ObjectSet<Map.Entry<Double, V>> entrySet() {
        return double2ObjectEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
    @Deprecated
    default V put(Double key, V value) {
        return put(key, (Double) value);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        return containsKey(key);
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Double, ? super V> consumer) {
        ObjectSet<Entry<V>> entrySet = double2ObjectEntrySet();
        Consumer<Entry<V>> wrappingConsumer = entry -> {
            consumer.accept(Double.valueOf(entry.getDoubleKey()), entry.getValue());
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction
    default V getOrDefault(double key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V getOrDefault(Object key, V defaultValue) {
        return getOrDefault(key, defaultValue);
    }

    default V putIfAbsent(double key, V value) {
        V v = get(key);
        V drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, (double) value);
        return drv;
    }

    default boolean remove(double key, Object value) {
        V curValue = get(key);
        if (!Objects.equals(curValue, value)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(double key, V oldValue, V newValue) {
        V curValue = get(key);
        if (!Objects.equals(curValue, oldValue)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, (double) newValue);
        return true;
    }

    default V replace(double key, V value) {
        return containsKey(key) ? put(key, (double) value) : defaultReturnValue();
    }

    default V computeIfAbsent(double key, DoubleFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        V newValue = (V) mappingFunction.apply(key);
        put(key, (double) newValue);
        return newValue;
    }

    default V computeIfAbsent(double key, Double2ObjectFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V v = get(key);
        V drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        V newValue = (V) mappingFunction.get(key);
        put(key, (double) newValue);
        return newValue;
    }

    @Deprecated
    default V computeIfAbsentPartial(double key, Double2ObjectFunction<? extends V> mappingFunction) {
        return computeIfAbsent(key, (Double2ObjectFunction) mappingFunction);
    }

    default V computeIfPresent(double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Object obj = (Object) get(key);
        V drv = defaultReturnValue();
        if (obj == drv && !containsKey(key)) {
            return drv;
        }
        V newValue = (V) remappingFunction.apply(Double.valueOf(key), obj);
        if (newValue == null) {
            remove(key);
            return drv;
        }
        put(key, (double) newValue);
        return newValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super V */
    default V compute(double key, BiFunction<? super Double, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        V drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        V newValue = (V) remappingFunction.apply(Double.valueOf(key), contained ? oldValue : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        put(key, (double) newValue);
        return newValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    default V merge(double key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        V newValue;
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = get(key);
        V drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Object apply = remappingFunction.apply(oldValue, value);
            if (apply == 0) {
                remove(key);
                return drv;
            }
            newValue = apply;
        } else {
            newValue = value;
        }
        put(key, (double) newValue);
        return newValue;
    }

    /* renamed from: it.unimi.dsi.fastutil.doubles.Double2ObjectMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ObjectMap$Entry.class */
    public interface Entry<V> extends Map.Entry<Double, V> {
        double getDoubleKey();

        @Override // java.util.Map.Entry
        @Deprecated
        default Double getKey() {
            return Double.valueOf(getDoubleKey());
        }
    }
}
