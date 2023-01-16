package com.mongodb.internal.connection;

import com.mongodb.internal.connection.RequestMessage;
import org.bson.p022io.BsonOutput;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/GetMoreMessage.class */
public class GetMoreMessage extends LegacyMessage {
    private final long cursorId;
    private final int numberToReturn;

    /* access modifiers changed from: package-private */
    public GetMoreMessage(String collectionName, long cursorId, int numberToReturn) {
        super(collectionName, OpCode.OP_GETMORE, MessageSettings.builder().build());
        this.cursorId = cursorId;
        this.numberToReturn = numberToReturn;
    }

    public long getCursorId() {
        return this.cursorId;
    }

    @Override // com.mongodb.internal.connection.LegacyMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput) {
        writeGetMore(bsonOutput);
        return new RequestMessage.EncodingMetadata(bsonOutput.getPosition());
    }

    private void writeGetMore(BsonOutput buffer) {
        buffer.writeInt32(0);
        buffer.writeCString(getCollectionName());
        buffer.writeInt32(this.numberToReturn);
        buffer.writeInt64(this.cursorId);
    }
}
