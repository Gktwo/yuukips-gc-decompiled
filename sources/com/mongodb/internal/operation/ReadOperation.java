package com.mongodb.internal.operation;

import com.mongodb.internal.binding.ReadBinding;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ReadOperation.class */
public interface ReadOperation<T> {
    T execute(ReadBinding readBinding);
}
