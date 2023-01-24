package com.mongodb;

import com.mongodb.annotations.Immutable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
@Immutable
/* loaded from: grasscutter.jar:com/mongodb/DBCollectionObjectFactory.class */
public final class DBCollectionObjectFactory implements DBObjectFactory {
    private final Map<List<String>, Class<? extends DBObject>> pathToClassMap;

    /* access modifiers changed from: package-private */
    public DBCollectionObjectFactory() {
        this(Collections.emptyMap());
    }

    private DBCollectionObjectFactory(Map<List<String>, Class<? extends DBObject>> pathToClassMap) {
        this.pathToClassMap = pathToClassMap;
    }

    @Override // com.mongodb.DBObjectFactory
    public DBObject getInstance() {
        return getInstance(Collections.emptyList());
    }

    @Override // com.mongodb.DBObjectFactory
    public DBObject getInstance(List<String> path) {
        Class<? extends DBObject> aClass = getClassForPath(path);
        try {
            return (DBObject) aClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw createInternalException(aClass, e);
        } catch (InstantiationException e2) {
            throw createInternalException(aClass, e2);
        } catch (NoSuchMethodException e3) {
            throw createInternalException(aClass, e3);
        } catch (InvocationTargetException e4) {
            throw createInternalException(aClass, e4.getTargetException());
        }
    }

    public DBCollectionObjectFactory update(Class<? extends DBObject> aClass) {
        return new DBCollectionObjectFactory(updatePathToClassMap(aClass, Collections.emptyList()));
    }

    public DBCollectionObjectFactory update(Class<? extends DBObject> aClass, List<String> path) {
        return new DBCollectionObjectFactory(updatePathToClassMap(aClass, path));
    }

    private Map<List<String>, Class<? extends DBObject>> updatePathToClassMap(Class<? extends DBObject> aClass, List<String> path) {
        Map<List<String>, Class<? extends DBObject>> map = new HashMap<>(this.pathToClassMap);
        if (aClass != null) {
            map.put(path, aClass);
        } else {
            map.remove(path);
        }
        return map;
    }

    /* access modifiers changed from: package-private */
    public Class<? extends DBObject> getClassForPath(List<String> path) {
        if (this.pathToClassMap.containsKey(path)) {
            return this.pathToClassMap.get(path);
        }
        return BasicDBObject.class;
    }

    private MongoInternalException createInternalException(Class<? extends DBObject> aClass, Throwable e) {
        throw new MongoInternalException("Can't instantiate class " + aClass, e);
    }
}
