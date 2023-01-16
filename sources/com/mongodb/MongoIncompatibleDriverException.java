package com.mongodb;

import com.mongodb.connection.ClusterDescription;

/* loaded from: grasscutter.jar:com/mongodb/MongoIncompatibleDriverException.class */
public class MongoIncompatibleDriverException extends MongoException {
    private static final long serialVersionUID = -5213381354402601890L;
    private ClusterDescription clusterDescription;

    public MongoIncompatibleDriverException(String message, ClusterDescription clusterDescription) {
        super(message);
        this.clusterDescription = clusterDescription;
    }

    public ClusterDescription getClusterDescription() {
        return this.clusterDescription;
    }
}
