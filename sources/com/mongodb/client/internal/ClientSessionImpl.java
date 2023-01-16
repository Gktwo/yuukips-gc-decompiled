package com.mongodb.client.internal;

import com.mongodb.ClientSessionOptions;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.ReadConcern;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.TransactionBody;
import com.mongodb.internal.operation.AbortTransactionOperation;
import com.mongodb.internal.operation.CommitTransactionOperation;
import com.mongodb.internal.session.BaseClientSessionImpl;
import com.mongodb.internal.session.ServerSessionPool;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/ClientSessionImpl.class */
public final class ClientSessionImpl extends BaseClientSessionImpl implements ClientSession {
    private static final int MAX_RETRY_TIME_LIMIT_MS = 120000;
    private final MongoClientDelegate delegate;
    private TransactionState transactionState = TransactionState.NONE;
    private boolean messageSentInCurrentTransaction;
    private boolean commitInProgress;
    private TransactionOptions transactionOptions;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/internal/ClientSessionImpl$TransactionState.class */
    public enum TransactionState {
        NONE,
        IN,
        COMMITTED,
        ABORTED
    }

    /* access modifiers changed from: package-private */
    public ClientSessionImpl(ServerSessionPool serverSessionPool, Object originator, ClientSessionOptions options, MongoClientDelegate delegate) {
        super(serverSessionPool, originator, options);
        this.delegate = delegate;
    }

    @Override // com.mongodb.client.ClientSession
    public boolean hasActiveTransaction() {
        return this.transactionState == TransactionState.IN || (this.transactionState == TransactionState.COMMITTED && this.commitInProgress);
    }

    @Override // com.mongodb.client.ClientSession
    public boolean notifyMessageSent() {
        if (hasActiveTransaction()) {
            boolean firstMessageInCurrentTransaction = !this.messageSentInCurrentTransaction;
            this.messageSentInCurrentTransaction = true;
            return firstMessageInCurrentTransaction;
        } else if (this.transactionState != TransactionState.COMMITTED && this.transactionState != TransactionState.ABORTED) {
            return false;
        } else {
            cleanupTransaction(TransactionState.NONE);
            return false;
        }
    }

    @Override // com.mongodb.client.ClientSession
    public TransactionOptions getTransactionOptions() {
        Assertions.isTrue("in transaction", this.transactionState == TransactionState.IN || this.transactionState == TransactionState.COMMITTED);
        return this.transactionOptions;
    }

    @Override // com.mongodb.client.ClientSession
    public void startTransaction() {
        startTransaction(TransactionOptions.builder().build());
    }

    @Override // com.mongodb.client.ClientSession
    public void startTransaction(TransactionOptions transactionOptions) {
        Assertions.notNull("transactionOptions", transactionOptions);
        if (this.transactionState == TransactionState.IN) {
            throw new IllegalStateException("Transaction already in progress");
        }
        if (this.transactionState == TransactionState.COMMITTED) {
            cleanupTransaction(TransactionState.IN);
        } else {
            this.transactionState = TransactionState.IN;
        }
        getServerSession().advanceTransactionNumber();
        this.transactionOptions = TransactionOptions.merge(transactionOptions, getOptions().getDefaultTransactionOptions());
        WriteConcern writeConcern = this.transactionOptions.getWriteConcern();
        if (writeConcern == null) {
            throw new MongoInternalException("Invariant violated.  Transaction options write concern can not be null");
        } else if (!writeConcern.isAcknowledged()) {
            throw new MongoClientException("Transactions do not support unacknowledged write concern");
        } else {
            setPinnedServerAddress(null);
        }
    }

