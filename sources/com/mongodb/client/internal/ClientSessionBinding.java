package com.mongodb.client.internal;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.ClientSession;
import com.mongodb.connection.ClusterType;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.binding.ClusterAwareReadWriteBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadWriteBinding;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.selector.ReadPreferenceServerSelector;
import com.mongodb.internal.session.ClientSessionContext;
import com.mongodb.internal.session.SessionContext;
import org.bson.assertions.Assertions;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/ClientSessionBinding.class */
public class ClientSessionBinding implements ReadWriteBinding {
    private final ClusterAwareReadWriteBinding wrapped;
    private final ClientSession session;
    private final boolean ownsSession;
    private final ClientSessionContext sessionContext;

    public ClientSessionBinding(ClientSession session, boolean ownsSession, ClusterAwareReadWriteBinding wrapped) {
        this.wrapped = wrapped;
        this.session = (ClientSession) Assertions.notNull("session", session);
        this.ownsSession = ownsSession;
        this.sessionContext = new SyncClientSessionContext(session);
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ReadPreference getReadPreference() {
        return this.wrapped.getReadPreference();
    }

    @Override // com.mongodb.internal.binding.ReferenceCounted
    public int getCount() {
        return this.wrapped.getCount();
    }

    @Override // com.mongodb.internal.binding.ReadWriteBinding, com.mongodb.internal.binding.ReadBinding, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public ReadWriteBinding retain() {
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

    @Override // com.mongodb.internal.binding.ReadBinding
    public ConnectionSource getReadConnectionSource() {
        if (isActiveShardedTxn()) {
            return new SessionBindingConnectionSource(this.wrapped.getConnectionSource(pinServer()));
        }
        return new SessionBindingConnectionSource(this.wrapped.getReadConnectionSource());
    }

    @Override // com.mongodb.internal.binding.WriteBinding
    public ConnectionSource getWriteConnectionSource() {
        if (isActiveShardedTxn()) {
            return new SessionBindingConnectionSource(this.wrapped.getConnectionSource(pinServer()));
        }
        return new SessionBindingConnectionSource(this.wrapped.getWriteConnectionSource());
    }

    @Override // com.mongodb.internal.binding.ReadBinding, com.mongodb.internal.binding.WriteBinding
    public SessionContext getSessionContext() {
        return this.sessionContext;
    }

    private boolean isActiveShardedTxn() {
        return this.session.hasActiveTransaction() && this.wrapped.getCluster().getDescription().getType() == ClusterType.SHARDED;
    }

    private ServerAddress pinServer() {
        ServerAddress pinnedServerAddress = this.session.getPinnedServerAddress();
        if (pinnedServerAddress == null) {
            pinnedServerAddress = this.wrapped.getCluster().selectServer(new ReadPreferenceServerSelector(this.wrapped.getReadPreference())).getServerDescription().getAddress();
            this.session.setPinnedServerAddress(pinnedServerAddress);
        }
        return pinnedServerAddress;
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/internal/ClientSessionBinding$SessionBindingConnectionSource.class */
    private class SessionBindingConnectionSource implements ConnectionSource {
        private ConnectionSource wrapped;

        SessionBindingConnectionSource(ConnectionSource wrapped) {
            this.wrapped = wrapped;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public ServerDescription getServerDescription() {
            return this.wrapped.getServerDescription();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public SessionContext getSessionContext() {
            return ClientSessionBinding.this.sessionContext;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public Connection getConnection() {
            return this.wrapped.getConnection();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public ConnectionSource retain() {
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

    /* loaded from: grasscutter.jar:com/mongodb/client/internal/ClientSessionBinding$SyncClientSessionContext.class */
    private final class SyncClientSessionContext extends ClientSessionContext implements SessionContext {
        private final ClientSession clientSession;

        SyncClientSessionContext(ClientSession clientSession) {
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
}
