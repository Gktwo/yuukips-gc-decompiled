package com.mongodb.internal.connection;

import com.mongodb.MongoCompressor;
import com.mongodb.MongoCredential;
import com.mongodb.MongoDriverInformation;
import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterId;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerSettings;
import com.mongodb.connection.StreamFactory;
import com.mongodb.event.ClusterListener;
import com.mongodb.event.CommandListener;
import com.mongodb.event.ConnectionPoolListener;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DefaultClusterFactory.class */
public final class DefaultClusterFactory implements ClusterFactory {
    @Override // com.mongodb.internal.connection.ClusterFactory
    public Cluster create(ClusterSettings settings, ServerSettings serverSettings, ConnectionPoolSettings connectionPoolSettings, StreamFactory streamFactory, StreamFactory heartbeatStreamFactory, MongoCredential credential, ClusterListener clusterListener, ConnectionPoolListener connectionPoolListener) {
        return createCluster(getClusterSettings(settings, clusterListener), serverSettings, getConnectionPoolSettings(connectionPoolSettings, connectionPoolListener), streamFactory, heartbeatStreamFactory, credential, null, null, null, Collections.emptyList());
    }

    public Cluster createCluster(ClusterSettings clusterSettings, ServerSettings serverSettings, ConnectionPoolSettings connectionPoolSettings, StreamFactory streamFactory, StreamFactory heartbeatStreamFactory, MongoCredential credential, CommandListener commandListener, String applicationName, MongoDriverInformation mongoDriverInformation, List<MongoCompressor> compressorList) {
        ClusterId clusterId = new ClusterId();
        ClusterableServerFactory serverFactory = new DefaultClusterableServerFactory(clusterId, clusterSettings, serverSettings, connectionPoolSettings, streamFactory, heartbeatStreamFactory, credential, commandListener, applicationName, mongoDriverInformation != null ? mongoDriverInformation : MongoDriverInformation.builder().build(), compressorList);
        DnsSrvRecordMonitorFactory dnsSrvRecordMonitorFactory = new DefaultDnsSrvRecordMonitorFactory(clusterId, serverSettings);
        if (clusterSettings.getMode() == ClusterConnectionMode.SINGLE) {
            return new SingleServerCluster(clusterId, clusterSettings, serverFactory);
        }
        if (clusterSettings.getMode() != ClusterConnectionMode.MULTIPLE) {
            throw new UnsupportedOperationException("Unsupported cluster mode: " + clusterSettings.getMode());
        } else if (clusterSettings.getSrvHost() == null) {
            return new MultiServerCluster(clusterId, clusterSettings, serverFactory);
        } else {
            return new DnsMultiServerCluster(clusterId, clusterSettings, serverFactory, dnsSrvRecordMonitorFactory);
        }
    }

    private ClusterSettings getClusterSettings(ClusterSettings settings, ClusterListener clusterListener) {
        return ClusterSettings.builder(settings).addClusterListener(clusterListener).build();
    }

    private ConnectionPoolSettings getConnectionPoolSettings(ConnectionPoolSettings connPoolSettings, ConnectionPoolListener connPoolListener) {
        return ConnectionPoolSettings.builder(connPoolSettings).addConnectionPoolListener(connPoolListener).build();
    }
}
