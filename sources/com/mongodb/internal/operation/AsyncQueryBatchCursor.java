package com.mongodb.internal.operation;

import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.ServerCursor;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.async.AsyncAggregateResponseBatchCursor;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonTimestamp;
import org.bson.FieldNameValidator;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.Decoder;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncQueryBatchCursor.class */
public class AsyncQueryBatchCursor<T> implements AsyncAggregateResponseBatchCursor<T> {
    private static final FieldNameValidator NO_OP_FIELD_NAME_VALIDATOR = new NoOpFieldNameValidator();
    private static final String CURSOR = "cursor";
    private static final String POST_BATCH_RESUME_TOKEN = "postBatchResumeToken";
    private static final String OPERATION_TIME = "operationTime";
    private final MongoNamespace namespace;
    private final int limit;
    private final Decoder<T> decoder;
    private final long maxTimeMS;
    private final AsyncConnectionSource connectionSource;
    private final AtomicReference<ServerCursor> cursor;
    private volatile QueryResult<T> firstBatch;
    private volatile int batchSize;
    private final AtomicInteger count;
    private volatile BsonDocument postBatchResumeToken;
    private final BsonTimestamp operationTime;
    private final boolean firstBatchEmpty;
    private final int maxWireVersion;
    private boolean isOperationInProgress;
    private boolean isClosed;
    private volatile boolean isClosePending;

    /* access modifiers changed from: package-private */
    public AsyncQueryBatchCursor(QueryResult<T> firstBatch, int limit, int batchSize, long maxTimeMS, Decoder<T> decoder, AsyncConnectionSource connectionSource, AsyncConnection connection) {
        this(firstBatch, limit, batchSize, maxTimeMS, decoder, connectionSource, connection, null);
    }

