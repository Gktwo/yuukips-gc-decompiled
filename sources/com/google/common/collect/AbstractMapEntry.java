package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/AbstractMapEntry.class */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public boolean equals(Object object) {
        if (!(object instanceof Map.Entry)) {
            return false;
        }
        Map.Entry<?, ?> that = (Map.Entry) object;
        return Objects.equal(getKey(), that.getKey()) && Objects.equal(getValue(), that.getValue());
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public int hashCode() {
        K k = getKey();
        V v = getValue();
        return (k == null ? 0 : k.hashCode()) ^ (v == null ? 0 : v.hashCode());
    }

    @Override // java.lang.Object
    public String toString() {
        return getKey() + "=" + getValue();
    }
}
