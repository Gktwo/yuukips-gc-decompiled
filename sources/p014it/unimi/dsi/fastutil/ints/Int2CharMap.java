package p014it.unimi.dsi.fastutil.ints;

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
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.CharBinaryOperator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.ints.Int2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharMap.class */
public interface Int2CharMap extends Int2CharFunction, Map<Integer, Character> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    void defaultReturnValue(char c);

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    char defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharSortedMap
    ObjectSet<Entry> int2CharEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.ints.IntSet' to match base method */
    @Override // java.util.Map
    Set<Integer> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // java.util.Map
    Collection<Character> values();

    boolean containsKey(int i);

    boolean containsValue(char c);

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Integer, java.lang.Character>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Integer, Character>> entrySet() {
        return int2CharEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    @Deprecated
    default Character put(Integer key, Character value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction, p014it.unimi.dsi.fastutil.Function
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
        return containsValue(((Character) value).charValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super Integer, ? super Character> consumer) {
        ObjectSet<Entry> entrySet = int2CharEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Integer.valueOf(entry.getIntKey()), Character.valueOf(entry.getCharValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    default char getOrDefault(int key, char defaultValue) {
        char v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2CharFunction
    @Deprecated
    default Character getOrDefault(Object key, Character defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default char putIfAbsent(int key, char value) {
        char v = get(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(int key, char value) {
        char curValue = get(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(int key, char oldValue, char newValue) {
        char curValue = get(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default char replace(int key, char value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default char computeIfAbsent(int key, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default char computeIfAbsentNullable(int key, IntFunction<? extends Character> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = get(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        Character mappedValue = (Character) mappingFunction.apply(key);
        if (mappedValue == null) {
            return drv;
        }
        char newValue = mappedValue.charValue();
        put(key, newValue);
        return newValue;
    }

    default char computeIfAbsent(int key, Int2CharFunction mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = get(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        char newValue = mappingFunction.get(key);
        put(key, newValue);
        return newValue;
    }

    @Deprecated
    default char computeIfAbsentPartial(int key, Int2CharFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default char computeIfPresent(int key, BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Character newValue = (Character) remappingFunction.apply(Integer.valueOf(key), Character.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        char newVal = newValue.charValue();
        put(key, newVal);
        return newVal;
    }

    default char compute(int key, BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Character newValue = (Character) remappingFunction.apply(Integer.valueOf(key), contained ? Character.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                remove(key);
            }
            return drv;
        }
        char newVal = newValue.charValue();
        put(key, newVal);
        return newVal;
    }

    default char merge(int key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        char newValue;
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Character mergedValue = (Character) remappingFunction.apply(Character.valueOf(oldValue), Character.valueOf(value));
            if (mergedValue == null) {
                remove(key);
                return drv;
            }
            newValue = mergedValue.charValue();
        } else {
            newValue = value;
        }
        put(key, newValue);
        return newValue;
    }

    default char mergeChar(int key, char value, CharBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default char mergeChar(int key, char value, IntBinaryOperator remappingFunction) {
        return mergeChar(key, value, remappingFunction instanceof CharBinaryOperator ? (CharBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToChar(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Character putIfAbsent(Integer key, Character value) {
        return putIfAbsent((Int2CharMap) key, (Integer) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Integer key, Character oldValue, Character newValue) {
        return replace((Int2CharMap) key, oldValue, newValue);
    }

    @Deprecated
    default Character replace(Integer key, Character value) {
        return replace((Int2CharMap) key, (Integer) value);
    }

    @Deprecated
    default Character computeIfAbsent(Integer key, Function<? super Integer, ? extends Character> mappingFunction) {
        return computeIfAbsent((Int2CharMap) key, (Function<? super Int2CharMap, ? extends Character>) mappingFunction);
    }

    @Deprecated
    default Character computeIfPresent(Integer key, BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
        return computeIfPresent((Int2CharMap) key, (BiFunction<? super Int2CharMap, ? super Character, ? extends Character>) remappingFunction);
    }

    @Deprecated
    default Character compute(Integer key, BiFunction<? super Integer, ? super Character, ? extends Character> remappingFunction) {
        return compute((Int2CharMap) key, (BiFunction<? super Int2CharMap, ? super Character, ? extends Character>) remappingFunction);
    }

    @Deprecated
    default Character merge(Integer key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        return merge((Int2CharMap) key, (Integer) value, (BiFunction<? super Integer, ? super Integer, ? extends Integer>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.ints.Int2CharMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2CharMap$Entry.class */
    public interface Entry extends Map.Entry<Integer, Character> {
        int getIntKey();

        char getCharValue();

        char setValue(char c);

        @Override // java.util.Map.Entry
        @Deprecated
        default Integer getKey() {
            return Integer.valueOf(getIntKey());
        }

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getValue() {
            return Character.valueOf(getCharValue());
        }

        @Deprecated
        default Character setValue(Character value) {
            return Character.valueOf(setValue(value.charValue()));
        }
    }
}
