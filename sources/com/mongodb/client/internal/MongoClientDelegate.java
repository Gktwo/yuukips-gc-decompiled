package com.mongodb.client.internal;

import com.mongodb.ClientSessionOptions;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.MongoQueryException;
import com.mongodb.MongoSocketException;
import com.mongodb.MongoTimeoutException;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.binding.ClusterAwareReadWriteBinding;
import com.mongodb.internal.binding.ClusterBinding;
import com.mongodb.internal.binding.ReadBinding;
import com.mongodb.internal.binding.ReadWriteBinding;
import com.mongodb.internal.binding.WriteBinding;
import com.mongodb.internal.connection.Cluster;
import com.mongodb.internal.connection.ClusterDescriptionHelper;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.WriteOperation;
import com.mongodb.internal.session.ServerSessionPool;
import com.mongodb.lang.Nullable;
import com.mongodb.selector.ServerSelector;
import java.util.List;
import org.bson.codecs.configuration.CodecRegistry;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/MongoClientDelegate.class */
public final class MongoClientDelegate {
    private final Cluster cluster;
    private final ServerSessionPool serverSessionPool;
    private final Object originator;
    private final OperationExecutor operationExecutor;
    private final Crypt crypt;
    private final CodecRegistry codecRegistry;

    /* access modifiers changed from: package-private */
    public MongoClientDelegate(Cluster cluster, CodecRegistry codecRegistry, Object originator, @Nullable OperationExecutor operationExecutor, @Nullable Crypt crypt) {
        this.cluster = cluster;
        this.codecRegistry = codecRegistry;
        this.serverSessionPool = new ServerSessionPool(cluster);
        this.originator = originator;
        this.operationExecutor = operationExecutor == null ? new DelegateOperationExecutor() : operationExecutor;
        this.crypt = crypt;
    }

    public OperationExecutor getOperationExecutor() {
        return this.operationExecutor;
    }

    @Nullable
    public ClientSession createClientSession(ClientSessionOptions options, ReadConcern readConcern, WriteConcern writeConcern, ReadPreference readPreference) {
        Assertions.notNull("readConcern", readConcern);
        Assertions.notNull("writeConcern", writeConcern);
        Assertions.notNull("readPreference", readPreference);
        if (getConnectedClusterDescription().getLogicalSessionTimeoutMinutes() == null) {
            return null;
        }
        return new ClientSessionImpl(this.serverSessionPool, this.originator, ClientSessionOptions.builder(options).defaultTransactionOptions(TransactionOptions.merge(options.getDefaultTransactionOptions(), TransactionOptions.builder().readConcern(readConcern).writeConcern(writeConcern).readPreference(readPreference).build())).build(), this);
    }

    public void close() {
        if (this.crypt != null) {
            this.crypt.close();
        }
        this.serverSessionPool.close();
        this.cluster.close();
    }

    public Cluster getCluster() {
        return this.cluster;
    }

    public CodecRegistry getCodecRegistry() {
        return this.codecRegistry;
    }

    public ServerSessionPool getServerSessionPool() {
        return this.serverSessionPool;
    }

    private ClusterDescription getConnectedClusterDescription() {
        ClusterDescription clusterDescription = this.cluster.getDescription();
        if (getServerDescriptionListToConsiderForSessionSupport(clusterDescription).isEmpty()) {
            this.cluster.selectServer(new ServerSelector() { // from class: com.mongodb.client.internal.MongoClientDelegate.1
                @Override // com.mongodb.selector.ServerSelector
                public List<ServerDescription> select(ClusterDescription clusterDescription2) {
                    return MongoClientDelegate.this.getServerDescriptionListToConsiderForSessionSupport(clusterDescription2);
                }
            });
            clusterDescription = this.cluster.getDescription();
        }
        return clusterDescription;
    }

