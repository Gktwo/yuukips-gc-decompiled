package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/BiMap.class */
public interface BiMap<K, V> extends Map<K, V> {
    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    V put(K k, V v);

    @CanIgnoreReturnValue
    V forcePut(K k, V v);

    @Override // com.google.common.collect.BiMap
    void putAll(Map<? extends K, ? extends V> map);

    @Override // com.google.common.collect.BiMap
    Set<V> values();

    BiMap<V, K> inverse();
}
