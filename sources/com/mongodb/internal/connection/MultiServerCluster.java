package com.mongodb.internal.connection;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ClusterSettings;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/MultiServerCluster.class */
public final class MultiServerCluster extends AbstractMultiServerCluster {
    public MultiServerCluster(ClusterId clusterId, ClusterSettings settings, ClusterableServerFactory serverFactory) {
        super(clusterId, settings, serverFactory);
        Assertions.isTrue("srvHost is null", settings.getSrvHost() == null);
        initialize(settings.getHosts());
    }
}
