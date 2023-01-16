package com.mongodb;

import org.bson.BSONObject;

/* loaded from: grasscutter.jar:com/mongodb/DBObject.class */
public interface DBObject extends BSONObject {
    void markAsPartialObject();

    boolean isPartialObject();
}
