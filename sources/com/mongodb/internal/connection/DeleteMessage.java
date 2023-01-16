package com.mongodb.internal.connection;

import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.connection.RequestMessage;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/DeleteMessage.class */
class DeleteMessage extends LegacyMessage {
    private final DeleteRequest deleteRequest;

    /* access modifiers changed from: package-private */
    public DeleteMessage(String collectionName, DeleteRequest deleteRequest, MessageSettings settings) {
        super(collectionName, OpCode.OP_DELETE, settings);
        this.deleteRequest = deleteRequest;
    }

    @Override // com.mongodb.internal.connection.LegacyMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput) {
        bsonOutput.writeInt32(0);
        bsonOutput.writeCString(getCollectionName());
        if (this.deleteRequest.isMulti()) {
            bsonOutput.writeInt32(0);
        } else {
            bsonOutput.writeInt32(1);
        }
        int firstDocumentStartPosition = bsonOutput.getPosition();
        addDocument(this.deleteRequest.getFilter(), bsonOutput, new NoOpFieldNameValidator());
        return new RequestMessage.EncodingMetadata(firstDocumentStartPosition);
    }
}