    @Override // com.mongodb.client.ClientSession
    public void commitTransaction() {
        if (this.transactionState == TransactionState.ABORTED) {
            throw new IllegalStateException("Cannot call commitTransaction after calling abortTransaction");
        }
        try {
            if (this.transactionState == TransactionState.NONE) {
                throw new IllegalStateException("There is no transaction started");
            }
            try {
                if (this.messageSentInCurrentTransaction) {
                    ReadConcern readConcern = this.transactionOptions.getReadConcern();
                    if (readConcern == null) {
                        throw new MongoInternalException("Invariant violated.  Transaction options read concern can not be null");
                    }
                    this.commitInProgress = true;
                    this.delegate.getOperationExecutor().execute(new CommitTransactionOperation(this.transactionOptions.getWriteConcern(), this.transactionState == TransactionState.COMMITTED).recoveryToken(getRecoveryToken()).maxCommitTime(this.transactionOptions.getMaxCommitTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS), readConcern, this);
                }
            } catch (MongoException e) {
                unpinServerAddressOnError(e);
                throw e;
            }
        } finally {
            this.transactionState = TransactionState.COMMITTED;
            this.commitInProgress = false;
        }
    }

    @Override // com.mongodb.client.ClientSession
    public void abortTransaction() {
        if (this.transactionState == TransactionState.ABORTED) {
            throw new IllegalStateException("Cannot call abortTransaction twice");
        } else if (this.transactionState == TransactionState.COMMITTED) {
            throw new IllegalStateException("Cannot call abortTransaction after calling commitTransaction");
        } else {
            try {
                if (this.transactionState == TransactionState.NONE) {
                    throw new IllegalStateException("There is no transaction started");
                }
                if (this.messageSentInCurrentTransaction) {
                    ReadConcern readConcern = this.transactionOptions.getReadConcern();
                    if (readConcern == null) {
                        throw new MongoInternalException("Invariant violated.  Transaction options read concern can not be null");
                    }
                    this.delegate.getOperationExecutor().execute(new AbortTransactionOperation(this.transactionOptions.getWriteConcern()).recoveryToken(getRecoveryToken()), readConcern, this);
                }
            } catch (Exception e) {
                if (e instanceof MongoException) {
                    unpinServerAddressOnError((MongoException) e);
                }
            } finally {
                cleanupTransaction(TransactionState.ABORTED);
            }
        }
    }

    private void unpinServerAddressOnError(MongoException e) {
        if (e.hasErrorLabel(MongoException.TRANSIENT_TRANSACTION_ERROR_LABEL) || e.hasErrorLabel(MongoException.UNKNOWN_TRANSACTION_COMMIT_RESULT_LABEL)) {
            setPinnedServerAddress(null);
        }
    }

