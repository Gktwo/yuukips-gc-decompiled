package com.mongodb.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ConnectionId;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/event/ServerHeartbeatSucceededEvent.class */
public final class ServerHeartbeatSucceededEvent {
    private final ConnectionId connectionId;
    private final BsonDocument reply;
    private final long elapsedTimeNanos;
    private final boolean awaited;

    @Deprecated
    public ServerHeartbeatSucceededEvent(ConnectionId connectionId, BsonDocument reply, long elapsedTimeNanos) {
        this(connectionId, reply, elapsedTimeNanos, false);
    }

    public ServerHeartbeatSucceededEvent(ConnectionId connectionId, BsonDocument reply, long elapsedTimeNanos, boolean awaited) {
        this.connectionId = (ConnectionId) Assertions.notNull("connectionId", connectionId);
        this.reply = (BsonDocument) Assertions.notNull("reply", reply);
        Assertions.isTrueArgument("elapsed time is not negative", elapsedTimeNanos >= 0);
        this.elapsedTimeNanos = elapsedTimeNanos;
        this.awaited = awaited;
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public BsonDocument getReply() {
        return this.reply;
    }

    public long getElapsedTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.elapsedTimeNanos, TimeUnit.NANOSECONDS);
    }

    public boolean isAwaited() {
        return this.awaited;
    }

    public String toString() {
        return "ServerHeartbeatSucceededEvent{connectionId=" + this.connectionId + ", reply=" + this.reply + ", elapsedTimeNanos=" + this.elapsedTimeNanos + ", awaited=" + this.awaited + "} ";
    }
}
