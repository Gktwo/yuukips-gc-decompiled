package com.mongodb.internal.bulk;

import com.mongodb.assertions.Assertions;
import com.mongodb.internal.bulk.WriteRequest;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/internal/bulk/InsertRequest.class */
public final class InsertRequest extends WriteRequest {
    private final BsonDocument document;

    public InsertRequest(BsonDocument document) {
        this.document = (BsonDocument) Assertions.notNull("document", document);
    }

    public BsonDocument getDocument() {
        return this.document;
    }

    @Override // com.mongodb.internal.bulk.WriteRequest
    public WriteRequest.Type getType() {
        return WriteRequest.Type.INSERT;
    }
}
