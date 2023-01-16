package com.mchange.util.impl;

import com.mchange.util.ObjectCache;
import java.util.Hashtable;

/* loaded from: grasscutter.jar:com/mchange/util/impl/NoGCObjectCache.class */
public abstract class NoGCObjectCache implements ObjectCache {
    Hashtable store = new Hashtable();

    protected abstract Object createFromKey(Object obj) throws Exception;

    @Override // com.mchange.util.ObjectCache
    public Object find(Object obj) throws Exception {
        Object obj2 = this.store.get(obj);
        if (obj2 == null || isDirty(obj, obj2)) {
            obj2 = createFromKey(obj);
            this.store.put(obj, obj2);
        }
        return obj2;
    }

    protected boolean isDirty(Object obj, Object obj2) {
        return false;
    }
}
