package p014it.unimi.dsi.fastutil.chars;

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

/* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMap.class */
public interface Char2BooleanMap extends Char2BooleanFunction, Map<Character, Boolean> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    void defaultReturnValue(boolean z);

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    boolean defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanSortedMap
    ObjectSet<Entry> char2BooleanEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // java.util.Map
    Set<Character> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.booleans.BooleanCollection' to match base method */
    @Override // java.util.Map
    Collection<Boolean> values();

    boolean containsKey(char c);

    boolean containsValue(boolean z);

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Boolean>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Character, Boolean>> entrySet() {
        return char2BooleanEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    @Deprecated
    default Boolean put(Character key, Boolean value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Character, ? super Boolean> consumer) {
        ObjectSet<Entry> entrySet = char2BooleanEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Character.valueOf(entry.getCharKey()), Boolean.valueOf(entry.getBooleanValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    default boolean getOrDefault(char key, boolean defaultValue) {
        boolean v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction
    @Deprecated
    default Boolean getOrDefault(Object key, Boolean defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default boolean putIfAbsent(char key, boolean value) {
        boolean v = get(key);
        boolean drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(char key, boolean value) {
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

    default boolean replace(char key, boolean oldValue, boolean newValue) {
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

    default boolean replace(char key, boolean value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default boolean computeIfAbsent(char key, IntPredicate mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        boolean v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        boolean newValue = mappingFunction.test(key);
        put(key, newValue);
        return newValue;
    }

    default boolean computeIfAbsentNullable(char key, IntFunction<? extends Boolean> mappingFunction) {
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

    default boolean computeIfAbsent(char key, Char2BooleanFunction mappingFunction) {
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
    default boolean computeIfAbsentPartial(char key, Char2BooleanFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default boolean computeIfPresent(char key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = get(key);
        boolean drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Boolean newValue = (Boolean) remappingFunction.apply(Character.valueOf(key), Boolean.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        boolean newVal = newValue.booleanValue();
        put(key, newVal);
        return newVal;
    }

    default boolean compute(char key, BiFunction<? super Character, ? super Boolean, ? extends Boolean> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        boolean oldValue = get(key);
        boolean drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Boolean newValue = (Boolean) remappingFunction.apply(Character.valueOf(key), contained ? Boolean.valueOf(oldValue) : null);
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

    default boolean merge(char key, boolean value, BiFunction<? super Boolean, ? super Boolean, ? extends Boolean> remappingFunction) {
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

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2BooleanMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2BooleanMap$Entry.class */
    public interface Entry extends Map.Entry<Character, Boolean> {
        char getCharKey();

        boolean getBooleanValue();

        boolean setValue(boolean z);

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getKey() {
            return Character.valueOf(getCharKey());
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
