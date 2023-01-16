package com.mongodb.internal.bulk;

import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.Collation;
import com.mongodb.internal.bulk.WriteRequest;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/internal/bulk/UpdateRequest.class */
public final class UpdateRequest extends WriteRequest {
    private final BsonValue update;
    private final WriteRequest.Type updateType;
    private final BsonDocument filter;
    private boolean isMulti;
    private boolean isUpsert = false;
    private Collation collation;
    private List<BsonDocument> arrayFilters;
    private Bson hint;
    private String hintString;

    public UpdateRequest(BsonDocument filter, BsonValue update, WriteRequest.Type updateType) {
        this.isMulti = true;
        if (updateType != WriteRequest.Type.UPDATE && updateType != WriteRequest.Type.REPLACE) {
            throw new IllegalArgumentException("Update type must be UPDATE or REPLACE");
        } else if (update == null || update.isDocument() || update.isArray()) {
            this.filter = (BsonDocument) Assertions.notNull("filter", filter);
            this.update = (BsonValue) Assertions.notNull("update", update);
            this.updateType = updateType;
            this.isMulti = updateType == WriteRequest.Type.UPDATE;
        } else {
            throw new IllegalArgumentException("Update operation type must be a document or a pipeline");
        }
    }

    @Override // com.mongodb.internal.bulk.WriteRequest
    public WriteRequest.Type getType() {
        return this.updateType;
    }

    public BsonDocument getFilter() {
        return this.filter;
    }

    public BsonValue getUpdateValue() {
        return this.update;
    }

    public boolean isMulti() {
        return this.isMulti;
    }

    public UpdateRequest multi(boolean isMulti) {
        if (!isMulti || this.updateType != WriteRequest.Type.REPLACE) {
            this.isMulti = isMulti;
            return this;
        }
        throw new IllegalArgumentException("Replacements can not be multi");
    }

    public boolean isUpsert() {
        return this.isUpsert;
    }

    public UpdateRequest upsert(boolean isUpsert) {
        this.isUpsert = isUpsert;
        return this;
    }

    public Collation getCollation() {
        return this.collation;
    }

    public UpdateRequest collation(Collation collation) {
        this.collation = collation;
        return this;
    }

    public UpdateRequest arrayFilters(List<BsonDocument> arrayFilters) {
        this.arrayFilters = arrayFilters;
        return this;
    }

    public List<BsonDocument> getArrayFilters() {
        return this.arrayFilters;
    }

    public Bson getHint() {
        return this.hint;
    }

    public UpdateRequest hint(Bson hint) {
        this.hint = hint;
        return this;
    }

    public String getHintString() {
        return this.hintString;
    }

    public UpdateRequest hintString(String hint) {
        this.hintString = hint;
        return this;
    }
}
