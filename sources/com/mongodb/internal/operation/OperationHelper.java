package com.mongodb.internal.operation;

import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.MongoNamespace;
import com.mongodb.ReadConcern;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerType;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.AsyncBatchCursor;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadBinding;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.binding.ReferenceCounted;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.IndexRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.QueryResult;
import com.mongodb.internal.session.SessionContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.codecs.Decoder;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper.class */
public final class OperationHelper {
    public static final Logger LOGGER = Loggers.getLogger("operation");

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$AsyncCallableWithConnection.class */
    public interface AsyncCallableWithConnection {
        void call(AsyncConnection asyncConnection, Throwable th);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$AsyncCallableWithConnectionAndSource.class */
    public interface AsyncCallableWithConnectionAndSource {
        void call(AsyncConnectionSource asyncConnectionSource, AsyncConnection asyncConnection, Throwable th);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$AsyncCallableWithSource.class */
    public interface AsyncCallableWithSource {
        void call(AsyncConnectionSource asyncConnectionSource, Throwable th);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$CallableWithConnection.class */
    public interface CallableWithConnection<T> {
        T call(Connection connection);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$CallableWithConnectionAndSource.class */
    public interface CallableWithConnectionAndSource<T> {
        T call(ConnectionSource connectionSource, Connection connection);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$CallableWithSource.class */
    public interface CallableWithSource<T> {
        T call(ConnectionSource connectionSource);
    }

    static void validateReadConcern(Connection connection, ReadConcern readConcern) {
        validateReadConcern(connection.getDescription(), readConcern);
    }

    static void validateReadConcern(ConnectionDescription description, ReadConcern readConcern) {
        if (!ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(description) && !readConcern.isServerDefault()) {
            throw new IllegalArgumentException(String.format("ReadConcern not supported by wire version: %s", Integer.valueOf(description.getMaxWireVersion())));
        }
    }

    static void validateReadConcern(AsyncConnection connection, ReadConcern readConcern, AsyncCallableWithConnection callable) {
        Throwable throwable = null;
        if (!ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connection.getDescription()) && !readConcern.isServerDefault()) {
            throwable = new IllegalArgumentException(String.format("ReadConcern not supported by wire version: %s", Integer.valueOf(connection.getDescription().getMaxWireVersion())));
        }
        callable.call(connection, throwable);
    }

