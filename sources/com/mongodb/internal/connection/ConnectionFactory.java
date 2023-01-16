package com.mongodb.internal.connection;

import com.mongodb.connection.ClusterConnectionMode;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ConnectionFactory.class */
public interface ConnectionFactory {
    Connection create(InternalConnection internalConnection, ProtocolExecutor protocolExecutor, ClusterConnectionMode clusterConnectionMode);

    AsyncConnection createAsync(InternalConnection internalConnection, ProtocolExecutor protocolExecutor, ClusterConnectionMode clusterConnectionMode);
}
