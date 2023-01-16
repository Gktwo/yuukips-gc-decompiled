package dev.morphia.mapping.experimental;

import com.mongodb.DBCollection;
import com.mongodb.DBRef;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.lazy.proxy.ReferenceException;
import dev.morphia.query.Query;
import dev.morphia.query.experimental.filters.Filters;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/SingleReference.class */
public class SingleReference<T> extends MorphiaReference<T> {
    private EntityModel entityModel;

    /* renamed from: id */
    private Object f478id;
    private T value;

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public SingleReference(Datastore datastore, EntityModel entityModel, Object id) {
        super(datastore);
        this.entityModel = entityModel;
        this.f478id = id;
        if (entityModel.getType().isInstance(id)) {
            this.value = id;
            PropertyModel idProperty = entityModel.getIdProperty();
            if (idProperty != null) {
                this.f478id = idProperty.getValue(this.value);
                resolve();
                return;
            }
            throw new MappingException(Sofia.noIdPropertyFound(entityModel.getType().getName(), new Locale[0]));
        }
    }

    /* access modifiers changed from: package-private */
    public SingleReference(T value) {
        this.value = value;
    }

    public static MorphiaReference<?> decode(Datastore datastore, Mapper mapper, PropertyModel mappedField, Class<?> paramType, Document document) {
        return new SingleReference(datastore, mapper.getEntityModel(paramType), document.get(mappedField.getMappedName()));
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public T get() {
        if (!isResolved() && this.value == null && this.f478id != null) {
            this.value = (T) buildQuery().iterator().tryNext();
            if (this.value != null || ignoreMissing()) {
                resolve();
            } else {
                throw new ReferenceException(Sofia.missingReferencedEntity(this.entityModel.getType().getSimpleName(), new Locale[0]));
            }
        }
        return this.value;
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public List<Object> getIds() {
        return List.of(getId());
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public Class<T> getType() {
        return (Class<T>) this.entityModel.getType();
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public Object getId(Mapper mapper, Datastore datastore, EntityModel fieldClass) {
        EntityModel entityModel;
        if (!(this.f478id != null || (entityModel = getEntityModel(mapper)) == null || entityModel.getIdProperty() == null)) {
            this.f478id = entityModel.getIdProperty().getValue(get());
            if (!entityModel.equals(fieldClass)) {
                this.f478id = new DBRef(entityModel.getCollectionName(), this.f478id);
            }
        }
        if (this.f478id != null) {
            return this.f478id;
        }
        throw new ReferenceException(Sofia.noIdForReference(new Locale[0]));
    }

    private Object getId() {
        return this.f478id instanceof DBRef ? ((DBRef) this.f478id).getId() : this.f478id;
    }

    Query<?> buildQuery() {
        Query<?> query;
        if (this.f478id instanceof DBRef) {
            query = getDatastore().find(getDatastore().getMapper().getClassFromCollection(((DBRef) this.f478id).getCollectionName()));
        } else {
            query = getDatastore().find(this.entityModel.getType());
        }
        return query.filter(Filters.m1223eq(DBCollection.ID_FIELD_NAME, getId()));
    }

    @Nullable
    EntityModel getEntityModel(Mapper mapper) {
        T t;
        if (this.entityModel == null && (t = get()) != null) {
            this.entityModel = mapper.getEntityModel(t.getClass());
        }
        return this.entityModel;
    }
}
