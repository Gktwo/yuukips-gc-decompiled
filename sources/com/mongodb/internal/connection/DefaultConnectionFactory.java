package com.mongodb.internal.connection;

import com.mongodb.connection.ClusterConnectionMode;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultConnectionFactory.class */
class DefaultConnectionFactory implements ConnectionFactory {
    @Override // com.mongodb.internal.connection.ConnectionFactory
    public Connection create(InternalConnection internalConnection, ProtocolExecutor executor, ClusterConnectionMode clusterConnectionMode) {
        return new DefaultServerConnection(internalConnection, executor, clusterConnectionMode);
    }

    @Override // com.mongodb.internal.connection.ConnectionFactory
    public AsyncConnection createAsync(InternalConnection internalConnection, ProtocolExecutor executor, ClusterConnectionMode clusterConnectionMode) {
        return new DefaultServerConnection(internalConnection, executor, clusterConnectionMode);
    }
}
