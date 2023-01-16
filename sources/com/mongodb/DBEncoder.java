package com.mongodb;

import org.bson.BSONObject;
import org.bson.p022io.OutputBuffer;

/* loaded from: grasscutter.jar:com/mongodb/DBEncoder.class */
public interface DBEncoder {
    int writeObject(OutputBuffer outputBuffer, BSONObject bSONObject);
}
