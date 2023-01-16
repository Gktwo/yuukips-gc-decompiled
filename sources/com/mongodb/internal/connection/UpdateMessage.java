package com.mongodb.internal.connection;

import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import com.mongodb.internal.connection.RequestMessage;
import com.mongodb.internal.validator.CollectibleDocumentFieldNameValidator;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import com.mongodb.internal.validator.UpdateFieldNameValidator;
import org.bson.BsonValue;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/UpdateMessage.class */
class UpdateMessage extends LegacyMessage {
    private final UpdateRequest updateRequest;

    /* access modifiers changed from: package-private */
    public UpdateMessage(String collectionName, UpdateRequest updateRequest, MessageSettings settings) {
        super(collectionName, OpCode.OP_UPDATE, settings);
        this.updateRequest = updateRequest;
    }

    @Override // com.mongodb.internal.connection.LegacyMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput) {
        bsonOutput.writeInt32(0);
        bsonOutput.writeCString(getCollectionName());
        int flags = 0;
        if (this.updateRequest.isUpsert()) {
            flags = 0 | 1;
        }
        if (this.updateRequest.isMulti()) {
            flags |= 2;
        }
        bsonOutput.writeInt32(flags);
        int firstDocumentStartPosition = bsonOutput.getPosition();
        addDocument(this.updateRequest.getFilter(), bsonOutput, new NoOpFieldNameValidator());
        if (this.updateRequest.getType() != WriteRequest.Type.REPLACE || !this.updateRequest.getUpdateValue().isDocument()) {
            int bufferPosition = bsonOutput.getPosition();
            BsonValue update = this.updateRequest.getUpdateValue();
            if (update.isDocument()) {
                addDocument(update.asDocument(), bsonOutput, new UpdateFieldNameValidator());
                if (bsonOutput.getPosition() == bufferPosition + 5) {
                    throw new IllegalArgumentException("Invalid BSON document for an update");
                }
            } else {
                throw new IllegalArgumentException("Invalid update filter in update request. The filter must be a document.");
            }
        } else {
            addDocument(this.updateRequest.getUpdateValue().asDocument(), bsonOutput, new CollectibleDocumentFieldNameValidator());
        }
        return new RequestMessage.EncodingMetadata(firstDocumentStartPosition);
    }
}
