package com.mongodb.client;

import com.mongodb.lang.Nullable;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/client/MongoChangeStreamCursor.class */
public interface MongoChangeStreamCursor<TResult> extends MongoCursor<TResult> {
    @Nullable
    BsonDocument getResumeToken();
}
