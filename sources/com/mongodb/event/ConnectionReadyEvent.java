package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionReadyEvent.class */
public final class ConnectionReadyEvent {
    private final ConnectionId connectionId;

    public ConnectionReadyEvent(ConnectionId connectionId) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public String toString() {
        return "ConnectionReadyEvent{ connectionId=" + this.connectionId + '}';
    }
}
