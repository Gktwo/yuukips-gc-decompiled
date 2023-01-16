package com.mongodb.client;

import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/ListCollectionsIterable.class */
public interface ListCollectionsIterable<TResult> extends MongoIterable<TResult> {
    ListCollectionsIterable<TResult> filter(@Nullable Bson bson);

    ListCollectionsIterable<TResult> maxTime(long j, TimeUnit timeUnit);

    @Override // com.mongodb.client.MongoIterable
    ListCollectionsIterable<TResult> batchSize(int i);
}
