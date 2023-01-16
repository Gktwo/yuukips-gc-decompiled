package com.mongodb;

import com.mongodb.lang.Nullable;
import java.util.Iterator;
import java.util.List;
import org.bson.LazyBSONCallback;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/LazyDBCallback.class */
public class LazyDBCallback extends LazyBSONCallback implements DBCallback {
    public LazyDBCallback(@Nullable DBCollection collection) {
    }

    @Override // org.bson.LazyBSONCallback
    public Object createObject(byte[] bytes, int offset) {
        LazyDBObject document = new LazyDBObject(bytes, offset, this);
        Iterator<String> iterator = document.keySet().iterator();
        if (!iterator.hasNext() || !iterator.next().equals("$ref") || !iterator.hasNext() || !iterator.next().equals("$id")) {
            return document;
        }
        return new DBRef((String) document.get("$db"), (String) document.get("$ref"), document.get("$id"));
    }

    @Override // org.bson.LazyBSONCallback
    public List createArray(byte[] bytes, int offset) {
        return new LazyDBList(bytes, offset, this);
    }

    @Override // org.bson.LazyBSONCallback
    public Object createDBRef(String ns, ObjectId id) {
        return new DBRef(ns, id);
    }
}
