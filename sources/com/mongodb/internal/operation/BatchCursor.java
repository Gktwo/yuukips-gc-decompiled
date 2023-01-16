package com.mongodb.internal.operation;

import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.annotations.NotThreadSafe;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;

@NotThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/BatchCursor.class */
public interface BatchCursor<T> extends Iterator<List<T>>, Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // java.util.Iterator
    boolean hasNext();

    @Override // java.util.Iterator
    List<T> next();

    void setBatchSize(int i);

    int getBatchSize();

    List<T> tryNext();

    ServerCursor getServerCursor();

    ServerAddress getServerAddress();
}
