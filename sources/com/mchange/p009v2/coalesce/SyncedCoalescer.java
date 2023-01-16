package com.mchange.p009v2.coalesce;

import java.util.Iterator;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.coalesce.SyncedCoalescer */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/SyncedCoalescer.class */
public class SyncedCoalescer implements Coalescer {
    Coalescer inner;

    public SyncedCoalescer(Coalescer coalescer) {
        this.inner = coalescer;
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public synchronized Object coalesce(Object obj) {
        return this.inner.coalesce(obj);
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public synchronized int countCoalesced() {
        return this.inner.countCoalesced();
    }

    @Override // com.mchange.p009v2.coalesce.Coalescer
    public synchronized Iterator iterator() {
        return this.inner.iterator();
    }
}
