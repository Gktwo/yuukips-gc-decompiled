package com.mchange.p006v1.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.mchange.v1.util.JoinedIterator */
/* loaded from: grasscutter.jar:com/mchange/v1/util/JoinedIterator.class */
public class JoinedIterator implements Iterator {
    Iterator[] its;
    boolean permit_removes;
    Iterator removeIterator = null;
    int cur = 0;

    public JoinedIterator(Iterator[] itArr, boolean z) {
        this.its = itArr;
        this.permit_removes = z;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.cur == this.its.length) {
            return false;
        }
        if (this.its[this.cur].hasNext()) {
            return true;
        }
        this.cur++;
        return hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.removeIterator = this.its[this.cur];
        return this.removeIterator.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.permit_removes) {
            throw new UnsupportedOperationException();
        } else if (this.removeIterator != null) {
            this.removeIterator.remove();
            this.removeIterator = null;
        } else {
            throw new IllegalStateException("next() not called, or element already removed.");
        }
    }
}
