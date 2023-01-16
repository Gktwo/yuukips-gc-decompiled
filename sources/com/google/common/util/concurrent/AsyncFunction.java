package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@FunctionalInterface
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AsyncFunction.class */
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(I i) throws Exception;
}
