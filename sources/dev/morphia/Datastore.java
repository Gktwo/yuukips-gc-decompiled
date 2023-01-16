package dev.morphia;

import com.mongodb.ClientSessionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.AggregationPipeline;
import dev.morphia.aggregation.experimental.Aggregation;
import dev.morphia.experimental.MorphiaSession;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.FindAndDeleteOptions;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateOpsImpl;
import dev.morphia.transactions.experimental.MorphiaTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/Datastore.class */
public interface Datastore {
    Aggregation<Document> aggregate(String str);

    <T> Aggregation<T> aggregate(Class<T> cls);

    @Deprecated(since = "2.0", forRemoval = true)
    AggregationPipeline createAggregation(Class<?> cls);

    <T> DeleteResult delete(T t);

    <T> DeleteResult delete(T t, DeleteOptions deleteOptions);

    void enableDocumentValidation();

    void ensureCaps();

    void ensureIndexes();

    <T> void ensureIndexes(Class<T> cls);

    <T> Query<T> find(Class<T> cls);

    <T> Query<T> find(String str, Class<T> cls);

    <T> Query<T> find(String str);

    @Nullable
    ClientSession findSession(SessionConfigurable<?> sessionConfigurable);

    MongoDatabase getDatabase();

    @Nullable
    String getLoggedQuery(FindOptions findOptions);

    Mapper getMapper();

    <T> void insert(T t);

    <T> void insert(T t, InsertOneOptions insertOneOptions);

    <T> void insert(List<T> list, InsertManyOptions insertManyOptions);

    <T> T merge(T t);

    <T> T merge(T t, InsertOneOptions insertOneOptions);

    <T> Query<T> queryByExample(T t);

    <T> void refresh(T t);

    <T> List<T> save(List<T> list, InsertManyOptions insertManyOptions);

    <T> T save(T t, InsertOneOptions insertOneOptions);

    MorphiaSession startSession();

    MorphiaSession startSession(ClientSessionOptions clientSessionOptions);

    <T> T withTransaction(MorphiaTransaction<T> morphiaTransaction);

    <T> T withTransaction(ClientSessionOptions clientSessionOptions, MorphiaTransaction<T> morphiaTransaction);

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> Query<T> createQuery(Class<T> type) {
        return find(type);
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> UpdateOperations<T> createUpdateOperations(Class<T> clazz) {
        return new UpdateOpsImpl(this, clazz, getMapper());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> DeleteResult delete(Query<T> query) {
        return query.delete(new DeleteOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> DeleteResult delete(Query<T> query, DeleteOptions options) {
        return query.delete(options);
    }

    @Nullable
    @Deprecated(since = "2.0", forRemoval = true)
    default <T> T findAndDelete(Query<T> query) {
        return query.findAndDelete();
    }

    @Nullable
    @Deprecated(since = "2.0", forRemoval = true)
    default <T> T findAndDelete(Query<T> query, FindAndModifyOptions options) {
        return query.findAndDelete(new FindAndDeleteOptions().writeConcern(options.getWriteConcern()).collation(options.getCollation()).maxTime(options.getMaxTime(TimeUnit.MILLISECONDS), TimeUnit.MILLISECONDS).sort(options.getSort()).projection(options.getProjection()));
    }

    @Nullable
    @Deprecated(since = "2.0", forRemoval = true)
    default <T> T findAndModify(Query<T> query, UpdateOperations<T> operations, FindAndModifyOptions options) {
        return query.modify(operations).execute(options);
    }

    @Nullable
    @Deprecated(since = "2.0", forRemoval = true)
    default <T> T findAndModify(Query<T> query, UpdateOperations<T> operations) {
        return query.modify(operations).execute(new ModifyOptions().returnDocument(ReturnDocument.AFTER));
    }

    @Nullable
    default ClientSession getSession() {
        return null;
    }

    default <T> void insert(List<T> entities) {
        insert(entities, new InsertManyOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> void merge(T entity, WriteConcern wc) {
        merge((Datastore) entity, new InsertOneOptions().writeConcern(wc));
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> List<T> save(Iterable<T> entities) {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(arrayList);
        entities.forEach(this::add);
        return save((List) arrayList);
    }

    default <T> List<T> save(List<T> entities) {
        return save(entities, new InsertManyOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> List<T> save(Iterable<T> entities, InsertOptions options) {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(arrayList);
        entities.forEach(this::add);
        return save(arrayList, options.toInsertManyOptions());
    }

    default <T> T save(T entity) {
        return (T) save((Datastore) entity, new InsertOneOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> T save(T entity, InsertOptions options) {
        return (T) save((Datastore) entity, options.toInsertOneOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> UpdateResult update(Query<T> query, UpdateOperations<T> operations, UpdateOptions options) {
        return query.update(operations).execute(options);
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> UpdateResult update(Query<T> query, UpdateOperations<T> operations) {
        return query.update(operations).execute(new UpdateOptions().upsert(false).multi(true).writeConcern(getMapper().getWriteConcern(query.getEntityClass())));
    }
}
