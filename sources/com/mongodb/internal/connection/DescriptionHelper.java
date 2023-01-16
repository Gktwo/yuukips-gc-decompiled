package com.mongodb.internal.connection;

import com.mongodb.ServerAddress;
import com.mongodb.Tag;
import com.mongodb.TagSet;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.connection.ConnectionId;
import com.mongodb.connection.ServerConnectionState;
import com.mongodb.connection.ServerDescription;
import com.mongodb.connection.ServerType;
import com.mongodb.connection.TopologyVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DescriptionHelper.class */
public final class DescriptionHelper {
    /* access modifiers changed from: package-private */
    public static ConnectionDescription createConnectionDescription(ConnectionId connectionId, BsonDocument isMasterResult) {
        ConnectionDescription connectionDescription = new ConnectionDescription(connectionId, getMaxWireVersion(isMasterResult), getServerType(isMasterResult), getMaxWriteBatchSize(isMasterResult), getMaxBsonObjectSize(isMasterResult), getMaxMessageSizeBytes(isMasterResult), getCompressors(isMasterResult), isMasterResult.getArray("saslSupportedMechs", null));
        if (isMasterResult.containsKey("connectionId")) {
            connectionDescription = connectionDescription.withConnectionId(connectionDescription.getConnectionId().withServerValue(isMasterResult.getNumber("connectionId").intValue()));
        }
        return connectionDescription;
    }

    public static ServerDescription createServerDescription(ServerAddress serverAddress, BsonDocument isMasterResult, long roundTripTime) {
        return ServerDescription.builder().state(ServerConnectionState.CONNECTED).address(serverAddress).type(getServerType(isMasterResult)).canonicalAddress(isMasterResult.containsKey("me") ? isMasterResult.getString("me").getValue() : null).hosts(listToSet(isMasterResult.getArray("hosts", new BsonArray()))).passives(listToSet(isMasterResult.getArray("passives", new BsonArray()))).arbiters(listToSet(isMasterResult.getArray("arbiters", new BsonArray()))).primary(getString(isMasterResult, "primary")).maxDocumentSize(getMaxBsonObjectSize(isMasterResult)).tagSet(getTagSetFromDocument(isMasterResult.getDocument("tags", new BsonDocument()))).setName(getString(isMasterResult, "setName")).minWireVersion(getMinWireVersion(isMasterResult)).maxWireVersion(getMaxWireVersion(isMasterResult)).electionId(getElectionId(isMasterResult)).setVersion(getSetVersion(isMasterResult)).topologyVersion(getTopologyVersion(isMasterResult)).lastWriteDate(getLastWriteDate(isMasterResult)).roundTripTime(roundTripTime, TimeUnit.NANOSECONDS).logicalSessionTimeoutMinutes(getLogicalSessionTimeoutMinutes(isMasterResult)).m1269ok(CommandHelper.isCommandOk(isMasterResult)).build();
    }

    private static int getMinWireVersion(BsonDocument isMasterResult) {
        return isMasterResult.getInt32("minWireVersion", new BsonInt32(ServerDescription.getDefaultMinWireVersion())).getValue();
    }

    private static int getMaxWireVersion(BsonDocument isMasterResult) {
        return isMasterResult.getInt32("maxWireVersion", new BsonInt32(ServerDescription.getDefaultMaxWireVersion())).getValue();
    }

    private static Date getLastWriteDate(BsonDocument isMasterResult) {
        if (!isMasterResult.containsKey("lastWrite")) {
            return null;
        }
        return new Date(isMasterResult.getDocument("lastWrite").getDateTime("lastWriteDate").getValue());
    }

    private static ObjectId getElectionId(BsonDocument isMasterResult) {
        if (isMasterResult.containsKey("electionId")) {
            return isMasterResult.getObjectId("electionId").getValue();
        }
        return null;
    }

    private static Integer getSetVersion(BsonDocument isMasterResult) {
        if (isMasterResult.containsKey("setVersion")) {
            return Integer.valueOf(isMasterResult.getNumber("setVersion").intValue());
        }
        return null;
    }

