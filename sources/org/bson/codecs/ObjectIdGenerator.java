package org.bson.codecs;

import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:org/bson/codecs/ObjectIdGenerator.class */
public class ObjectIdGenerator implements IdGenerator {
    @Override // org.bson.codecs.IdGenerator
    public Object generate() {
        return new ObjectId();
    }
}
