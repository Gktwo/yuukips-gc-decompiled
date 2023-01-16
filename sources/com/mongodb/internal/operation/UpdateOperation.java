package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.bulk.UpdateRequest;
import com.mongodb.internal.bulk.WriteRequest;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/UpdateOperation.class */
public class UpdateOperation extends BaseWriteOperation {
    private final List<UpdateRequest> updates;

    public UpdateOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern, List<UpdateRequest> updates) {
        this(namespace, ordered, writeConcern, false, updates);
    }

    public UpdateOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern, boolean retryWrites, List<UpdateRequest> updates) {
        super(namespace, ordered, writeConcern, retryWrites);
        this.updates = (List) Assertions.notNull("update", updates);
        Assertions.isTrueArgument("updateRequests not empty", !updates.isEmpty());
    }

    public List<UpdateRequest> getUpdateRequests() {
        return this.updates;
    }

    @Override // com.mongodb.internal.operation.BaseWriteOperation
    protected List<? extends WriteRequest> getWriteRequests() {
        return getUpdateRequests();
    }

    @Override // com.mongodb.internal.operation.BaseWriteOperation
    protected WriteRequest.Type getType() {
        return WriteRequest.Type.UPDATE;
    }
}
