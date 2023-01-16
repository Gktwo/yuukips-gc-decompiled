package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionCheckedInEvent.class */
public final class ConnectionCheckedInEvent {
    private final ConnectionId connectionId;

    public ConnectionCheckedInEvent(ConnectionId connectionId) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public String toString() {
        return "ConnectionCheckedInEvent{connectionId=" + this.connectionId + '}';
    }
}
