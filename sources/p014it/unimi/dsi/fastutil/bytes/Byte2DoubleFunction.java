package p014it.unimi.dsi.fastutil.bytes;

import java.util.function.IntToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
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
/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2DoubleFunction.class */
public interface Byte2DoubleFunction extends Function<Byte, Double>, IntToDoubleFunction {
    double get(byte b);

    @Override // java.util.function.IntToDoubleFunction
    @Deprecated
    default double applyAsDouble(int operand) {
        return get(SafeMath.safeIntToByte(operand));
    }

    default double put(byte key, double value) {
        throw new UnsupportedOperationException();
    }

    default double getOrDefault(byte key, double defaultValue) {
        double v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default double remove(byte key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Double put(Byte key, Double value) {
        byte k = key.byteValue();
        boolean containsKey = containsKey(k);
        double v = put(k, value.doubleValue());
        if (containsKey) {
            return Double.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double get(Object key) {
        if (key == null) {
            return null;
        }
        byte k = ((Byte) key).byteValue();
        double v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Double.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Double getOrDefault(Object key, Double defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        byte k = ((Byte) key).byteValue();
        double v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Double.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        if (key == null) {
            return null;
        }
        byte k = ((Byte) key).byteValue();
        if (containsKey(k)) {
            return Double.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2DoubleMap
    default boolean containsKey(byte key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Byte) key).byteValue());
    }

    default void defaultReturnValue(double rv) {
        throw new UnsupportedOperationException();
    }

    default double defaultReturnValue() {
        return 0.0d;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Double> compose(java.util.function.Function<? super T, ? extends Byte> before) {
        return (java.util.function.Function<T, Double>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Byte, T> andThen(java.util.function.Function<? super Double, ? extends T> after) {
        return (java.util.function.Function<Byte, T>) andThen(after);
    }

    default Byte2ByteFunction andThenByte(Double2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2DoubleFunction composeByte(Byte2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2ShortFunction andThenShort(Double2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2DoubleFunction composeShort(Short2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2IntFunction andThenInt(Double2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2DoubleFunction composeInt(Int2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2LongFunction andThenLong(Double2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2DoubleFunction composeLong(Long2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2CharFunction andThenChar(Double2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2DoubleFunction composeChar(Char2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2FloatFunction andThenFloat(Double2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2DoubleFunction composeFloat(Float2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2DoubleFunction andThenDouble(Double2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2DoubleFunction composeDouble(Double2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Byte2ObjectFunction<T> andThenObject(Double2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2DoubleFunction<T> composeObject(Object2ByteFunction<? super T> before) {
        return k -> {
            return get(before.getByte(before));
        };
    }

    default <T> Byte2ReferenceFunction<T> andThenReference(Double2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2DoubleFunction<T> composeReference(Reference2ByteFunction<? super T> before) {
        return k -> {
            return get(before.getByte(before));
        };
    }
}
