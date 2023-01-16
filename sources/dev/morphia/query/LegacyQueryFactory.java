package dev.morphia.query;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/LegacyQueryFactory.class */
public class LegacyQueryFactory implements QueryFactory {
    @Override // dev.morphia.query.QueryFactory
    public <T> Query<T> createQuery(Datastore datastore, String collection, Class<T> type) {
        return new LegacyQuery(datastore, collection, type);
    }

    @Override // dev.morphia.query.QueryFactory
    public <T> Query<T> createQuery(Datastore datastore, Class<T> type, @Nullable Document seed) {
        LegacyQuery<T> query = new LegacyQuery<>(datastore, null, type);
        if (seed != null) {
            query.setQueryObject(seed);
        }
        return query;
    }
}
