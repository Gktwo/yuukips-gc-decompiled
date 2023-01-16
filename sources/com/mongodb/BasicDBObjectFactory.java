package com.mongodb;

import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/BasicDBObjectFactory.class */
class BasicDBObjectFactory implements DBObjectFactory {
    @Override // com.mongodb.DBObjectFactory
    public DBObject getInstance() {
        return new BasicDBObject();
    }

    @Override // com.mongodb.DBObjectFactory
    public DBObject getInstance(List<String> path) {
        return new BasicDBObject();
    }
}
