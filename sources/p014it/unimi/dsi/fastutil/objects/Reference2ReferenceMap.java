package p014it.unimi.dsi.fastutil.objects;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceMap.class */
public interface Reference2ReferenceMap<K, V> extends Reference2ReferenceFunction<K, V>, Map<K, V> {

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceMap$Entry.class */
    public interface Entry<K, V> extends Map.Entry<K, V> {
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction
    void defaultReturnValue(V v);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction
    V defaultReturnValue();

    ObjectSet<Entry<K, V>> reference2ReferenceEntrySet();

    @Override // java.util.Map
    ReferenceSet<K> keySet();

    @Override // java.util.Map
    ReferenceCollection<V> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceMap$FastEntrySet.class */
    public interface FastEntrySet<K, V> extends ObjectSet<Entry<K, V>> {
        ObjectIterator<Entry<K, V>> fastIterator();

        default void fastForEach(Consumer<? super Entry<K, V>> consumer) {
            forEach(consumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    default void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    default ObjectSet<Map.Entry<K, V>> entrySet() {
        return reference2ReferenceEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    default V put(K key, V value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    default V remove(Object key) {
        return remove(key);
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super K, ? super V> consumer) {
        ObjectSet<Entry<K, V>> entrySet = reference2ReferenceEntrySet();
        Consumer<Entry<K, V>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), entry.getValue());
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction, p014it.unimi.dsi.fastutil.Function
    default V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // java.util.Map
    default V putIfAbsent(K key, V value) {
        V v = get(key);
        V drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    @Override // java.util.Map
    default boolean remove(Object key, Object value) {
        V curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    @Override // java.util.Map
    default boolean replace(K key, V oldValue, V newValue) {
        V curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    @Override // java.util.Map
    default V replace(K key, V value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default V computeIfAbsent(K key, Reference2ReferenceFunction<? super K, ? extends V> mappingFunction) {
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
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default V computeReferenceIfAbsentPartial(K key, Reference2ReferenceFunction<? super K, ? extends V> mappingFunction) {
        return computeIfAbsent((Reference2ReferenceMap<K, V>) key, (Reference2ReferenceFunction<? super Reference2ReferenceMap<K, V>, ? extends V>) mappingFunction);
    }

    @Override // java.util.Map
    default V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Object obj = (Object) get(key);
        V drv = defaultReturnValue();
        if (obj == drv && !containsKey(key)) {
            return drv;
        }
        V newValue = (V) remappingFunction.apply(key, obj);
        if (newValue == null) {
            remove(key);
            return drv;
        }
        put(key, newValue);
        return newValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super V */
    @Override // java.util.Map
    default V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        V drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        V newValue = (V) remappingFunction.apply(key, contained ? oldValue : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        put(key, newValue);
        return newValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    default V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
        put(key, newValue);
        return newValue;
    }
}
