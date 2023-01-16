package com.mongodb.internal.async;

/* loaded from: grasscutter.jar:com/mongodb/internal/async/SingleResultCallback.class */
public interface SingleResultCallback<T> {
    void onResult(T t, Throwable th);
}
