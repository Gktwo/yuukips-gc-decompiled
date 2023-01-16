package p014it.unimi.dsi.fastutil.doubles;

import java.util.function.DoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2DoubleFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2DoubleFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ShortFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/Double2ReferenceFunction.class */
public interface Double2ReferenceFunction<V> extends Function<Double, V>, DoubleFunction<V> {
    V get(double d);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Object put(Double d, Object obj) {
        return put(d, (Double) obj);
    }

    @Override // java.util.function.DoubleFunction
    default V apply(double operand) {
        return get(operand);
    }

    default V put(double key, V value) {
        throw new UnsupportedOperationException();
    }

    default V getOrDefault(double key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default V remove(double key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default V put(Double key, V value) {
        double k = key.doubleValue();
        boolean containsKey = containsKey(k);
        V v = put(k, (double) value);
        if (containsKey) {
            return v;
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V get(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        V v = get(k);
        if (v != defaultReturnValue() || containsKey(k)) {
            return v;
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V getOrDefault(Object key, V defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        double k = ((Double) key).doubleValue();
        V v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V remove(Object key) {
        if (key == null) {
            return null;
        }
        double k = ((Double) key).doubleValue();
        if (containsKey(k)) {
            return remove(k);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.doubles.Double2ReferenceMap
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

    default void defaultReturnValue(V rv) {
        throw new UnsupportedOperationException();
    }

    default V defaultReturnValue() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super T, ? extends java.lang.Double> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.function.Function<V, V>, java.util.function.Function<T, V> */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, V> compose(java.util.function.Function<? super T, ? extends Double> before) {
        return (java.util.function.Function<V, V>) compose(before);
    }

    default Double2ByteFunction andThenByte(Reference2ByteFunction<V> after) {
        return k -> {
            return after.getByte(get(after));
        };
    }

    default Byte2ReferenceFunction<V> composeByte(Byte2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2ShortFunction andThenShort(Reference2ShortFunction<V> after) {
        return k -> {
            return after.getShort(get(after));
        };
    }

    default Short2ReferenceFunction<V> composeShort(Short2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2IntFunction andThenInt(Reference2IntFunction<V> after) {
        return k -> {
            return after.getInt(get(after));
        };
    }

    default Int2ReferenceFunction<V> composeInt(Int2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2LongFunction andThenLong(Reference2LongFunction<V> after) {
        return k -> {
            return after.getLong(get(after));
        };
    }

    default Long2ReferenceFunction<V> composeLong(Long2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2CharFunction andThenChar(Reference2CharFunction<V> after) {
        return k -> {
            return after.getChar(get(after));
        };
    }

    default Char2ReferenceFunction<V> composeChar(Char2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2FloatFunction andThenFloat(Reference2FloatFunction<V> after) {
        return k -> {
            return after.getFloat(get(after));
        };
    }

    default Float2ReferenceFunction<V> composeFloat(Float2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Double2DoubleFunction andThenDouble(Reference2DoubleFunction<V> after) {
        return k -> {
            return after.getDouble(get(after));
        };
    }

    default Double2ReferenceFunction<V> composeDouble(Double2DoubleFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Double2ObjectFunction<T> andThenObject(Reference2ObjectFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ReferenceFunction<T, V> composeObject(Object2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }

    default <T> Double2ReferenceFunction<T> andThenReference(Reference2ReferenceFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ReferenceFunction<T, V> composeReference(Reference2DoubleFunction<? super T> before) {
        return k -> {
            return get(before.getDouble(before));
        };
    }
}
