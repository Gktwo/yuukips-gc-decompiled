package com.mongodb.internal.binding;

import com.mongodb.ServerAddress;
import com.mongodb.internal.connection.Cluster;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/ClusterAwareReadWriteBinding.class */
public interface ClusterAwareReadWriteBinding extends ReadWriteBinding {
    Cluster getCluster();

    ConnectionSource getConnectionSource(ServerAddress serverAddress);
}
