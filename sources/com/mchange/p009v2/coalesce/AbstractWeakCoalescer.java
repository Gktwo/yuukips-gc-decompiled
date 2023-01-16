package com.mchange.p009v2.coalesce;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.mchange.v2.coalesce.AbstractWeakCoalescer */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/AbstractWeakCoalescer.class */
class AbstractWeakCoalescer implements Coalescer {
    Map wcoalesced;

    /* access modifiers changed from: package-private */
    public AbstractWeakCoalescer(Map map) {
        this.wcoalesced = map;
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public Object coalesce(Object obj) {
        Object obj2 = null;
        WeakReference weakReference = (WeakReference) this.wcoalesced.get(obj);
        if (weakReference != null) {
            obj2 = weakReference.get();
        }
        if (obj2 == null) {
            this.wcoalesced.put(obj, new WeakReference(obj));
            obj2 = obj;
        }
        return obj2;
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public int countCoalesced() {
        return this.wcoalesced.size();
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public Iterator iterator() {
        return new CoalescerIterator(this.wcoalesced.keySet().iterator());
    }
}
