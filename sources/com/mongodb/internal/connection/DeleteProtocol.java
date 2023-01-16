package com.mongodb.internal.connection;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcernResult;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.async.SingleResultCallback;
import com.mongodb.internal.bulk.DeleteRequest;
import java.util.Collections;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonInt32;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DeleteProtocol.class */
public class DeleteProtocol extends WriteProtocol {
    private static final Logger LOGGER = Loggers.getLogger("protocol.delete");
    private final DeleteRequest deleteRequest;

    /* access modifiers changed from: package-private */
    public DeleteProtocol(MongoNamespace namespace, boolean ordered, DeleteRequest deleteRequest) {
        super(namespace, ordered);
        this.deleteRequest = deleteRequest;
    }

    @Override // com.mongodb.internal.connection.WriteProtocol, com.mongodb.internal.connection.LegacyProtocol
    public WriteConcernResult execute(InternalConnection connection) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug(String.format("Deleting documents from namespace %s on connection [%s] to server %s", getNamespace(), connection.getDescription().getConnectionId(), connection.getDescription().getServerAddress()));
        }
        WriteConcernResult writeConcernResult = execute(connection);
        LOGGER.debug("Delete completed");
        return writeConcernResult;
    }

    @Override // com.mongodb.internal.connection.WriteProtocol, com.mongodb.internal.connection.LegacyProtocol
    public void executeAsync(InternalConnection connection, final SingleResultCallback<WriteConcernResult> callback) {
        try {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(String.format("Asynchronously deleting documents in namespace %s on connection [%s] to server %s", getNamespace(), connection.getDescription().getConnectionId(), connection.getDescription().getServerAddress()));
            }
            executeAsync(connection, new SingleResultCallback<WriteConcernResult>() { // from class: com.mongodb.internal.connection.DeleteProtocol.1
                public void onResult(WriteConcernResult result, Throwable t) {
                    if (t != null) {
                        callback.onResult(null, t);
                        return;
                    }
                    DeleteProtocol.LOGGER.debug("Asynchronous delete completed");
                    callback.onResult(result, null);
                }
            });
        } catch (Throwable t) {
            callback.onResult(null, t);
        }
    }

    @Override // com.mongodb.internal.connection.WriteProtocol
    protected BsonDocument getAsWriteCommand(ByteBufferBsonOutput bsonOutput, int firstDocumentPosition) {
        return getBaseCommandDocument("delete").append("deletes", new BsonArray(Collections.singletonList(new BsonDocument("q", ByteBufBsonDocument.createOne(bsonOutput, firstDocumentPosition)).append("limit", this.deleteRequest.isMulti() ? new BsonInt32(0) : new BsonInt32(1)))));
    }

    @Override // com.mongodb.internal.connection.WriteProtocol
    protected RequestMessage createRequestMessage(MessageSettings settings) {
        return new DeleteMessage(getNamespace().getFullName(), this.deleteRequest, settings);
    }

    @Override // com.mongodb.internal.connection.WriteProtocol
    protected Logger getLogger() {
        return LOGGER;
    }
}
