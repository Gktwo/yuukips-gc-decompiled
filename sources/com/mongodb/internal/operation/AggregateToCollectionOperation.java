package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.client.model.AggregationLevel;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.OperationHelper;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AggregateToCollectionOperation.class */
public class AggregateToCollectionOperation implements AsyncWriteOperation<Void>, WriteOperation<Void> {
    private final MongoNamespace namespace;
    private final List<BsonDocument> pipeline;
    private final WriteConcern writeConcern;
    private final ReadConcern readConcern;
    private final AggregationLevel aggregationLevel;
    private Boolean allowDiskUse;
    private long maxTimeMS;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private String comment;
    private BsonDocument hint;

    public AggregateToCollectionOperation(MongoNamespace namespace, List<BsonDocument> pipeline) {
        this(namespace, pipeline, null, null, AggregationLevel.COLLECTION);
    }

    public AggregateToCollectionOperation(MongoNamespace namespace, List<BsonDocument> pipeline, WriteConcern writeConcern) {
        this(namespace, pipeline, null, writeConcern, AggregationLevel.COLLECTION);
    }

    public AggregateToCollectionOperation(MongoNamespace namespace, List<BsonDocument> pipeline, ReadConcern readConcern) {
        this(namespace, pipeline, readConcern, null, AggregationLevel.COLLECTION);
    }

    public AggregateToCollectionOperation(MongoNamespace namespace, List<BsonDocument> pipeline, ReadConcern readConcern, WriteConcern writeConcern) {
        this(namespace, pipeline, readConcern, writeConcern, AggregationLevel.COLLECTION);
    }

    public AggregateToCollectionOperation(MongoNamespace namespace, List<BsonDocument> pipeline, WriteConcern writeConcern, AggregationLevel aggregationLevel) {
        this(namespace, pipeline, ReadConcern.DEFAULT, writeConcern, aggregationLevel);
    }

    public AggregateToCollectionOperation(MongoNamespace namespace, List<BsonDocument> pipeline, ReadConcern readConcern, WriteConcern writeConcern, AggregationLevel aggregationLevel) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.pipeline = (List) Assertions.notNull("pipeline", pipeline);
        this.writeConcern = writeConcern;
        this.readConcern = readConcern;
        this.aggregationLevel = (AggregationLevel) Assertions.notNull("aggregationLevel", aggregationLevel);
        Assertions.isTrueArgument("pipeline is not empty", !pipeline.isEmpty());
    }

    public List<BsonDocument> getPipeline() {
        return this.pipeline;
    }

    public ReadConcern getReadConcern() {
        return this.readConcern;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public Boolean getAllowDiskUse() {
        return this.allowDiskUse;
    }

    public AggregateToCollectionOperation allowDiskUse(Boolean allowDiskUse) {
        this.allowDiskUse = allowDiskUse;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public AggregateToCollectionOperation maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public AggregateToCollectionOperation bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public AggregateToCollectionOperation collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    public String getComment() {
        return this.comment;
    }

    public AggregateToCollectionOperation comment(String comment) {
        this.comment = comment;
        return this;
    }

    public BsonDocument getHint() {
        return this.hint;
    }

    public AggregateToCollectionOperation hint(BsonDocument hint) {
        this.hint = hint;
        return this;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public Void execute(final WriteBinding binding) {
        return (Void) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<Void>() { // from class: com.mongodb.internal.operation.AggregateToCollectionOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public Void call(Connection connection) {
                OperationHelper.validateCollation(connection, AggregateToCollectionOperation.this.collation);
                return (Void) CommandOperationHelper.executeCommand(binding, AggregateToCollectionOperation.this.namespace.getDatabaseName(), AggregateToCollectionOperation.this.getCommand(connection.getDescription()), connection, CommandOperationHelper.writeConcernErrorTransformer());
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, final SingleResultCallback<Void> callback) {
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.AggregateToCollectionOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<Void> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                    return;
                }
                final SingleResultCallback<Void> wrappedCallback = OperationHelper.releasingCallback(errHandlingCallback, connection);
                OperationHelper.validateCollation(connection, AggregateToCollectionOperation.this.collation, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.AggregateToCollectionOperation.2.1
                    @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
                    public void call(AsyncConnection connection2, Throwable t2) {
                        if (t2 != null) {
                            wrappedCallback.onResult(null, t2);
                        } else {
                            CommandOperationHelper.executeCommandAsync(binding, AggregateToCollectionOperation.this.namespace.getDatabaseName(), AggregateToCollectionOperation.this.getCommand(connection2.getDescription()), connection2, CommandOperationHelper.writeConcernErrorWriteTransformer(), wrappedCallback);
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(ConnectionDescription description) {
        BsonDocument commandDocument = new BsonDocument("aggregate", this.aggregationLevel == AggregationLevel.DATABASE ? new BsonInt32(1) : new BsonString(this.namespace.getCollectionName()));
        commandDocument.put("pipeline", (BsonValue) new BsonArray(this.pipeline));
        if (this.maxTimeMS > 0) {
            commandDocument.put("maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        if (this.allowDiskUse != null) {
            commandDocument.put("allowDiskUse", (BsonValue) BsonBoolean.valueOf(this.allowDiskUse.booleanValue()));
        }
        if (this.bypassDocumentValidation != null && ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(description)) {
            commandDocument.put("bypassDocumentValidation", (BsonValue) BsonBoolean.valueOf(this.bypassDocumentValidation.booleanValue()));
        }
        if (ServerVersionHelper.serverIsAtLeastVersionThreeDotSix(description)) {
            commandDocument.put("cursor", (BsonValue) new BsonDocument());
        }
        WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, commandDocument, description);
        if (this.readConcern != null && !this.readConcern.isServerDefault() && ServerVersionHelper.serverIsAtLeastVersionThreeDotFour(description)) {
            commandDocument.put("readConcern", (BsonValue) this.readConcern.asDocument());
        }
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        if (this.comment != null) {
            commandDocument.put("comment", (BsonValue) new BsonString(this.comment));
        }
        if (this.hint != null) {
            commandDocument.put("hint", (BsonValue) this.hint);
        }
        return commandDocument;
    }
}