    static void validateReadConcern(final AsyncConnectionSource source, AsyncConnection connection, ReadConcern readConcern, final AsyncCallableWithConnectionAndSource callable) {
        validateReadConcern(connection, readConcern, new AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.OperationHelper.1
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection2, Throwable t) {
                AsyncCallableWithConnectionAndSource.this.call(source, connection2, t);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static void validateCollation(Connection connection, Collation collation) {
        validateCollation(connection.getDescription(), collation);
    }

    /* access modifiers changed from: package-private */
    public static void validateCollation(ConnectionDescription connectionDescription, Collation collation) {
        if (collation != null && !ServerVersionHelper.serverIsAtLeastVersionThreeDotFour(connectionDescription)) {
            throw new IllegalArgumentException(String.format("Collation not supported by wire version: %s", Integer.valueOf(connectionDescription.getMaxWireVersion())));
        }
    }

    static void validateCollationAndWriteConcern(ConnectionDescription connectionDescription, Collation collation, WriteConcern writeConcern) {
        if (collation != null && !ServerVersionHelper.serverIsAtLeastVersionThreeDotFour(connectionDescription)) {
            throw new IllegalArgumentException(String.format("Collation not supported by wire version: %s", Integer.valueOf(connectionDescription.getMaxWireVersion())));
        } else if (collation != null && !writeConcern.isAcknowledged()) {
            throw new MongoClientException("Specifying collation with an unacknowledged WriteConcern is not supported");
        }
    }

    private static void validateArrayFilters(ConnectionDescription connectionDescription, WriteConcern writeConcern) {
        if (ServerVersionHelper.serverIsLessThanVersionThreeDotSix(connectionDescription)) {
            throw new IllegalArgumentException(String.format("Array filters not supported by wire version: %s", Integer.valueOf(connectionDescription.getMaxWireVersion())));
        } else if (!writeConcern.isAcknowledged()) {
            throw new MongoClientException("Specifying array filters with an unacknowledged WriteConcern is not supported");
        }
    }

    private static void validateWriteRequestHint(ConnectionDescription connectionDescription, WriteConcern writeConcern, WriteRequest request) {
        if (ServerVersionHelper.serverIsLessThanVersionThreeDotFour(connectionDescription)) {
            throw new IllegalArgumentException(String.format("Hint not supported by wire version: %s", Integer.valueOf(connectionDescription.getMaxWireVersion())));
        } else if (((request instanceof DeleteRequest) || (request instanceof UpdateRequest)) && !writeConcern.isAcknowledged()) {
            throw new MongoClientException("Specifying hints with an unacknowledged WriteConcern is not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public static void validateHint(ConnectionDescription connectionDescription, WriteConcern writeConcern) {
        if (ServerVersionHelper.serverIsLessThanVersionFourDotTwo(connectionDescription)) {
            throw new IllegalArgumentException(String.format("Hint not supported by wire version: %s", Integer.valueOf(connectionDescription.getMaxWireVersion())));
        } else if (!writeConcern.isAcknowledged()) {
            throw new MongoClientException("Specifying hints with an unacknowledged WriteConcern is not supported");
        }
    }

    static void validateAllowDiskUse(Connection connection, Boolean allowDiskUse) {
        validateAllowDiskUse(connection.getDescription(), allowDiskUse).ifPresent(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }

    static void validateAllowDiskUse(AsyncConnection connection, Boolean allowDiskUse, AsyncCallableWithConnection callable) {
        Optional<Throwable> throwable = validateAllowDiskUse(connection.getDescription(), allowDiskUse);
        callable.call(connection, throwable.isPresent() ? throwable.get() : null);
    }

    /* access modifiers changed from: package-private */
    public static void validateCollation(AsyncConnection connection, Collation collation, AsyncCallableWithConnection callable) {
        Throwable throwable = null;
        if (!ServerVersionHelper.serverIsAtLeastVersionThreeDotFour(connection.getDescription()) && collation != null) {
            throwable = new IllegalArgumentException(String.format("Collation not supported by wire version: %s", Integer.valueOf(connection.getDescription().getMaxWireVersion())));
        }
        callable.call(connection, throwable);
    }

    static void validateCollation(final AsyncConnectionSource source, AsyncConnection connection, Collation collation, final AsyncCallableWithConnectionAndSource callable) {
        validateCollation(connection, collation, new AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.OperationHelper.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection2, Throwable t) {
                AsyncCallableWithConnectionAndSource.this.call(source, connection2, t);
            }
        });
    }

    static void validateWriteRequestCollations(ConnectionDescription connectionDescription, List<? extends WriteRequest> requests, WriteConcern writeConcern) {
        Collation collation = null;
        for (WriteRequest request : requests) {
            if (request instanceof UpdateRequest) {
                collation = ((UpdateRequest) request).getCollation();
            } else if (request instanceof DeleteRequest) {
                collation = ((DeleteRequest) request).getCollation();
            }
            if (collation != null) {
                break;
            }
        }
        validateCollationAndWriteConcern(connectionDescription, collation, writeConcern);
    }

    static void validateUpdateRequestArrayFilters(ConnectionDescription connectionDescription, List<? extends WriteRequest> requests, WriteConcern writeConcern) {
        for (WriteRequest request : requests) {
            List<BsonDocument> arrayFilters = null;
            if (request instanceof UpdateRequest) {
                arrayFilters = ((UpdateRequest) request).getArrayFilters();
            }
            if (arrayFilters != null) {
                validateArrayFilters(connectionDescription, writeConcern);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void validateWriteRequestHints(com.mongodb.connection.ConnectionDescription r4, java.util.List<? extends com.mongodb.internal.bulk.WriteRequest> r5, com.mongodb.WriteConcern r6) {
        /*
            r0 = r5
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
        L_0x0007:
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0073
            r0 = r7
            java.lang.Object r0 = r0.next()
            com.mongodb.internal.bulk.WriteRequest r0 = (com.mongodb.internal.bulk.WriteRequest) r0
            r8 = r0
            r0 = 0
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r8
            boolean r0 = r0 instanceof com.mongodb.internal.bulk.UpdateRequest
            if (r0 == 0) goto L_0x0040
            r0 = r8
            com.mongodb.internal.bulk.UpdateRequest r0 = (com.mongodb.internal.bulk.UpdateRequest) r0
            org.bson.conversions.Bson r0 = r0.getHint()
            r9 = r0
            r0 = r8
            com.mongodb.internal.bulk.UpdateRequest r0 = (com.mongodb.internal.bulk.UpdateRequest) r0
            java.lang.String r0 = r0.getHintString()
            r10 = r0
            goto L_0x005c
        L_0x0040:
            r0 = r8
            boolean r0 = r0 instanceof com.mongodb.internal.bulk.DeleteRequest
            if (r0 == 0) goto L_0x005c
            r0 = r8
            com.mongodb.internal.bulk.DeleteRequest r0 = (com.mongodb.internal.bulk.DeleteRequest) r0
            org.bson.conversions.Bson r0 = r0.getHint()
            r9 = r0
            r0 = r8
            com.mongodb.internal.bulk.DeleteRequest r0 = (com.mongodb.internal.bulk.DeleteRequest) r0
            java.lang.String r0 = r0.getHintString()
            r10 = r0
        L_0x005c:
            r0 = r9
            if (r0 != 0) goto L_0x0066
            r0 = r10
            if (r0 == 0) goto L_0x0070
        L_0x0066:
            r0 = r4
            r1 = r6
            r2 = r8
            validateWriteRequestHint(r0, r1, r2)
            goto L_0x0073
        L_0x0070:
            goto L_0x0007
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.operation.OperationHelper.validateWriteRequestHints(com.mongodb.connection.ConnectionDescription, java.util.List, com.mongodb.WriteConcern):void");
    }

    /* access modifiers changed from: package-private */
    public static void validateWriteRequests(ConnectionDescription connectionDescription, Boolean bypassDocumentValidation, List<? extends WriteRequest> requests, WriteConcern writeConcern) {
        checkBypassDocumentValidationIsSupported(connectionDescription, bypassDocumentValidation, writeConcern);
        validateWriteRequestCollations(connectionDescription, requests, writeConcern);
        validateUpdateRequestArrayFilters(connectionDescription, requests, writeConcern);
        validateWriteRequestHints(connectionDescription, requests, writeConcern);
    }

    /* access modifiers changed from: package-private */
    public static void validateWriteRequests(AsyncConnection connection, Boolean bypassDocumentValidation, List<? extends WriteRequest> requests, WriteConcern writeConcern, AsyncCallableWithConnection callable) {
        try {
            validateWriteRequests(connection.getDescription(), bypassDocumentValidation, requests, writeConcern);
            callable.call(connection, null);
        } catch (Throwable t) {
            callable.call(connection, t);
        }
    }

    /* access modifiers changed from: package-private */
    public static void validateIndexRequestCollations(Connection connection, List<IndexRequest> requests) {
        for (IndexRequest request : requests) {
            if (request.getCollation() != null) {
                validateCollation(connection, request.getCollation());
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void validateIndexRequestCollations(AsyncConnection connection, List<IndexRequest> requests, final AsyncCallableWithConnection callable) {
        boolean calledTheCallable = false;
        Iterator<IndexRequest> it = requests.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            IndexRequest request = it.next();
            if (request.getCollation() != null) {
                calledTheCallable = true;
                validateCollation(connection, request.getCollation(), new AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.OperationHelper.3
                    @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
                    public void call(AsyncConnection connection2, Throwable t) {
                        AsyncCallableWithConnection.this.call(connection2, t);
                    }
                });
                break;
            }
        }
        if (!calledTheCallable) {
            callable.call(connection, null);
        }
    }

    /* access modifiers changed from: package-private */
    public static void validateFindOptions(Connection connection, ReadConcern readConcern, Collation collation, Boolean allowDiskUse) {
        validateReadConcernAndCollation(connection, readConcern, collation);
        validateAllowDiskUse(connection, allowDiskUse);
    }

    /* access modifiers changed from: package-private */
    public static void validateFindOptions(ConnectionDescription description, ReadConcern readConcern, Collation collation, Boolean allowDiskUse) {
        validateReadConcernAndCollation(description, readConcern, collation);
        validateAllowDiskUse(description, allowDiskUse).ifPresent(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }

    static void validateReadConcernAndCollation(Connection connection, ReadConcern readConcern, Collation collation) {
        validateReadConcern(connection, readConcern);
        validateCollation(connection, collation);
    }

    /* access modifiers changed from: package-private */
    public static void validateReadConcernAndCollation(ConnectionDescription description, ReadConcern readConcern, Collation collation) {
        validateReadConcern(description, readConcern);
        validateCollation(description, collation);
    }

    static void validateFindOptions(AsyncConnection connection, ReadConcern readConcern, Collation collation, final Boolean allowDiskUse, final AsyncCallableWithConnection callable) {
        validateReadConcernAndCollation(connection, readConcern, collation, new AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.OperationHelper.4
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection2, Throwable t) {
                if (t != null) {
                    AsyncCallableWithConnection.this.call(connection2, t);
                } else {
                    OperationHelper.validateAllowDiskUse(connection2, allowDiskUse, AsyncCallableWithConnection.this);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static void validateFindOptions(final AsyncConnectionSource source, AsyncConnection connection, ReadConcern readConcern, Collation collation, Boolean allowDiskUse, final AsyncCallableWithConnectionAndSource callable) {
        validateFindOptions(connection, readConcern, collation, allowDiskUse, new AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.OperationHelper.5
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection2, Throwable t) {
                AsyncCallableWithConnectionAndSource.this.call(source, connection2, t);
            }
        });
    }

    static void validateReadConcernAndCollation(AsyncConnection connection, ReadConcern readConcern, final Collation collation, final AsyncCallableWithConnection callable) {
        validateReadConcern(connection, readConcern, new AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.OperationHelper.6
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection2, Throwable t) {
                if (t != null) {
                    AsyncCallableWithConnection.this.call(connection2, t);
                } else {
                    OperationHelper.validateCollation(connection2, collation, AsyncCallableWithConnection.this);
                }
            }
        });
    }

    static void validateReadConcernAndCollation(final AsyncConnectionSource source, AsyncConnection connection, ReadConcern readConcern, Collation collation, final AsyncCallableWithConnectionAndSource callable) {
        validateReadConcernAndCollation(connection, readConcern, collation, new AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.OperationHelper.7
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
            public void call(AsyncConnection connection2, Throwable t) {
                AsyncCallableWithConnectionAndSource.this.call(source, connection2, t);
            }
        });
    }

    static void checkBypassDocumentValidationIsSupported(ConnectionDescription connectionDescription, Boolean bypassDocumentValidation, WriteConcern writeConcern) {
        if (bypassDocumentValidation != null && ServerVersionHelper.serverIsAtLeastVersionThreeDotTwo(connectionDescription) && !writeConcern.isAcknowledged()) {
            throw new MongoClientException("Specifying bypassDocumentValidation with an unacknowledged WriteConcern is not supported");
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean isRetryableWrite(boolean retryWrites, WriteConcern writeConcern, ServerDescription serverDescription, ConnectionDescription connectionDescription, SessionContext sessionContext) {
        if (!retryWrites) {
            return false;
        }
        if (!writeConcern.isAcknowledged()) {
            LOGGER.debug("retryWrites set to true but the writeConcern is unacknowledged.");
            return false;
        } else if (!sessionContext.hasActiveTransaction()) {
            return canRetryWrite(serverDescription, connectionDescription, sessionContext);
        } else {
            LOGGER.debug("retryWrites set to true but in an active transaction.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean canRetryWrite(ServerDescription serverDescription, ConnectionDescription connectionDescription, SessionContext sessionContext) {
        if (ServerVersionHelper.serverIsLessThanVersionThreeDotSix(connectionDescription)) {
            LOGGER.debug("retryWrites set to true but the server does not support retryable writes.");
            return false;
        } else if (serverDescription.getLogicalSessionTimeoutMinutes() == null) {
            LOGGER.debug("retryWrites set to true but the server does not have 3.6 feature compatibility enabled.");
            return false;
        } else if (connectionDescription.getServerType().equals(ServerType.STANDALONE)) {
            LOGGER.debug("retryWrites set to true but the server is a standalone server.");
            return false;
        } else if (sessionContext.hasSession()) {
            return true;
        } else {
            LOGGER.debug("retryWrites set to true but there is no implicit session, likely because the MongoClient was created with multiple MongoCredential instances and sessions can only be used with a single MongoCredential");
            return false;
        }
    }

    static boolean isRetryableRead(boolean retryReads, ServerDescription serverDescription, ConnectionDescription connectionDescription, SessionContext sessionContext) {
        if (!retryReads) {
            return false;
        }
        if (!sessionContext.hasActiveTransaction()) {
            return canRetryRead(serverDescription, connectionDescription, sessionContext);
        }
        LOGGER.debug("retryReads set to true but in an active transaction.");
        return false;
    }

    /* access modifiers changed from: package-private */
    public static boolean canRetryRead(ServerDescription serverDescription, ConnectionDescription connectionDescription, SessionContext sessionContext) {
        if (ServerVersionHelper.serverIsLessThanVersionThreeDotSix(connectionDescription)) {
            LOGGER.debug("retryReads set to true but the server does not support retryable reads.");
            return false;
        } else if (serverDescription.getLogicalSessionTimeoutMinutes() == null) {
            LOGGER.debug("retryReads set to true but the server does not have 3.6 feature compatibility enabled.");
            return false;
        } else if (serverDescription.getType() == ServerType.STANDALONE || sessionContext.hasSession()) {
            return true;
        } else {
            LOGGER.debug("retryReads set to true but there is no implicit session, likely because the MongoClient was created with multiple MongoCredential instances and sessions can only be used with a single MongoCredential");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static <T> QueryBatchCursor<T> createEmptyBatchCursor(MongoNamespace namespace, Decoder<T> decoder, ServerAddress serverAddress, int batchSize) {
        return new QueryBatchCursor<>(new QueryResult(namespace, Collections.emptyList(), 0, serverAddress), 0, batchSize, decoder);
    }

    /* access modifiers changed from: package-private */
    public static <T> AsyncBatchCursor<T> createEmptyAsyncBatchCursor(MongoNamespace namespace, ServerAddress serverAddress) {
        return new AsyncSingleBatchQueryCursor(new QueryResult(namespace, Collections.emptyList(), 0, serverAddress));
    }

    /* access modifiers changed from: package-private */
    public static <T> BatchCursor<T> cursorDocumentToBatchCursor(BsonDocument cursorDocument, Decoder<T> decoder, ConnectionSource source, int batchSize) {
        return new QueryBatchCursor(cursorDocumentToQueryResult(cursorDocument, source.getServerDescription().getAddress()), 0, batchSize, decoder, source);
    }

    /* access modifiers changed from: package-private */
    public static <T> AsyncBatchCursor<T> cursorDocumentToAsyncBatchCursor(BsonDocument cursorDocument, Decoder<T> decoder, AsyncConnectionSource source, AsyncConnection connection, int batchSize) {
        return new AsyncQueryBatchCursor(cursorDocumentToQueryResult(cursorDocument, source.getServerDescription().getAddress()), 0, batchSize, 0, decoder, source, connection, cursorDocument);
    }

    /* access modifiers changed from: package-private */
    public static <T> QueryResult<T> cursorDocumentToQueryResult(BsonDocument cursorDocument, ServerAddress serverAddress) {
        return cursorDocumentToQueryResult(cursorDocument, serverAddress, "firstBatch");
    }

    /* access modifiers changed from: package-private */
    public static <T> QueryResult<T> getMoreCursorDocumentToQueryResult(BsonDocument cursorDocument, ServerAddress serverAddress) {
        return cursorDocumentToQueryResult(cursorDocument, serverAddress, "nextBatch");
    }

    private static <T> QueryResult<T> cursorDocumentToQueryResult(BsonDocument cursorDocument, ServerAddress serverAddress, String fieldNameContainingBatch) {
        return new QueryResult<>(new MongoNamespace(cursorDocument.getString("ns").getValue()), BsonDocumentWrapperHelper.toList(cursorDocument, fieldNameContainingBatch), ((BsonInt64) cursorDocument.get("id")).getValue(), serverAddress);
    }

    /* access modifiers changed from: package-private */
    public static <T> SingleResultCallback<T> releasingCallback(SingleResultCallback<T> wrapped, AsyncConnectionSource source) {
        return new ReferenceCountedReleasingWrappedCallback(wrapped, Collections.singletonList(source));
    }

    /* access modifiers changed from: package-private */
    public static <T> SingleResultCallback<T> releasingCallback(SingleResultCallback<T> wrapped, AsyncConnection connection) {
        return new ReferenceCountedReleasingWrappedCallback(wrapped, Collections.singletonList(connection));
    }

    /* access modifiers changed from: package-private */
    public static <T> SingleResultCallback<T> releasingCallback(SingleResultCallback<T> wrapped, AsyncConnectionSource source, AsyncConnection connection) {
        return new ReferenceCountedReleasingWrappedCallback(wrapped, Arrays.asList(connection, source));
    }

    static <T> SingleResultCallback<T> releasingCallback(SingleResultCallback<T> wrapped, AsyncReadBinding readBinding, AsyncConnectionSource source, AsyncConnection connection) {
        return new ReferenceCountedReleasingWrappedCallback(wrapped, Arrays.asList(readBinding, connection, source));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$ReferenceCountedReleasingWrappedCallback.class */
    public static class ReferenceCountedReleasingWrappedCallback<T> implements SingleResultCallback<T> {
        private final SingleResultCallback<T> wrapped;
        private final List<? extends ReferenceCounted> referenceCounted;

        ReferenceCountedReleasingWrappedCallback(SingleResultCallback<T> wrapped, List<? extends ReferenceCounted> referenceCounted) {
            this.wrapped = wrapped;
            this.referenceCounted = (List) Assertions.notNull("referenceCounted", referenceCounted);
        }

        @Override // com.mongodb.internal.async.SingleResultCallback
        public void onResult(T result, Throwable t) {
            for (ReferenceCounted cur : this.referenceCounted) {
                if (cur != null) {
                    cur.release();
                }
            }
            this.wrapped.onResult(result, t);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$ConnectionReleasingWrappedCallback.class */
    public static class ConnectionReleasingWrappedCallback<T> implements SingleResultCallback<T> {
        private final SingleResultCallback<T> wrapped;
        private final AsyncConnectionSource source;
        private final AsyncConnection connection;

        /* access modifiers changed from: package-private */
        public ConnectionReleasingWrappedCallback(SingleResultCallback<T> wrapped, AsyncConnectionSource source, AsyncConnection connection) {
            this.wrapped = wrapped;
            this.source = (AsyncConnectionSource) Assertions.notNull("source", source);
            this.connection = (AsyncConnection) Assertions.notNull("connection", connection);
        }

        @Override // com.mongodb.internal.async.SingleResultCallback
        public void onResult(T result, Throwable t) {
            this.connection.release();
            this.source.release();
            this.wrapped.onResult(result, t);
        }

        public SingleResultCallback<T> releaseConnectionAndGetWrapped() {
            this.connection.release();
            this.source.release();
            return this.wrapped;
        }
    }

    static <T> T withConnection(ReadBinding binding, CallableWithConnection<T> callable) {
        ConnectionSource source = binding.getReadConnectionSource();
        try {
            T t = (T) withConnectionSource(source, callable);
            source.release();
            return t;
        } catch (Throwable th) {
            source.release();
            throw th;
        }
    }

    static <T> T withConnection(ReadBinding binding, CallableWithConnectionAndSource<T> callable) {
        ConnectionSource source = binding.getReadConnectionSource();
        try {
            T t = (T) withConnectionSource(source, callable);
            source.release();
            return t;
        } catch (Throwable th) {
            source.release();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static <T> T withReadConnectionSource(ReadBinding binding, CallableWithSource<T> callable) {
        ConnectionSource source = binding.getReadConnectionSource();
        try {
            T call = callable.call(source);
            source.release();
            return call;
        } catch (Throwable th) {
            source.release();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static <T> T withReleasableConnection(ReadBinding binding, MongoException connectionException, CallableWithConnectionAndSource<T> callable) {
        ConnectionSource source = null;
        try {
            source = binding.getReadConnectionSource();
            try {
                T call = callable.call(source, source.getConnection());
                source.release();
                return call;
            } catch (Throwable th) {
                source.release();
                throw th;
            }
        } catch (Throwable th2) {
            if (source != null) {
                source.release();
            }
            throw connectionException;
        }
    }

    /* access modifiers changed from: package-private */
    public static <T> T withConnection(WriteBinding binding, CallableWithConnection<T> callable) {
        ConnectionSource source = binding.getWriteConnectionSource();
        try {
            T t = (T) withConnectionSource(source, callable);
            source.release();
            return t;
        } catch (Throwable th) {
            source.release();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static <T> T withReleasableConnection(WriteBinding binding, CallableWithConnectionAndSource<T> callable) {
        ConnectionSource source = binding.getWriteConnectionSource();
        try {
            T call = callable.call(source, source.getConnection());
            source.release();
            return call;
        } catch (Throwable th) {
            source.release();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static <T> T withReleasableConnection(WriteBinding binding, MongoException connectionException, CallableWithConnectionAndSource<T> callable) {
        ConnectionSource source = null;
        try {
            source = binding.getWriteConnectionSource();
            try {
                T call = callable.call(source, source.getConnection());
                source.release();
                return call;
            } catch (Throwable th) {
                source.release();
                throw th;
            }
        } catch (Throwable th2) {
            if (source != null) {
                source.release();
            }
            throw connectionException;
        }
    }

    static <T> T withConnectionSource(ConnectionSource source, CallableWithConnection<T> callable) {
        Connection connection = source.getConnection();
        try {
            T call = callable.call(connection);
            connection.release();
            return call;
        } catch (Throwable th) {
            connection.release();
            throw th;
        }
    }

    static <T> T withConnectionSource(ConnectionSource source, CallableWithConnectionAndSource<T> callable) {
        Connection connection = source.getConnection();
        try {
            T call = callable.call(source, connection);
            connection.release();
            return call;
        } catch (Throwable th) {
            connection.release();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public static void withAsyncConnection(AsyncWriteBinding binding, AsyncCallableWithConnection callable) {
        binding.getWriteConnectionSource(ErrorHandlingResultCallback.errorHandlingCallback(new AsyncCallableWithConnectionCallback(callable), LOGGER));
    }

    /* access modifiers changed from: package-private */
    public static void withAsyncConnection(AsyncWriteBinding binding, AsyncCallableWithConnectionAndSource callable) {
        binding.getWriteConnectionSource(ErrorHandlingResultCallback.errorHandlingCallback(new AsyncCallableWithConnectionAndSourceCallback(callable), LOGGER));
    }

    /* access modifiers changed from: package-private */
    public static void withAsyncReadConnection(AsyncReadBinding binding, AsyncCallableWithSource callable) {
        binding.getReadConnectionSource(ErrorHandlingResultCallback.errorHandlingCallback(new AsyncCallableWithSourceCallback(callable), LOGGER));
    }

    /* access modifiers changed from: package-private */
    public static void withAsyncReadConnection(AsyncReadBinding binding, AsyncCallableWithConnectionAndSource callable) {
        binding.getReadConnectionSource(ErrorHandlingResultCallback.errorHandlingCallback(new AsyncCallableWithConnectionAndSourceCallback(callable), LOGGER));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$AsyncCallableWithConnectionCallback.class */
    public static class AsyncCallableWithConnectionCallback implements SingleResultCallback<AsyncConnectionSource> {
        private final AsyncCallableWithConnection callable;

        AsyncCallableWithConnectionCallback(AsyncCallableWithConnection callable) {
            this.callable = callable;
        }

        public void onResult(AsyncConnectionSource source, Throwable t) {
            if (t != null) {
                this.callable.call(null, t);
            } else {
                OperationHelper.withAsyncConnectionSourceCallableConnection(source, this.callable);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$AsyncCallableWithSourceCallback.class */
    public static class AsyncCallableWithSourceCallback implements SingleResultCallback<AsyncConnectionSource> {
        private final AsyncCallableWithSource callable;

        AsyncCallableWithSourceCallback(AsyncCallableWithSource callable) {
            this.callable = callable;
        }

        public void onResult(AsyncConnectionSource source, Throwable t) {
            if (t != null) {
                this.callable.call(null, t);
            } else {
                OperationHelper.withAsyncConnectionSource(source, this.callable);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void withAsyncConnectionSourceCallableConnection(final AsyncConnectionSource source, final AsyncCallableWithConnection callable) {
        source.getConnection(new SingleResultCallback<AsyncConnection>() { // from class: com.mongodb.internal.operation.OperationHelper.8
            public void onResult(AsyncConnection connection, Throwable t) {
                AsyncConnectionSource.this.release();
                if (t != null) {
                    callable.call(null, t);
                } else {
                    callable.call(connection, null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void withAsyncConnectionSource(AsyncConnectionSource source, AsyncCallableWithSource callable) {
        callable.call(source, null);
    }

    /* access modifiers changed from: private */
    public static void withAsyncConnectionSource(final AsyncConnectionSource source, final AsyncCallableWithConnectionAndSource callable) {
        source.getConnection(new SingleResultCallback<AsyncConnection>() { // from class: com.mongodb.internal.operation.OperationHelper.9
            public void onResult(AsyncConnection result, Throwable t) {
                AsyncCallableWithConnectionAndSource.this.call(source, result, t);
            }
        });
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/operation/OperationHelper$AsyncCallableWithConnectionAndSourceCallback.class */
    public static class AsyncCallableWithConnectionAndSourceCallback implements SingleResultCallback<AsyncConnectionSource> {
        private final AsyncCallableWithConnectionAndSource callable;

        AsyncCallableWithConnectionAndSourceCallback(AsyncCallableWithConnectionAndSource callable) {
            this.callable = callable;
        }

        public void onResult(AsyncConnectionSource source, Throwable t) {
            if (t != null) {
                this.callable.call(null, null, t);
            } else {
                OperationHelper.withAsyncConnectionSource(source, this.callable);
            }
        }
    }

    private static Optional<Throwable> validateAllowDiskUse(ConnectionDescription description, Boolean allowDiskUse) {
        Optional<Throwable> throwable = Optional.empty();
        if (allowDiskUse != null && ServerVersionHelper.serverIsLessThanVersionThreeDotTwo(description)) {
            throwable = Optional.of(new IllegalArgumentException(String.format("allowDiskUse not supported by wire version: %s", Integer.valueOf(description.getMaxWireVersion()))));
        }
        return throwable;
    }

    private OperationHelper() {
    }
}
