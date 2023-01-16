package com.mongodb.internal.operation;

import com.mongodb.MongoException;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.async.AsyncBatchCursor;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.connection.QueryResult;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncSingleBatchQueryCursor.class */
public class AsyncSingleBatchQueryCursor<T> implements AsyncBatchCursor<T> {
    private volatile QueryResult<T> firstBatch;
    private volatile boolean closed;

    /* access modifiers changed from: package-private */
    public AsyncSingleBatchQueryCursor(QueryResult<T> firstBatch) {
        this.firstBatch = firstBatch;
        Assertions.isTrue("Empty Cursor", firstBatch.getCursor() == null);
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void next(SingleResultCallback<List<T>> callback) {
        if (this.closed) {
            callback.onResult(null, new MongoException("next() called after the cursor was closed."));
        } else if (this.firstBatch == null || this.firstBatch.getResults().isEmpty()) {
            this.closed = true;
            callback.onResult(null, null);
        } else {
            List<T> results = this.firstBatch.getResults();
            this.firstBatch = null;
            callback.onResult(results, null);
        }
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void tryNext(SingleResultCallback<List<T>> callback) {
        next(callback);
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void setBatchSize(int batchSize) {
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public int getBatchSize() {
        return 0;
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public boolean isClosed() {
        return this.closed;
    }
}
