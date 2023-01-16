package com.mongodb.internal.operation;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoNamespace;
import com.mongodb.QueryOperators;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
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
import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonDocumentReader;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonRegularExpression;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Codec;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ListCollectionsOperation.class */
public class ListCollectionsOperation<T> implements AsyncReadOperation<AsyncBatchCursor<T>>, ReadOperation<BatchCursor<T>> {
    private final String databaseName;
    private final Decoder<T> decoder;
    private boolean retryReads;
    private BsonDocument filter;
    private int batchSize;
    private long maxTimeMS;
    private boolean nameOnly;

    public ListCollectionsOperation(String databaseName, Decoder<T> decoder) {
        this.databaseName = (String) Assertions.notNull("databaseName", databaseName);
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public boolean isNameOnly() {
        return this.nameOnly;
    }

    public ListCollectionsOperation<T> filter(BsonDocument filter) {
        this.filter = filter;
        return this;
    }

    public ListCollectionsOperation<T> nameOnly(boolean nameOnly) {
        this.nameOnly = nameOnly;
        return this;
    }

    public Integer getBatchSize() {
        return Integer.valueOf(this.batchSize);
    }

    public ListCollectionsOperation<T> batchSize(int batchSize) {
        this.batchSize = batchSize;
        return this;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public ListCollectionsOperation<T> maxTime(long maxTime, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
        return this;
    }

    public ListCollectionsOperation<T> retryReads(boolean retryReads) {
        this.retryReads = retryReads;
        return this;
    }

    public boolean getRetryReads() {
        return this.retryReads;
    }

    @Override // com.mongodb.internal.operation.ReadOperation
    public BatchCursor<T> execute(final ReadBinding binding) {
        return (BatchCursor) OperationHelper.withReadConnectionSource(binding, new OperationHelper.CallableWithSource<BatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithSource
            public BatchCursor<T> call(ConnectionSource source) {
                Connection connection = source.getConnection();
                if (ServerVersionHelper.serverIsAtLeastVersionThreeDotZero(connection.getDescription())) {
                    try {
                        return (BatchCursor) CommandOperationHelper.executeCommandWithConnection(binding, source, ListCollectionsOperation.this.databaseName, ListCollectionsOperation.this.getCommandCreator(), ListCollectionsOperation.this.createCommandDecoder(), ListCollectionsOperation.this.commandTransformer(), ListCollectionsOperation.this.retryReads, connection);
                    } catch (MongoCommandException e) {
                        return (BatchCursor) CommandOperationHelper.rethrowIfNotNamespaceError(e, OperationHelper.createEmptyBatchCursor(ListCollectionsOperation.this.createNamespace(), ListCollectionsOperation.this.decoder, source.getServerDescription().getAddress(), ListCollectionsOperation.this.batchSize));
                    }
                } else {
                    try {
                        ProjectingBatchCursor projectingBatchCursor = new ProjectingBatchCursor(new QueryBatchCursor(connection.query(ListCollectionsOperation.this.getNamespace(), ListCollectionsOperation.this.asQueryDocument(connection.getDescription(), binding.getReadPreference()), null, 0, 0, ListCollectionsOperation.this.batchSize, binding.getReadPreference().isSlaveOk(), false, false, false, false, false, new BsonDocumentCodec()), 0, ListCollectionsOperation.this.batchSize, new BsonDocumentCodec(), source));
                        connection.release();
                        return projectingBatchCursor;
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
        OperationHelper.withAsyncReadConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
            public void call(final AsyncConnectionSource source, final AsyncConnection connection, Throwable t) {
                final SingleResultCallback<AsyncBatchCursor<T>> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                } else if (ServerVersionHelper.serverIsAtLeastVersionThreeDotZero(connection.getDescription())) {
                    CommandOperationHelper.executeCommandAsyncWithConnection(binding, source, ListCollectionsOperation.this.databaseName, ListCollectionsOperation.this.getCommandCreator(), ListCollectionsOperation.this.createCommandDecoder(), ListCollectionsOperation.this.asyncTransformer(), ListCollectionsOperation.this.retryReads, connection, new SingleResultCallback<AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.2.1
                        @Override // com.mongodb.internal.async.SingleResultCallback
                        public /* bridge */ /* synthetic */ void onResult(Object obj, Throwable th) {
                            onResult((AsyncBatchCursor) ((AsyncBatchCursor) obj), th);
                        }

                        public void onResult(AsyncBatchCursor<T> result, Throwable t2) {
                            if (t2 == null || CommandOperationHelper.isNamespaceError(t2)) {
                                errHandlingCallback.onResult(result != null ? result : ListCollectionsOperation.this.emptyAsyncCursor(source), null);
                            } else {
                                errHandlingCallback.onResult(null, t2);
                            }
                        }
                    });
                } else {
                    final SingleResultCallback<AsyncBatchCursor<T>> wrappedCallback = OperationHelper.releasingCallback(errHandlingCallback, source, connection);
                    connection.queryAsync(ListCollectionsOperation.this.getNamespace(), ListCollectionsOperation.this.asQueryDocument(connection.getDescription(), binding.getReadPreference()), null, 0, 0, ListCollectionsOperation.this.batchSize, binding.getReadPreference().isSlaveOk(), false, false, false, false, false, new BsonDocumentCodec(), new SingleResultCallback<QueryResult<BsonDocument>>() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.2.2
                        public void onResult(QueryResult<BsonDocument> result, Throwable t2) {
                            if (t2 != null) {
                                wrappedCallback.onResult(null, t2);
                            } else {
                                wrappedCallback.onResult(new ProjectingAsyncBatchCursor(new AsyncQueryBatchCursor(result, 0, ListCollectionsOperation.this.batchSize, 0, new BsonDocumentCodec(), source, connection)), null);
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public AsyncBatchCursor<T> emptyAsyncCursor(AsyncConnectionSource source) {
        return OperationHelper.createEmptyAsyncBatchCursor(createNamespace(), source.getServerDescription().getAddress());
    }

    /* access modifiers changed from: private */
    public MongoNamespace createNamespace() {
        return new MongoNamespace(this.databaseName, "$cmd.listCollections");
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>> asyncTransformer() {
        return new CommandOperationHelper.CommandReadTransformerAsync<BsonDocument, AsyncBatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.3
            public AsyncBatchCursor<T> apply(BsonDocument result, AsyncConnectionSource source, AsyncConnection connection) {
                return OperationHelper.cursorDocumentToAsyncBatchCursor(result.getDocument("cursor"), ListCollectionsOperation.this.decoder, source, connection, ListCollectionsOperation.this.batchSize);
            }
        };
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>> commandTransformer() {
        return new CommandOperationHelper.CommandReadTransformer<BsonDocument, BatchCursor<T>>() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.4
            public BatchCursor<T> apply(BsonDocument result, ConnectionSource source, Connection connection) {
                return OperationHelper.cursorDocumentToBatchCursor(result.getDocument("cursor"), ListCollectionsOperation.this.decoder, source, ListCollectionsOperation.this.batchSize);
            }
        };
    }

    /* access modifiers changed from: private */
    public MongoNamespace getNamespace() {
        return new MongoNamespace(this.databaseName, "system.namespaces");
    }

    /* access modifiers changed from: private */
    public CommandOperationHelper.CommandCreator getCommandCreator() {
        return new CommandOperationHelper.CommandCreator() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.5
            @Override // com.mongodb.internal.operation.CommandOperationHelper.CommandCreator
            public BsonDocument create(ServerDescription serverDescription, ConnectionDescription connectionDescription) {
                return ListCollectionsOperation.this.getCommand();
            }
        };
    }

    /* access modifiers changed from: private */
    public BsonDocument getCommand() {
        BsonDocument command = new BsonDocument("listCollections", new BsonInt32(1)).append("cursor", CursorHelper.getCursorDocumentFromBatchSize(this.batchSize == 0 ? null : Integer.valueOf(this.batchSize)));
        if (this.filter != null) {
            command.append("filter", this.filter);
        }
        if (this.nameOnly) {
            command.append("nameOnly", BsonBoolean.TRUE);
        }
        if (this.maxTimeMS > 0) {
            command.put("maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        return command;
    }

    /* access modifiers changed from: private */
    public BsonDocument asQueryDocument(ConnectionDescription connectionDescription, ReadPreference readPreference) {
        BsonDocument document = new BsonDocument();
        BsonDocument transformedFilter = null;
        if (this.filter != null) {
            if (!this.filter.containsKey("name")) {
                transformedFilter = this.filter;
            } else if (!this.filter.isString("name")) {
                throw new IllegalArgumentException("When filtering collections on MongoDB versions < 3.0 the name field must be a string");
            } else {
                transformedFilter = new BsonDocument();
                transformedFilter.putAll(this.filter);
                transformedFilter.put("name", (BsonValue) new BsonString(String.format("%s.%s", this.databaseName, this.filter.getString("name").getValue())));
            }
        }
        BsonDocument indexExcludingRegex = new BsonDocument("name", new BsonRegularExpression("^[^$]*$"));
        document.put("$query", (BsonValue) (transformedFilter == null ? indexExcludingRegex : new BsonDocument(QueryOperators.AND, new BsonArray(Arrays.asList(indexExcludingRegex, transformedFilter)))));
        if (connectionDescription.getServerType() == ServerType.SHARD_ROUTER && !readPreference.equals(ReadPreference.primary())) {
            document.put("$readPreference", (BsonValue) readPreference.toDocument());
        }
        if (this.maxTimeMS > 0) {
            document.put("$maxTimeMS", (BsonValue) new BsonInt64(this.maxTimeMS));
        }
        return document;
    }

    /* access modifiers changed from: private */
    public Codec<BsonDocument> createCommandDecoder() {
        return CommandResultDocumentCodec.create(this.decoder, "firstBatch");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/ListCollectionsOperation$ProjectingBatchCursor.class */
    public final class ProjectingBatchCursor implements BatchCursor<T> {
        private final BatchCursor<BsonDocument> delegate;

        private ProjectingBatchCursor(BatchCursor<BsonDocument> delegate) {
            this.delegate = delegate;
        }

        @Override // java.util.Iterator
        public void remove() {
            this.delegate.remove();
        }

        @Override // com.mongodb.internal.operation.BatchCursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // com.mongodb.internal.operation.BatchCursor, java.util.Iterator
        public boolean hasNext() {
            return this.delegate.hasNext();
        }

        @Override // com.mongodb.internal.operation.BatchCursor, java.util.Iterator
        public List<T> next() {
            return ListCollectionsOperation.this.projectFromFullNamespaceToCollectionName(this.delegate.next());
        }

        @Override // com.mongodb.internal.operation.BatchCursor
        public void setBatchSize(int batchSize) {
            this.delegate.setBatchSize(batchSize);
        }

        @Override // com.mongodb.internal.operation.BatchCursor
        public int getBatchSize() {
            return this.delegate.getBatchSize();
        }

        @Override // com.mongodb.internal.operation.BatchCursor
        public List<T> tryNext() {
            return ListCollectionsOperation.this.projectFromFullNamespaceToCollectionName(this.delegate.tryNext());
        }

        @Override // com.mongodb.internal.operation.BatchCursor
        public ServerCursor getServerCursor() {
            return this.delegate.getServerCursor();
        }

        @Override // com.mongodb.internal.operation.BatchCursor
        public ServerAddress getServerAddress() {
            return this.delegate.getServerAddress();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/ListCollectionsOperation$ProjectingAsyncBatchCursor.class */
    public final class ProjectingAsyncBatchCursor implements AsyncBatchCursor<T> {
        private final AsyncBatchCursor<BsonDocument> delegate;

        private ProjectingAsyncBatchCursor(AsyncBatchCursor<BsonDocument> delegate) {
            this.delegate = delegate;
        }

        @Override // com.mongodb.internal.async.AsyncBatchCursor
        public void next(final SingleResultCallback<List<T>> callback) {
            this.delegate.next(new SingleResultCallback<List<BsonDocument>>() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.ProjectingAsyncBatchCursor.1
                public void onResult(List<BsonDocument> result, Throwable t) {
                    if (t != null) {
                        callback.onResult(null, t);
                    } else {
                        callback.onResult(ListCollectionsOperation.this.projectFromFullNamespaceToCollectionName(result), null);
                    }
                }
            });
        }

        @Override // com.mongodb.internal.async.AsyncBatchCursor
        public void tryNext(final SingleResultCallback<List<T>> callback) {
            this.delegate.tryNext(new SingleResultCallback<List<BsonDocument>>() { // from class: com.mongodb.internal.operation.ListCollectionsOperation.ProjectingAsyncBatchCursor.2
                public void onResult(List<BsonDocument> result, Throwable t) {
                    if (t != null) {
                        callback.onResult(null, t);
                    } else {
                        callback.onResult(ListCollectionsOperation.this.projectFromFullNamespaceToCollectionName(result), null);
                    }
                }
            });
        }

        @Override // com.mongodb.internal.async.AsyncBatchCursor
        public void setBatchSize(int batchSize) {
            this.delegate.setBatchSize(batchSize);
        }

        @Override // com.mongodb.internal.async.AsyncBatchCursor
        public int getBatchSize() {
            return this.delegate.getBatchSize();
        }

        @Override // com.mongodb.internal.async.AsyncBatchCursor
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // com.mongodb.internal.async.AsyncBatchCursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }
    }

    /* access modifiers changed from: private */
    public List<T> projectFromFullNamespaceToCollectionName(List<BsonDocument> unstripped) {
        if (unstripped == null) {
            return null;
        }
        List<T> stripped = new ArrayList<>(unstripped.size());
        String prefix = this.databaseName + Mapper.IGNORED_FIELDNAME;
        for (BsonDocument cur : unstripped) {
            cur.put("name", (BsonValue) new BsonString(cur.getString("name").getValue().substring(prefix.length())));
            stripped.add(this.decoder.decode(new BsonDocumentReader(cur), DecoderContext.builder().build()));
        }
        return stripped;
    }
}
