package org.bson;

import org.bson.p022io.OutputBuffer;

/* loaded from: grasscutter.jar:org/bson/BSONEncoder.class */
public interface BSONEncoder {
    byte[] encode(BSONObject bSONObject);

    int putObject(BSONObject bSONObject);

    void done();

    void set(OutputBuffer outputBuffer);
}
