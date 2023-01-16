package p014it.unimi.dsi.fastutil.shorts;

import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.shorts.Short2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/Short2ShortFunction.class */
public interface Short2ShortFunction extends Function<Short, Short>, IntUnaryOperator {
    short get(short s);

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int operand) {
        return get(SafeMath.safeIntToShort(operand));
    }

    default short put(short key, short value) {
        throw new UnsupportedOperationException();
    }

    default short getOrDefault(short key, short defaultValue) {
        short v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default short remove(short key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Short put(Short key, Short value) {
        short k = key.shortValue();
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
        short k = ((Short) key).shortValue();
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
        short k = ((Short) key).shortValue();
        short v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Short.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        if (key == null) {
            return null;
        }
        short k = ((Short) key).shortValue();
        if (containsKey(k)) {
            return Short.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.shorts.Short2ShortMap
    default boolean containsKey(short key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Short) key).shortValue());
    }

    default void defaultReturnValue(short rv) {
        throw new UnsupportedOperationException();
    }

    default short defaultReturnValue() {
        return 0;
    }

    static Short2ShortFunction identity() {
        return k -> {
            return k;
        };
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Short> compose(java.util.function.Function<? super T, ? extends Short> before) {
        return (java.util.function.Function<T, Short>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Short, T> andThen(java.util.function.Function<? super Short, ? extends T> after) {
        return (java.util.function.Function<Short, T>) andThen(after);
    }

    default Short2ByteFunction andThenByte(Short2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2ShortFunction composeByte(Byte2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2ShortFunction andThenShort(Short2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2ShortFunction composeShort(Short2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2IntFunction andThenInt(Short2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2ShortFunction composeInt(Int2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2LongFunction andThenLong(Short2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2ShortFunction composeLong(Long2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2CharFunction andThenChar(Short2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2ShortFunction composeChar(Char2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2FloatFunction andThenFloat(Short2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2ShortFunction composeFloat(Float2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Short2DoubleFunction andThenDouble(Short2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2ShortFunction composeDouble(Double2ShortFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Short2ObjectFunction<T> andThenObject(Short2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ShortFunction<T> composeObject(Object2ShortFunction<? super T> before) {
        return k -> {
            return get(before.getShort(before));
        };
    }

    default <T> Short2ReferenceFunction<T> andThenReference(Short2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ShortFunction<T> composeReference(Reference2ShortFunction<? super T> before) {
        return k -> {
            return get(before.getShort(before));
        };
    }
}
