package com.mongodb.internal.async;

import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/internal/async/AsyncAggregateResponseBatchCursor.class */
public interface AsyncAggregateResponseBatchCursor<T> extends AsyncBatchCursor<T> {
    BsonDocument getPostBatchResumeToken();

    BsonTimestamp getOperationTime();

    boolean isFirstBatchEmpty();

    int getMaxWireVersion();
}
