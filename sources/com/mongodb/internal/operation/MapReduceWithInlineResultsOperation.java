package com.mongodb.internal.operation;

import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoNamespace;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.NoOpSessionContext;
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.session.SessionContext;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonJavaScript;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Decoder;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MapReduceWithInlineResultsOperation.class */
public class MapReduceWithInlineResultsOperation<T> implements AsyncReadOperation<MapReduceAsyncBatchCursor<T>>, ReadOperation<MapReduceBatchCursor<T>> {
    private final MongoNamespace namespace;
    private final BsonJavaScript mapFunction;
    private final BsonJavaScript reduceFunction;
    private final Decoder<T> decoder;
    private BsonJavaScript finalizeFunction;
    private BsonDocument scope;
    private BsonDocument filter;
    private BsonDocument sort;
    private int limit;
    private boolean jsMode;
    private boolean verbose;
    private long maxTimeMS;
    private Collation collation;

    public MapReduceWithInlineResultsOperation(MongoNamespace namespace, BsonJavaScript mapFunction, BsonJavaScript reduceFunction, Decoder<T> decoder) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.mapFunction = (BsonJavaScript) Assertions.notNull("mapFunction", mapFunction);
        this.reduceFunction = (BsonJavaScript) Assertions.notNull("reduceFunction", reduceFunction);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    public Decoder<T> getDecoder() {
        return this.decoder;
    }

    public BsonJavaScript getMapFunction() {
        return this.mapFunction;
    }

    public BsonJavaScript getReduceFunction() {
        return this.reduceFunction;
    }

    public BsonJavaScript getFinalizeFunction() {
        return this.finalizeFunction;
    }

    public MapReduceWithInlineResultsOperation<T> finalizeFunction(BsonJavaScript finalizeFunction) {
        this.finalizeFunction = finalizeFunction;
        return this;
    }

    public BsonDocument getScope() {
        return this.scope;
    }

    public MapReduceWithInlineResultsOperation<T> scope(BsonDocument scope) {
        this.scope = scope;
        return this;
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public MapReduceWithInlineResultsOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public BsonDocument getSort() {
        return this.sort;
    }

    public MapReduceWithInlineResultsOperation<T> sort(BsonDocument sort) {
        this.sort = sort;
        return this;
    }

    public int getLimit() {
        return this.limit;
    }

    public MapReduceWithInlineResultsOperation<T> limit(int limit) {
        this.limit = limit;
        return this;
    }

    public boolean isJsMode() {
        return this.jsMode;
    }

    public MapReduceWithInlineResultsOperation<T> jsMode(boolean jsMode) {
        this.jsMode = jsMode;
        return this;
    }

    public boolean isVerbose() {
        return this.verbose;
    }

    public MapReduceWithInlineResultsOperation<T> verbose(boolean verbose) {
        this.verbose = verbose;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public MapReduceWithInlineResultsOperation<T> collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public MapReduceWithInlineResultsOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public MapReduceBatchCursor<T> execute(ReadBinding binding) {
        return (MapReduceBatchCursor) CommandOperationHelper.executeCommand(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), (Decoder) CommandResultDocumentCodec.create(this.decoder, "results"), (CommandOperationHelper.CommandReadTransformer<D, Object>) transformer(), false);
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(AsyncReadBinding binding, SingleResultCallback<MapReduceAsyncBatchCursor<T>> callback) {
        CommandOperationHelper.executeCommandAsync(binding, this.namespace.getDatabaseName(), getCommandCreator(binding.getSessionContext()), (Decoder) CommandResultDocumentCodec.create(this.decoder, "results"), (CommandOperationHelper.CommandReadTransformerAsync) asyncTransformer(), false, (SingleResultCallback) ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER));
    }

    public ReadOperation<BsonDocument> asExplainableOperation(ExplainVerbosity explainVerbosity) {
        return createExplainableOperation(explainVerbosity);
    }

    public AsyncReadOperation<BsonDocument> asExplainableOperationAsync(ExplainVerbosity explainVerbosity) {
        return createExplainableOperation(explainVerbosity);
    }

    private CommandReadOperation<BsonDocument> createExplainableOperation(ExplainVerbosity explainVerbosity) {
        return new CommandReadOperation<>(this.namespace.getDatabaseName(), ExplainHelper.asExplainCommand(getCommand(NoOpSessionContext.INSTANCE), explainVerbosity), new BsonDocumentCodec());
    }

    private CommandOperationHelper.CommandReadTransformer<BsonDocument, MapReduceBatchCursor<T>> transformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, MapReduceBatchCursor<T>>() { // from class: com.mongodb.internal.operation.MapReduceWithInlineResultsOperation.1
            public MapReduceBatchCursor<T> apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return new MapReduceInlineResultsCursor(MapReduceWithInlineResultsOperation.this.createQueryResult(result, connection.getDescription()), MapReduceWithInlineResultsOperation.this.decoder, source, MapReduceHelper.createStatistics(result));
            }
        };
    }

    private CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, MapReduceAsyncBatchCursor<T>> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, MapReduceAsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.MapReduceWithInlineResultsOperation.2
            public MapReduceAsyncBatchCursor<T> apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return new MapReduceInlineResultsAsyncCursor(MapReduceWithInlineResultsOperation.this.createQueryResult(result, connection.getDescription()), MapReduceHelper.createStatistics(result));
            }
        };
    }

    private CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.MapReduceWithInlineResultsOperation.3
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                OperationHelper.validateReadConcernAndCollation(connectionDescription, sessionContext.getReadConcern(), MapReduceWithInlineResultsOperation.this.collation);
                return MapReduceWithInlineResultsOperation.this.getCommand(sessionContext);
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(SessionContext sessionContext) {
        BsonDocument commandDocument = new BsonDocument("mapreduce", new BsonString(this.namespace.getCollectionName())).append("map", getMapFunction()).append("reduce", getReduceFunction()).append("out", new BsonDocument("inline", new BsonInt32(1)));
        DocumentHelper.putIfNotNull(commandDocument, "query", getFilter());
        DocumentHelper.putIfNotNull(commandDocument, "sort", getSort());
        DocumentHelper.putIfNotNull(commandDocument, "finalize", getFinalizeFunction());
        DocumentHelper.putIfNotNull(commandDocument, Action.SCOPE_ATTRIBUTE, getScope());
        DocumentHelper.putIfTrue(commandDocument, "verbose", isVerbose());
        OperationReadConcernHelper.appendReadConcernToCommand(sessionContext, commandDocument);
        DocumentHelper.putIfNotZero(commandDocument, "limit", getLimit());
        DocumentHelper.putIfNotZero(commandDocument, "maxTimeMS", getMaxTime(TimeUnit.MILLISECONDS));
        DocumentHelper.putIfTrue(commandDocument, "jsMode", isJsMode());
        if (this.collation != null) {
            commandDocument.put("collation", (BsonValue) this.collation.asDocument());
        }
        return commandDocument;
    }

    /* access modifiers changed from: private */
    public QueryResult<T> createQueryResult(BsonDocument result, ConnectionDescription description) {
        return new QueryResult<>(this.namespace, BsonDocumentWrapperHelper.toList(result, "results"), 0, description.getServerAddress());
    }
}
