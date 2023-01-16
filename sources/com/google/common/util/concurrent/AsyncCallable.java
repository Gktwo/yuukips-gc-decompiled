package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@FunctionalInterface
@Beta
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/util/concurrent/AsyncCallable.class */
public interface AsyncCallable<V> {
    ListenableFuture<V> call() throws Exception;
}
