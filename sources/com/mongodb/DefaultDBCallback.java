package com.mongodb;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bson.BSONObject;
import org.bson.BasicBSONCallback;
import org.bson.types.BasicBSONList;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/DefaultDBCallback.class */
public class DefaultDBCallback extends BasicBSONCallback implements DBCallback {
    private final DBObjectFactory objectFactory;
    public static final DBCallbackFactory FACTORY = new DBCallbackFactory() { // from class: com.mongodb.DefaultDBCallback.1
        @Override // com.mongodb.DBCallbackFactory
        public DBCallback create(DBCollection collection) {
            return new DefaultDBCallback(collection);
        }
    };

    public DefaultDBCallback(DBCollection collection) {
        if (collection != null) {
            this.objectFactory = collection.getObjectFactory();
        } else {
            this.objectFactory = new DBCollectionObjectFactory();
        }
    }

    @Override // org.bson.BasicBSONCallback
    public BSONObject create() {
        return this.objectFactory.getInstance();
    }

    @Override // org.bson.BasicBSONCallback
    public BSONObject create(boolean array, List<String> path) {
        if (array) {
            return new BasicDBList();
        }
        return this.objectFactory.getInstance(path != null ? path : Collections.emptyList());
    }

    @Override // org.bson.BasicBSONCallback, org.bson.BSONCallback
    public void gotDBRef(String name, String namespace, ObjectId id) {
        _put(name, new DBRef(namespace, id));
    }

    @Override // org.bson.BasicBSONCallback, org.bson.BSONCallback
    public Object objectDone() {
        String name = curName();
        BSONObject document = (BSONObject) objectDone();
        if (!(document instanceof BasicBSONList)) {
            Iterator<String> iterator = document.keySet().iterator();
            if (iterator.hasNext() && iterator.next().equals("$ref") && iterator.hasNext() && iterator.next().equals("$id")) {
                _put(name, new DBRef((String) document.get("$db"), (String) document.get("$ref"), document.get("$id")));
            }
        }
        return document;
    }
}
