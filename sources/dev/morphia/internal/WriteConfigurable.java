package dev.morphia.internal;

import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:dev/morphia/internal/WriteConfigurable.class */
public interface WriteConfigurable<T> {
    T writeConcern(@Nullable WriteConcern writeConcern);

    @Nullable
    WriteConcern writeConcern();

    @Nullable
    @Deprecated(since = "2.0", forRemoval = true)
    default WriteConcern getWriteConcern() {
        return writeConcern();
    }

    default <C> MongoCollection<C> prepare(MongoCollection<C> collection) {
        WriteConcern writeConcern = writeConcern();
        if (writeConcern == null) {
            return collection;
        }
        return collection.withWriteConcern(writeConcern);
    }
}
