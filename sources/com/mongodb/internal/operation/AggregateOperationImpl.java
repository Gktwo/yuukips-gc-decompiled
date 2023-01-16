package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.AsyncBatchCursor;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.client.model.AggregationLevel;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.session.SessionContext;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.Decoder;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AggregateOperationImpl.class */
public class AggregateOperationImpl<T> implements AsyncReadOperation<AsyncBatchCursor<T>>, ReadOperation<BatchCursor<T>> {
    private static final String CURSOR = "cursor";
    private final MongoNamespace namespace;
    private final List<BsonDocument> pipeline;
    private final Decoder<T> decoder;
    private final AggregateTarget aggregateTarget;
    private final PipelineCreator pipelineCreator;
    private boolean retryReads;
    private Boolean allowDiskUse;
    private Integer batchSize;
    private Collation collation;
    private String comment;
    private BsonValue hint;
    private long maxAwaitTimeMS;
    private long maxTimeMS;
    private static final String RESULT = "result";
    private static final String FIRST_BATCH = "firstBatch";
    private static final List<String> FIELD_NAMES_WITH_RESULT = Arrays.asList(RESULT, FIRST_BATCH);

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/AggregateOperationImpl$AggregateTarget.class */
    public interface AggregateTarget {
        BsonValue create();
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/AggregateOperationImpl$PipelineCreator.class */
    public interface PipelineCreator {
        BsonArray create();
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl(MongoNamespace namespace, List<BsonDocument> pipeline, Decoder<T> decoder, AggregationLevel aggregationLevel) {
        this(namespace, pipeline, decoder, defaultAggregateTarget((AggregationLevel) Assertions.notNull("aggregationLevel", aggregationLevel), ((MongoNamespace) Assertions.notNull("namespace", namespace)).getCollectionName()), defaultPipelineCreator(pipeline));
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl(MongoNamespace namespace, List<BsonDocument> pipeline, Decoder<T> decoder, AggregateTarget aggregateTarget, PipelineCreator pipelineCreator) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.pipeline = (List) Assertions.notNull("pipeline", pipeline);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
        this.aggregateTarget = (AggregateTarget) Assertions.notNull("aggregateTarget", aggregateTarget);
        this.pipelineCreator = (PipelineCreator) Assertions.notNull("pipelineCreator", pipelineCreator);
    }

    /* access modifiers changed from: package-private */
    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    /* access modifiers changed from: package-private */
    public List<BsonDocument> getPipeline() {
        return this.pipeline;
    }

    /* access modifiers changed from: package-private */
    public Decoder<T> getDecoder() {
        return this.decoder;
    }

