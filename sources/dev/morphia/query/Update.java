package dev.morphia.query;

import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.UpdateResult;
import dev.morphia.Datastore;
import dev.morphia.UpdateOptions;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.query.experimental.updates.UpdateOperator;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/Update.class */
public class Update<T> extends UpdateBase<T> {
    /* access modifiers changed from: package-private */
    public Update(Datastore datastore, Mapper mapper, MongoCollection<T> collection, Query<T> query, Class<T> type, UpdateOpsImpl operations) {
        super(datastore, mapper, collection, query, type, operations.getUpdates());
    }

    /* access modifiers changed from: package-private */
    public Update(Datastore datastore, Mapper mapper, MongoCollection<T> collection, Query<T> query, Class<T> type, UpdateOperator first, UpdateOperator[] updates) {
        super(datastore, mapper, collection, query, type, first, updates);
    }

    public UpdateResult execute() {
        return execute(new UpdateOptions());
    }

    public UpdateResult execute(UpdateOptions options) {
        Document updateOperations = toDocument();
        Document queryObject = getQuery().toDocument();
        if (options.isUpsert()) {
            EntityModel entityModel = getDatastore().getMapper().getEntityModel(getQuery().getEntityClass());
            if (entityModel.useDiscriminator()) {
                queryObject.put(entityModel.getDiscriminatorKey(), (Object) entityModel.getDiscriminator());
            }
        }
        ClientSession session = getDatastore().findSession(options);
        MongoCollection<C> prepare = options.prepare(getCollection());
        return options.isMulti() ? session == null ? prepare.updateMany(queryObject, updateOperations, options) : prepare.updateMany(session, queryObject, updateOperations, options) : session == null ? prepare.updateOne(queryObject, updateOperations, options) : prepare.updateOne(session, queryObject, updateOperations, options);
    }
}
