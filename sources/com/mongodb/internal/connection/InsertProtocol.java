package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcernResult;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.bulk.InsertRequest;
import org.bson.BsonArray;
import org.bson.BsonDocument;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InsertProtocol.class */
public class InsertProtocol extends WriteProtocol {
    private static final Logger LOGGER = Loggers.getLogger("protocol.insert");
    private final InsertRequest insertRequest;

    /* access modifiers changed from: package-private */
    public InsertProtocol(MongoNamespace namespace, boolean ordered, InsertRequest insertRequest) {
        super(namespace, ordered);
        this.insertRequest = insertRequest;
    }

    @Override // com.mongodb.internal.connection.WriteProtocol, com.mongodb.internal.connection.LegacyProtocol
    public WriteConcernResult execute(InternalConnection connection) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Inserting 1 document into namespace %s on connection [%s] to server %s", getNamespace(), connection.getDescription().getConnectionId(), connection.getDescription().getServerAddress()));
        }
        WriteConcernResult writeConcernResult = execute(connection);
        LOGGER.debug("Insert completed");
        return writeConcernResult;
    }

    @Override // com.mongodb.internal.connection.WriteProtocol, com.mongodb.internal.connection.LegacyProtocol
    public void executeAsync(InternalConnection connection, final SingleResultCallback<WriteConcernResult> callback) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format("Asynchronously inserting 1 document into namespace %s on connection [%s] to server %s", getNamespace(), connection.getDescription().getConnectionId(), connection.getDescription().getServerAddress()));
            }
            executeAsync(connection, new SingleResultCallback<WriteConcernResult>() { // from class: com.mongodb.internal.connection.InsertProtocol.1
                public void onResult(WriteConcernResult result, Throwable t) {
                    if (t != null) {
                        callback.onResult(null, t);
                        return;
                    }
                    InsertProtocol.LOGGER.debug("Asynchronous insert completed");
                    callback.onResult(result, null);
                }
            });
        } catch (Throwable t) {
            callback.onResult(null, t);
        }
    }

    @Override // com.mongodb.internal.connection.WriteProtocol
    protected BsonDocument getAsWriteCommand(ByteBufferBsonOutput bsonOutput, int firstDocumentPosition) {
        return getBaseCommandDocument("insert").append("documents", new BsonArray(ByteBufBsonDocument.createList(bsonOutput, firstDocumentPosition)));
    }

    @Override // com.mongodb.internal.connection.WriteProtocol
    protected RequestMessage createRequestMessage(MessageSettings settings) {
        return new InsertMessage(getNamespace().getFullName(), this.insertRequest, settings);
    }

    @Override // com.mongodb.internal.connection.WriteProtocol
    protected Logger getLogger() {
        return LOGGER;
    }
}
