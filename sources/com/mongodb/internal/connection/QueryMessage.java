package com.mongodb.internal.connection;

import com.mongodb.internal.connection.RequestMessage;
import com.mongodb.internal.validator.NoOpFieldNameValidator;
import org.bson.BsonDocument;
import org.bson.p022io.BsonOutput;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/QueryMessage.class */
public class QueryMessage extends BaseQueryMessage {
    private final BsonDocument queryDocument;
    private final BsonDocument fields;

    /* access modifiers changed from: package-private */
    public QueryMessage(String collectionName, int skip, int numberToReturn, BsonDocument queryDocument, BsonDocument fields, MessageSettings settings) {
        super(collectionName, skip, numberToReturn, settings);
        this.queryDocument = queryDocument;
        this.fields = fields;
    }

    @Override // com.mongodb.internal.connection.LegacyMessage
    protected RequestMessage.EncodingMetadata encodeMessageBodyWithMetadata(BsonOutput bsonOutput) {
        writeQueryPrologue(bsonOutput);
        int firstDocumentStartPosition = bsonOutput.getPosition();
        addDocument(this.queryDocument, bsonOutput, new NoOpFieldNameValidator());
        if (this.fields != null) {
            addDocument(this.fields, bsonOutput, new NoOpFieldNameValidator());
        }
        return new RequestMessage.EncodingMetadata(firstDocumentStartPosition);
    }
}
