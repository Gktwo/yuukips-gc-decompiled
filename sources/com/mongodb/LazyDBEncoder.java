package com.mongodb;

import java.io.IOException;
import org.bson.BSONObject;
import org.bson.p022io.OutputBuffer;

/* loaded from: grasscutter.jar:com/mongodb/LazyDBEncoder.class */
public class LazyDBEncoder implements DBEncoder {
    @Override // com.mongodb.DBEncoder
    public int writeObject(OutputBuffer outputBuffer, BSONObject document) {
        if (!(document instanceof LazyDBObject)) {
            throw new IllegalArgumentException("LazyDBEncoder can only encode BSONObject instances of type LazyDBObject");
        }
        try {
            return ((LazyDBObject) document).pipe(outputBuffer);
        } catch (IOException e) {
            throw new MongoException("Exception serializing a LazyDBObject", e);
        }
    }
}
