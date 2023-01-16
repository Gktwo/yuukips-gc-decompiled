package com.mongodb;

import com.mongodb.client.MongoCursor;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/MongoCursorAdapter.class */
public class MongoCursorAdapter implements Cursor {
    private final MongoCursor<DBObject> cursor;

    /* access modifiers changed from: package-private */
    public MongoCursorAdapter(MongoCursor<DBObject> cursor) {
        this.cursor = cursor;
    }

    @Override // com.mongodb.Cursor
    public long getCursorId() {
        ServerCursor serverCursor = this.cursor.getServerCursor();
        if (serverCursor == null) {
            return 0;
        }
        return serverCursor.getId();
    }

    @Override // com.mongodb.Cursor
    public ServerAddress getServerAddress() {
        return this.cursor.getServerAddress();
    }

    @Override // com.mongodb.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.cursor.close();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.cursor.hasNext();
    }

    @Override // java.util.Iterator
    public DBObject next() {
        return this.cursor.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.cursor.remove();
    }
}
