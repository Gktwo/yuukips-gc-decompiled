package com.mchange.p006v1.util;

import java.util.ArrayList;

/* renamed from: com.mchange.v1.util.NumberedObjectCache */
/* loaded from: grasscutter.jar:com/mchange/v1/util/NumberedObjectCache.class */
public abstract class NumberedObjectCache {

    /* renamed from: al */
    ArrayList f386al = new ArrayList();

    protected abstract Object findObject(int i) throws Exception;

    public Object getObject(int i) throws Exception {
        Object obj;
        int i2 = i + 1;
        if (i2 > this.f386al.size()) {
            this.f386al.ensureCapacity(i2 * 2);
            int i3 = i2 * 2;
            for (int size = this.f386al.size(); size < i3; size++) {
                this.f386al.add(null);
            }
            obj = addToCache(i);
        } else {
            obj = this.f386al.get(i);
            if (obj == null) {
                obj = addToCache(i);
            }
        }
        return obj;
    }

    private Object addToCache(int i) throws Exception {
        Object findObject = findObject(i);
        this.f386al.set(i, findObject);
        return findObject;
    }
}
