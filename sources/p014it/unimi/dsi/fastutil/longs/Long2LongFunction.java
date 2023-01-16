package p014it.unimi.dsi.fastutil.longs;

import java.util.function.LongUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.Long2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2LongFunction.class */
public interface Long2LongFunction extends Function<Long, Long>, LongUnaryOperator {
    long get(long j);

    @Override // java.util.function.LongUnaryOperator
    default long applyAsLong(long operand) {
        return get(operand);
    }

    default long put(long key, long value) {
        throw new UnsupportedOperationException();
    }

    default long getOrDefault(long key, long defaultValue) {
        long v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default long remove(long key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Long put(Long key, Long value) {
        long k = key.longValue();
        boolean containsKey = containsKey(k);
        long v = put(k, value.longValue());
        if (containsKey) {
            return Long.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long get(Object key) {
        if (key == null) {
            return null;
        }
        long k = ((Long) key).longValue();
        long v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Long.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Long getOrDefault(Object key, Long defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        long k = ((Long) key).longValue();
        long v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Long.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        if (key == null) {
            return null;
        }
        long k = ((Long) key).longValue();
        if (containsKey(k)) {
            return Long.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2LongMap
    default boolean containsKey(long key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Long) key).longValue());
    }

    default void defaultReturnValue(long rv) {
        throw new UnsupportedOperationException();
    }

    default long defaultReturnValue() {
        return 0;
    }

    static Long2LongFunction identity() {
        return k -> {
            return k;
        };
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Long> compose(java.util.function.Function<? super T, ? extends Long> before) {
        return (java.util.function.Function<T, Long>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Long, T> andThen(java.util.function.Function<? super Long, ? extends T> after) {
        return (java.util.function.Function<Long, T>) andThen(after);
    }

    default Long2ByteFunction andThenByte(Long2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2LongFunction composeByte(Byte2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2ShortFunction andThenShort(Long2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2LongFunction composeShort(Short2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2IntFunction andThenInt(Long2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2LongFunction composeInt(Int2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2LongFunction andThenLong(Long2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2LongFunction composeLong(Long2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2CharFunction andThenChar(Long2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2LongFunction composeChar(Char2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2FloatFunction andThenFloat(Long2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2LongFunction composeFloat(Float2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2DoubleFunction andThenDouble(Long2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2LongFunction composeDouble(Double2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Long2ObjectFunction<T> andThenObject(Long2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2LongFunction<T> composeObject(Object2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }

    default <T> Long2ReferenceFunction<T> andThenReference(Long2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2LongFunction<T> composeReference(Reference2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }
}
