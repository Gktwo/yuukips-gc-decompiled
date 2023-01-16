package com.mongodb.connection;

import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/ConnectionId.class */
public final class ConnectionId {
    private static final AtomicInteger INCREMENTING_ID = new AtomicInteger();
    private final ServerId serverId;
    private final int localValue;
    private final Integer serverValue;
    private final String stringValue;

    public ConnectionId(ServerId serverId) {
        this(serverId, INCREMENTING_ID.incrementAndGet(), null);
    }

    public ConnectionId(ServerId serverId, int localValue, @Nullable Integer serverValue) {
        this.serverId = (ServerId) Assertions.notNull("serverId", serverId);
        this.localValue = localValue;
        this.serverValue = serverValue;
        if (serverValue == null) {
            this.stringValue = String.format("connectionId{localValue:%s}", Integer.valueOf(localValue));
        } else {
            this.stringValue = String.format("connectionId{localValue:%s, serverValue:%s}", Integer.valueOf(localValue), serverValue);
        }
    }

    public ConnectionId withServerValue(int serverValue) {
        Assertions.isTrue("server value is null", this.serverValue == null);
        return new ConnectionId(this.serverId, this.localValue, Integer.valueOf(serverValue));
    }

    public ServerId getServerId() {
        return this.serverId;
    }

    public int getLocalValue() {
        return this.localValue;
    }

    @Nullable
    public Integer getServerValue() {
        return this.serverValue;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionId that = (ConnectionId) o;
        if (this.localValue != that.localValue || !this.serverId.equals(that.serverId)) {
            return false;
        }
        if (this.serverValue != null) {
            if (!this.serverValue.equals(that.serverValue)) {
                return false;
            }
            return true;
        } else if (that.serverValue != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * this.serverId.hashCode()) + this.localValue)) + (this.serverValue != null ? this.serverValue.hashCode() : 0);
    }

    public String toString() {
        return this.stringValue;
    }
}
