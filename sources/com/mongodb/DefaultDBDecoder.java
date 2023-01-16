package com.mongodb;

import java.io.IOException;
import java.io.InputStream;
import org.bson.BasicBSONDecoder;

/* loaded from: grasscutter.jar:com/mongodb/DefaultDBDecoder.class */
public class DefaultDBDecoder extends BasicBSONDecoder implements DBDecoder {
    public static final DBDecoderFactory FACTORY = new DBDecoderFactory() { // from class: com.mongodb.DefaultDBDecoder.1
        @Override // com.mongodb.DBDecoderFactory
        public DBDecoder create() {
            return new DefaultDBDecoder();
        }
    };

    @Override // com.mongodb.DBDecoder
    public DBCallback getDBCallback(DBCollection collection) {
        return new DefaultDBCallback(collection);
    }

    @Override // com.mongodb.DBDecoder
    public DBObject decode(InputStream input, DBCollection collection) throws IOException {
        DBCallback callback = getDBCallback(collection);
        decode(input, callback);
        return (DBObject) callback.get();
    }

    @Override // com.mongodb.DBDecoder
    public DBObject decode(byte[] bytes, DBCollection collection) {
        DBCallback callback = getDBCallback(collection);
        decode(bytes, callback);
        return (DBObject) callback.get();
    }

    public String toString() {
        return String.format("DBDecoder{class=%s}", getClass().getName());
    }
}
