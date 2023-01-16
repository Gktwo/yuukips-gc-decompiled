package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

/* access modifiers changed from: package-private */
@GwtCompatible(serializable = true)
/* loaded from: grasscutter.jar:com/google/common/collect/ImmutableEntry.class */
public class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    final K key;
    final V value;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public ImmutableEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final V setValue(V value) {
        throw new UnsupportedOperationException();
    }
}
