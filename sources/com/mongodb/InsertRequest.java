package com.mongodb;

import com.mongodb.internal.bulk.WriteRequest;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.Encoder;

/* loaded from: grasscutter.jar:com/mongodb/InsertRequest.class */
class InsertRequest extends WriteRequest {
    private final DBObject document;
    private final Encoder<DBObject> codec;

    /* access modifiers changed from: package-private */
    public InsertRequest(DBObject document, Encoder<DBObject> codec) {
        this.document = document;
        this.codec = codec;
    }

    public DBObject getDocument() {
        return this.document;
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.WriteRequest
    public WriteRequest toNew(DBCollection dbCollection) {
        return new com.mongodb.internal.bulk.InsertRequest(new BsonDocumentWrapper(this.document, this.codec));
    }
}
