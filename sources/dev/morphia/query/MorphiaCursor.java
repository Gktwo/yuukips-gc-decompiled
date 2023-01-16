package dev.morphia.query;

import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoCursor;
import com.mongodb.lang.NonNull;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/query/MorphiaCursor.class */
public class MorphiaCursor<T> implements MongoCursor<T> {
    private final MongoCursor<T> wrapped;

    public MorphiaCursor(MongoCursor<T> cursor) {
        this.wrapped = cursor;
    }

    @Override // com.mongodb.client.MongoCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.wrapped.close();
    }

    @Override // com.mongodb.client.MongoCursor, java.util.Iterator
    public boolean hasNext() {
        return this.wrapped.hasNext();
    }

    @Override // com.mongodb.client.MongoCursor, java.util.Iterator
    @NonNull
    public T next() {
        return this.wrapped.next();
    }

    @Override // com.mongodb.client.MongoCursor
    public T tryNext() {
        return this.wrapped.tryNext();
    }

    @Override // com.mongodb.client.MongoCursor
    public ServerCursor getServerCursor() {
        return this.wrapped.getServerCursor();
    }

    @Override // com.mongodb.client.MongoCursor
    @NonNull
    public ServerAddress getServerAddress() {
        return this.wrapped.getServerAddress();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.wrapped.remove();
    }

    public List<T> toList() {
        List<T> results = new ArrayList<>();
        while (this.wrapped.hasNext()) {
            try {
                results.add(next());
            } finally {
                this.wrapped.close();
            }
        }
        return results;
    }
}
