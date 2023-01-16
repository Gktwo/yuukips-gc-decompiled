package com.mongodb.internal.bulk;

import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.internal.bulk.WriteRequest;
import org.bson.BsonDocument;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/internal/bulk/DeleteRequest.class */
public final class DeleteRequest extends WriteRequest {
    private final BsonDocument filter;
    private boolean isMulti = true;
    private Collation collation;
    private Bson hint;
    private String hintString;

    public DeleteRequest(BsonDocument filter) {
        this.filter = (BsonDocument) Assertions.notNull("filter", filter);
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public DeleteRequest multi(boolean isMulti) {
        this.isMulti = isMulti;
        return this;
    }

    public boolean isMulti() {
        return this.isMulti;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public DeleteRequest collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    public Bson getHint() {
        return this.hint;
    }

    public DeleteRequest hint(Bson hint) {
        this.hint = hint;
        return this;
    }

    public String getHintString() {
        return this.hintString;
    }

    public DeleteRequest hintString(String hint) {
        this.hintString = hint;
        return this;
    }

    @Override // com.mongodb.internal.bulk.WriteRequest
    public WriteRequest.Type getType() {
        return WriteRequest.Type.DELETE;
    }
}
