package com.mongodb;

import org.bson.LazyBSONCallback;
import org.bson.LazyBSONList;

/* loaded from: grasscutter.jar:com/mongodb/LazyDBList.class */
public class LazyDBList extends LazyBSONList implements DBObject {
    private boolean isPartial;

    public LazyDBList(byte[] bytes, LazyBSONCallback callback) {
        super(bytes, callback);
    }

    public LazyDBList(byte[] bytes, int offset, LazyBSONCallback callback) {
        super(bytes, offset, callback);
    }

    @Override // com.mongodb.DBObject
    public void markAsPartialObject() {
        this.isPartial = true;
    }

    @Override // com.mongodb.DBObject
    public boolean isPartialObject() {
        return this.isPartial;
    }
}
