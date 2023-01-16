package com.google.common.util.concurrent.internal;

/* loaded from: grasscutter.jar:com/google/common/util/concurrent/internal/InternalFutures.class */
public final class InternalFutures {
    public static Throwable tryInternalFastPathGetFailure(InternalFutureFailureAccess future) {
        return future.tryInternalFastPathGetFailure();
    }

    private InternalFutures() {
    }
}
