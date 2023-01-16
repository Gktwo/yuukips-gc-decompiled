package p014it.unimi.dsi.fastutil.bytes;

import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.bytes.Byte2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/bytes/Byte2ByteFunction.class */
public interface Byte2ByteFunction extends Function<Byte, Byte>, IntUnaryOperator {
    byte get(byte b);

    @Override // java.util.function.IntUnaryOperator
    @Deprecated
    default int applyAsInt(int operand) {
        return get(SafeMath.safeIntToByte(operand));
    }

    default byte put(byte key, byte value) {
        throw new UnsupportedOperationException();
    }

    default byte getOrDefault(byte key, byte defaultValue) {
        byte v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default byte remove(byte key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Byte put(Byte key, Byte value) {
        byte k = key.byteValue();
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
        byte k = ((Byte) key).byteValue();
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
        byte k = ((Byte) key).byteValue();
        byte v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Byte.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        if (key == null) {
            return null;
        }
        byte k = ((Byte) key).byteValue();
        if (containsKey(k)) {
            return Byte.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.bytes.Byte2ByteMap
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

    default void defaultReturnValue(byte rv) {
        throw new UnsupportedOperationException();
    }

    default byte defaultReturnValue() {
        return 0;
    }

    static Byte2ByteFunction identity() {
        return k -> {
            return k;
        };
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Byte> compose(java.util.function.Function<? super T, ? extends Byte> before) {
        return (java.util.function.Function<T, Byte>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Byte, T> andThen(java.util.function.Function<? super Byte, ? extends T> after) {
        return (java.util.function.Function<Byte, T>) andThen(after);
    }

    default Byte2ByteFunction andThenByte(Byte2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2ByteFunction composeByte(Byte2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2ShortFunction andThenShort(Byte2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2ByteFunction composeShort(Short2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2IntFunction andThenInt(Byte2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2ByteFunction composeInt(Int2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2LongFunction andThenLong(Byte2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2ByteFunction composeLong(Long2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2CharFunction andThenChar(Byte2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2ByteFunction composeChar(Char2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2FloatFunction andThenFloat(Byte2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2ByteFunction composeFloat(Float2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Byte2DoubleFunction andThenDouble(Byte2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2ByteFunction composeDouble(Double2ByteFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Byte2ObjectFunction<T> andThenObject(Byte2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ByteFunction<T> composeObject(Object2ByteFunction<? super T> before) {
        return k -> {
            return get(before.getByte(before));
        };
    }

    default <T> Byte2ReferenceFunction<T> andThenReference(Byte2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ByteFunction<T> composeReference(Reference2ByteFunction<? super T> before) {
        return k -> {
            return get(before.getByte(before));
        };
    }
}
