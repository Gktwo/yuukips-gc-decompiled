package com.mongodb.client.internal;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.client.ClientSession;
import com.mongodb.internal.operation.ReadOperation;
import com.mongodb.internal.operation.WriteOperation;
import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/client/internal/OperationExecutor.class */
public interface OperationExecutor {
    <T> T execute(ReadOperation<T> readOperation, ReadPreference readPreference, ReadConcern readConcern);

    <T> T execute(WriteOperation<T> writeOperation, ReadConcern readConcern);

    <T> T execute(ReadOperation<T> readOperation, ReadPreference readPreference, ReadConcern readConcern, @Nullable ClientSession clientSession);

    <T> T execute(WriteOperation<T> writeOperation, ReadConcern readConcern, @Nullable ClientSession clientSession);
}
