package com.mongodb.internal.async.client;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterType;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.binding.AsyncClusterAwareReadWriteBinding;
import com.mongodb.internal.binding.AsyncConnectionSource;
import com.mongodb.internal.binding.AsyncReadWriteBinding;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.ServerTuple;
import com.mongodb.internal.selector.ReadPreferenceServerSelector;
import com.mongodb.internal.session.ClientSessionContext;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/async/client/ClientSessionBinding.class */
public class ClientSessionBinding implements AsyncReadWriteBinding {
    private final AsyncClusterAwareReadWriteBinding wrapped;
    private final AsyncClientSession session;
    private final boolean ownsSession;
    private final ClientSessionContext sessionContext;

    public ClientSessionBinding(AsyncClientSession session, boolean ownsSession, AsyncClusterAwareReadWriteBinding wrapped) {
        this.wrapped = (AsyncClusterAwareReadWriteBinding) Assertions.notNull("wrapped", wrapped);
        this.ownsSession = ownsSession;
        this.session = (AsyncClientSession) Assertions.notNull("session", session);
        this.sessionContext = new AsyncClientSessionContext(session);
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding
    public ReadPreference getReadPreference() {
        return this.wrapped.getReadPreference();
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding
    public void getReadConnectionSource(SingleResultCallback<AsyncConnectionSource> callback) {
        if (isActiveShardedTxn()) {
            getPinnedConnectionSource(callback);
        } else {
            this.wrapped.getReadConnectionSource(new WrappingCallback(callback));
        }
    }

    @Override // com.mongodb.internal.binding.AsyncWriteBinding
    public void getWriteConnectionSource(SingleResultCallback<AsyncConnectionSource> callback) {
        if (isActiveShardedTxn()) {
            getPinnedConnectionSource(callback);
        } else {
            this.wrapped.getWriteConnectionSource(new WrappingCallback(callback));
        }
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding, com.mongodb.internal.binding.AsyncWriteBinding
    public SessionContext getSessionContext() {
        return this.sessionContext;
    }

    private void getPinnedConnectionSource(final SingleResultCallback<AsyncConnectionSource> callback) {
        if (this.session.getPinnedServerAddress() == null) {
            this.wrapped.getCluster().selectServerAsync(new ReadPreferenceServerSelector(this.wrapped.getReadPreference()), new SingleResultCallback<ServerTuple>() { // from class: com.mongodb.internal.async.client.ClientSessionBinding.1
                public void onResult(ServerTuple serverTuple, Throwable t) {
                    if (t != null) {
                        callback.onResult(null, t);
                        return;
                    }
                    ClientSessionBinding.this.session.setPinnedServerAddress(serverTuple.getServerDescription().getAddress());
                    ClientSessionBinding.this.wrapped.getConnectionSource(ClientSessionBinding.this.session.getPinnedServerAddress(), new WrappingCallback(callback));
                }
            });
        } else {
            this.wrapped.getConnectionSource(this.session.getPinnedServerAddress(), new WrappingCallback(callback));
        }
    }

    @Override // com.mongodb.internal.binding.ReferenceCounted
    public int getCount() {
        return this.wrapped.getCount();
    }

    @Override // com.mongodb.internal.binding.AsyncReadWriteBinding, com.mongodb.internal.binding.AsyncReadBinding, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public AsyncReadWriteBinding retain() {
        this.wrapped.retain();
        return this;
    }

    @Override // com.mongodb.internal.binding.ReferenceCounted
    public void release() {
        this.wrapped.release();
        closeSessionIfCountIsZero();
    }

    /* access modifiers changed from: private */
    public void closeSessionIfCountIsZero() {
        if (getCount() == 0 && this.ownsSession) {
            this.session.close();
        }
    }

    private boolean isActiveShardedTxn() {
        return this.session.hasActiveTransaction() && this.wrapped.getCluster().getDescription().getType() == ClusterType.SHARDED;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/async/client/ClientSessionBinding$SessionBindingAsyncConnectionSource.class */
    public class SessionBindingAsyncConnectionSource implements AsyncConnectionSource {
        private AsyncConnectionSource wrapped;

        SessionBindingAsyncConnectionSource(AsyncConnectionSource wrapped) {
            this.wrapped = wrapped;
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public ServerDescription getServerDescription() {
            return this.wrapped.getServerDescription();
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public SessionContext getSessionContext() {
            return ClientSessionBinding.this.sessionContext;
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public void getConnection(SingleResultCallback<AsyncConnection> callback) {
            this.wrapped.getConnection(callback);
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public AsyncConnectionSource retain() {
            this.wrapped = this.wrapped.retain();
            return this;
        }

        @Override // com.mongodb.internal.binding.ReferenceCounted
        public int getCount() {
            return this.wrapped.getCount();
        }

        @Override // com.mongodb.internal.binding.ReferenceCounted
        public void release() {
            this.wrapped.release();
            ClientSessionBinding.this.closeSessionIfCountIsZero();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/async/client/ClientSessionBinding$AsyncClientSessionContext.class */
    private final class AsyncClientSessionContext extends ClientSessionContext implements SessionContext {
        private final AsyncClientSession clientSession;

        AsyncClientSessionContext(AsyncClientSession clientSession) {
            super(clientSession);
            this.clientSession = clientSession;
        }

        @Override // com.mongodb.internal.session.SessionContext
        public boolean isImplicitSession() {
            return ClientSessionBinding.this.ownsSession;
        }

        @Override // com.mongodb.internal.session.SessionContext
        public boolean notifyMessageSent() {
            return this.clientSession.notifyMessageSent();
        }

        @Override // com.mongodb.internal.session.SessionContext
        public boolean hasActiveTransaction() {
            return this.clientSession.hasActiveTransaction();
        }

        @Override // com.mongodb.internal.session.SessionContext
        public ReadConcern getReadConcern() {
            if (this.clientSession.hasActiveTransaction()) {
                return this.clientSession.getTransactionOptions().getReadConcern();
            }
            return ClientSessionBinding.this.wrapped.getSessionContext().getReadConcern();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/async/client/ClientSessionBinding$WrappingCallback.class */
    public class WrappingCallback implements SingleResultCallback<AsyncConnectionSource> {
        private final SingleResultCallback<AsyncConnectionSource> callback;

        WrappingCallback(SingleResultCallback<AsyncConnectionSource> callback) {
            this.callback = callback;
        }

        public void onResult(AsyncConnectionSource result, Throwable t) {
            if (t != null) {
                this.callback.onResult(null, t);
            } else {
                this.callback.onResult(new SessionBindingAsyncConnectionSource(result), null);
            }
        }
    }
}
