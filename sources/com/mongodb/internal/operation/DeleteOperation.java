package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.bulk.DeleteRequest;
import com.mongodb.internal.bulk.WriteRequest;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/DeleteOperation.class */
public class DeleteOperation extends BaseWriteOperation {
    private final List<DeleteRequest> deleteRequests;

    public DeleteOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern, List<DeleteRequest> deleteRequests) {
        this(namespace, ordered, writeConcern, false, deleteRequests);
    }

    public DeleteOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern, boolean retryWrites, List<DeleteRequest> deleteRequests) {
        super(namespace, ordered, writeConcern, retryWrites);
        this.deleteRequests = (List) Assertions.notNull("removes", deleteRequests);
        Assertions.isTrueArgument("deleteRequests not empty", !deleteRequests.isEmpty());
    }

    public List<DeleteRequest> getDeleteRequests() {
        return this.deleteRequests;
    }

    @Override // com.mongodb.internal.operation.BaseWriteOperation
    protected List<? extends WriteRequest> getWriteRequests() {
        return getDeleteRequests();
    }

    @Override // com.mongodb.internal.operation.BaseWriteOperation
    protected WriteRequest.Type getType() {
        return WriteRequest.Type.DELETE;
    }
}
