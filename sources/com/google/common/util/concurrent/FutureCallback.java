package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/FutureCallback.class */
public interface FutureCallback<V> {
    void onSuccess(V v);

    void onFailure(Throwable th);
}
