package com.mongodb.internal.async;

import java.io.Closeable;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/async/AsyncBatchCursor.class */
public interface AsyncBatchCursor<T> extends Closeable {
    void next(SingleResultCallback<List<T>> singleResultCallback);

    void tryNext(SingleResultCallback<List<T>> singleResultCallback);

    void setBatchSize(int i);

    int getBatchSize();

    boolean isClosed();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
