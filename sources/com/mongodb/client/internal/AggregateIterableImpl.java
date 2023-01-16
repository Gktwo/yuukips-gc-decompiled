package com.mongodb.client.internal;

import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.ClientSession;
import com.mongodb.client.model.Collation;
import com.mongodb.internal.client.model.AggregationLevel;
import com.mongodb.internal.client.model.FindOptions;
import com.mongodb.internal.operation.BatchCursor;
import com.mongodb.internal.operation.ExplainableReadOperation;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.SyncOperations;
import com.mongodb.lang.Nullable;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/AggregateIterableImpl.class */
class AggregateIterableImpl<TDocument, TResult> extends MongoIterableImpl<TResult> implements AggregateIterable<TResult> {
    private SyncOperations<TDocument> operations;
    private final MongoNamespace namespace;
    private final Class<TDocument> documentClass;
    private final Class<TResult> resultClass;
    private final CodecRegistry codecRegistry;
    private final List<? extends Bson> pipeline;
    private final AggregationLevel aggregationLevel;
    private Boolean allowDiskUse;
    private long maxTimeMS;
    private long maxAwaitTimeMS;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private String comment;
    private Bson hint;

    AggregateIterableImpl(@Nullable ClientSession clientSession, String databaseName, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, WriteConcern writeConcern, OperationExecutor executor, List<? extends Bson> pipeline, AggregationLevel aggregationLevel) {
        this(clientSession, new MongoNamespace(databaseName, "ignored"), (Class) documentClass, (Class) resultClass, codecRegistry, readPreference, readConcern, writeConcern, executor, pipeline, aggregationLevel, true);
    }

    /* access modifiers changed from: package-private */
    public AggregateIterableImpl(@Nullable ClientSession clientSession, String databaseName, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, WriteConcern writeConcern, OperationExecutor executor, List<? extends Bson> pipeline, AggregationLevel aggregationLevel, boolean retryReads) {
        this(clientSession, new MongoNamespace(databaseName, "ignored"), documentClass, resultClass, codecRegistry, readPreference, readConcern, writeConcern, executor, pipeline, aggregationLevel, retryReads);
    }

    /* access modifiers changed from: package-private */
    public AggregateIterableImpl(@Nullable ClientSession clientSession, MongoNamespace namespace, Class<TDocument> documentClass, Class<TResult> resultClass, CodecRegistry codecRegistry, ReadPreference readPreference, ReadConcern readConcern, WriteConcern writeConcern, OperationExecutor executor, List<? extends Bson> pipeline, AggregationLevel aggregationLevel, boolean retryReads) {
        super(clientSession, executor, readConcern, readPreference, retryReads);
        this.operations = new SyncOperations<>(namespace, documentClass, readPreference, codecRegistry, readConcern, writeConcern, true, retryReads);
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.documentClass = (Class) Assertions.notNull("documentClass", documentClass);
        this.resultClass = (Class) Assertions.notNull("resultClass", resultClass);
        this.codecRegistry = (CodecRegistry) Assertions.notNull("codecRegistry", codecRegistry);
        this.pipeline = (List) Assertions.notNull("pipeline", pipeline);
        this.aggregationLevel = (AggregationLevel) Assertions.notNull("aggregationLevel", aggregationLevel);
    }

    @Override // com.mongodb.client.AggregateIterable
    public void toCollection() {
        BsonDocument lastPipelineStage = getLastPipelineStage();
        if (lastPipelineStage == null || (!lastPipelineStage.containsKey("$out") && !lastPipelineStage.containsKey("$merge"))) {
            throw new IllegalStateException("The last stage of the aggregation pipeline must be $out or $merge");
        }
        getExecutor().execute(this.operations.aggregateToCollection(this.pipeline, this.maxTimeMS, this.allowDiskUse, this.bypassDocumentValidation, this.collation, this.hint, this.comment, this.aggregationLevel), getReadConcern(), getClientSession());
    }

