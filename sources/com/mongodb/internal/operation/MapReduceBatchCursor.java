package com.mongodb.internal.operation;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MapReduceBatchCursor.class */
public interface MapReduceBatchCursor<T> extends BatchCursor<T> {
    MapReduceStatistics getStatistics();
}
