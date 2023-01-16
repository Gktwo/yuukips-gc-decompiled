package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.shorts.ShortBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortMap.class */
public interface Reference2ShortMap<K> extends Reference2ShortFunction<K>, Map<K, Short> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction
    void defaultReturnValue(short s);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction
    short defaultReturnValue();

    ObjectSet<Entry<K>> reference2ShortEntrySet();

    @Override // java.util.Map
    ReferenceSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.shorts.ShortCollection' to match base method */
    @Override // java.util.Map
    Collection<Short> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(short s);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Short put(Object obj, Short sh) {
        return put((Reference2ShortMap<K>) obj, sh);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Short merge(Object obj, Short sh, BiFunction<? super Short, ? super Short, ? extends Short> biFunction) {
        return merge((Reference2ShortMap<K>) obj, sh, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Short replace(Object obj, Short sh) {
        return replace((Reference2ShortMap<K>) obj, sh);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default boolean replace(Object obj, Short sh, Short sh2) {
        return replace((Reference2ShortMap<K>) obj, sh, sh2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Short putIfAbsent(Object obj, Short sh) {
        return putIfAbsent((Reference2ShortMap<K>) obj, sh);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortMap$FastEntrySet.class */
    public interface FastEntrySet<K> extends ObjectSet<Entry<K>> {
        ObjectIterator<Entry<K>> fastIterator();

        default void fastForEach(Consumer<? super Entry<K>> consumer) {
            forEach(consumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    default void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    default ObjectSet<Map.Entry<K, Short>> entrySet() {
        return reference2ShortEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction
    @Deprecated
    default Short put(K key, Short value) {
        return put((Reference2ShortMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        return remove(key);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        return containsValue(((Short) value).shortValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super K, ? super Short> consumer) {
        ObjectSet<Entry<K>> entrySet = reference2ShortEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Short.valueOf(entry.getShortValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction
    default short getOrDefault(Object key, short defaultValue) {
        short v = getShort(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction
    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default short putIfAbsent(K key, short value) {
        short v = getShort(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Reference2ShortMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, short value) {
        short curValue = getShort(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeShort(key);
        return true;
    }

    default boolean replace(K key, short oldValue, short newValue) {
        short curValue = getShort(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Reference2ShortMap<K>) key, newValue);
        return true;
    }

    default short replace(K key, short value) {
        return containsKey(key) ? put((Reference2ShortMap<K>) key, value) : defaultReturnValue();
    }

    default short computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = getShort(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        short newValue = SafeMath.safeIntToShort(mappingFunction.applyAsInt(key));
        put((Reference2ShortMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default short computeShortIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2ShortMap<K>) key, (ToIntFunction<? super Reference2ShortMap<K>>) mappingFunction);
    }

    default short computeIfAbsent(K key, Reference2ShortFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        short v = getShort(key);
        short drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        short newValue = mappingFunction.getShort(key);
        put((Reference2ShortMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default short computeShortIfAbsentPartial(K key, Reference2ShortFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2ShortMap<K>) key, (Reference2ShortFunction<? super Reference2ShortMap<K>>) mappingFunction);
    }

    default short computeShortIfPresent(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = getShort(key);
        short drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Short newValue = (Short) remappingFunction.apply(key, Short.valueOf(oldValue));
        if (newValue == null) {
            removeShort(key);
            return drv;
        }
        short newVal = newValue.shortValue();
        put((Reference2ShortMap<K>) key, newVal);
        return newVal;
    }

    default short computeShort(K key, BiFunction<? super K, ? super Short, ? extends Short> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = getShort(key);
        short drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Short newValue = (Short) remappingFunction.apply(key, contained ? Short.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeShort(key);
            }
            return drv;
        }
        short newVal = newValue.shortValue();
        put((Reference2ShortMap<K>) key, newVal);
        return newVal;
    }

    default short merge(K key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        short newValue;
        Objects.requireNonNull(remappingFunction);
        short oldValue = getShort(key);
        short drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Short mergedValue = (Short) remappingFunction.apply(Short.valueOf(oldValue), Short.valueOf(value));
            if (mergedValue == null) {
                removeShort(key);
                return drv;
            }
            newValue = mergedValue.shortValue();
        } else {
            newValue = value;
        }
        put((Reference2ShortMap<K>) key, newValue);
        return newValue;
    }

    default short mergeShort(K key, short value, ShortBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        short oldValue = getShort(key);
        short newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put((Reference2ShortMap<K>) key, newValue);
        return newValue;
    }

    default short mergeShort(K key, short value, IntBinaryOperator remappingFunction) {
        return mergeShort((Reference2ShortMap<K>) key, value, remappingFunction instanceof ShortBinaryOperator ? (ShortBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToShort(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default short mergeShort(K key, short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return merge((Reference2ShortMap<K>) key, value, remappingFunction);
    }

    @Deprecated
    default Short putIfAbsent(K key, Short value) {
        return putIfAbsent((Reference2ShortMap<K>) key, (K) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(K key, Short oldValue, Short newValue) {
        return replace((Reference2ShortMap<K>) key, oldValue, newValue);
    }

    @Deprecated
    default Short replace(K key, Short value) {
        return replace((Reference2ShortMap<K>) key, (K) value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.function.BiFunction<? super java.lang.Short, ? super java.lang.Short, ? extends java.lang.Short> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    default Short merge(K key, Short value, BiFunction<? super Short, ? super Short, ? extends Short> remappingFunction) {
        return merge((Reference2ShortMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ShortMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ShortMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Short> {
        short getShortValue();

        short setValue(short s);

        @Override // java.util.Map.Entry
        @Deprecated
        default Short getValue() {
            return Short.valueOf(getShortValue());
        }

        @Deprecated
        default Short setValue(Short value) {
            return Short.valueOf(setValue(value.shortValue()));
        }
    }
}
