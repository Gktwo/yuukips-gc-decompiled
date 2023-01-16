package com.mongodb.internal.operation;

import com.mongodb.ExplainVerbosity;
import com.mongodb.lang.Nullable;
import org.bson.codecs.Decoder;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ExplainableReadOperation.class */
public interface ExplainableReadOperation<T> extends ReadOperation<T> {
    <R> ReadOperation<R> asExplainableOperation(@Nullable ExplainVerbosity explainVerbosity, Decoder<R> decoder);
}
