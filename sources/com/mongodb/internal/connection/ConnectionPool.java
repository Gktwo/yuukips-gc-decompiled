package com.mongodb.internal.connection;

import com.mongodb.internal.async.SingleResultCallback;
import java.io.Closeable;
import java.util.concurrent.TimeUnit;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ConnectionPool.class */
public interface ConnectionPool extends Closeable {
    void start();

    InternalConnection get();

    InternalConnection get(long j, TimeUnit timeUnit);

    void getAsync(SingleResultCallback<InternalConnection> singleResultCallback);

    void invalidate();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getGeneration();
}
