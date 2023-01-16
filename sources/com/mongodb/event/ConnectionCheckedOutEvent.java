package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionCheckedOutEvent.class */
public final class ConnectionCheckedOutEvent {
    private final ConnectionId connectionId;

    public ConnectionCheckedOutEvent(ConnectionId connectionId) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public String toString() {
        return "ConnectionCheckedOutEvent{connectionId=" + this.connectionId + '}';
    }
}
