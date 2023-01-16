package p014it.unimi.dsi.fastutil.objects;

import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ShortFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ShortFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ShortFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ShortFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2CharFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2DoubleFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2IntFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2LongFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ShortFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Object2ShortFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ShortFunction.class */
public interface Object2ShortFunction<K> extends Function<K, Short>, ToIntFunction<K> {
    short getShort(Object obj);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Short put(Object obj, Short sh) {
        return put((Object2ShortFunction<K>) obj, sh);
    }

    @Override // java.util.function.ToIntFunction
    default int applyAsInt(K operand) {
        return getShort(operand);
    }

    default short put(K key, short value) {
        throw new UnsupportedOperationException();
    }

    default short getOrDefault(Object key, short defaultValue) {
        short v = getShort(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default short removeShort(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Short put(K key, Short value) {
        boolean containsKey = containsKey(key);
        short v = put((Object2ShortFunction<K>) key, value.shortValue());
        if (containsKey) {
            return Short.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short get(Object key) {
        short v = getShort(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return Short.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Short getOrDefault(Object key, Short defaultValue) {
        short v = getShort(key);
        return (v != defaultReturnValue() || containsKey(key)) ? Short.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Short remove(Object key) {
        if (containsKey(key)) {
            return Short.valueOf(removeShort(key));
        }
        return null;
    }

    default void defaultReturnValue(short rv) {
        throw new UnsupportedOperationException();
    }

    default short defaultReturnValue() {
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super java.lang.Short, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<K, T> andThen(java.util.function.Function<? super Short, ? extends T> after) {
        return (java.util.function.Function<K, T>) andThen(after);
    }

    default Object2ByteFunction<K> andThenByte(Short2ByteFunction after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default Byte2ShortFunction composeByte(Byte2ObjectFunction<K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default Object2ShortFunction<K> andThenShort(Short2ShortFunction after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default Short2ShortFunction composeShort(Short2ObjectFunction<K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default Object2IntFunction<K> andThenInt(Short2IntFunction after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default Int2ShortFunction composeInt(Int2ObjectFunction<K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default Object2LongFunction<K> andThenLong(Short2LongFunction after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default Long2ShortFunction composeLong(Long2ObjectFunction<K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default Object2CharFunction<K> andThenChar(Short2CharFunction after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default Char2ShortFunction composeChar(Char2ObjectFunction<K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default Object2FloatFunction<K> andThenFloat(Short2FloatFunction after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default Float2ShortFunction composeFloat(Float2ObjectFunction<K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default Object2DoubleFunction<K> andThenDouble(Short2DoubleFunction after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default Double2ShortFunction composeDouble(Double2ObjectFunction<K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default <T> Object2ObjectFunction<K, T> andThenObject(Short2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default <T> Object2ShortFunction<T> composeObject(Object2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }

    default <T> Object2ReferenceFunction<K, T> andThenReference(Short2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(getShort(after));
        };
    }

    default <T> Reference2ShortFunction<T> composeReference(Reference2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return getShort(before.get(before));
        };
    }
}