    /* access modifiers changed from: private */
    public List<ServerDescription> getServerDescriptionListToConsiderForSessionSupport(ClusterDescription clusterDescription) {
        if (clusterDescription.getConnectionMode() == ClusterConnectionMode.SINGLE) {
            return ClusterDescriptionHelper.getAny(clusterDescription);
        }
        return ClusterDescriptionHelper.getAnyPrimaryOrSecondary(clusterDescription);
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/internal/MongoClientDelegate$DelegateOperationExecutor.class */
    private class DelegateOperationExecutor implements OperationExecutor {
        private DelegateOperationExecutor() {
        }

        @Override // com.mongodb.client.internal.OperationExecutor
        public <T> T execute(ReadOperation<T> operation, ReadPreference readPreference, ReadConcern readConcern) {
            return (T) execute(operation, readPreference, readConcern, null);
        }

        @Override // com.mongodb.client.internal.OperationExecutor
        public <T> T execute(WriteOperation<T> operation, ReadConcern readConcern) {
            return (T) execute(operation, readConcern, (ClientSession) null);
        }

        @Override // com.mongodb.client.internal.OperationExecutor
        public <T> T execute(ReadOperation<T> operation, ReadPreference readPreference, ReadConcern readConcern, @Nullable ClientSession session) {
            ReadBinding binding;
            ClientSession actualClientSession = getClientSession(session);
            try {
                binding = getReadBinding(readPreference, readConcern, actualClientSession, session == null && actualClientSession != null);
                if (session != null) {
                    try {
                        if (session.hasActiveTransaction() && !binding.getReadPreference().equals(ReadPreference.primary())) {
                            throw new MongoClientException("Read preference in a transaction must be primary");
                        }
                    } catch (MongoException e) {
                        labelException(session, e);
                        unpinServerAddressOnTransientTransactionError(session, e);
                        throw e;
                    }
                }
                T execute = operation.execute(binding);
                binding.release();
                return execute;
            } catch (Throwable th) {
                binding.release();
                throw th;
            }
        }

        @Override // com.mongodb.client.internal.OperationExecutor
        public <T> T execute(WriteOperation<T> operation, ReadConcern readConcern, @Nullable ClientSession session) {
            WriteBinding binding;
            ClientSession actualClientSession = getClientSession(session);
            try {
                binding = getWriteBinding(readConcern, actualClientSession, session == null && actualClientSession != null);
                try {
                    T execute = operation.execute(binding);
                    binding.release();
                    return execute;
                } catch (MongoException e) {
                    labelException(session, e);
                    unpinServerAddressOnTransientTransactionError(session, e);
                    throw e;
                }
            } catch (Throwable th) {
                binding.release();
                throw th;
            }
        }

        WriteBinding getWriteBinding(ReadConcern readConcern, @Nullable ClientSession session, boolean ownsSession) {
            return getReadWriteBinding(ReadPreference.primary(), readConcern, session, ownsSession);
        }

        ReadBinding getReadBinding(ReadPreference readPreference, ReadConcern readConcern, @Nullable ClientSession session, boolean ownsSession) {
            return getReadWriteBinding(readPreference, readConcern, session, ownsSession);
        }

        ReadWriteBinding getReadWriteBinding(ReadPreference readPreference, ReadConcern readConcern, @Nullable ClientSession session, boolean ownsSession) {
            ClusterAwareReadWriteBinding readWriteBinding = new ClusterBinding(MongoClientDelegate.this.cluster, getReadPreferenceForBinding(readPreference, session), readConcern);
            if (MongoClientDelegate.this.crypt != null) {
                readWriteBinding = new CryptBinding(readWriteBinding, MongoClientDelegate.this.crypt);
            }
            if (session != null) {
                return new ClientSessionBinding(session, ownsSession, readWriteBinding);
            }
            return readWriteBinding;
        }

        private void labelException(@Nullable ClientSession session, MongoException e) {
            if (session != null && session.hasActiveTransaction()) {
                if (((e instanceof MongoSocketException) || (e instanceof MongoTimeoutException) || ((e instanceof MongoQueryException) && e.getCode() == 91)) && !e.hasErrorLabel(MongoException.UNKNOWN_TRANSACTION_COMMIT_RESULT_LABEL)) {
                    e.addLabel(MongoException.TRANSIENT_TRANSACTION_ERROR_LABEL);
                }
            }
        }

        private void unpinServerAddressOnTransientTransactionError(@Nullable ClientSession session, MongoException e) {
            if (session != null && e.hasErrorLabel(MongoException.TRANSIENT_TRANSACTION_ERROR_LABEL)) {
                session.setPinnedServerAddress(null);
            }
        }

        private ReadPreference getReadPreferenceForBinding(ReadPreference readPreference, @Nullable ClientSession session) {
            if (session == null) {
                return readPreference;
            }
            if (!session.hasActiveTransaction()) {
                return readPreference;
            }
            ReadPreference readPreferenceForBinding = session.getTransactionOptions().getReadPreference();
            if (readPreferenceForBinding != null) {
                return readPreferenceForBinding;
            }
            throw new MongoInternalException("Invariant violated.  Transaction options read preference can not be null");
        }

        @Nullable
        ClientSession getClientSession(@Nullable ClientSession clientSessionFromOperation) {
            ClientSession session;
            if (clientSessionFromOperation != null) {
                Assertions.isTrue("ClientSession from same MongoClient", clientSessionFromOperation.getOriginator() == MongoClientDelegate.this.originator);
                session = clientSessionFromOperation;
            } else {
                session = MongoClientDelegate.this.createClientSession(ClientSessionOptions.builder().causallyConsistent(false).build(), ReadConcern.DEFAULT, WriteConcern.ACKNOWLEDGED, ReadPreference.primary());
            }
            return session;
        }
    }
}
