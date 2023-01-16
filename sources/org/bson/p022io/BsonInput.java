package org.bson.p022io;

import java.io.Closeable;
import org.bson.types.ObjectId;

/* renamed from: org.bson.io.BsonInput */
/* loaded from: grasscutter.jar:org/bson/io/BsonInput.class */
public interface BsonInput extends Closeable {
    int getPosition();

    byte readByte();

    void readBytes(byte[] bArr);

    void readBytes(byte[] bArr, int i, int i2);

    long readInt64();

    double readDouble();

    int readInt32();

    String readString();

    ObjectId readObjectId();

    String readCString();

    void skipCString();

    void skip(int i);

    BsonInputMark getMark(int i);

    boolean hasRemaining();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
