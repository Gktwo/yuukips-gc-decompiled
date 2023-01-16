package p014it.unimi.dsi.fastutil.objects;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;
import p014it.unimi.dsi.fastutil.SafeMath;
import p014it.unimi.dsi.fastutil.bytes.ByteBinaryOperator;

/* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteMap */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteMap.class */
public interface Reference2ByteMap<K> extends Reference2ByteFunction<K>, Map<K, Byte> {
    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    int size();

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    void defaultReturnValue(byte b);

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    byte defaultReturnValue();

    ObjectSet<Entry<K>> reference2ByteEntrySet();

    @Override // java.util.Map
    ReferenceSet<K> keySet();

    /* Return type fixed from 'it.unimi.dsi.fastutil.bytes.ByteCollection' to match base method */
    @Override // java.util.Map
    Collection<Byte> values();

    @Override // p014it.unimi.dsi.fastutil.Function
    boolean containsKey(Object obj);

    boolean containsValue(byte b);

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    /* bridge */ /* synthetic */ default Byte put(Object obj, Byte b) {
        return put((Reference2ByteMap<K>) obj, b);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.util.function.BiFunction] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Byte merge(Object obj, Byte b, BiFunction<? super Byte, ? super Byte, ? extends Byte> biFunction) {
        return merge((Reference2ByteMap<K>) obj, b, biFunction);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Byte replace(Object obj, Byte b) {
        return replace((Reference2ByteMap<K>) obj, b);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default boolean replace(Object obj, Byte b, Byte b2) {
        return replace((Reference2ByteMap<K>) obj, b, b2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    @Deprecated
    /* bridge */ /* synthetic */ default Byte putIfAbsent(Object obj, Byte b) {
        return putIfAbsent((Reference2ByteMap<K>) obj, b);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteMap$FastEntrySet */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteMap$FastEntrySet.class */
    public interface FastEntrySet<K> extends ObjectSet<Entry<K>> {
        ObjectIterator<Entry<K>> fastIterator();

        default void fastForEach(Consumer<? super Entry<K>> consumer) {
            forEach(consumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.Function, p014it.unimi.dsi.fastutil.bytes.Byte2BooleanMap, java.util.Map
    default void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    default ObjectSet<Map.Entry<K, Byte>> entrySet() {
        return reference2ByteEntrySet();
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    @Deprecated
    default Byte put(K key, Byte value) {
        return put((Reference2ByteMap<K>) key, value);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte get(Object key) {
        return get(key);
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction, p014it.unimi.dsi.fastutil.Function
    @Deprecated
    default Byte remove(Object key) {
        return remove(key);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        return containsValue(((Byte) value).byteValue());
    }

    @Override // java.util.Map
    default void forEach(BiConsumer<? super K, ? super Byte> consumer) {
        ObjectSet<Entry<K>> entrySet = reference2ByteEntrySet();
        Consumer<Entry<K>> wrappingConsumer = entry -> {
            consumer.accept(entry.getKey(), Byte.valueOf(entry.getByteValue()));
        };
        if (entrySet instanceof FastEntrySet) {
            ((FastEntrySet) entrySet).fastForEach(wrappingConsumer);
        } else {
            entrySet.forEach(wrappingConsumer);
        }
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    default byte getOrDefault(Object key, byte defaultValue) {
        byte v = getByte(key);
        return (v != defaultReturnValue() || containsKey(key)) ? v : defaultValue;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.Reference2ByteFunction
    @Deprecated
    default Byte getOrDefault(Object key, Byte defaultValue) {
        return getOrDefault(key, (Object) defaultValue);
    }

    default byte putIfAbsent(K key, byte value) {
        byte v = getByte(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        put((Reference2ByteMap<K>) key, value);
        return drv;
    }

    default boolean remove(Object key, byte value) {
        byte curValue = getByte(key);
        if (curValue != value) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        removeByte(key);
        return true;
    }

    default boolean replace(K key, byte oldValue, byte newValue) {
        byte curValue = getByte(key);
        if (curValue != oldValue) {
            return false;
        }
        if (curValue == defaultReturnValue() && !containsKey(key)) {
            return false;
        }
        put((Reference2ByteMap<K>) key, newValue);
        return true;
    }

    default byte replace(K key, byte value) {
        return containsKey(key) ? put((Reference2ByteMap<K>) key, value) : defaultReturnValue();
    }

    default byte computeIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = getByte(key);
        if (v != defaultReturnValue() || containsKey(key)) {
            return v;
        }
        byte newValue = SafeMath.safeIntToByte(mappingFunction.applyAsInt(key));
        put((Reference2ByteMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default byte computeByteIfAbsent(K key, ToIntFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2ByteMap<K>) key, (ToIntFunction<? super Reference2ByteMap<K>>) mappingFunction);
    }

    default byte computeIfAbsent(K key, Reference2ByteFunction<? super K> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        byte v = getByte(key);
        byte drv = defaultReturnValue();
        if (v != drv || containsKey(key)) {
            return v;
        }
        if (!mappingFunction.containsKey(key)) {
            return drv;
        }
        byte newValue = mappingFunction.getByte(key);
        put((Reference2ByteMap<K>) key, newValue);
        return newValue;
    }

    @Deprecated
    default byte computeByteIfAbsentPartial(K key, Reference2ByteFunction<? super K> mappingFunction) {
        return computeIfAbsent((Reference2ByteMap<K>) key, (Reference2ByteFunction<? super Reference2ByteMap<K>>) mappingFunction);
    }

    default byte computeByteIfPresent(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = getByte(key);
        byte drv = defaultReturnValue();
        if (oldValue == drv && !containsKey(key)) {
            return drv;
        }
        Byte newValue = (Byte) remappingFunction.apply(key, Byte.valueOf(oldValue));
        if (newValue == null) {
            removeByte(key);
            return drv;
        }
        byte newVal = newValue.byteValue();
        put((Reference2ByteMap<K>) key, newVal);
        return newVal;
    }

    default byte computeByte(K key, BiFunction<? super K, ? super Byte, ? extends Byte> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = getByte(key);
        byte drv = defaultReturnValue();
        boolean contained = oldValue != drv || containsKey(key);
        Byte newValue = (Byte) remappingFunction.apply(key, contained ? Byte.valueOf(oldValue) : null);
        if (newValue == null) {
            if (contained) {
                removeByte(key);
            }
            return drv;
        }
        byte newVal = newValue.byteValue();
        put((Reference2ByteMap<K>) key, newVal);
        return newVal;
    }

    default byte merge(K key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        byte newValue;
        Objects.requireNonNull(remappingFunction);
        byte oldValue = getByte(key);
        byte drv = defaultReturnValue();
        if (oldValue != drv || containsKey(key)) {
            Byte mergedValue = (Byte) remappingFunction.apply(Byte.valueOf(oldValue), Byte.valueOf(value));
            if (mergedValue == null) {
                removeByte(key);
                return drv;
            }
            newValue = mergedValue.byteValue();
        } else {
            newValue = value;
        }
        put((Reference2ByteMap<K>) key, newValue);
        return newValue;
    }

    default byte mergeByte(K key, byte value, ByteBinaryOperator remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        byte oldValue = getByte(key);
        byte newValue = (oldValue != defaultReturnValue() || containsKey(key)) ? remappingFunction.apply(oldValue, value) : value;
        put((Reference2ByteMap<K>) key, newValue);
        return newValue;
    }

    default byte mergeByte(K key, byte value, IntBinaryOperator remappingFunction) {
        return mergeByte((Reference2ByteMap<K>) key, value, remappingFunction instanceof ByteBinaryOperator ? (ByteBinaryOperator) remappingFunction : x, y -> {
            return SafeMath.safeIntToByte(remappingFunction.applyAsInt(x, y));
        });
    }

    @Deprecated
    default byte mergeByte(K key, byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        return merge((Reference2ByteMap<K>) key, value, remappingFunction);
    }

    @Deprecated
    default Byte putIfAbsent(K key, Byte value) {
        return putIfAbsent((Reference2ByteMap<K>) key, (K) value);
    }

    @Override // java.util.Map
    @Deprecated
    default boolean remove(Object key, Object value) {
        return remove(key, value);
    }

    @Deprecated
    default boolean replace(K key, Byte oldValue, Byte newValue) {
        return replace((Reference2ByteMap<K>) key, oldValue, newValue);
    }

    @Deprecated
    default Byte replace(K key, Byte value) {
        return replace((Reference2ByteMap<K>) key, (K) value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.util.function.BiFunction<? super java.lang.Byte, ? super java.lang.Byte, ? extends java.lang.Byte> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    default Byte merge(K key, Byte value, BiFunction<? super Byte, ? super Byte, ? extends Byte> remappingFunction) {
        return merge((Reference2ByteMap<K>) key, (K) value, (BiFunction<? super K, ? super K, ? extends K>) remappingFunction);
    }

    /* renamed from: it.unimi.dsi.fastutil.objects.Reference2ByteMap$Entry */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/Reference2ByteMap$Entry.class */
    public interface Entry<K> extends Map.Entry<K, Byte> {
        byte getByteValue();

        byte setValue(byte b);

        @Override // java.util.Map.Entry
        @Deprecated
        default Byte getValue() {
            return Byte.valueOf(getByteValue());
        }

        @Deprecated
        default Byte setValue(Byte value) {
            return Byte.valueOf(setValue(value.byteValue()));
        }
    }
}