    /* access modifiers changed from: package-private */
    public AsyncQueryBatchCursor(QueryResult<T> firstBatch, int limit, int batchSize, long maxTimeMS, Decoder<T> decoder, AsyncConnectionSource connectionSource, AsyncConnection connection, BsonDocument result) {
        this.count = new AtomicInteger();
        this.isOperationInProgress = false;
        this.isClosed = false;
        this.isClosePending = false;
        Assertions.isTrueArgument("maxTimeMS >= 0", maxTimeMS >= 0);
        this.maxTimeMS = maxTimeMS;
        this.namespace = firstBatch.getNamespace();
        this.firstBatch = firstBatch;
        this.limit = limit;
        this.batchSize = batchSize;
        this.decoder = decoder;
        this.cursor = new AtomicReference<>(firstBatch.getCursor());
        this.connectionSource = (AsyncConnectionSource) Assertions.notNull("connectionSource", connectionSource);
        this.count.addAndGet(firstBatch.getResults().size());
        if (result != null) {
            this.operationTime = result.getTimestamp(OPERATION_TIME, null);
            this.postBatchResumeToken = getPostBatchResumeTokenFromResponse(result);
        } else {
            this.operationTime = null;
        }
        this.firstBatchEmpty = firstBatch.getResults().isEmpty();
        if (firstBatch.getCursor() != null) {
            connectionSource.retain();
            if (limitReached()) {
                killCursor(connection);
            }
        }
        this.maxWireVersion = connection == null ? 0 : connection.getDescription().getMaxWireVersion();
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean doClose = false;
        synchronized (this) {
            if (this.isOperationInProgress) {
                this.isClosePending = true;
            } else if (!this.isClosed) {
                this.isClosed = true;
                this.isClosePending = false;
                doClose = true;
            }
        }
        if (doClose) {
            killCursorOnClose();
        }
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void next(SingleResultCallback<List<T>> callback) {
        next(callback, false);
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void tryNext(SingleResultCallback<List<T>> callback) {
        next(callback, true);
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public void setBatchSize(int batchSize) {
        Assertions.assertFalse(isClosed());
        this.batchSize = batchSize;
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public int getBatchSize() {
        Assertions.assertFalse(isClosed());
        return this.batchSize;
    }

    @Override // com.mongodb.internal.async.AsyncBatchCursor
    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.isClosed || this.isClosePending;
        }
        return z;
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public BsonDocument getPostBatchResumeToken() {
        return this.postBatchResumeToken;
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public BsonTimestamp getOperationTime() {
        return this.operationTime;
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public boolean isFirstBatchEmpty() {
        return this.firstBatchEmpty;
    }

    @Override // com.mongodb.internal.async.AsyncAggregateResponseBatchCursor
    public int getMaxWireVersion() {
        return this.maxWireVersion;
    }

    private void next(SingleResultCallback<List<T>> callback, boolean tryNext) {
        if (isClosed()) {
            Object[] objArr = new Object[1];
            objArr[0] = tryNext ? "tryNext()" : "next()";
            callback.onResult(null, new MongoException(String.format("%s called after the cursor was closed.", objArr)));
        } else if (this.firstBatch == null || (!tryNext && this.firstBatch.getResults().isEmpty())) {
            ServerCursor localCursor = getServerCursor();
            if (localCursor == null) {
                close();
                callback.onResult(null, null);
                return;
            }
            synchronized (this) {
                if (isClosed()) {
                    Object[] objArr2 = new Object[1];
                    objArr2[0] = tryNext ? "tryNext()" : "next()";
                    callback.onResult(null, new MongoException(String.format("%s called after the cursor was closed.", objArr2)));
                    return;
                }
                this.isOperationInProgress = true;
                getMore(localCursor, callback, tryNext);
            }
        } else {
            List<T> results = this.firstBatch.getResults();
            if (tryNext && results.isEmpty()) {
                results = null;
            }
            this.firstBatch = null;
            if (getServerCursor() == null) {
                close();
            }
            callback.onResult(results, null);
        }
    }

    private boolean limitReached() {
        return Math.abs(this.limit) != 0 && this.count.get() >= Math.abs(this.limit);
    }

    private void getMore(final ServerCursor cursor, final SingleResultCallback<List<T>> callback, final boolean tryNext) {
        this.connectionSource.getConnection(new SingleResultCallback<AsyncConnection>() { // from class: com.mongodb.internal.operation.AsyncQueryBatchCursor.1
            public void onResult(AsyncConnection connection, Throwable t) {
                if (t != null) {
                    AsyncQueryBatchCursor.this.endOperationInProgress();
                    callback.onResult(null, t);
                    return;
                }
                AsyncQueryBatchCursor.this.getMore(connection, cursor, callback, tryNext);
            }
        });
    }

    /* access modifiers changed from: private */
    public void getMore(AsyncConnection connection, ServerCursor cursor, SingleResultCallback<List<T>> callback, boolean tryNext) {
        if (ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connection.getDescription())) {
            connection.commandAsync(this.namespace.getDatabaseName(), asGetMoreCommandDocument(cursor.getId()), NO_OP_FIELD_NAME_VALIDATOR, ReadPreference.primary(), CommandResultDocumentCodec.create(this.decoder, "nextBatch"), this.connectionSource.getSessionContext(), new CommandResultSingleResultCallback(connection, cursor, callback, tryNext));
        } else {
            connection.getMoreAsync(this.namespace, cursor.getId(), CursorHelper.getNumberToReturn(this.limit, this.batchSize, this.count.get()), this.decoder, new QueryResultSingleResultCallback(connection, callback, tryNext));
        }
    }

    private BsonDocument asGetMoreCommandDocument(long cursorId) {
        BsonDocument document = new BsonDocument("getMore", new BsonInt64(cursorId)).append("collection", new BsonString(this.namespace.getCollectionName()));
        int batchSizeForGetMoreCommand = Math.abs(CursorHelper.getNumberToReturn(this.limit, this.batchSize, this.count.get()));
        if (batchSizeForGetMoreCommand != 0) {
            document.append("batchSize", new BsonInt32(batchSizeForGetMoreCommand));
        }
        if (this.maxTimeMS != 0) {
            document.append("maxTimeMS", new BsonInt64(this.maxTimeMS));
        }
        return document;
    }

    private void killCursorOnClose() {
        final ServerCursor localCursor = getServerCursor();
        if (localCursor != null) {
            this.connectionSource.getConnection(new SingleResultCallback<AsyncConnection>() { // from class: com.mongodb.internal.operation.AsyncQueryBatchCursor.2
                public void onResult(AsyncConnection connection, Throwable t) {
                    if (t != null) {
                        AsyncQueryBatchCursor.this.connectionSource.release();
                    } else {
                        AsyncQueryBatchCursor.this.killCursorAsynchronouslyAndReleaseConnectionAndSource(connection, localCursor);
                    }
                }
            });
        }
    }

    private void killCursor(AsyncConnection connection) {
        ServerCursor localCursor = this.cursor.getAndSet(null);
        if (localCursor != null) {
            killCursorAsynchronouslyAndReleaseConnectionAndSource(connection.retain(), localCursor);
        } else {
            this.connectionSource.release();
        }
    }

    /* access modifiers changed from: private */
    public void killCursorAsynchronouslyAndReleaseConnectionAndSource(final AsyncConnection connection, ServerCursor localCursor) {
        if (ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connection.getDescription())) {
            connection.commandAsync(this.namespace.getDatabaseName(), asKillCursorsCommandDocument(localCursor), NO_OP_FIELD_NAME_VALIDATOR, ReadPreference.primary(), new BsonDocumentCodec(), this.connectionSource.getSessionContext(), new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.operation.AsyncQueryBatchCursor.3
                public void onResult(BsonDocument result, Throwable t) {
                    connection.release();
                    AsyncQueryBatchCursor.this.connectionSource.release();
                }
            });
        } else {
            connection.killCursorAsync(this.namespace, Collections.singletonList(Long.valueOf(localCursor.getId())), new SingleResultCallback<Void>() { // from class: com.mongodb.internal.operation.AsyncQueryBatchCursor.4
                public void onResult(Void result, Throwable t) {
                    connection.release();
                    AsyncQueryBatchCursor.this.connectionSource.release();
                }
            });
        }
    }

    private BsonDocument asKillCursorsCommandDocument(ServerCursor localCursor) {
        return new BsonDocument("killCursors", new BsonString(this.namespace.getCollectionName())).append("cursors", new BsonArray(Collections.singletonList(new BsonInt64(localCursor.getId()))));
    }

    /* access modifiers changed from: private */
    public void endOperationInProgress() {
        boolean closePending;
        synchronized (this) {
            this.isOperationInProgress = false;
            closePending = this.isClosePending;
        }
        if (closePending) {
            close();
        }
    }

    /* access modifiers changed from: private */
    public void handleGetMoreQueryResult(AsyncConnection connection, SingleResultCallback<List<T>> callback, QueryResult<T> result, boolean tryNext) {
        this.cursor.set(result.getCursor());
        if (this.isClosePending) {
            try {
                connection.release();
                if (result.getCursor() == null) {
                    this.connectionSource.release();
                }
                endOperationInProgress();
                callback.onResult(null, null);
            } catch (Throwable th) {
                callback.onResult(null, null);
                throw th;
            }
        } else if (tryNext || !result.getResults().isEmpty() || result.getCursor() == null) {
            this.count.addAndGet(result.getResults().size());
            if (limitReached()) {
                killCursor(connection);
                connection.release();
            } else {
                connection.release();
                if (result.getCursor() == null) {
                    this.connectionSource.release();
                }
            }
            endOperationInProgress();
            if (result.getResults().isEmpty()) {
                callback.onResult(null, null);
            } else {
                callback.onResult(result.getResults(), null);
            }
        } else {
            getMore(connection, result.getCursor(), callback, false);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncQueryBatchCursor$CommandResultSingleResultCallback.class */
    public class CommandResultSingleResultCallback implements SingleResultCallback<BsonDocument> {
        private final AsyncConnection connection;
        private final ServerCursor cursor;
        private final SingleResultCallback<List<T>> callback;
        private final boolean tryNext;

        CommandResultSingleResultCallback(AsyncConnection connection, ServerCursor cursor, SingleResultCallback<List<T>> callback, boolean tryNext) {
            this.connection = connection;
            this.cursor = cursor;
            this.callback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
            this.tryNext = tryNext;
        }

        public void onResult(BsonDocument result, Throwable t) {
            Throwable translatedException;
            if (t != null) {
                if (t instanceof MongoCommandException) {
                    translatedException = QueryHelper.translateCommandException((MongoCommandException) t, this.cursor);
                } else {
                    translatedException = t;
                }
                this.connection.release();
                AsyncQueryBatchCursor.this.endOperationInProgress();
                this.callback.onResult(null, translatedException);
                return;
            }
            QueryResult<T> queryResult = OperationHelper.getMoreCursorDocumentToQueryResult(result.getDocument(AsyncQueryBatchCursor.CURSOR), this.connection.getDescription().getServerAddress());
            AsyncQueryBatchCursor.this.postBatchResumeToken = AsyncQueryBatchCursor.this.getPostBatchResumeTokenFromResponse(result);
            AsyncQueryBatchCursor.this.handleGetMoreQueryResult(this.connection, this.callback, queryResult, this.tryNext);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncQueryBatchCursor$QueryResultSingleResultCallback.class */
    public class QueryResultSingleResultCallback implements SingleResultCallback<QueryResult<T>> {
        private final AsyncConnection connection;
        private final SingleResultCallback<List<T>> callback;
        private final boolean tryNext;

        @Override // com.mongodb.internal.async.SingleResultCallback
        public /* bridge */ /* synthetic */ void onResult(Object obj, Throwable th) {
            onResult((QueryResult) ((QueryResult) obj), th);
        }

        QueryResultSingleResultCallback(AsyncConnection connection, SingleResultCallback<List<T>> callback, boolean tryNext) {
            this.connection = connection;
            this.callback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
            this.tryNext = tryNext;
        }

        public void onResult(QueryResult<T> result, Throwable t) {
            if (t != null) {
                this.connection.release();
                AsyncQueryBatchCursor.this.endOperationInProgress();
                this.callback.onResult(null, t);
                return;
            }
            AsyncQueryBatchCursor.this.handleGetMoreQueryResult(this.connection, this.callback, result, this.tryNext);
        }
    }

    ServerCursor getServerCursor() {
        return this.cursor.get();
    }

    /* access modifiers changed from: private */
    public BsonDocument getPostBatchResumeTokenFromResponse(BsonDocument result) {
        BsonDocument cursor = result.getDocument(CURSOR, null);
        if (cursor != null) {
            return cursor.getDocument(POST_BATCH_RESUME_TOKEN, null);
        }
        return null;
    }
}
