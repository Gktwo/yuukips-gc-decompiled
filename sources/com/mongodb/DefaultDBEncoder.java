package com.mongodb;

import org.bson.BSONObject;
import org.bson.BasicBSONEncoder;
import org.bson.p022io.OutputBuffer;

/* loaded from: grasscutter.jar:com/mongodb/DefaultDBEncoder.class */
public class DefaultDBEncoder extends BasicBSONEncoder implements DBEncoder {
    public static final DBEncoderFactory FACTORY = new DBEncoderFactory() { // from class: com.mongodb.DefaultDBEncoder.1
        @Override // com.mongodb.DBEncoderFactory
        public DBEncoder create() {
            return new DefaultDBEncoder();
        }
    };

    @Override // com.mongodb.DBEncoder
    public int writeObject(OutputBuffer outputBuffer, BSONObject document) {
        set(outputBuffer);
        int x = putObject(document);
        done();
        return x;
    }

    @Override // org.bson.BasicBSONEncoder
    protected boolean putSpecial(String name, Object value) {
        if (!(value instanceof DBRef)) {
            return false;
        }
        putDBRef(name, (DBRef) value);
        return true;
    }

    protected void putDBRef(String name, DBRef ref) {
        BasicDBObject dbRefDocument = new BasicDBObject("$ref", ref.getCollectionName()).append("$id", ref.getId());
        if (ref.getDatabaseName() != null) {
            dbRefDocument.put((Object) "$db", (Object) ref.getDatabaseName());
        }
        putObject(name, dbRefDocument);
    }

    public String toString() {
        return String.format("DBEncoder{class=%s}", getClass().getName());
    }
}
