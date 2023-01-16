package com.mongodb.internal.connection;

import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.connection.ClusterType;
import java.util.Collection;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DnsSrvRecordInitializer.class */
public interface DnsSrvRecordInitializer {
    void initialize(Collection<ServerAddress> collection);

    void initialize(MongoException mongoException);

    ClusterType getClusterType();
}
