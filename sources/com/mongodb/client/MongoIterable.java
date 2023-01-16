package com.mongodb.client;

import com.mongodb.Function;
import com.mongodb.lang.Nullable;
import java.util.Collection;

/* loaded from: grasscutter.jar:com/mongodb/client/MongoIterable.class */
public interface MongoIterable<TResult> extends Iterable<TResult> {
    @Override // java.lang.Iterable
    MongoCursor<TResult> iterator();

    MongoCursor<TResult> cursor();

    @Nullable
    TResult first();

    <U> MongoIterable<U> map(Function<TResult, U> function);

    <A extends Collection<? super TResult>> A into(A a);

    MongoIterable<TResult> batchSize(int i);
}
