package com.mongodb.client;

import com.mongodb.ExplainVerbosity;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.Document;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/AggregateIterable.class */
public interface AggregateIterable<TResult> extends MongoIterable<TResult> {
    void toCollection();

    AggregateIterable<TResult> allowDiskUse(@Nullable Boolean bool);

    @Override // com.mongodb.client.MongoIterable
    AggregateIterable<TResult> batchSize(int i);

    AggregateIterable<TResult> maxTime(long j, TimeUnit timeUnit);

    AggregateIterable<TResult> maxAwaitTime(long j, TimeUnit timeUnit);

    AggregateIterable<TResult> bypassDocumentValidation(@Nullable Boolean bool);

    AggregateIterable<TResult> collation(@Nullable Collation collation);

    AggregateIterable<TResult> comment(@Nullable String str);

    AggregateIterable<TResult> hint(@Nullable Bson bson);

    Document explain();

    Document explain(ExplainVerbosity explainVerbosity);

    <E> E explain(Class<E> cls);

    <E> E explain(Class<E> cls, ExplainVerbosity explainVerbosity);
}
