package com.mongodb.internal.operation;

import com.mongodb.DBCollection;
import com.mongodb.MongoChangeStreamException;
import com.mongodb.MongoException;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.async.AsyncAggregateResponseBatchCursor;
import com.mongodb.internal.async.AsyncBatchCursor;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.operation.OperationHelper;
import com.mongodb.lang.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;
import org.bson.RawBsonDocument;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncChangeStreamBatchCursor.class */
public final class AsyncChangeStreamBatchCursor<T> implements AsyncAggregateResponseBatchCursor<T> {
    private final AsyncReadBinding binding;
    private final ChangeStreamOperation<T> changeStreamOperation;
    private final int maxWireVersion;
    private volatile BsonDocument resumeToken;
    private final AtomicReference<AsyncAggregateResponseBatchCursor<RawBsonDocument>> wrapped;
    private final AtomicBoolean isClosed = new AtomicBoolean();

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncChangeStreamBatchCursor$AsyncBlock.class */
    public interface AsyncBlock {
        void apply(AsyncAggregateResponseBatchCursor<RawBsonDocument> asyncAggregateResponseBatchCursor, SingleResultCallback<List<RawBsonDocument>> singleResultCallback);
    }

    /* access modifiers changed from: package-private */
    public AsyncChangeStreamBatchCursor(ChangeStreamOperation<T> changeStreamOperation, AsyncAggregateResponseBatchCursor<RawBsonDocument> wrapped, AsyncReadBinding binding, BsonDocument resumeToken, int maxWireVersion) {
        this.changeStreamOperation = changeStreamOperation;
        this.wrapped = new AtomicReference<>((AsyncAggregateResponseBatchCursor) Assertions.assertNotNull(wrapped));
        this.binding = binding;
        binding.retain();
        this.resumeToken = resumeToken;
        this.maxWireVersion = maxWireVersion;
    }

