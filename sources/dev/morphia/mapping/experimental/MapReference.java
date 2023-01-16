package dev.morphia.mapping.experimental;

import com.mongodb.DBCollection;
import com.mongodb.DBRef;
import com.mongodb.client.MongoCursor;
import dev.morphia.Datastore;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.codec.references.ReferenceCodec;
import dev.morphia.query.experimental.filters.Filters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/MapReference.class */
public class MapReference<T> extends MorphiaReference<Map<Object, T>> {
    private Map<String, Object> ids;
    private Map<Object, T> values;
    private final Map<String, List<Object>> collections = new HashMap();

    public MapReference(Datastore datastore, Map<String, Object> ids, EntityModel entityModel) {
        super(datastore);
        for (Map.Entry<String, Object> entry : ids.entrySet()) {
            CollectionReference.collate(entityModel, this.collections, entry.getValue());
        }
        this.ids = ids;
    }

    private void setValues(Map<String, Object> values) {
        resolve();
    }

    /* access modifiers changed from: package-private */
    public MapReference(Map<Object, T> values) {
        this.values = values;
    }

    public static MapReference decode(Datastore datastore, Mapper mapper, PropertyModel property, Document document) {
        Class subType = property.getTypeData().getTypeParameters().get(0).getType();
        Map<String, Object> ids = (Map) property.getDocumentValue(document);
        MapReference reference = null;
        if (ids != null) {
            reference = new MapReference(datastore, ids, mapper.getEntityModel(subType));
        }
        return reference;
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public Map<Object, T> get() {
        if (this.values == null && this.ids != null) {
            this.values = new LinkedHashMap();
            mergeReads();
        }
        return this.values;
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public Class<Map<Object, T>> getType() {
        throw new UnsupportedOperationException();
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public List<Object> getIds() {
        List<Object> ids = new ArrayList<>(this.ids.values());
        if (!ids.isEmpty() && (ids.get(0) instanceof DBRef)) {
            ListIterator iterator = ids.listIterator();
            while (iterator.hasNext()) {
                iterator.set(((DBRef) iterator.next()).getId());
            }
        }
        return ids;
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public Map<String, Object> getId(Mapper mapper, Datastore datastore, EntityModel field) {
        if (this.ids == null) {
            this.ids = new LinkedHashMap();
            this.values.entrySet().stream().forEach(e -> {
                this.ids.put(field.getKey().toString(), ReferenceCodec.encodeId(mapper, field.getValue(), mapper));
            });
        }
        return this.ids;
    }

    private void mergeReads() {
        for (Map.Entry<String, List<Object>> entry : this.collections.entrySet()) {
            readFromSingleCollection(entry.getKey(), entry.getValue());
        }
        resolve();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v29, resolved type: java.util.Map<java.lang.Object, T> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readFromSingleCollection(String collection, List<Object> collectionIds) {
        MongoCursor<T> cursor = getDatastore().find(collection).filter(Filters.m1221in(DBCollection.ID_FIELD_NAME, collectionIds)).iterator();
        try {
            Map<Object, T> idMap = new HashMap<>();
            while (cursor.hasNext()) {
                T entity = cursor.next();
                idMap.put(getDatastore().getMapper().getId(entity), entity);
            }
            for (Map.Entry<String, Object> entry : this.ids.entrySet()) {
                Object id = entry.getValue();
                T value = idMap.get(id instanceof DBRef ? ((DBRef) id).getId() : id);
                if (value != null) {
                    this.values.put(entry.getKey(), value);
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
