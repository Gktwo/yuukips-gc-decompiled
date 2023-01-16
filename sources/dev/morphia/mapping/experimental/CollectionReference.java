package dev.morphia.mapping.experimental;

import com.mongodb.DBCollection;
import com.mongodb.DBRef;
import com.mongodb.client.MongoCursor;
import dev.morphia.Datastore;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.references.ReferenceCodec;
import dev.morphia.mapping.lazy.proxy.ReferenceException;
import dev.morphia.query.experimental.filters.Filters;
import dev.morphia.sofia.Sofia;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/CollectionReference.class */
public abstract class CollectionReference<C extends Collection> extends MorphiaReference<C> {
    private EntityModel entityModel;
    private List ids;
    private final Map<String, List<Object>> collections = new HashMap();

    abstract void setValues(List list);

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public abstract C get();

    abstract Collection<?> getValues();

    /* access modifiers changed from: package-private */
    public CollectionReference(Datastore datastore, EntityModel entityModel, List ids) {
        super(datastore);
        this.entityModel = entityModel;
        if (ids != null) {
            Stream stream = ids.stream();
            Class<?> type = entityModel.getType();
            Objects.requireNonNull(type);
            if (stream.allMatch(this::isInstance)) {
                setValues(ids);
                return;
            }
            for (Object o : ids) {
                collate(entityModel, this.collections, o);
            }
            this.ids = ids;
        }
    }

    /* access modifiers changed from: protected */
    public CollectionReference() {
    }

    /* access modifiers changed from: package-private */
    public static void collate(EntityModel valueType, Map<String, List<Object>> collections, Object o) {
        Object id;
        String collectionName;
        if (o instanceof DBRef) {
            DBRef dbRef = (DBRef) o;
            collectionName = dbRef.getCollectionName();
            id = dbRef.getId();
        } else {
            collectionName = valueType.getCollectionName();
            id = o;
        }
        register(collections, collectionName).add(id);
    }

    static List register(Map<String, List<Object>> collections, String name) {
        return collections.computeIfAbsent(name, k -> {
            return new ArrayList();
        });
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public Class<C> getType() {
        return (Class<C>) this.entityModel.getType();
    }

    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public List<Object> getIds() {
        List<Object> ids = new ArrayList<>(this.ids);
        if (!ids.isEmpty() && (ids.get(0) instanceof DBRef)) {
            ListIterator iterator = ids.listIterator();
            while (iterator.hasNext()) {
                iterator.set(((DBRef) iterator.next()).getId());
            }
        }
        return ids;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.experimental.MorphiaReference
    public final List<Object> getId(Mapper mapper, Datastore datastore, EntityModel entityModel) {
        if (this.ids == null) {
            this.ids = (List) getValues().stream().map(v -> {
                return ReferenceCodec.encodeId(mapper, v, entityModel);
            }).collect(Collectors.toList());
        }
        return this.ids;
    }

    private List<Object> extractIds(List<Object> list) {
        List<Object> ids = new ArrayList<>();
        list.forEach(i -> {
            if (ids instanceof List) {
                ids.addAll(extractIds((List) ids));
            } else {
                ids.add(ids);
            }
        });
        return ids;
    }

    private List<Object> mapIds(List list, Map<Object, Object> idMap) {
        Object value;
        List<Object> values = new ArrayList<>(Arrays.asList(new Object[list.size()]));
        for (int i = 0; i < list.size(); i++) {
            Object id = list.get(i);
            if (id instanceof List) {
                value = mapIds((List) id, idMap);
            } else {
                value = idMap.get(id instanceof DBRef ? ((DBRef) id).getId() : id);
            }
            if (value != null) {
                values.set(i, value);
            }
        }
        return values;
    }

    final List find() {
        HashMap<Object, Object> idMap = new HashMap<>();
        for (Map.Entry<String, List<Object>> entry : this.collections.entrySet()) {
            idMap.putAll(query(entry.getKey(), extractIds(entry.getValue())));
        }
        List values = (List) mapIds(this.ids, idMap).stream().filter(Objects::nonNull).collect(Collectors.toList());
        resolve();
        return values;
    }

    Map<Object, Object> query(String collection, List<Object> collectionIds) {
        Map<Object, Object> idMap = new HashMap<>();
        MongoCursor<?> cursor = getDatastore().find(collection).disableValidation().filter(Filters.m1221in(DBCollection.ID_FIELD_NAME, collectionIds)).iterator();
        while (cursor.hasNext()) {
            try {
                Object entity = cursor.next();
                idMap.put(getDatastore().getMapper().getId(entity), entity);
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
        if (ignoreMissing() || idMap.size() == collectionIds.size()) {
            if (cursor != null) {
                cursor.close();
            }
            return idMap;
        }
        throw new ReferenceException(Sofia.missingReferencedEntities(this.entityModel.getType().getSimpleName(), new Locale[0]));
    }
}
