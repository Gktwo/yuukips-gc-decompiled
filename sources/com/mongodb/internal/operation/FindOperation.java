package com.mongodb.internal.operation;

import com.mongodb.CursorType;
import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoNamespace;
import com.mongodb.MongoQueryException;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerType;
import com.mongodb.internal.async.AsyncBatchCursor;
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
import com.mongodb.internal.operation.OperationHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/FindOperation.class */
public class FindOperation<T> implements AsyncExplainableReadOperation<AsyncBatchCursor<T>>, ExplainableReadOperation<BatchCursor<T>> {
    private static final String FIRST_BATCH = "firstBatch";
    private final MongoNamespace namespace;
    private final Decoder<T> decoder;
    private boolean retryReads;
    private BsonDocument filter;
    private int batchSize;
    private int limit;
    private BsonDocument projection;
    private long maxTimeMS;
    private long maxAwaitTimeMS;
    private int skip;
    private BsonDocument sort;
    private CursorType cursorType = CursorType.NonTailable;
    private boolean slaveOk;
    private boolean oplogReplay;
    private boolean noCursorTimeout;
    private boolean partial;
    private Collation collation;
    private String comment;
    private BsonValue hint;
    private BsonDocument max;
    private BsonDocument min;
    private boolean returnKey;
    private boolean showRecordId;
    private Boolean allowDiskUse;

