package com.mongodb.client.internal;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.SyncOperations;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/ListDatabasesIterableImpl.class */
public class ListDatabasesIterableImpl<TResult> extends MongoIterableImpl<TResult> implements ListDatabasesIterable<TResult> {
    private final SyncOperations<BsonDocument> operations;
    private final Class<TResult> resultClass;
    private long maxTimeMS;
    private Bson filter;
    private Boolean nameOnly;
    private Boolean authorizedDatabasesOnly;

    ListDatabasesIterableImpl(@Nullable ClientSession clientSession, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, OperationExecutor executor) {
        this(clientSession, resultClass, codecRegistry, readPreference, executor, true);
    }

    public ListDatabasesIterableImpl(@Nullable ClientSession clientSession, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, OperationExecutor executor, boolean retryReads) {
        super(clientSession, executor, ReadConcern.DEFAULT, readPreference, retryReads);
        this.operations = new SyncOperations<>(BsonDocument.class, readPreference, codecRegistry, retryReads);
        this.resultClass = (Class) Assertions.notNull("clazz", resultClass);
    }

    @Override // com.mongodb.client.ListDatabasesIterable
    public ListDatabasesIterableImpl<TResult> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public ListDatabasesIterable<TResult> batchSize(int batchSize) {
        batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.ListDatabasesIterable
    public ListDatabasesIterable<TResult> filter(@Nullable Bson filter) {
        this.filter = filter;
        return this;
    }

    @Override // com.mongodb.client.ListDatabasesIterable
    public ListDatabasesIterable<TResult> nameOnly(@Nullable Boolean nameOnly) {
        this.nameOnly = nameOnly;
        return this;
    }

    @Override // com.mongodb.client.ListDatabasesIterable
    public ListDatabasesIterable<TResult> authorizedDatabasesOnly(@Nullable Boolean authorizedDatabasesOnly) {
        this.authorizedDatabasesOnly = authorizedDatabasesOnly;
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ReadOperation<BatchCursor<TResult>> asReadOperation() {
        return this.operations.listDatabases(this.resultClass, this.filter, this.nameOnly, this.maxTimeMS, this.authorizedDatabasesOnly);
    }
}
