package p014it.unimi.dsi.fastutil.longs;

import java.util.function.LongFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2LongFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2LongFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2LongFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ByteFunction;
import p014it.unimi.dsi.fastutil.objects.Object2CharFunction;
import p014it.unimi.dsi.fastutil.objects.Object2DoubleFunction;
import p014it.unimi.dsi.fastutil.objects.Object2FloatFunction;
import p014it.unimi.dsi.fastutil.objects.Object2IntFunction;
import p014it.unimi.dsi.fastutil.objects.Object2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ObjectFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ReferenceFunction;
import p014it.unimi.dsi.fastutil.objects.Object2ShortFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2LongFunction;
import p014it.unimi.dsi.fastutil.objects.Reference2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.longs.Long2ObjectFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/Long2ObjectFunction.class */
public interface Long2ObjectFunction<V> extends Function<Long, V>, LongFunction<V> {
    V get(long j);

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Object put(Long l, Object obj) {
        return put(l, (Long) obj);
    }

    @Override // java.util.function.LongFunction
    default V apply(long operand) {
        return get(operand);
    }

    default V put(long key, V value) {
        throw new UnsupportedOperationException();
    }

    default V getOrDefault(long key, V defaultValue) {
        V v = get(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default V remove(long key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default V put(Long key, V value) {
        long k = key.longValue();
        boolean containsKey = containsKey(k);
        V v = put(k, (long) value);
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
        long k = ((Long) key).longValue();
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
        long k = ((Long) key).longValue();
        V v = get(k);
        return (v != defaultReturnValue() || containsKey(k)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default V remove(Object key) {
        if (key == null) {
            return null;
        }
        long k = ((Long) key).longValue();
        if (containsKey(k)) {
            return remove(k);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.longs.Long2ObjectMap
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

    default void defaultReturnValue(V rv) {
        throw new UnsupportedOperationException();
    }

    default V defaultReturnValue() {
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super T, ? extends java.lang.Long> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.function.Function<V, V>, java.util.function.Function<T, V> */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<T, V> compose(java.util.function.Function<? super T, ? extends Long> before) {
        return (java.util.function.Function<V, V>) compose(before);
    }

    default Long2ByteFunction andThenByte(Object2ByteFunction<V> after) {
        return k -> {
            return after.getByte(get(after));
        };
    }

    default Byte2ObjectFunction<V> composeByte(Byte2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2ShortFunction andThenShort(Object2ShortFunction<V> after) {
        return k -> {
            return after.getShort(get(after));
        };
    }

    default Short2ObjectFunction<V> composeShort(Short2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2IntFunction andThenInt(Object2IntFunction<V> after) {
        return k -> {
            return after.getInt(get(after));
        };
    }

    default Int2ObjectFunction<V> composeInt(Int2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2LongFunction andThenLong(Object2LongFunction<V> after) {
        return k -> {
            return after.getLong(get(after));
        };
    }

    default Long2ObjectFunction<V> composeLong(Long2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2CharFunction andThenChar(Object2CharFunction<V> after) {
        return k -> {
            return after.getChar(get(after));
        };
    }

    default Char2ObjectFunction<V> composeChar(Char2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2FloatFunction andThenFloat(Object2FloatFunction<V> after) {
        return k -> {
            return after.getFloat(get(after));
        };
    }

    default Float2ObjectFunction<V> composeFloat(Float2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default Long2DoubleFunction andThenDouble(Object2DoubleFunction<V> after) {
        return k -> {
            return after.getDouble(get(after));
        };
    }

    default Double2ObjectFunction<V> composeDouble(Double2LongFunction before) {
        return k -> {
            return get(before.get(before));
        };
    }

    default <T> Long2ObjectFunction<T> andThenObject(Object2ObjectFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Object2ObjectFunction<T, V> composeObject(Object2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }

    default <T> Long2ReferenceFunction<T> andThenReference(Object2ReferenceFunction<? super V, ? extends T> after) {
        return k -> {
            return after.get(get(after));
        };
    }

    default <T> Reference2ObjectFunction<T, V> composeReference(Reference2LongFunction<? super T> before) {
        return k -> {
            return get(before.getLong(before));
        };
    }
}
