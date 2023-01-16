package com.mongodb;

import com.mongodb.client.model.Collation;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.WriteRequest;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.Encoder;

/* loaded from: grasscutter.jar:com/mongodb/RemoveRequest.class */
class RemoveRequest extends WriteRequest {
    private final DBObject query;
    private final boolean multi;
    private final Encoder<DBObject> codec;
    private final Collation collation;

    /* access modifiers changed from: package-private */
    public RemoveRequest(DBObject query, boolean multi, Encoder<DBObject> codec, Collation collation) {
        this.query = query;
        this.multi = multi;
        this.codec = codec;
        this.collation = collation;
    }

    public DBObject getQuery() {
        return this.query;
    }

    public boolean isMulti() {
        return this.multi;
    }

    /* access modifiers changed from: package-private */
    @Override // com.mongodb.WriteRequest
    public WriteRequest toNew(DBCollection dbCollection) {
        return new DeleteRequest(new BsonDocumentWrapper(this.query, this.codec)).multi(isMulti()).collation(this.collation);
    }
}
