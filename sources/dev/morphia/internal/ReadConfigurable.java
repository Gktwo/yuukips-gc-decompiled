package dev.morphia.internal;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoCollection;
import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:dev/morphia/internal/ReadConfigurable.class */
public interface ReadConfigurable<T> {
    @Nullable
    ReadConcern getReadConcern();

    @Nullable
    ReadPreference getReadPreference();

    T readConcern(ReadConcern readConcern);

    T readPreference(ReadPreference readPreference);

    @Override // dev.morphia.internal.WriteConfigurable
    default <C> MongoCollection<C> prepare(MongoCollection<C> collection) {
        MongoCollection<C> updated = collection;
        ReadConcern readConcern = getReadConcern();
        if (readConcern != null) {
            updated = updated.withReadConcern(readConcern);
        }
        ReadPreference readPreference = getReadPreference();
        if (readPreference != null) {
            updated = updated.withReadPreference(readPreference);
        }
        return updated;
    }
}
