package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ReferenceFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ReferenceFunction.class */
public interface Reference2ReferenceFunction<K, V> extends Function<K, V> {
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

    default Reference2ByteFunction<K> andThenByte(Reference2ByteFunction<V> after) {
        return k -> {
            return after.getByte(get(after));
        };
    }

    default Byte2ReferenceFunction<V> composeByte(Byte2ReferenceFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Reference2ShortFunction<K> andThenShort(Reference2ShortFunction<V> after) {
        return k -> {
            return after.getShort(get(after));
        };
    }

    default Short2ReferenceFunction<V> composeShort(Short2ReferenceFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Reference2IntFunction<K> andThenInt(Reference2IntFunction<V> after) {
        return k -> {
            return after.getInt(get(after));
        };
    }

    default Int2ReferenceFunction<V> composeInt(Int2ReferenceFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Reference2LongFunction<K> andThenLong(Reference2LongFunction<V> after) {
        return k -> {
            return after.getLong(get(after));
        };
    }

    default Long2ReferenceFunction<V> composeLong(Long2ReferenceFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Reference2CharFunction<K> andThenChar(Reference2CharFunction<V> after) {
        return k -> {
            return after.getChar(get(after));
        };
    }

    default Char2ReferenceFunction<V> composeChar(Char2ReferenceFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Reference2FloatFunction<K> andThenFloat(Reference2FloatFunction<V> after) {
        return k -> {
            return after.getFloat(get(after));
        };
    }

    default Float2ReferenceFunction<V> composeFloat(Float2ReferenceFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Reference2DoubleFunction<K> andThenDouble(Reference2DoubleFunction<V> after) {
        return k -> {
            return after.getDouble(get(after));
        };
    }

    default Double2ReferenceFunction<V> composeDouble(Double2ReferenceFunction<K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Reference2ObjectFunction<K, T> andThenObject(Reference2ObjectFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ReferenceFunction<T, V> composeObject(Object2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Reference2ReferenceFunction<K, T> andThenReference(Reference2ReferenceFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ReferenceFunction<T, V> composeReference(Reference2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return get(before.get(before));
        };
    }
}
