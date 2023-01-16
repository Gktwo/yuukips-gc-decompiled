package com.mongodb.internal.connection;

import com.mongodb.MongoCredential;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerSettings;
import com.mongodb.connection.StreamFactory;
import com.mongodb.event.ClusterListener;
import com.mongodb.event.ConnectionPoolListener;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ClusterFactory.class */
public interface ClusterFactory {
    Cluster create(ClusterSettings clusterSettings, ServerSettings serverSettings, ConnectionPoolSettings connectionPoolSettings, StreamFactory streamFactory, StreamFactory streamFactory2, MongoCredential mongoCredential, ClusterListener clusterListener, ConnectionPoolListener connectionPoolListener);
}
