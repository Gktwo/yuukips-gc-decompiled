package com.mongodb.internal.operation;

import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.operation.OperationHelper;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonJavaScript;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.BsonDocumentCodec;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.pattern.parser.Parser;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MapReduceToCollectionOperation.class */
public class MapReduceToCollectionOperation implements AsyncWriteOperation<MapReduceStatistics>, WriteOperation<MapReduceStatistics> {
    private final MongoNamespace namespace;
    private final BsonJavaScript mapFunction;
    private final BsonJavaScript reduceFunction;
    private final String collectionName;
    private final WriteConcern writeConcern;
    private BsonJavaScript finalizeFunction;
    private BsonDocument scope;
    private BsonDocument filter;
    private BsonDocument sort;
    private int limit;
    private boolean jsMode;
    private boolean verbose;
    private long maxTimeMS;
    private String action;
    private String databaseName;
    private boolean sharded;
    private boolean nonAtomic;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private static final List<String> VALID_ACTIONS = Arrays.asList(Parser.REPLACE_CONVERTER_WORD, "merge", "reduce");

    public MapReduceToCollectionOperation(MongoNamespace namespace, BsonJavaScript mapFunction, BsonJavaScript reduceFunction, String collectionName) {
        this(namespace, mapFunction, reduceFunction, collectionName, null);
    }

    public MapReduceToCollectionOperation(MongoNamespace namespace, BsonJavaScript mapFunction, BsonJavaScript reduceFunction, String collectionName, WriteConcern writeConcern) {
        this.action = Parser.REPLACE_CONVERTER_WORD;
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.mapFunction = (BsonJavaScript) Assertions.notNull("mapFunction", mapFunction);
        this.reduceFunction = (BsonJavaScript) Assertions.notNull("reduceFunction", reduceFunction);
        this.collectionName = (String) Assertions.notNull("collectionName", collectionName);
        this.writeConcern = writeConcern;
    }

    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    public BsonJavaScript getMapFunction() {
        return this.mapFunction;
    }

