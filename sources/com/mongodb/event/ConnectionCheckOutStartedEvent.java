package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionCheckOutStartedEvent.class */
public final class ConnectionCheckOutStartedEvent {
    private final ServerId serverId;

    public ConnectionCheckOutStartedEvent(ServerId serverId) {
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
    }

    public ServerId getServerId() {
        return this.serverId;
    }

    public String toString() {
        return "ConnectionCheckOutStartedEvent{serverId=" + this.serverId + '}';
    }
}
