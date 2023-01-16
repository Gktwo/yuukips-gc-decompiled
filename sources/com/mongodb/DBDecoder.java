package com.mongodb;

import java.io.IOException;
import java.io.InputStream;
import org.bson.BSONDecoder;

/* loaded from: grasscutter.jar:com/mongodb/DBDecoder.class */
public interface DBDecoder extends BSONDecoder {
    DBCallback getDBCallback(DBCollection dBCollection);

    DBObject decode(InputStream inputStream, DBCollection dBCollection) throws IOException;

    DBObject decode(byte[] bArr, DBCollection dBCollection);
}
