package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Object2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ObjectFunction.class */
public interface Object2ObjectFunction<K, V> extends Function<K, V> {
    @Override // p014it.unimi.dsi.fastutil.Function
    V get(Object obj);

    @Override // p014it.unimi.dsi.fastutil.Function
    default V put(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    default V getOrDefault(Object key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    default V remove(Object key) {
        throw new UnsupportedOperationException();
    }

    default void defaultReturnValue(V rv) {
        throw new UnsupportedOperationException();
    }

    default V defaultReturnValue() {
        return null;
    }

    default Object2ByteFunction<K> andThenByte(Object2ByteFunction<V> after) {
        return k -> {
            return after.getByte(get(after));
        };
    }

    default Byte2ObjectFunction<V> composeByte(Byte2ObjectFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Object2ShortFunction<K> andThenShort(Object2ShortFunction<V> after) {
        return k -> {
            return after.getShort(get(after));
        };
    }

    default Short2ObjectFunction<V> composeShort(Short2ObjectFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Object2IntFunction<K> andThenInt(Object2IntFunction<V> after) {
        return k -> {
            return after.getInt(get(after));
        };
    }

    default Int2ObjectFunction<V> composeInt(Int2ObjectFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Object2LongFunction<K> andThenLong(Object2LongFunction<V> after) {
        return k -> {
            return after.getLong(get(after));
        };
    }

    default Long2ObjectFunction<V> composeLong(Long2ObjectFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Object2CharFunction<K> andThenChar(Object2CharFunction<V> after) {
        return k -> {
            return after.getChar(get(after));
        };
    }

    default Char2ObjectFunction<V> composeChar(Char2ObjectFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Object2FloatFunction<K> andThenFloat(Object2FloatFunction<V> after) {
        return k -> {
            return after.getFloat(get(after));
        };
    }

    default Float2ObjectFunction<V> composeFloat(Float2ObjectFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Object2DoubleFunction<K> andThenDouble(Object2DoubleFunction<V> after) {
        return k -> {
            return after.getDouble(get(after));
        };
    }

    default Double2ObjectFunction<V> composeDouble(Double2ObjectFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Object2ObjectFunction<K, T> andThenObject(Object2ObjectFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ObjectFunction<T, V> composeObject(Object2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Object2ReferenceFunction<K, T> andThenReference(Object2ReferenceFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ObjectFunction<T, V> composeReference(Reference2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return get(before.get(before));
        };
    }
}
