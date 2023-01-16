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
import p014it.unimi.dsi.fastutil.chars.CharBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharMap.class */
public interface Reference2CharMap<K> extends Reference2CharFunction<K>, Map<K, Character> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    void defaultReturnValue(char c);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    char defaultReturnValue();

    ObjectSet<Entry<K>> reference2CharEntrySet();

    @Override // java.util.Map
    ReferenceSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharCollection' to match base method */
    @Override // java.util.Map
    Collection<Character> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(char c);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Character put(Object obj, Character ch) {
        return put((Reference2CharMap<K>) obj, ch);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Character merge(Object obj, Character ch, BiFunction<? super Character, ? super Character, ? extends Character> biFunction) {
        return merge((Reference2CharMap<K>) obj, ch, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Character replace(Object obj, Character ch) {
        return replace((Reference2CharMap<K>) obj, ch);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default boolean replace(Object obj, Character ch, Character ch2) {
        return replace((Reference2CharMap<K>) obj, ch, ch2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Character putIfAbsent(Object obj, Character ch) {
        return putIfAbsent((Reference2CharMap<K>) obj, ch);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharMap$FastEntrySet.class */
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
    default ObjectSet<Map.Entry<K, Character>> entrySet() {
        return reference2CharEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    @Deprecated
    default Character put(K key, Character value) {
        return put((Reference2CharMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        return remove(key);
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
    default void forEach(BiConsumer<? super K, ? super Character> consumer) {
        ObjectSet<Entry<K>> entrySet = reference2CharEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Character.valueOf(entry.getCharValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    default char getOrDefault(Object key, char defaultValue) {
        char v = getChar(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2CharFunction
    @Deprecated
    default Character getOrDefault(Object key, Character defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default char putIfAbsent(K key, char value) {
        char v = getChar(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Reference2CharMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, char value) {
        char curValue = getChar(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeChar(key);
        return true;
    }

    default boolean replace(K key, char oldValue, char newValue) {
        char curValue = getChar(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Reference2CharMap<K>) key, newValue);
        return true;
    }

    default char replace(K key, char value) {
        return containsKey(key) ? put((Reference2CharMap<K>) key, value) : defaultReturnValue();
    }

    default char computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = getChar(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        char newValue = SafeMath.safeIntToChar(mappingFunction.applyAsInt(key));
        put((Reference2CharMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default char computeCharIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2CharMap<K>) key, (ToIntFunction<? super Reference2CharMap<K>>) mappingFunction);
    }

    default char computeIfAbsent(K key, Reference2CharFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        char v = getChar(key);
        char drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        char newValue = mappingFunction.getChar(key);
        put((Reference2CharMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default char computeCharIfAbsentPartial(K key, Reference2CharFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2CharMap<K>) key, (Reference2CharFunction<? super Reference2CharMap<K>>) mappingFunction);
    }

    default char computeCharIfPresent(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = getChar(key);
        char drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Character newValue = (Character) remappingFunction.apply(key, Character.valueOf(oldValue));
        if (newValue == null) {
            removeChar(key);
            return drv;
        }
        char newVal = newValue.charValue();
        put((Reference2CharMap<K>) key, newVal);
        return newVal;
    }

    default char computeChar(K key, BiFunction<? super K, ? super Character, ? extends Character> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = getChar(key);
        char drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Character newValue = (Character) remappingFunction.apply(key, contained ? Character.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeChar(key);
            }
            return drv;
        }
        char newVal = newValue.charValue();
        put((Reference2CharMap<K>) key, newVal);
        return newVal;
    }

    default char merge(K key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        char newValue;
        Objects.requireNonNull(remappingFunction);
        char oldValue = getChar(key);
        char drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Character mergedValue = (Character) remappingFunction.apply(Character.valueOf(oldValue), Character.valueOf(value));
            if (mergedValue == null) {
                removeChar(key);
                return drv;
            }
            newValue = mergedValue.charValue();
        } else {
            newValue = value;
        }
        put((Reference2CharMap<K>) key, newValue);
        return newValue;
    }

    default char mergeChar(K key, char value, CharBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        char oldValue = getChar(key);
        char newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put((Reference2CharMap<K>) key, newValue);
        return newValue;
    }

    default char mergeChar(K key, char value, IntBinaryOperator remappingFunction) {
        return mergeChar((Reference2CharMap<K>) key, value, remappingFunction instanceof CharBinaryOperator ? (CharBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToChar(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default char mergeChar(K key, char value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        return merge((Reference2CharMap<K>) key, value, remappingFunction);
    }

    @Deprecated
    default Character putIfAbsent(K key, Character value) {
        return putIfAbsent((Reference2CharMap<K>) key, (K) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(K key, Character oldValue, Character newValue) {
        return replace((Reference2CharMap<K>) key, oldValue, newValue);
    }

    @Deprecated
    default Character replace(K key, Character value) {
        return replace((Reference2CharMap<K>) key, (K) value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.function.BiFunction<? super java.lang.Character, ? super java.lang.Character, ? extends java.lang.Character> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    default Character merge(K key, Character value, BiFunction<? super Character, ? super Character, ? extends Character> remappingFunction) {
        return merge((Reference2CharMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2CharMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2CharMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Character> {
        char getCharValue();

        char setValue(char c);

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
