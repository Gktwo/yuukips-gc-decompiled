package com.mongodb;

import java.io.Closeable;
import java.util.Iterator;

/* loaded from: grasscutter.jar:com/mongodb/Cursor.class */
public interface Cursor extends Iterator<DBObject>, Closeable {
    long getCursorId();

    ServerAddress getServerAddress();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
