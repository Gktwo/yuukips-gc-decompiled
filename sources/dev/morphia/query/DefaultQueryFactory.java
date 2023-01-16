package dev.morphia.query;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/DefaultQueryFactory.class */
public class DefaultQueryFactory implements QueryFactory {
    @Override // dev.morphia.query.QueryFactory
    public <T> Query<T> createQuery(Datastore datastore, String collection, Class<T> type) {
        return new MorphiaQuery(datastore, collection, type);
    }

    @Override // dev.morphia.query.QueryFactory
    public <T> Query<T> createQuery(Datastore datastore, Class<T> type, @Nullable Document query) {
        if (query != null) {
            return new MorphiaQuery(datastore, type, query);
        }
        return new MorphiaQuery(datastore, (String) null, type);
    }
}
