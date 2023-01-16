package com.mongodb.client.internal;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.model.Collation;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.SyncOperations;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/DistinctIterableImpl.class */
class DistinctIterableImpl<TDocument, TResult> extends MongoIterableImpl<TResult> implements DistinctIterable<TResult> {
    private final SyncOperations<TDocument> operations;
    private final Class<TResult> resultClass;
    private final String fieldName;
    private Bson filter;
    private long maxTimeMS;
    private Collation collation;

    DistinctIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, OperationExecutor executor, String fieldName, Bson filter) {
        this(clientSession, namespace, documentClass, resultClass, codecRegistry, readPreference, readConcern, executor, fieldName, filter, true);
    }

    /* access modifiers changed from: package-private */
    public DistinctIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, OperationExecutor executor, String fieldName, Bson filter, boolean retryReads) {
        super(clientSession, executor, readConcern, readPreference, retryReads);
        this.operations = new SyncOperations<>(namespace, documentClass, readPreference, codecRegistry, retryReads);
        this.resultClass = (Class) Assertions.notNull("resultClass", resultClass);
        this.fieldName = (String) Assertions.notNull("mapFunction", fieldName);
        this.filter = filter;
    }

    @Override // com.mongodb.client.DistinctIterable
    public DistinctIterable<TResult> filter(@Nullable Bson filter) {
        this.filter = filter;
        return this;
    }

    @Override // com.mongodb.client.DistinctIterable
    public DistinctIterable<TResult> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public DistinctIterable<TResult> batchSize(int batchSize) {
        batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.DistinctIterable
    public DistinctIterable<TResult> collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ReadOperation<BatchCursor<TResult>> asReadOperation() {
        return this.operations.distinct(this.fieldName, this.filter, this.resultClass, this.maxTimeMS, this.collation);
    }
}
