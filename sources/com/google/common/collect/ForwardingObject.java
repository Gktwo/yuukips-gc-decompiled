package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/collect/ForwardingObject.class */
public abstract class ForwardingObject {
    protected abstract Object delegate();

    @Override // java.lang.Object
    public String toString() {
        return delegate().toString();
    }
}
