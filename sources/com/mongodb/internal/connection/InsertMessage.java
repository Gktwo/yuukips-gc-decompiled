package com.mongodb.internal.connection;

import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.connection.RequestMessage;
import com.mongodb.internal.validator.CollectibleDocumentFieldNameValidator;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InsertMessage.class */
class InsertMessage extends LegacyMessage {
    private final InsertRequest insertRequest;

    /* access modifiers changed from: package-private */
    public InsertMessage(String collectionName, InsertRequest insertRequest, MessageSettings settings) {
        super(collectionName, OpCode.OP_INSERT, settings);
        this.insertRequest = insertRequest;
    }

    @Override // com.mongodb.internal.connection.LegacyMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput outputStream) {
        writeInsertPrologue(outputStream);
        int firstDocumentPosition = outputStream.getPosition();
        addCollectibleDocument(this.insertRequest.getDocument(), outputStream, new CollectibleDocumentFieldNameValidator());
        return new RequestMessage.EncodingMetadata(firstDocumentPosition);
    }

    private void writeInsertPrologue(BsonOutput outputStream) {
        outputStream.writeInt32(0);
        outputStream.writeCString(getCollectionName());
    }
}
