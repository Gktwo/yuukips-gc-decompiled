package com.mongodb;

import com.mongodb.client.model.Collation;
import com.mongodb.internal.bulk.WriteRequest;
import java.util.List;
import org.bson.BsonDocumentWrapper;
import org.bson.codecs.Encoder;

/* loaded from: grasscutter.jar:com/mongodb/UpdateRequest.class */
class UpdateRequest extends WriteRequest {
    private final DBObject query;
    private final DBObject update;
    private final boolean multi;
    private final boolean upsert;
    private final Encoder<DBObject> codec;
    private final Collation collation;
    private final List<? extends DBObject> arrayFilters;

    /* access modifiers changed from: package-private */
    public UpdateRequest(DBObject query, DBObject update, boolean multi, boolean upsert, Encoder<DBObject> codec, Collation collation, List<? extends DBObject> arrayFilters) {
        this.query = query;
        this.update = update;
        this.multi = multi;
        this.upsert = upsert;
        this.codec = codec;
        this.collation = collation;
        this.arrayFilters = arrayFilters;
    }

    public DBObject getQuery() {
        return this.query;
    }

    public DBObject getUpdate() {
        return this.update;
    }

    public boolean isUpsert() {
        return this.upsert;
    }

    public boolean isMulti() {
        return this.multi;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public List<? extends DBObject> getArrayFilters() {
        return this.arrayFilters;
    }

    @Override // com.mongodb.WriteRequest
    WriteRequest toNew(DBCollection dbCollection) {
        return new com.mongodb.internal.bulk.UpdateRequest(new BsonDocumentWrapper(this.query, this.codec), new BsonDocumentWrapper(this.update, this.codec), WriteRequest.Type.UPDATE).upsert(isUpsert()).multi(isMulti()).collation(getCollation()).arrayFilters(dbCollection.wrapAllowNull(this.arrayFilters, this.codec));
    }
}
