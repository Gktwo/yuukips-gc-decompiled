package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.util.Map;
import java.util.function.BiConsumer;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true, emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/SingletonImmutableBiMap.class */
public final class SingletonImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    final transient K singleKey;
    final transient V singleValue;
    @RetainedWith
    @LazyInit
    transient ImmutableBiMap<V, K> inverse;

    /* access modifiers changed from: package-private */
    public SingletonImmutableBiMap(K singleKey, V singleValue) {
        CollectPreconditions.checkEntryNotNull(singleKey, singleValue);
        this.singleKey = singleKey;
        this.singleValue = singleValue;
    }

    private SingletonImmutableBiMap(K singleKey, V singleValue, ImmutableBiMap<V, K> inverse) {
        this.singleKey = singleKey;
        this.singleValue = singleValue;
        this.inverse = inverse;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object key) {
        if (this.singleKey.equals(key)) {
            return this.singleValue;
        }
        return null;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> action) {
        ((BiConsumer) Preconditions.checkNotNull(action)).accept(this.singleKey, this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object key) {
        return this.singleKey.equals(key);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(Object value) {
        return this.singleValue.equals(value);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return ImmutableSet.m1395of(Maps.immutableEntry(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return ImmutableSet.m1395of(this.singleKey);
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> result = this.inverse;
        if (result != null) {
            return result;
        }
        SingletonImmutableBiMap singletonImmutableBiMap = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
        this.inverse = singletonImmutableBiMap;
        return singletonImmutableBiMap;
    }
}
