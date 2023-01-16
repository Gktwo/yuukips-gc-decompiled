package com.mongodb.client;

import com.mongodb.client.model.Collation;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.FullDocument;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.BsonDocument;
import org.bson.BsonTimestamp;

/* loaded from: grasscutter.jar:com/mongodb/client/ChangeStreamIterable.class */
public interface ChangeStreamIterable<TResult> extends MongoIterable<ChangeStreamDocument<TResult>> {
    @Override // com.mongodb.client.MongoIterable
    MongoChangeStreamCursor<ChangeStreamDocument<TResult>> cursor();

    ChangeStreamIterable<TResult> fullDocument(FullDocument fullDocument);

    ChangeStreamIterable<TResult> resumeAfter(BsonDocument bsonDocument);

    @Override // com.mongodb.client.MongoIterable
    ChangeStreamIterable<TResult> batchSize(int i);

    ChangeStreamIterable<TResult> maxAwaitTime(long j, TimeUnit timeUnit);

    ChangeStreamIterable<TResult> collation(@Nullable Collation collation);

    <TDocument> MongoIterable<TDocument> withDocumentClass(Class<TDocument> cls);

    ChangeStreamIterable<TResult> startAtOperationTime(BsonTimestamp bsonTimestamp);

    ChangeStreamIterable<TResult> startAfter(BsonDocument bsonDocument);
}