    @Override // com.mongodb.client.AggregateIterable
    public AggregateIterable<TResult> allowDiskUse(@Nullable Boolean allowDiskUse) {
        this.allowDiskUse = allowDiskUse;
        return this;
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl, com.mongodb.client.MongoIterable
    public AggregateIterable<TResult> batchSize(int batchSize) {
        batchSize(batchSize);
        return this;
    }

    @Override // com.mongodb.client.AggregateIterable
    public AggregateIterable<TResult> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.AggregateIterable
    public AggregateIterable<TResult> maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxAwaitTimeMS = TimeUnit.MILLISECONDS.convert(maxAwaitTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.client.AggregateIterable
    public AggregateIterable<TResult> bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    @Override // com.mongodb.client.AggregateIterable
    public AggregateIterable<TResult> collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    @Override // com.mongodb.client.AggregateIterable
    public AggregateIterable<TResult> comment(@Nullable String comment) {
        this.comment = comment;
        return this;
    }

    @Override // com.mongodb.client.AggregateIterable
    public AggregateIterable<TResult> hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    @Override // com.mongodb.client.AggregateIterable
    public Document explain() {
        return (Document) executeExplain(Document.class, null);
    }

    @Override // com.mongodb.client.AggregateIterable
    public Document explain(ExplainVerbosity verbosity) {
        return (Document) executeExplain(Document.class, (ExplainVerbosity) Assertions.notNull("verbosity", verbosity));
    }

    @Override // com.mongodb.client.AggregateIterable
    public <E> E explain(Class<E> explainDocumentClass) {
        return (E) executeExplain(explainDocumentClass, null);
    }

    @Override // com.mongodb.client.AggregateIterable
    public <E> E explain(Class<E> explainResultClass, ExplainVerbosity verbosity) {
        return (E) executeExplain(explainResultClass, (ExplainVerbosity) Assertions.notNull("verbosity", verbosity));
    }

    private <E> E executeExplain(Class<E> explainResultClass, @Nullable ExplainVerbosity verbosity) {
        Assertions.notNull("explainDocumentClass", explainResultClass);
        return (E) getExecutor().execute(asAggregateOperation().asExplainableOperation(verbosity, this.codecRegistry.get(explainResultClass)), getReadPreference(), getReadConcern(), getClientSession());
    }

    @Override // com.mongodb.client.internal.MongoIterableImpl
    public ReadOperation<BatchCursor<TResult>> asReadOperation() {
        MongoNamespace outNamespace = getOutNamespace();
        if (outNamespace == null) {
            return asAggregateOperation();
        }
        getExecutor().execute(this.operations.aggregateToCollection(this.pipeline, this.maxTimeMS, this.allowDiskUse, this.bypassDocumentValidation, this.collation, this.hint, this.comment, this.aggregationLevel), getReadConcern(), getClientSession());
        FindOptions findOptions = new FindOptions().collation(this.collation);
        Integer batchSize = getBatchSize();
        if (batchSize != null) {
            findOptions.batchSize(batchSize.intValue());
        }
        return this.operations.find(outNamespace, new BsonDocument(), this.resultClass, findOptions);
    }

    private ExplainableReadOperation<BatchCursor<TResult>> asAggregateOperation() {
        return this.operations.aggregate(this.pipeline, this.resultClass, this.maxTimeMS, this.maxAwaitTimeMS, getBatchSize(), this.collation, this.hint, this.comment, this.allowDiskUse, this.aggregationLevel);
    }

    @Nullable
    private BsonDocument getLastPipelineStage() {
        if (this.pipeline.isEmpty()) {
            return null;
        }
        return ((Bson) Assertions.notNull("last pipeline stage", (Bson) this.pipeline.get(this.pipeline.size() - 1))).toBsonDocument(this.documentClass, this.codecRegistry);
    }

    @Nullable
    private MongoNamespace getOutNamespace() {
        BsonDocument lastPipelineStage = getLastPipelineStage();
        if (lastPipelineStage == null) {
            return null;
        }
        if (lastPipelineStage.containsKey("$out")) {
            if (lastPipelineStage.get((Object) "$out").isString()) {
                return new MongoNamespace(this.namespace.getDatabaseName(), lastPipelineStage.getString("$out").getValue());
            }
            if (lastPipelineStage.get((Object) "$out").isDocument()) {
                BsonDocument outDocument = lastPipelineStage.getDocument("$out");
                if (outDocument.containsKey("db") && outDocument.containsKey("coll")) {
                    return new MongoNamespace(outDocument.getString("db").getValue(), outDocument.getString("coll").getValue());
                }
                throw new IllegalStateException("Cannot return a cursor when the value for $out stage is not a namespace document");
            }
            throw new IllegalStateException("Cannot return a cursor when the value for $out stage is not a string or namespace document");
        } else if (!lastPipelineStage.containsKey("$merge")) {
            return null;
        } else {
            BsonDocument mergeDocument = lastPipelineStage.getDocument("$merge");
            if (mergeDocument.isDocument("into")) {
                BsonDocument intoDocument = mergeDocument.getDocument("into");
                return new MongoNamespace(intoDocument.getString("db", new BsonString(this.namespace.getDatabaseName())).getValue(), intoDocument.getString("coll").getValue());
            } else if (mergeDocument.isString("into")) {
                return new MongoNamespace(this.namespace.getDatabaseName(), mergeDocument.getString("into").getValue());
            } else {
                return null;
            }
        }
    }
}
