package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoubleToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ByteFunction.class */
public interface Double2ByteFunction extends Function<Double, Byte>, DoubleToIntFunction {
    byte get(double d);

    @Override // java.util.function.DoubleToIntFunction
    default int applyAsInt(double operand) {
        return get(operand);
    }

    default byte put(double key, byte value) {
        throw new UnsupportedOperationException();
    }

    default byte getOrDefault(double key, byte defaultValue) {
        byte v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default byte remove(double key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Byte put(Double key, Byte value) {
        double k = key.doubleValue();
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
        double k = ((Double) key).doubleValue();
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
        double k = ((Double) key).doubleValue();
        byte v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Byte.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        if (containsKey(k)) {
            return Byte.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ByteMap
    default boolean containsKey(double key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Double) key).doubleValue());
    }

    default void defaultReturnValue(byte rv) {
        throw new UnsupportedOperationException();
    }

    default byte defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Byte> compose(java.util.function.Function<? super T, ? extends Double> before) {
        return (java.util.function.Function<T, Byte>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Double, T> andThen(java.util.function.Function<? super Byte, ? extends T> after) {
        return (java.util.function.Function<Double, T>) andThen(after);
    }

    default Double2ByteFunction andThenByte(Byte2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2ByteFunction composeByte(Byte2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2ShortFunction andThenShort(Byte2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2ByteFunction composeShort(Short2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2IntFunction andThenInt(Byte2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2ByteFunction composeInt(Int2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2LongFunction andThenLong(Byte2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2ByteFunction composeLong(Long2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2CharFunction andThenChar(Byte2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2ByteFunction composeChar(Char2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2FloatFunction andThenFloat(Byte2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2ByteFunction composeFloat(Float2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2DoubleFunction andThenDouble(Byte2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2ByteFunction composeDouble(Double2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Double2ObjectFunction<T> andThenObject(Byte2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ByteFunction<T> composeObject(Object2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }

    default <T> Double2ReferenceFunction<T> andThenReference(Byte2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ByteFunction<T> composeReference(Reference2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }
}
