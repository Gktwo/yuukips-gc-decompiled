package com.mongodb.internal.operation;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
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
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.operation.CommandOperationHelper;
import com.mongodb.internal.operation.OperationHelper;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ListIndexesOperation.class */
public class ListIndexesOperation<T> implements AsyncReadOperation<AsyncBatchCursor<T>>, ReadOperation<BatchCursor<T>> {
    private final MongoNamespace namespace;
    private final Decoder<T> decoder;
    private boolean retryReads;
    private int batchSize;
    private long maxTimeMS;

    public ListIndexesOperation(MongoNamespace namespace, Decoder<T> decoder) {
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    public Integer getBatchSize() {
        return Integer.valueOf(this.batchSize);
    }

    public ListIndexesOperation<T> batchSize(int batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public ListIndexesOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public ListIndexesOperation<T> retryReads(boolean retryReads) {
        this.retryReads = retryReads;
        return this;
    }

    public boolean getRetryReads() {
        return this.retryReads;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public BatchCursor<T> execute(final ReadBinding binding) {
        return (BatchCursor) OperationHelper.withReadConnectionSource(binding, new OperationHelper.CallableWithSource<BatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListIndexesOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithSource
            public BatchCursor<T> call(ConnectionSource source) {
                Connection connection = source.getConnection();
                if (ServerVersionHelper.serverIsAtLeastVersionThreeDotZero(connection.getDescription())) {
                    try {
                        return (BatchCursor) CommandOperationHelper.executeCommandWithConnection(binding, source, ListIndexesOperation.this.namespace.getDatabaseName(), ListIndexesOperation.this.getCommandCreator(), ListIndexesOperation.this.createCommandDecoder(), ListIndexesOperation.this.transformer(), ListIndexesOperation.this.retryReads, connection);
                    } catch (MongoCommandException e) {
                        return (BatchCursor) CommandOperationHelper.rethrowIfNotNamespaceError(e, OperationHelper.createEmptyBatchCursor(ListIndexesOperation.this.namespace, ListIndexesOperation.this.decoder, source.getServerDescription().getAddress(), ListIndexesOperation.this.batchSize));
                    }
                } else {
                    try {
                        QueryBatchCursor queryBatchCursor = new QueryBatchCursor(connection.query(ListIndexesOperation.this.getIndexNamespace(), ListIndexesOperation.this.asQueryDocument(connection.getDescription(), binding.getReadPreference()), null, 0, 0, ListIndexesOperation.this.batchSize, binding.getReadPreference().isSlaveOk(), false, false, false, false, false, ListIndexesOperation.this.decoder), 0, ListIndexesOperation.this.batchSize, ListIndexesOperation.this.decoder, source);
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
        OperationHelper.withAsyncReadConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.ListIndexesOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
            public void call(final AsyncConnectionSource source, final AsyncConnection connection, Throwable t) {
                final SingleResultCallback<AsyncBatchCursor<T>> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                } else if (ServerVersionHelper.serverIsAtLeastVersionThreeDotZero(connection.getDescription())) {
                    CommandOperationHelper.executeCommandAsyncWithConnection(binding, source, ListIndexesOperation.this.namespace.getDatabaseName(), ListIndexesOperation.this.getCommandCreator(), ListIndexesOperation.this.createCommandDecoder(), ListIndexesOperation.this.asyncTransformer(), ListIndexesOperation.this.retryReads, connection, new SingleResultCallback<AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListIndexesOperation.2.1
                        @Override // com.mongodb.internal.async.SingleResultCallback
                        public /* bridge */ /* synthetic */ void onResult(Object obj, Throwable th) {
                            onResult((AsyncBatchCursor) ((AsyncBatchCursor) obj), th);
                        }

                        public void onResult(AsyncBatchCursor<T> result, Throwable t2) {
                            if (t2 == null || CommandOperationHelper.isNamespaceError(t2)) {
                                errHandlingCallback.onResult(result != null ? result : ListIndexesOperation.this.emptyAsyncCursor(source), null);
                            } else {
                                errHandlingCallback.onResult(null, t2);
                            }
                        }
                    });
                } else {
                    final SingleResultCallback<AsyncBatchCursor<T>> wrappedCallback = OperationHelper.releasingCallback(errHandlingCallback, source, connection);
                    connection.queryAsync(ListIndexesOperation.this.getIndexNamespace(), ListIndexesOperation.this.asQueryDocument(connection.getDescription(), binding.getReadPreference()), null, 0, 0, ListIndexesOperation.this.batchSize, binding.getReadPreference().isSlaveOk(), false, false, false, false, false, ListIndexesOperation.this.decoder, new SingleResultCallback<QueryResult<T>>() { // from class: com.mongodb.internal.operation.ListIndexesOperation.2.2
                        @Override // com.mongodb.internal.async.SingleResultCallback
                        public /* bridge */ /* synthetic */ void onResult(Object obj, Throwable th) {
                            onResult((QueryResult) ((QueryResult) obj), th);
                        }

                        public void onResult(QueryResult<T> result, Throwable t2) {
                            if (t2 != null) {
                                wrappedCallback.onResult(null, t2);
                            } else {
                                wrappedCallback.onResult(new AsyncQueryBatchCursor(result, 0, ListIndexesOperation.this.batchSize, 0, ListIndexesOperation.this.decoder, source, connection), null);
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public AsyncBatchCursor<T> emptyAsyncCursor(AsyncConnectionSource source) {
        return OperationHelper.createEmptyAsyncBatchCursor(this.namespace, source.getServerDescription().getAddress());
    }

    /* access modifiers changed from: private */
    public BsonDocument asQueryDocument(ConnectionDescription connectionDescription, ReadPreference readPreference) {
        BsonDocument document = new BsonDocument("$query", new BsonDocument("ns", new BsonString(this.namespace.getFullName())));
        if (this.maxTimeMS > 0) {
            document.put("$maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        if (connectionDescription.getServerType() == ServerType.SHARD_ROUTER && !readPreference.equals(ReadPreference.primary())) {
            document.put("$readPreference", (BsonValue) readPreference.toDocument());
        }
        return document;
    }

    /* access modifiers changed from: private */
    public MongoNamespace getIndexNamespace() {
        return new MongoNamespace(this.namespace.getDatabaseName(), "system.indexes");
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandCreator getCommandCreator() {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.ListIndexesOperation.3
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                return ListIndexesOperation.this.getCommand();
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand() {
        BsonDocument command = new BsonDocument("listIndexes", new BsonString(this.namespace.getCollectionName())).append("cursor", CursorHelper.getCursorDocumentFromBatchSize(this.batchSize == 0 ? null : Integer.valueOf(this.batchSize)));
        if (this.maxTimeMS > 0) {
            command.put("maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        return command;
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>> transformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListIndexesOperation.4
            public BatchCursor<T> apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return OperationHelper.cursorDocumentToBatchCursor(result.getDocument("cursor"), ListIndexesOperation.this.decoder, source, ListIndexesOperation.this.batchSize);
            }
        };
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListIndexesOperation.5
            public AsyncBatchCursor<T> apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return OperationHelper.cursorDocumentToAsyncBatchCursor(result.getDocument("cursor"), ListIndexesOperation.this.decoder, source, connection, ListIndexesOperation.this.batchSize);
            }
        };
    }

    /* access modifiers changed from: private */
    public Codec<BsonDocument> createCommandDecoder() {
        return CommandResultDocumentCodec.create(this.decoder, "firstBatch");
    }
}
