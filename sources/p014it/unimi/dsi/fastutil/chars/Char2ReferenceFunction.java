package p014it.unimi.dsi.fastutil.chars;

import java.util.function.IntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.Char2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ReferenceFunction.class */
public interface Char2ReferenceFunction<V> extends Function<Character, V>, IntFunction<V> {
    V get(char c);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Object put(Character ch, Object obj) {
        return put(ch, (Character) obj);
    }

    @Override // java.util.function.IntFunction
    @Deprecated
    default V apply(int operand) {
        return get(SafeMath.safeIntToChar(operand));
    }

    default V put(char key, V value) {
        throw new UnsupportedOperationException();
    }

    default V getOrDefault(char key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default V remove(char key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default V put(Character key, V value) {
        char k = key.charValue();
        boolean containsKey = containsKey(k);
        V v = put(k, (char) value);
        if (containsKey) {
            return v;
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V get(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        V v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return v;
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V getOrDefault(Object key, V defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        char k = ((Character) key).charValue();
        V v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V remove(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        if (containsKey(k)) {
            return remove(k);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ReferenceMap
    default boolean containsKey(char key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Character) key).charValue());
    }

    default void defaultReturnValue(V rv) {
        throw new UnsupportedOperationException();
    }

    default V defaultReturnValue() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super T, ? extends java.lang.Character> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.function.Function<V, V>, java.util.function.Function<T, V> */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, V> compose(java.util.function.Function<? super T, ? extends Character> before) {
        return (java.util.function.Function<V, V>) compose(before);
    }

    default Char2ByteFunction andThenByte(Reference2ByteFunction<V> after) {
        return k -> {
            return after.getByte(get(after));
        };
    }

    default Byte2ReferenceFunction<V> composeByte(Byte2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2ShortFunction andThenShort(Reference2ShortFunction<V> after) {
        return k -> {
            return after.getShort(get(after));
        };
    }

    default Short2ReferenceFunction<V> composeShort(Short2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2IntFunction andThenInt(Reference2IntFunction<V> after) {
        return k -> {
            return after.getInt(get(after));
        };
    }

    default Int2ReferenceFunction<V> composeInt(Int2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2LongFunction andThenLong(Reference2LongFunction<V> after) {
        return k -> {
            return after.getLong(get(after));
        };
    }

    default Long2ReferenceFunction<V> composeLong(Long2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2CharFunction andThenChar(Reference2CharFunction<V> after) {
        return k -> {
            return after.getChar(get(after));
        };
    }

    default Char2ReferenceFunction<V> composeChar(Char2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2FloatFunction andThenFloat(Reference2FloatFunction<V> after) {
        return k -> {
            return after.getFloat(get(after));
        };
    }

    default Float2ReferenceFunction<V> composeFloat(Float2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2DoubleFunction andThenDouble(Reference2DoubleFunction<V> after) {
        return k -> {
            return after.getDouble(get(after));
        };
    }

    default Double2ReferenceFunction<V> composeDouble(Double2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Char2ObjectFunction<T> andThenObject(Reference2ObjectFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ReferenceFunction<T, V> composeObject(Object2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }

    default <T> Char2ReferenceFunction<T> andThenReference(Reference2ReferenceFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ReferenceFunction<T, V> composeReference(Reference2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }
}
