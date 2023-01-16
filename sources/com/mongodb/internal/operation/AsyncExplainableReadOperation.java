package com.mongodb.internal.operation;

import com.mongodb.ExplainVerbosity;
import com.mongodb.lang.Nullable;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/AsyncExplainableReadOperation.class */
public interface AsyncExplainableReadOperation<T> extends AsyncReadOperation<T> {
    <R> AsyncReadOperation<R> asAsyncExplainableOperation(@Nullable ExplainVerbosity explainVerbosity, Decoder<R> decoder);
}
