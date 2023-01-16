package p014it.unimi.dsi.fastutil.longs;

import java.util.function.LongToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2CharFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2IntFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.Long2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2IntFunction.class */
public interface Long2IntFunction extends Function<Long, Integer>, LongToIntFunction {
    int get(long j);

    @Override // java.util.function.LongToIntFunction
    default int applyAsInt(long operand) {
        return get(operand);
    }

    default int put(long key, int value) {
        throw new UnsupportedOperationException();
    }

    default int getOrDefault(long key, int defaultValue) {
        int v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default int remove(long key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Integer put(Long key, Integer value) {
        long k = key.longValue();
        boolean containsKey = containsKey(k);
        int v = put(k, value.intValue());
        if (containsKey) {
            return Integer.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer get(Object key) {
        if (key == null) {
            return null;
        }
        long k = ((Long) key).longValue();
        int v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return Integer.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Integer getOrDefault(Object key, Integer defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        long k = ((Long) key).longValue();
        int v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Integer.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        if (key == null) {
            return null;
        }
        long k = ((Long) key).longValue();
        if (containsKey(k)) {
            return Integer.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2IntMap
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

    default void defaultReturnValue(int rv) {
        throw new UnsupportedOperationException();
    }

    default int defaultReturnValue() {
        return 0;
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Integer> compose(java.util.function.Function<? super T, ? extends Long> before) {
        return (java.util.function.Function<T, Integer>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Long, T> andThen(java.util.function.Function<? super Integer, ? extends T> after) {
        return (java.util.function.Function<Long, T>) andThen(after);
    }

    default Long2ByteFunction andThenByte(Int2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2IntFunction composeByte(Byte2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2ShortFunction andThenShort(Int2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2IntFunction composeShort(Short2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2IntFunction andThenInt(Int2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2IntFunction composeInt(Int2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2LongFunction andThenLong(Int2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2IntFunction composeLong(Long2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2CharFunction andThenChar(Int2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2IntFunction composeChar(Char2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2FloatFunction andThenFloat(Int2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2IntFunction composeFloat(Float2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2DoubleFunction andThenDouble(Int2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2IntFunction composeDouble(Double2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Long2ObjectFunction<T> andThenObject(Int2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2IntFunction<T> composeObject(Object2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }

    default <T> Long2ReferenceFunction<T> andThenReference(Int2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2IntFunction<T> composeReference(Reference2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }
}
