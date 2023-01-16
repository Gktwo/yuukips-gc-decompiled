package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ClusterId;

/* loaded from: grasscutter.jar:com/mongodb/event/ClusterOpeningEvent.class */
public final class ClusterOpeningEvent {
    private final ClusterId clusterId;

    public ClusterOpeningEvent(ClusterId clusterId) {
        this.clusterId = (ClusterId) Assertions.notNull("clusterId", clusterId);
    }

    public ClusterId getClusterId() {
        return this.clusterId;
    }

    public String toString() {
        return "ClusterOpeningEvent{clusterId=" + this.clusterId + '}';
    }
}
