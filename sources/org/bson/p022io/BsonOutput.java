package org.bson.p022io;

import java.io.Closeable;
import org.bson.types.ObjectId;

/* renamed from: org.bson.io.BsonOutput */
/* loaded from: grasscutter.jar:org/bson/io/BsonOutput.class */
public interface BsonOutput extends Closeable {
    int getPosition();

    int getSize();

    void truncateToPosition(int i);

    void writeBytes(byte[] bArr);

    void writeBytes(byte[] bArr, int i, int i2);

    void writeByte(int i);

    void writeCString(String str);

    void writeString(String str);

    void writeDouble(double d);

    void writeInt32(int i);

    void writeInt32(int i, int i2);

    void writeInt64(long j);

    void writeObjectId(ObjectId objectId);

    @Override // java.io.Closeable, java.lang.AutoCloseable, org.bson.p022io.BsonOutput
    void close();
}
