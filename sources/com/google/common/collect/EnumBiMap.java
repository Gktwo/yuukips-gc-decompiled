package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/EnumBiMap.class */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    private transient Class<K> keyType;
    private transient Class<V> valueType;
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ Set values() {
        return values();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return keySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, java.util.Map
    public /* bridge */ /* synthetic */ void replaceAll(BiFunction biFunction) {
        replaceAll(biFunction);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        putAll(map);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return containsValue(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.EnumBiMap<K extends java.lang.Enum<K>, V extends java.lang.Enum<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap
    /* bridge */ /* synthetic */ Object checkValue(Object obj) {
        return checkValue((EnumBiMap<K, V>) ((Enum) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.EnumBiMap<K extends java.lang.Enum<K>, V extends java.lang.Enum<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap
    /* bridge */ /* synthetic */ Object checkKey(Object obj) {
        return checkKey((EnumBiMap<K, V>) ((Enum) obj));
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> keyType, Class<V> valueType) {
        return new EnumBiMap<>(keyType, valueType);
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        EnumBiMap<K, V> bimap = create(inferKeyType(map), inferValueType(map));
        bimap.putAll(map);
        return bimap;
    }

    private EnumBiMap(Class<K> keyType, Class<V> valueType) {
        super(new EnumMap(keyType), new EnumMap(valueType));
        this.keyType = keyType;
        this.valueType = valueType;
    }

    /* access modifiers changed from: package-private */
    public static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        Preconditions.checkArgument(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    private static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).valueType;
        }
        Preconditions.checkArgument(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    public Class<V> valueType() {
        return this.valueType;
    }

    K checkKey(K key) {
        return (K) ((Enum) Preconditions.checkNotNull(key));
    }

    V checkValue(V value) {
        return (V) ((Enum) Preconditions.checkNotNull(value));
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(this.keyType);
        stream.writeObject(this.valueType);
        Serialization.writeMap(this, stream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.keyType = (Class) stream.readObject();
        this.valueType = (Class) stream.readObject();
        setDelegates(new EnumMap(this.keyType), new EnumMap(this.valueType));
        Serialization.populateMap(this, stream);
    }
}
