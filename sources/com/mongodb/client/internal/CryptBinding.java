package com.mongodb.client.internal;

import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.binding.ClusterAwareReadWriteBinding;
import com.mongodb.internal.binding.ConnectionSource;
import com.mongodb.internal.binding.ReadWriteBinding;
import com.mongodb.internal.connection.Cluster;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.session.SessionContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/internal/CryptBinding.class */
public class CryptBinding implements ClusterAwareReadWriteBinding {
    private final ClusterAwareReadWriteBinding wrapped;
    private final Crypt crypt;

    /* access modifiers changed from: package-private */
    public CryptBinding(ClusterAwareReadWriteBinding wrapped, Crypt crypt) {
        this.crypt = crypt;
        this.wrapped = wrapped;
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ReadPreference getReadPreference() {
        return this.wrapped.getReadPreference();
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ConnectionSource getReadConnectionSource() {
        return new CryptConnectionSource(this.wrapped.getReadConnectionSource());
    }

    @Override // com.mongodb.internal.binding.WriteBinding
    public ConnectionSource getWriteConnectionSource() {
        return new CryptConnectionSource(this.wrapped.getWriteConnectionSource());
    }

    @Override // com.mongodb.internal.binding.ClusterAwareReadWriteBinding
    public ConnectionSource getConnectionSource(ServerAddress serverAddress) {
        return new CryptConnectionSource(this.wrapped.getConnectionSource(serverAddress));
    }

    @Override // com.mongodb.internal.binding.ReadBinding, com.mongodb.internal.binding.WriteBinding
    public SessionContext getSessionContext() {
        return this.wrapped.getSessionContext();
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
    }

    @Override // com.mongodb.internal.binding.ClusterAwareReadWriteBinding
    public Cluster getCluster() {
        return this.wrapped.getCluster();
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/internal/CryptBinding$CryptConnectionSource.class */
    private class CryptConnectionSource implements ConnectionSource {
        private final ConnectionSource wrapped;

        CryptConnectionSource(ConnectionSource wrapped) {
            this.wrapped = wrapped;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public ServerDescription getServerDescription() {
            return this.wrapped.getServerDescription();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public SessionContext getSessionContext() {
            return this.wrapped.getSessionContext();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public Connection getConnection() {
            return new CryptConnection(this.wrapped.getConnection(), CryptBinding.this.crypt);
        }

        @Override // com.mongodb.internal.binding.ReferenceCounted
        public int getCount() {
            return this.wrapped.getCount();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public ConnectionSource retain() {
            this.wrapped.retain();
            return this;
        }

        @Override // com.mongodb.internal.binding.ReferenceCounted
        public void release() {
            this.wrapped.release();
        }
    }
}
