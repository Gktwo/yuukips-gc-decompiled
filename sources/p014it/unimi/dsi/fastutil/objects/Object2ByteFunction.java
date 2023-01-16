package p014it.unimi.dsi.fastutil.objects;

import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2ByteFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2CharFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2DoubleFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2IntFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2LongFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ObjectFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ShortFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ByteFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ObjectFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ByteFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ByteFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ByteFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ByteFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ObjectFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Object2ByteFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Object2ByteFunction.class */
public interface Object2ByteFunction<K> extends Function<K, Byte>, ToIntFunction<K> {
    byte getByte(Object obj);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Byte put(Object obj, Byte b) {
        return put((Object2ByteFunction<K>) obj, b);
    }

    @Override // java.util.function.ToIntFunction
    default int applyAsInt(K operand) {
        return getByte(operand);
    }

    default byte put(K key, byte value) {
        throw new UnsupportedOperationException();
    }

    default byte getOrDefault(Object key, byte defaultValue) {
        byte v = getByte(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default byte removeByte(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Byte put(K key, Byte value) {
        boolean containsKey = containsKey(key);
        byte v = put((Object2ByteFunction<K>) key, value.byteValue());
        if (containsKey) {
            return Byte.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte get(Object key) {
        byte v = getByte(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return Byte.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Byte getOrDefault(Object key, Byte defaultValue) {
        byte v = getByte(key);
        return (v != defaultReturnValue() || containsKey(key)) ? Byte.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        if (containsKey(key)) {
            return Byte.valueOf(removeByte(key));
        }
        return null;
    }

    default void defaultReturnValue(byte rv) {
        throw new UnsupportedOperationException();
    }

    default byte defaultReturnValue() {
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super java.lang.Byte, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<K, T> andThen(java.util.function.Function<? super Byte, ? extends T> after) {
        return (java.util.function.Function<K, T>) andThen(after);
    }

    default Object2ByteFunction<K> andThenByte(Byte2ByteFunction after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default Byte2ByteFunction composeByte(Byte2ObjectFunction<K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default Object2ShortFunction<K> andThenShort(Byte2ShortFunction after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default Short2ByteFunction composeShort(Short2ObjectFunction<K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default Object2IntFunction<K> andThenInt(Byte2IntFunction after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default Int2ByteFunction composeInt(Int2ObjectFunction<K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default Object2LongFunction<K> andThenLong(Byte2LongFunction after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default Long2ByteFunction composeLong(Long2ObjectFunction<K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default Object2CharFunction<K> andThenChar(Byte2CharFunction after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default Char2ByteFunction composeChar(Char2ObjectFunction<K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default Object2FloatFunction<K> andThenFloat(Byte2FloatFunction after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default Float2ByteFunction composeFloat(Float2ObjectFunction<K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default Object2DoubleFunction<K> andThenDouble(Byte2DoubleFunction after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default Double2ByteFunction composeDouble(Double2ObjectFunction<K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default <T> Object2ObjectFunction<K, T> andThenObject(Byte2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default <T> Object2ByteFunction<T> composeObject(Object2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }

    default <T> Object2ReferenceFunction<K, T> andThenReference(Byte2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(getByte(after));
        };
    }

    default <T> Reference2ByteFunction<T> composeReference(Reference2ObjectFunction<? super T, ? extends K> before) {
        return k -> {
            return getByte(before.get(before));
        };
    }
}
