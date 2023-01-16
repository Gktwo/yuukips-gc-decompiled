package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/BulkWriteOperation.class */
public class BulkWriteOperation {
    private static final String ID_FIELD_NAME = "_id";
    private final boolean ordered;
    private final DBCollection collection;
    private final List<WriteRequest> requests = new ArrayList();
    private Boolean bypassDocumentValidation;
    private boolean closed;

    /* access modifiers changed from: package-private */
    public BulkWriteOperation(boolean ordered, DBCollection collection) {
        this.ordered = ordered;
        this.collection = collection;
    }

    public boolean isOrdered() {
        return this.ordered;
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public void setBypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
    }

    public void insert(DBObject document) {
        Assertions.isTrue("already executed", !this.closed);
        if (document.get("_id") == null) {
            document.put("_id", new ObjectId());
        }
        addRequest(new InsertRequest(document, this.collection.getObjectCodec()));
    }

    public BulkWriteRequestBuilder find(DBObject query) {
        Assertions.isTrue("already executed", !this.closed);
        return new BulkWriteRequestBuilder(this, query, this.collection.getDefaultDBObjectCodec(), this.collection.getObjectCodec());
    }

    public BulkWriteResult execute() {
        Assertions.isTrue("already executed", !this.closed);
        this.closed = true;
        return this.collection.executeBulkWriteOperation(this.ordered, this.bypassDocumentValidation, this.requests);
    }

    public BulkWriteResult execute(WriteConcern writeConcern) {
        Assertions.isTrue("already executed", !this.closed);
        this.closed = true;
        return this.collection.executeBulkWriteOperation(this.ordered, this.bypassDocumentValidation, this.requests, writeConcern);
    }

    /* access modifiers changed from: package-private */
    public void addRequest(WriteRequest request) {
        Assertions.isTrue("already executed", !this.closed);
        this.requests.add(request);
    }
}
