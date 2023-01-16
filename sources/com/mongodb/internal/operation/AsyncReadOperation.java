package com.mongodb.internal.operation;

import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncReadBinding;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncReadOperation.class */
public interface AsyncReadOperation<T> {
    void executeAsync(AsyncReadBinding asyncReadBinding, SingleResultCallback<T> singleResultCallback);
}
