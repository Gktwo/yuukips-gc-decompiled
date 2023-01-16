package com.mongodb.client.internal;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MapReduceIterable;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.MapReduceAction;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.client.model.FindOptions;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.MapReduceBatchCursor;
import com.mongodb.internal.operation.MapReduceStatistics;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.SyncOperations;
import com.mongodb.internal.operation.WriteOperation;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/MapReduceIterableImpl.class */
class MapReduceIterableImpl<TDocument, TResult> extends MongoIterableImpl<TResult> implements MapReduceIterable<TResult> {
    private final SyncOperations<TDocument> operations;
    private final MongoNamespace namespace;
    private final Class<TResult> resultClass;
    private final String mapFunction;
    private final String reduceFunction;
    private String collectionName;
    private String finalizeFunction;
    private Bson scope;
    private Bson filter;
    private Bson sort;
    private int limit;
    private boolean jsMode;
    private long maxTimeMS;
    private String databaseName;
    private boolean sharded;
    private boolean nonAtomic;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private boolean inline = true;
    private boolean verbose = true;
    private MapReduceAction action = MapReduceAction.REPLACE;

    /* access modifiers changed from: package-private */
    public MapReduceIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, WriteConcern writeConcern, OperationExecutor executor, String mapFunction, String reduceFunction) {
        super(clientSession, executor, readConcern, readPreference, false);
        this.operations = new SyncOperations<>(namespace, documentClass, readPreference, codecRegistry, readConcern, writeConcern, false, false);
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.resultClass = (Class) Assertions.notNull("resultClass", resultClass);
        this.mapFunction = (String) Assertions.notNull("mapFunction", mapFunction);
        this.reduceFunction = (String) Assertions.notNull("reduceFunction", reduceFunction);
    }

    @Override // com.mongodb.client.MapReduceIterable
    public void toCollection() {
        if (this.inline) {
            throw new IllegalStateException("The options must specify a non-inline result");
        }
        getExecutor().execute(createMapReduceToCollectionOperation(), getReadConcern(), getClientSession());
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> collectionName(String collectionName) {
        this.collectionName = (String) Assertions.notNull("collectionName", collectionName);
        this.inline = false;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> finalizeFunction(@Nullable String finalizeFunction) {
        this.finalizeFunction = finalizeFunction;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> scope(@Nullable Bson scope) {
        this.scope = scope;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> sort(@Nullable Bson sort) {
        this.sort = sort;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> filter(@Nullable Bson filter) {
        this.filter = filter;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> limit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> jsMode(boolean jsMode) {
        this.jsMode = jsMode;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> verbose(boolean verbose) {
        this.verbose = verbose;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> action(MapReduceAction action) {
        this.action = action;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> databaseName(@Nullable String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> sharded(boolean sharded) {
        this.sharded = sharded;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> nonAtomic(boolean nonAtomic) {
        this.nonAtomic = nonAtomic;
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public MapReduceIterable<TResult> batchSize(int batchSize) {
        batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    @Override // com.mongodb.client.MapReduceIterable
    public MapReduceIterable<TResult> collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ReadPreference getReadPreference() {
        if (this.inline) {
            return getReadPreference();
        }
        return ReadPreference.primary();
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ReadOperation<BatchCursor<TResult>> asReadOperation() {
        if (this.inline) {
            return new WrappedMapReduceReadOperation(this.operations.mapReduce(this.mapFunction, this.reduceFunction, this.finalizeFunction, this.resultClass, this.filter, this.limit, this.maxTimeMS, this.jsMode, this.scope, this.sort, this.verbose, this.collation));
        }
        getExecutor().execute(createMapReduceToCollectionOperation(), getReadConcern(), getClientSession());
        String dbName = this.databaseName != null ? this.databaseName : this.namespace.getDatabaseName();
        FindOptions findOptions = new FindOptions().collation(this.collation);
        Integer batchSize = getBatchSize();
        if (batchSize != null) {
            findOptions.batchSize(batchSize.intValue());
        }
        return this.operations.find(new MongoNamespace(dbName, this.collectionName), new BsonDocument(), this.resultClass, findOptions);
    }

    private WriteOperation<MapReduceStatistics> createMapReduceToCollectionOperation() {
        return this.operations.mapReduceToCollection(this.databaseName, this.collectionName, this.mapFunction, this.reduceFunction, this.finalizeFunction, this.filter, this.limit, this.maxTimeMS, this.jsMode, this.scope, this.sort, this.verbose, this.action, this.nonAtomic, this.sharded, this.bypassDocumentValidation, this.collation);
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/internal/MapReduceIterableImpl$WrappedMapReduceReadOperation.class */
    static class WrappedMapReduceReadOperation<TResult> implements ReadOperation<BatchCursor<TResult>> {
        private final ReadOperation<MapReduceBatchCursor<TResult>> operation;

        ReadOperation<MapReduceBatchCursor<TResult>> getOperation() {
            return this.operation;
        }

        WrappedMapReduceReadOperation(ReadOperation<MapReduceBatchCursor<TResult>> operation) {
            this.operation = operation;
        }

        @Override // com.mongodb.internal.operation.ReadOperation
        public BatchCursor<TResult> execute(ReadBinding binding) {
            return this.operation.execute(binding);
        }
    }
}
