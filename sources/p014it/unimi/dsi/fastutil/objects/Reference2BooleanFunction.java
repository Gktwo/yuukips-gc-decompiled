package p014it.unimi.dsi.fastutil.objects;

import java.util.function.Predicate;
import p014it.unimi.dsi.fastutil.Function;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ByteFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2CharFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2DoubleFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2FloatFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2IntFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2LongFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ObjectFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ReferenceFunction;
import p014it.unimi.dsi.fastutil.booleans.Boolean2ShortFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2BooleanFunction;
import p014it.unimi.dsi.fastutil.bytes.Byte2ReferenceFunction;
import p014it.unimi.dsi.fastutil.chars.Char2BooleanFunction;
import p014it.unimi.dsi.fastutil.chars.Char2ReferenceFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2BooleanFunction;
import p014it.unimi.dsi.fastutil.doubles.Double2ReferenceFunction;
import p014it.unimi.dsi.fastutil.floats.Float2BooleanFunction;
import p014it.unimi.dsi.fastutil.floats.Float2ReferenceFunction;
import p014it.unimi.dsi.fastutil.ints.Int2BooleanFunction;
import p014it.unimi.dsi.fastutil.ints.Int2ReferenceFunction;
import p014it.unimi.dsi.fastutil.longs.Long2BooleanFunction;
import p014it.unimi.dsi.fastutil.longs.Long2ReferenceFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2BooleanFunction;
import p014it.unimi.dsi.fastutil.shorts.Short2ReferenceFunction;

@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.objects.Reference2BooleanFunction */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2BooleanFunction.class */
public interface Reference2BooleanFunction<K> extends Function<K, Boolean>, Predicate<K> {
    boolean getBoolean(Object obj);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Boolean put(Object obj, Boolean bool) {
        return put((Reference2BooleanFunction<K>) obj, bool);
    }

    @Override // java.util.function.Predicate
    default boolean test(K operand) {
        return getBoolean(operand);
    }

    default boolean put(K key, boolean value) {
        throw new UnsupportedOperationException();
    }

    default boolean getOrDefault(Object key, boolean defaultValue) {
        boolean v = getBoolean(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    default boolean removeBoolean(Object key) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    default Boolean put(K key, Boolean value) {
        boolean containsKey = containsKey(key);
        boolean v = put((Reference2BooleanFunction<K>) key, value.booleanValue());
        if (containsKey) {
            return Boolean.valueOf(v);
        }
        return null;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean get(Object key) {
        boolean v = getBoolean(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return Boolean.valueOf(v);
        }
        return null;
    }

    @Deprecated
    default Boolean getOrDefault(Object key, Boolean defaultValue) {
        boolean v = getBoolean(key);
        return (v != defaultReturnValue() || containsKey(key)) ? Boolean.valueOf(v) : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Boolean remove(Object key) {
        if (containsKey(key)) {
            return Boolean.valueOf(removeBoolean(key));
        }
        return null;
    }

    default void defaultReturnValue(boolean rv) {
        throw new UnsupportedOperationException();
    }

    default boolean defaultReturnValue() {
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.function.Function<? super java.lang.Boolean, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.function.Function
    @Deprecated
    default <T> java.util.function.Function<K, T> andThen(java.util.function.Function<? super Boolean, ? extends T> after) {
        return (java.util.function.Function<K, T>) andThen(after);
    }

    default Reference2ByteFunction<K> andThenByte(Boolean2ByteFunction after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default Byte2BooleanFunction composeByte(Byte2ReferenceFunction<K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default Reference2ShortFunction<K> andThenShort(Boolean2ShortFunction after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default Short2BooleanFunction composeShort(Short2ReferenceFunction<K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default Reference2IntFunction<K> andThenInt(Boolean2IntFunction after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default Int2BooleanFunction composeInt(Int2ReferenceFunction<K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default Reference2LongFunction<K> andThenLong(Boolean2LongFunction after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default Long2BooleanFunction composeLong(Long2ReferenceFunction<K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default Reference2CharFunction<K> andThenChar(Boolean2CharFunction after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default Char2BooleanFunction composeChar(Char2ReferenceFunction<K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default Reference2FloatFunction<K> andThenFloat(Boolean2FloatFunction after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default Float2BooleanFunction composeFloat(Float2ReferenceFunction<K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default Reference2DoubleFunction<K> andThenDouble(Boolean2DoubleFunction after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default Double2BooleanFunction composeDouble(Double2ReferenceFunction<K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default <T> Reference2ObjectFunction<K, T> andThenObject(Boolean2ObjectFunction<? extends T> after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default <T> Object2BooleanFunction<T> composeObject(Object2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }

    default <T> Reference2ReferenceFunction<K, T> andThenReference(Boolean2ReferenceFunction<? extends T> after) {
        return k -> {
            return after.get(getBoolean(after));
        };
    }

    default <T> Reference2BooleanFunction<T> composeReference(Reference2ReferenceFunction<? super T, ? extends K> before) {
        return k -> {
            return getBoolean(before.get(before));
        };
    }
}
