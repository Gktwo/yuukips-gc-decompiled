package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/event/ServerHeartbeatFailedEvent.class */
public final class ServerHeartbeatFailedEvent {
    private final ConnectionId connectionId;
    private final long elapsedTimeNanos;
    private final boolean awaited;
    private final Throwable throwable;

    @Deprecated
    public ServerHeartbeatFailedEvent(ConnectionId connectionId, long elapsedTimeNanos, Throwable throwable) {
        this(connectionId, elapsedTimeNanos, false, throwable);
    }

    public ServerHeartbeatFailedEvent(ConnectionId connectionId, long elapsedTimeNanos, boolean awaited, Throwable throwable) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
        this.awaited = awaited;
        Assertions.isTrueArgument("elapsed time is not negative", elapsedTimeNanos >= 0);
        this.elapsedTimeNanos = elapsedTimeNanos;
        this.throwable = (Throwable) Assertions.notNull("throwable", throwable);
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public long getElapsedTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.elapsedTimeNanos, TimeUnit.NANOSECONDS);
    }

    public boolean isAwaited() {
        return this.awaited;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public String toString() {
        return "ServerHeartbeatFailedEvent{connectionId=" + this.connectionId + ", elapsedTimeNanos=" + this.elapsedTimeNanos + ", awaited=" + this.awaited + ", throwable=" + this.throwable + "} " + toString();
    }
}
