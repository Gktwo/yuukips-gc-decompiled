package com.mongodb.internal.operation;

import com.mongodb.MongoException;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
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
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/QueryBatchCursor.class */
public class QueryBatchCursor<T> implements AggregateResponseBatchCursor<T> {
    private static final FieldNameValidator NO_OP_FIELD_NAME_VALIDATOR = new NoOpFieldNameValidator();
    private static final String CURSOR = "cursor";
    private static final String POST_BATCH_RESUME_TOKEN = "postBatchResumeToken";
    private static final String OPERATION_TIME = "operationTime";
    private final MongoNamespace namespace;
    private final ServerAddress serverAddress;
    private final int limit;
    private final Decoder<T> decoder;
    private final long maxTimeMS;
    private int batchSize;
    private ConnectionSource connectionSource;
    private ServerCursor serverCursor;
    private List<T> nextBatch;
    private int count;
    private volatile boolean closed;
    private BsonDocument postBatchResumeToken;
    private BsonTimestamp operationTime;
    private boolean firstBatchEmpty;
    private int maxWireVersion;

    /* access modifiers changed from: package-private */
    public QueryBatchCursor(QueryResult<T> firstQueryResult, int limit, int batchSize, Decoder<T> decoder) {
        this(firstQueryResult, limit, batchSize, decoder, null);
    }

    /* access modifiers changed from: package-private */
    public QueryBatchCursor(QueryResult<T> firstQueryResult, int limit, int batchSize, Decoder<T> decoder, ConnectionSource connectionSource) {
        this(firstQueryResult, limit, batchSize, 0, decoder, connectionSource, null, null);
    }

    QueryBatchCursor(QueryResult<T> firstQueryResult, int limit, int batchSize, Decoder<T> decoder, ConnectionSource connectionSource, Connection connection) {
        this(firstQueryResult, limit, batchSize, 0, decoder, connectionSource, connection, null);
    }

    /* access modifiers changed from: package-private */
    public QueryBatchCursor(QueryResult<T> firstQueryResult, int limit, int batchSize, long maxTimeMS, Decoder<T> decoder, ConnectionSource connectionSource, Connection connection) {
        this(firstQueryResult, limit, batchSize, maxTimeMS, decoder, connectionSource, connection, null);
    }

    /* access modifiers changed from: package-private */
    public QueryBatchCursor(QueryResult<T> firstQueryResult, int limit, int batchSize, long maxTimeMS, Decoder<T> decoder, ConnectionSource connectionSource, Connection connection, BsonDocument result) {
        this.maxWireVersion = 0;
        Assertions.isTrueArgument("maxTimeMS >= 0", maxTimeMS >= 0);
        this.maxTimeMS = maxTimeMS;
        this.namespace = firstQueryResult.getNamespace();
        this.serverAddress = firstQueryResult.getAddress();
        this.limit = limit;
        this.batchSize = batchSize;
        this.decoder = (Decoder) Assertions.notNull("decoder", decoder);
        if (result != null) {
            this.operationTime = result.getTimestamp(OPERATION_TIME, null);
            this.postBatchResumeToken = getPostBatchResumeTokenFromResponse(result);
        }
        if (firstQueryResult.getCursor() != null) {
            Assertions.notNull("connectionSource", connectionSource);
        }
        if (connectionSource != null) {
            this.connectionSource = connectionSource.retain();
        } else {
            this.connectionSource = null;
        }
        initFromQueryResult(firstQueryResult);
        this.firstBatchEmpty = firstQueryResult.getResults().isEmpty();
        if (connection != null) {
            this.maxWireVersion = connection.getDescription().getMaxWireVersion();
            if (limitReached()) {
                killCursor(connection);
            }
        }
        releaseConnectionSourceIfNoServerCursor();
    }

