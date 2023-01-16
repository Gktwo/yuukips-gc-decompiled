package com.mchange.util.impl;

import com.mchange.util.ObjectCache;
import java.util.HashMap;
import java.util.Map;

/* loaded from: grasscutter.jar:com/mchange/util/impl/SoftReferenceObjectCache.class */
public abstract class SoftReferenceObjectCache implements ObjectCache {
    Map store = new HashMap();

    protected abstract Object createFromKey(Object obj) throws Exception;

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (isDirty(r7, r9) == false) goto L_0x003d;
     */
    @Override // com.mchange.util.ObjectCache
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object find(java.lang.Object r7) throws java.lang.Exception {
        /*
            r6 = this;
            r0 = r6
            java.util.Map r0 = r0.store
            r1 = r7
            java.lang.Object r0 = r0.get(r1)
            java.lang.ref.Reference r0 = (java.lang.ref.Reference) r0
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0024
            r0 = r8
            java.lang.Object r0 = r0.get()
            r1 = r0
            r9 = r1
            if (r0 == 0) goto L_0x0024
            r0 = r6
            r1 = r7
            r2 = r9
            boolean r0 = r0.isDirty(r1, r2)
            if (r0 == 0) goto L_0x003d
        L_0x0024:
            r0 = r6
            r1 = r7
            java.lang.Object r0 = r0.createFromKey(r1)
            r9 = r0
            r0 = r6
            java.util.Map r0 = r0.store
            r1 = r7
            java.lang.ref.SoftReference r2 = new java.lang.ref.SoftReference
            r3 = r2
            r4 = r9
            r3.<init>(r4)
            java.lang.Object r0 = r0.put(r1, r2)
        L_0x003d:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.util.impl.SoftReferenceObjectCache.find(java.lang.Object):java.lang.Object");
    }

    protected boolean isDirty(Object obj, Object obj2) {
        return false;
    }
}
