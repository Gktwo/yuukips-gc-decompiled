package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterId;

/* loaded from: grasscutter.jar:com/mongodb/event/ClusterClosedEvent.class */
public final class ClusterClosedEvent {
    private final ClusterId clusterId;

    public ClusterClosedEvent(ClusterId clusterId) {
        this.clusterId = (ClusterId) Assertions.notNull("clusterId", clusterId);
    }

    public ClusterId getClusterId() {
        return this.clusterId;
    }

    public String toString() {
        return "ClusterClosedEvent{clusterId=" + this.clusterId + '}';
    }
}
