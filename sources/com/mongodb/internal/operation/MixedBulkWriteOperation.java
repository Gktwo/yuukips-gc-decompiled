package com.mongodb.internal.operation;

import com.mongodb.MongoException;
import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.WriteConcernResult;
import com.mongodb.assertions.Assertions;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.internal.async.ErrorHandlingResultCallback;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncWriteBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.MongoWriteConcernWithResponseException;
import com.mongodb.internal.connection.ProtocolHelper;
import com.mongodb.internal.operation.OperationHelper;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.FieldNameValidator;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MixedBulkWriteOperation.class */
public class MixedBulkWriteOperation implements AsyncWriteOperation<BulkWriteResult>, WriteOperation<BulkWriteResult> {
    private static final FieldNameValidator NO_OP_FIELD_NAME_VALIDATOR = new NoOpFieldNameValidator();
    private final MongoNamespace namespace;
    private final List<? extends WriteRequest> writeRequests;
    private final boolean ordered;
    private final boolean retryWrites;
    private final WriteConcern writeConcern;
    private Boolean bypassDocumentValidation;

    public MixedBulkWriteOperation(MongoNamespace namespace, List<? extends WriteRequest> writeRequests, boolean ordered, WriteConcern writeConcern, boolean retryWrites) {
        this.ordered = ordered;
        this.namespace = (MongoNamespace) Assertions.notNull("namespace", namespace);
        this.writeRequests = (List) Assertions.notNull("writes", writeRequests);
        this.writeConcern = (WriteConcern) Assertions.notNull("writeConcern", writeConcern);
        this.retryWrites = retryWrites;
        Assertions.isTrueArgument("writes is not an empty list", !writeRequests.isEmpty());
    }

    public MongoNamespace getNamespace() {
        return this.namespace;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public boolean isOrdered() {
        return this.ordered;
    }

    public List<? extends WriteRequest> getWriteRequests() {
        return this.writeRequests;
    }

    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public MixedBulkWriteOperation bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    public Boolean getRetryWrites() {
        return Boolean.valueOf(this.retryWrites);
    }

    @Override // com.mongodb.internal.operation.WriteOperation
    public BulkWriteResult execute(final WriteBinding binding) {
        return (BulkWriteResult) OperationHelper.withReleasableConnection(binding, new OperationHelper.CallableWithConnectionAndSource<BulkWriteResult>() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.1
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnectionAndSource
            public BulkWriteResult call(ConnectionSource connectionSource, Connection connection) {
                MixedBulkWriteOperation.this.validateWriteRequestsAndReleaseConnectionIfError(binding, connection);
                if (!MixedBulkWriteOperation.this.getWriteConcern().isAcknowledged() && !ServerVersionHelper.serverIsAtLeastVersionThreeDotSix(connection.getDescription())) {
                    return MixedBulkWriteOperation.this.executeLegacyBatches(connection);
                }
                return MixedBulkWriteOperation.this.executeBulkWriteBatch(binding, connection, BulkWriteBatch.createBulkWriteBatch(MixedBulkWriteOperation.this.namespace, connectionSource.getServerDescription(), connection.getDescription(), MixedBulkWriteOperation.this.ordered, MixedBulkWriteOperation.this.getAppliedWriteConcern(binding), MixedBulkWriteOperation.this.bypassDocumentValidation, MixedBulkWriteOperation.this.retryWrites, MixedBulkWriteOperation.this.writeRequests, binding.getSessionContext()));
            }
        });
    }