    public BsonJavaScript getReduceFunction() {
        return this.reduceFunction;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public BsonJavaScript getFinalizeFunction() {
        return this.finalizeFunction;
    }

    public MapReduceToCollectionOperation finalizeFunction(BsonJavaScript finalizeFunction) {
        this.finalizeFunction = finalizeFunction;
        return this;
    }

    public BsonDocument getScope() {
        return this.scope;
    }

    public MapReduceToCollectionOperation scope(BsonDocument scope) {
        this.scope = scope;
        return this;
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public MapReduceToCollectionOperation filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public BsonDocument getSort() {
        return this.sort;
    }

    public MapReduceToCollectionOperation sort(BsonDocument sort) {
        this.sort = sort;
        return this;
    }

    public int getLimit() {
        return this.limit;
    }

    public MapReduceToCollectionOperation limit(int limit) {
        this.limit = limit;
        return this;
    }

    public boolean isJsMode() {
        return this.jsMode;
    }

    public MapReduceToCollectionOperation jsMode(boolean jsMode) {
        this.jsMode = jsMode;
        return this;
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public MapReduceToCollectionOperation verbose(boolean verbose) {
        this.verbose = verbose;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public MapReduceToCollectionOperation maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public String getAction() {
        return this.action;
    }

    public MapReduceToCollectionOperation action(String action) {
        Assertions.notNull("action", action);
        Assertions.isTrue("action must be one of: \"replace\", \"merge\", \"reduce\"", VALID_ACTIONS.contains(action));
        this.action = action;
        return this;
    }

    public String getDatabaseName() {
        return this.databaseName;
    }

    public MapReduceToCollectionOperation databaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    public boolean isSharded() {
        return this.sharded;
    }

    public MapReduceToCollectionOperation sharded(boolean sharded) {
        this.sharded = sharded;
        return this;
    }

    public boolean isNonAtomic() {
        return this.nonAtomic;
    }

    public MapReduceToCollectionOperation nonAtomic(boolean nonAtomic) {
        this.nonAtomic = nonAtomic;
        return this;
    }

    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public MapReduceToCollectionOperation bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public MapReduceToCollectionOperation collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public MapReduceStatistics execute(final WriteBinding binding) {
        return (MapReduceStatistics) OperationHelper.withConnection(binding, new OperationHelper.CallableWithConnection<MapReduceStatistics>() { // from class: com.mongodb.internal.operation.MapReduceToCollectionOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnection
            public MapReduceStatistics call(Connection connection) {
                OperationHelper.validateCollation(connection, MapReduceToCollectionOperation.this.collation);
                return (MapReduceStatistics) CommandOperationHelper.executeCommand(binding, MapReduceToCollectionOperation.this.namespace.getDatabaseName(), MapReduceToCollectionOperation.this.getCommand(connection.getDescription()), connection, MapReduceToCollectionOperation.this.transformer());
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, final SingleResultCallback<MapReduceStatistics> callback) {
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.MapReduceToCollectionOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection, Throwable t) {
                SingleResultCallback<MapReduceStatistics> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                    return;
                }
                final SingleResultCallback<MapReduceStatistics> wrappedCallback = OperationHelper.releasingCallback(errHandlingCallback, connection);
                OperationHelper.validateCollation(connection, MapReduceToCollectionOperation.this.collation, new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.MapReduceToCollectionOperation.2.1
                    @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
                    public void call(AsyncConnection connection2, Throwable t2) {
                        if (t2 != null) {
                            wrappedCallback.onResult(null, t2);
                        } else {
                            CommandOperationHelper.executeCommandAsync(binding, MapReduceToCollectionOperation.this.namespace.getDatabaseName(), MapReduceToCollectionOperation.this.getCommand(connection2.getDescription()), connection2, MapReduceToCollectionOperation.this.transformerAsync(), wrappedCallback);
                        }
                    }
                });
            }
        });
    }

    public ReadOperation<BsonDocument> asExplainableOperation(ExplainVerbosity explainVerbosity) {
        return createExplainableOperation(explainVerbosity);
    }

    public AsyncReadOperation<BsonDocument> asExplainableOperationAsync(ExplainVerbosity explainVerbosity) {
        return createExplainableOperation(explainVerbosity);
    }

    private CommandReadOperation<BsonDocument> createExplainableOperation(ExplainVerbosity explainVerbosity) {
        return new CommandReadOperation<>(this.namespace.getDatabaseName(), ExplainHelper.asExplainCommand(getCommand(null), explainVerbosity), new BsonDocumentCodec());
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandWriteTransformer<BsonDocument, MapReduceStatistics> transformer() {
        return new CommandOperationHelper.CommandWriteTransformer<BsonDocument, MapReduceStatistics>() { // from class: com.mongodb.internal.operation.MapReduceToCollectionOperation.3
            public MapReduceStatistics apply(BsonDocument result, Connection connection) {
                WriteConcernHelper.throwOnWriteConcernError(result, connection.getDescription().getServerAddress(), connection.getDescription().getMaxWireVersion());
                return MapReduceHelper.createStatistics(result);
            }
        };
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandWriteTransformerAsync<BsonDocument, MapReduceStatistics> transformerAsync() {
        return new CommandOperationHelper.CommandWriteTransformerAsync<BsonDocument, MapReduceStatistics>() { // from class: com.mongodb.internal.operation.MapReduceToCollectionOperation.4
            public MapReduceStatistics apply(BsonDocument result, AsyncConnection connection) {
                WriteConcernHelper.throwOnWriteConcernError(result, connection.getDescription().getServerAddress(), connection.getDescription().getMaxWireVersion());
                return MapReduceHelper.createStatistics(result);
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(ConnectionDescription description) {
        BsonDocument outputDocument = new BsonDocument(getAction(), new BsonString(getCollectionName()));
        if (description != null && !ServerVersionHelper.serverIsAtLeastVersionFourDotFour(description)) {
            DocumentHelper.putIfTrue(outputDocument, "sharded", isSharded());
            DocumentHelper.putIfTrue(outputDocument, "nonAtomic", isNonAtomic());
        }
        if (getDatabaseName() != null) {
            outputDocument.put("db", (BsonValue) new BsonString(getDatabaseName()));
        }
        BsonDocument commandDocument = new BsonDocument("mapreduce", new BsonString(this.namespace.getCollectionName())).append("map", getMapFunction()).append("reduce", getReduceFunction()).append("out", outputDocument);
        DocumentHelper.putIfNotNull(commandDocument, "query", getFilter());
        DocumentHelper.putIfNotNull(commandDocument, "sort", getSort());
        DocumentHelper.putIfNotNull(commandDocument, "finalize", getFinalizeFunction());
        DocumentHelper.putIfNotNull(commandDocument, Action.SCOPE_ATTRIBUTE, getScope());
        DocumentHelper.putIfTrue(commandDocument, "verbose", isVerbose());
        DocumentHelper.putIfNotZero(commandDocument, "limit", getLimit());
        DocumentHelper.putIfNotZero(commandDocument, "maxTimeMS", getMaxTime(TimeUnit.MILLISECONDS));
        DocumentHelper.putIfTrue(commandDocument, "jsMode", isJsMode());
        if (!(this.bypassDocumentValidation == null || description == null || !ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(description))) {
            commandDocument.put("bypassDocumentValidation", (BsonValue) BsonBoolean.valueOf(this.bypassDocumentValidation.booleanValue()));
        }
        if (description != null) {
            WriteConcernHelper.appendWriteConcernToCommand(this.writeConcern, commandDocument, description);
        }
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        return commandDocument;
    }
}
