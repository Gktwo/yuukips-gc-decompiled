package p014it.unimi.dsi.fastutil.objects;

import java.util.function.ToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2CharFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2DoubleFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2IntFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Reference2DoubleFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2DoubleFunction.class */
public interface Reference2DoubleFunction<K> extends Function<K, Double>, ToDoubleFunction<K> {
    double getDouble(Object obj);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Double put(Object obj, Double d) {
        return put((Reference2DoubleFunction<K>) obj, d);
    }

    @Override // java.util.function.ToDoubleFunction
    default double applyAsDouble(K operand) {
        return getDouble(operand);
    }

    default double put(K key, double value) {
        throw new UnsupportedOperationException();
    }

    default double getOrDefault(Object key, double defaultValue) {
        double v = getDouble(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default double removeDouble(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Double put(K key, Double value) {
        boolean containsKey = containsKey(key);
        double v = put((Reference2DoubleFunction<K>) key, value.doubleValue());
        if (containsKey) {
            return Double.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double get(Object key) {
        double v = getDouble(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return Double.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Double getOrDefault(Object key, Double defaultValue) {
        double v = getDouble(key);
        return (v != defaultReturnValue() || containsKey(key)) ? Double.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Double remove(Object key) {
        if (containsKey(key)) {
            return Double.valueOf(removeDouble(key));
        }
        return null;
    }

    default void defaultReturnValue(double rv) {
        throw new UnsupportedOperationException();
    }

    default double defaultReturnValue() {
        return 0.0d;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super java.lang.Double, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<K, T> andThen(java.util.function.Function<? super Double, ? extends T> after) {
        return (java.util.function.Function<K, T>) andThen(after);
    }

    default Reference2ByteFunction<K> andThenByte(Double2ByteFunction after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default Byte2DoubleFunction composeByte(Byte2ReferenceFunction<K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default Reference2ShortFunction<K> andThenShort(Double2ShortFunction after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default Short2DoubleFunction composeShort(Short2ReferenceFunction<K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default Reference2IntFunction<K> andThenInt(Double2IntFunction after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default Int2DoubleFunction composeInt(Int2ReferenceFunction<K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default Reference2LongFunction<K> andThenLong(Double2LongFunction after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default Long2DoubleFunction composeLong(Long2ReferenceFunction<K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default Reference2CharFunction<K> andThenChar(Double2CharFunction after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default Char2DoubleFunction composeChar(Char2ReferenceFunction<K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default Reference2FloatFunction<K> andThenFloat(Double2FloatFunction after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default Float2DoubleFunction composeFloat(Float2ReferenceFunction<K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default Reference2DoubleFunction<K> andThenDouble(Double2DoubleFunction after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default Double2DoubleFunction composeDouble(Double2ReferenceFunction<K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default <T> Reference2ObjectFunction<K, T> andThenObject(Double2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default <T> Object2DoubleFunction<T> composeObject(Object2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }

    default <T> Reference2ReferenceFunction<K, T> andThenReference(Double2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(getDouble(after));
        };
    }

    default <T> Reference2DoubleFunction<T> composeReference(Reference2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getDouble(before.get(before));
        };
    }
}
