package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionCreatedEvent.class */
public final class ConnectionCreatedEvent {
    private final ConnectionId connectionId;

    public ConnectionCreatedEvent(ConnectionId connectionId) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public String toString() {
        return "ConnectionCreatedEvent{ connectionId=" + this.connectionId + '}';
    }
}
