package com.mongodb.internal.binding;

import com.mongodb.ServerAddress;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.connection.Cluster;

/* loaded from: grasscutter.jar:com/mongodb/internal/binding/AsyncClusterAwareReadWriteBinding.class */
public interface AsyncClusterAwareReadWriteBinding extends AsyncReadWriteBinding {
    Cluster getCluster();

    void getConnectionSource(ServerAddress serverAddress, SingleResultCallback<AsyncConnectionSource> singleResultCallback);
}
