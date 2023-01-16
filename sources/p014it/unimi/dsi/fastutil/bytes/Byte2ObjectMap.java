package p014it.unimi.dsi.fastutil.bytes;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import p014it.unimi.dsi.fastutil.objects.ObjectCollection;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMap.class */
public interface Byte2ObjectMap<V> extends Byte2ObjectFunction<V>, Map<Byte, V> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
    void defaultReturnValue(V v);

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
    V defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectSortedMap
    ObjectSet<Entry<V>> byte2ObjectEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteSet' to match base method */
    @Override // java.util.Map
    Set<Byte> keySet();

    @Override // java.util.Map
    ObjectCollection<V> values();

    boolean containsKey(byte b);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Object put(Byte b, Object obj) {
        return put(b, (Byte) obj);
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMap$FastEntrySet.class */
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
    default ObjectSet<Map.Entry<Byte, V>> entrySet() {
        return byte2ObjectEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
    @Deprecated
    default V put(Byte key, V value) {
        return put(key, (Byte) value);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        return containsKey(key);
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Byte, ? super V> consumer) {
        ObjectSet<Entry<V>> entrySet = byte2ObjectEntrySet();
        Consumer<Entry<V>> wrappingConsumer = entry -> {
            consumer.accept(Byte.valueOf(entry.getByteKey()), entry.getValue());
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction
    default V getOrDefault(byte key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V getOrDefault(Object key, V defaultValue) {
        return getOrDefault(key, defaultValue);
    }

    default V putIfAbsent(byte key, V value) {
        V v = get(key);
        V drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, (byte) value);
        return drv;
    }

    default boolean remove(byte key, Object value) {
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

    default boolean replace(byte key, V oldValue, V newValue) {
        V curValue = get(key);
        if (!Objects.equals(curValue, oldValue)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, (byte) newValue);
        return true;
    }

    default V replace(byte key, V value) {
        return containsKey(key) ? put(key, (byte) value) : defaultReturnValue();
    }

    default V computeIfAbsent(byte key, IntFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        V newValue = (V) mappingFunction.apply(key);
        put(key, (byte) newValue);
        return newValue;
    }

    default V computeIfAbsent(byte key, Byte2ObjectFunction<? extends V> mappingFunction) {
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
        put(key, (byte) newValue);
        return newValue;
    }

    @Deprecated
    default V computeIfAbsentPartial(byte key, Byte2ObjectFunction<? extends V> mappingFunction) {
        return computeIfAbsent(key, (Byte2ObjectFunction) mappingFunction);
    }

    default V computeIfPresent(byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Object obj = (Object) get(key);
        V drv = defaultReturnValue();
        if (obj == drv && !containsKey(key)) {
            return drv;
        }
        V newValue = (V) remappingFunction.apply(Byte.valueOf(key), obj);
        if (newValue == null) {
            remove(key);
            return drv;
        }
        put(key, (byte) newValue);
        return newValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super V */
    default V compute(byte key, BiFunction<? super Byte, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        V drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        V newValue = (V) remappingFunction.apply(Byte.valueOf(key), contained ? oldValue : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        put(key, (byte) newValue);
        return newValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    default V merge(byte key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
        put(key, (byte) newValue);
        return newValue;
    }

    /* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ObjectMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ObjectMap$Entry.class */
    public interface Entry<V> extends Map.Entry<Byte, V> {
        byte getByteKey();

        @Override // java.util.Map.Entry
        @Deprecated
        default Byte getKey() {
            return Byte.valueOf(getByteKey());
        }
    }
}
