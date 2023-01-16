package p014it.unimi.dsi.fastutil.chars;

import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.chars.Char2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/Char2ShortFunction.class */
public interface Char2ShortFunction extends Function<Character, Short>, IntUnaryOperator {
    short get(char c);

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int operand) {
        return get(SafeMath.safeIntToChar(operand));
    }

    default short put(char key, short value) {
        throw new UnsupportedOperationException();
    }

    default short getOrDefault(char key, short defaultValue) {
        short v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default short remove(char key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Short put(Character key, Short value) {
        char k = key.charValue();
        boolean containsKey = containsKey(k);
        short v = put(k, value.shortValue());
        if (containsKey) {
            return Short.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        short v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Short.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        char k = ((Character) key).charValue();
        short v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Short.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        if (key == null) {
            return null;
        }
        char k = ((Character) key).charValue();
        if (containsKey(k)) {
            return Short.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.chars.Char2ShortMap
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

    default void defaultReturnValue(short rv) {
        throw new UnsupportedOperationException();
    }

    default short defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Short> compose(java.util.function.Function<? super T, ? extends Character> before) {
        return (java.util.function.Function<T, Short>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Character, T> andThen(java.util.function.Function<? super Short, ? extends T> after) {
        return (java.util.function.Function<Character, T>) andThen(after);
    }

    default Char2ByteFunction andThenByte(Short2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2ShortFunction composeByte(Byte2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2ShortFunction andThenShort(Short2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2ShortFunction composeShort(Short2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2IntFunction andThenInt(Short2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2ShortFunction composeInt(Int2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2LongFunction andThenLong(Short2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2ShortFunction composeLong(Long2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2CharFunction andThenChar(Short2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2ShortFunction composeChar(Char2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2FloatFunction andThenFloat(Short2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2ShortFunction composeFloat(Float2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Char2DoubleFunction andThenDouble(Short2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2ShortFunction composeDouble(Double2CharFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Char2ObjectFunction<T> andThenObject(Short2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ShortFunction<T> composeObject(Object2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }

    default <T> Char2ReferenceFunction<T> andThenReference(Short2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ShortFunction<T> composeReference(Reference2CharFunction<? super T> before) {
        return k -> {
            return get(before.getChar(before));
        };
    }
}
