package com.mongodb.internal.operation;

import com.mongodb.MongoNamespace;
import com.mongodb.WriteConcern;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.bulk.InsertRequest;
import com.mongodb.internal.bulk.WriteRequest;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/InsertOperation.class */
public class InsertOperation extends BaseWriteOperation {
    private final List<InsertRequest> insertRequests;

    public InsertOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern, List<InsertRequest> insertRequests) {
        this(namespace, ordered, writeConcern, false, insertRequests);
    }

    public InsertOperation(MongoNamespace namespace, boolean ordered, WriteConcern writeConcern, boolean retryWrites, List<InsertRequest> insertRequests) {
        super(namespace, ordered, writeConcern, retryWrites);
        this.insertRequests = (List) Assertions.notNull("insertRequests", insertRequests);
        Assertions.isTrueArgument("insertRequests not empty", !insertRequests.isEmpty());
    }

    public List<InsertRequest> getInsertRequests() {
        return this.insertRequests;
    }

    @Override // com.mongodb.internal.operation.BaseWriteOperation
    protected WriteRequest.Type getType() {
        return WriteRequest.Type.INSERT;
    }

    @Override // com.mongodb.internal.operation.BaseWriteOperation
    protected List<? extends WriteRequest> getWriteRequests() {
        return getInsertRequests();
    }
}
