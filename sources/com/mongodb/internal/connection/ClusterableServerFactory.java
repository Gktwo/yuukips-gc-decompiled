package com.mongodb.internal.connection;

import com.mongodb.ServerAddress;
import com.mongodb.connection.ServerSettings;
import com.mongodb.event.ServerListener;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ClusterableServerFactory.class */
public interface ClusterableServerFactory {
    ClusterableServer create(ServerAddress serverAddress, ServerDescriptionChangedListener serverDescriptionChangedListener, ServerListener serverListener, ClusterClock clusterClock);

    ServerSettings getSettings();
}
