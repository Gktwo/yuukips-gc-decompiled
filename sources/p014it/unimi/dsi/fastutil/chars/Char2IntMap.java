package p014it.unimi.dsi.fastutil.chars;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2IntMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntMap.class */
public interface Char2IntMap extends Char2IntFunction, Map<Character, Integer> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    void defaultReturnValue(int i);

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    int defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntSortedMap
    ObjectSet<Entry> char2IntEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // java.util.Map
    Set<Character> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntCollection' to match base method */
    @Override // java.util.Map
    Collection<Integer> values();

    boolean containsKey(char c);

    boolean containsValue(int i);

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Integer>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Character, Integer>> entrySet() {
        return char2IntEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    @Deprecated
    default Integer put(Character key, Integer value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Integer) value).intValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Character, ? super Integer> consumer) {
        ObjectSet<Entry> entrySet = char2IntEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Character.valueOf(entry.getCharKey()), Integer.valueOf(entry.getIntValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    default int getOrDefault(char key, int defaultValue) {
        int v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2IntFunction
    @Deprecated
    default Integer getOrDefault(Object key, Integer defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default int putIfAbsent(char key, int value) {
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(char key, int value) {
        int curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(char key, int oldValue, int newValue) {
        int curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default int replace(char key, int value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default int computeIfAbsent(char key, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        int newValue = mappingFunction.applyAsInt(key);
        put(key, newValue);
        return newValue;
    }

    default int computeIfAbsentNullable(char key, IntFunction<? extends Integer> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Integer mappedValue = (Integer) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        int newValue = mappedValue.intValue();
        put(key, newValue);
        return newValue;
    }

    default int computeIfAbsent(char key, Char2IntFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        int v = get(key);
        int drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        int newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default int computeIfAbsentPartial(char key, Char2IntFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default int computeIfPresent(char key, BiFunction<? super Character, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Integer newValue = (Integer) remappingFunction.apply(Character.valueOf(key), Integer.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        int newVal = newValue.intValue();
        put(key, newVal);
        return newVal;
    }

    default int compute(char key, BiFunction<? super Character, ? super Integer, ? extends Integer> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Integer newValue = (Integer) remappingFunction.apply(Character.valueOf(key), contained ? Integer.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        int newVal = newValue.intValue();
        put(key, newVal);
        return newVal;
    }

    default int merge(char key, int value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        int newValue;
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Integer mergedValue = (Integer) remappingFunction.apply(Integer.valueOf(oldValue), Integer.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.intValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default int mergeInt(char key, int value, IntBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        int oldValue = get(key);
        int newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.applyAsInt(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default int mergeInt(char key, int value, p014it.unimi.dsi.fastutil.ints.IntBinaryOperator remappingFunction) {
        return mergeInt(key, value, (IntBinaryOperator) remappingFunction);
    }

    @Deprecated
    default Integer putIfAbsent(Character key, Integer value) {
        return putIfAbsent((Char2IntMap) key, (Character) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Character key, Integer oldValue, Integer newValue) {
        return replace((Char2IntMap) key, oldValue, newValue);
    }

    @Deprecated
    default Integer replace(Character key, Integer value) {
        return replace((Char2IntMap) key, (Character) value);
    }

    @Deprecated
    default Integer computeIfAbsent(Character key, Function<? super Character, ? extends Integer> mappingFunction) {
        return computeIfAbsent((Char2IntMap) key, (Function<? super Char2IntMap, ? extends Integer>) mappingFunction);
    }

    @Deprecated
    default Integer computeIfPresent(Character key, BiFunction<? super Character, ? super Integer, ? extends Integer> remappingFunction) {
        return computeIfPresent((Char2IntMap) key, (BiFunction<? super Char2IntMap, ? super Integer, ? extends Integer>) remappingFunction);
    }

    @Deprecated
    default Integer compute(Character key, BiFunction<? super Character, ? super Integer, ? extends Integer> remappingFunction) {
        return compute((Char2IntMap) key, (BiFunction<? super Char2IntMap, ? super Integer, ? extends Integer>) remappingFunction);
    }

    @Deprecated
    default Integer merge(Character key, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        return merge((Char2IntMap) key, (Character) value, (BiFunction<? super Character, ? super Character, ? extends Character>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2IntMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2IntMap$Entry.class */
    public interface Entry extends Map.Entry<Character, Integer> {
        char getCharKey();

        int getIntValue();

        int setValue(int i);

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getKey() {
            return Character.valueOf(getCharKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getValue() {
            return Integer.valueOf(getIntValue());
        }

        @Deprecated
        default Integer setValue(Integer value) {
            return Integer.valueOf(setValue(value.intValue()));
        }
    }
}
