package p014it.unimi.dsi.fastutil.ints;

import java.util.function.IntUnaryOperator;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.chars.Char2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.ints.Int2IntFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/Int2IntFunction.class */
public interface Int2IntFunction extends Function<Integer, Integer>, IntUnaryOperator {
    int get(int i);

    @Override // java.util.function.IntUnaryOperator
    default int applyAsInt(int operand) {
        return get(operand);
    }

    default int put(int key, int value) {
        throw new UnsupportedOperationException();
    }

    default int getOrDefault(int key, int defaultValue) {
        int v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default int remove(int key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Integer put(Integer key, Integer value) {
        int k = key.intValue();
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
        int k = ((Integer) key).intValue();
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
        int k = ((Integer) key).intValue();
        int v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? Integer.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Integer remove(Object key) {
        if (key == null) {
            return null;
        }
        int k = ((Integer) key).intValue();
        if (containsKey(k)) {
            return Integer.valueOf(remove(k));
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.ints.Int2IntMap
    default boolean containsKey(int key) {
        return true;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        return containsKey(((Integer) key).intValue());
    }

    default void defaultReturnValue(int rv) {
        throw new UnsupportedOperationException();
    }

    default int defaultReturnValue() {
        return 0;
    }

    static Int2IntFunction identity() {
        return k -> {
            return k;
        };
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, Integer> compose(java.util.function.Function<? super T, ? extends Integer> before) {
        return (java.util.function.Function<T, Integer>) compose(before);
    }

    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<Integer, T> andThen(java.util.function.Function<? super Integer, ? extends T> after) {
        return (java.util.function.Function<Integer, T>) andThen(after);
    }

    default Int2ByteFunction andThenByte(Int2ByteFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Byte2IntFunction composeByte(Byte2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2ShortFunction andThenShort(Int2ShortFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Short2IntFunction composeShort(Short2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2IntFunction andThenInt(Int2IntFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Int2IntFunction composeInt(Int2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2LongFunction andThenLong(Int2LongFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Long2IntFunction composeLong(Long2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2CharFunction andThenChar(Int2CharFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Char2IntFunction composeChar(Char2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2FloatFunction andThenFloat(Int2FloatFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Float2IntFunction composeFloat(Float2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Int2DoubleFunction andThenDouble(Int2DoubleFunction after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default Double2IntFunction composeDouble(Double2IntFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Int2ObjectFunction<T> andThenObject(Int2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2IntFunction<T> composeObject(Object2IntFunction<? super T> before) {
        return k -> {
            return get(before.getInt(before));
        };
    }

    default <T> Int2ReferenceFunction<T> andThenReference(Int2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2IntFunction<T> composeReference(Reference2IntFunction<? super T> before) {
        return k -> {
            return get(before.getInt(before));
        };
    }
}
