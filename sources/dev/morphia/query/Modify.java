package dev.morphia.query;

import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.ModifyOptions;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.experimental.updates.UpdateOperator;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/Modify.class */
public class Modify<T> extends UpdateBase<T> {
    /* access modifiers changed from: package-private */
    public Modify(Datastore datastore, Mapper mapper, MongoCollection<T> collection, Query<T> query, Class<T> type, UpdateOpsImpl operations) {
        super(datastore, mapper, collection, query, type, operations.getUpdates());
    }

    /* access modifiers changed from: package-private */
    public Modify(Datastore datastore, Mapper mapper, MongoCollection<T> collection, Query<T> query, Class<T> type, UpdateOperator first, UpdateOperator[] updates) {
        super(datastore, mapper, collection, query, type, first, updates);
    }

    @Nullable
    public T execute() {
        return execute(new ModifyOptions());
    }

    @Nullable
    public T execute(ModifyOptions options) {
        ClientSession session = getDatastore().findSession(options);
        Document update = toDocument();
        if (session == null) {
            return (T) options.prepare(getCollection()).findOneAndUpdate(getQuery().toDocument(), update, options);
        }
        return (T) options.prepare(getCollection()).findOneAndUpdate(session, getQuery().toDocument(), update, options);
    }
}