    @Override // com.mongodb.internal.operation.AsyncWriteOperation
    public void executeAsync(final AsyncWriteBinding binding, SingleResultCallback<BulkWriteResult> callback) {
        final SingleResultCallback<BulkWriteResult> errHandlingCallback = ErrorHandlingResultCallback.errorHandlingCallback(callback, OperationHelper.LOGGER);
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.2
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
            public void call(final AsyncConnectionSource source, AsyncConnection connection, Throwable t) {
                if (t != null) {
                    errHandlingCallback.onResult(null, t);
                } else {
                    OperationHelper.validateWriteRequests(connection, MixedBulkWriteOperation.this.bypassDocumentValidation, MixedBulkWriteOperation.this.writeRequests, MixedBulkWriteOperation.this.getAppliedWriteConcern(binding), new OperationHelper.AsyncCallableWithConnection() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.2.1
                        @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnection
                        public void call(AsyncConnection connection2, Throwable t1) {
                            OperationHelper.ConnectionReleasingWrappedCallback<BulkWriteResult> releasingCallback = new OperationHelper.ConnectionReleasingWrappedCallback<>(errHandlingCallback, source, connection2);
                            if (t1 != null) {
                                releasingCallback.onResult(null, t1);
                            } else if (MixedBulkWriteOperation.this.getAppliedWriteConcern(binding).isAcknowledged() || ServerVersionHelper.serverIsAtLeastVersionThreeDotSix(connection2.getDescription())) {
                                try {
                                    MixedBulkWriteOperation.this.executeBatchesAsync(binding, connection2, BulkWriteBatch.createBulkWriteBatch(MixedBulkWriteOperation.this.namespace, source.getServerDescription(), connection2.getDescription(), MixedBulkWriteOperation.this.ordered, MixedBulkWriteOperation.this.getAppliedWriteConcern(binding), MixedBulkWriteOperation.this.bypassDocumentValidation, MixedBulkWriteOperation.this.retryWrites, MixedBulkWriteOperation.this.writeRequests, binding.getSessionContext()), MixedBulkWriteOperation.this.retryWrites, releasingCallback);
                                } catch (Throwable t2) {
                                    releasingCallback.onResult(null, t2);
                                }
                            } else {
                                MixedBulkWriteOperation.this.executeLegacyBatchesAsync(connection2, MixedBulkWriteOperation.this.getWriteRequests(), 1, releasingCallback);
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public BulkWriteResult executeBulkWriteBatch(WriteBinding binding, Connection connection, BulkWriteBatch originalBatch) {
        MongoException writeConcernBasedError;
        BulkWriteBatch currentBatch = originalBatch;
        MongoException exception = null;
        int maxWireVersion = connection.getDescription().getMaxWireVersion();
        while (currentBatch.shouldProcessBatch()) {
            try {
                BsonDocument result = executeCommand(connection, currentBatch, binding);
                if (!this.retryWrites || binding.getSessionContext().hasActiveTransaction() || (writeConcernBasedError = ProtocolHelper.createSpecialException(result, connection.getDescription().getServerAddress(), "errMsg")) == null || !CommandOperationHelper.shouldAttemptToRetryWrite(true, (Throwable) writeConcernBasedError, maxWireVersion)) {
                    currentBatch.addResult(result);
                    currentBatch = currentBatch.getNextBatch();
                } else {
                    throw new MongoWriteConcernWithResponseException(writeConcernBasedError, result);
                }
            } catch (MongoException e) {
                exception = e;
                connection.release();
            } catch (Throwable th) {
                connection.release();
                throw th;
            }
        }
        connection.release();
        if (exception == null) {
            try {
                return currentBatch.getResult();
            } catch (MongoException e2) {
                if (originalBatch.getRetryWrites()) {
                    CommandOperationHelper.logUnableToRetry(originalBatch.getPayload().getPayloadType().toString(), e2);
                }
                throw e2;
            }
        } else if ((exception instanceof MongoWriteConcernWithResponseException) || CommandOperationHelper.shouldAttemptToRetryWrite(originalBatch.getRetryWrites(), exception, maxWireVersion)) {
            return retryExecuteBatches(binding, currentBatch, exception);
        } else {
            if (originalBatch.getRetryWrites()) {
                CommandOperationHelper.logUnableToRetry(originalBatch.getPayload().getPayloadType().toString(), exception);
            }
            throw CommandOperationHelper.transformWriteException(exception);
        }
    }

    private BulkWriteResult retryExecuteBatches(final WriteBinding binding, final BulkWriteBatch retryBatch, final MongoException originalError) {
        CommandOperationHelper.logRetryExecute(retryBatch.getPayload().getPayloadType().toString(), originalError);
        return (BulkWriteResult) OperationHelper.withReleasableConnection(binding, originalError, new OperationHelper.CallableWithConnectionAndSource<BulkWriteResult>() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.3
            @Override // com.mongodb.internal.operation.OperationHelper.CallableWithConnectionAndSource
            public BulkWriteResult call(ConnectionSource source, Connection connection) {
                if (!OperationHelper.isRetryableWrite(MixedBulkWriteOperation.this.retryWrites, MixedBulkWriteOperation.this.getAppliedWriteConcern(binding), source.getServerDescription(), connection.getDescription(), binding.getSessionContext())) {
                    return checkMongoWriteConcernWithResponseException(connection);
                }
                try {
                    BsonDocument result = MixedBulkWriteOperation.this.executeCommand(connection, retryBatch, binding);
                    MongoException writeConcernBasedError = ProtocolHelper.createSpecialException(result, connection.getDescription().getServerAddress(), "errMsg");
                    if (writeConcernBasedError != null) {
                        CommandOperationHelper.addRetryableWriteErrorLabel(writeConcernBasedError, connection.getDescription().getMaxWireVersion());
                        MixedBulkWriteOperation.this.addErrorLabelsToWriteConcern(result.getDocument("writeConcernError"), writeConcernBasedError.getErrorLabels());
                    }
                    retryBatch.addResult(result);
                    return MixedBulkWriteOperation.this.executeBulkWriteBatch(binding, connection, retryBatch.getNextBatch());
                } catch (Throwable th) {
                    return checkMongoWriteConcernWithResponseException(connection);
                }
            }

            private BulkWriteResult checkMongoWriteConcernWithResponseException(Connection connection) {
                if (originalError instanceof MongoWriteConcernWithResponseException) {
                    retryBatch.addResult((BsonDocument) ((MongoWriteConcernWithResponseException) originalError).getResponse());
                    return MixedBulkWriteOperation.this.executeBulkWriteBatch(binding, connection, retryBatch.getNextBatch());
                }
                connection.release();
                throw originalError;
            }
        });
    }

    /* access modifiers changed from: private */
    public BulkWriteResult executeLegacyBatches(Connection connection) {
        try {
            for (WriteRequest writeRequest : getWriteRequests()) {
                if (writeRequest.getType() == WriteRequest.Type.INSERT) {
                    connection.insert(getNamespace(), isOrdered(), (InsertRequest) writeRequest);
                } else if (writeRequest.getType() == WriteRequest.Type.UPDATE || writeRequest.getType() == WriteRequest.Type.REPLACE) {
                    connection.update(getNamespace(), isOrdered(), (UpdateRequest) writeRequest);
                } else {
                    connection.delete(getNamespace(), isOrdered(), (DeleteRequest) writeRequest);
                }
            }
            BulkWriteResult unacknowledged = BulkWriteResult.unacknowledged();
            connection.release();
            return unacknowledged;
        } catch (Throwable th) {
            connection.release();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void executeBatchesAsync(AsyncWriteBinding binding, AsyncConnection connection, BulkWriteBatch batch, boolean retryWrites, OperationHelper.ConnectionReleasingWrappedCallback<BulkWriteResult> callback) {
        executeCommandAsync(binding, connection, batch, callback, getCommandCallback(binding, connection, batch, retryWrites, false, callback));
    }

    /* access modifiers changed from: private */
    public void retryExecuteBatchesAsync(final AsyncWriteBinding binding, final BulkWriteBatch retryBatch, final Throwable originalError, final SingleResultCallback<BulkWriteResult> callback) {
        CommandOperationHelper.logRetryExecute(retryBatch.getPayload().getPayloadType().toString(), originalError);
        OperationHelper.withAsyncConnection(binding, new OperationHelper.AsyncCallableWithConnectionAndSource() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.4
            @Override // com.mongodb.internal.operation.OperationHelper.AsyncCallableWithConnectionAndSource
            public void call(AsyncConnectionSource source, final AsyncConnection connection, Throwable t) {
                if (t != null) {
                    callback.onResult(null, originalError);
                    return;
                }
                final OperationHelper.ConnectionReleasingWrappedCallback<BulkWriteResult> releasingCallback = new OperationHelper.ConnectionReleasingWrappedCallback<>(callback, source, connection);
                if (!OperationHelper.isRetryableWrite(MixedBulkWriteOperation.this.retryWrites, MixedBulkWriteOperation.this.getAppliedWriteConcern(binding), source.getServerDescription(), connection.getDescription(), binding.getSessionContext())) {
                    checkMongoWriteConcernWithResponseException(connection, releasingCallback);
                } else {
                    MixedBulkWriteOperation.this.executeCommandAsync(binding, connection, retryBatch, releasingCallback, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.4.1
                        public void onResult(BsonDocument result, Throwable t2) {
                            if (t2 != null) {
                                C12264.this.checkMongoWriteConcernWithResponseException(connection, releasingCallback);
                            } else {
                                MixedBulkWriteOperation.this.getCommandCallback(binding, connection, retryBatch, true, true, releasingCallback).onResult(result, null);
                            }
                        }
                    });
                }
            }

            /* access modifiers changed from: private */
            public void checkMongoWriteConcernWithResponseException(AsyncConnection connection, OperationHelper.ConnectionReleasingWrappedCallback<BulkWriteResult> releasingCallback) {
                if (originalError instanceof MongoWriteConcernWithResponseException) {
                    retryBatch.addResult((BsonDocument) ((MongoWriteConcernWithResponseException) originalError).getResponse());
                    BulkWriteBatch nextBatch = retryBatch.getNextBatch();
                    MixedBulkWriteOperation.this.executeCommandAsync(binding, connection, nextBatch, releasingCallback, MixedBulkWriteOperation.this.getCommandCallback(binding, connection, nextBatch, true, true, releasingCallback));
                    return;
                }
                releasingCallback.onResult(null, originalError);
            }
        });
    }

    /* access modifiers changed from: private */
    public void executeLegacyBatchesAsync(final AsyncConnection connection, List<? extends WriteRequest> writeRequests, final int batchNum, final SingleResultCallback<BulkWriteResult> callback) {
        try {
            if (!writeRequests.isEmpty()) {
                WriteRequest writeRequest = (WriteRequest) writeRequests.get(0);
                final List<? extends WriteRequest> remaining = writeRequests.subList(1, writeRequests.size());
                SingleResultCallback<WriteConcernResult> writeCallback = new SingleResultCallback<WriteConcernResult>() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.5
                    public void onResult(WriteConcernResult result, Throwable t) {
                        if (t != null) {
                            callback.onResult(null, t);
                        } else {
                            MixedBulkWriteOperation.this.executeLegacyBatchesAsync(connection, remaining, batchNum + 1, callback);
                        }
                    }
                };
                if (writeRequest.getType() == WriteRequest.Type.INSERT) {
                    connection.insertAsync(getNamespace(), isOrdered(), (InsertRequest) writeRequest, writeCallback);
                } else if (writeRequest.getType() == WriteRequest.Type.UPDATE || writeRequest.getType() == WriteRequest.Type.REPLACE) {
                    connection.updateAsync(getNamespace(), isOrdered(), (UpdateRequest) writeRequest, writeCallback);
                } else {
                    connection.deleteAsync(getNamespace(), isOrdered(), (DeleteRequest) writeRequest, writeCallback);
                }
            } else {
                callback.onResult(BulkWriteResult.unacknowledged(), null);
            }
        } catch (Throwable t) {
            callback.onResult(null, t);
        }
    }

    /* access modifiers changed from: private */
    public BsonDocument executeCommand(Connection connection, BulkWriteBatch batch, WriteBinding binding) {
        return (BsonDocument) connection.command(this.namespace.getDatabaseName(), batch.getCommand(), NO_OP_FIELD_NAME_VALIDATOR, null, batch.getDecoder(), binding.getSessionContext(), shouldAcknowledge(batch, binding.getSessionContext()), batch.getPayload(), batch.getFieldNameValidator());
    }

    /* access modifiers changed from: private */
    public void executeCommandAsync(AsyncWriteBinding binding, AsyncConnection connection, BulkWriteBatch batch, OperationHelper.ConnectionReleasingWrappedCallback<BulkWriteResult> callback, SingleResultCallback<BsonDocument> commandCallback) {
        try {
            connection.commandAsync(this.namespace.getDatabaseName(), batch.getCommand(), NO_OP_FIELD_NAME_VALIDATOR, null, batch.getDecoder(), binding.getSessionContext(), shouldAcknowledge(batch, binding.getSessionContext()), batch.getPayload(), batch.getFieldNameValidator(), commandCallback);
        } catch (Throwable t) {
            callback.onResult(null, t);
        }
    }

    /* access modifiers changed from: private */
    public WriteConcern getAppliedWriteConcern(WriteBinding binding) {
        return getAppliedWriteConcern(binding.getSessionContext());
    }

    /* access modifiers changed from: private */
    public WriteConcern getAppliedWriteConcern(AsyncWriteBinding binding) {
        return getAppliedWriteConcern(binding.getSessionContext());
    }

    private WriteConcern getAppliedWriteConcern(SessionContext sessionContext) {
        if (sessionContext.hasActiveTransaction()) {
            return WriteConcern.ACKNOWLEDGED;
        }
        return this.writeConcern;
    }

    private boolean shouldAcknowledge(BulkWriteBatch batch, SessionContext sessionContext) {
        if (this.ordered) {
            return batch.hasAnotherBatch() || getAppliedWriteConcern(sessionContext).isAcknowledged();
        }
        return getAppliedWriteConcern(sessionContext).isAcknowledged();
    }

    /* access modifiers changed from: private */
    public SingleResultCallback<BsonDocument> getCommandCallback(final AsyncWriteBinding binding, final AsyncConnection connection, final BulkWriteBatch batch, final boolean retryWrites, final boolean isSecondAttempt, final OperationHelper.ConnectionReleasingWrappedCallback<BulkWriteResult> callback) {
        final int maxWireVersion = connection.getDescription().getMaxWireVersion();
        return new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.operation.MixedBulkWriteOperation.6
            public void onResult(BsonDocument result, Throwable t) {
                if (t == null) {
                    MongoException writeConcernBasedError = ProtocolHelper.createSpecialException(result, connection.getDescription().getServerAddress(), "errMsg");
                    if (writeConcernBasedError != null && CommandOperationHelper.shouldAttemptToRetryWrite(retryWrites, writeConcernBasedError, maxWireVersion)) {
                        if (!retryWrites || isSecondAttempt) {
                            MixedBulkWriteOperation.this.addErrorLabelsToWriteConcern(result.getDocument("writeConcernError"), writeConcernBasedError.getErrorLabels());
                        } else {
                            MixedBulkWriteOperation.this.retryExecuteBatchesAsync(binding, batch, new MongoWriteConcernWithResponseException(writeConcernBasedError, result), callback.releaseConnectionAndGetWrapped());
                            return;
                        }
                    }
                    MixedBulkWriteOperation.this.addBatchResult(result, binding, connection, batch, retryWrites, callback);
                } else if (isSecondAttempt || !CommandOperationHelper.shouldAttemptToRetryWrite(retryWrites, t, maxWireVersion)) {
                    if (retryWrites && !isSecondAttempt) {
                        CommandOperationHelper.logUnableToRetry(batch.getPayload().getPayloadType().toString(), t);
                    }
                    if (t instanceof MongoWriteConcernWithResponseException) {
                        MixedBulkWriteOperation.this.addBatchResult((BsonDocument) ((MongoWriteConcernWithResponseException) t).getResponse(), binding, connection, batch, retryWrites, callback);
                    } else {
                        callback.onResult(null, t instanceof MongoException ? CommandOperationHelper.transformWriteException((MongoException) t) : t);
                    }
                } else {
                    MixedBulkWriteOperation.this.retryExecuteBatchesAsync(binding, batch, t, callback.releaseConnectionAndGetWrapped());
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void addBatchResult(BsonDocument result, AsyncWriteBinding binding, AsyncConnection connection, BulkWriteBatch batch, boolean retryWrites, OperationHelper.ConnectionReleasingWrappedCallback<BulkWriteResult> callback) {
        batch.addResult(result);
        BulkWriteBatch nextBatch = batch.getNextBatch();
        if (nextBatch.shouldProcessBatch()) {
            executeBatchesAsync(binding, connection, nextBatch, retryWrites, callback);
        } else if (batch.hasErrors()) {
            if (retryWrites) {
                CommandOperationHelper.logUnableToRetry(batch.getPayload().getPayloadType().toString(), batch.getError());
            }
            callback.onResult(null, CommandOperationHelper.transformWriteException(batch.getError()));
        } else {
            callback.onResult(batch.getResult(), null);
        }
    }

    /* access modifiers changed from: private */
    public void addErrorLabelsToWriteConcern(BsonDocument result, Set<String> errorLabels) {
        if (!result.containsKey("errorLabels")) {
            result.put("errorLabels", (BsonValue) new BsonArray((List) errorLabels.stream().map(BsonString::new).collect(Collectors.toList())));
        }
    }

    /* access modifiers changed from: private */
    public void validateWriteRequestsAndReleaseConnectionIfError(WriteBinding binding, Connection connection) {
        try {
            OperationHelper.validateWriteRequests(connection.getDescription(), this.bypassDocumentValidation, this.writeRequests, getAppliedWriteConcern(binding));
        } catch (MongoException e) {
            connection.release();
            throw e;
        } catch (IllegalArgumentException e2) {
            connection.release();
            throw e2;
        } catch (Throwable t) {
            connection.release();
            throw MongoException.fromThrowableNonNull(t);
        }
    }
}