    @Override // com.mongodb.client.ClientSession
    public <T> T withTransaction(TransactionBody<T> transactionBody) {
        return (T) withTransaction(transactionBody, TransactionOptions.builder().build());
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6 A[EDGE_INSN: B:40:0x00a6->B:28:0x00a6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x000e A[SYNTHETIC] */
    @Override // com.mongodb.client.ClientSession
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T withTransaction(com.mongodb.client.TransactionBody<T> r6, com.mongodb.TransactionOptions r7) {
        /*
            r5 = this;
            java.lang.String r0 = "transactionBody"
            r1 = r6
            java.lang.Object r0 = com.mongodb.assertions.Assertions.notNull(r0, r1)
            com.mongodb.client.internal.ClientSessionClock r0 = com.mongodb.client.internal.ClientSessionClock.INSTANCE
            long r0 = r0.now()
            r8 = r0
        L_0x000e:
            r0 = r5
            r1 = r7
            r0.startTransaction(r1)     // Catch: RuntimeException -> 0x001e
            r0 = r6
            java.lang.Object r0 = r0.execute()     // Catch: RuntimeException -> 0x001e
            r10 = r0
            goto L_0x0058
        L_0x001e:
            r11 = move-exception
            r0 = r5
            com.mongodb.client.internal.ClientSessionImpl$TransactionState r0 = r0.transactionState
            com.mongodb.client.internal.ClientSessionImpl$TransactionState r1 = com.mongodb.client.internal.ClientSessionImpl.TransactionState.IN
            if (r0 != r1) goto L_0x002e
            r0 = r5
            r0.abortTransaction()
        L_0x002e:
            r0 = r11
            boolean r0 = r0 instanceof com.mongodb.MongoException
            if (r0 == 0) goto L_0x0055
            r0 = r11
            com.mongodb.MongoException r0 = (com.mongodb.MongoException) r0
            java.lang.String r1 = "TransientTransactionError"
            boolean r0 = r0.hasErrorLabel(r1)
            if (r0 == 0) goto L_0x0055
            com.mongodb.client.internal.ClientSessionClock r0 = com.mongodb.client.internal.ClientSessionClock.INSTANCE
            long r0 = r0.now()
            r1 = r8
            long r0 = r0 - r1
            r1 = 120000(0x1d4c0, double:5.9288E-319)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0055
            goto L_0x000e
        L_0x0055:
            r0 = r11
            throw r0
        L_0x0058:
            r0 = r5
            com.mongodb.client.internal.ClientSessionImpl$TransactionState r0 = r0.transactionState
            com.mongodb.client.internal.ClientSessionImpl$TransactionState r1 = com.mongodb.client.internal.ClientSessionImpl.TransactionState.IN
            if (r0 != r1) goto L_0x00a9
        L_0x0062:
            r0 = r5
            r0.commitTransaction()     // Catch: MongoException -> 0x0069
            goto L_0x00a9
        L_0x0069:
            r11 = move-exception
            r0 = r5
            r1 = r11
            r0.unpinServerAddressOnError(r1)
            com.mongodb.client.internal.ClientSessionClock r0 = com.mongodb.client.internal.ClientSessionClock.INSTANCE
            long r0 = r0.now()
            r1 = r8
            long r0 = r0 - r1
            r1 = 120000(0x1d4c0, double:5.9288E-319)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a6
            r0 = r5
            r0.applyMajorityWriteConcernToTransactionOptions()
            r0 = r11
            boolean r0 = r0 instanceof com.mongodb.MongoExecutionTimeoutException
            if (r0 != 0) goto L_0x0099
            r0 = r11
            java.lang.String r1 = "UnknownTransactionCommitResult"
            boolean r0 = r0.hasErrorLabel(r1)
            if (r0 == 0) goto L_0x0099
            goto L_0x0062
        L_0x0099:
            r0 = r11
            java.lang.String r1 = "TransientTransactionError"
            boolean r0 = r0.hasErrorLabel(r1)
            if (r0 == 0) goto L_0x00a6
            goto L_0x000e
        L_0x00a6:
            r0 = r11
            throw r0
        L_0x00a9:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.client.internal.ClientSessionImpl.withTransaction(com.mongodb.client.TransactionBody, com.mongodb.TransactionOptions):java.lang.Object");
    }

    private void applyMajorityWriteConcernToTransactionOptions() {
        if (this.transactionOptions != null) {
            WriteConcern writeConcern = this.transactionOptions.getWriteConcern();
            if (writeConcern != null) {
                this.transactionOptions = TransactionOptions.merge(TransactionOptions.builder().writeConcern(writeConcern.withW("majority")).build(), this.transactionOptions);
            } else {
                this.transactionOptions = TransactionOptions.merge(TransactionOptions.builder().writeConcern(WriteConcern.MAJORITY).build(), this.transactionOptions);
            }
        } else {
            this.transactionOptions = TransactionOptions.builder().writeConcern(WriteConcern.MAJORITY).build();
        }
    }

    @Override // com.mongodb.internal.session.BaseClientSessionImpl, com.mongodb.session.ClientSession, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            if (this.transactionState == TransactionState.IN) {
                abortTransaction();
            }
        } finally {
            close();
        }
    }

    private void cleanupTransaction(TransactionState nextState) {
        this.messageSentInCurrentTransaction = false;
        this.transactionOptions = null;
        this.transactionState = nextState;
    }
}
