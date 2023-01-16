package com.mchange.p009v2.coalesce;

import java.util.Iterator;

/* renamed from: com.mchange.v2.coalesce.CoalescerIterator */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/CoalescerIterator.class */
class CoalescerIterator implements Iterator {
    Iterator inner;

    /* access modifiers changed from: package-private */
    public CoalescerIterator(Iterator it) {
        this.inner = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.inner.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return this.inner.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Objects cannot be removed from a coalescer!");
    }
}
