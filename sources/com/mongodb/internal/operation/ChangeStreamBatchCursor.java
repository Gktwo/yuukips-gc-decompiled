package com.mongodb.internal.operation;

import com.mongodb.DBCollection;
import com.mongodb.Function;
import com.mongodb.MongoChangeStreamException;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.operation.OperationHelper;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;
import org.bson.RawBsonDocument;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ChangeStreamBatchCursor.class */
public final class ChangeStreamBatchCursor<T> implements AggregateResponseBatchCursor<T> {
    private final ReadBinding binding;
    private final ChangeStreamOperation<T> changeStreamOperation;
    private final int maxWireVersion;
    private AggregateResponseBatchCursor<RawBsonDocument> wrapped;
    private BsonDocument resumeToken;
    private volatile boolean closed;

    /* access modifiers changed from: package-private */
    public ChangeStreamBatchCursor(ChangeStreamOperation<T> changeStreamOperation, AggregateResponseBatchCursor<RawBsonDocument> wrapped, ReadBinding binding, BsonDocument resumeToken, int maxWireVersion) {
        this.changeStreamOperation = changeStreamOperation;
        this.binding = binding.retain();
        this.wrapped = wrapped;
        this.resumeToken = resumeToken;
        this.maxWireVersion = maxWireVersion;
    }

    AggregateResponseBatchCursor<RawBsonDocument> getWrapped() {
        return this.wrapped;
    }

    @Override // com.mongodb.internal.operation.BatchCursor, java.util.Iterator
    public boolean hasNext() {
        return ((Boolean) resumeableOperation(new Function<AggregateResponseBatchCursor<RawBsonDocument>, Boolean>() { // from class: com.mongodb.internal.operation.ChangeStreamBatchCursor.1
            public Boolean apply(AggregateResponseBatchCursor<RawBsonDocument> queryBatchCursor) {
                try {
                    return Boolean.valueOf(queryBatchCursor.hasNext());
                } finally {
                    ChangeStreamBatchCursor.this.cachePostBatchResumeToken(queryBatchCursor);
                }
            }
        })).booleanValue();
    }

    @Override // com.mongodb.internal.operation.BatchCursor, java.util.Iterator
    public List<T> next() {
        return (List) resumeableOperation(new Function<AggregateResponseBatchCursor<RawBsonDocument>, List<T>>() { // from class: com.mongodb.internal.operation.ChangeStreamBatchCursor.2
            public List<T> apply(AggregateResponseBatchCursor<RawBsonDocument> queryBatchCursor) {
                try {
                    return ChangeStreamBatchCursor.this.convertResults(queryBatchCursor.next());
                } finally {
                    ChangeStreamBatchCursor.this.cachePostBatchResumeToken(queryBatchCursor);
                }
            }
        });
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public List<T> tryNext() {
        return (List) resumeableOperation(new Function<AggregateResponseBatchCursor<RawBsonDocument>, List<T>>() { // from class: com.mongodb.internal.operation.ChangeStreamBatchCursor.3
            public List<T> apply(AggregateResponseBatchCursor<RawBsonDocument> queryBatchCursor) {
                try {
                    return ChangeStreamBatchCursor.this.convertResults(queryBatchCursor.tryNext());
                } finally {
                    ChangeStreamBatchCursor.this.cachePostBatchResumeToken(queryBatchCursor);
                }
            }
        });
    }

    @Override // com.mongodb.internal.operation.BatchCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.wrapped.close();
            this.binding.release();
        }
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public void setBatchSize(int batchSize) {
        this.wrapped.setBatchSize(batchSize);
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public int getBatchSize() {
        return this.wrapped.getBatchSize();
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public ServerCursor getServerCursor() {
        return this.wrapped.getServerCursor();
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public ServerAddress getServerAddress() {
        return this.wrapped.getServerAddress();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public BsonDocument getPostBatchResumeToken() {
        return this.wrapped.getPostBatchResumeToken();
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public BsonTimestamp getOperationTime() {
        return this.changeStreamOperation.getStartAtOperationTime();
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public boolean isFirstBatchEmpty() {
        return this.wrapped.isFirstBatchEmpty();
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public int getMaxWireVersion() {
        return this.maxWireVersion;
    }

    /* access modifiers changed from: private */
    public void cachePostBatchResumeToken(AggregateResponseBatchCursor<RawBsonDocument> queryBatchCursor) {
        if (queryBatchCursor.getPostBatchResumeToken() != null) {
            this.resumeToken = queryBatchCursor.getPostBatchResumeToken();
        }
    }

    /* access modifiers changed from: private */
    public List<T> convertResults(List<RawBsonDocument> rawDocuments) {
        ArrayList arrayList = null;
        if (rawDocuments != null) {
            arrayList = new ArrayList();
            for (RawBsonDocument rawDocument : rawDocuments) {
                if (!rawDocument.containsKey(DBCollection.ID_FIELD_NAME)) {
                    throw new MongoChangeStreamException("Cannot provide resume functionality when the resume token is missing.");
                }
                arrayList.add(rawDocument.decode(this.changeStreamOperation.getDecoder()));
            }
            this.resumeToken = rawDocuments.get(rawDocuments.size() - 1).getDocument(DBCollection.ID_FIELD_NAME);
        }
        return arrayList;
    }

    <R> R resumeableOperation(Function<AggregateResponseBatchCursor<RawBsonDocument>, R> function) {
        while (true) {
            try {
                return function.apply(this.wrapped);
            } catch (Throwable t) {
                if (!ChangeStreamBatchCursorHelper.isRetryableError(t, this.maxWireVersion)) {
                    throw MongoException.fromThrowableNonNull(t);
                }
                this.wrapped.close();
                OperationHelper.withReadConnectionSource(this.binding, new OperationHelper.CallableWithSource<Void>() { // from class: com.mongodb.internal.operation.ChangeStreamBatchCursor.4
                    @Override // com.mongodb.internal.operation.OperationHelper.CallableWithSource
                    public Void call(ConnectionSource source) {
                        ChangeStreamBatchCursor.this.changeStreamOperation.setChangeStreamOptionsForResume(ChangeStreamBatchCursor.this.resumeToken, source.getServerDescription().getMaxWireVersion());
                        return null;
                    }
                });
                this.wrapped = ((ChangeStreamBatchCursor) this.changeStreamOperation.execute(this.binding)).getWrapped();
                this.binding.release();
            }
        }
    }
}
