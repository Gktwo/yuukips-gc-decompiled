package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;

/* loaded from: grasscutter.jar:com/mongodb/event/ServerHeartbeatStartedEvent.class */
public final class ServerHeartbeatStartedEvent {
    private final ConnectionId connectionId;

    public ServerHeartbeatStartedEvent(ConnectionId connectionId) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public String toString() {
        return "ServerHeartbeatStartedEvent{connectionId=" + this.connectionId + "} " + toString();
    }
}
