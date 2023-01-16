package com.mongodb.internal.connection;

import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.lang.Nullable;
import com.mongodb.selector.ServerSelector;
import java.io.Closeable;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/Cluster.class */
public interface Cluster extends Closeable {
    ClusterSettings getSettings();

    ClusterDescription getDescription();

    ClusterDescription getCurrentDescription();

    @Nullable
    BsonTimestamp getClusterTime();

    ServerTuple selectServer(ServerSelector serverSelector);

    void selectServerAsync(ServerSelector serverSelector, SingleResultCallback<ServerTuple> singleResultCallback);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    boolean isClosed();
}
