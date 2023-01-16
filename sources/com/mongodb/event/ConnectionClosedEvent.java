package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionClosedEvent.class */
public final class ConnectionClosedEvent {
    private final ConnectionId connectionId;
    private final Reason reason;

    /* loaded from: grasscutter.jar:com/mongodb/event/ConnectionClosedEvent$Reason.class */
    public enum Reason {
        STALE,
        IDLE,
        ERROR,
        POOL_CLOSED
    }

    public ConnectionClosedEvent(ConnectionId connectionId, Reason reason) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
        this.reason = (Reason) Assertions.notNull("reason", reason);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public Reason getReason() {
        return this.reason;
    }

    public String toString() {
        return "ConnectionClosedEvent{ connectionId=" + this.connectionId + " reason=" + this.reason + '}';
    }
}
