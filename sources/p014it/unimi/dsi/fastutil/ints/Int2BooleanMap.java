package p014it.unimi.dsi.fastutil.ints;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanMap.class */
public interface Int2BooleanMap extends Int2BooleanFunction, Map<Integer, Boolean> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
    void defaultReturnValue(boolean z);

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
    boolean defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanSortedMap
    ObjectSet<Entry> int2BooleanEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // java.util.Map
    Set<Integer> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // java.util.Map
    Collection<Boolean> values();

    boolean containsKey(int i);

    boolean containsValue(boolean z);

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanMap$FastEntrySet.class */
    public interface FastEntrySet extends ObjectSet<Entry> {
        ObjectIterator<Entry> fastIterator();

        default void fastForEach(Consumer<? super Entry> consumer) {
            forEach(consumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    default void clear() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Boolean>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Integer, Boolean>> entrySet() {
        return int2BooleanEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
    @Deprecated
    default Boolean put(Integer key, Boolean value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        return containsKey(key);
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
    default void forEach(BiConsumer<? super Integer, ? super Boolean> consumer) {
        ObjectSet<Entry> entrySet = int2BooleanEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Integer.valueOf(entry.getIntKey()), Boolean.valueOf(entry.getBooleanValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
    default boolean getOrDefault(int key, boolean defaultValue) {
        boolean v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction
    @Deprecated
    default Boolean getOrDefault(Object key, Boolean defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default boolean putIfAbsent(int key, boolean value) {
        boolean v = get(key);
        boolean drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(int key, boolean value) {
        boolean curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(int key, boolean oldValue, boolean newValue) {
        boolean curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default boolean replace(int key, boolean value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default boolean computeIfAbsent(int key, IntPredicate mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        boolean v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        boolean newValue = mappingFunction.test(key);
        put(key, newValue);
        return newValue;
    }

    default boolean computeIfAbsentNullable(int key, IntFunction<? extends Boolean> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        boolean v = get(key);
        boolean drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Boolean mappedValue = (Boolean) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        boolean newValue = mappedValue.booleanValue();
        put(key, newValue);
        return newValue;
    }

    default boolean computeIfAbsent(int key, Int2BooleanFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        boolean v = get(key);
        boolean drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        boolean newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default boolean computeIfAbsentPartial(int key, Int2BooleanFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default boolean computeIfPresent(int key, BiFunction<? super Integer, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = get(key);
        boolean drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Boolean newValue = (Boolean) remappingFunction.apply(Integer.valueOf(key), Boolean.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        boolean newVal = newValue.booleanValue();
        put(key, newVal);
        return newVal;
    }

    default boolean compute(int key, BiFunction<? super Integer, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = get(key);
        boolean drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Boolean newValue = (Boolean) remappingFunction.apply(Integer.valueOf(key), contained ? Boolean.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        boolean newVal = newValue.booleanValue();
        put(key, newVal);
        return newVal;
    }

    default boolean merge(int key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
        boolean newValue;
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = get(key);
        boolean drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Boolean mergedValue = (Boolean) remappingFunction.apply(Boolean.valueOf(oldValue), Boolean.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.booleanValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2BooleanMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2BooleanMap$Entry.class */
    public interface Entry extends Map.Entry<Integer, Boolean> {
        int getIntKey();

        boolean getBooleanValue();

        boolean setValue(boolean z);

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getKey() {
            return Integer.valueOf(getIntKey());
        }

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
