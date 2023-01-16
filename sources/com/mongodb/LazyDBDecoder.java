package com.mongodb;

import com.mongodb.lang.Nullable;
import java.io.IOException;
import java.io.InputStream;
import org.bson.LazyBSONDecoder;

/* loaded from: grasscutter.jar:com/mongodb/LazyDBDecoder.class */
public class LazyDBDecoder extends LazyBSONDecoder implements DBDecoder {
    public static final DBDecoderFactory FACTORY = new DBDecoderFactory() { // from class: com.mongodb.LazyDBDecoder.1
        @Override // com.mongodb.DBDecoderFactory
        public DBDecoder create() {
            return new LazyDBDecoder();
        }
    };

    @Override // com.mongodb.DBDecoder
    public DBCallback getDBCallback(@Nullable DBCollection collection) {
        return new LazyDBCallback(collection);
    }

    @Override // org.bson.LazyBSONDecoder, org.bson.BSONDecoder
    public DBObject readObject(InputStream in) throws IOException {
        DBCallback dbCallback = getDBCallback(null);
        decode(in, dbCallback);
        return (DBObject) dbCallback.get();
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
}
