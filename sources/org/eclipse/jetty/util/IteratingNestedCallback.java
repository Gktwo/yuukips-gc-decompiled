package org.eclipse.jetty.util;

import org.eclipse.jetty.util.thread.Invocable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/IteratingNestedCallback.class */
public abstract class IteratingNestedCallback extends IteratingCallback {
    final Callback _callback;

    public IteratingNestedCallback(Callback callback) {
        this._callback = callback;
    }

    @Override // org.eclipse.jetty.util.thread.Invocable
    public Invocable.InvocationType getInvocationType() {
        return this._callback.getInvocationType();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.IteratingCallback
    public void onCompleteSuccess() {
        this._callback.succeeded();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.IteratingCallback
    public void onCompleteFailure(Throwable x) {
        this._callback.failed(x);
    }

    @Override // org.eclipse.jetty.util.IteratingCallback
    public String toString() {
        return String.format("%s@%x", getClass().getSimpleName(), Integer.valueOf(hashCode()));
    }
}
