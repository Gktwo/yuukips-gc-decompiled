package com.mchange.p006v1.util;

import com.mchange.p009v2.lang.ObjectUtils;
import java.util.Map;

/* renamed from: com.mchange.v1.util.AbstractMapEntry */
/* loaded from: grasscutter.jar:com/mchange/v1/util/AbstractMapEntry.class */
public abstract class AbstractMapEntry implements Map.Entry {
    @Override // java.util.Map.Entry
    public abstract Object getKey();

    @Override // java.util.Map.Entry
    public abstract Object getValue();

    @Override // java.util.Map.Entry
    public abstract Object setValue(Object obj);

    @Override // java.util.Map.Entry, java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ObjectUtils.eqOrBothNull(getKey(), entry.getKey()) && ObjectUtils.eqOrBothNull(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() == null ? 0 : getValue().hashCode());
    }
}
