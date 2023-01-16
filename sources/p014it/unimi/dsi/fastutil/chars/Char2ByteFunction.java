package p014it.unimi.dsi.fastutil.chars;

import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.Char2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ByteFunction.class */
public interface Char2ByteFunction extends Function<Character, Byte>, IntUnaryOperator {
    byte get(char c);

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int operand) {
        return get(SafeMath.safeIntToChar(operand));
    }

    default byte put(char key, byte value) {
        throw new UnsupportedOperationException();
    }

    default byte getOrDefault(char key, byte defaultValue) {
        byte v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default byte remove(char key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Byte put(Character key, Byte value) {
        char k = key.charValue();
        boolean containsKey = containsKey(k);
        byte v = put(k, value.byteValue());
        if (containsKey) {
            return Byte.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte get(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        byte v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Byte.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Byte getOrDefault(Object key, Byte defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        char k = ((Character) key).charValue();
        byte v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Byte.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        if (containsKey(k)) {
            return Byte.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ByteMap
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

    default void defaultReturnValue(byte rv) {
        throw new UnsupportedOperationException();
    }

    default byte defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Byte> compose(java.util.function.Function<? super T, ? extends Character> before) {
        return (java.util.function.Function<T, Byte>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Character, T> andThen(java.util.function.Function<? super Byte, ? extends T> after) {
        return (java.util.function.Function<Character, T>) andThen(after);
    }

    default Char2ByteFunction andThenByte(Byte2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2ByteFunction composeByte(Byte2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2ShortFunction andThenShort(Byte2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2ByteFunction composeShort(Short2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2IntFunction andThenInt(Byte2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2ByteFunction composeInt(Int2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2LongFunction andThenLong(Byte2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2ByteFunction composeLong(Long2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2CharFunction andThenChar(Byte2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2ByteFunction composeChar(Char2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2FloatFunction andThenFloat(Byte2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2ByteFunction composeFloat(Float2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2DoubleFunction andThenDouble(Byte2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2ByteFunction composeDouble(Double2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Char2ObjectFunction<T> andThenObject(Byte2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ByteFunction<T> composeObject(Object2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }

    default <T> Char2ReferenceFunction<T> andThenReference(Byte2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ByteFunction<T> composeReference(Reference2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }
}
