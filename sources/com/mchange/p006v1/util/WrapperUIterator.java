package com.mchange.p006v1.util;

import java.util.NoSuchElementException;

/* renamed from: com.mchange.v1.util.WrapperUIterator */
/* loaded from: grasscutter.jar:com/mchange/v1/util/WrapperUIterator.class */
public abstract class WrapperUIterator implements UIterator {
    protected static final Object SKIP_TOKEN;
    static final boolean DEBUG = true;
    UIterator inner;
    boolean supports_remove;
    Object lastOut;
    Object nextOut;
    static final /* synthetic */ boolean $assertionsDisabled;

    protected abstract Object transformObject(Object obj) throws Exception;

    static {
        $assertionsDisabled = !WrapperUIterator.class.desiredAssertionStatus();
        SKIP_TOKEN = new Object();
    }

    public WrapperUIterator(UIterator uIterator, boolean z) {
        this.lastOut = null;
        this.nextOut = SKIP_TOKEN;
        this.inner = uIterator;
        this.supports_remove = z;
    }

    public WrapperUIterator(UIterator uIterator) {
        this(uIterator, false);
    }

    @Override // com.mchange.p006v1.util.UIterator
    public boolean hasNext() throws Exception {
        findNext();
        return this.nextOut != SKIP_TOKEN;
    }

    private void findNext() throws Exception {
        if (this.nextOut == SKIP_TOKEN) {
            while (this.inner.hasNext() && this.nextOut == SKIP_TOKEN) {
                this.nextOut = transformObject(this.inner.next());
            }
        }
    }

    @Override // com.mchange.p006v1.util.UIterator
    public Object next() throws NoSuchElementException, Exception {
        findNext();
        if (this.nextOut != SKIP_TOKEN) {
            this.lastOut = this.nextOut;
            this.nextOut = SKIP_TOKEN;
            DebugUtils.myAssert(this.nextOut == SKIP_TOKEN && this.lastOut != SKIP_TOKEN);
            if ($assertionsDisabled || (this.nextOut == SKIP_TOKEN && this.lastOut != SKIP_TOKEN)) {
                return this.lastOut;
            }
            throw new AssertionError();
        }
        throw new NoSuchElementException();
    }

    @Override // com.mchange.p006v1.util.UIterator
    public void remove() throws Exception {
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

    @Override // com.mchange.p006v1.util.UIterator, com.mchange.p006v1.util.ClosableResource
    public void close() throws Exception {
        this.inner.close();
    }
}
