package com.mongodb.internal.binding;

import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.Cluster;
import com.mongodb.internal.connection.Connection;
import com.mongodb.internal.connection.NoOpSessionContext;
import com.mongodb.internal.selector.ServerAddressSelector;
import com.mongodb.internal.session.SessionContext;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/SingleServerBinding.class */
public class SingleServerBinding extends AbstractReferenceCounted implements ReadWriteBinding {
    private final Cluster cluster;
    private final ServerAddress serverAddress;
    private final ReadPreference readPreference;

    public SingleServerBinding(Cluster cluster, ServerAddress serverAddress) {
        this(cluster, serverAddress, ReadPreference.primary());
    }

    public SingleServerBinding(Cluster cluster, ServerAddress serverAddress, ReadPreference readPreference) {
        this.cluster = (Cluster) Assertions.notNull("cluster", cluster);
        this.serverAddress = (ServerAddress) Assertions.notNull("serverAddress", serverAddress);
        this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
    }

    @Override // com.mongodb.internal.binding.WriteBinding
    public ConnectionSource getWriteConnectionSource() {
        return new SingleServerBindingConnectionSource();
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Override // com.mongodb.internal.binding.ReadBinding
    public ConnectionSource getReadConnectionSource() {
        return new SingleServerBindingConnectionSource();
    }

    @Override // com.mongodb.internal.binding.ReadBinding, com.mongodb.internal.binding.WriteBinding
    public SessionContext getSessionContext() {
        return NoOpSessionContext.INSTANCE;
    }

    @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public SingleServerBinding retain() {
        retain();
        return this;
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/binding/SingleServerBinding$SingleServerBindingConnectionSource.class */
    private final class SingleServerBindingConnectionSource extends AbstractReferenceCounted implements ConnectionSource {
        private final ServerDescription serverDescription;

        private SingleServerBindingConnectionSource() {
            SingleServerBinding.this.retain();
            this.serverDescription = SingleServerBinding.this.cluster.selectServer(new ServerAddressSelector(SingleServerBinding.this.serverAddress)).getServerDescription();
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public ServerDescription getServerDescription() {
            return this.serverDescription;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public SessionContext getSessionContext() {
            return NoOpSessionContext.INSTANCE;
        }

        @Override // com.mongodb.internal.binding.ConnectionSource
        public Connection getConnection() {
            return SingleServerBinding.this.cluster.selectServer(new ServerAddressSelector(SingleServerBinding.this.serverAddress)).getServer().getConnection();
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public ConnectionSource retain() {
            retain();
            return this;
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
        public void release() {
            release();
            if (getCount() == 0) {
                SingleServerBinding.this.release();
            }
        }
    }
}
