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
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectSet;

/* renamed from: it.unimi.dsi.fastutil.chars.Char2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharMap.class */
public interface Char2CharMap extends Char2CharFunction, Map<Character, Character> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction
    void defaultReturnValue(char c);

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction
    char defaultReturnValue();

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharSortedMap
    ObjectSet<Entry> char2CharEntrySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharSet' to match base method */
    @Override // java.util.Map
    Set<Character> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // java.util.Map
    Collection<Character> values();

    boolean containsKey(char c);

    boolean containsValue(char c);

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2CharMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharMap$FastEntrySet.class */
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

    /* Return type fixed from 'it.unimi.dsi.fastutil.objects.ObjectSet<java.util.Map$Entry<java.lang.Character, java.lang.Character>>' to match base method */
    @Override // java.util.Map
    @Deprecated
    default Set<Map.Entry<Character, Character>> entrySet() {
        return char2CharEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction
    @Deprecated
    default Character put(Character key, Character value) {
        return put(key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        return remove(key);
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction, p014it.unimi.dsi.fastutil.Function
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
    default void forEach(BiConsumer<? super Character, ? super Character> consumer) {
        ObjectSet<Entry> entrySet = char2CharEntrySet();
        Consumer<Entry> wrappingConsumer = entry -> {
            consumer.accept(Character.valueOf(entry.getCharKey()), Character.valueOf(entry.getCharValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction
    default char getOrDefault(char key, char defaultValue) {
        char v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2CharFunction
    @Deprecated
    default Character getOrDefault(Object key, Character defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default char putIfAbsent(char key, char value) {
        char v = get(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put(key, value);
        return drv;
    }

    default boolean remove(char key, char value) {
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

    default boolean replace(char key, char oldValue, char newValue) {
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

    default char replace(char key, char value) {
        return containsKey(key) ? put(key, value) : defaultReturnValue();
    }

    default char computeIfAbsent(char key, IntUnaryOperator mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = get(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(key));
        put(key, newValue);
        return newValue;
    }

    default char computeIfAbsentNullable(char key, IntFunction<? extends Character> mappingFunction) {
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

    default char computeIfAbsent(char key, Char2CharFunction mappingFunction) {
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
    default char computeIfAbsentPartial(char key, Char2CharFunction mappingFunction) {
        return computeIfAbsent(key, mappingFunction);
    }

    default char computeIfPresent(char key, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Character newValue = (Character) remappingFunction.apply(Character.valueOf(key), Character.valueOf(oldValue));
        if (newValue == null) {
            remove(key);
            return drv;
        }
        char newVal = newValue.charValue();
        put(key, newVal);
        return newVal;
    }

    default char compute(char key, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Character newValue = (Character) remappingFunction.apply(Character.valueOf(key), contained ? Character.valueOf(oldValue) : null);
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

    default char merge(char key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
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

    default char mergeChar(char key, char value, CharBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = get(key);
        char newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put(key, newValue);
        return newValue;
    }

    default char mergeChar(char key, char value, IntBinaryOperator remappingFunction) {
        return mergeChar(key, value, remappingFunction instanceof CharBinaryOperator ? (CharBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToChar(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default Character putIfAbsent(Character key, Character value) {
        return putIfAbsent((Char2CharMap) key, value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(Character key, Character oldValue, Character newValue) {
        return replace((Char2CharMap) key, oldValue, newValue);
    }

    @Deprecated
    default Character replace(Character key, Character value) {
        return replace((Char2CharMap) key, value);
    }

    @Deprecated
    default Character computeIfAbsent(Character key, Function<? super Character, ? extends Character> mappingFunction) {
        return computeIfAbsent((Char2CharMap) key, (Function<? super Char2CharMap, ? extends Character>) mappingFunction);
    }

    @Deprecated
    default Character computeIfPresent(Character key, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        return computeIfPresent((Char2CharMap) key, (BiFunction<? super Char2CharMap, ? super Character, ? extends Character>) remappingFunction);
    }

    @Deprecated
    default Character compute(Character key, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        return compute((Char2CharMap) key, (BiFunction<? super Char2CharMap, ? super Character, ? extends Character>) remappingFunction);
    }

    @Deprecated
    default Character merge(Character key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        return merge((Char2CharMap) key, value, remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.chars.Char2CharMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2CharMap$Entry.class */
    public interface Entry extends Map.Entry<Character, Character> {
        char getCharKey();

        char getCharValue();

        char setValue(char c);

        @Override // java.util.Map.Entry
        @Deprecated
        default Character getKey() {
            return Character.valueOf(getCharKey());
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
