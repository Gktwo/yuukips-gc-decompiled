package dev.morphia.experimental;

import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import dev.morphia.DeleteOptions;
import dev.morphia.InsertManyOptions;
import dev.morphia.InsertOneOptions;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.QueryFactory;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/experimental/MorphiaSessionImpl.class */
public class MorphiaSessionImpl extends BaseMorphiaSession {
    public MorphiaSessionImpl(ClientSession session, MongoClient mongoClient, MongoDatabase database, Mapper mapper, QueryFactory queryFactory) {
        super(session, mongoClient, database, mapper, queryFactory);
    }

    @Override // dev.morphia.DatastoreImpl, dev.morphia.Datastore
    public <T> void insert(T entity, InsertOneOptions options) {
        insert((MorphiaSessionImpl) entity, new InsertOneOptions(options).clientSession(findSession(options)));
    }

    @Override // dev.morphia.DatastoreImpl, dev.morphia.Datastore
    public <T> void insert(List<T> entities, InsertManyOptions options) {
        insert(entities, new InsertManyOptions(options).clientSession(findSession(options)));
    }

    @Override // dev.morphia.DatastoreImpl, dev.morphia.Datastore
    public <T> DeleteResult delete(T entity, DeleteOptions options) {
        return delete((MorphiaSessionImpl) entity, new DeleteOptions(options).clientSession(findSession(options)));
    }

    @Override // dev.morphia.DatastoreImpl, dev.morphia.Datastore
    public <T> T merge(T entity, InsertOneOptions options) {
        return (T) merge((MorphiaSessionImpl) entity, new InsertOneOptions(options).clientSession(findSession(options)));
    }

    @Override // dev.morphia.DatastoreImpl, dev.morphia.Datastore
    public <T> List<T> save(List<T> entities, InsertManyOptions options) {
        return save(entities, new InsertManyOptions(options).clientSession(findSession(options)));
    }

    @Override // dev.morphia.DatastoreImpl, dev.morphia.Datastore
    public <T> T save(T entity, InsertOneOptions options) {
        return (T) save((MorphiaSessionImpl) entity, new InsertOneOptions(options).clientSession(findSession(options)));
    }
}
