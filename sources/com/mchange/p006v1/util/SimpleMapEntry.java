package com.mchange.p006v1.util;

import java.util.Map;

/* renamed from: com.mchange.v1.util.SimpleMapEntry */
/* loaded from: grasscutter.jar:com/mchange/v1/util/SimpleMapEntry.class */
public class SimpleMapEntry extends AbstractMapEntry implements Map.Entry {
    Object key;
    Object value;

    public SimpleMapEntry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
    public Object getKey() {
        return this.key;
    }

    @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
    public Object getValue() {
        return this.value;
    }

    @Override // com.mchange.p006v1.util.AbstractMapEntry, java.util.Map.Entry
    public Object setValue(Object obj) {
        this.value = obj;
        return obj;
    }
}