    /* access modifiers changed from: package-private */
    public Boolean getAllowDiskUse() {
        return this.allowDiskUse;
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> allowDiskUse(Boolean allowDiskUse) {
        this.allowDiskUse = allowDiskUse;
        return this;
    }

    /* access modifiers changed from: package-private */
    public Integer getBatchSize() {
        return this.batchSize;
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> batchSize(Integer batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    /* access modifiers changed from: package-private */
    public long getMaxAwaitTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxAwaitTimeMS, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxAwaitTime >= 0", maxAwaitTime >= 0);
        this.maxAwaitTimeMS = TimeUnit.MILLISECONDS.convert(maxAwaitTime, timeUnit);
        return this;
    }

    /* access modifiers changed from: package-private */
    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxTime >= 0", maxTime >= 0);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    /* access modifiers changed from: package-private */
    public Collation getCollation() {
        return this.collation;
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    /* access modifiers changed from: package-private */
    public String getComment() {
        return this.comment;
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> comment(String comment) {
        this.comment = comment;
        return this;
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> retryReads(boolean retryReads) {
        this.retryReads = retryReads;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean getRetryReads() {
        return this.retryReads;
    }

    /* access modifiers changed from: package-private */
    public BsonValue getHint() {
        return this.hint;
    }

    /* access modifiers changed from: package-private */
    public AggregateOperationImpl<T> hint(BsonValue hint) {
        Assertions.isTrueArgument("BsonString or BsonDocument", hint == null || hint.isDocument() || hint.isString());
        this.hint = hint;
        return this;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public BatchCursor<T> execute(ReadBinding binding) {
        return (BatchCursor) CommandOperationHelper.executeCommand(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), (Decoder) CommandResultDocumentCodec.create(this.decoder, FIELD_NAMES_WITH_RESULT), (CommandOperationHelper.CommandReadTransformer<D, Object>) transformer(), this.retryReads);
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(AsyncReadBinding binding, SingleResultCallback<AsyncBatchCursor<T>> callback) {
        CommandOperationHelper.executeCommandAsync(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), CommandResultDocumentCodec.create(this.decoder, FIELD_NAMES_WITH_RESULT), asyncTransformer(), this.retryReads, ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER));
    }

    private CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.AggregateOperationImpl.1
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                OperationHelper.validateReadConcernAndCollation(connectionDescription, sessionContext.getReadConcern(), AggregateOperationImpl.this.collation);
                return AggregateOperationImpl.this.getCommand(sessionContext);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public BsonDocument getCommand(SessionContext sessionContext) {
        BsonDocument commandDocument = new BsonDocument("aggregate", this.aggregateTarget.create());
        OperationReadConcernHelper.appendReadConcernToCommand(sessionContext, commandDocument);
        commandDocument.put("pipeline", (BsonValue) this.pipelineCreator.create());
        if (this.maxTimeMS > 0) {
            commandDocument.put("maxTimeMS", this.maxTimeMS > 2147483647L ? new BsonInt64(this.maxTimeMS) : new BsonInt32((int) this.maxTimeMS));
        }
        BsonDocument cursor = new BsonDocument();
        if (this.batchSize != null) {
            cursor.put("batchSize", (BsonValue) new BsonInt32(this.batchSize.intValue()));
        }
        commandDocument.put(CURSOR, (BsonValue) cursor);
        if (this.allowDiskUse != null) {
            commandDocument.put("allowDiskUse", (BsonValue) BsonBoolean.valueOf(this.allowDiskUse.booleanValue()));
        }
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        if (this.comment != null) {
            commandDocument.put("comment", (BsonValue) new BsonString(this.comment));
        }
        if (this.hint != null) {
            commandDocument.put("hint", this.hint);
        }
        return commandDocument;
    }

    /* access modifiers changed from: private */
    public QueryResult<T> createQueryResult(BsonDocument result, ConnectionDescription description) {
        return OperationHelper.cursorDocumentToQueryResult(result.getDocument(CURSOR), description.getServerAddress());
    }

    private CommandOperationHelper.CommandReadTransformer<BsonDocument, AggregateResponseBatchCursor<T>> transformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, AggregateResponseBatchCursor<T>>() { // from class: com.mongodb.internal.operation.AggregateOperationImpl.2
            public AggregateResponseBatchCursor<T> apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return new QueryBatchCursor(AggregateOperationImpl.this.createQueryResult(result, connection.getDescription()), 0, AggregateOperationImpl.this.batchSize != null ? AggregateOperationImpl.this.batchSize.intValue() : 0, AggregateOperationImpl.this.maxAwaitTimeMS, AggregateOperationImpl.this.decoder, source, connection, result);
            }
        };
    }

    private CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.AggregateOperationImpl.3
            public AsyncBatchCursor<T> apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return new AsyncQueryBatchCursor(AggregateOperationImpl.this.createQueryResult(result, connection.getDescription()), 0, AggregateOperationImpl.this.batchSize != null ? AggregateOperationImpl.this.batchSize.intValue() : 0, AggregateOperationImpl.this.maxAwaitTimeMS, AggregateOperationImpl.this.decoder, source, connection, result);
            }
        };
    }

    private static AggregateTarget defaultAggregateTarget(final AggregationLevel aggregationLevel, final String collectionName) {
        return new AggregateTarget() { // from class: com.mongodb.internal.operation.AggregateOperationImpl.4
            @Override // com.mongodb.internal.operation.AggregateOperationImpl.AggregateTarget
            public BsonValue create() {
                if (AggregationLevel.this == AggregationLevel.DATABASE) {
                    return new BsonInt32(1);
                }
                return new BsonString(collectionName);
            }
        };
    }

    private static PipelineCreator defaultPipelineCreator(final List<BsonDocument> pipeline) {
        return new PipelineCreator() { // from class: com.mongodb.internal.operation.AggregateOperationImpl.5
            @Override // com.mongodb.internal.operation.AggregateOperationImpl.PipelineCreator
            public BsonArray create() {
                return new BsonArray(pipeline);
            }
        };
    }
}
