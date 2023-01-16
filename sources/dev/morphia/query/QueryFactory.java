package dev.morphia.query;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/QueryFactory.class */
public interface QueryFactory {
    <T> Query<T> createQuery(Datastore datastore, String str, Class<T> cls);

    <T> Query<T> createQuery(Datastore datastore, Class<T> cls, @Nullable Document document);

    default <T> Query<T> createQuery(Datastore datastore, Class<T> type) {
        return createQuery(datastore, type, (Document) null);
    }

    @Deprecated(forRemoval = true)
    default <T> Query<T> createQuery(Datastore datastore) {
        throw new UnsupportedOperationException();
    }
}