    @NonNull
    AsyncAggregateResponseBatchCursor<RawBsonDocument> getWrapped() {
        return (AsyncAggregateResponseBatchCursor) Assertions.assertNotNull(this.wrapped.get());
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void next(SingleResultCallback<List<T>> callback) {
        resumeableOperation(new AsyncBlock() { // from class: com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.1
            @Override // com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.AsyncBlock
            public void apply(AsyncAggregateResponseBatchCursor<RawBsonDocument> cursor, SingleResultCallback<List<RawBsonDocument>> callback2) {
                cursor.next(callback2);
                AsyncChangeStreamBatchCursor.this.cachePostBatchResumeToken(cursor);
            }
        }, convertResultsCallback(callback), false);
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void tryNext(SingleResultCallback<List<T>> callback) {
        resumeableOperation(new AsyncBlock() { // from class: com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.2
            @Override // com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.AsyncBlock
            public void apply(AsyncAggregateResponseBatchCursor<RawBsonDocument> cursor, SingleResultCallback<List<RawBsonDocument>> callback2) {
                cursor.tryNext(callback2);
                AsyncChangeStreamBatchCursor.this.cachePostBatchResumeToken(cursor);
            }
        }, convertResultsCallback(callback), true);
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.isClosed.compareAndSet(false, true)) {
            try {
                nullifyAndCloseWrapped();
            } finally {
                this.binding.release();
            }
        }
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void setBatchSize(int batchSize) {
        getWrapped().setBatchSize(batchSize);
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public int getBatchSize() {
        return getWrapped().getBatchSize();
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public boolean isClosed() {
        if (this.isClosed.get()) {
            return true;
        }
        if (!wrappedClosedItself()) {
            return false;
        }
        close();
        return true;
    }

    private boolean wrappedClosedItself() {
        AsyncAggregateResponseBatchCursor<RawBsonDocument> observedWrapped = this.wrapped.get();
        return observedWrapped != null && observedWrapped.isClosed();
    }

    /* access modifiers changed from: private */
    public void nullifyAndCloseWrapped() {
        AsyncAggregateResponseBatchCursor<RawBsonDocument> observedWrapped = this.wrapped.getAndSet(null);
        if (observedWrapped != null) {
            observedWrapped.close();
        }
    }

    /* access modifiers changed from: private */
    public void setWrappedOrCloseIt(AsyncAggregateResponseBatchCursor<RawBsonDocument> newValue) {
        if (isClosed()) {
            Assertions.assertNull(this.wrapped.get());
            newValue.close();
            return;
        }
        Assertions.assertNull(this.wrapped.getAndSet(newValue));
        if (isClosed()) {
            nullifyAndCloseWrapped();
        }
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public BsonDocument getPostBatchResumeToken() {
        return getWrapped().getPostBatchResumeToken();
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public BsonTimestamp getOperationTime() {
        return this.changeStreamOperation.getStartAtOperationTime();
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public boolean isFirstBatchEmpty() {
        return getWrapped().isFirstBatchEmpty();
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public int getMaxWireVersion() {
        return this.maxWireVersion;
    }

    /* access modifiers changed from: private */
    public void cachePostBatchResumeToken(AsyncAggregateResponseBatchCursor<RawBsonDocument> queryBatchCursor) {
        if (queryBatchCursor.getPostBatchResumeToken() != null) {
            this.resumeToken = queryBatchCursor.getPostBatchResumeToken();
        }
    }

    private SingleResultCallback<List<RawBsonDocument>> convertResultsCallback(final SingleResultCallback<List<T>> callback) {
        return ErrorHandlingResultCallback.errorHandlingCallback(new SingleResultCallback<List<RawBsonDocument>>() { // from class: com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.3
            public void onResult(List<RawBsonDocument> rawDocuments, Throwable t) {
                if (t != null) {
                    callback.onResult(null, t);
                } else if (rawDocuments != null) {
                    ArrayList arrayList = new ArrayList();
                    for (RawBsonDocument rawDocument : rawDocuments) {
                        if (!rawDocument.containsKey(DBCollection.ID_FIELD_NAME)) {
                            callback.onResult(null, new MongoChangeStreamException("Cannot provide resume functionality when the resume token is missing."));
                            return;
                        }
                        try {
                            arrayList.add(rawDocument.decode(AsyncChangeStreamBatchCursor.this.changeStreamOperation.getDecoder()));
                        } catch (Exception e) {
                            callback.onResult(null, e);
                            return;
                        }
                    }
                    AsyncChangeStreamBatchCursor.this.resumeToken = rawDocuments.get(rawDocuments.size() - 1).getDocument(DBCollection.ID_FIELD_NAME);
                    callback.onResult(arrayList, null);
                } else {
                    callback.onResult(null, null);
                }
            }
        }, OperationHelper.LOGGER);
    }

    /* access modifiers changed from: private */
    public void resumeableOperation(final AsyncBlock asyncBlock, final SingleResultCallback<List<RawBsonDocument>> callback, final boolean tryNext) {
        if (isClosed()) {
            Object[] objArr = new Object[1];
            objArr[0] = tryNext ? "tryNext()" : "next()";
            callback.onResult(null, new MongoException(String.format("%s called after the cursor was closed.", objArr)));
            return;
        }
        asyncBlock.apply(getWrapped(), new SingleResultCallback<List<RawBsonDocument>>() { // from class: com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.4
            public void onResult(List<RawBsonDocument> result, Throwable t) {
                if (t == null) {
                    callback.onResult(result, null);
                } else if (ChangeStreamBatchCursorHelper.isRetryableError(t, AsyncChangeStreamBatchCursor.this.maxWireVersion)) {
                    AsyncChangeStreamBatchCursor.this.nullifyAndCloseWrapped();
                    AsyncChangeStreamBatchCursor.this.retryOperation(asyncBlock, callback, tryNext);
                } else {
                    callback.onResult(null, t);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void retryOperation(final AsyncBlock asyncBlock, final SingleResultCallback<List<RawBsonDocument>> callback, final boolean tryNext) {
        OperationHelper.withAsyncReadConnection(this.binding, new OperationHelper.AsyncCallableWithSource() { // from class: com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.5
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithSource
            public void call(AsyncConnectionSource source, Throwable t) {
                if (t != null) {
                    callback.onResult(null, t);
                    return;
                }
                AsyncChangeStreamBatchCursor.this.changeStreamOperation.setChangeStreamOptionsForResume(AsyncChangeStreamBatchCursor.this.resumeToken, source.getServerDescription().getMaxWireVersion());
                source.release();
                AsyncChangeStreamBatchCursor.this.changeStreamOperation.executeAsync(AsyncChangeStreamBatchCursor.this.binding, new SingleResultCallback<AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.AsyncChangeStreamBatchCursor.5.1
                    @Override // com.mongodb.internal.async.SingleResultCallback
                    public /* bridge */ /* synthetic */ void onResult(Object obj, Throwable th) {
                        onResult((AsyncBatchCursor) ((AsyncBatchCursor) obj), th);
                    }

                    public void onResult(AsyncBatchCursor<T> result, Throwable t2) {
                        if (t2 != null) {
                            callback.onResult(null, t2);
                            return;
                        }
                        try {
                            AsyncChangeStreamBatchCursor.this.setWrappedOrCloseIt(((AsyncChangeStreamBatchCursor) result).getWrapped());
                            try {
                                AsyncChangeStreamBatchCursor.this.binding.release();
                                AsyncChangeStreamBatchCursor.this.resumeableOperation(asyncBlock, callback, tryNext);
                            } catch (Throwable th) {
                                AsyncChangeStreamBatchCursor.this.resumeableOperation(asyncBlock, callback, tryNext);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            try {
                                AsyncChangeStreamBatchCursor.this.binding.release();
                                AsyncChangeStreamBatchCursor.this.resumeableOperation(asyncBlock, callback, tryNext);
                                throw th2;
                            } catch (Throwable th3) {
                                AsyncChangeStreamBatchCursor.this.resumeableOperation(asyncBlock, callback, tryNext);
                                throw th3;
                            }
                        }
                    }
                });
            }
        });
    }
}
