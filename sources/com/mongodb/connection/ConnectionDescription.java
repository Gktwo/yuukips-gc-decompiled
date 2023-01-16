package com.mongodb.connection;

import com.mongodb.ServerAddress;
import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bson.BsonArray;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/ConnectionDescription.class */
public class ConnectionDescription {
    private final ConnectionId connectionId;
    private final int maxWireVersion;
    private final ServerType serverType;
    private final int maxBatchCount;
    private final int maxDocumentSize;
    private final int maxMessageSize;
    private final List<String> compressors;
    private final BsonArray saslSupportedMechanisms;
    private static final int DEFAULT_MAX_MESSAGE_SIZE = 33554432;
    private static final int DEFAULT_MAX_WRITE_BATCH_SIZE = 512;

    public ConnectionDescription(ServerId serverId) {
        this(new ConnectionId(serverId), 0, ServerType.UNKNOWN, 512, ServerDescription.getDefaultMaxDocumentSize(), 33554432, Collections.emptyList());
    }

    public ConnectionDescription(ConnectionId connectionId, int maxWireVersion, ServerType serverType, int maxBatchCount, int maxDocumentSize, int maxMessageSize, List<String> compressors) {
        this(connectionId, maxWireVersion, serverType, maxBatchCount, maxDocumentSize, maxMessageSize, compressors, null);
    }

    public ConnectionDescription(ConnectionId connectionId, int maxWireVersion, ServerType serverType, int maxBatchCount, int maxDocumentSize, int maxMessageSize, List<String> compressors, BsonArray saslSupportedMechanisms) {
        this.connectionId = connectionId;
        this.serverType = serverType;
        this.maxBatchCount = maxBatchCount;
        this.maxDocumentSize = maxDocumentSize;
        this.maxMessageSize = maxMessageSize;
        this.maxWireVersion = maxWireVersion;
        this.compressors = (List) Assertions.notNull("compressors", Collections.unmodifiableList(new ArrayList(compressors)));
        this.saslSupportedMechanisms = saslSupportedMechanisms;
    }

    public ConnectionDescription withConnectionId(ConnectionId connectionId) {
        Assertions.notNull("connectionId", connectionId);
        return new ConnectionDescription(connectionId, this.maxWireVersion, this.serverType, this.maxBatchCount, this.maxDocumentSize, this.maxMessageSize, this.compressors, this.saslSupportedMechanisms);
    }

    public ServerAddress getServerAddress() {
        return this.connectionId.getServerId().getAddress();
    }

    public ConnectionId getConnectionId() {
        return this.connectionId;
    }

    public int getMaxWireVersion() {
        return this.maxWireVersion;
    }

    public ServerType getServerType() {
        return this.serverType;
    }

    public int getMaxBatchCount() {
        return this.maxBatchCount;
    }

    public int getMaxDocumentSize() {
        return this.maxDocumentSize;
    }

    public int getMaxMessageSize() {
        return this.maxMessageSize;
    }

    public List<String> getCompressors() {
        return this.compressors;
    }

    public BsonArray getSaslSupportedMechanisms() {
        return this.saslSupportedMechanisms;
    }

    public static int getDefaultMaxMessageSize() {
        return 33554432;
    }

    public static int getDefaultMaxWriteBatchSize() {
        return 512;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionDescription that = (ConnectionDescription) o;
        if (this.maxBatchCount == that.maxBatchCount && this.maxDocumentSize == that.maxDocumentSize && this.maxMessageSize == that.maxMessageSize && this.connectionId.equals(that.connectionId) && this.serverType == that.serverType && this.maxWireVersion == that.maxWireVersion && this.compressors.equals(that.compressors)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * this.connectionId.hashCode()) + this.maxBatchCount)) + this.serverType.hashCode())) + this.maxBatchCount)) + this.maxDocumentSize)) + this.maxMessageSize)) + this.compressors.hashCode();
    }

    public String toString() {
        return "ConnectionDescription{connectionId=" + this.connectionId + ", maxWireVersion=" + this.maxWireVersion + ", serverType=" + this.serverType + ", maxBatchCount=" + this.maxBatchCount + ", maxDocumentSize=" + this.maxDocumentSize + ", maxMessageSize=" + this.maxMessageSize + ", compressors=" + this.compressors + '}';
    }
}
