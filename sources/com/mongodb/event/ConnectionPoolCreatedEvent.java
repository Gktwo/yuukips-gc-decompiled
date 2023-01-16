package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerId;

/* loaded from: grasscutter.jar:com/mongodb/event/ConnectionPoolCreatedEvent.class */
public final class ConnectionPoolCreatedEvent {
    private final ServerId serverId;
    private final ConnectionPoolSettings settings;

    public ConnectionPoolCreatedEvent(ServerId serverId, ConnectionPoolSettings settings) {
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
        this.settings = (ConnectionPoolSettings) Assertions.notNull("settings", settings);
    }

    public ServerId getServerId() {
        return this.serverId;
    }

    public ConnectionPoolSettings getSettings() {
        return this.settings;
    }

    public String toString() {
        return "ConnectionPoolCreatedEvent{serverId=" + this.serverId + " settings=" + this.settings + '}';
    }
}
