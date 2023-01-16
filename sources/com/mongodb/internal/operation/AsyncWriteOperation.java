package com.mongodb.internal.operation;

import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncWriteOperation.class */
public interface AsyncWriteOperation<T> {
    void executeAsync(AsyncWriteBinding asyncWriteBinding, SingleResultCallback<T> singleResultCallback);
}
