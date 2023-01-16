package com.mchange.p009v2.async;

import com.mchange.p006v1.util.ClosableResource;

/* renamed from: com.mchange.v2.async.AsynchronousRunner */
/* loaded from: grasscutter.jar:com/mchange/v2/async/AsynchronousRunner.class */
public interface AsynchronousRunner extends ClosableResource {
    void postRunnable(Runnable runnable);

    void close(boolean z);

    @Override // com.mchange.p006v1.util.ClosableResource
    void close();
}
