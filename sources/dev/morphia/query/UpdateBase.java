package dev.morphia.query;

import com.mongodb.client.MongoCollection;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.internal.PathTarget;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.experimental.updates.UpdateOperator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/UpdateBase.class */
public abstract class UpdateBase<T> {
    private final Query<T> query;
    private final MongoCollection<T> collection;
    private final Mapper mapper;
    private final Class<T> type;
    private final List<UpdateOperator> updates;
    private final Datastore datastore;

    /* access modifiers changed from: package-private */
    public UpdateBase(Datastore datastore, Mapper mapper, @Nullable MongoCollection<T> collection, @Nullable Query<T> query, Class<T> type) {
        this.updates = new ArrayList();
        this.datastore = datastore;
        this.mapper = mapper;
        this.collection = collection;
        this.query = query;
        this.type = type;
    }

    /* access modifiers changed from: package-private */
    public UpdateBase(Datastore datastore, Mapper mapper, MongoCollection<T> collection, Query<T> query, Class<T> type, UpdateOperator first, UpdateOperator[] updates) {
        this.updates = new ArrayList();
        this.datastore = datastore;
        this.mapper = mapper;
        this.type = type;
        this.updates.add(first);
        this.updates.addAll(Arrays.asList(updates));
        this.query = query;
        this.collection = collection;
    }

    /* access modifiers changed from: package-private */
    public UpdateBase(Datastore datastore, Mapper mapper, MongoCollection<T> collection, Query<T> query, Class<T> type, List<UpdateOperator> updates) {
        this(datastore, mapper, collection, query, type);
        this.updates.addAll(updates);
    }

    public void add(UpdateOperator operator) {
        this.updates.add(operator);
    }

    public Document toDocument() {
        Operations operations = new Operations(this.mapper, this.mapper.getEntityModel(this.type));
        for (UpdateOperator update : this.updates) {
            operations.add(update.operator(), update.toTarget(new PathTarget(this.mapper, this.mapper.getEntityModel(this.type), update.field(), true)));
        }
        return operations.toDocument();
    }

    public String toString() {
        return toDocument().toString();
    }

    protected MongoCollection<T> getCollection() {
        return this.collection;
    }

    protected Datastore getDatastore() {
        return this.datastore;
    }

    protected Query<T> getQuery() {
        return this.query;
    }

    protected List<UpdateOperator> getUpdates() {
        return this.updates;
    }
}