    public FindOperation(MongoNamespace namespace, Decoder<T> decoder) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    public Decoder<T> getDecoder() {
        return this.decoder;
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public FindOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public int getBatchSize() {
        return this.batchSize;
    }

    public FindOperation<T> batchSize(int batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    public int getLimit() {
        return this.limit;
    }

    public FindOperation<T> limit(int limit) {
        this.limit = limit;
        return this;
    }

    public BsonDocument getProjection() {
        return this.projection;
    }

    public FindOperation<T> projection(BsonDocument projection) {
        this.projection = projection;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public FindOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxTime >= 0", maxTime >= 0);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public long getMaxAwaitTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxAwaitTimeMS, TimeUnit.MILLISECONDS);
    }

    public FindOperation<T> maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        Assertions.isTrueArgument("maxAwaitTime >= 0", maxAwaitTime >= 0);
        this.maxAwaitTimeMS = TimeUnit.MILLISECONDS.convert(maxAwaitTime, timeUnit);
        return this;
    }

    public int getSkip() {
        return this.skip;
    }

    public FindOperation<T> skip(int skip) {
        this.skip = skip;
        return this;
    }

    public BsonDocument getSort() {
        return this.sort;
    }

    public FindOperation<T> sort(BsonDocument sort) {
        this.sort = sort;
        return this;
    }

    public CursorType getCursorType() {
        return this.cursorType;
    }

    public FindOperation<T> cursorType(CursorType cursorType) {
        this.cursorType = (CursorType) Assertions.notNull("cursorType", cursorType);
        return this;
    }

    public boolean isSlaveOk() {
        return this.slaveOk;
    }

    public FindOperation<T> slaveOk(boolean slaveOk) {
        this.slaveOk = slaveOk;
        return this;
    }

    public boolean isOplogReplay() {
        return this.oplogReplay;
    }

    public FindOperation<T> oplogReplay(boolean oplogReplay) {
        this.oplogReplay = oplogReplay;
        return this;
    }

    public boolean isNoCursorTimeout() {
        return this.noCursorTimeout;
    }

    public FindOperation<T> noCursorTimeout(boolean noCursorTimeout) {
        this.noCursorTimeout = noCursorTimeout;
        return this;
    }

    public boolean isPartial() {
        return this.partial;
    }

    public FindOperation<T> partial(boolean partial) {
        this.partial = partial;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public FindOperation<T> collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    public String getComment() {
        return this.comment;
    }

    public FindOperation<T> comment(String comment) {
        this.comment = comment;
        return this;
    }

    public BsonValue getHint() {
        return this.hint;
    }

    public FindOperation<T> hint(BsonValue hint) {
        this.hint = hint;
        return this;
    }

    public BsonDocument getMax() {
        return this.max;
    }

    public FindOperation<T> max(BsonDocument max) {
        this.max = max;
        return this;
    }

    public BsonDocument getMin() {
        return this.min;
    }

    public FindOperation<T> min(BsonDocument min) {
        this.min = min;
        return this;
    }

    public boolean isReturnKey() {
        return this.returnKey;
    }

    public FindOperation<T> returnKey(boolean returnKey) {
        this.returnKey = returnKey;
        return this;
    }

    public boolean isShowRecordId() {
        return this.showRecordId;
    }

    public FindOperation<T> showRecordId(boolean showRecordId) {
        this.showRecordId = showRecordId;
        return this;
    }

    public FindOperation<T> retryReads(boolean retryReads) {
        this.retryReads = retryReads;
        return this;
    }

    public boolean getRetryReads() {
        return this.retryReads;
    }

    public Boolean isAllowDiskUse() {
        return this.allowDiskUse;
    }

    public FindOperation<T> allowDiskUse(@Nullable Boolean allowDiskUse) {
        this.allowDiskUse = allowDiskUse;
        return this;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public BatchCursor<T> execute(final ReadBinding binding) {
        return (BatchCursor) OperationHelper.withReadConnectionSource(binding, new OperationHelper.CallableWithSource<BatchCursor<T>>() { // from class: com.mongodb.internal.operation.FindOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithSource
            public BatchCursor<T> call(ConnectionSource source) {
                Connection connection = source.getConnection();
                if (ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connection.getDescription())) {
                    try {
                        return (BatchCursor) CommandOperationHelper.executeCommandWithConnection(binding, source, FindOperation.this.namespace.getDatabaseName(), FindOperation.this.getCommandCreator(binding.getSessionContext()), CommandResultDocumentCodec.create(FindOperation.this.decoder, FindOperation.FIRST_BATCH), FindOperation.this.transformer(), FindOperation.this.retryReads, connection);
                    } catch (MongoCommandException e) {
                        throw new MongoQueryException(e);
                    }
                } else {
                    try {
                        OperationHelper.validateFindOptions(connection, binding.getSessionContext().getReadConcern(), FindOperation.this.collation, FindOperation.this.allowDiskUse);
                        QueryBatchCursor queryBatchCursor = new QueryBatchCursor(connection.query(FindOperation.this.namespace, FindOperation.this.asDocument(connection.getDescription(), binding.getReadPreference()), FindOperation.this.projection, FindOperation.this.skip, FindOperation.this.limit, FindOperation.this.batchSize, FindOperation.this.isSlaveOk() || binding.getReadPreference().isSlaveOk(), FindOperation.this.isTailableCursor(), FindOperation.this.isAwaitData(), FindOperation.this.isNoCursorTimeout(), FindOperation.this.isPartial(), FindOperation.this.isOplogReplay(), FindOperation.this.decoder), FindOperation.this.limit, FindOperation.this.batchSize, FindOperation.this.getMaxTimeForCursor(), FindOperation.this.decoder, source, connection);
                        connection.release();
                        return queryBatchCursor;
                    } catch (Throwable th) {
                        connection.release();
                        throw th;
                    }
                }
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncReadOperation
    public void executeAsync(final AsyncReadBinding binding, final SingleResultCallback<AsyncBatchCursor<T>> callback) {
        OperationHelper.withAsyncReadConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.FindOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
            public void call(AsyncConnectionSource source, AsyncConnection connection, Throwable t) {
                SingleResultCallback<AsyncBatchCursor<T>> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                } else if (ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connection.getDescription())) {
                    CommandOperationHelper.executeCommandAsyncWithConnection(binding, source, FindOperation.this.namespace.getDatabaseName(), FindOperation.this.getCommandCreator(binding.getSessionContext()), CommandResultDocumentCodec.create(FindOperation.this.decoder, FindOperation.FIRST_BATCH), FindOperation.this.asyncTransformer(), FindOperation.this.retryReads, connection, FindOperation.exceptionTransformingCallback(errHandlingCallback));
                } else {
                    final SingleResultCallback<AsyncBatchCursor<T>> wrappedCallback = OperationHelper.releasingCallback(errHandlingCallback, source, connection);
                    OperationHelper.validateFindOptions(source, connection, binding.getSessionContext().getReadConcern(), FindOperation.this.collation, FindOperation.this.allowDiskUse, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.FindOperation.2.1
                        @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
                        public void call(final AsyncConnectionSource source2, final AsyncConnection connection2, Throwable t2) {
                            if (t2 != null) {
                                wrappedCallback.onResult(null, t2);
                            } else {
                                connection2.queryAsync(FindOperation.this.namespace, FindOperation.this.asDocument(connection2.getDescription(), binding.getReadPreference()), FindOperation.this.projection, FindOperation.this.skip, FindOperation.this.limit, FindOperation.this.batchSize, FindOperation.this.isSlaveOk() || binding.getReadPreference().isSlaveOk(), FindOperation.this.isTailableCursor(), FindOperation.this.isAwaitData(), FindOperation.this.isNoCursorTimeout(), FindOperation.this.isPartial(), FindOperation.this.isOplogReplay(), FindOperation.this.decoder, new SingleResultCallback<QueryResult<T>>() { // from class: com.mongodb.internal.operation.FindOperation.2.1.1
                                    @Override // com.mongodb.internal.async.SingleResultCallback
                                    public /* bridge */ /* synthetic */ void onResult(Object obj, Throwable th) {
                                        onResult((QueryResult) ((QueryResult) obj), th);
                                    }

                                    public void onResult(QueryResult<T> result, Throwable t3) {
                                        if (t3 != null) {
                                            wrappedCallback.onResult(null, t3);
                                        } else {
                                            wrappedCallback.onResult(new AsyncQueryBatchCursor(result, FindOperation.this.limit, FindOperation.this.batchSize, FindOperation.this.getMaxTimeForCursor(), FindOperation.this.decoder, source2, connection2), null);
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static <T> SingleResultCallback<T> exceptionTransformingCallback(final SingleResultCallback<T> callback) {
        return new SingleResultCallback<T>() { // from class: com.mongodb.internal.operation.FindOperation.3
            @Override // com.mongodb.internal.async.SingleResultCallback
            public void onResult(T result, Throwable t) {
                if (t == null) {
                    SingleResultCallback.this.onResult(result, null);
                } else if (t instanceof MongoCommandException) {
                    MongoCommandException commandException = (MongoCommandException) t;
                    SingleResultCallback.this.onResult(result, new MongoQueryException(commandException.getServerAddress(), commandException.getErrorCode(), commandException.getErrorMessage()));
                } else {
                    SingleResultCallback.this.onResult(result, t);
                }
            }
        };
    }

    @Override // com.mongodb.internal.operation.ExplainableReadOperation
    public <R> ReadOperation<R> asExplainableOperation(@Nullable ExplainVerbosity verbosity, Decoder<R> resultDecoder) {
        return new CommandReadOperation(getNamespace().getDatabaseName(), ExplainHelper.asExplainCommand(getCommand(NoOpSessionContext.INSTANCE), verbosity), resultDecoder);
    }

    @Override // com.mongodb.internal.operation.AsyncExplainableReadOperation
    public <R> AsyncReadOperation<R> asAsyncExplainableOperation(@Nullable ExplainVerbosity verbosity, Decoder<R> resultDecoder) {
        return new CommandReadOperation(getNamespace().getDatabaseName(), ExplainHelper.asExplainCommand(getCommand(NoOpSessionContext.INSTANCE), verbosity), resultDecoder);
    }

    /* access modifiers changed from: private */
    public BsonDocument asDocument(ConnectionDescription connectionDescription, ReadPreference readPreference) {
        BsonDocument document = new BsonDocument();
        if (this.sort != null) {
            document.put("$orderby", (BsonValue) this.sort);
        }
        if (this.maxTimeMS > 0) {
            document.put("$maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        if (connectionDescription.getServerType() == ServerType.SHARD_ROUTER && !readPreference.equals(ReadPreference.primary())) {
            document.put("$readPreference", (BsonValue) readPreference.toDocument());
        }
        if (this.comment != null) {
            document.put("$comment", (BsonValue) new BsonString(this.comment));
        }
        if (this.hint != null) {
            document.put("$hint", this.hint);
        }
        if (this.max != null) {
            document.put("$max", (BsonValue) this.max);
        }
        if (this.min != null) {
            document.put("$min", (BsonValue) this.min);
        }
        if (this.returnKey) {
            document.put("$returnKey", (BsonValue) BsonBoolean.TRUE);
        }
        if (this.showRecordId) {
            document.put("$showDiskLoc", (BsonValue) BsonBoolean.TRUE);
        }
        if (document.isEmpty()) {
            document = this.filter != null ? this.filter : new BsonDocument();
        } else if (this.filter != null) {
            document.put("$query", (BsonValue) this.filter);
        } else if (!document.containsKey("$query")) {
            document.put("$query", (BsonValue) new BsonDocument());
        }
        return document;
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand(SessionContext sessionContext) {
        BsonDocument commandDocument = new BsonDocument("find", new BsonString(this.namespace.getCollectionName()));
        OperationReadConcernHelper.appendReadConcernToCommand(sessionContext, commandDocument);
        DocumentHelper.putIfNotNull(commandDocument, "filter", this.filter);
        DocumentHelper.putIfNotNullOrEmpty(commandDocument, "sort", this.sort);
        DocumentHelper.putIfNotNullOrEmpty(commandDocument, "projection", this.projection);
        if (this.skip > 0) {
            commandDocument.put("skip", (BsonValue) new BsonInt32(this.skip));
        }
        if (this.limit != 0) {
            commandDocument.put("limit", (BsonValue) new BsonInt32(Math.abs(this.limit)));
        }
        if (this.limit >= 0) {
            if (this.batchSize < 0 && Math.abs(this.batchSize) < this.limit) {
                commandDocument.put("limit", (BsonValue) new BsonInt32(Math.abs(this.batchSize)));
            } else if (this.batchSize != 0) {
                commandDocument.put("batchSize", (BsonValue) new BsonInt32(Math.abs(this.batchSize)));
            }
        }
        if (this.limit < 0 || this.batchSize < 0) {
            commandDocument.put("singleBatch", (BsonValue) BsonBoolean.TRUE);
        }
        if (this.maxTimeMS > 0) {
            commandDocument.put("maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        if (isTailableCursor()) {
            commandDocument.put("tailable", (BsonValue) BsonBoolean.TRUE);
        }
        if (isAwaitData()) {
            commandDocument.put("awaitData", (BsonValue) BsonBoolean.TRUE);
        }
        if (this.oplogReplay) {
            commandDocument.put("oplogReplay", (BsonValue) BsonBoolean.TRUE);
        }
        if (this.noCursorTimeout) {
            commandDocument.put("noCursorTimeout", (BsonValue) BsonBoolean.TRUE);
        }
        if (this.partial) {
            commandDocument.put("allowPartialResults", (BsonValue) BsonBoolean.TRUE);
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
        if (this.max != null) {
            commandDocument.put("max", (BsonValue) this.max);
        }
        if (this.min != null) {
            commandDocument.put("min", (BsonValue) this.min);
        }
        if (this.returnKey) {
            commandDocument.put("returnKey", (BsonValue) BsonBoolean.TRUE);
        }
        if (this.showRecordId) {
            commandDocument.put("showRecordId", (BsonValue) BsonBoolean.TRUE);
        }
        if (this.allowDiskUse != null) {
            commandDocument.put("allowDiskUse", (BsonValue) BsonBoolean.valueOf(this.allowDiskUse.booleanValue()));
        }
        return commandDocument;
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandCreator getCommandCreator(final SessionContext sessionContext) {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.FindOperation.4
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                OperationHelper.validateFindOptions(connectionDescription, sessionContext.getReadConcern(), FindOperation.this.collation, FindOperation.this.allowDiskUse);
                return FindOperation.this.getCommand(sessionContext);
            }
        };
    }

    /* access modifiers changed from: private */
    public boolean isTailableCursor() {
        return this.cursorType.isTailable();
    }

    /* access modifiers changed from: private */
    public boolean isAwaitData() {
        return this.cursorType == CursorType.TailableAwait;
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandReadTransformer<BsonDocument, AggregateResponseBatchCursor<T>> transformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, AggregateResponseBatchCursor<T>>() { // from class: com.mongodb.internal.operation.FindOperation.5
            public AggregateResponseBatchCursor<T> apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return new QueryBatchCursor(OperationHelper.cursorDocumentToQueryResult(result.getDocument("cursor"), connection.getDescription().getServerAddress()), FindOperation.this.limit, FindOperation.this.batchSize, FindOperation.this.getMaxTimeForCursor(), FindOperation.this.decoder, source, connection, result);
            }
        };
    }

    /* access modifiers changed from: private */
    public long getMaxTimeForCursor() {
        if (this.cursorType == CursorType.TailableAwait) {
            return this.maxAwaitTimeMS;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.FindOperation.6
            public AsyncBatchCursor<T> apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return new AsyncQueryBatchCursor(OperationHelper.cursorDocumentToQueryResult(result.getDocument("cursor"), connection.getDescription().getServerAddress()), FindOperation.this.limit, FindOperation.this.batchSize, FindOperation.this.getMaxTimeForCursor(), FindOperation.this.decoder, source, connection, result);
            }
        };
    }
}
