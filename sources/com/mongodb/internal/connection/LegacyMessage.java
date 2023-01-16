package com.mongodb.internal.connection;

import com.mongodb.internal.connection.RequestMessage;
import com.mongodb.internal.session.SessionContext;
import org.bson.p022io.BsonOutput;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/LegacyMessage.class */
abstract class LegacyMessage extends RequestMessage {
    abstract RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput);

    /* access modifiers changed from: package-private */
    public LegacyMessage(String collectionName, OpCode opCode, MessageSettings settings) {
        super(collectionName, opCode, settings);
    }

    /* access modifiers changed from: package-private */
    public LegacyMessage(OpCode opCode, MessageSettings settings) {
        super(opCode, settings);
    }

    @Override // com.mongodb.internal.connection.RequestMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput, SessionContext sessionContext) {
        return encodeMessageBodyWithMetadata(bsonOutput);
    }
}
