package com.mongodb.client.internal;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.ListIndexesIterable;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.SyncOperations;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/ListIndexesIterableImpl.class */
class ListIndexesIterableImpl<TResult> extends MongoIterableImpl<TResult> implements ListIndexesIterable<TResult> {
    private final SyncOperations<BsonDocument> operations;
    private final Class<TResult> resultClass;
    private long maxTimeMS;

    ListIndexesIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, OperationExecutor executor) {
        this(clientSession, namespace, resultClass, codecRegistry, readPreference, executor, true);
    }

    /* access modifiers changed from: package-private */
    public ListIndexesIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, OperationExecutor executor, boolean retryReads) {
        super(clientSession, executor, ReadConcern.DEFAULT, readPreference, retryReads);
        this.operations = new SyncOperations<>(namespace, BsonDocument.class, readPreference, codecRegistry, retryReads);
        this.resultClass = (Class) Assertions.notNull("resultClass", resultClass);
    }

    @Override // com.mongodb.client.ListIndexesIterable
    public ListIndexesIterable<TResult> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public ListIndexesIterable<TResult> batchSize(int batchSize) {
        batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ReadOperation<BatchCursor<TResult>> asReadOperation() {
        return this.operations.listIndexes(this.resultClass, getBatchSize(), this.maxTimeMS);
    }
}
