package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;

@Deprecated
/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionAddedEvent.class */
public final class ConnectionAddedEvent {
    private final ConnectionId connectionId;

    public ConnectionAddedEvent(ConnectionId connectionId) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public String toString() {
        return "ConnectionAddedEvent{connectionId=" + this.connectionId + '}';
    }
}
