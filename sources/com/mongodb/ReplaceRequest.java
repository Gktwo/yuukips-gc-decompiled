package com.mongodb;

import com.mongodb.client.model.Collation;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.Encoder;

/* loaded from: grasscutter.jar:com/mongodb/ReplaceRequest.class */
class ReplaceRequest extends WriteRequest {
    private final DBObject query;
    private final DBObject document;
    private final boolean upsert;
    private final Encoder<DBObject> codec;
    private final Encoder<DBObject> replacementCodec;
    private final Collation collation;

    /* access modifiers changed from: package-private */
    public ReplaceRequest(DBObject query, DBObject document, boolean upsert, Encoder<DBObject> codec, Encoder<DBObject> replacementCodec, Collation collation) {
        this.query = query;
        this.document = document;
        this.upsert = upsert;
        this.codec = codec;
        this.replacementCodec = replacementCodec;
        this.collation = collation;
    }

    public DBObject getQuery() {
        return this.query;
    }

    public DBObject getDocument() {
        return this.document;
    }

    public boolean isUpsert() {
        return this.upsert;
    }

    public Collation getCollation() {
        return this.collation;
    }

    @Override // com.mongodb.WriteRequest
    WriteRequest toNew(DBCollection dbCollection) {
        return new UpdateRequest(new BsonDocumentWrapper(this.query, this.codec), new BsonDocumentWrapper(this.document, this.replacementCodec), WriteRequest.Type.REPLACE).upsert(isUpsert()).collation(getCollation());
    }
}
