package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionCheckOutFailedEvent.class */
public final class ConnectionCheckOutFailedEvent {
    private final ServerId serverId;
    private final Reason reason;

    /* loaded from: grasscutter.jar:com/mongodb/event/ConnectionCheckOutFailedEvent$Reason.class */
    public enum Reason {
        POOL_CLOSED,
        TIMEOUT,
        CONNECTION_ERROR,
        UNKNOWN
    }

    public ConnectionCheckOutFailedEvent(ServerId serverId, Reason reason) {
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
        this.reason = (Reason) Assertions.notNull("reason", reason);
    }

    public ServerId getServerId() {
        return this.serverId;
    }

    public String toString() {
        return "ConnectionCheckOutFailedEvent{serverId=" + this.serverId + " reason=" + this.reason + '}';
    }
}
