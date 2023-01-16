package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMap.class */
public interface Object2BooleanMap<K> extends Object2BooleanFunction<K>, Map<K, Boolean> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    void defaultReturnValue(boolean z);

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    boolean defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanSortedMap
    ObjectSet<Entry<K>> object2BooleanEntrySet();

    @Override // java.util.Map
    ObjectSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // java.util.Map
    Collection<Boolean> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(boolean z);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Boolean put(Object obj, Boolean bool) {
        return put((Object2BooleanMap<K>) obj, bool);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMap$FastEntrySet.class */
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
    default ObjectSet<Map.Entry<K, Boolean>> entrySet() {
        return object2BooleanEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    @Deprecated
    default Boolean put(K key, Boolean value) {
        return put((Object2BooleanMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        return remove(key);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        return containsValue(((Boolean) value).booleanValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super K, ? super Boolean> consumer) {
        ObjectSet<Entry<K>> entrySet = object2BooleanEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Boolean.valueOf(entry.getBooleanValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    default boolean getOrDefault(Object key, boolean defaultValue) {
        boolean v = getBoolean(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Object2BooleanFunction
    @Deprecated
    default Boolean getOrDefault(Object key, Boolean defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default boolean putIfAbsent(K key, boolean value) {
        boolean v = getBoolean(key);
        boolean drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Object2BooleanMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, boolean value) {
        boolean curValue = getBoolean(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeBoolean(key);
        return true;
    }

    default boolean replace(K key, boolean oldValue, boolean newValue) {
        boolean curValue = getBoolean(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Object2BooleanMap<K>) key, newValue);
        return true;
    }

    default boolean replace(K key, boolean value) {
        return containsKey(key) ? put((Object2BooleanMap<K>) key, value) : defaultReturnValue();
    }

    default boolean computeIfAbsent(K key, Predicate<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        boolean v = getBoolean(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        boolean newValue = mappingFunction.test(key);
        put((Object2BooleanMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default boolean computeBooleanIfAbsent(K key, Predicate<? super K> mappingFunction) {
        return computeIfAbsent((Object2BooleanMap<K>) key, (Predicate<? super Object2BooleanMap<K>>) mappingFunction);
    }

    default boolean computeIfAbsent(K key, Object2BooleanFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        boolean v = getBoolean(key);
        boolean drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        boolean newValue = mappingFunction.getBoolean(key);
        put((Object2BooleanMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default boolean computeBooleanIfAbsentPartial(K key, Object2BooleanFunction<? super K> mappingFunction) {
        return computeIfAbsent((Object2BooleanMap<K>) key, (Object2BooleanFunction<? super Object2BooleanMap<K>>) mappingFunction);
    }

    default boolean computeBooleanIfPresent(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = getBoolean(key);
        boolean drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Boolean newValue = (Boolean) remappingFunction.apply(key, Boolean.valueOf(oldValue));
        if (newValue == null) {
            removeBoolean(key);
            return drv;
        }
        boolean newVal = newValue.booleanValue();
        put((Object2BooleanMap<K>) key, newVal);
        return newVal;
    }

    default boolean computeBoolean(K key, BiFunction<? super K, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = getBoolean(key);
        boolean drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Boolean newValue = (Boolean) remappingFunction.apply(key, contained ? Boolean.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeBoolean(key);
            }
            return drv;
        }
        boolean newVal = newValue.booleanValue();
        put((Object2BooleanMap<K>) key, newVal);
        return newVal;
    }

    default boolean merge(K key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
        boolean newValue;
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = getBoolean(key);
        boolean drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Boolean mergedValue = (Boolean) remappingFunction.apply(Boolean.valueOf(oldValue), Boolean.valueOf(value));
            if (mergedValue == null) {
                removeBoolean(key);
                return drv;
            }
            newValue = mergedValue.booleanValue();
        } else {
            newValue = value;
        }
        put((Object2BooleanMap<K>) key, newValue);
        return newValue;
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Object2BooleanMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2BooleanMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Boolean> {
        boolean getBooleanValue();

        boolean setValue(boolean z);

        @Override // java.util.Map.Entry
        @Deprecated
        default Boolean getValue() {
            return Boolean.valueOf(getBooleanValue());
        }

        @Deprecated
        default Boolean setValue(Boolean value) {
            return Boolean.valueOf(setValue(value.booleanValue()));
        }
    }
}
