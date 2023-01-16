package com.mchange.p009v2.collection;

import com.mchange.p009v2.lang.ObjectUtils;
import java.util.Map;

/* renamed from: com.mchange.v2.collection.MapEntry */
/* loaded from: grasscutter.jar:com/mchange/v2/collection/MapEntry.class */
public class MapEntry implements Map.Entry {
    Object key;
    Object value;

    public MapEntry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // java.util.Map.Entry
    public Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ObjectUtils.eqOrBothNull(this.key, entry.getKey()) && ObjectUtils.eqOrBothNull(this.value, entry.getValue());
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public int hashCode() {
        return ObjectUtils.hashOrZero(this.key) ^ ObjectUtils.hashOrZero(this.value);
    }
}
