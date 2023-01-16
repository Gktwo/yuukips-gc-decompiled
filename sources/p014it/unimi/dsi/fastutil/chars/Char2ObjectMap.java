package p014it.unimi.dsi.fastutil.chars;

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

/* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMap.class */
public interface Char2ObjectMap<V> extends Char2ObjectFunction<V>, Map<Character, V> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    void defaultReturnValue(V v);

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    V defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectSortedMap
    ObjectSet<Entry<V>> char2ObjectEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // java.util.Map
    Set<Character> keySet();

    @Override // java.util.Map
    ObjectCollection<V> values();

    boolean containsKey(char c);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Object put(Character ch, Object obj) {
        return put(ch, (Character) obj);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMap$FastEntrySet.class */
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
    default ObjectSet<Map.Entry<Character, V>> entrySet() {
        return char2ObjectEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    @Deprecated
    default V put(Character key, V value) {
        return put(key, (Character) value);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        return containsKey(key);
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Character, ? super V> consumer) {
        ObjectSet<Entry<V>> entrySet = char2ObjectEntrySet();
        Consumer<Entry<V>> wrappingConsumer = entry -> {
            consumer.accept(Character.valueOf(entry.getCharKey()), entry.getValue());
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction
    default V getOrDefault(char key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V getOrDefault(Object key, V defaultValue) {
        return getOrDefault(key, defaultValue);
    }

    default V putIfAbsent(char key, V value) {
        V v = get(key);
        V drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, (char) value);
        return drv;
    }

    default boolean remove(char key, Object value) {
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

    default boolean replace(char key, V oldValue, V newValue) {
        V curValue = get(key);
        if (!Objects.equals(curValue, oldValue)) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, (char) newValue);
        return true;
    }

    default V replace(char key, V value) {
        return containsKey(key) ? put(key, (char) value) : defaultReturnValue();
    }

    default V computeIfAbsent(char key, IntFunction<? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        V newValue = (V) mappingFunction.apply(key);
        put(key, (char) newValue);
        return newValue;
    }

    default V computeIfAbsent(char key, Char2ObjectFunction<? extends V> mappingFunction) {
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
        put(key, (char) newValue);
        return newValue;
    }

    @Deprecated
    default V computeIfAbsentPartial(char key, Char2ObjectFunction<? extends V> mappingFunction) {
        return computeIfAbsent(key, (Char2ObjectFunction) mappingFunction);
    }

    default V computeIfPresent(char key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Object obj = (Object) get(key);
        V drv = defaultReturnValue();
        if (obj == drv && !containsKey(key)) {
            return drv;
        }
        V newValue = (V) remappingFunction.apply(Character.valueOf(key), obj);
        if (newValue == null) {
            remove(key);
            return drv;
        }
        put(key, (char) newValue);
        return newValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r2v1. Raw type applied. Possible types: ? super V */
    default V compute(char key, BiFunction<? super Character, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);
        V drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        V newValue = (V) remappingFunction.apply(Character.valueOf(key), contained ? oldValue : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        put(key, (char) newValue);
        return newValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    default V merge(char key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
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
        put(key, (char) newValue);
        return newValue;
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2ObjectMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ObjectMap$Entry.class */
    public interface Entry<V> extends Map.Entry<Character, V> {
        char getCharKey();

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getKey() {
            return Character.valueOf(getCharKey());
        }
    }
}
