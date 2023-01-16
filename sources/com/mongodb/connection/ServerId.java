package com.mongodb.connection;

import com.mongodb.ServerAddress;
import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/ServerId.class */
public final class ServerId {
    private final ClusterId clusterId;
    private final ServerAddress address;

    public ServerId(ClusterId clusterId, ServerAddress address) {
        this.clusterId = (ClusterId) Assertions.notNull("clusterId", clusterId);
        this.address = (ServerAddress) Assertions.notNull("address", address);
    }

    public ClusterId getClusterId() {
        return this.clusterId;
    }

    public ServerAddress getAddress() {
        return this.address;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerId serverId = (ServerId) o;
        if (this.address.equals(serverId.address) && this.clusterId.equals(serverId.clusterId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.clusterId.hashCode()) + this.address.hashCode();
    }

    public String toString() {
        return "ServerId{clusterId=" + this.clusterId + ", address=" + this.address + '}';
    }
}