    @Override // com.mongodb.internal.operation.BatchCursor, java.util.Iterator
    public boolean hasNext() {
        if (this.closed) {
            throw new IllegalStateException("Cursor has been closed");
        } else if (this.nextBatch != null) {
            return true;
        } else {
            if (limitReached()) {
                return false;
            }
            while (this.serverCursor != null) {
                getMore();
                if (this.closed) {
                    throw new IllegalStateException("Cursor has been closed");
                } else if (this.nextBatch != null) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.mongodb.internal.operation.BatchCursor, java.util.Iterator
    public List<T> next() {
        if (this.closed) {
            throw new IllegalStateException("Iterator has been closed");
        } else if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            List<T> retVal = this.nextBatch;
            this.nextBatch = null;
            return retVal;
        }
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public int getBatchSize() {
        return this.batchSize;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override // com.mongodb.internal.operation.BatchCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.closed) {
            this.closed = true;
            try {
                killCursor();
                if (this.connectionSource != null) {
                    this.connectionSource.release();
                }
            } catch (Throwable th) {
                if (this.connectionSource != null) {
                    this.connectionSource.release();
                }
                throw th;
            }
        }
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public List<T> tryNext() {
        if (this.closed) {
            throw new IllegalStateException("Cursor has been closed");
        } else if (!tryHasNext()) {
            return null;
        } else {
            return next();
        }
    }

    boolean tryHasNext() {
        if (this.nextBatch != null) {
            return true;
        }
        if (limitReached()) {
            return false;
        }
        if (this.serverCursor != null) {
            getMore();
        }
        return this.nextBatch != null;
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public ServerCursor getServerCursor() {
        if (!this.closed) {
            return this.serverCursor;
        }
        throw new IllegalStateException("Iterator has been closed");
    }

    @Override // com.mongodb.internal.operation.BatchCursor
    public ServerAddress getServerAddress() {
        if (!this.closed) {
            return this.serverAddress;
        }
        throw new IllegalStateException("Iterator has been closed");
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public BsonDocument getPostBatchResumeToken() {
        return this.postBatchResumeToken;
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public BsonTimestamp getOperationTime() {
        return this.operationTime;
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public boolean isFirstBatchEmpty() {
        return this.firstBatchEmpty;
    }

    @Override // com.mongodb.internal.operation.AggregateResponseBatchCursor
    public int getMaxWireVersion() {
        return this.maxWireVersion;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0049
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void getMore() {
        /*
            r9 = this;
            r0 = r9
            com.mongodb.internal.binding.ConnectionSource r0 = r0.connectionSource
            com.mongodb.internal.connection.Connection r0 = r0.getConnection()
            r10 = r0
            r0 = r10
            com.mongodb.connection.ConnectionDescription r0 = r0.getDescription()     // Catch: all -> 0x0096
            boolean r0 = com.mongodb.internal.operation.ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(r0)     // Catch: all -> 0x0096
            if (r0 == 0) goto L_0x0053
            r0 = r9
            r1 = r10
            r2 = r9
            com.mongodb.MongoNamespace r2 = r2.namespace     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            java.lang.String r2 = r2.getDatabaseName()     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            r3 = r9
            org.bson.BsonDocument r3 = r3.asGetMoreCommandDocument()     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            org.bson.FieldNameValidator r4 = com.mongodb.internal.operation.QueryBatchCursor.NO_OP_FIELD_NAME_VALIDATOR     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            com.mongodb.ReadPreference r5 = com.mongodb.ReadPreference.primary()     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            r6 = r9
            org.bson.codecs.Decoder<T> r6 = r6.decoder     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            java.lang.String r7 = "nextBatch"
            org.bson.codecs.Codec r6 = com.mongodb.internal.operation.CommandResultDocumentCodec.create(r6, r7)     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            r7 = r9
            com.mongodb.internal.binding.ConnectionSource r7 = r7.connectionSource     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            com.mongodb.internal.session.SessionContext r7 = r7.getSessionContext()     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            java.lang.Object r1 = r1.command(r2, r3, r4, r5, r6, r7)     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            org.bson.BsonDocument r1 = (org.bson.BsonDocument) r1     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            r0.initFromCommandResult(r1)     // Catch: MongoCommandException -> 0x0049, all -> 0x0096
            goto L_0x007d
        L_0x0049:
            r11 = move-exception
            r0 = r11
            r1 = r9
            com.mongodb.ServerCursor r1 = r1.serverCursor     // Catch: all -> 0x0096
            com.mongodb.MongoQueryException r0 = com.mongodb.internal.operation.QueryHelper.translateCommandException(r0, r1)     // Catch: all -> 0x0096
            throw r0     // Catch: all -> 0x0096
        L_0x0053:
            r0 = r10
            r1 = r9
            com.mongodb.MongoNamespace r1 = r1.namespace     // Catch: all -> 0x0096
            r2 = r9
            com.mongodb.ServerCursor r2 = r2.serverCursor     // Catch: all -> 0x0096
            long r2 = r2.getId()     // Catch: all -> 0x0096
            r3 = r9
            int r3 = r3.limit     // Catch: all -> 0x0096
            r4 = r9
            int r4 = r4.batchSize     // Catch: all -> 0x0096
            r5 = r9
            int r5 = r5.count     // Catch: all -> 0x0096
            int r3 = com.mongodb.internal.operation.CursorHelper.getNumberToReturn(r3, r4, r5)     // Catch: all -> 0x0096
            r4 = r9
            org.bson.codecs.Decoder<T> r4 = r4.decoder     // Catch: all -> 0x0096
            com.mongodb.internal.connection.QueryResult r0 = r0.getMore(r1, r2, r3, r4)     // Catch: all -> 0x0096
            r11 = r0
            r0 = r9
            r1 = r11
            r0.initFromQueryResult(r1)     // Catch: all -> 0x0096
        L_0x007d:
            r0 = r9
            boolean r0 = r0.limitReached()     // Catch: all -> 0x0096
            if (r0 == 0) goto L_0x0089
            r0 = r9
            r1 = r10
            r0.killCursor(r1)     // Catch: all -> 0x0096
        L_0x0089:
            r0 = r10
            r0.release()
            r0 = r9
            r0.releaseConnectionSourceIfNoServerCursor()
            goto L_0x00a3
        L_0x0096:
            r12 = move-exception
            r0 = r10
            r0.release()
            r0 = r9
            r0.releaseConnectionSourceIfNoServerCursor()
            r0 = r12
            throw r0
        L_0x00a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.operation.QueryBatchCursor.getMore():void");
    }

    private BsonDocument asGetMoreCommandDocument() {
        BsonDocument document = new BsonDocument("getMore", new BsonInt64(this.serverCursor.getId())).append("collection", new BsonString(this.namespace.getCollectionName()));
        int batchSizeForGetMoreCommand = Math.abs(CursorHelper.getNumberToReturn(this.limit, this.batchSize, this.count));
        if (batchSizeForGetMoreCommand != 0) {
            document.append("batchSize", new BsonInt32(batchSizeForGetMoreCommand));
        }
        if (this.maxTimeMS != 0) {
            document.append("maxTimeMS", new BsonInt64(this.maxTimeMS));
        }
        return document;
    }

    private void initFromQueryResult(QueryResult<T> queryResult) {
        this.serverCursor = queryResult.getCursor();
        this.nextBatch = queryResult.getResults().isEmpty() ? null : queryResult.getResults();
        this.count += queryResult.getResults().size();
    }

    private void initFromCommandResult(BsonDocument getMoreCommandResultDocument) {
        QueryResult<T> queryResult = OperationHelper.getMoreCursorDocumentToQueryResult(getMoreCommandResultDocument.getDocument(CURSOR), this.connectionSource.getServerDescription().getAddress());
        this.postBatchResumeToken = getPostBatchResumeTokenFromResponse(getMoreCommandResultDocument);
        this.operationTime = getMoreCommandResultDocument.getTimestamp(OPERATION_TIME, null);
        initFromQueryResult(queryResult);
    }

    private boolean limitReached() {
        return Math.abs(this.limit) != 0 && this.count >= Math.abs(this.limit);
    }

    private void killCursor() {
        if (this.serverCursor != null) {
            try {
                Connection connection = this.connectionSource.getConnection();
                killCursor(connection);
                connection.release();
            } catch (MongoException e) {
            }
        }
    }

    private void killCursor(Connection connection) {
        if (this.serverCursor != null) {
            Assertions.notNull("connection", connection);
            try {
                if (ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connection.getDescription())) {
                    connection.command(this.namespace.getDatabaseName(), asKillCursorsCommandDocument(), NO_OP_FIELD_NAME_VALIDATOR, ReadPreference.primary(), new BsonDocumentCodec(), this.connectionSource.getSessionContext());
                } else {
                    connection.killCursor(this.namespace, Collections.singletonList(Long.valueOf(this.serverCursor.getId())));
                }
            } finally {
                this.serverCursor = null;
            }
        }
    }

    private void releaseConnectionSourceIfNoServerCursor() {
        if (this.serverCursor == null && this.connectionSource != null) {
            this.connectionSource.release();
            this.connectionSource = null;
        }
    }

    private BsonDocument asKillCursorsCommandDocument() {
        return new BsonDocument("killCursors", new BsonString(this.namespace.getCollectionName())).append("cursors", new BsonArray(Collections.singletonList(new BsonInt64(this.serverCursor.getId()))));
    }

    private BsonDocument getPostBatchResumeTokenFromResponse(BsonDocument result) {
        BsonDocument cursor = result.getDocument(CURSOR, null);
        if (cursor != null) {
            return cursor.getDocument(POST_BATCH_RESUME_TOKEN, null);
        }
        return null;
    }
}
