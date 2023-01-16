package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/collect/HashMultimapGwtSerializationDependencies.class */
abstract class HashMultimapGwtSerializationDependencies<K, V> extends AbstractSetMultimap<K, V> {
    /* access modifiers changed from: package-private */
    public HashMultimapGwtSerializationDependencies(Map<K, Collection<V>> map) {
        super(map);
    }
}
