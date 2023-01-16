package com.mongodb.internal.binding;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.Cluster;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.ReadConcernAwareNoOpSessionContext;
import com.mongodb.internal.connection.Server;
import com.mongodb.internal.connection.ServerTuple;
import com.mongodb.internal.selector.ReadPreferenceServerSelector;
import com.mongodb.internal.selector.ServerAddressSelector;
import com.mongodb.internal.selector.WritableServerSelector;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.selector.ServerSelector;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/ClusterBinding.class */
public class ClusterBinding extends AbstractReferenceCounted implements ClusterAwareReadWriteBinding {
    private final Cluster cluster;
    private final ReadPreference readPreference;
    private final ReadConcern readConcern;

    public ClusterBinding(Cluster cluster, ReadPreference readPreference, ReadConcern readConcern) {
        this.cluster = (Cluster) Assertions.notNull("cluster", cluster);
        this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
        this.readConcern = (ReadConcern) Assertions.notNull("readConcern", readConcern);
    }

    @Override // com.mongodb.internal.binding.ClusterAwareReadWriteBinding
    public Cluster getCluster() {
        return this.cluster;
    }

    @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public ReadWriteBinding retain() {
        retain();
        return this;
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Override // com.mongodb.internal.binding.ReadBinding, com.mongodb.internal.binding.WriteBinding
    public SessionContext getSessionContext() {
        return new ReadConcernAwareNoOpSessionContext(this.readConcern);
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ConnectionSource getReadConnectionSource() {
        return new ClusterBindingConnectionSource(new ReadPreferenceServerSelector(this.readPreference));
    }

    @Override // com.mongodb.internal.binding.WriteBinding
    public ConnectionSource getWriteConnectionSource() {
        return new ClusterBindingConnectionSource(new WritableServerSelector());
    }

    @Override // com.mongodb.internal.binding.ClusterAwareReadWriteBinding
    public ConnectionSource getConnectionSource(ServerAddress serverAddress) {
        return new ClusterBindingConnectionSource(new ServerAddressSelector(serverAddress));
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/binding/ClusterBinding$ClusterBindingConnectionSource.class */
    private final class ClusterBindingConnectionSource extends AbstractReferenceCounted implements ConnectionSource {
        private final Server server;
        private final ServerDescription serverDescription;

        private ClusterBindingConnectionSource(ServerSelector serverSelector) {
            ServerTuple serverTuple = ClusterBinding.this.cluster.selectServer(serverSelector);
            this.server = serverTuple.getServer();
            this.serverDescription = serverTuple.getServerDescription();
            ClusterBinding.this.retain();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public ServerDescription getServerDescription() {
            return this.serverDescription;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public SessionContext getSessionContext() {
            return new ReadConcernAwareNoOpSessionContext(ClusterBinding.this.readConcern);
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public Connection getConnection() {
            return this.server.getConnection();
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public ConnectionSource retain() {
            retain();
            ClusterBinding.this.retain();
            return this;
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
        public void release() {
            release();
            ClusterBinding.this.release();
        }
    }
}
