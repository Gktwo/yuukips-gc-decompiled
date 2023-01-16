package com.mongodb.event;

import com.mongodb.connection.ConnectionId;
import org.bson.assertions.Assertions;

@Deprecated
/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionRemovedEvent.class */
public final class ConnectionRemovedEvent {
    private final ConnectionId connectionId;
    private final Reason reason;

    /* loaded from: grasscutter.jar:com/mongodb/event/ConnectionRemovedEvent$Reason.class */
    public enum Reason {
        UNKNOWN,
        STALE,
        MAX_IDLE_TIME_EXCEEDED,
        MAX_LIFE_TIME_EXCEEDED,
        ERROR,
        POOL_CLOSED
    }

    public ConnectionRemovedEvent(ConnectionId connectionId, Reason reason) {
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
        return "ConnectionRemovedEvent{connectionId=" + this.connectionId + ", reason=" + this.reason + '}';
    }
}
