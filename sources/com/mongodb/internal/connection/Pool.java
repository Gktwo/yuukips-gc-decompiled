package com.mongodb.internal.connection;

import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/Pool.class */
interface Pool<T> {
    T get();

    T get(long j, TimeUnit timeUnit);

    void release(T t);

    void close();

    void release(T t, boolean z);
}
