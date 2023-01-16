package com.mongodb.internal.operation;

import com.mongodb.internal.binding.WriteBinding;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/WriteOperation.class */
public interface WriteOperation<T> {
    T execute(WriteBinding writeBinding);
}
