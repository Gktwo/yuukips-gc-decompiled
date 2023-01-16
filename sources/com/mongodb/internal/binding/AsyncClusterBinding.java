package com.mongodb.internal.binding;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.connection.AsyncConnection;
import com.mongodb.internal.connection.Cluster;
import com.mongodb.internal.connection.ReadConcernAwareNoOpSessionContext;
import com.mongodb.internal.connection.Server;
import com.mongodb.internal.connection.ServerTuple;
import com.mongodb.internal.selector.ReadPreferenceServerSelector;
import com.mongodb.internal.selector.ServerAddressSelector;
import com.mongodb.internal.selector.WritableServerSelector;
import com.mongodb.internal.session.SessionContext;
import com.mongodb.selector.ServerSelector;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncClusterBinding.class */
public class AsyncClusterBinding extends AbstractReferenceCounted implements AsyncClusterAwareReadWriteBinding {
    private final Cluster cluster;
    private final ReadPreference readPreference;
    private final ReadConcern readConcern;

    public AsyncClusterBinding(Cluster cluster, ReadPreference readPreference, ReadConcern readConcern) {
        this.cluster = (Cluster) Assertions.notNull("cluster", cluster);
        this.readPreference = (ReadPreference) Assertions.notNull("readPreference", readPreference);
        this.readConcern = (ReadConcern) Assertions.notNull("readConcern", readConcern);
    }

    @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
    public AsyncReadWriteBinding retain() {
        retain();
        return this;
    }

    @Override // com.mongodb.internal.binding.AsyncClusterAwareReadWriteBinding
    public Cluster getCluster() {
        return this.cluster;
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding, com.mongodb.internal.binding.AsyncWriteBinding
    public SessionContext getSessionContext() {
        return new ReadConcernAwareNoOpSessionContext(this.readConcern);
    }

    @Override // com.mongodb.internal.binding.AsyncReadBinding
    public void getReadConnectionSource(SingleResultCallback<AsyncConnectionSource> callback) {
        getAsyncClusterBindingConnectionSource(new ReadPreferenceServerSelector(this.readPreference), callback);
    }

    @Override // com.mongodb.internal.binding.AsyncWriteBinding
    public void getWriteConnectionSource(SingleResultCallback<AsyncConnectionSource> callback) {
        getAsyncClusterBindingConnectionSource(new WritableServerSelector(), callback);
    }

    @Override // com.mongodb.internal.binding.AsyncClusterAwareReadWriteBinding
    public void getConnectionSource(ServerAddress serverAddress, SingleResultCallback<AsyncConnectionSource> callback) {
        getAsyncClusterBindingConnectionSource(new ServerAddressSelector(serverAddress), callback);
    }

    private void getAsyncClusterBindingConnectionSource(ServerSelector serverSelector, final SingleResultCallback<AsyncConnectionSource> callback) {
        this.cluster.selectServerAsync(serverSelector, new SingleResultCallback<ServerTuple>() { // from class: com.mongodb.internal.binding.AsyncClusterBinding.1
            public void onResult(ServerTuple result, Throwable t) {
                if (t != null) {
                    callback.onResult(null, t);
                } else {
                    callback.onResult(new AsyncClusterBindingConnectionSource(result.getServer(), result.getServerDescription()), null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncClusterBinding$AsyncClusterBindingConnectionSource.class */
    public final class AsyncClusterBindingConnectionSource extends AbstractReferenceCounted implements AsyncConnectionSource {
        private final Server server;
        private final ServerDescription serverDescription;

        private AsyncClusterBindingConnectionSource(Server server, ServerDescription serverDescription) {
            this.server = server;
            this.serverDescription = serverDescription;
            AsyncClusterBinding.this.retain();
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public ServerDescription getServerDescription() {
            return this.serverDescription;
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public SessionContext getSessionContext() {
            return new ReadConcernAwareNoOpSessionContext(AsyncClusterBinding.this.readConcern);
        }

        @Override // com.mongodb.internal.binding.AsyncConnectionSource
        public void getConnection(SingleResultCallback<AsyncConnection> callback) {
            this.server.getConnectionAsync(callback);
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted, com.mongodb.internal.binding.WriteBinding
        public AsyncConnectionSource retain() {
            retain();
            AsyncClusterBinding.this.retain();
            return this;
        }

        @Override // com.mongodb.internal.binding.AbstractReferenceCounted, com.mongodb.internal.binding.ReferenceCounted
        public void release() {
            release();
            AsyncClusterBinding.this.release();
        }
    }
}
