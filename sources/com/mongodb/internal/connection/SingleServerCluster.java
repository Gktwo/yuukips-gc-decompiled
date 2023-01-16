package com.mongodb.internal.connection;

import com.mongodb.MongoConfigurationException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ClusterType;
import com.mongodb.connection.ServerConnectionState;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerType;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.ServerDescriptionChangedEvent;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.selector.ServerSelector;
import java.util.Collections;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SingleServerCluster.class */
public final class SingleServerCluster extends BaseCluster {
    private static final Logger LOGGER = Loggers.getLogger("cluster");
    private final ClusterableServer server;

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ClusterDescription getCurrentDescription() {
        return getCurrentDescription();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ boolean isClosed() {
        return isClosed();
    }

    @Override // com.mongodb.internal.connection.BaseCluster
    public /* bridge */ /* synthetic */ ClusterableServerFactory getServerFactory() {
        return getServerFactory();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ClusterSettings getSettings() {
        return getSettings();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ClusterDescription getDescription() {
        return getDescription();
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ void selectServerAsync(ServerSelector serverSelector, SingleResultCallback singleResultCallback) {
        selectServerAsync(serverSelector, singleResultCallback);
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ ServerTuple selectServer(ServerSelector serverSelector) {
        return selectServer(serverSelector);
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster
    public /* bridge */ /* synthetic */ BsonTimestamp getClusterTime() {
        return getClusterTime();
    }

    public SingleServerCluster(ClusterId clusterId, ClusterSettings settings, ClusterableServerFactory serverFactory) {
        super(clusterId, settings, serverFactory);
        Assertions.isTrue("one server in a direct cluster", settings.getHosts().size() == 1);
        Assertions.isTrue("connection mode is single", settings.getMode() == ClusterConnectionMode.SINGLE);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(String.format("Cluster created with settings %s", settings.getShortDescription()));
        }
        synchronized (this) {
            this.server = createServer(settings.getHosts().get(0), new DefaultServerDescriptionChangedListener());
            publishDescription(ServerDescription.builder().state(ServerConnectionState.CONNECTING).address(settings.getHosts().get(0)).build());
        }
    }

    @Override // com.mongodb.internal.connection.BaseCluster
    protected void connect() {
        this.server.connect();
    }

    @Override // com.mongodb.internal.connection.BaseCluster
    protected ClusterableServer getServer(ServerAddress serverAddress) {
        Assertions.isTrue("open", !isClosed());
        return this.server;
    }

    @Override // com.mongodb.internal.connection.BaseCluster, com.mongodb.internal.connection.Cluster, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!isClosed()) {
            this.server.close();
            close();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/SingleServerCluster$DefaultServerDescriptionChangedListener.class */
    private class DefaultServerDescriptionChangedListener implements ServerDescriptionChangedListener {
        private DefaultServerDescriptionChangedListener() {
        }

        @Override // com.mongodb.internal.connection.ServerDescriptionChangedListener
        public void serverDescriptionChanged(ServerDescriptionChangedEvent event) {
            ServerDescription newDescription = event.getNewDescription();
            if (newDescription.isOk()) {
                if (SingleServerCluster.this.getSettings().getRequiredClusterType() != ClusterType.UNKNOWN && SingleServerCluster.this.getSettings().getRequiredClusterType() != newDescription.getClusterType()) {
                    newDescription = null;
                } else if (SingleServerCluster.this.getSettings().getRequiredClusterType() == ClusterType.REPLICA_SET && SingleServerCluster.this.getSettings().getRequiredReplicaSetName() != null && !SingleServerCluster.this.getSettings().getRequiredReplicaSetName().equals(newDescription.getSetName())) {
                    SingleServerCluster.this.publishDescription(ClusterType.UNKNOWN, ServerDescription.builder(newDescription).exception(new MongoConfigurationException(String.format("Replica set name '%s' does not match required replica set name of '%s'", newDescription.getSetName(), SingleServerCluster.this.getSettings().getRequiredReplicaSetName()))).type(ServerType.UNKNOWN).setName(null).m1269ok(false).build());
                    return;
                }
            }
            SingleServerCluster.this.publishDescription(newDescription);
        }
    }

    /* access modifiers changed from: private */
    public void publishDescription(ServerDescription serverDescription) {
        ClusterType clusterType = getSettings().getRequiredClusterType();
        if (clusterType == ClusterType.UNKNOWN && serverDescription != null) {
            clusterType = serverDescription.getClusterType();
        }
        publishDescription(clusterType, serverDescription);
    }

    /* access modifiers changed from: private */
    public void publishDescription(ClusterType clusterType, ServerDescription serverDescription) {
        ClusterDescription currentDescription = getCurrentDescription();
        ClusterDescription description = new ClusterDescription(ClusterConnectionMode.SINGLE, clusterType, serverDescription == null ? Collections.emptyList() : Collections.singletonList(serverDescription), getSettings(), getServerFactory().getSettings());
        updateDescription(description);
        fireChangeEvent(description, currentDescription);
    }
}
