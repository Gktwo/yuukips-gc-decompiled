package p014it.unimi.dsi.fastutil.objects;

import java.util.function.ToDoubleFunction;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.bytes.Byte2FloatFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2FloatFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2FloatFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ByteFunction;
import p014it.unimi.dsi.fastutil.floats.Float2CharFunction;
import p014it.unimi.dsi.fastutil.floats.Float2DoubleFunction;
import p014it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import p014it.unimi.dsi.fastutil.floats.Float2IntFunction;
import p014it.unimi.dsi.fastutil.floats.Float2LongFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ObjectFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ShortFunction;
import p014it.unimi.dsi.fastutil.ints.Int2FloatFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2FloatFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2FloatFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Reference2FloatFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2FloatFunction.class */
public interface Reference2FloatFunction<K> extends Function<K, Float>, ToDoubleFunction<K> {
    float getFloat(Object obj);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Float put(Object obj, Float f) {
        return put((Reference2FloatFunction<K>) obj, f);
    }

    @Override // java.util.function.ToDoubleFunction
    default double applyAsDouble(K operand) {
        return (double) getFloat(operand);
    }

    default float put(K key, float value) {
        throw new UnsupportedOperationException();
    }

    default float getOrDefault(Object key, float defaultValue) {
        float v = getFloat(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default float removeFloat(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Float put(K key, Float value) {
        boolean containsKey = containsKey(key);
        float v = put((Reference2FloatFunction<K>) key, value.floatValue());
        if (containsKey) {
            return Float.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float get(Object key) {
        float v = getFloat(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return Float.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Float getOrDefault(Object key, Float defaultValue) {
        float v = getFloat(key);
        return (v != defaultReturnValue() || containsKey(key)) ? Float.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Float remove(Object key) {
        if (containsKey(key)) {
            return Float.valueOf(removeFloat(key));
        }
        return null;
    }

    default void defaultReturnValue(float rv) {
        throw new UnsupportedOperationException();
    }

    default float defaultReturnValue() {
        return 0.0f;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super java.lang.Float, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<K, T> andThen(java.util.function.Function<? super Float, ? extends T> after) {
        return (java.util.function.Function<K, T>) andThen(after);
    }

    default Reference2ByteFunction<K> andThenByte(Float2ByteFunction after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default Byte2FloatFunction composeByte(Byte2ReferenceFunction<K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default Reference2ShortFunction<K> andThenShort(Float2ShortFunction after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default Short2FloatFunction composeShort(Short2ReferenceFunction<K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default Reference2IntFunction<K> andThenInt(Float2IntFunction after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default Int2FloatFunction composeInt(Int2ReferenceFunction<K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default Reference2LongFunction<K> andThenLong(Float2LongFunction after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default Long2FloatFunction composeLong(Long2ReferenceFunction<K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default Reference2CharFunction<K> andThenChar(Float2CharFunction after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default Char2FloatFunction composeChar(Char2ReferenceFunction<K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default Reference2FloatFunction<K> andThenFloat(Float2FloatFunction after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default Float2FloatFunction composeFloat(Float2ReferenceFunction<K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default Reference2DoubleFunction<K> andThenDouble(Float2DoubleFunction after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default Double2FloatFunction composeDouble(Double2ReferenceFunction<K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default <T> Reference2ObjectFunction<K, T> andThenObject(Float2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default <T> Object2FloatFunction<T> composeObject(Object2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }

    default <T> Reference2ReferenceFunction<K, T> andThenReference(Float2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(getFloat(after));
        };
    }

    default <T> Reference2FloatFunction<T> composeReference(Reference2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getFloat(before.get(before));
        };
    }
}
