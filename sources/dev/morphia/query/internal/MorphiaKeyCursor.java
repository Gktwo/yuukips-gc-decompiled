package dev.morphia.query.internal;

import com.mongodb.DBCollection;
import com.mongodb.ServerAddress;
import com.mongodb.ServerCursor;
import com.mongodb.client.MongoCursor;
import com.mongodb.lang.NonNull;
import dev.morphia.Key;
import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/internal/MorphiaKeyCursor.class */
public class MorphiaKeyCursor<T> implements MongoCursor<Key<T>> {
    private final MongoCursor<Document> wrapped;
    private final Mapper mapper;
    private final Class<T> clazz;
    private final String collection;

    public MorphiaKeyCursor(MongoCursor<Document> cursor, Mapper mapper, Class<T> clazz, String collection) {
        this.wrapped = cursor;
        if (this.wrapped == null) {
            throw new IllegalArgumentException("The wrapped cursor can not be null");
        }
        this.mapper = mapper;
        this.clazz = clazz;
        this.collection = collection;
    }

    @Override // com.mongodb.client.MongoCursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.wrapped != null) {
            this.wrapped.close();
        }
    }

    @Override // com.mongodb.client.MongoCursor, java.util.Iterator
    public boolean hasNext() {
        if (this.wrapped == null) {
            return false;
        }
        return this.wrapped.hasNext();
    }

    @Override // com.mongodb.client.MongoCursor, java.util.Iterator
    @NonNull
    public Key<T> next() {
        if (hasNext()) {
            return convertItem(this.wrapped.next());
        }
        throw new NoSuchElementException();
    }

    @Override // com.mongodb.client.MongoCursor
    public Key<T> tryNext() {
        if (hasNext()) {
            return next();
        }
        return null;
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

    private Key<T> convertItem(Document document) {
        Object id = document.get(DBCollection.ID_FIELD_NAME);
        if (id instanceof Document) {
            id = this.mapper.fromDocument(this.clazz, (Document) id);
        }
        return new Key<>(this.clazz, this.collection, id);
    }

    public List<Key<T>> toList() {
        List<Key<T>> results = new ArrayList<>();
        while (this.wrapped.hasNext()) {
            try {
                results.add(next());
            } finally {
                this.wrapped.close();
            }
        }
        return results;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.wrapped.remove();
    }
}
