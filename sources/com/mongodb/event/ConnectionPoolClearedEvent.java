package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionPoolClearedEvent.class */
public final class ConnectionPoolClearedEvent {
    private final ServerId serverId;

    public ConnectionPoolClearedEvent(ServerId serverId) {
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
    }

    public ServerId getServerId() {
        return this.serverId;
    }

    public String toString() {
        return "ConnectionPoolClearedEvent{serverId=" + this.serverId + '}';
    }
}
