package p014it.unimi.dsi.fastutil.objects;

import java.util.function.ToLongFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2CharFunction;
import p014it.unimi.dsi.fastutil.longs.Long2DoubleFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2IntFunction;
import p014it.unimi.dsi.fastutil.longs.Long2LongFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Reference2LongFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2LongFunction.class */
public interface Reference2LongFunction<K> extends Function<K, Long>, ToLongFunction<K> {
    long getLong(Object obj);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Long put(Object obj, Long l) {
        return put((Reference2LongFunction<K>) obj, l);
    }

    @Override // java.util.function.ToLongFunction
    default long applyAsLong(K operand) {
        return getLong(operand);
    }

    default long put(K key, long value) {
        throw new UnsupportedOperationException();
    }

    default long getOrDefault(Object key, long defaultValue) {
        long v = getLong(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default long removeLong(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Long put(K key, Long value) {
        boolean containsKey = containsKey(key);
        long v = put((Reference2LongFunction<K>) key, value.longValue());
        if (containsKey) {
            return Long.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long get(Object key) {
        long v = getLong(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return Long.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Long getOrDefault(Object key, Long defaultValue) {
        long v = getLong(key);
        return (v != defaultReturnValue() || containsKey(key)) ? Long.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Long remove(Object key) {
        if (containsKey(key)) {
            return Long.valueOf(removeLong(key));
        }
        return null;
    }

    default void defaultReturnValue(long rv) {
        throw new UnsupportedOperationException();
    }

    default long defaultReturnValue() {
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super java.lang.Long, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<K, T> andThen(java.util.function.Function<? super Long, ? extends T> after) {
        return (java.util.function.Function<K, T>) andThen(after);
    }

    default Reference2ByteFunction<K> andThenByte(Long2ByteFunction after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default Byte2LongFunction composeByte(Byte2ReferenceFunction<K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default Reference2ShortFunction<K> andThenShort(Long2ShortFunction after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default Short2LongFunction composeShort(Short2ReferenceFunction<K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default Reference2IntFunction<K> andThenInt(Long2IntFunction after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default Int2LongFunction composeInt(Int2ReferenceFunction<K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default Reference2LongFunction<K> andThenLong(Long2LongFunction after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default Long2LongFunction composeLong(Long2ReferenceFunction<K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default Reference2CharFunction<K> andThenChar(Long2CharFunction after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default Char2LongFunction composeChar(Char2ReferenceFunction<K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default Reference2FloatFunction<K> andThenFloat(Long2FloatFunction after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default Float2LongFunction composeFloat(Float2ReferenceFunction<K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default Reference2DoubleFunction<K> andThenDouble(Long2DoubleFunction after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default Double2LongFunction composeDouble(Double2ReferenceFunction<K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default <T> Reference2ObjectFunction<K, T> andThenObject(Long2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default <T> Object2LongFunction<T> composeObject(Object2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }

    default <T> Reference2ReferenceFunction<K, T> andThenReference(Long2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(getLong(after));
        };
    }

    default <T> Reference2LongFunction<T> composeReference(Reference2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getLong(before.get(before));
        };
    }
}
