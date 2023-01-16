package com.mchange.p009v2.coalesce;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.mchange.v2.coalesce.AbstractStrongCoalescer */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/AbstractStrongCoalescer.class */
class AbstractStrongCoalescer implements Coalescer {
    Map coalesced;

    /* access modifiers changed from: package-private */
    public AbstractStrongCoalescer(Map map) {
        this.coalesced = map;
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public Object coalesce(Object obj) {
        Object obj2 = this.coalesced.get(obj);
        if (obj2 == null) {
            this.coalesced.put(obj, obj);
            obj2 = obj;
        }
        return obj2;
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public int countCoalesced() {
        return this.coalesced.size();
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public Iterator iterator() {
        return new CoalescerIterator(this.coalesced.keySet().iterator());
    }
}
