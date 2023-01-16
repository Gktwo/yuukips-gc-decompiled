package p014it.unimi.dsi.fastutil.objects;

import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2CharFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Object2CharFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2CharFunction.class */
public interface Object2CharFunction<K> extends Function<K, Character>, ToIntFunction<K> {
    char getChar(Object obj);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Character put(Object obj, Character ch) {
        return put((Object2CharFunction<K>) obj, ch);
    }

    @Override // java.util.function.ToIntFunction
    default int applyAsInt(K operand) {
        return getChar(operand);
    }

    default char put(K key, char value) {
        throw new UnsupportedOperationException();
    }

    default char getOrDefault(Object key, char defaultValue) {
        char v = getChar(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default char removeChar(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Character put(K key, Character value) {
        boolean containsKey = containsKey(key);
        char v = put((Object2CharFunction<K>) key, value.charValue());
        if (containsKey) {
            return Character.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character get(Object key) {
        char v = getChar(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return Character.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Character getOrDefault(Object key, Character defaultValue) {
        char v = getChar(key);
        return (v != defaultReturnValue() || containsKey(key)) ? Character.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Character remove(Object key) {
        if (containsKey(key)) {
            return Character.valueOf(removeChar(key));
        }
        return null;
    }

    default void defaultReturnValue(char rv) {
        throw new UnsupportedOperationException();
    }

    default char defaultReturnValue() {
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super java.lang.Character, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<K, T> andThen(java.util.function.Function<? super Character, ? extends T> after) {
        return (java.util.function.Function<K, T>) andThen(after);
    }

    default Object2ByteFunction<K> andThenByte(Char2ByteFunction after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default Byte2CharFunction composeByte(Byte2ObjectFunction<K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default Object2ShortFunction<K> andThenShort(Char2ShortFunction after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default Short2CharFunction composeShort(Short2ObjectFunction<K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default Object2IntFunction<K> andThenInt(Char2IntFunction after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default Int2CharFunction composeInt(Int2ObjectFunction<K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default Object2LongFunction<K> andThenLong(Char2LongFunction after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default Long2CharFunction composeLong(Long2ObjectFunction<K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default Object2CharFunction<K> andThenChar(Char2CharFunction after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default Char2CharFunction composeChar(Char2ObjectFunction<K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default Object2FloatFunction<K> andThenFloat(Char2FloatFunction after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default Float2CharFunction composeFloat(Float2ObjectFunction<K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default Object2DoubleFunction<K> andThenDouble(Char2DoubleFunction after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default Double2CharFunction composeDouble(Double2ObjectFunction<K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default <T> Object2ObjectFunction<K, T> andThenObject(Char2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default <T> Object2CharFunction<T> composeObject(Object2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }

    default <T> Object2ReferenceFunction<K, T> andThenReference(Char2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(getChar(after));
        };
    }

    default <T> Reference2CharFunction<T> composeReference(Reference2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return getChar(before.get(before));
        };
    }
}
