package com.mongodb.internal.operation;

import com.mongodb.internal.async.AsyncBatchCursor;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MapReduceAsyncBatchCursor.class */
public interface MapReduceAsyncBatchCursor<T> extends AsyncBatchCursor<T> {
    MapReduceStatistics getStatistics();
}