    private static TopologyVersion getTopologyVersion(BsonDocument isMasterResult) {
        if (!isMasterResult.containsKey("topologyVersion") || !isMasterResult.get("topologyVersion").isDocument()) {
            return null;
        }
        return new TopologyVersion(isMasterResult.getDocument("topologyVersion"));
    }

    private static int getMaxMessageSizeBytes(BsonDocument isMasterResult) {
        return isMasterResult.getInt32("maxMessageSizeBytes", new BsonInt32(ConnectionDescription.getDefaultMaxMessageSize())).getValue();
    }

    private static int getMaxBsonObjectSize(BsonDocument isMasterResult) {
        return isMasterResult.getInt32("maxBsonObjectSize", new BsonInt32(ServerDescription.getDefaultMaxDocumentSize())).getValue();
    }

    private static int getMaxWriteBatchSize(BsonDocument isMasterResult) {
        return isMasterResult.getInt32("maxWriteBatchSize", new BsonInt32(ConnectionDescription.getDefaultMaxWriteBatchSize())).getValue();
    }

    private static Integer getLogicalSessionTimeoutMinutes(BsonDocument isMasterResult) {
        if (isMasterResult.isNumber("logicalSessionTimeoutMinutes")) {
            return Integer.valueOf(isMasterResult.getNumber("logicalSessionTimeoutMinutes").intValue());
        }
        return null;
    }

    private static String getString(BsonDocument response, String key) {
        if (response.containsKey(key)) {
            return response.getString(key).getValue();
        }
        return null;
    }

    private static Set<String> listToSet(BsonArray array) {
        if (array == null || array.isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> set = new HashSet<>();
        Iterator<BsonValue> it = array.iterator();
        while (it.hasNext()) {
            set.add(it.next().asString().getValue());
        }
        return set;
    }

    private static ServerType getServerType(BsonDocument isMasterResult) {
        if (!CommandHelper.isCommandOk(isMasterResult)) {
            return ServerType.UNKNOWN;
        }
        if (isReplicaSetMember(isMasterResult)) {
            if (isMasterResult.getBoolean("hidden", BsonBoolean.FALSE).getValue()) {
                return ServerType.REPLICA_SET_OTHER;
            }
            if (isMasterResult.getBoolean("ismaster", BsonBoolean.FALSE).getValue()) {
                return ServerType.REPLICA_SET_PRIMARY;
            }
            if (isMasterResult.getBoolean("secondary", BsonBoolean.FALSE).getValue()) {
                return ServerType.REPLICA_SET_SECONDARY;
            }
            if (isMasterResult.getBoolean("arbiterOnly", BsonBoolean.FALSE).getValue()) {
                return ServerType.REPLICA_SET_ARBITER;
            }
            if (!isMasterResult.containsKey("setName") || !isMasterResult.containsKey("hosts")) {
                return ServerType.REPLICA_SET_GHOST;
            }
            return ServerType.REPLICA_SET_OTHER;
        } else if (!isMasterResult.containsKey("msg") || !isMasterResult.get("msg").equals(new BsonString("isdbgrid"))) {
            return ServerType.STANDALONE;
        } else {
            return ServerType.SHARD_ROUTER;
        }
    }

    private static boolean isReplicaSetMember(BsonDocument isMasterResult) {
        return isMasterResult.containsKey("setName") || isMasterResult.getBoolean("isreplicaset", BsonBoolean.FALSE).getValue();
    }

    private static TagSet getTagSetFromDocument(BsonDocument tagsDocuments) {
        List<Tag> tagList = new ArrayList<>();
        for (Map.Entry<String, BsonValue> curEntry : tagsDocuments.entrySet()) {
            tagList.add(new Tag(curEntry.getKey(), curEntry.getValue().asString().getValue()));
        }
        return new TagSet(tagList);
    }

    private static List<String> getCompressors(BsonDocument isMasterResult) {
        List<String> compressorList = new ArrayList<>();
        Iterator<BsonValue> it = isMasterResult.getArray("compression", new BsonArray()).iterator();
        while (it.hasNext()) {
            compressorList.add(it.next().asString().getValue());
        }
        return compressorList;
    }

    private DescriptionHelper() {
    }
}
