package com.mongodb;

import org.bson.BsonDocument;
import org.bson.BsonDocumentReader;
import org.bson.codecs.DecoderContext;

/* loaded from: grasscutter.jar:com/mongodb/DBObjects.class */
final class DBObjects {
    public static DBObject toDBObject(BsonDocument document) {
        return (DBObject) MongoClient.getDefaultCodecRegistry().get(DBObject.class).decode(new BsonDocumentReader(document), DecoderContext.builder().build());
    }

    private DBObjects() {
    }
}
