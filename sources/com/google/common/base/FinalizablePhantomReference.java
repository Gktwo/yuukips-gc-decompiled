package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.PhantomReference;

@GwtIncompatible
/* loaded from: grasscutter.jar:com/google/common/base/FinalizablePhantomReference.class */
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
    protected FinalizablePhantomReference(T referent, FinalizableReferenceQueue queue) {
        super(referent, queue.queue);
        queue.cleanUp();
    }
}
