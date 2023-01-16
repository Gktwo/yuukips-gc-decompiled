package com.mongodb.internal.operation;

import com.mongodb.annotations.NotThreadSafe;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

@NotThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AggregateResponseBatchCursor.class */
public interface AggregateResponseBatchCursor<T> extends BatchCursor<T> {
    BsonDocument getPostBatchResumeToken();

    BsonTimestamp getOperationTime();

    boolean isFirstBatchEmpty();

    int getMaxWireVersion();
}
