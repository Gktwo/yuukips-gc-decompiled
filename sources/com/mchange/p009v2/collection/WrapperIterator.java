package com.mchange.p009v2.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: com.mchange.v2.collection.WrapperIterator */
/* loaded from: grasscutter.jar:com/mchange/v2/collection/WrapperIterator.class */
public abstract class WrapperIterator implements Iterator {
    protected static final Object SKIP_TOKEN = new Object();
    static final boolean DEBUG = true;
    Iterator inner;
    boolean supports_remove;
    Object lastOut;
    Object nextOut;

    protected abstract Object transformObject(Object obj);

    public WrapperIterator(Iterator it, boolean z) {
        this.lastOut = null;
        this.nextOut = SKIP_TOKEN;
        this.inner = it;
        this.supports_remove = z;
    }

    public WrapperIterator(Iterator it) {
        this(it, false);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        findNext();
        return this.nextOut != SKIP_TOKEN;
    }

    private void findNext() {
        if (this.nextOut == SKIP_TOKEN) {
            while (this.inner.hasNext() && this.nextOut == SKIP_TOKEN) {
                this.nextOut = transformObject(this.inner.next());
            }
        }
    }

    @Override // java.util.Iterator
    public Object next() {
        findNext();
        if (this.nextOut != SKIP_TOKEN) {
            this.lastOut = this.nextOut;
            this.nextOut = SKIP_TOKEN;
            if (this.nextOut == SKIP_TOKEN && this.lastOut != SKIP_TOKEN) {
                return this.lastOut;
            }
            throw new AssertionError("Better check out this weird WrapperIterator logic!");
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.supports_remove) {
            throw new UnsupportedOperationException();
        } else if (this.nextOut != SKIP_TOKEN) {
            throw new UnsupportedOperationException(getClass().getName() + " cannot support remove after hasNext() has been called!");
        } else if (this.lastOut != SKIP_TOKEN) {
            this.inner.remove();
        } else {
            throw new NoSuchElementException();
        }
    }
}
