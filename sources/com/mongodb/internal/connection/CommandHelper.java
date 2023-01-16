package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.MongoServerException;
import com.mongodb.ReadPreference;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.bson.codecs.BsonDocumentCodec;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/CommandHelper.class */
public final class CommandHelper {
    /* access modifiers changed from: package-private */
    public static BsonDocument executeCommand(String database, BsonDocument command, InternalConnection internalConnection) {
        return sendAndReceive(database, command, null, internalConnection);
    }

    public static BsonDocument executeCommand(String database, BsonDocument command, ClusterClock clusterClock, InternalConnection internalConnection) {
        return sendAndReceive(database, command, clusterClock, internalConnection);
    }

    /* access modifiers changed from: package-private */
    public static BsonDocument executeCommandWithoutCheckingForFailure(String database, BsonDocument command, InternalConnection internalConnection) {
        try {
            return sendAndReceive(database, command, null, internalConnection);
        } catch (MongoServerException e) {
            return new BsonDocument();
        }
    }

    /* access modifiers changed from: package-private */
    public static void executeCommandAsync(String database, BsonDocument command, InternalConnection internalConnection, final SingleResultCallback<BsonDocument> callback) {
        internalConnection.sendAndReceiveAsync(getCommandMessage(database, command, internalConnection), new BsonDocumentCodec(), NoOpSessionContext.INSTANCE, new SingleResultCallback<BsonDocument>() { // from class: com.mongodb.internal.connection.CommandHelper.1
            public void onResult(BsonDocument result, Throwable t) {
                if (t != null) {
                    SingleResultCallback.this.onResult(null, t);
                } else {
                    SingleResultCallback.this.onResult(result, null);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static boolean isCommandOk(BsonDocument response) {
        if (!response.containsKey("ok")) {
            return false;
        }
        BsonValue okValue = response.get("ok");
        if (okValue.isBoolean()) {
            return okValue.asBoolean().getValue();
        }
        return okValue.isNumber() && okValue.asNumber().intValue() == 1;
    }

    private static BsonDocument sendAndReceive(String database, BsonDocument command, ClusterClock clusterClock, InternalConnection internalConnection) {
        return (BsonDocument) internalConnection.sendAndReceive(getCommandMessage(database, command, internalConnection), new BsonDocumentCodec(), clusterClock == null ? NoOpSessionContext.INSTANCE : new ClusterClockAdvancingSessionContext(NoOpSessionContext.INSTANCE, clusterClock));
    }

    private static CommandMessage getCommandMessage(String database, BsonDocument command, InternalConnection internalConnection) {
        return new CommandMessage(new MongoNamespace(database, MongoNamespace.COMMAND_COLLECTION_NAME), command, new NoOpFieldNameValidator(), ReadPreference.primary(), MessageSettings.builder().maxWireVersion(internalConnection.getDescription().getMaxWireVersion()).build());
    }

    private CommandHelper() {
    }
}
