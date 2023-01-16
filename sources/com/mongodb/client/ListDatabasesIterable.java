package com.mongodb.client;

import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/ListDatabasesIterable.class */
public interface ListDatabasesIterable<TResult> extends MongoIterable<TResult> {
    ListDatabasesIterable<TResult> maxTime(long j, TimeUnit timeUnit);

    @Override // com.mongodb.client.MongoIterable
    ListDatabasesIterable<TResult> batchSize(int i);

    ListDatabasesIterable<TResult> filter(@Nullable Bson bson);

    ListDatabasesIterable<TResult> nameOnly(@Nullable Boolean bool);

    ListDatabasesIterable<TResult> authorizedDatabasesOnly(@Nullable Boolean bool);
}
